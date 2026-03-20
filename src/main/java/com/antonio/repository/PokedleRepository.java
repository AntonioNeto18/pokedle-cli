package com.antonio.repository;

import com.antonio.entity.Pokemon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class PokedleRepository implements IPokedleRepository {

    private ObjectMapper mapper = new ObjectMapper();
    private List<Pokemon> pokemons;

    public PokedleRepository() {
        loadData();
    }

    private void loadData() {
        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("data.json");

            pokemons = mapper.readValue(
                    is,
                    new TypeReference<List<Pokemon>>() {}
            );
        } catch (Exception ex) {
            throw new RuntimeException("Erro: " + ex.getMessage());
        }
    }

    @Override
    public List<Pokemon> findAll() {
        return this.pokemons;
    }

    @Override
    public Optional<Pokemon> findByName(String name) {
        return pokemons.stream()
                .filter(p -> p.name().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public Optional<Pokemon> findById(Integer id) {
        return pokemons.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();
    }
}
