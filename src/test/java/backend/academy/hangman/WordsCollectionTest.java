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

    @Test
    void DeviceEasyWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        String easyDeviceWord = wordsCollection.getRandomEasyDeviceWord().getWord();
        assertNotEquals("headphones", easyDeviceWord);
        assertNotEquals("projector", easyDeviceWord);
    }

    @Test
    void DeviceMediumWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        String mediumDeviceWord = wordsCollection.getRandomMediumDeviceWord().getWord();
        assertNotEquals("projector", mediumDeviceWord);
        assertNotEquals("mouse", mediumDeviceWord);
        assertNotEquals("screen", mediumDeviceWord);
    }

    @Test
    void DeviceHardWordCreation() {
        WordsCollection wordsCollection = new WordsCollection();
        String hardDeviceWord = wordsCollection.getRandomHardDeviceWord().getWord();
        assertNotEquals("headphones", hardDeviceWord);
        assertNotEquals("mouse", hardDeviceWord);
        assertNotEquals("screen", hardDeviceWord);
    }
}
