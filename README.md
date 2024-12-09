# Ticketing System CLI

A robust command-line interface application for managing ticket distribution, designed for real-time processing and concurrency. This system handles tickets from multiple vendors and customers, ensuring smooth operation even under high load. Built using **Java**, with a **React** frontend and **Spring Boot** backend.

---

## 🎥 Demo Video

[![Watch the Demo](https://img.youtube.com/vi/YOUR_VIDEO_ID/0.jpg)](https://www.youtube.com/watch?v=YOUR_VIDEO_ID)

> Click the image above to watch the demonstration of the Ticketing System CLI.

---

## 📝 Features

- **Multi-threaded Operations**: Simultaneous ticket additions and retrievals by vendors and customers.
- **Real-time Logging**: Error and transaction logs for debugging and transparency.
- **Configuration Management**: Easy-to-use setup for system parameters.
- **Concurrency Management**: Smooth handling of concurrent operations.

---

## 🏗️ System Architecture

### Sequence Diagram
![Sequence Diagram](./SequenceDiagram.png)

### Class Diagram
![Class Diagram](./ClassDiagram.png)

---

## ⚙️ Setup Instructions

### Prerequisites
- Java JDK 11 or higher
- Maven
- React and Node.js (for the frontend)
- Spring Boot (for the backend)

### Backend Setup
1. Clone the repository.
   ```bash
   git clone <repository-url>
   cd <repository-folder>/backend
   ```
2. Build the project.
   ```bash
   mvn clean install
   ```
3. Run the Spring Boot application.
   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the frontend folder.
   ```bash
   cd <repository-folder>/frontend
   ```
2. Install dependencies.
   ```bash
   npm install
   ```
3. Start the development server.
   ```bash
   npm start
   ```

---

## 🚀 Usage

1. Run the backend and frontend services.
2. Launch the CLI from the terminal:
   ```bash
   java -jar TicketingSystemCLI.jar
   ```
3. Follow the prompts to configure settings, add tickets, and purchase tickets.

---

## 📂 Project Structure

- **backend/**: Spring Boot backend code.
- **frontend/**: React frontend code.
- **CLI/**: Command-line interface for ticket management.
- **diagrams/**: Sequence and class diagrams.

---

## 💬 Contact

For inquiries, please contact [your.email@example.com](mailto:rochaniriligala@gmail.com).

---

Show your support by ⭐ starring this repository!
