package com.chickenlipnerd.enterprise.catalogservice.model;

import java.math.BigDecimal;

public record CatalogItemSummary(String sku, String displayName, BigDecimal price, boolean active) {
}
