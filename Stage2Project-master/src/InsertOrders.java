import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOrders {
//function to insert orders into database
    public static void main (String department)
    {
        Scanner keyboard = new Scanner(System.in);
        //database connection
        Connection conn = connect();

        try {
            //creation of new order string
            String sql = "INSERT INTO Orders (User_ID,Order_Date,Order_Status,Extra_Comments) VALUES(?,?,?,?)";

            System.out.println("User ID: ");
            String oUser = keyboard.nextLine();
            System.out.println("Date: ");
            String oDate = keyboard.nextLine();
            System.out.println("Status: ");
            String oStatus = keyboard.nextLine();
            System.out.println("Extra Comments: ");
            String extraComments = keyboard.nextLine();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, oUser);
            pstmt.setString(2, oDate);
            pstmt.setString(3, oStatus);
            pstmt.setString(4, extraComments);
            //execution of insert string
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
