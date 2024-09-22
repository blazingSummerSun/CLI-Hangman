package backend.academy.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashSet;
import lombok.Getter;

public class HangmanGame {
    private static final String ANIMAL_CATEGORY = "animals";
    private static final String LOCATIONS_CATEGORY = "locations";
    private static final String DEVICES_CATEGORY = "devices";
    private static final String HINT = "hint";
    private static final int CATEGORIES_NUMBER = 3;
    private static final int DIFFICULTY_LEVEL_NUMBER = 3;
    private static final String ANIMAL_CATEGORY_INDEX = "1";
    private static final String LOCATIONS_CATEGORY_INDEX = "2";
    private static final String DEVICES_CATEGORY_INDEX = "3";
    private static final String EASY_DIFFICULTY_INDEX = "1";
    private static final String MEDIUM_DIFFICULTY_INDEX = "2";
    private static final String HARD_DIFFICULTY_INDEX = "3";
    @Getter private String category;
    private static String word;
    private String hint;
    @Getter private String difficulty;
    private final HangmanStates states;
    private final HashSet<Character> wordByChars;
    private final HashSet<Character> inputLetters;
    private final String[] categories = {"Animals", "Locations", "Devices", "1", "2", "3"};
    private final String[] difficultyLevels = {"Easy", "Medium", "Hard", "1", "2", "3"};
    private static final SecureRandom RANDOM = new SecureRandom();

    public HangmanGame() {
        states = new HangmanStates();
        wordByChars = new HashSet<>();
        inputLetters = new HashSet<>();
    }

    private void getUserInput(InputStream inputStream, PrintStream output) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            output.print("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                Welcome to the hangman game! Write the name of the category you want to select:
                """);
            for (int i = 0; i < CATEGORIES_NUMBER; i++) {
                output.println(i + 1 + ". " + categories[i]);
                categories[i] = categories[i].toLowerCase();
            }
            boolean categoryExists = false;
            category = reader.readLine();
            if (category != null && category.isEmpty()) {
                output.print("""
                    Your input is empty! The category will define randomly!
                    """);
            } else if (category != null) {
                category = category.toLowerCase();
                categoryExists = isCategoryExists(category);
            }
            if (!categoryExists) {
                int categoryRandomIndex = RANDOM.nextInt(CATEGORIES_NUMBER);
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
            boolean difficultyExists = false;
            if (difficulty != null && difficulty.isEmpty()) {
                output.print("""
                    Your input is empty! The difficulty will define randomly!
                    """);
            } else if (difficulty != null) {
                difficulty = difficulty.toLowerCase();
                difficultyExists = isDifficultyExists(difficulty);
                difficulty = difficulty.toLowerCase();
            }
            if (!difficultyExists) {
                output.print("""
                    Such a difficulty level doesn't exist! It will define randomly!
                    """);
                int difficultyRandomIndex = RANDOM.nextInt(DIFFICULTY_LEVEL_NUMBER);
                difficulty = difficultyLevels[difficultyRandomIndex];
                difficulty = difficulty.toLowerCase();
            }
        } catch (IOException e) {
            output.print(e.getMessage());
        }
    }

    private void initUserInput(PrintStream output) {
        switch (difficulty) {
            case "easy", "1":
                initEasyDifficulty(output, category);
                break;
            case "medium", "2":
                initMediumDifficulty(output, category);
                break;
            case "hard", "3":
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
                output.print(states.invalidState());
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
                output.print(states.invalidState());
                break;
        }
    }

    private boolean isCategoryExists(String category) {
        String cutCategory = category;
        if (cutCategory.charAt(cutCategory.length() - 1) == '.') {
            cutCategory = cutCategory.substring(0, cutCategory.length() - 1);
        }
        for (String currentCategory : categories) {
            if (cutCategory.equals(currentCategory)) {
                if (ANIMAL_CATEGORY_INDEX.equals(cutCategory)) {
                    this.category = categories[Integer.parseInt(currentCategory) - 1];
                }
                if (LOCATIONS_CATEGORY_INDEX.equals(cutCategory)) {
                    this.category = categories[Integer.parseInt(currentCategory) - 1];
                }
                if (DEVICES_CATEGORY_INDEX.equals(cutCategory)) {
                    this.category = categories[Integer.parseInt(currentCategory) - 1];
                }
                return true;
            }
        }
        return false;
    }

    private boolean isDifficultyExists(String difficulty) {
        String cutDifficulty = difficulty;
        if (cutDifficulty.charAt(cutDifficulty.length() - 1) == '.') {
            cutDifficulty = cutDifficulty.substring(0, cutDifficulty.length() - 1);
        }
        for (String difficultyLevel : difficultyLevels) {
            if (cutDifficulty.equals(difficultyLevel)) {
                if (EASY_DIFFICULTY_INDEX.equals(cutDifficulty)) {
                    this.difficulty = difficultyLevels[Integer.parseInt(difficultyLevel) - 1];
                }
                if (MEDIUM_DIFFICULTY_INDEX.equals(cutDifficulty)) {
                    this.difficulty = difficultyLevels[Integer.parseInt(difficultyLevel) - 1];
                }
                if (HARD_DIFFICULTY_INDEX.equals(cutDifficulty)) {
                    this.difficulty = difficultyLevels[Integer.parseInt(difficultyLevel) - 1];
                }
                return true;
            }
        }
        return false;
    }

    public void launchGame(InputStream inputStream, PrintStream output) {
        getUserInput(inputStream, output);
        initUserInput(output);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
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
        output.print(states.attemptsLeft());
        drawState(output);
        while (states.currentState() <= states.attempts()) {
            try {
                String currentInput = reader.readLine();
                if (currentInput != null) {
                    currentInput = currentInput.toLowerCase();
                } else {
                    output.print("""
                        Your input is empty!
                        """);
                    output.print(states.attemptsLeft());
                    continue;
                }
                if (checkInvalidInput(output, currentInput)) {
                    continue;
                } else {
                    if (inputLetters.contains(currentInput.charAt(0))) {
                        output.print("""
                            You've already entered this letter! Try another one!
                            """);
                        output.print(states.attemptsLeft());
                    } else if (wordByChars.contains(currentInput.charAt(0))) {
                        output.print("""
                            Exactly! You guess the letter! Keep going!
                            """);
                        inputLetters.add(currentInput.charAt(0));
                        output.print(states.attemptsLeft());
                    } else if (!wordByChars.contains(currentInput.charAt(0))
                        && states.currentState() < states.attempts()) {
                        output.print("""
                            Failure! You didn't guess the letter! Try another one!
                            """);
                        inputLetters.add(currentInput.charAt(0));
                        states.incrementCurrentState();
                        output.print(states.attemptsLeft());
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

    private boolean checkInvalidInput(PrintStream output, String currentInput) {
        if (!(HINT.equals(currentInput) || currentInput.length() == 1)) {
            output.print("""
                Your input is incorrect! You need to write either "hint" or any character!
                """);
            drawState(output);
            return true;
        } else if (HINT.equals(currentInput)) {
            output.println("""
                You used the hint! The hint is:
                """ + hint);
            drawState(output);
            return true;
        } else if (!Character.isAlphabetic(currentInput.charAt(0))) {
            output.print("""
                Wrong input! You need to write either "hint" or any character!
                """);
            output.print(states.attemptsLeft());
            drawState(output);
            return true;
        }
        return false;
    }

    private void drawState(PrintStream output) {
        output.print(states.displayCurrentState());
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
