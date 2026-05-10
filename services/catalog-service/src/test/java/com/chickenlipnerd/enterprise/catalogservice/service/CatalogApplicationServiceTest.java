package com.chickenlipnerd.enterprise.catalogservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.chickenlipnerd.enterprise.catalogservice.model.CatalogItem;
import com.chickenlipnerd.enterprise.catalogservice.repository.CatalogItemRepository;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class CatalogApplicationServiceTest {

    @Test
    void mapsRepositoryItemsWhenAvailable() {
        CatalogItemRepository repository = mock(CatalogItemRepository.class);
        when(repository.findTop10ByOrderByDisplayNameAsc())
            .thenReturn(List.of(new CatalogItem("SKU-001", "Starter Bundle", new BigDecimal("19.99"), true)));

        CatalogApplicationService service = new CatalogApplicationService(repository);

        assertThat(service.listItems())
            .extracting(item -> item.sku())
            .containsExactly("SKU-001");
    }

    @Test
    void fallsBackToSampleItemsWhenRepositoryFails() {
        CatalogItemRepository repository = mock(CatalogItemRepository.class);
        when(repository.findTop10ByOrderByDisplayNameAsc()).thenThrow(new IllegalStateException("database unavailable"));

        CatalogApplicationService service = new CatalogApplicationService(repository);

        assertThat(service.listItems()).hasSize(2);
    }
}
