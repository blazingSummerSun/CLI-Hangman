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
        Word cow = new Word("cow", "Farm animal", WordCategories.animals);
        Word hyena = new Word("hyena", "Carnivorous animal", WordCategories.animals);
        Word giraffe = new Word("giraffe", "Animal with the longest neck", WordCategories.animals);
        Word whale = new Word("whale", "Lives in the ocean", WordCategories.animals);
        animalWordsCollectionEasy.add(cow);
        animalWordsCollectionEasy.add(hyena);
        animalWordsCollectionEasy.add(giraffe);
        animalWordsCollectionEasy.add(whale);
    }

    private void setAnimalWordsCollectionMedium() {
        Word capybara = new Word("capybara", "The friendliest animal", WordCategories.animals);
        Word raccoon = new Word("raccoon", "Has distinctive dark markings on their faces", WordCategories.animals);
        Word peacock = new Word("peacock", "Animal with sea green `eyes` on its tail", WordCategories.animals);
        animalWordsCollectionMedium.add(capybara);
        animalWordsCollectionMedium.add(raccoon);
        animalWordsCollectionMedium.add(peacock);
    }

    private void setAnimalWordsCollectionHard() {
        Word chinchilla = new Word("chinchilla", "Cute and fluffy animal", WordCategories.animals);
        animalWordsCollectionHard.add(chinchilla);
    }

    private void setDeviceWordsCollectionEasy() {
        Word mouse = new Word("mouse", "Moves a cursor on the screen", WordCategories.devices);
        Word screen = new Word("screen", "Displays some information from a user", WordCategories.devices);
        deviceWordsCollectionEasy.add(mouse);
        deviceWordsCollectionEasy.add(screen);
    }

    private void setDeviceWordsCollectionMedium() {
        Word headphones = new Word("headphones", "Sound device", WordCategories.devices);
        deviceWordsCollectionMedium.add(headphones);
    }

    private void setDeviceWordsCollectionHard() {
        Word projector = new Word("projector", "Displays information on the wall", WordCategories.devices);
        deviceWordsCollectionHard.add(projector);
    }

    private void setLocationWordsCollectionEasy() {
        Word everest = new Word("everest", "The highest mountain in the world", WordCategories.locations);
        locationWordsCollectionEasy.add(everest);
    }

    private void setLocationWordsCollectionMedium() {
        Word france = new Word("france", "The capital of love", WordCategories.locations);
        locationWordsCollectionMedium.add(france);
    }

    private void setLocationWordsCollectionHard() {
        Word madagascar = new Word("madagascar", "The place named after a cartoon", WordCategories.locations);
        locationWordsCollectionHard.add(madagascar);
    }

    public Word getRandomWord(Difficulty difficulty, WordCategories category) {
        return switch (category) {
            case animals -> switch (difficulty) {
                case easy -> animalWordsCollectionEasy.get(RANDOM.nextInt(animalWordsCollectionEasy.size()));
                case medium -> animalWordsCollectionMedium.get(RANDOM.nextInt(animalWordsCollectionMedium.size()));
                default -> animalWordsCollectionHard.get(RANDOM.nextInt(animalWordsCollectionHard.size()));
            };
            case devices -> switch (difficulty) {
                case easy -> deviceWordsCollectionEasy.get(RANDOM.nextInt(deviceWordsCollectionEasy.size()));
                case medium -> deviceWordsCollectionMedium.get(RANDOM.nextInt(deviceWordsCollectionMedium.size()));
                default -> deviceWordsCollectionHard.get(RANDOM.nextInt(deviceWordsCollectionHard.size()));
            };
            default -> switch (difficulty) {
                case easy -> locationWordsCollectionEasy.get(RANDOM.nextInt(locationWordsCollectionEasy.size()));
                case medium -> locationWordsCollectionMedium.get(RANDOM.nextInt(locationWordsCollectionMedium.size()));
                default -> locationWordsCollectionHard.get(RANDOM.nextInt(locationWordsCollectionHard.size()));
            };
        };
    }
}
