package com.chickenlipnerd.enterprise.catalogservice.controller;

import com.chickenlipnerd.enterprise.catalogservice.model.CatalogItemSummary;
import com.chickenlipnerd.enterprise.catalogservice.service.CatalogApplicationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalog/items")
public class CatalogController {

    private final CatalogApplicationService catalogApplicationService;

    public CatalogController(CatalogApplicationService catalogApplicationService) {
        this.catalogApplicationService = catalogApplicationService;
    }

    @GetMapping
    public List<CatalogItemSummary> listItems() {
        return catalogApplicationService.listItems();
    }

    @GetMapping("/{sku}")
    public CatalogItemSummary getItem(@PathVariable String sku) {
        return catalogApplicationService.getItem(sku);
    }
}
