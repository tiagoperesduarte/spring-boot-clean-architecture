package com.example.demo.core.factory;

import org.springframework.data.domain.PageRequest;

import com.example.demo.domain.entity.SimplePageRequest;

public class PageRequestFactory {
    public static PageRequest of(SimplePageRequest simplePageRequest) {
        return PageRequest.of(
                simplePageRequest.getPage(),
                simplePageRequest.getSize()
        );
    }
}
