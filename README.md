# Airline-Reservation-System
A collection of Core Java and Python projects.<br>

✈️ Airline Ticket Reservation System
A robust Java-based console application designed to manage airline bookings with a persistent backend database. This project demonstrates core OOP principles, database connectivity (JDBC), and date-time handling in Java.

🚀 Features
Dynamic Booking ID Generation: Automatically creates unique IDs based on passenger details.

Database Persistence: Full integration with MySQL to store and retrieve flight details.

Input Validation: Checks for destination conflicts (ensures 'From' and 'To' are not identical).

Formatted Ticket Preview: Displays a clean, professional ticket summary in the console.

Real-time Scheduling: Uses Java's LocalDateTime for accurate flight timing.

🛠️ Tech Stack
Language: Java (JDK 8+)

Database: MySQL

API: JDBC (Java Database Connectivity)

📁 Project Structure
AirlineTicket.java: The main controller containing logic for passenger input, display, and database insertion.

MySQL Integration: Uses PreparedStatement to securely handle SQL queries.

⚙️ Setup & Installation
Clone the repository:

Bash

git clone https://github.com/vanshbhatia3841-beep/Airline-Reservation-System

Database Setup:

Create a database named airline in MySQL.

Create a table named Ticket with columns: Airline Name, First Name, Last Name, Phone No, Age, From, TO, BookingID, Date, Time.

Add JDBC Driver:

Ensure the mysql-connector-java JAR file is added to your project's build path.

Update Credentials:

Open AirlineTicket.java and update the DriverManager.getConnection string with your MySQL username and password.
