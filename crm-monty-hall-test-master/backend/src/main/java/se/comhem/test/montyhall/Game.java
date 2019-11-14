package se.comhem.test.montyhall;

import se.comhem.test.montyhall.door.BlankDoor;
import se.comhem.test.montyhall.door.Door;
import se.comhem.test.montyhall.door.WinningDoor;

import java.util.*;
import java.util.stream.Collectors;

class Game {
    private final int NO_OF_BLANK_DOORS = 2;
    private final List<Door> doors;
    private Door chosenDoor;

    Game() {
        List<Door> doorList = new ArrayList<>();
        for (int i=1; i<= NO_OF_BLANK_DOORS; i++) {
            doorList.add(new BlankDoor());
        }
        doorList.add(WinningDoor.getInstance());
        Collections.shuffle(doorList);
        this.doors = Collections.unmodifiableList(doorList);
    }

    Game(List<Door> testDoors) {
        this.doors = Collections.unmodifiableList(testDoors);
    }

    boolean play(int chosenDoor, boolean switchDoor) {
        if (chosenDoor < 1 || chosenDoor > NO_OF_BLANK_DOORS+1) {
            throw new IllegalArgumentException("door numbers are from 1 to " + (NO_OF_BLANK_DOORS + 1));
        }
        int chosenDoorIndex = chosenDoor-1;
        chooseDoor(chosenDoorIndex);
        openBlankDoor();
        if (switchDoor) {
            chooseRandomDoor();
        }
        return this.chosenDoor instanceof WinningDoor;
    }

    private void chooseDoor(int chosenDoor) {
        List<Door> notChosenDoors = getClosedDoorsNotChosen();
        this.chosenDoor =  notChosenDoors.get(chosenDoor);
    }

    private void chooseRandomDoor() {
        List<Door> notChosenDoors = getClosedDoorsNotChosen();
        int randomDoorIndex = (int) Math.round(Math.random() * (notChosenDoors.size() -1));
        chosenDoor =  notChosenDoors.get(randomDoorIndex);
    }

    private List<Door> getClosedDoorsNotChosen() {
        if (chosenDoor == null) {
            return doors;
        } else {
            return doors.stream().filter(this::doorIsClosedAndNotChosen).collect(Collectors.toList());
        }
    }

    private boolean doorIsClosedAndNotChosen(Door door) {
        return chosenDoor == null || (door.isClosed() && !door.equals(chosenDoor));
    }

    private void openBlankDoor() {
        doors.stream().filter(door -> door instanceof BlankDoor
                && doorIsClosedAndNotChosen(door)
        ).findAny().ifPresent(door ->  ((BlankDoor) door).openDoor());
    }
}


