package backend.academy.hangman;

import java.util.HashMap;

public class AnimalWordsCollection {
    private final HashMap<String, AnimalWord> animal_words_collection;
    public AnimalWordsCollection() {
        animal_words_collection = new HashMap<>();
        AnimalWord cow = new AnimalWord("Cow", "Usually, it lives on the farm");
        AnimalWord capybara = new AnimalWord("Capybara", "The friendliest animal");
        AnimalWord raccoon = new AnimalWord("Raccoon", "Distinctive dark markings on their faces");
        animal_words_collection.put("Cow", cow);
        animal_words_collection.put("Capybara", capybara);
        animal_words_collection.put("Raccoon", raccoon);
    }
    public HashMap<String, AnimalWord> getAnimal_words_collection() {
        return animal_words_collection;
    }
}
