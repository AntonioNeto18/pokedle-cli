package com.antonio.menu;

import com.antonio.entity.GuessFeedback;
import com.antonio.entity.Pokemon;
import com.antonio.service.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private Pokemon correctAnswer;
    private List<GuessFeedback> guesses = new ArrayList<>();
    private GameService service = new GameService();
    private Boolean win = false;

    public Menu() {
        this.correctAnswer = service.generateRandomAnswer();
    }

    public void show() {
        System.out.println("""
                --- POKEDLE ---
                1. Chutar
                2. Ver chutes
                3. Ver pokemons
                0. Sair
                """);
        System.out.print(">>> ");

        Integer op = sc.nextInt();
        optionHandler(op);
    }

    private void optionHandler(Integer op) {
        switch (op) {
            case 1:
                guess();
                break;
            case 2:
                showGuesses();
                break;
            case 3:
                showPokemons();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcao inválida.");
        }
    }

    private void showPokemons() {
        System.out.println("--- POKEDLE ---");
        for (Pokemon p : service.getPokemons()) {
            System.out.println(p.name());
        }
    }

    private void showGuesses() {
        System.out.println("--- POKEDLE ---");
        System.out.println("Nome\t - \tTipos\t - Altura - Peso");
        for (GuessFeedback f : guesses) {
            System.out.println(f);
        }
    }

    private void guess() {
        System.out.println("--- POKEDLE ---");
        while (!win) {
            System.out.print("Digite o nome do pokemon [V para voltar]: ");
            String pokemonName = sc.next();
            if (pokemonName.equalsIgnoreCase("v")) return;
            try {
                GuessFeedback feedback = service.checkGuess(pokemonName, correctAnswer);
                guesses.add(feedback);
                System.out.println(feedback);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
            if (service.isCorrect(pokemonName, correctAnswer)) {
                win = true;
            }
        }

        System.out.println("Você ganhou!");
    }
}
