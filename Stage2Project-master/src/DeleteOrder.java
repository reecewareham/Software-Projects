import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteOrder {

    public static void main (String department)
    {
        //Main start up function to delete orders from the database
        Scanner keyboard = new Scanner(System.in);
        ViewOrders view = new ViewOrders();

        System.out.println("Which order would you like to delete");
        view.main(department);
        System.out.println("Enter the ID: ");
        int deleteID = keyboard.nextInt();


        DeleteOrder delete = new DeleteOrder();
        delete.deleteRecord(deleteID);



    }

    public void deleteRecord(int Order_ID){
        //database connection
        Connection conn = connect();
        //deletion string
        String sql = "DELETE FROM Orders WHERE Order_ID = ?";

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Order_ID);
            //executed deletion string
            pstmt.executeUpdate();
            System.out.println("A record has been deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }





    private static Connection connect(){

        String fileName = "Stage2Database.db";
        String url = "jdbc:sqlite:" + fileName;
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
