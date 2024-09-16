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
        setanimalWordsCollectionEasy();
        setanimalWordsCollectionMedium();
        setanimalWordsCollectionHard();
        setdeviceWordsCollectionEasy();
        setdeviceWordsCollectionMedium();
        setdeviceWordsCollectionHard();
        setlocationWordsCollectionEasy();
        setlocationWordsCollectionMedium();
        setlocationWordsCollectionHard();
    }

    private void setanimalWordsCollectionEasy() {
        AnimalWord cow = new AnimalWord("cow", "Farm animal");
        AnimalWord hyena = new AnimalWord("hyena", "Carnivorous animal");
        AnimalWord giraffe = new AnimalWord("giraffe", "Animal with the longest neck");
        AnimalWord whale = new AnimalWord("whale", "The animal lives in the ocean");
        animalWordsCollectionEasy.add(cow);
        animalWordsCollectionEasy.add(hyena);
        animalWordsCollectionEasy.add(giraffe);
        animalWordsCollectionEasy.add(whale);
    }

    private void setanimalWordsCollectionMedium() {
        AnimalWord capybara = new AnimalWord("capybara", "The friendliest animal");
        AnimalWord raccoon = new AnimalWord("raccoon", "Distinctive dark markings on their faces");
        AnimalWord peacock = new AnimalWord("peacock", "Animal with sea green `eyes` on its tail");
        animalWordsCollectionMedium.add(capybara);
        animalWordsCollectionMedium.add(raccoon);
        animalWordsCollectionMedium.add(peacock);
    }

    private void setanimalWordsCollectionHard() {
        AnimalWord chinchilla = new AnimalWord("chinchilla", "Cute animal");
        animalWordsCollectionHard.add(chinchilla);
    }

    private void setdeviceWordsCollectionEasy() {
        DeviceWord mouse = new DeviceWord("mouse", "Moves a cursor within the screen");
        DeviceWord screen = new DeviceWord("screen", "Displays some information from a user");
        deviceWordsCollectionEasy.add(mouse);
        deviceWordsCollectionEasy.add(screen);
    }

    private void setdeviceWordsCollectionMedium() {
        DeviceWord headphones = new DeviceWord("headphones", "Sound device");
        deviceWordsCollectionMedium.add(headphones);
    }

    private void setdeviceWordsCollectionHard() {
        DeviceWord projector = new DeviceWord("projector", "Displays information on the wall");
        deviceWordsCollectionHard.add(projector);
    }

    private void setlocationWordsCollectionEasy() {
        LocationWord everest = new LocationWord("everest", "The highest mountain in the world");
        locationWordsCollectionEasy.add(everest);
    }

    private void setlocationWordsCollectionMedium() {
        LocationWord france = new LocationWord("france", "The love's country");
        locationWordsCollectionMedium.add(france);
    }

    private void setlocationWordsCollectionHard() {
        LocationWord madagascar = new LocationWord("madagascar", "The place called by the cartoon");
        locationWordsCollectionHard.add(madagascar);
    }

    public AnimalWord getRandomEasyAnimalWord() {
        SecureRandom secureRandom = new SecureRandom();
        return animalWordsCollectionEasy.get(secureRandom.nextInt(animalWordsCollectionEasy.size()));
    }

    public AnimalWord getRandomMediumAnimalWord() {
        SecureRandom secureRandom = new SecureRandom();
        return animalWordsCollectionMedium.get(secureRandom.nextInt(animalWordsCollectionMedium.size()));
    }

    public AnimalWord getRandomHardAnimalWord() {
        SecureRandom secureRandom = new SecureRandom();
        return animalWordsCollectionHard.get(secureRandom.nextInt(animalWordsCollectionHard.size()));
    }

    public DeviceWord getRandomEasyDeviceWord() {
        SecureRandom secureRandom = new SecureRandom();
        return deviceWordsCollectionEasy.get(secureRandom.nextInt(deviceWordsCollectionEasy.size()));
    }

    public DeviceWord getRandomMediumDeviceWord() {
        SecureRandom secureRandom = new SecureRandom();
        return deviceWordsCollectionMedium.get(secureRandom.nextInt(deviceWordsCollectionMedium.size()));
    }

    public DeviceWord getRandomHardDeviceWord() {
        SecureRandom secureRandom = new SecureRandom();
        return deviceWordsCollectionHard.get(secureRandom.nextInt(deviceWordsCollectionHard.size()));
    }

    public LocationWord getRandomEasyLocationWord() {
        SecureRandom secureRandom = new SecureRandom();
        return locationWordsCollectionEasy.get(secureRandom.nextInt(locationWordsCollectionEasy.size()));
    }

    public LocationWord getRandomMediumLocationWord() {
        SecureRandom secureRandom = new SecureRandom();
        return locationWordsCollectionMedium.get(secureRandom.nextInt(locationWordsCollectionMedium.size()));
    }

    public LocationWord getRandomHardLocationWord() {
        SecureRandom secureRandom = new SecureRandom();
        return locationWordsCollectionHard.get(secureRandom.nextInt(locationWordsCollectionHard.size()));
    }
}
