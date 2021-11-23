import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteWarehouse {

    public static void main (String department)
    {
        //function for deletion of warehouse
        Scanner keyboard = new Scanner(System.in);
        ViewWarehouses view = new ViewWarehouses();

        System.out.println("Which warehouse would you like to delete");
        view.main(department);
        System.out.println("Enter the ID: ");
        int deleteID = keyboard.nextInt();


        DeleteWarehouse delete = new DeleteWarehouse();
        delete.deleteRecord(deleteID);



    }

    public void deleteRecord(int Warehouse_ID){
        //database connection
        Connection conn = connect();
        //deletion string
        String sql = "DELETE FROM Warehouses WHERE Warehouse_ID = ?";

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, Warehouse_ID);
            //execution of deletion string
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
