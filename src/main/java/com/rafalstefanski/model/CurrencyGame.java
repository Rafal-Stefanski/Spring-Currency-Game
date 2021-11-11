package com.rafalstefanski.model;

public class CurrencyGame {
    private double usdValueInPln;
    private double usdInput;
    private String status;
    private int counter = 0;
    private boolean isGameOver = false;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    private final LatestUsdInPlnValue latestUsdInPlnValue = new LatestUsdInPlnValue();

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter++;
    }

    public double getUsdValueInPln() {
        return usdValueInPln;
    }

    public void setUsdValueInPln(double usdValueInPln) {
        this.usdValueInPln = Math.round(usdValueInPln * 100.0) / 100.0;
    }

    public double getUsdInput() {
        return usdInput;
    }

    public void setUsdInput(double usdInput) {
        this.usdInput = usdInput;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void check(double guessedInput) {
        counter++;
        setUsdInput(guessedInput);
        setCounter(counter);

        if (latestUsdInPlnValue.getPln() < guessedInput) {
            setStatus("Too much. Try again. ");
        } else if (latestUsdInPlnValue.getPln() > guessedInput) {
            setStatus("Too low. Try again. ");
        } else {
            setStatus("Bingo! You guessed it!");
        }
    }
}
