package com.antonio.repository;

import com.antonio.entity.Pokemon;

import java.util.List;
import java.util.Optional;

public interface IPokedleRepository {
    List<Pokemon> findAll();
    Optional<Pokemon> findByName(String name);
    Optional<Pokemon> findById(Integer id);
}
