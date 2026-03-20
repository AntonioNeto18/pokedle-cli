package com.antonio.service;

import com.antonio.entity.GuessFeedback;
import com.antonio.entity.Pokemon;
import com.antonio.repository.PokedleRepository;

import java.util.List;
import java.util.Random;

public class GameService {

    private PokedleRepository repository = new PokedleRepository();
    private VerifyService verifyService = new VerifyService();

    private Random random = new Random();

    public Pokemon generateRandomAnswer() {
        Integer randomId;
        do {
            randomId = random.nextInt() % 151;
        } while (!repository.findById(randomId).isPresent());
        return repository.findById(randomId).get();
    }

    private Pokemon getPokemonByName(String pokemonName) {
        return repository.findByName(pokemonName).orElseThrow(
                () -> new RuntimeException("Pokemon não encontrado.")
        );
    }

    public GuessFeedback checkGuess(String pokemonName, Pokemon correctAnswer) {
        try {
            Pokemon guess = getPokemonByName(pokemonName);
            return verifyService.verifiedGuess(guess, correctAnswer);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Boolean isCorrect(String pokemonName, Pokemon correctAnswer) {
        return pokemonName.equalsIgnoreCase(correctAnswer.name());
    }

    public List<Pokemon> getPokemons() {
        return repository.findAll();
    }
}
