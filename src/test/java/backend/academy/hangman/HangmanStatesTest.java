package backend.academy.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanStatesTest {
    @Test
    void shouldReturnZeroState() {
        HangmanStates hangmanStates = new HangmanStates();
        String currentState = ("""
            |||======================
            |||                    |
            |||                    |
            |||
            \\|/
             |
             |
             |
            """);
        assertEquals(currentState, hangmanStates.displayCurrentState());
    }

    @Test
    void shouldReturnFirstState() {
        HangmanStates hangmanStates = new HangmanStates();
        hangmanStates.incrementCurrentState();
        String currentState = ("""
            |||======================
            |||                    |
            |||                    |
            |||                    |
            \\|/                    O
             |
             |
             |
            """);
        assertEquals(currentState, hangmanStates.displayCurrentState());
    }

    @Test
    void shouldReturnSecondState() {
        HangmanStates hangmanStates = new HangmanStates();
        hangmanStates.incrementCurrentState();
        hangmanStates.incrementCurrentState();
        String currentState = ("""
            |||======================
            |||                    |
            |||                    |
            |||                    |
            \\|/                    O
             |                    /|\\
             |
             |
            """);
        assertEquals(currentState, hangmanStates.displayCurrentState());
    }

    @Test
    void shouldReturnThirdState() {
        HangmanStates hangmanStates = new HangmanStates();
        for (int i = 0; i < 3; i++) {
            hangmanStates.incrementCurrentState();
        }
        String currentState = ("""
            |||======================
            |||                    |
            |||                    |
            |||                    |
            \\|/                    O
             |                    /|\\
             |                     |
             |
            """);
        assertEquals(currentState, hangmanStates.displayCurrentState());
    }

    @Test
    void shouldReturnFourthState() {
        HangmanStates hangmanStates = new HangmanStates();
        for (int i = 0; i < 4; i++) {
            hangmanStates.incrementCurrentState();
        }
        String currentState = ("""
            |||======================
            |||                    |
            |||                    |
            |||                    |
            \\|/                    O
             |                    /|\\
             |                     |
             |                    /
            """);
        assertEquals(currentState, hangmanStates.displayCurrentState());
    }

    @Test
    void shouldReturnFifthState() {
        HangmanStates hangmanStates = new HangmanStates();
        for (int i = 0; i < 5; i++) {
            hangmanStates.incrementCurrentState();
        }
        String currentState = ("""
            |||======================
            |||                    |
            |||                    |
            |||                    |
            \\|/                    O
             |                    /|\\
             |                     |
             |                    / \\
            """);
        assertEquals(currentState, hangmanStates.displayCurrentState());
    }

    @Test
    void shouldReturnSixthState() {
        HangmanStates hangmanStates = new HangmanStates();
        for (int i = 0; i < 6; i++) {
            hangmanStates.incrementCurrentState();
        }
        String currentState = ("""
            |||======================
            |||                    |
            |||                    |
            |||                    |
            \\|/                    X
             |                    /|\\
             |                     |
             |                    / \\
            """);
        assertEquals(currentState, hangmanStates.displayCurrentState());
    }

}
