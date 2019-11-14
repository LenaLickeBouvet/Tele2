package se.comhem.test.montyhall;

import org.junit.Before;
import org.junit.Test;
import se.comhem.test.montyhall.door.BlankDoor;
import se.comhem.test.montyhall.door.Door;
import se.comhem.test.montyhall.door.WinningDoor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Before
    public void setup() {
        game = new Game(createDoors());
    }
    
    @Test
    public void switchChooseCar_loose() {
        boolean result = game.play(2, true);
        assertFalse(result);
    }

    @Test
    public void switchChooseBlank_win() {
        boolean result = game.play(1, true);
        assertTrue(result);
    }

    @Test
    public void notSwitchChooseCar_win() {
        boolean result = game.play(2, false);
        assertTrue(result);
    }

    @Test
    public void notSwitchChoseBlank_loose() {
        boolean result = game.play(3, false);
        assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void chooseNotOkDoorNo_throwsException() {
        game.play(5, false);
    }
    
    private List<Door> createDoors() {
        List<Door> doors = new ArrayList<>();
        doors.add(new BlankDoor());
        doors.add(WinningDoor.getInstance());
        doors.add(new BlankDoor());
        return doors;
    }
}