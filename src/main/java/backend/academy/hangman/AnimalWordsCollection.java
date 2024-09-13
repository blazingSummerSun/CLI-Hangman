package backend.academy.hangman;

import java.util.HashMap;

public class AnimalWordsCollection {
    private final HashMap<String, AnimalWord> animal_words_collection_easy;
    private final HashMap<String, AnimalWord> animal_words_collection_medium;
    private final HashMap<String, AnimalWord> animal_words_collection_hard;

    public AnimalWordsCollection() {
        animal_words_collection_easy = new HashMap<>();
        animal_words_collection_medium = new HashMap<>();
        animal_words_collection_hard = new HashMap<>();
        setAnimal_words_collection_easy();
    }

    private void setAnimal_words_collection_easy() {
        AnimalWord cow = new AnimalWord("Cow", "Farm animal");
        AnimalWord hyena = new AnimalWord("Hyena", "Carnivorous animal");
        AnimalWord giraffe = new AnimalWord("Giraffe", "Animal with the longest neck");
        animal_words_collection_easy.put("Cow", cow);
        animal_words_collection_easy.put("Hyena", hyena);
        animal_words_collection_easy.put("Giraffe", giraffe);
    }

    private void setAnimal_words_collection_medium() {
        AnimalWord capybara = new AnimalWord("Capybara", "The friendliest animal");
        AnimalWord raccoon = new AnimalWord("Raccoon", "Distinctive dark markings on their faces");
        AnimalWord peacock = new AnimalWord("Peacock", "Animal with sea green `eyes` on its tail");
        animal_words_collection_medium.put("Capybara", capybara);
        animal_words_collection_medium.put("Raccoon", raccoon);
        animal_words_collection_medium.put("Peacock", peacock);
    }

    private void setAnimal_words_collection_hard() {
        AnimalWord chinchilla = new AnimalWord("Chinchilla", "Cute animal");
        animal_words_collection_hard.put("Chinchilla", chinchilla);
    }

    public HashMap<String, AnimalWord> getAnimal_words_collection_easy() {
        return animal_words_collection_easy;
    }
}
