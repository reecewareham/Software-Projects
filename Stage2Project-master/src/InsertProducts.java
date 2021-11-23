import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertProducts {
//function to insert new products into the database
    public static void main (String department)
    {
        Scanner keyboard = new Scanner(System.in);
        //database connection
        Connection conn = connect();

        try {
            System.out.println("Enter Name: ");
            String pName = keyboard.nextLine();
            System.out.println("Category: ");
            String pCategory = keyboard.nextLine();
            System.out.println("Description: ");
            String pDescription = keyboard.nextLine();
            System.out.println("Supplier: ");
            String pSupplier = keyboard.nextLine();
            System.out.println("Price: ");
            double pPrice = keyboard.nextDouble();
            System.out.println("Quantity: ");
            int pQuantity = keyboard.nextInt();
            System.out.println("Status: ");
            String pStatus1 = keyboard.nextLine();
            String pStatus = keyboard.nextLine();
            System.out.println("Availability: ");
            String pAvailability = keyboard.nextLine();
            //insertion string
            String sql = "INSERT INTO Products (Product_Name,Product_Category, Product_Description,Product_Supplier,Product_Price,Product_Quantity,Product_Status,Availability) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pName);
            pstmt.setString(2, pCategory);
            pstmt.setString(3, pDescription);
            pstmt.setString(4, pSupplier);
            pstmt.setDouble(5, pPrice);
            pstmt.setInt(6, pQuantity);
            pstmt.setString(7, pStatus );
            pstmt.setString(8, pAvailability);
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
