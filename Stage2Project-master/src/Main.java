import java.sql.*;
import java.util.Scanner;
//The main menu system is linked to all the other classes, methods and functions.
public class Main {
    public static void main(String[] args) {
        //Database connection
        Connection conn = connect();
        Scanner mainPageChoice = new Scanner(System.in);
        //This will prompt the user to sign in, login, or just stop the application.
        System.out.println("Hello there, this is an Inventory Management Application.\n" +
                "Please Login using your username and password or create a new account.\n" +
                "\n" +
                "Press 1: To login\n" +
                "Press 2: To sign up\n" +
                "Press 3: To End Application");
        switch (mainPageChoice.nextInt()) {
            case 1:
                UserLogin.Login();
                break;
            case 2:
                UserLogin.Register();
                break;
            case 3:
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                System.out.println("That was not a valid input please try again");
                main(null);
        }

    }

    public static void ManagerMenu() {
        //If the user is a manager they will be greeted with this menu. This will connect them to other sub menus for further functionalities, or they can return to the main menu.
        Scanner managerChoice = new Scanner(System.in);
        String department = "Manager";
        System.out.println("Manager Home Page:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To manage Product Information\n" +
                "\n" +
                "Press 2: To manage Warehouse Information\n" +
                "\n" +
                "Press 3: To manage Purchases\n" +
                "\n" +
                "Press 4: To manage Inquiries\n" +
                "\n" +
                "Press 5: To manage Users\n" +
                "\n" +
                "Press 6: To log out\n");
        switch (managerChoice.nextInt()) {
            case 1:
                manageProductInformation(department);
                break;
            case 2:
                manageWarehouseInformation(department);
                break;
            case 3:
                managePurchases(department);
                break;
            case 4:
                manageInquiries(department);
                break;
            case 5:
                manageUserDatabase(department);
                break;
            case 6:
                logOut();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                ManagerMenu();
        }


    }

    public static void ProductionMenu() {
        //If the user is in production they will be greeted with this menu. This will connect them to other sub menus for further functionalities, or they can return to the main menu.
        Scanner productionChoice = new Scanner(System.in);
        String department = "Production";
        System.out.println("Production Home Page:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To manage Product Information\n" +
                "\n" +
                "Press 2: To manage Warehouse Information\n" +
                "\n" +
                "Press 3: To view purchases\n" +
                "\n" +
                "Press 4: To contact the Purchasing Department\n" +
                "\n" +
                "Press 5: To log out\n");
        switch (productionChoice.nextInt()) {
            case 1:
                manageProductInformation(department);
                break;
            case 2:
                manageWarehouseInformation(department);
                break;
            case 3:
                ViewOrders.main(department);
                ProductionMenu();
                break;
            case 4:
                contactPurchasing(department);
                break;
            case 5:
                logOut();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                ProductionMenu();
        }
    }

    public static void PurchasingMenu() {
        //If the user is in production they will be greeted with this menu. This will connect them to other sub menus for further functionalities, or they can return to the main menu.
        Scanner purchasingChoice = new Scanner(System.in);
        String department = "Purchasing";
        System.out.println("Purchasing Home Page:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To view Products\n" +
                "\n" +
                "Press 2: To view Warehouses\n" +
                "\n" +
                "Press 3: To manage purchases\n" +
                "\n" +
                "Press 4: To contact the Production Department\n" +
                "\n" +
                "Press 5: To log out\n");
        switch (purchasingChoice.nextInt()) {
            case 1:
                ViewProducts.main(department);
                PurchasingMenu();
                break;
            case 2:
                ViewWarehouses.main(department);
                PurchasingMenu();
                break;
            case 3:
                managePurchases(department);
                break;
            case 4:
                contactProduction(department);
                break;
            case 5:
                logOut();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                PurchasingMenu();
        }

    }

