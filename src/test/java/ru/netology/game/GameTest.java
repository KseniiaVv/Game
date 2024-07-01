package ru.netology.game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void WhenFirstPlayerWin() {
        Game game = new Game();
        Player Anna = new Player(125, "Анна", 180);
        Player Victoria = new Player(140, "Виктория", 140);

        game.register(Anna);
        game.register(Victoria);
        int actual = game.round("Анна", "Виктория");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenSecondPlayerWin() {
        Game game = new Game();
        Player Anna = new Player(125, "Анна", 140);
        Player Victoria = new Player(140, "Виктория", 180);

        game.register(Anna);
        game.register(Victoria);
        int actual = game.round("Анна", "Виктория");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenStrengthsEqual() {
        Game game = new Game();
        Player Anna = new Player(125, "Анна", 100);
        Player Victoria = new Player(140, "Виктория", 100);

        game.register(Anna);
        game.register(Victoria);
        int actual = game.round("Анна", "Виктория");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void WhenFirstPlayerNotExist() {
        Game game = new Game();
        Player Anna = new Player(125, "Анна", 100);


        game.register(Anna);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Анна", "Егор")
        );
    }

    @Test
    public void WhenSecondPlayerNotExist() {
        Game game = new Game();
        Player Victoria = new Player(140, "Виктория", 100);


        game.register(Victoria);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Егор", "Виктория")
        );
    }



}