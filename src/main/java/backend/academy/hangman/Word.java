package backend.academy.hangman;

public abstract class Word {
    protected final String word;
    protected final String hint;

    public Word(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }

}
