package com.example.demo.core.factory;

import org.springframework.data.domain.Page;

import com.example.demo.domain.entity.SimplePage;

public class SimplePageFactory {
    public static <U> SimplePage<U> of(Page<U> page) {
        return new SimplePage<>(
                page.getContent(),
                page.getTotalElements()
        );
    }
}
