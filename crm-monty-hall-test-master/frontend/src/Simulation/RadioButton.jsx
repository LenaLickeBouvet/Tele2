import React from 'react';

const RadioButton = (props) => {

    const {id, onChange, value, isSelected, label} = props.config;

    function handleOnChange() {
        onChange(value);
    }

    return (
        <div>
            <input 
                id={id} 
                onChange={handleOnChange} 
                value={value} 
                type="radio" 
                checked={isSelected}
            />
            <label htmlFor={id}>{label}</label>
        </div>
    );

};
export default RadioButton;