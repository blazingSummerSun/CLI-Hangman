package backend.academy.hangman;

import java.io.PrintStream;
import lombok.Getter;

@Getter public class HangmanStates {
    private static final int STATE_ZERO = 0;
    private static final int STATE_ONE = 1;
    private static final int STATE_TWO = 2;
    private static final int STATE_THREE = 3;
    private static final int STATE_FOUR = 4;
    private static final int STATE_FIVE = 5;
    private static final int STATE_SIX = 6;
    private int currentState;
    private final int attempts = 5;

    public HangmanStates() {
        this.currentState = 0;
    }

    public void displayCurrentState(PrintStream output) {
        switch (currentState) {
            case STATE_ZERO:
                output.print("""
                    |||======================
                    |||                    |
                    |||                    |
                    |||
                    \\|/
                     |
                     |
                     |
                    """);
                break;
            case STATE_ONE:
                output.print("""
                    |||======================
                    |||                    |
                    |||                    |
                    |||                    |
                    \\|/                    O
                     |
                     |
                     |
                    """);
                break;
            case STATE_TWO:
                output.print("""
                    |||======================
                    |||                    |
                    |||                    |
                    |||                    |
                    \\|/                    O
                     |                    /|\\
                     |
                     |
                    """);
                break;
            case STATE_THREE:
                output.print("""
                    |||======================
                    |||                    |
                    |||                    |
                    |||                    |
                    \\|/                    O
                     |                    /|\\
                     |                     |
                     |
                    """);
                break;
            case STATE_FOUR:
                output.print("""
                    |||======================
                    |||                    |
                    |||                    |
                    |||                    |
                    \\|/                    O
                     |                    /|\\
                     |                     |
                     |                    /
                    """);
                break;
            case STATE_FIVE:
                output.print("""
                    |||======================
                    |||                    |
                    |||                    |
                    |||                    |
                    \\|/                    O
                     |                    /|\\
                     |                     |
                     |                    / \\
                    """);
                break;
            case STATE_SIX:
                output.print("""
                    |||======================
                    |||                    |
                    |||                    |
                    |||                    |
                    \\|/                    X
                     |                    /|\\
                     |                     |
                     |                    / \\
                    """);
                break;
            default:
                output.print("""
                    Something went wrong! Try to reboot the program!
                    |||======================
                    |||                    |
                    |||                    |
                    |||                    |
                    \\|/                    X
                     |                    /|\\
                     |                     |
                     |                    / \\
                    """);
        }
    }

    public void incrementCurrentState() {
        currentState++;
    }

}
