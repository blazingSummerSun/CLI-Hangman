package backend.academy.hangman;

public class LocationWord extends Word {
    public LocationWord(String word, String hint) {
        super(word, hint);
    }

    public String getWord() {
        return this.word;
    }

    public String getHint() {
        return hint;
    }
}
