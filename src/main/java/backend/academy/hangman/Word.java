package backend.academy.hangman;

public abstract class Word {
    protected String word;
    protected String hint;
    public Word(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }
    public String getWord() {
        return word;
    }
    public String getHint() {
        return hint;
    }
}
