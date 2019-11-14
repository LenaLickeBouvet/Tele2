package se.comhem.test.montyhall;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimulationServiceTest {
    private SimulationService simulationService;

    @Before
    public void init(){
        simulationService = new SimulationService();
    }

    @Test
    public void simulate1000_whenSwitch_shouldWinOver500() {
        int sumWins = simulationService.runSimulation(1000, true);
        assertTrue(sumWins > 500);
    }

    @Test
    public void simulate1000_whenKeep_shouldWinLessThan500() {
        int sumWins = simulationService.runSimulation(1000, false);
        assertTrue(sumWins<500);
    }
}