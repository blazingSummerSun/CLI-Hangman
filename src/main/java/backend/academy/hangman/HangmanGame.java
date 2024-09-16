package backend.academy.hangman;

import lombok.Getter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.HashSet;

public class HangmanGame {
    @Getter private String category;
    private static String word;
    private String hint;
    @Getter private String difficulty;
    private static HangmanStates states;
    private static HashSet<Character> word_by_chars;
    private static HashSet<Character> input_letters;

    public HangmanGame(InputStream inputStream, PrintStream output) {
        final String[] categories = {"Animals", "Locations", "Devices"};
        final String[] difficulty_levels = {"Easy", "Medium", "Hard"};
        states = new HangmanStates();
        word_by_chars = new HashSet<>();
        input_letters = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            output.print("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                Welcome to the hangman game! Write the name of the category you want to select:
                """);
            for (int i = 0; i < categories.length; i++) {
                output.println(i + 1 + ". " + categories[i]);
            }
            category = reader.readLine();
            category = category.toLowerCase();
            if (!(category.equals("animals") || category.equals("locations") || category.equals("devices") ||
                category.equals("1")
                || category.equals("2") || category.equals("3"))) {
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
                """);
            for (int i = 0; i < difficulty_levels.length; i++) {
                output.println(i + 1 + ". " + difficulty_levels[i]);
            }
            difficulty = reader.readLine();
            difficulty = difficulty.toLowerCase();
            if (!(difficulty.equals("easy") || difficulty.equals("medium") || difficulty.equals("hard")
                || difficulty.equals("1") || difficulty.equals("2") || difficulty.equals("3"))) {
                output.print("""
                    Such a difficulty level doesn't exist! It will define randomly!
                    """);
                SecureRandom secureRandom = new SecureRandom();
                int difficulty_random_index = secureRandom.nextInt(difficulty_levels.length);
                difficulty = difficulty_levels[difficulty_random_index];
                difficulty = difficulty.toLowerCase();
            }
            switch (difficulty) {
                case "easy", "1":
                    switch (category) {
                        case "animals", "1":
                            AnimalWord current_word_animal = new WordsCollection().getRandomEasyAnimalWord();
                            word = current_word_animal.getWord();
                            hint = current_word_animal.getHint();
                            break;
                        case "locations", "2":
                            LocationWord current_word_location = new WordsCollection().getRandomEasyLocationWord();
                            word = current_word_location.getWord();
                            hint = current_word_location.getHint();
                            break;
                        case "devices", "3":
                            DeviceWord current_word_device = new WordsCollection().getRandomEasyDeviceWord();
                            word = current_word_device.getWord();
                            hint = current_word_device.getHint();
                            break;
                    }
                    break;
                case "medium", "2":
                    switch (category) {
                        case "animals", "1":
                            AnimalWord current_word = new WordsCollection().getRandomMediumAnimalWord();
                            word = current_word.getWord();
                            hint = current_word.getHint();
                            break;
                        case "locations", "2":
                            LocationWord current_word_location = new WordsCollection().getRandomMediumLocationWord();
                            word = current_word_location.getWord();
                            hint = current_word_location.getHint();
                            break;
                        case "devices", "3":
                            DeviceWord current_word_device = new WordsCollection().getRandomMediumDeviceWord();
                            word = current_word_device.getWord();
                            hint = current_word_device.getHint();
                            break;
                    }
                    break;
                case "hard", "3":
                    switch (category) {
                        case "animals", "1":
                            AnimalWord current_word = new WordsCollection().getRandomHardAnimalWord();
                            word = current_word.getWord();
                            hint = current_word.getHint();
                            break;
                        case "locations", "2":
                            LocationWord current_word_location = new WordsCollection().getRandomHardLocationWord();
                            word = current_word_location.getWord();
                            hint = current_word_location.getHint();
                            break;
                        case "devices", "3":
                            DeviceWord current_word_device = new WordsCollection().getRandomHardDeviceWord();
                            word = current_word_device.getWord();
                            hint = current_word_device.getHint();
                            break;
                    }
                    break;
            }
            output.print("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                """);
            category = category.substring(0, 1).toUpperCase() + category.substring(1);
            difficulty = difficulty.substring(0, 1).toUpperCase() + difficulty.substring(1);
        } catch (IOException e) {
            output.println(e.getMessage());
        }
    }

    public void launchGame(InputStream inputStream, PrintStream output) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        for (int i = 0; i < word.length(); i++) {
            word_by_chars.add(word.charAt(i));
        }
        output.println("""
            Well-well-well! The game has started right now! Good luck!
            Your category is""" + " " + category);
        output.println("""
            Your difficulty level is""" + " " + difficulty);
        output.print("""
            Start typing character by character or write "hint" to get the hint!
            """);
        drawState(output);
        while (states.getCurrentState() <= states.getAttempts()) {
            try {
                String current_input = reader.readLine();
                current_input = current_input.toLowerCase();
                if (current_input.isEmpty()) {
                    output.print("""
                        Your input is empty!
                        """);
                    continue;
                } else if (!(current_input.equals("hint") || current_input.length() == 1)) {
                    output.print("""
                        Your input is incorrect! You need to write either "hint" or any character!
                        """);
                    continue;
                } else if (current_input.equals("hint")) {
                    output.println("""
                        You used the hint! The hint is:
                        """ + hint);
                    continue;
                } else if (!Character.isAlphabetic(current_input.charAt(0))) {
                    output.print("""
                        Wrong input! You need to write either "hint" or any character!
                        """);
                    continue;
                } else {
                    if (input_letters.contains(current_input.charAt(0))) {
                        output.print("""
                            You've already entered this letter! Try another one!
                            """);
                    } else if (word_by_chars.contains(current_input.charAt(0))) {
                        output.print("""
                            Exactly! You guess the letter! Keep going!
                            """);
                        input_letters.add(current_input.charAt(0));
                    } else if (!word_by_chars.contains(current_input.charAt(0)) &&
                        states.getCurrentState() < states.getAttempts()) {
                        output.print("""
                            Failure! You didn't guess the letter! Try another one!
                            """);
                        input_letters.add(current_input.charAt(0));
                        states.setCurrentState(states.getCurrentState() + 1);
                    } else {
                        output.print("""
                            You wasted all your attempts! You have lost!
                            """);
                        input_letters.add(current_input.charAt(0));
                        states.setCurrentState(states.getCurrentState() + 1);
                    }
                }
                boolean stop = true;
                for (Character current_char : word_by_chars) {
                    if (!input_letters.contains(current_char)) {
                        stop = false;
                        break;
                    }
                }
                drawState(output);
                if (stop) {
                    output.print("""
                        Congratulations! You guessed the word!
                        """);
                    break;
                }
            } catch (Exception e) {
                output.println(e.getMessage());
            }
        }
    }

    private static void drawState(PrintStream output) {
        states.displayCurrentState(output);
        for (int i = 0; i < word.length(); i++) {
            if (input_letters.contains(word.charAt(i))) {
                output.print(word.charAt(i) + " ");
            } else {
                output.print("_ ");
            }
            if (i == word.length() - 1) {
                output.println();
            }
        }
    }

}
