# Airline-Reservation-System
A Core Java project<br>

✈️ <b>Airline Ticket Reservation System</b><br>
A robust Java-based console application designed to manage airline bookings with a persistent backend database. This project demonstrates core OOP principles, database connectivity (JDBC), and date-time handling in Java.

🚀 <b>Features</b><br>
- Dynamic Booking ID Generation: Automatically creates unique IDs based on passenger details.
- Database Persistence: Full integration with MySQL to store and retrieve flight details.
- Input Validation: Checks for destination conflicts (ensures 'From' and 'To' are not identical).
- Formatted Ticket Preview: Displays a clean, professional ticket summary in the console.
- Real-time Scheduling: Uses Java's LocalDateTime for accurate flight timing.

🛠️ <b>Tech Stack</b><br>
- Language: Java (JDK 8+)
- Database: MySQL
- API: JDBC (Java Database Connectivity)

📁 <b>Project Structure</b><br>
- AirlineTicket.java: The main controller containing logic for passenger input, display, and database insertion.
- MySQL Integration: Uses PreparedStatement to securely handle SQL queries.

⚙️ <b>Setup & Installation</b><br>
1. <b>Clone the repository:</b><br>
      git clone https://github.com/vanshbhatia3841-beep/Airline-Reservation-System

2. <b>Database Setup:</b><br>
- Create a database named airline in MySQL.

- Create a table named Ticket with columns: Id(Auto-Increment), Airline Name, First Name, Last Name, Phone No, Age, From, TO, BookingID, Date, Time, Verification (By Default set as Pending).

3. <b>Add JDBC Driver:</b><br>
- Ensure the mysql-connector-java JAR file is added to your project's build path.

4. <b>Update Credentials:</b><br>

- Open AirlineTicket.java and update the DriverManager.getConnection string with your MySQL username and password.
