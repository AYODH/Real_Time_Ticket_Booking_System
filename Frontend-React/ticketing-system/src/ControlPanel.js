// ControlPanel.js
import React from 'react';
import './App.css'; // Import the CSS file for ControlPanel

const ControlPanel = ({ startSystem, stopSystem, isRunning }) => {
  return (
    <div className="control-panel">
      <h2>Control Panel</h2>
      <div className="button-container">
        <button onClick={startSystem} disabled={isRunning}>Start System</button>
        <button onClick={stopSystem} disabled={!isRunning}>Stop System</button>
      </div>
    </div>
  );
};

export default ControlPanel;