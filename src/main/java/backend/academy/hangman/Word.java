package backend.academy.hangman;

import lombok.Getter;

@Getter public class Word {
    private final String word;
    private final String hint;

    public Word(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }

}
