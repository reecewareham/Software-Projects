import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;


public class UserLogin {
//main function just to call the register function
    public static void main (String [] args) {
        Register();
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

    //function to log the user into the system
    public static void Login() {
        Scanner Input = new Scanner(System.in);
        //Database connection
        Connection conn = connect();

        String databaseEmail = "";
        String databasePassword = "";
        String databaseRole = "";

        System.out.println("------------------");
        System.out.println("    User Login    ");
        System.out.println("------------------");

        System.out.println("Email: ");
        String email = Input.nextLine();
        System.out.println("Password: ");
        String password = Input.nextLine();

        //Retrieves login details
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE User_Email=(?) AND User_Password=(?)")) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                databaseEmail = rs.getString("User_Email");
                databasePassword = rs.getString("User_Password");
                databaseRole = rs.getString("User_Role");
            }

            //Data validation to test the input from the details
            if (email.equals(databaseEmail) && password.equals(databasePassword)) {
                  if (databaseRole.equals("Manager")) {
                    conn.close();
                    Main.ManagerMenu();
                } else if (databaseRole.equals("Customer")) {
                    conn.close();
                      Main.CustomerMenu();
                }
                  else if (databaseRole.equals("Sales")) {
                      conn.close();
                      Main.SalesMenu();
                  }
                  else if (databaseRole.equals("Production")) {
                      conn.close();
                      Main.ProductionMenu();
                  }
                  else if (databaseRole.equals("Purchasing")) {
                      conn.close();
                      Main.PurchasingMenu();
                  }
            } else {
                System.out.println("Incorrect Login!");
                Login();
            }
        } catch (SQLException e) {
            System.out.println("Fail!");

        }
    }
    //register function to register new users
        public static void Register() {

        Scanner Input = new Scanner(System.in);
        Connection conn = connect();

        System.out.println("---------------------------");
        System.out.println("    Register an Account    ");
        System.out.println("---------------------------");

        System.out.println("First Name: ");
        String uFName = Input.nextLine();
        System.out.println("Last Name: ");
        String uLName = Input.nextLine();

        String uEmail;
        int i = 0;
        do {
            System.out.println("Email: ");
            uEmail = Input.nextLine();
            if (isEmailValid(uEmail))
                i++;
            else
                System.out.println("\nThe email you have used is not valid. Please try again.\n");
        }
        while (i==0);

        System.out.println("Password: ");
        String uPassword = Input.nextLine();

        String uDOB;
        int i2 = 0;
        do {
            System.out.println("DOB (DD/MM/YYYY): ");
            uDOB = Input.nextLine();
            if (isDateValid(uDOB))
                i2++;
            else
                System.out.println("\nThe date of birth you have entered is not valid. Please try again.\n");
        }
        while (i2==0);

        String uPhoneNumber;
        int i3 = 0;
        do {
            System.out.println("Phone Number: ");
            uPhoneNumber = Input.nextLine();
            if (isPhoneNumberValid(uPhoneNumber))
                i3++;
            else
                System.out.println("\nThe phone number you have entered is not valid. Please try again.\n ");
        }
        while (i3==0);

        String uRole = "Customer";

        try {
            //Insertion string
            String sql = "INSERT INTO Users  (User_Fname,User_LName,User_Email,User_Password,User_DOB,User_PhoneNumber,User_Role) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uFName);
            pstmt.setString(2,uLName);
            pstmt.setString(3,uEmail);
            pstmt.setString(4,uPassword);
            pstmt.setString(5, uDOB);
            pstmt.setString(6,uPhoneNumber);
            pstmt.setString(7,uRole);

            //Execution of insertion string
            pstmt.executeUpdate();
            Main.CustomerMenu();

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

    //Function to check if the email that is being registered is valid
    public static boolean isEmailValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }

    //more data validation
    public static boolean isDateValid(String date) {
        String dateRegex = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher((CharSequence)date);
        return matcher.matches();
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        String numberRegex = "^(((\\+44\\s?\\d{4}|\\(?0\\d{4}\\)?)\\s?\\d{3}\\s?\\d{3})|((\\+44\\s?\\d{3}|\\(?0\\d{3}\\)?)\\s?\\d{3}\\s?\\d{4})|((\\+44\\s?\\d{2}|\\(?0\\d{2}\\)?)\\s?\\d{4}\\s?\\d{4}))(\\s?\\#(\\d{4}|\\d{3}))?$";
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher((CharSequence)phoneNumber);
        return matcher.matches();
    }
}





