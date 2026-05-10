package com.chickenlipnerd.enterprise.catalogservice.service;

import com.chickenlipnerd.enterprise.catalogservice.model.CatalogItem;
import com.chickenlipnerd.enterprise.catalogservice.model.CatalogItemSummary;
import com.chickenlipnerd.enterprise.catalogservice.repository.CatalogItemRepository;
import com.chickenlipnerd.enterprise.shared.logging.StructuredLogger;
import com.chickenlipnerd.enterprise.shared.validation.ValidationSupport;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CatalogApplicationService {

    private static final List<CatalogItemSummary> FALLBACK_ITEMS = List.of(
        new CatalogItemSummary("SKU-001", "Starter Bundle", new BigDecimal("19.99"), true),
        new CatalogItemSummary("SKU-002", "Premium Bundle", new BigDecimal("49.99"), true)
    );

    private static final StructuredLogger LOGGER = StructuredLogger.forClass(CatalogApplicationService.class);

    private final CatalogItemRepository catalogItemRepository;

    public CatalogApplicationService(CatalogItemRepository catalogItemRepository) {
        this.catalogItemRepository = catalogItemRepository;
    }

    public List<CatalogItemSummary> listItems() {
        try {
            List<CatalogItemSummary> items = catalogItemRepository.findTop10ByOrderByDisplayNameAsc().stream()
                .map(this::toSummary)
                .toList();
            return items.isEmpty() ? FALLBACK_ITEMS : items;
        } catch (RuntimeException exception) {
            LOGGER.warn("Falling back to sample catalog items", Map.of("service", "catalog-service"), exception);
            return FALLBACK_ITEMS;
        }
    }

    public CatalogItemSummary getItem(String sku) {
        String validatedSku = ValidationSupport.requireNotBlank(sku, "sku");
        return listItems().stream()
            .filter(item -> item.sku().equalsIgnoreCase(validatedSku))
            .findFirst()
            .orElse(new CatalogItemSummary(validatedSku, "Item not found", BigDecimal.ZERO, false));
    }

    private CatalogItemSummary toSummary(CatalogItem item) {
        return new CatalogItemSummary(item.getSku(), item.getDisplayName(), item.getPrice(), item.isActive());
    }
}
