import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditOrders {

    public static String OrderID;
    static public Scanner Input = new Scanner(System.in);

    public static void main(String department) {
        //Function for getting the order id
        orderID();
        //Function for editing the order
        editOrder();
    }
//database connection function
    public static Connection connect() {
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
//function to get the order id
    public static String orderID() {
        System.out.println("\nPlease enter the order ID of the order you would like to edit: \n");
        OrderID = Input.nextLine();
        return OrderID;
    }


    public static void editOrder() {

        System.out.println("\nYou are currently editing order " + OrderID + ".\n");
        System.out.println("Edit Order:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: Edit order user ID\n" +
                "\n" +
                "Press 2: Edit order date\n" +
                "\n" +
                "Press 3: Edit order status\n" +
                "\n" +
                "Press 4: Edit the extra comments\n" +
                "\n" +
                "Press 5: Return to purchases\n");
        int choice;
            choice = Input.nextInt();
            Input.nextLine();

            //switch statement to send to a different function to edit what part they would like to edit
            switch (choice) {
                case 1:
                    orderUser();
                    break;
                case 2:
                    orderDate();
                    break;
                case 3:
                    orderStatus();
                    break;
                case 4:
                    orderExtraComments();
                    break;
                case 5:
                    break;
                default:
                    //data validation
                    System.out.println("That was not a valid input please try again\n");
                    editOrder();
            }
    }

    public static void orderUser() {
        //connection to database
        Connection conn = connect();

        System.out.println("Please enter the new user ID: ");
        String oUserID = Input.nextLine();
        //edit string
        String sql = "UPDATE Orders SET User_ID = ? WHERE Order_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, oUserID);
            pstmt.setString(2, OrderID);
            //execution of edit string
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editOrder();
    }

    public static void orderDate() {
        //database connection
        Connection conn = connect();

        System.out.println("Please enter the new order date (dd/mm/yyyy): ");
        String oDate = Input.nextLine();
        //edit string
        String sql = "UPDATE Orders SET Order_Date = ? WHERE Order_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, oDate);
            pstmt.setString(2, OrderID);
            //execution of edit string
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editOrder();
    }

    public static void orderStatus() {
        //database connection
        Connection conn = connect();

        System.out.println("Please enter the new order status: ");
        String oStatus = Input.nextLine();
        //edit string
        String sql = "UPDATE Orders SET Order_Status = ? WHERE Order_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, oStatus);
            pstmt.setString(2, OrderID);
            //execution of edit string
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editOrder();
    }

    public static void orderExtraComments() {
        //database connection
        Connection conn = connect();

        System.out.println("Please enter the new order extra comments: ");
        String oEC = Input.nextLine();
        //edit string
        String sql = "UPDATE Orders SET Extra_Comments = ? WHERE Order_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, oEC);
            pstmt.setString(2, OrderID);
            //execution of edit string
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        editOrder();
    }
}

