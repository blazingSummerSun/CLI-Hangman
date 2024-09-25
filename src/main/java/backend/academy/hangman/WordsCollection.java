package backend.academy.hangman;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class WordsCollection {
    private final List<Word> animalWordsCollectionEasy;
    private final List<Word> animalWordsCollectionMedium;
    private final List<Word> animalWordsCollectionHard;
    private final List<Word> deviceWordsCollectionEasy;
    private final List<Word> deviceWordsCollectionMedium;
    private final List<Word> deviceWordsCollectionHard;
    private final List<Word> locationWordsCollectionEasy;
    private final List<Word> locationWordsCollectionMedium;
    private final List<Word> locationWordsCollectionHard;
    private static final SecureRandom RANDOM = new SecureRandom();

    public WordsCollection() {
        animalWordsCollectionEasy = new ArrayList<>();
        animalWordsCollectionMedium = new ArrayList<>();
        animalWordsCollectionHard = new ArrayList<>();
        deviceWordsCollectionEasy = new ArrayList<>();
        deviceWordsCollectionMedium = new ArrayList<>();
        deviceWordsCollectionHard = new ArrayList<>();
        locationWordsCollectionEasy = new ArrayList<>();
        locationWordsCollectionMedium = new ArrayList<>();
        locationWordsCollectionHard = new ArrayList<>();
        setAnimalWordsCollectionEasy();
        setAnimalWordsCollectionMedium();
        setAnimalWordsCollectionHard();
        setDeviceWordsCollectionHard();
        setDeviceWordsCollectionEasy();
        setDeviceWordsCollectionMedium();
        setLocationWordsCollectionMedium();
        setLocationWordsCollectionHard();
        setLocationWordsCollectionEasy();
    }

    private void setAnimalWordsCollectionEasy() {
        Word cow = new Word("cow", "Farm animal");
        Word hyena = new Word("hyena", "Carnivorous animal");
        Word giraffe = new Word("giraffe", "Animal with the longest neck");
        Word whale = new Word("whale", "Lives in the ocean");
        animalWordsCollectionEasy.add(cow);
        animalWordsCollectionEasy.add(hyena);
        animalWordsCollectionEasy.add(giraffe);
        animalWordsCollectionEasy.add(whale);
    }

    private void setAnimalWordsCollectionMedium() {
        Word capybara = new Word("capybara", "The friendliest animal");
        Word raccoon = new Word("raccoon", "Has distinctive dark markings on their faces");
        Word peacock = new Word("peacock", "Animal with sea green `eyes` on its tail");
        animalWordsCollectionMedium.add(capybara);
        animalWordsCollectionMedium.add(raccoon);
        animalWordsCollectionMedium.add(peacock);
    }

    private void setAnimalWordsCollectionHard() {
        Word chinchilla = new Word("chinchilla", "Cute and fluffy animal");
        animalWordsCollectionHard.add(chinchilla);
    }

    private void setDeviceWordsCollectionEasy() {
        Word mouse = new Word("mouse", "Moves a cursor on the screen");
        Word screen = new Word("screen", "Displays some information from a user");
        deviceWordsCollectionEasy.add(mouse);
        deviceWordsCollectionEasy.add(screen);
    }

    private void setDeviceWordsCollectionMedium() {
        Word headphones = new Word("headphones", "Sound device");
        deviceWordsCollectionMedium.add(headphones);
    }

    private void setDeviceWordsCollectionHard() {
        Word projector = new Word("projector", "Displays information on the wall");
        deviceWordsCollectionHard.add(projector);
    }

    private void setLocationWordsCollectionEasy() {
        Word everest = new Word("everest", "The highest mountain in the world");
        locationWordsCollectionEasy.add(everest);
    }

    private void setLocationWordsCollectionMedium() {
        Word france = new Word("france", "The capital of love");
        locationWordsCollectionMedium.add(france);
    }

    private void setLocationWordsCollectionHard() {
        Word madagascar = new Word("madagascar", "The place named after a cartoon");
        locationWordsCollectionHard.add(madagascar);
    }

    public Word getRandomEasyAnimalWord() {
        return animalWordsCollectionEasy.get(RANDOM.nextInt(animalWordsCollectionEasy.size()));
    }

    public Word getRandomMediumAnimalWord() {
        return animalWordsCollectionMedium.get(RANDOM.nextInt(animalWordsCollectionMedium.size()));
    }

    public Word getRandomHardAnimalWord() {
        return animalWordsCollectionHard.get(RANDOM.nextInt(animalWordsCollectionHard.size()));
    }

    public Word getRandomEasyDeviceWord() {
        return deviceWordsCollectionEasy.get(RANDOM.nextInt(deviceWordsCollectionEasy.size()));
    }

    public Word getRandomMediumDeviceWord() {
        return deviceWordsCollectionMedium.get(RANDOM.nextInt(deviceWordsCollectionMedium.size()));
    }

    public Word getRandomHardDeviceWord() {
        return deviceWordsCollectionHard.get(RANDOM.nextInt(deviceWordsCollectionHard.size()));
    }

    public Word getRandomEasyLocationWord() {
        return locationWordsCollectionEasy.get(RANDOM.nextInt(locationWordsCollectionEasy.size()));
    }

    public Word getRandomMediumLocationWord() {
        return locationWordsCollectionMedium.get(RANDOM.nextInt(locationWordsCollectionMedium.size()));
    }

    public Word getRandomHardLocationWord() {
        return locationWordsCollectionHard.get(RANDOM.nextInt(locationWordsCollectionHard.size()));
    }
}
