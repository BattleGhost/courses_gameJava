package com.company.hwork2;

import java.util.Random;

public class Model {
    private static final int MIN = 0;
    private static final int MAX = 100;

    private int guessedMinimal = MIN;
    private int guessedMaximal = MAX;

    private int guessedNumber;
    private int guessTries = 0;

    // Constructor
    public Model() {
        this.guessedNumber = (new Random()).nextInt(MAX - MIN - 1) + MIN + 1;
    }

    // Getters
    public int getGuessedNumber() {
        return guessedNumber;
    }

    public int getGuessTries() {
        return guessTries;
    }

    public int getGuessedMaximal() {
        return guessedMaximal;
    }

    public int getGuessedMinimal() {
        return guessedMinimal;
    }


    // Work methods
    public void resetGuessedNumber() {
        this.guessedNumber = (new Random()).nextInt(MAX - MIN) + MIN;
        this.guessTries = 0;
    }

    public void changeGuessedBounds(int guess) {
        if (guess > this.guessedNumber)
            this.guessedMaximal = guess;
        else
            this.guessedMinimal = guess;
    }

    public boolean isCorrectGuess(int guess) {
        return guess == this.guessedNumber;
    }

    public boolean isGuessHigher(int guess) {
        return guess > this.guessedNumber;
    }

    public boolean isCorrectBoundary(int guess) {
        return guess > this.guessedMinimal && guess < this.guessedMaximal;
    }

    public void increaseGuessTries() {
        this.guessTries++;
    }

}
