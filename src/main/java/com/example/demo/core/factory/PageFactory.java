package com.example.demo.core.factory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.entity.SimplePage;

public class PageFactory {
    public static <U> Page<U> of(SimplePage<U> simplePage, Pageable pageable) {
        return new PageImpl<>(
                simplePage.getContent(),
                pageable,
                simplePage.getTotalElements()
        );
    }
}
