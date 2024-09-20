package backend.academy.hangman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordsCollectionTest {
    @Test
    void AnimalEasyWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        AnimalWord easyAnimalWord = wordsCollection.getRandomEasyAnimalWord();
        assertNotEquals("capybara", easyAnimalWord.getWord());
        assertNotEquals("raccoon", easyAnimalWord.getWord());
        assertNotEquals("peacock", easyAnimalWord.getWord());
        assertNotEquals("chinchilla", easyAnimalWord.getWord());
    }

    @Test
    void AnimalMediumWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        AnimalWord mediumAnimalWord = wordsCollection.getRandomMediumAnimalWord();
        assertNotEquals("cow", mediumAnimalWord.getWord());
        assertNotEquals("hyena", mediumAnimalWord.getWord());
        assertNotEquals("giraffe", mediumAnimalWord.getWord());
        assertNotEquals("whale", mediumAnimalWord.getWord());
        assertNotEquals("chinchilla", mediumAnimalWord.getWord());
    }

    @Test
    void AnimalHardWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        AnimalWord hardAnimalWord = wordsCollection.getRandomHardAnimalWord();
        assertNotEquals("cow", hardAnimalWord.getWord());
        assertNotEquals("hyena", hardAnimalWord.getWord());
        assertNotEquals("giraffe", hardAnimalWord.getWord());
        assertNotEquals("whale", hardAnimalWord.getWord());
        assertNotEquals("capybara", hardAnimalWord.getWord());
        assertNotEquals("raccoon", hardAnimalWord.getWord());
        assertNotEquals("peacock", hardAnimalWord.getWord());
    }

}
