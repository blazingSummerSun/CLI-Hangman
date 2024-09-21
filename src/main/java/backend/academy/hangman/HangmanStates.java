package backend.academy.hangman;

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

    public String displayCurrentState() {
        return switch (currentState) {
            case STATE_ZERO -> ("""
                |||======================
                |||                    |
                |||                    |
                |||
                \\|/
                 |
                 |
                 |
                """);
            case STATE_ONE -> ("""
                |||======================
                |||                    |
                |||                    |
                |||                    |
                \\|/                    O
                 |
                 |
                 |
                """);
            case STATE_TWO -> ("""
                |||======================
                |||                    |
                |||                    |
                |||                    |
                \\|/                    O
                 |                    /|\\
                 |
                 |
                """);
            case STATE_THREE -> ("""
                |||======================
                |||                    |
                |||                    |
                |||                    |
                \\|/                    O
                 |                    /|\\
                 |                     |
                 |
                """);
            case STATE_FOUR -> ("""
                |||======================
                |||                    |
                |||                    |
                |||                    |
                \\|/                    O
                 |                    /|\\
                 |                     |
                 |                    /
                """);
            case STATE_FIVE -> ("""
                |||======================
                |||                    |
                |||                    |
                |||                    |
                \\|/                    O
                 |                    /|\\
                 |                     |
                 |                    / \\
                """);
            case STATE_SIX -> ("""
                |||======================
                |||                    |
                |||                    |
                |||                    |
                \\|/                    X
                 |                    /|\\
                 |                     |
                 |                    / \\
                """);
            default -> ("""
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
        };
    }

    public void incrementCurrentState() {
        currentState++;
    }

    public String attemptsLeft() {
        return (attempts() - currentState() + 1 + " " + """
            attempts left!
            """);
    }

}
