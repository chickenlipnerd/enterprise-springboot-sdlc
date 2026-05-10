package com.chickenlipnerd.enterprise.catalogservice.repository;

import com.chickenlipnerd.enterprise.catalogservice.model.CatalogItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, UUID> {

    List<CatalogItem> findTop10ByOrderByDisplayNameAsc();

    Optional<CatalogItem> findBySku(String sku);
}
