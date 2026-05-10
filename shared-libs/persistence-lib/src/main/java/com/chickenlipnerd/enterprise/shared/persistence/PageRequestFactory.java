package com.chickenlipnerd.enterprise.shared.persistence;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class PageRequestFactory {

    private PageRequestFactory() {
    }

    public static Pageable firstPage(int size, String sortProperty) {
        return PageRequest.of(0, size, Sort.by(sortProperty).ascending());
    }
}
