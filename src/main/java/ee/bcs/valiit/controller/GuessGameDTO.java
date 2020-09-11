package ee.bcs.valiit.controller;

public class GuessGameDTO {
    int randomNr;
    int guessedNr;
    boolean guessedRight;
    int counter;

    public boolean isGuessedRight() {
        return guessedRight;
    }

    public void setGuessedRight(boolean guessedRight) {
        this.guessedRight = guessedRight;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getRandomNr() {
        return randomNr;
    }

    public void setRandomNr(int randomNr) {
        this.randomNr = randomNr;
    }

    public int getGuessedNr() {
        return guessedNr;
    }

    public void setGuessedNr(int guessedNr) {
        this.guessedNr = guessedNr;
    }
}
