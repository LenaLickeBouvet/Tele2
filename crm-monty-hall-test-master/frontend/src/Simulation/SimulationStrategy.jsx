 import React from 'react';
 import RadioButton from './RadioButton';
 import {SWITCH, DONT_SWITCH} from '../utils/constants';

function SimulationStrategy({setSwitchDoor, switchDoor}) {

    const trueButton = {
        id: 1,
        isSelected: switchDoor,
        onChange: setSwitchDoor,
        value: true,
        label: SWITCH
    };

    const falseButton = {
        id: 0,
        isSelected: !switchDoor,
        onChange: setSwitchDoor,
        value: false,
        label: DONT_SWITCH
    };

    return (
        <div style={{marginTop:'10px'}}>
            <label>Simulation strategy</label>
            <RadioButton config={trueButton} />
            <RadioButton config={falseButton} />
        </div>
    );

}
 
export default SimulationStrategy;