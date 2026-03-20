package com.antonio.entity;

import java.util.List;

public record Pokemon (
        Integer id,
        String name,
        List<String> types,
        Integer height,
        Integer weight,
        String sprite
) {
}
