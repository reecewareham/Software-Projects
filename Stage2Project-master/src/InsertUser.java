import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser {
//function to insert new users into the database
    public static void main (String department)
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner userChoice = new Scanner(System.in);
        //database connection
        Connection conn = connect();

        try {
            //insertion string
            String sql = "INSERT INTO Users  (User_Fname,User_LName,User_Email,User_Password,User_DOB,User_PhoneNumber,User_Role) VALUES(?,?,?,?,?,?,?)";

            System.out.println("First Name: ");
            String uFName = keyboard.nextLine();
            System.out.println("Last Name: ");
            String uLName = keyboard.nextLine();
            System.out.println("Email: ");
            String uEmail = keyboard.nextLine();
            System.out.println("Password: ");
            String uPassword = keyboard.nextLine();
            System.out.println("DOB: ");
            String uDOB = keyboard.nextLine();
            System.out.println("Phone Number: ");
            String uPhoneNumber = keyboard.nextLine();
            System.out.println("User Role:\nPress 1: For Sales\nPress 2: For Production\nPress 3: For Manager\nPress 4: For Customer\nPress 5: For Purchasing");
            String uRole = "";
            switch (userChoice.nextInt()) {
                case 1:
                    uRole = "Sales";
                    break;
                case 2:
                    uRole = "Production";
                    break;
                case 3:
                    uRole = "Manager";
                    break;
                case 4:
                    uRole = "Customer";
                    break;
                case 5:
                    uRole = "Purchasing";
                    break;
                default:
                    System.out.println("That was not a valid input please try again");
            }

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uFName);
            pstmt.setString(2,uLName);
            pstmt.setString(3,uEmail);
            pstmt.setString(4,uPassword);
            pstmt.setString(5,uDOB);
            pstmt.setString(6,uPhoneNumber);
            pstmt.setString(7,uRole);
            //execution of insertion string
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

//database connection function
    private static Connection connect(){

        String fileName = "Stage2Database.db";
        String url = "jdbc:sqlite:" + fileName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