    public static void SalesMenu() {
        //If the user is in sales they will be greeted with this menu. This will connect them to other sub menus for further functionalities, or they can return to the main menu.
        Scanner salesChoice = new Scanner(System.in);
        String department = "Sales";
        System.out.println("Sales Home Page:\n" +
                "Please Select a function:\n" +
                "\n" +
                "Press 1: To manage inquiries\n" +
                "\n" +
                "Press 2: To view Product Information\n" +
                "\n" +
                "Press 3: To view Warehouse Information\n" +
                "\n" +
                "Press 4: To view purchases\n" +
                "\n" +
                "Press 5: To log out\n");
        switch (salesChoice.nextInt()) {
            case 1:
                manageInquiries(department);
                break;
            case 2:
                ViewProducts.main(department);
                SalesMenu();
                break;
            case 3:
                ViewWarehouses.main(department);
                SalesMenu();
                break;
            case 4:
                ViewOrders.main(department);
                SalesMenu();
                break;
            case 5:
                logOut();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                SalesMenu();
        }

    }

    public static void CustomerMenu() {
        //If the user is a customer they will be greeted with this menu. This will connect them to other sub menus for further functionalities, or they can return to the main menu.
        Scanner customerChoice = new Scanner(System.in);
        String department = "Customer";
        System.out.println("\n" +
                "Welcome to the store:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To search Products\n" +
                "\n" +
                "Press 2: To ask for help from our Sales Team\n" +
                "\n" +
                "Press 3: To view replies to inquiries\n" +
                "\n" +
                "Press 4: To log out");
        switch (customerChoice.nextInt()) {
            case 1:
                SearchProducts.main(department);
                break;
            case 2:
                Inquiries.inquire();
                break;
            case 3:
                Inquiries.viewReplies();
                break;
            case 4:
                logOut();
                break;
            default:
                System.out.println("That was not a valid input please try again");
                CustomerMenu();
        }

    }

    private static void manageProductInformation(String department) {
        //This will connect with the Products java classes where the user can manage the Products table in the database. Or they can return to the previous menu.
        Scanner productChoice = new Scanner(System.in);
        System.out.println("Product Information:\n" +
                "Please select a function:\n" +
                "\n" +
                "Press 1: To add a Product\n" +
                "\n" +
                "Press 2: To search Products\n" +
                "\n" +
                "Press 3: To delete a Product\n" +
                "\n" +
                "Press 4: To view Products\n" +
                "\n" +
                "Press 5: To edit Products\n" +
                "\n" +
                "Press 6: To return Home");
        switch (productChoice.nextInt()) {
            case 1:
                InsertProducts.main(department);
                break;
            case 2:
                SearchProducts.main(department);
                break;
            case 3:
                DeleteProducts.main(department);
                break;
            case 4:
                ViewProducts.main(department);
                break;
            case 5:
                EditProducts.main(department);
                break;
            case 6:
                returnHome(department);
                break;
            default:
                System.out.println("That was not a valid input please try again");
                manageProductInformation(department);

        }
        returnHome(department);
    }

        private static void manageWarehouseInformation (String department) {
        //This will connect with the Warehouse java classes where the user can manage the Warehouse table in the database. Or they can return to the previous menu.
        Scanner warehouseChoice = new Scanner(System.in);
            System.out.println("Warehouse Information:\n" +
                    "Please select a function:\n" +
                    "\n" +
                    "Press 1: To add a Warehouse\n" +
                    "\n" +
                    "Press 2: To search Warehouses\n" +
                    "\n" +
                    "Press 3: To delete a Warehouse\n" +
                    "\n" +
                    "Press 4: To View Warehouses\n" +
                    "\n" +
                    "Press 5: To Edit Warehouses\n" +
                    "\n" +
                    "Press 6: To return Home");
            switch (warehouseChoice.nextInt()) {
                case 1:
                    InsertWarehouse.main(department);
                    break;
                case 2:
                    SearchWarehouses.main(department);
                    break;
                case 3:
                    DeleteWarehouse.main(department);
                    break;
                case 4:
                    ViewWarehouses.main(department);
                    break;
                case 5:
                    EditWarehouse.main(department);
                    break;
                case 6:
                    returnHome(department);
                    break;
                default:
                    System.out.println("That was not a valid input please try again");
                    manageWarehouseInformation(department);

            }
            returnHome(department);

        }

