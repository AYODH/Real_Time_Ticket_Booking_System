import React, { useState } from 'react';
import axios from 'axios';

const ConfigurationForm = ({ setConfig }) => {
  const [formData, setFormData] = useState({
    totalTickets: '',
    ticketReleaseRate: '',
    customerRetrievalRate: '',
    maxTicketCapacity: '',
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const ConfigData = {
      totalTickets: Number(formData.totalTickets),
      ticketReleaseRate: Number(formData.ticketReleaseRate),
      customerRetrievalRate: Number(formData.customerRetrievalRate),
      maxTicketCapacity: Number(formData.maxTicketCapacity),
    };
 
    try{
      await axios.post('http://localhost:8080/api/tickets/configure', ConfigData);
      setConfig(ConfigData);
      setFormData({
        totalTickets: '',
        ticketReleaseRate: '',
        customerRetrievalRate: '',
        maxTicketCapacity: '',
      });
    } catch (error) {
      console.error('Error configuring the system: ', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Configuration form</h2>
      <input type="number" name="totalTickets" placeholder="Total Tickets" value={formData.totalTickets} onChange={handleChange} required />
      <input type="number" name="ticketReleaseRate" placeholder="Ticket Release Rate" value={formData.ticketReleaseRate} onChange={handleChange} required />
      <input type="number" name="customerRetrievalRate" placeholder="Customer Retrieval Rate" value={formData.customerRetrievalRate} onChange={handleChange} required />
      <input type="number" name="maxTicketCapacity" placeholder="Max Ticket Capacity" value={formData.maxTicketCapacity} onChange={handleChange} required />
      <button type="submit">Save Configuration</button>
    </form>
  );
};

export default ConfigurationForm;








































