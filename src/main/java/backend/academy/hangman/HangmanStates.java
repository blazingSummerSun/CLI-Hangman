package backend.academy.hangman;

import java.io.PrintStream;

public class HangmanStates {
    private final int attempts = 5;
    private int current_state;
    public HangmanStates() {
        this.current_state = 0;
    }
    public void getCurrentState(PrintStream output) {
        switch (current_state) {
            case 0: output.print("""
                -------------------------
                |||                    |
                |||                    |
                |||                    |
                \\|/                   |
                 |                     |
                """);
            break;
            case 1: output.print("""
                case 1
                """);
            break;
            case 2: output.print("""
                case 2
                """);
            break;
            case 3: output.print("""
                case 3
                """);
            break;
            case 4: output.print("""
                case 4
                """);
            break;
        }
    }
    public void invalidAttempt(){
        current_state++;
    }
    public int getAttempts() {
        return attempts;
    }
}
