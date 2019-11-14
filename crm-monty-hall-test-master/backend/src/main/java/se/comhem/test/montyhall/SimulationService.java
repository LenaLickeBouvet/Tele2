package se.comhem.test.montyhall;

import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class SimulationService {

   int runSimulation(int noSimulations, boolean switchDoor) {
        return Math.toIntExact(IntStream.range(0, noSimulations)
                .parallel()
                .filter(i -> didWinGame(switchDoor))
                .count());
    }

    private boolean didWinGame(boolean switchDoor) {
        Game game = new Game();
        int randomDoor = (int) Math.round(Math.random() * 2) + 1;
        return game.play(randomDoor, switchDoor);
    }
}
