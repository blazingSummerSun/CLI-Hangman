package backend.academy.hangman;

import lombok.Getter;

@Getter public class Word {
    private final String word;
    private final String hint;
    private final WordCategories wordCategories;

    public Word(String word, String hint, WordCategories wordCategories) {
        this.word = word;
        this.hint = hint;
        this.wordCategories = wordCategories;
    }

}
