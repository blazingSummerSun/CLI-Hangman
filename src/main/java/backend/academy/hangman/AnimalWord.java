package backend.academy.hangman;

public class AnimalWord extends Word {
    public AnimalWord(String word, String hint) {
        super(word, hint);
    }

    public String getWord() {
        return this.word;
    }

    public String getHint() {
        return hint;
    }
}
