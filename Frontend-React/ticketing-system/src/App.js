// App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import ConfigurationForm from './ConfigurationForm';
import TicketDisplay from './TicketDisplay';
import ControlPanel from './ControlPanel';
import LogDisplay from './LogDisplay';
import './App.css';

const App = () => {
  const [ticketsAvailable, setTicketsAvailable] = useState(0);
  const [isRunning, setIsRunning] = useState(false);
  const [logs, setLogs] = useState([]);

  useEffect(() => {
    const client = new Client({
      brokerURL: 'ws://localhost:8080/ws',
      webSocketFactory: () => new SockJS('http://localhost:8080/ws'),
      onConnect: () => {
        console.log('Connected to WebSocket');
        client.subscribe('/topic/tickets', (message) => {
          setLogs((prevLogs) => [...prevLogs, message.body]);

          // Extract ticketsAvailable from the message
        const ticketCountMatch = message.body.match(/Tickets Available: (\d+)/);
        if (ticketCountMatch) {
          const newTicketCount = parseInt(ticketCountMatch[1], 10);
          setTicketsAvailable(newTicketCount);
        }
        });
      },
    });

    client.activate();

    return () => {
      client.deactivate();
    };
  }, []);

  const startSystem = async () => {
    setIsRunning(true);
    setLogs((prev) => [...prev, 'System started.']);
    try {
      await axios.post('http://localhost:8080/api/start');
    } catch (error) {
      console.error('Error starting the system:', error);
    }
  };

  const stopSystem = async () => {
    setIsRunning(false);
    setLogs((prev) => [...prev, 'System stopped.']);
    try {
      await axios.post('http://localhost:8080/api/stop');
    } catch (error) {
      console.error('Error stopping the system:', error);
    }
  };

  return (
    <div className="App">
      <h1>Real-Time Event Ticketing Platform</h1>
      <ConfigurationForm />
      <TicketDisplay ticketsAvailable={ticketsAvailable} />
      <ControlPanel startSystem={startSystem} stopSystem={stopSystem} isRunning={isRunning} />
      <LogDisplay logs={logs} />
    </div>
  );
};

export default App;

