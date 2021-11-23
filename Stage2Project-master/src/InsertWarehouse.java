import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertWarehouse {
//function to insert new warehouse into database
    public static void main (String department)
    {
        Scanner keyboard = new Scanner(System.in);
        //database connection
        Connection conn = connect();

        try {

            System.out.println("Name: ");
            String wName = keyboard.nextLine();
            System.out.println("Location: ");
            String wLocation = keyboard.nextLine();
            System.out.println("Available Space: ");
            int wAvailableSpace = keyboard.nextInt();
            System.out.println("Used Space: ");
            int wUsedSpace = keyboard.nextInt();

            //insertion string
            String sql = "INSERT INTO Warehouses (Warehouse_name,Warehouse_Location,Warehouse_AvailableSpace, Warehouse_UsedSpace) VALUES(?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, wName);
            pstmt.setString(2, wLocation);
            pstmt.setInt(3, wAvailableSpace);
            pstmt.setInt(4, wUsedSpace);
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
