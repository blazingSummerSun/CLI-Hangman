package backend.academy.hangman;

public class DeviceWord extends Word {
    public DeviceWord(String word, String hint) {
        super(word, hint);
    }

    public String getWord() {
        return this.word;
    }

    public String getHint() {
        return hint;
    }
}
