// TicketDisplay.js
import React from 'react';

const TicketDisplay = ({ ticketsAvailable }) => {
  return (
    <div className='ticketsAvailability'>
      <h2>Current Ticket Availability</h2>
      <p>{ticketsAvailable} tickets available</p>
    </div>
  );
};

export default TicketDisplay;