package backend.academy.hangman;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class WordsCollection {
    private final List<AnimalWord> animalWordsCollectionEasy;
    private final List<AnimalWord> animalWordsCollectionMedium;
    private final List<AnimalWord> animalWordsCollectionHard;
    private final List<DeviceWord> deviceWordsCollectionEasy;
    private final List<DeviceWord> deviceWordsCollectionMedium;
    private final List<DeviceWord> deviceWordsCollectionHard;
    private final List<LocationWord> locationWordsCollectionEasy;
    private final List<LocationWord> locationWordsCollectionMedium;
    private final List<LocationWord> locationWordsCollectionHard;
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
        AnimalWord cow = new AnimalWord("cow", "Farm animal");
        AnimalWord hyena = new AnimalWord("hyena", "Carnivorous animal");
        AnimalWord giraffe = new AnimalWord("giraffe", "Animal with the longest neck");
        AnimalWord whale = new AnimalWord("whale", "The animal lives in the ocean");
        animalWordsCollectionEasy.add(cow);
        animalWordsCollectionEasy.add(hyena);
        animalWordsCollectionEasy.add(giraffe);
        animalWordsCollectionEasy.add(whale);
    }

    private void setAnimalWordsCollectionMedium() {
        AnimalWord capybara = new AnimalWord("capybara", "The friendliest animal");
        AnimalWord raccoon = new AnimalWord("raccoon", "Distinctive dark markings on their faces");
        AnimalWord peacock = new AnimalWord("peacock", "Animal with sea green `eyes` on its tail");
        animalWordsCollectionMedium.add(capybara);
        animalWordsCollectionMedium.add(raccoon);
        animalWordsCollectionMedium.add(peacock);
    }

    private void setAnimalWordsCollectionHard() {
        AnimalWord chinchilla = new AnimalWord("chinchilla", "Cute and fluffy animal");
        animalWordsCollectionHard.add(chinchilla);
    }

    private void setDeviceWordsCollectionEasy() {
        DeviceWord mouse = new DeviceWord("mouse", "Moves a cursor within the screen");
        DeviceWord screen = new DeviceWord("screen", "Displays some information from a user");
        deviceWordsCollectionEasy.add(mouse);
        deviceWordsCollectionEasy.add(screen);
    }

    private void setDeviceWordsCollectionMedium() {
        DeviceWord headphones = new DeviceWord("headphones", "Sound device");
        deviceWordsCollectionMedium.add(headphones);
    }

    private void setDeviceWordsCollectionHard() {
        DeviceWord projector = new DeviceWord("projector", "Displays information on the wall");
        deviceWordsCollectionHard.add(projector);
    }

    private void setLocationWordsCollectionEasy() {
        LocationWord everest = new LocationWord("everest", "The highest mountain in the world");
        locationWordsCollectionEasy.add(everest);
    }

    private void setLocationWordsCollectionMedium() {
        LocationWord france = new LocationWord("france", "The capital of love");
        locationWordsCollectionMedium.add(france);
    }

    private void setLocationWordsCollectionHard() {
        LocationWord madagascar = new LocationWord("madagascar", "The place named after a cartoon");
        locationWordsCollectionHard.add(madagascar);
    }

    public AnimalWord getRandomEasyAnimalWord() {
        return animalWordsCollectionEasy.get(RANDOM.nextInt(animalWordsCollectionEasy.size()));
    }

    public AnimalWord getRandomMediumAnimalWord() {
        return animalWordsCollectionMedium.get(RANDOM.nextInt(animalWordsCollectionMedium.size()));
    }

    public AnimalWord getRandomHardAnimalWord() {
        return animalWordsCollectionHard.get(RANDOM.nextInt(animalWordsCollectionHard.size()));
    }

    public DeviceWord getRandomEasyDeviceWord() {
        return deviceWordsCollectionEasy.get(RANDOM.nextInt(deviceWordsCollectionEasy.size()));
    }

    public DeviceWord getRandomMediumDeviceWord() {
        return deviceWordsCollectionMedium.get(RANDOM.nextInt(deviceWordsCollectionMedium.size()));
    }

    public DeviceWord getRandomHardDeviceWord() {
        return deviceWordsCollectionHard.get(RANDOM.nextInt(deviceWordsCollectionHard.size()));
    }

    public LocationWord getRandomEasyLocationWord() {
        return locationWordsCollectionEasy.get(RANDOM.nextInt(locationWordsCollectionEasy.size()));
    }

    public LocationWord getRandomMediumLocationWord() {
        return locationWordsCollectionMedium.get(RANDOM.nextInt(locationWordsCollectionMedium.size()));
    }

    public LocationWord getRandomHardLocationWord() {
        return locationWordsCollectionHard.get(RANDOM.nextInt(locationWordsCollectionHard.size()));
    }
}
