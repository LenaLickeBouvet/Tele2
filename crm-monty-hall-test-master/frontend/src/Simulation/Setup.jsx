import React, {useState} from 'react';
import SimulationStrategy from './SimulationStrategy';
import './Simulation.css';

function Setup({runSimulation}) {

    const [switchDoor, setSwitchDoor] = useState(true);
    const [noSimulations, setNoSimulations] = useState(1000);

    function handleRunSimulation() {
        runSimulation(noSimulations, switchDoor);
    }

    return(
        <div className="simulationForm">
            <label htmlFor="noSimulations">Number of simulations to run</label>
            <input 
                name="noSimulations" 
                type="number"  
                value={noSimulations} 
                onChange={e => setNoSimulations(e.target.value)} 
            />   
            <SimulationStrategy 
                setSwitchDoor={setSwitchDoor} 
                switchDoor={switchDoor} 
            /> 
            <button onClick={handleRunSimulation}>Run simulation</button>
        </div>
    );

}

export default Setup;