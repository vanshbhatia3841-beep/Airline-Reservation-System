import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AirlineTicket {

    String AirlineName;
    String BookingID;
    String FName, LName;
    String From;
    String To, Verification;
    int day, month, year, hour, minute, age;
    long phone;
    int id;

    Scanner scanner = new Scanner(System.in);
    LocalDateTime DateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
    String newDateTime = DateTime.format(formatter);

    AirlineTicket(String AirlineName) {
        this.AirlineName = AirlineName;
    }

    void getInfo() {
        System.out.print("First Name: ");
        FName = scanner.next();

        scanner.nextLine();
        System.out.print("Middle + Last Name: ");
        LName = scanner.nextLine();

        System.out.print("Phone No: +91 ");
        phone = scanner.nextLong();

        System.out.print("Age: ");
        age = scanner.nextInt();

        scanner.nextLine();
        System.out.print("From Where: ");
        From = scanner.nextLine();

        System.out.print("To: ");
        To = scanner.nextLine();

        while (From.equalsIgnoreCase(To)) {
            if (From.equalsIgnoreCase(To)) {
                System.out.println(
                        "You entered the same location in both destinations.\nPlease re-enter the correct locations");
                To = scanner.nextLine();
            }
        }
        try {
            System.out.println("Enter date, month, year, hour, minute: ");
            day = scanner.nextInt();
            month = scanner.nextInt();
            year = scanner.nextInt();
            hour = scanner.nextInt();
            minute = scanner.nextInt();

            DateTime = LocalDateTime.of(year, month, day, hour, minute, 0);
            newDateTime = DateTime.format(formatter);
        } catch (Exception e) {
            System.out.println("The format/datetime you entered is in wrong format");
        } finally {
            System.out.println("All the details are stored.\nHere is your Ticket Preview");
        }

        String a = Long.toString(phone);
        String b = Integer.toString(age);

        BookingID = (FName == null || FName.isEmpty()) ? ""
                : FName.substring(0, Math.min(3, FName.length())) + (a.substring(0, 5)) + (b.substring(0, 2));
    }

    void display() {
        System.out.printf("""
                                        Airline Name: %s

                Customer Name: %s %s                            Destination: %s TO %s

                Age: %s                                         Phone No: +91 %s

                Booking ID: %s

                Date & Time of Flight(requested by customer): %s
                """, AirlineName, FName, LName, From, To, age, phone, BookingID, newDateTime);
    }

    public static void main(String[] args) {

        AirlineTicket AT = new AirlineTicket("Air India");

        AT.getInfo();
        System.out.println();
        AT.display();

        try {
            Connection myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/airline",  "root",  "Vansh@1405") ; 
                                                                                                                    
                                                                                                                    

            String sql = "INSERT INTO Ticket " +
                    "(id, `Airline Name`, `First Name`, `Last Name`, `Phone No`, Age, `From`, `TO`, BookingID, `Date`, `Time`) "
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = myConn.prepareStatement(sql);

            pstmt.setInt(1, AT.id);
            pstmt.setString(2, AT.AirlineName);
            pstmt.setString(3, AT.FName);
            pstmt.setString(4, AT.LName);
            pstmt.setLong(5, AT.phone);
            pstmt.setInt(6, AT.age);
            pstmt.setString(7, AT.From);
            pstmt.setString(8, AT.To);
            pstmt.setString(9, AT.BookingID);
            pstmt.setDate(10, java.sql.Date.valueOf(AT.DateTime.toLocalDate()));
            pstmt.setTime(11, java.sql.Time.valueOf(AT.DateTime.toLocalTime()));

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Ticket successfully stored in database. Rows affected: " + rowsAffected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
