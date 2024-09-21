package backend.academy.hangman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordsCollectionTest {
    @Test
    void shouldReturnEasyAnimalWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String easyAnimalWord = wordsCollection.getRandomEasyAnimalWord().getWord();
        assertNotEquals("capybara", easyAnimalWord);
        assertNotEquals("raccoon", easyAnimalWord);
        assertNotEquals("peacock", easyAnimalWord);
        assertNotEquals("chinchilla", easyAnimalWord);
    }

    @Test
    void shouldReturnMediumAnimalWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String mediumAnimalWord = wordsCollection.getRandomMediumAnimalWord().getWord();
        assertNotEquals("cow", mediumAnimalWord);
        assertNotEquals("hyena", mediumAnimalWord);
        assertNotEquals("giraffe", mediumAnimalWord);
        assertNotEquals("whale", mediumAnimalWord);
        assertNotEquals("chinchilla", mediumAnimalWord);
    }

    @Test
    void shouldReturnHardAnimalWord() {
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

    @Test
    void shouldReturnEasyDeviceWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String easyDeviceWord = wordsCollection.getRandomEasyDeviceWord().getWord();
        assertNotEquals("headphones", easyDeviceWord);
        assertNotEquals("projector", easyDeviceWord);
    }

    @Test
    void shouldReturnMediumDeviceWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String mediumDeviceWord = wordsCollection.getRandomMediumDeviceWord().getWord();
        assertNotEquals("projector", mediumDeviceWord);
        assertNotEquals("mouse", mediumDeviceWord);
        assertNotEquals("screen", mediumDeviceWord);
    }

    @Test
    void shouldReturnHardDeviceWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String hardDeviceWord = wordsCollection.getRandomHardDeviceWord().getWord();
        assertNotEquals("headphones", hardDeviceWord);
        assertNotEquals("mouse", hardDeviceWord);
        assertNotEquals("screen", hardDeviceWord);
    }

    @Test
    void shouldReturnEasyLocationWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String easyLocationWord = wordsCollection.getRandomEasyLocationWord().getWord();
        assertNotEquals("france", easyLocationWord);
        assertNotEquals("madagascar", easyLocationWord);
    }

    @Test
    void shouldReturnMediumLocationWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String mediumLocationWord = wordsCollection.getRandomMediumLocationWord().getWord();
        assertNotEquals("madagascar", mediumLocationWord);
        assertNotEquals("everest", mediumLocationWord);
    }

    @Test
    void shouldReturnHardLocationWord() {
        WordsCollection wordsCollection = new WordsCollection();
        String hardLocationWord = wordsCollection.getRandomHardLocationWord().getWord();
        assertNotEquals("france", hardLocationWord);
        assertNotEquals("everest", hardLocationWord);
    }
}
