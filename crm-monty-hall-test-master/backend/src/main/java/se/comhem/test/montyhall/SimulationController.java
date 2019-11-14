package se.comhem.test.montyhall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.comhem.test.montyhall.model.Simulation;

import java.lang.invoke.MethodHandles;

@RestController
public class SimulationController {
    private final SimulationService simulationService;

    @Autowired
    SimulationController(SimulationService simulationService){
        this.simulationService = simulationService;
    }

    private static final Logger logger
            = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int MAX_NUMBER_OF_SIMULATIONS = 1000000;

    @GetMapping(
            value = "/simulations"
    )
    public ResponseEntity<Simulation> runSimulation(
            @RequestParam("noSimulations") int noSimulations,
            @RequestParam("switchDoorStrategy") boolean switchDoorStrategy) {
        logger.info("REST runSimulation called, noSimulations: {}, switchDoorStrategy: {}"
                , noSimulations, switchDoorStrategy);
        if (noSimulations > MAX_NUMBER_OF_SIMULATIONS) {
            throw new IllegalArgumentException("Request was for "+ noSimulations +
                    " and max number of simulations is " + MAX_NUMBER_OF_SIMULATIONS);
        }

        int sumWins = simulationService.runSimulation(noSimulations, switchDoorStrategy);

        return new ResponseEntity<>(new Simulation(sumWins, noSimulations, switchDoorStrategy), HttpStatus.OK);
    }

}