        private static void managePurchases (String department) {
        //This will connect with the Purchases java classes where the user can manage the Purchases table in the database. Or they can return to the previous menu.
        Scanner purchaseChoice = new Scanner(System.in);
            System.out.println("Purchase Information:\n" +
                    "Please select a function:\n" +
                    "\n" +
                    "Press 1: To add a Purchase\n" +
                    "\n" +
                    "Press 2: To search Purchases\n" +
                    "\n" +
                    "Press 3: To delete a Purchase\n" +
                    "\n" +
                    "Press 4: To View Purchases\n" +
                    "\n" +
                    "Press 5: To Edit Purchases\n" +
                    "\n" +
                    "Press 6: To return Home");
            switch (purchaseChoice.nextInt()) {
                case 1:
                    InsertOrders.main(department);
                    break;
                case 2:
                    SearchOrders.main(department);
                    break;
                case 3:
                    DeleteOrder.main(department);
                    break;
                case 4:
                    ViewOrders.main(department);
                    break;
                case 5:
                    EditOrders.main(department);
                    break;
                case 6:
                    returnHome(department);
                    break;
                default:
                    System.out.println("That was not a valid input please try again");
                    managePurchases(department);
            }
            returnHome(department);

        }

        private static void manageInquiries (String department) {
        //This menu connects to Inquiries class where the user can manage the inquiries table in the database.
            Scanner inquiriesChoice = new Scanner(System.in);
            System.out.println("Inquiries Page:\n" +
                    "Press 1: To View Inquiries\n" +
                    "Press 2: To Reply \n" +
                    "Press 3: To Return Home\n");
            switch (inquiriesChoice.nextInt()) {
                case 1:
                    Inquiries.viewInquiries(department);
                    break;
                case 2:
                    Inquiries.reply(department);
                    break;
                case 3:
                    returnHome(department);
                    break;
                default:
                    System.out.println("That was not a valid input please try again");
                    manageUserDatabase(department);
            }
            returnHome(department);
        }

        private static void manageUserDatabase (String department) {
        //This will connect with the User java classes where the user can manage the Users table in the database. Or they can return to the previous menu.
        Scanner purchaseChoice = new Scanner(System.in);
        System.out.println("User Information:\n" +
                    "Please select a function:\n" +
                    "\n" +
                    "Press 1: To add a User\n" +
                    "\n" +
                    "Press 2: To search Users\n" +
                    "\n" +
                    "Press 3: To delete a User\n" +
                    "\n" +
                    "Press 4: To View Users\n" +
                    "\n" +
                    "Press 5: To Edit Users\n" +
                    "\n" +
                    "Press 6: To return Home");
            switch (purchaseChoice.nextInt()) {
                case 1:
                    InsertUser.main(department);
                    break;
                case 2:
                    SearchUsers.main(department);
                    break;
                case 3:
                    DeleteUsers.main(department);
                    break;
                case 4:
                    ViewUsers.main(department);
                    break;
                case 5:
                    EditUser.main(department);
                    break;
                case 6:
                    returnHome(department);
                    break;
                default:
                    System.out.println("That was not a valid input please try again");
                    manageUserDatabase(department);
            }
            returnHome(department);

        }

        public static void returnHome(String department){
        //This will return the User to their department's menu.
            if (department.equals("Manager")) {
                ManagerMenu();
            } else if (department.equals("Sales")) {
                SalesMenu();
            } else if (department.equals("Production")) {
                ProductionMenu();
            } else if (department.equals("Purchasing")) {
                PurchasingMenu();
            }else if (department.equals("Customer")) {
                    CustomerMenu();
            } else {
                main(null);
            }
        }

        private static void contactPurchasing(String department){
        //For external contact using company emails
        System.out.println("To Contact The Purchasing Department please use InventoryPurchasing@gmail.com");
        returnHome(department);
        }

        private static void contactProduction(String department){
        //For external contact using company emails
        System.out.println("To Contact The Purchasing Department please use InventoryProduction@gmail.com");
        returnHome(department);
        }

        private static void logOut () {
        //This will take the user back to the main menu.
        Main.main(null);
        }

        private static Connection connect () {
            //This connects the java class to the database.
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



