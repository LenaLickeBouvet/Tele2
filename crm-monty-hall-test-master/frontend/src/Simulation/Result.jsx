import React from 'react';
import {SWITCH, DONT_SWITCH} from '../utils/constants';
import './Simulation.css';
import {formatNumber} from '../utils/textHelpers';

function Result(props) {
    const result = props.simulationResult;
    const strategy = result.switchDoorStrategy ? SWITCH : DONT_SWITCH;

    return (
        <React.Fragment>
            <p>
                <b> {formatNumber(result.sumWins)}</b> won a car of 
                <b> {formatNumber(result.noSimulations)}</b> simulations with "{strategy}" strategy.
            </p>
            <button onClick={props.clearResult}>Run a new simulation</button>
        </React.Fragment>

    )
}
export default Result;
