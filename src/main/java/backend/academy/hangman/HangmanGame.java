package backend.academy.hangman;

import lombok.Getter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;

public class HangmanGame {
    @Getter private String category;
    private String word;
    private String hint;
    @Getter private String difficulty;
    private int current_state;

    public HangmanGame(InputStream inputStream, PrintStream output) {
        final String[] categories = {"Animals", "Locations", "Devices"};
        this.current_state = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            output.print("""
                Welcome to the hangman game! Write the name of the category you want to select:
                """);
            for(int i = 0; i < categories.length; i++) {
                output.println(i+1 + ". " + categories[i]);
            }
            category = reader.readLine();
            category = category.toLowerCase();
            if (!(category.equals("animals") || category.equals("locations") || category.equals("devices"))) {
                SecureRandom secureRandom = new SecureRandom();
                int category_random_index = secureRandom.nextInt(categories.length);
                category = categories[category_random_index];
                category = category.toLowerCase();
                output.print("""
                    Such a category doesn't exist! It will define randomly!
                    """);
            }
            output.print("""
                Select the desired difficulty level:
                1. Easy
                2. Medium
                3. Hard
                """);
            difficulty = reader.readLine();
            difficulty = difficulty.toLowerCase();
            if (!(difficulty.equals("easy") || difficulty.equals("medium") || difficulty.equals("hard"))) {
                output.print("""
                    Such a difficulty level doesn't exist! It will define randomly!
                    """);
                SecureRandom secureRandom = new SecureRandom();
                int difficulty_random_index = secureRandom.nextInt(categories.length);
                category = categories[difficulty_random_index];
                difficulty = difficulty.toLowerCase();
            }
            switch (difficulty) {
                case "easy":
                    switch (category) {
                        case "animals":
                            AnimalWord current_word_animal = new WordsCollection().getRandomEasyAnimalWord();
                            word = current_word_animal.getWord();
                            hint = current_word_animal.getHint();
                            break;
                        case "locations":
                            LocationWord current_word_location = new WordsCollection().getRandomEasyLocationWord();
                            word = current_word_location.getWord();
                            hint = current_word_location.getHint();
                            break;
                        case "devices":
                            DeviceWord current_word_device = new WordsCollection().getRandomEasyDeviceWord();
                            word = current_word_device.getWord();
                            hint = current_word_device.getHint();
                            break;
                    }
                    break;
                case "medium":
                    switch (category) {
                        case "animals":
                            AnimalWord current_word = new WordsCollection().getRandomMediumAnimalWord();
                            word = current_word.getWord();
                            hint = current_word.getHint();
                            break;
                        case "locations":
                            LocationWord current_word_location = new WordsCollection().getRandomMediumLocationWord();
                            word = current_word_location.getWord();
                            hint = current_word_location.getHint();
                            break;
                        case "devices":
                            DeviceWord current_word_device = new WordsCollection().getRandomMediumDeviceWord();
                            word = current_word_device.getWord();
                            hint = current_word_device.getHint();
                            break;
                    }
                    break;
                case "hard":
                    switch (category) {
                        case "animals":
                            AnimalWord current_word = new WordsCollection().getRandomHardAnimalWord();
                            word = current_word.getWord();
                            hint = current_word.getHint();
                            break;
                        case "locations":
                            LocationWord current_word_location = new WordsCollection().getRandomHardLocationWord();
                            word = current_word_location.getWord();
                            hint = current_word_location.getHint();
                            break;
                        case "devices":
                            DeviceWord current_word_device = new WordsCollection().getRandomHardDeviceWord();
                            word = current_word_device.getWord();
                            hint = current_word_device.getHint();
                            break;
                    }
                    break;
            }
            System.out.println(word);
            System.out.println(hint);
        } catch (IOException e) {
            output.println(e.getMessage());
        }
    }

    public void launchGame(InputStream inputStream, PrintStream output) {
        HangmanStates states = new HangmanStates();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (current_state != states.getAttempts()) {
            try {
                char current_char = reader.readLine().charAt(0);

            } catch (Exception e) {
                output.println(e.getMessage());
            }
        }
    }

}
