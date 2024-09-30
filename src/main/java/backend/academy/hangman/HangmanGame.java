package backend.academy.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashSet;

public final class HangmanGame {
    private static final String HINT = "hint";
    private static String word;
    private String hint;
    private Difficulty difficulty;
    private final HangmanStates states;
    private final HashSet<Character> wordByChars;
    private final HashSet<Character> inputLetters;
    private final WordCategories[] categories;
    private final Difficulty[] difficultyLevels;
    private static final SecureRandom RANDOM = new SecureRandom();
    private final WordsCollection wordsCollection = new WordsCollection();
    private static WordCategories category;

    public HangmanGame() {
        states = new HangmanStates();
        wordByChars = new HashSet<>();
        inputLetters = new HashSet<>();
        categories = WordCategories.values();
        difficultyLevels = Difficulty.values();
    }

    private boolean initWord(PrintStream output) {
        Word randomWord = wordsCollection.getRandomWord(difficulty, category);
        word = randomWord.word();
        hint = randomWord.hint();
        category = randomWord.wordCategories();
        if (word.isEmpty()) {
            output.print("Your word has zero length! Reboot the program");
            return false;
        }
        output.print("""
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            """);
        return true;
    }

    private boolean isInputExists(String input, int type) {
        if (type == 0) {
            for (WordCategories currentCategory : categories) {
                if (input.equals(currentCategory.toString())
                    || input.equals(Integer.toString(currentCategory.ordinal() + 1))) {
                    if (input.equals(Integer.toString(WordCategories.animals.ordinal() + 1))
                        || WordCategories.animals.toString().equals(input)) {
                        category = WordCategories.animals;
                    } else if (input.equals(Integer.toString(WordCategories.locations.ordinal() + 1))
                        || WordCategories.locations.toString().equals(input)) {
                        category = WordCategories.locations;
                    } else {
                        category = WordCategories.devices;
                    }
                    return true;
                }
            }
            return false;
        }
        for (Difficulty difficultyLevel : difficultyLevels) {
            if (input.equals(difficultyLevel.toString())
                || input.equals(Integer.toString(difficultyLevel.ordinal() + 1))) {
                if (input.equals(Integer.toString(Difficulty.easy.ordinal() + 1))
                    || Difficulty.easy.toString().equals(input)) {
                    difficulty = Difficulty.easy;
                } else if (input.equals(Integer.toString(Difficulty.medium.ordinal() + 1))
                    || Difficulty.medium.toString().equals(input)) {
                    difficulty = Difficulty.medium;
                    states.incrementCurrentState();
                } else {
                    difficulty = Difficulty.hard;
                    states.incrementCurrentState();
                    states.incrementCurrentState();
                }
                return true;
            }
        }
        return false;
    }

    private void getUserCategory(InputStream inputStream, PrintStream output) {
        try {
            printCategories(output);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String categoryInput = reader.readLine();
            if (categoryInput != null && categoryInput.isEmpty()) {
                wrongCategory(output, categoryInput);
            } else if (categoryInput != null) {
                categoryInput = categoryInput.toLowerCase();
                String cutCategory = String.copyValueOf(categoryInput.toCharArray());
                if (!categoryInput.isEmpty() && categoryInput.charAt(categoryInput.length() - 1) == '.') {
                    cutCategory = cutCategory.substring(0, cutCategory.length() - 1);
                }
                boolean categoryExists = isInputExists(cutCategory, 0);
                if (!categoryExists) {
                    wrongCategory(output, categoryInput);
                }
            } else {
                wrongCategory(output, "");
            }
        } catch (IOException e) {
            wrongCategory(output, "");
        }
    }

    private void getRandomCategory() {
        category = categories[RANDOM.nextInt(categories.length)];
    }

    private void wrongCategory(PrintStream output, String input) {
        if (input != null && input.isEmpty()) {
            output.print("""
                Your input is empty! The category will define randomly!
                """);
            getRandomCategory();
        } else if (input != null) {
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

    private void wrongDifficulty(PrintStream output, String cutDifficulty) {
        if (cutDifficulty != null && cutDifficulty.isEmpty()) {
            output.print("""
                Your input is empty! The difficulty will define randomly!
                """);
            getRandomDifficulty();
        } else if (cutDifficulty != null) {
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
            String inputDifficulty = reader.readLine();
            if (inputDifficulty != null && inputDifficulty.isEmpty()) {
                wrongDifficulty(output, inputDifficulty);
            } else if (inputDifficulty != null) {
                inputDifficulty = inputDifficulty.toLowerCase();
                String cutDifficulty = String.copyValueOf(inputDifficulty.toCharArray());
                if (cutDifficulty.charAt(cutDifficulty.length() - 1) == '.') {
                    cutDifficulty = cutDifficulty.substring(0, cutDifficulty.length() - 1);
                }
                boolean difficultyExists = isInputExists(cutDifficulty, 1);
                if (!difficultyExists) {
                    wrongDifficulty(output, cutDifficulty);
                }
            } else {
                wrongDifficulty(output, "");
            }
        } catch (Exception e) {
            wrongCategory(output, category.toString());
        }
    }

    private void getRandomDifficulty() {
        difficulty = difficultyLevels[RANDOM.nextInt(difficultyLevels.length)];
        if (Difficulty.medium.toString().equals(difficulty.toString())) {
            states.incrementCurrentState();
        } else if (Difficulty.hard.toString().equals(difficulty.toString())) {
            states.incrementCurrentState();
            states.incrementCurrentState();
        }
    }

    public void launchGame(InputStream inputStream, PrintStream output) {
        getUserCategory(inputStream, output);
        getUserDifficulty(inputStream, output);
        if (!initWord(output)) {
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        for (int i = 0; i < word.length(); i++) {
            wordByChars.add(word.charAt(i));
        }
        output.println("""
            Well-well-well! The game has started right now! Good luck!
            Your category is""" + " " + category.toString());
        output.println("""
            Your difficulty level is""" + " " + difficulty.toString());
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
                if (HINT.equals(currentInput)) {
                    hintState(output);
                } else if (checkInvalidInput(output, currentInput)) {
                    continue;
                } else {
                    guessTheLetter(output, currentInput);
                }
                drawState(output);
                if (isWin(output)) {
                    break;
                }
            } catch (Exception e) {
                drawState(output);
            }
        }
    }

    private void guessTheLetter(PrintStream output, String currentInput) {
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

    private boolean isWin(PrintStream output) {
        boolean stop = true;
        for (Character currentChar : wordByChars) {
            if (!inputLetters.contains(currentChar)) {
                stop = false;
                break;
            }
        }
        if (stop) {
            output.print("""
                Congratulations! You guessed the word!
                """);
            return true;
        }
        return false;
    }

    public void printCategories(PrintStream output) {
        output.print("""
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            Welcome to the hangman game! Write the name of the category you want to select:
            """);
        for (int i = 0; i < WordCategories.values().length; i++) {
            output.println(i + 1 + ". " + categories[i]);
        }
    }

    private void printDifficulties(PrintStream output) {
        output.print("""
            Select the desired difficulty level:
            """);
        for (int i = 0; i < difficultyLevels.length; i++) {
            output.println(i + 1 + ". " + difficultyLevels[i]);
        }
    }

    private boolean checkInvalidInput(PrintStream output, String currentInput) {
        if (!(currentInput.length() == 1)) {
            output.print("""
                Your input is incorrect! You need to write either "hint" or any character!
                """);
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

    private void hintState(PrintStream output) {
        output.println("""
            You used the hint! The hint is:
            """ + hint);
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
