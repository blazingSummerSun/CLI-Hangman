package backend.academy.hangman;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class WordsCollection {
    private final List<AnimalWord> animal_words_collection_easy;
    private final List<AnimalWord> animal_words_collection_medium;
    private final List<AnimalWord> animal_words_collection_hard;
    private final List<DeviceWord> device_words_collection_easy;
    private final List<DeviceWord> device_words_collection_medium;
    private final List<DeviceWord> device_words_collection_hard;
    private final List<LocationWord> location_words_collection_easy;
    private final List<LocationWord> location_words_collection_medium;
    private final List<LocationWord> location_words_collection_hard;


    public WordsCollection() {
        animal_words_collection_easy = new ArrayList<>();
        animal_words_collection_medium = new ArrayList<>();
        animal_words_collection_hard = new ArrayList<>();
        device_words_collection_easy = new ArrayList<>();
        device_words_collection_medium = new ArrayList<>();
        device_words_collection_hard = new ArrayList<>();
        location_words_collection_easy = new ArrayList<>();
        location_words_collection_medium = new ArrayList<>();
        location_words_collection_hard = new ArrayList<>();
        setAnimal_words_collection_easy();
        setAnimal_words_collection_medium();
        setAnimal_words_collection_hard();
        setDevice_words_collection_easy();
        setDevice_words_collection_medium();
        setDevice_words_collection_hard();
        setLocation_words_collection_easy();
        setLocation_words_collection_medium();
        setLocation_words_collection_hard();
    }

    private void setAnimal_words_collection_easy() {
        AnimalWord cow = new AnimalWord("cow", "Farm animal");
        AnimalWord hyena = new AnimalWord("hyena", "Carnivorous animal");
        AnimalWord giraffe = new AnimalWord("giraffe", "Animal with the longest neck");
        AnimalWord whale = new AnimalWord("whale", "The animal lives in the ocean");
        animal_words_collection_easy.add(cow);
        animal_words_collection_easy.add(hyena);
        animal_words_collection_easy.add(giraffe);
        animal_words_collection_easy.add(whale);
    }

    private void setAnimal_words_collection_medium() {
        AnimalWord capybara = new AnimalWord("capybara", "The friendliest animal");
        AnimalWord raccoon = new AnimalWord("raccoon", "Distinctive dark markings on their faces");
        AnimalWord peacock = new AnimalWord("peacock", "Animal with sea green `eyes` on its tail");
        animal_words_collection_medium.add(capybara);
        animal_words_collection_medium.add(raccoon);
        animal_words_collection_medium.add(peacock);
    }

    private void setAnimal_words_collection_hard() {
        AnimalWord chinchilla = new AnimalWord("chinchilla", "Cute animal");
        animal_words_collection_hard.add(chinchilla);
    }
    private void setDevice_words_collection_easy() {
        DeviceWord mouse = new DeviceWord("mouse", "Moves a cursor within the screen");
        DeviceWord screen = new DeviceWord("screen", "Displays some information from a user");
        device_words_collection_easy.add(mouse);
        device_words_collection_easy.add(screen);
    }
    private void setDevice_words_collection_medium() {
        DeviceWord headphones = new DeviceWord("headphones", "Sound device");
        device_words_collection_medium.add(headphones);
    }
    private void setDevice_words_collection_hard() {
        DeviceWord projector = new DeviceWord("projector", "Displays information on the wall");
        device_words_collection_hard.add(projector);
    }
    private void setLocation_words_collection_easy() {
        LocationWord everest = new LocationWord("everest", "The highest mountain in the world");
        location_words_collection_easy.add(everest);
    }
    private void setLocation_words_collection_medium() {
        LocationWord france = new LocationWord("france", "The love's country");
        location_words_collection_medium.add(france);
    }
    private void setLocation_words_collection_hard() {
        LocationWord madagascar = new LocationWord("madagascar", "The place called by the cartoon");
        location_words_collection_hard.add(madagascar);
    }

    public AnimalWord getRandomEasyAnimalWord() {
        SecureRandom secureRandom = new SecureRandom();
        return animal_words_collection_easy.get(secureRandom.nextInt(animal_words_collection_easy.size()));
    }
    public AnimalWord getRandomMediumAnimalWord() {
        SecureRandom secureRandom = new SecureRandom();
        return animal_words_collection_medium.get(secureRandom.nextInt(animal_words_collection_medium.size()));
    }
    public AnimalWord getRandomHardAnimalWord() {
        SecureRandom secureRandom = new SecureRandom();
        return animal_words_collection_hard.get(secureRandom.nextInt(animal_words_collection_hard.size()));
    }
    public DeviceWord getRandomEasyDeviceWord() {
        SecureRandom secureRandom = new SecureRandom();
        return device_words_collection_easy.get(secureRandom.nextInt(device_words_collection_easy.size()));
    }
    public DeviceWord getRandomMediumDeviceWord() {
        SecureRandom secureRandom = new SecureRandom();
        return device_words_collection_medium.get(secureRandom.nextInt(device_words_collection_medium.size()));
    }
    public DeviceWord getRandomHardDeviceWord() {
        SecureRandom secureRandom = new SecureRandom();
        return device_words_collection_hard.get(secureRandom.nextInt(device_words_collection_hard.size()));
    }
    public LocationWord getRandomEasyLocationWord() {
        SecureRandom secureRandom = new SecureRandom();
        return location_words_collection_easy.get(secureRandom.nextInt(location_words_collection_easy.size()));
    }
    public LocationWord getRandomMediumLocationWord() {
        SecureRandom secureRandom = new SecureRandom();
        return location_words_collection_medium.get(secureRandom.nextInt(location_words_collection_medium.size()));
    }
    public LocationWord getRandomHardLocationWord() {
        SecureRandom secureRandom = new SecureRandom();
        return location_words_collection_hard.get(secureRandom.nextInt(location_words_collection_hard.size()));
    }
}
