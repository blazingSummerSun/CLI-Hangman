package backend.academy.hangman;

import java.io.PrintStream;

public class HangmanStates {
    private int current_state;

    public HangmanStates() {
        this.current_state = 0;
    }

    public void displayCurrentState(PrintStream output) {
        switch (current_state) {
            case 0:
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
            case 1:
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
            case 2:
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
            case 3:
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
            case 4:
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
            case 5:
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
            case 6:
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
        }
    }

    public int getCurrentState() {
        return current_state;
    }

    public void setCurrentState(int current_state) {
        this.current_state = current_state;
    }

    public int getAttempts() {
        return 5;
    }

}
