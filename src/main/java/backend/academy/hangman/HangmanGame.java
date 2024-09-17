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
    private static final String ANIMAL_CATEGORY = "animals";
    private static final String LOCATIONS_CATEGORY = "locations";
    private static final String DEVICES_CATEGORY = "devices";
    private static final String HINT = "hint";
    private static final String ERROR_INPUT = "Something went wrong! Try to reboot the program.";
    private static final int CATEGORIES_NUMBER = 3;
    private static final int DIFFICULTY_LEVEL_NUMBER = 3;
    @Getter private String category;
    private static String word;
    private String hint;
    @Getter private String difficulty;
    private static HangmanStates states;
    private static HashSet<Character> wordByChars;
    private static HashSet<Character> inputLetters;
    private final String[] categories = {"Animals", "Locations", "Devices", "1", "1.", "2", "2.", "3", "3."};
    private final String[] difficultyLevels = {"Easy", "Medium", "Hard", "1", "1.", "2", "2.", "3", "3."};

    public HangmanGame(InputStream inputStream, PrintStream output) {
        states = new HangmanStates();
        wordByChars = new HashSet<>();
        inputLetters = new HashSet<>();
        getUserInput(inputStream, output);
        initUserInput(output);
    }

    private void getUserInput(InputStream inputStream, PrintStream output) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            output.print("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                Welcome to the hangman game! Write the name of the category you want to select:
                """);
            for (int i = 0; i < CATEGORIES_NUMBER; i++) {
                output.println(i + 1 + ". " + categories[i]);
                categories[i] = categories[i].toLowerCase();
            }
            category = reader.readLine();
            category = category.toLowerCase();
            boolean categoryExists = isCategoryExists(category);
            if (!categoryExists) {
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
            for (int i = 0; i < DIFFICULTY_LEVEL_NUMBER; i++) {
                output.println(i + 1 + ". " + difficultyLevels[i]);
                difficultyLevels[i] = difficultyLevels[i].toLowerCase();
            }
            difficulty = reader.readLine();
            difficulty = difficulty.toLowerCase();
            boolean difficultyExists = isDifficultyExists(difficulty);
            if (!difficultyExists) {
                output.print("""
                    Such a difficulty level doesn't exist! It will define randomly!
                    """);
                SecureRandom secureRandom = new SecureRandom();
                int difficultyRandomIndex = secureRandom.nextInt(difficultyLevels.length);
                difficulty = difficultyLevels[difficultyRandomIndex];
                difficulty = difficulty.toLowerCase();
            }
        } catch (IOException e) {
            output.print(e.getMessage());
        }
    }

    private void initUserInput(PrintStream output) {
        switch (difficulty) {
            case "easy", "1", "1.":
                initEasyDifficulty(output, category);
                break;
            case "medium", "2", "2.":
                initMediumDifficulty(output, category);
                break;
            case "hard", "3", "3.":
                initHardDifficulty(output, category);
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

    }

    private void initEasyDifficulty(PrintStream output, String category) {
        switch (category) {
            case ANIMAL_CATEGORY, "1":
                AnimalWord currentWordAnimal = new WordsCollection().getRandomEasyAnimalWord();
                word = currentWordAnimal.getWord();
                hint = currentWordAnimal.getHint();
                break;
            case LOCATIONS_CATEGORY, "2":
                LocationWord currentWordLocation = new WordsCollection().getRandomEasyLocationWord();
                word = currentWordLocation.getWord();
                hint = currentWordLocation.getHint();
                break;
            case DEVICES_CATEGORY, "3":
                DeviceWord currentWordDevice = new WordsCollection().getRandomEasyDeviceWord();
                word = currentWordDevice.getWord();
                hint = currentWordDevice.getHint();
                break;
            default:
                output.print("""
                    Category doesn't exists! Reboot the program
                    """);
                break;
        }
    }

    private void initMediumDifficulty(PrintStream output, String category) {
        switch (category) {
            case ANIMAL_CATEGORY, "1":
                AnimalWord currentWord = new WordsCollection().getRandomMediumAnimalWord();
                word = currentWord.getWord();
                hint = currentWord.getHint();
                break;
            case LOCATIONS_CATEGORY, "2":
                LocationWord currentWordLocation = new WordsCollection().getRandomMediumLocationWord();
                word = currentWordLocation.getWord();
                hint = currentWordLocation.getHint();
                break;
            case DEVICES_CATEGORY, "3":
                DeviceWord currentWordDevice = new WordsCollection().getRandomMediumDeviceWord();
                word = currentWordDevice.getWord();
                hint = currentWordDevice.getHint();
                break;
            default:
                output.print(ERROR_INPUT);
                break;
        }
    }

    private void initHardDifficulty(PrintStream output, String category) {
        switch (category) {
            case ANIMAL_CATEGORY, "1":
                AnimalWord currentWord = new WordsCollection().getRandomHardAnimalWord();
                word = currentWord.getWord();
                hint = currentWord.getHint();
                break;
            case LOCATIONS_CATEGORY, "2":
                LocationWord currentWordLocation = new WordsCollection().getRandomHardLocationWord();
                word = currentWordLocation.getWord();
                hint = currentWordLocation.getHint();
                break;
            case DEVICES_CATEGORY, "3":
                DeviceWord currentWordDevice = new WordsCollection().getRandomHardDeviceWord();
                word = currentWordDevice.getWord();
                hint = currentWordDevice.getHint();
                break;
            default:
                output.print(ERROR_INPUT);
                break;
        }
    }

    private boolean isCategoryExists(String category) {
        for (String currentCategory : categories) {
            if (category.equals(currentCategory)) {
                if (category.equals("1")) {
                    this.category = categories[0];
                }
                if (category.equals("2")) {
                    this.category = categories[1];
                }
                if (category.equals("3")) {
                    this.category = categories[2];
                }
                return true;
            }
        }
        return false;
    }

    private boolean isDifficultyExists(String difficulty) {
        for (String difficultyLevel : difficultyLevels) {
            if (difficulty.equals(difficultyLevel)) {
                return true;
            }
        }
        return false;
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
        while (states.currentState() <= states.attempts()) {
            try {
                String currentInput = reader.readLine();
                currentInput = currentInput.toLowerCase();
                if (currentInput.isEmpty()) {
                    output.print("""
                        Your input is empty!
                        """);
                    continue;
                } else if (!(currentInput.equals(HINT) || currentInput.length() == 1)) {
                    output.print("""
                        Your input is incorrect! You need to write either "hint" or any character!
                        """);
                    continue;
                } else if (currentInput.equals(HINT)) {
                    output.println("""
                        You used the hint! The hint is:
                        """ + hint);
                    continue;
                } else if (!Character.isAlphabetic(currentInput.charAt(0))) {
                    output.print("""
                        Wrong input! You need to write either "hint" or any character!
                        """);
                    continue;
                } else {
                    if (inputLetters.contains(currentInput.charAt(0))) {
                        output.print("""
                            You've already entered this letter! Try another one!
                            """);
                    } else if (wordByChars.contains(currentInput.charAt(0))) {
                        output.print("""
                            Exactly! You guess the letter! Keep going!
                            """);
                        inputLetters.add(currentInput.charAt(0));
                    } else if (!wordByChars.contains(currentInput.charAt(0))
                        && states.currentState() < states.attempts()) {
                        output.print("""
                            Failure! You didn't guess the letter! Try another one!
                            """);
                        inputLetters.add(currentInput.charAt(0));
                        states.incrementCurrentState();
                    } else {
                        output.print("""
                            You wasted all your attempts! You have lost!
                            """);
                        inputLetters.add(currentInput.charAt(0));
                        states.incrementCurrentState();
                    }
                }
                boolean stop = true;
                for (Character currentChar : wordByChars) {
                    if (!inputLetters.contains(currentChar)) {
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
