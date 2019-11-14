import React, { Component } from 'react';
import monty from './monty.jpg';
import './App.css';
import BackendHealth from './BackendHealth/BackendHealth';
import Simulation from './Simulation/Simulation'

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <BackendHealth/>
          <img src={monty} className="App-monty" alt="logo" />
          <h1 className="App-title">Welcome to the Monty Hall Simulator</h1>
        </header>
		<div className="App-body">
          <Simulation/>
        </div>
      </div>
    );
  }
}

export default App;
