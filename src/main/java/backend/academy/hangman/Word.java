package backend.academy.hangman;

public abstract class Word {
    protected String word;
    protected String clue;
    public Word(String word, String clue) {
        this.word = word;
        this.clue = clue;
    }
    public String getWord() {
        return word;
    }
    public String getClue() {
        return clue;
    }
}
