package se.comhem.test.montyhall.door;

public class WinningDoor extends Door {
    private static WinningDoor instance = null;

    private WinningDoor() { }

    public static WinningDoor getInstance() {
        if (instance == null) {
            instance = new WinningDoor();
        }
        return instance;
    }
}
