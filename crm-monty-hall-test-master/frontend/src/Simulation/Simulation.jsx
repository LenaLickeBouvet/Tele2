import React, {useState} from 'react'
import axios from 'axios'
import Setup from './Setup'
import Error from './Error'
import Result from './Result'

function Simulation() {

    const noError = {isError:false, errorMsg: ''};
    const [simulationResult, setSimulationResult] = useState();
    const [error, setError] = useState(noError);
    
    const clearError = () => {
        setError(noError);
    }

    const clearResult = () => {
        setSimulationResult();
    }

    function runSimulation(noSimulations, switchDoor) {
        axios.get(`simulations`, {
            params: {
                noSimulations: noSimulations,
                switchDoorStrategy: switchDoor
            }
        })
        .then(res => {
            setSimulationResult(res.data)
        })
        .catch(res => {
            const error = {isError: true, errorMsg: res.response.data.message};
            console.log(error);
            setError(error);
        });    
    }
    
    return (
        error.isError ?  
            <Error 
                errorMsg={error.errorMsg} 
                clearError={clearError}
            />
        : simulationResult ? 
                <Result 
                    simulationResult={simulationResult} 
                    clearResult={clearResult}
                />
            :    
                <Setup runSimulation={runSimulation} />
    );
}

export default Simulation;