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

public final class HangmanGame {
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

    private void initWord() {
        Word randomWord = new WordsCollection().getRandomWord(difficulty, category);
        word = randomWord.word();
        hint = randomWord.hint();
    }

    private boolean isInputExists(String input, int type) {
        if (type == 0) {
            for (String currentCategory : categories) {
                if (input.equals(currentCategory)) {
                    if (ANIMAL_CATEGORY_INDEX.equals(input)) {
                        this.category = categories[Integer.parseInt(currentCategory) - 1];
                    }
                    if (LOCATIONS_CATEGORY_INDEX.equals(input)) {
                        this.category = categories[Integer.parseInt(currentCategory) - 1];
                    }
                    if (DEVICES_CATEGORY_INDEX.equals(input)) {
                        this.category = categories[Integer.parseInt(currentCategory) - 1];
                    }
                    return true;
                }
            }
            return false;
        }
        for (String difficultyLevel : difficultyLevels) {
            if (input.equals(difficultyLevel)) {
                if (EASY_DIFFICULTY_INDEX.equals(input)) {
                    this.difficulty = difficultyLevels[Integer.parseInt(difficultyLevel) - 1];
                }
                if (MEDIUM_DIFFICULTY_INDEX.equals(input)
                    || difficultyLevels[Integer.parseInt(MEDIUM_DIFFICULTY_INDEX) - 1].equals(difficultyLevel)) {
                    this.difficulty = difficultyLevels[Integer.parseInt(difficultyLevel) - 1];
                    states.incrementCurrentState();
                }
                if (HARD_DIFFICULTY_INDEX.equals(input)
                    || difficultyLevels[Integer.parseInt(HARD_DIFFICULTY_INDEX) - 1].equals(difficultyLevel)) {
                    this.difficulty = difficultyLevels[Integer.parseInt(difficultyLevel) - 1];
                    states.incrementCurrentState();
                    states.incrementCurrentState();
                }
                return true;
            }
        }
        return false;
    }

    private boolean isWordEmpty(String word) {
        return word.isEmpty();
    }

    private void getUserCategory(InputStream inputStream, PrintStream output) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            category = reader.readLine();
            if (category != null && category.isEmpty()) {
                category = category.toLowerCase();
                wrongCategory(output);
            } else if (category != null) {
                category = category.toLowerCase();
                String cutCategory = String.copyValueOf(difficulty.toCharArray());
                if (!category.isEmpty() && category.charAt(category.length() - 1) == '.') {
                    cutCategory = cutCategory.substring(0, cutCategory.length() - 1);
                }
                boolean categoryExists = isInputExists(cutCategory, 0);
                if (!categoryExists) {
                    getRandomCategory();
                    wrongCategory(output);
                }
            } else {
                wrongCategory(output);
            }
        } catch (IOException e) {
            wrongCategory(output);
        }
    }

    private void getRandomCategory() {
        int categoryRandomIndex = RANDOM.nextInt(CATEGORIES_NUMBER);
        category = categories[categoryRandomIndex];
        category = category.toLowerCase();
    }

    private void wrongCategory(PrintStream output) {
        if (category != null && category.isEmpty()) {
            output.print("""
                Your input is empty! The category will define randomly!
                """);
            getRandomCategory();
        } else if (category != null) {
            output.print("""
                Such a category doesn't exist! It will define randomly!
                """);
            getRandomCategory();
        } else {
            output.print("""
                Something wrong with category! Try to reboot the program!
                """);
        }

    }

    private void wrongDifficulty(PrintStream output) {
        if (difficulty != null && difficulty.isEmpty()) {
            output.print("""
                Your input is empty! The difficulty will define randomly!
                """);
            getRandomDifficulty();
        } else if (difficulty != null) {
            output.print("""
                Such a difficulty level doesn't exist! It will define randomly!
                """);
            getRandomDifficulty();
        } else {
            output.print("""
                Something wrong with difficulty level! Try to reboot the program!
                """);
        }
    }

    private void getUserDifficulty(InputStream inputStream, PrintStream output) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            printDifficulties(output);
            difficulty = reader.readLine();
            if (difficulty != null && difficulty.isEmpty()) {
                wrongDifficulty(output);
            } else if (difficulty != null) {
                String cutDifficulty = String.copyValueOf(difficulty.toCharArray());
                if (cutDifficulty.charAt(cutDifficulty.length() - 1) == '.') {
                    cutDifficulty = cutDifficulty.substring(0, cutDifficulty.length() - 1);
                }
                difficulty = difficulty.toLowerCase();
                boolean difficultyExists = isInputExists(cutDifficulty, 1);
                if (!difficultyExists) {
                    getRandomDifficulty();
                    wrongDifficulty(output);
                }
            } else {
                wrongDifficulty(output);
            }
        } catch (Exception e) {
            wrongCategory(output);
        }
    }

    private void getRandomDifficulty() {
        int difficultyRandomIndex = RANDOM.nextInt(DIFFICULTY_LEVEL_NUMBER);
        difficulty = difficultyLevels[difficultyRandomIndex];
        difficulty = difficulty.toLowerCase();
    }

    public void launchGame(InputStream inputStream, PrintStream output) {
        printCategories(output);
        getUserCategory(inputStream, output);
        getUserDifficulty(inputStream, output);
        initWord();
        output.print("""
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            """);
        if (isWordEmpty(word)) {
            output.print("Your word has zero length! Reboot the program");
            return;
        }
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

    public void printCategories(PrintStream output) {
        output.print("""
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            Welcome to the hangman game! Write the name of the category you want to select:
            """);
        for (int i = 0; i < CATEGORIES_NUMBER; i++) {
            output.println(i + 1 + ". " + categories[i]);
            categories[i] = categories[i].toLowerCase();
        }
    }

    private void printDifficulties(PrintStream output) {
        output.print("""
            Select the desired difficulty level:
            """);
        for (int i = 0; i < DIFFICULTY_LEVEL_NUMBER; i++) {
            output.println(i + 1 + ". " + difficultyLevels[i]);
            difficultyLevels[i] = difficultyLevels[i].toLowerCase();
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
