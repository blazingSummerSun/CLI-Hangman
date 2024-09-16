package backend.academy.hangman;

import org.checkerframework.checker.units.qual.A;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnimalWordsCollection {
    private final List<AnimalWord> animal_words_collection_easy;
    private final List<AnimalWord> animal_words_collection_medium;
    private final List<AnimalWord> animal_words_collection_hard;

    public AnimalWordsCollection() {
        animal_words_collection_easy = new ArrayList<>();
        animal_words_collection_medium = new ArrayList<>();
        animal_words_collection_hard = new ArrayList<>();
        setAnimal_words_collection_easy();
        setAnimal_words_collection_medium();
        setAnimal_words_collection_hard();
    }

    private void setAnimal_words_collection_easy() {
        AnimalWord cow = new AnimalWord("Cow", "Farm animal");
        AnimalWord hyena = new AnimalWord("Hyena", "Carnivorous animal");
        AnimalWord giraffe = new AnimalWord("Giraffe", "Animal with the longest neck");
        AnimalWord whale = new AnimalWord("Whale", "The animal lives in the ocean");
        animal_words_collection_easy.add(cow);
        animal_words_collection_easy.add(hyena);
        animal_words_collection_easy.add(giraffe);
        animal_words_collection_easy.add(whale);
    }

    private void setAnimal_words_collection_medium() {
        AnimalWord capybara = new AnimalWord("Capybara", "The friendliest animal");
        AnimalWord raccoon = new AnimalWord("Raccoon", "Distinctive dark markings on their faces");
        AnimalWord peacock = new AnimalWord("Peacock", "Animal with sea green `eyes` on its tail");
        animal_words_collection_medium.add(capybara);
        animal_words_collection_medium.add(raccoon);
        animal_words_collection_medium.add(peacock);
    }

    private void setAnimal_words_collection_hard() {
        AnimalWord chinchilla = new AnimalWord("Chinchilla", "Cute animal");
        animal_words_collection_hard.add(chinchilla);
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
}
