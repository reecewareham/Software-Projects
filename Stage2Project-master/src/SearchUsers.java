import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchUsers {
//main function to call the search function
    public static void main (String department)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter User ID ");
        String userID = keyboard.nextLine();

        SearchUsers userSearch = new SearchUsers();
        userSearch.queryUsers(userID);
    }
//search function
    public void queryUsers(String Search){
        //Database connection
        Connection conn = connect();

        ArrayList<ArrayList<Object>> data;

        try {
            //search string
            String sql = "SELECT User_ID,User_FName,User_LName,User_Email,User_Password,User_DOB,User_PhoneNumber,User_Role FROM Users WHERE User_ID = ?";
            PreparedStatement sqlStatement  = conn.prepareStatement(sql);

            sqlStatement.setString(1,Search);

            data = new ArrayList<ArrayList<Object>>();
            ResultSet res = sqlStatement.executeQuery();
            {

                while (res.next()) {

                    int uID = res.getInt("User_ID");
                    String uFName = res.getString("User_FName");
                    String uLName = res.getString("User_LName");
                    String uEmail = res.getString("User_Email");
                    String uPassword = res.getString("User_Password");
                    String uDOB = res.getString("User_DOB");
                    String uPhoneNumber = res.getString("User_PhoneNumber");
                    String uRole = res.getString("User_Role");

                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(uID);
                    rec.add(uFName);
                    rec.add(uLName);
                    rec.add(uEmail);
                    rec.add(uPassword);
                    rec.add(uDOB);
                    rec.add(uPhoneNumber);
                    rec.add(uRole);

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
    }

//Database connection function
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

    //Function to print the searched details
    public static void printData (ArrayList<ArrayList<Object>> data)
    {
        System.out.print("User ID: User FName:  User LName:     User Email:           User Password:   User DOB:    User PhoneNumber:  User Role:\n");
        for (int i=0; i<data.size(); i++)
        {
            for (int j=0; j<data.get(i).size(); j++)
            {
                System.out.print(data.get(i).get(j));
                System.out.print("        ");
            }
            System.out.println();
        }
    }
}