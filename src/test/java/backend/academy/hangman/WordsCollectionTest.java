package backend.academy.hangman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordsCollectionTest {
    @Test
    void AnimalEasyWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        String easyAnimalWord = wordsCollection.getRandomEasyAnimalWord().getWord();
        assertNotEquals("capybara", easyAnimalWord);
        assertNotEquals("raccoon", easyAnimalWord);
        assertNotEquals("peacock", easyAnimalWord);
        assertNotEquals("chinchilla", easyAnimalWord);
    }

    @Test
    void AnimalMediumWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        String mediumAnimalWord = wordsCollection.getRandomMediumAnimalWord().getWord();
        assertNotEquals("cow", mediumAnimalWord);
        assertNotEquals("hyena", mediumAnimalWord);
        assertNotEquals("giraffe", mediumAnimalWord);
        assertNotEquals("whale", mediumAnimalWord);
        assertNotEquals("chinchilla", mediumAnimalWord);
    }

    @Test
    void AnimalHardWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        String hardAnimalWord = wordsCollection.getRandomHardAnimalWord().getWord();
        assertNotEquals("cow", hardAnimalWord);
        assertNotEquals("hyena", hardAnimalWord);
        assertNotEquals("giraffe", hardAnimalWord);
        assertNotEquals("whale", hardAnimalWord);
        assertNotEquals("capybara", hardAnimalWord);
        assertNotEquals("raccoon", hardAnimalWord);
        assertNotEquals("peacock", hardAnimalWord);
    }


}
