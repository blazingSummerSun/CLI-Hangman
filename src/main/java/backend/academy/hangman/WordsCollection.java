package backend.academy.hangman;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class WordsCollection {
    private static final String EASY_LEVEL = "easy";
    private static final String MEDIUM_LEVEL = "medium";
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

    public Word getRandomWord(String difficulty, String category) {
        return switch (category) {
            case "animals" -> switch (difficulty) {
                case EASY_LEVEL -> animalWordsCollectionEasy.get(RANDOM.nextInt(animalWordsCollectionEasy.size()));
                case MEDIUM_LEVEL ->
                    animalWordsCollectionMedium.get(RANDOM.nextInt(animalWordsCollectionMedium.size()));
                default -> animalWordsCollectionHard.get(RANDOM.nextInt(animalWordsCollectionHard.size()));
            };
            case "devices" -> switch (difficulty) {
                case EASY_LEVEL -> deviceWordsCollectionEasy.get(RANDOM.nextInt(deviceWordsCollectionEasy.size()));
                case MEDIUM_LEVEL ->
                    deviceWordsCollectionMedium.get(RANDOM.nextInt(deviceWordsCollectionMedium.size()));
                default -> deviceWordsCollectionHard.get(RANDOM.nextInt(deviceWordsCollectionHard.size()));
            };
            default -> switch (difficulty) {
                case EASY_LEVEL -> locationWordsCollectionEasy.get(RANDOM.nextInt(locationWordsCollectionEasy.size()));
                case MEDIUM_LEVEL ->
                    locationWordsCollectionMedium.get(RANDOM.nextInt(locationWordsCollectionMedium.size()));
                default -> locationWordsCollectionHard.get(RANDOM.nextInt(locationWordsCollectionHard.size()));
            };
        };
    }
}
