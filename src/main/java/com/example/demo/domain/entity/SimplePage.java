package com.example.demo.domain.entity;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimplePage<T> {
    private List<T> content;
    private long totalElements;

    public <U> SimplePage<U> map(Function<? super T, ? extends U> mapper) {
        return new SimplePage<>(
                content.stream()
                       .map(mapper)
                       .collect(Collectors.toList()),
                totalElements
        );
    }
}
