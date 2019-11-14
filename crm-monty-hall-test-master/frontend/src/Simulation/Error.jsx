import React from 'react';
import './Simulation.css';

function Error(props) {

    return (
    <div>
        <h2>Some error occurred in simulation.</h2>
        <p>{props.errorMsg}</p>
        <button onClick={props.clearError}>try again</button>
    </div>
    )

}
export default Error;