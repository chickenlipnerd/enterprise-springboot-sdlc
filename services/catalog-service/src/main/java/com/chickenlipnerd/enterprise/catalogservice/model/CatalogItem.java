package com.chickenlipnerd.enterprise.catalogservice.model;

import com.chickenlipnerd.enterprise.shared.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "catalog_item")
public class CatalogItem extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String displayName;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean active;

    protected CatalogItem() {
    }

    public CatalogItem(String sku, String displayName, BigDecimal price, boolean active) {
        this.sku = sku;
        this.displayName = displayName;
        this.price = price;
        this.active = active;
    }

    public String getSku() {
        return sku;
    }

    public String getDisplayName() {
        return displayName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }
}
