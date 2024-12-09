# Real Time Event Ticketing System 

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
![Sequence Diagram](./Diagrams/Sequence%20diagram.png)

### Class Diagram
![Class Diagram](./Diagrams/Class%20Diagram.png)

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

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

---

## 📂 Project Structure

- **backend**: Spring Boot backend code.
- **frontend**: React frontend code.
- **CLI**: Command-line interface for ticket management.
- **diagrams**: Sequence and class diagrams.

---

## 💬 Contact

For inquiries, please contact [rochaniriligala@gmail.com](mailto:rochaniriligala@gmail.com).

---

Show your support by ⭐ starring this repository!
