package backend.academy;

import backend.academy.hangman.HangmanGame;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.launchGame(System.in, System.out);
    }
}
