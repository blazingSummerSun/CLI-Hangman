package backend.academy.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.HashSet;
import lombok.Getter;

public class HangmanGame {
    @Getter private String category;
    private static String word;
    private String hint;
    @Getter private String difficulty;
    private static HangmanStates states;
    private static HashSet<Character> wordByChars;
    private static HashSet<Character> inputLetters;

    public HangmanGame(InputStream inputStream, PrintStream output) {
        final String[] categories = {"Animals", "Locations", "Devices"};
        final String[] difficulty_levels = {"Easy", "Medium", "Hard"};
        states = new HangmanStates();
        wordByChars = new HashSet<>();
        inputLetters = new HashSet<>();
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
            if (!(category.equals("animals") || category.equals("locations") || category.equals("devices")
                || category.equals("1") || category.equals("2") || category.equals("3"))) {
                SecureRandom secureRandom = new SecureRandom();
                int categoryRandomIndex = secureRandom.nextInt(categories.length);
                category = categories[categoryRandomIndex];
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
                int difficultyRandomIndex = secureRandom.nextInt(difficulty_levels.length);
                difficulty = difficulty_levels[difficultyRandomIndex];
                difficulty = difficulty.toLowerCase();
            }
            switch (difficulty) {
                case "easy", "1":
                    switch (category) {
                        case "animals", "1":
                            AnimalWord currentWordAnimal = new WordsCollection().getRandomEasyAnimalWord();
                            word = currentWordAnimal.getWord();
                            hint = currentWordAnimal.getHint();
                            break;
                        case "locations", "2":
                            LocationWord currentWordLocation = new WordsCollection().getRandomEasyLocationWord();
                            word = currentWordLocation.getWord();
                            hint = currentWordLocation.getHint();
                            break;
                        case "devices", "3":
                            DeviceWord currentWordDevice = new WordsCollection().getRandomEasyDeviceWord();
                            word = currentWordDevice.getWord();
                            hint = currentWordDevice.getHint();
                            break;
                        default:
                            output.print("""
                                Something went wrong! Reboot the program.
                                """);
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
                            LocationWord currentWordLocation = new WordsCollection().getRandomMediumLocationWord();
                            word = currentWordLocation.getWord();
                            hint = currentWordLocation.getHint();
                            break;
                        case "devices", "3":
                            DeviceWord currentWordDevice = new WordsCollection().getRandomMediumDeviceWord();
                            word = currentWordDevice.getWord();
                            hint = currentWordDevice.getHint();
                            break;
                        default:
                            output.print("""
                                Something went wrong! Reboot the program.
                                """);
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
                            LocationWord currentWordLocation = new WordsCollection().getRandomHardLocationWord();
                            word = currentWordLocation.getWord();
                            hint = currentWordLocation.getHint();
                            break;
                        case "devices", "3":
                            DeviceWord currentWordDevice = new WordsCollection().getRandomHardDeviceWord();
                            word = currentWordDevice.getWord();
                            hint = currentWordDevice.getHint();
                            break;
                        default:
                            output.print("""
                                Something went wrong! Reboot the program.
                                """);
                            break;
                    }
                    break;
                default:
                    output.print("""
                        Something went wrong! Reboot the program.
                        """);
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
            wordByChars.add(word.charAt(i));
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
                    if (inputLetters.contains(current_input.charAt(0))) {
                        output.print("""
                            You've already entered this letter! Try another one!
                            """);
                    } else if (wordByChars.contains(current_input.charAt(0))) {
                        output.print("""
                            Exactly! You guess the letter! Keep going!
                            """);
                        inputLetters.add(current_input.charAt(0));
                    } else if (!wordByChars.contains(current_input.charAt(0))
                        && states.getCurrentState() < states.getAttempts()) {
                        output.print("""
                            Failure! You didn't guess the letter! Try another one!
                            """);
                        inputLetters.add(current_input.charAt(0));
                        states.setCurrentState(states.getCurrentState() + 1);
                    } else {
                        output.print("""
                            You wasted all your attempts! You have lost!
                            """);
                        inputLetters.add(current_input.charAt(0));
                        states.setCurrentState(states.getCurrentState() + 1);
                    }
                }
                boolean stop = true;
                for (Character current_char : wordByChars) {
                    if (!inputLetters.contains(current_char)) {
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
            if (inputLetters.contains(word.charAt(i))) {
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
