import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchWarehouses {
//Function to call the search functions
    public static void main (String department)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Warehouse Name: ");
        String warehouseName = keyboard.nextLine();

        SearchWarehouses warehouseSearch = new SearchWarehouses();
        warehouseSearch.queryWarehouse(warehouseName);
    }

    //Search function
    public void queryWarehouse(String Search){
        //Database connection
        Connection conn = connect();

        ArrayList<ArrayList<Object>> data;
        try {
            //Search string
            String sql = "SELECT Warehouse_ID, Warehouse_Name,Warehouse_Location,Warehouse_AvailableSpace,Warehouse_UsedSpace FROM Warehouses WHERE Warehouse_Name = ?";

            PreparedStatement sqlStatement  = conn.prepareStatement(sql);

            sqlStatement.setString(1,Search);

            data = new ArrayList<ArrayList<Object>>();
            ResultSet res = sqlStatement.executeQuery();
            {
                while (res.next()) {

                    int wID = res.getInt("Warehouse_ID");
                    String wName = res.getString("Warehouse_Name");
                    String wLocation = res.getString("Warehouse_Location");
                    int wAvailableSpace = res.getInt("Warehouse_AvailableSpace");
                    int wUsedSpace = res.getInt("Warehouse_UsedSpace");

                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(wID);
                    rec.add(wName);
                    rec.add(wLocation);
                    rec.add(wAvailableSpace);
                    rec.add(wUsedSpace);

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
    private static Connection connect () {
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

    //Function to print the searched data to the user
    public static void printData (ArrayList<ArrayList<Object>> data)
    {
        System.out.print("Warehouse ID:  Warehouse Name:     Warehouse Location:      Available Space: Used Space\n");
        for (int i=0; i<data.size(); i++)
        {
            for (int j=0; j<data.get(i).size(); j++)
            {
                System.out.print(data.get(i).get(j));
                System.out.print("              ");
            }
            System.out.println();
        }
    }
}