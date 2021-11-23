import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Inquiries {
    //main function that calls to view the Inquiries
    public static void main(String[] args) {

    }

    //Function that sends the inquiry to the database
    public static void inquire() {
        Scanner userChoice = new Scanner(System.in);
        String category = "Empty";
        //Specifies a category for the inquire
        System.out.println("Please Enter What This Inquiry Is About\nPress 1: Logging In\nPress 2: Searching Store\nPress 3: Other\nPress 4: To Exit");
        switch (userChoice.nextInt()) {
            case 1:
                category = "Log In Error";
                break;
            case 2:
                category = "Store Search Error";
                break;
            case 3:
                category = "Other";
                break;
            case 4:
                Main.CustomerMenu();
                break;
            default:
                //data validation
                System.out.println("That was not a valid input please try again");
                Inquiries.inquire();
        }
        System.out.println("You have chosen: " + category);
        System.out.println("Please Enter Your Inquiry:");
        userChoice.nextLine();
        String inq = userChoice.nextLine();
        //Database connection
        Connection conn = connect();

        try {
            //Insertion of the category for the inquiry string
            String sqlinsert = "INSERT INTO Inquiries (Category, Inq) VALUES(?,?)";

            PreparedStatement prepst = conn.prepareStatement(sqlinsert);
            prepst.setString(1, category);
            prepst.setString(2, inq);
            //Execution of the insertion string
            prepst.executeUpdate();
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
        Main.CustomerMenu();
    }

    //Function to view all the inquiries
    public static void viewInquiries(String department) {
        //Database connection
        Connection conn = connect();
        ArrayList<ArrayList<Object>> data;

        try {
            //String to view the inquiries
            String sql = "SELECT Category,Inq  FROM Inquiries";

            Statement stmt = conn.createStatement();
            data = new ArrayList<ArrayList<Object>>();

            ResultSet res = stmt.executeQuery(sql);
            {
                // loop through the result set
                while (res.next()) {

                    String Category = res.getString("Category");
                    String Inquiry = res.getString("Inq");

                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(Category);
                    rec.add(Inquiry);
                    data.add(rec);
                }
            }
            printData(data);
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
        Main.returnHome(department);
    }

    //function to allow the user to reply to an inquiry
    public static void reply(String department) {
        Scanner userChoice = new Scanner(System.in);
        String category = "Empty";

        System.out.println("Please Enter What This Reply Is About\nPress 1: Logging In\nPress 2: Searching Store\nPress 3: Other\nPress 4: To Exit");
        switch (userChoice.nextInt()) {
            case 1:
                category = "Log In Error";
                break;
            case 2:
                category = "Store Search Error";
                break;
            case 3:
                viewInquiries(department);
                category = "Other";
                break;
            case 4:
                Main.CustomerMenu();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                Inquiries.inquire();
        }
        System.out.println(category);
        System.out.println("Please Enter Your Reply");
        userChoice.nextLine();
        String reply = userChoice.nextLine();
        //Database connection
        Connection conn = connect();
        try {
            //Insertion string
            String sqlinsert = "INSERT INTO Replies (Category, Reply_Text) VALUES(?,?)";

            PreparedStatement prepst = conn.prepareStatement(sqlinsert);
            prepst.setString(1, category);
            prepst.setString(2, reply);

            prepst.executeUpdate();

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
        Main.returnHome(department);
    }

    //Function for the user to view all the replies
    public static void viewReplies() {
        //Database connection
        Connection conn = connect();
        ArrayList<ArrayList<Object>> data;

        try {
            //Selection string to get the viewable data
            String sql = "SELECT Category,Reply_Text  FROM Replies";

            Statement stmt = conn.createStatement();
            data = new ArrayList<ArrayList<Object>>();

            ResultSet res = stmt.executeQuery(sql);
            {
                // loop through the result set
                while (res.next()) {
                    String Category = res.getString("Category");
                    String Reply_Text = res.getString("Reply_Text");

                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(Category);
                    rec.add(Reply_Text);

                    data.add(rec);
                }
            }
            printData(data);
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
        Main.CustomerMenu();
    }

    //Database connection function
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

    //Function to displays all the data that wants to be viewed
    public static void printData(ArrayList<ArrayList<Object>> data) {
        System.out.println("Category:                           Text:");
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                System.out.print(data.get(i).get(j));
                System.out.print("                                  ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}