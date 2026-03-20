package com.antonio.service;

import com.antonio.entity.GuessFeedback;
import com.antonio.entity.Pokemon;

import java.util.List;

public class VerifyService {

    private static final String RESET = "\u001B[0m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARELO = "\u001B[33m";

    public GuessFeedback verifiedGuess(Pokemon guess, Pokemon correctAnswer) {
        return new GuessFeedback(
                verifiedName(guess, correctAnswer),
                verifiedTypes(guess, correctAnswer),
                verifiedHeight(guess, correctAnswer),
                verifiedWeight(guess, correctAnswer)
        );
    }

    private String verifiedWeight(Pokemon guess, Pokemon correctAnswer) {
        String color;
        if (guess.weight().equals(correctAnswer.weight())) {
            color = VERDE;
            return color + guess.weight() + RESET;
        } else {
            color = AMARELO;
            if (guess.weight() < correctAnswer.weight()) {
                return color + "↑" + RESET;
            } else {
                return color + "↓" + RESET;
            }
        }
    }

    private String verifiedHeight(Pokemon guess, Pokemon correctAnswer) {
        String color;
        if (guess.height().equals(correctAnswer.height())) {
            color = VERDE;
            return color + guess.height() + RESET;
        } else {
            color = AMARELO;
            if (guess.height() < correctAnswer.height()) {
                return color + "↑" + RESET;
            } else {
                return color + "↓" + RESET;
            }
        }
    }

    private List<String> verifiedTypes(Pokemon guess, Pokemon correctAnswer) {
        return List.of(
                verifiedType1(guess.types().get(0), correctAnswer.types()),
                verifiedType2(guess.types().get(1), correctAnswer.types())
        );
    }

    private String verifiedType1(String guessType, List<String> correctTypes) {
        String color;
        if (guessType.equalsIgnoreCase(correctTypes.get(0))) {
            color = VERDE;
        } else if (correctTypes.contains(guessType)) {
            color = AMARELO;
        } else {
            color = VERMELHO;
        }
        return color + guessType + RESET;
    }

    private String verifiedType2(String guessType, List<String> correctTypes) {
        String color;
        if (guessType.equalsIgnoreCase(correctTypes.get(1))) {
            color = VERDE;
        } else if (correctTypes.contains(guessType)) {
            color = AMARELO;
        } else {
            color = VERMELHO;
        }
        return color + guessType + RESET;
    }

    private String verifiedName(Pokemon guess, Pokemon correctAnswer) {
        String color;
        if (guess.name().equalsIgnoreCase(correctAnswer.name())) {
            color = VERDE;
        }
        else {
            color = VERMELHO;
        }
        return color + guess.name() + RESET;
    }

}
