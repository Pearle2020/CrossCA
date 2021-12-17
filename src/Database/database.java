package Database;

import static cacrossmodule.Determinant.Inverse2X2;
import static cacrossmodule.Determinant.Inverse3X3;
import static cacrossmodule.UI.UI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tchat
 */

public class database {

    int num1 = 1;
    int num2 = 2;
    String END, Fname, Lname, Password, Uname, AGAIN;
    Connection conn;
    Statement st;
    ResultSet rs;
    String BACK;

    public String getEND() {
        return END;
    }

    public void setEND(String END) {
        this.END = END;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String Uname) {
        this.Uname = Uname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
  public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    Scanner scan = new Scanner(System.in);

    public Connection getConnection() throws Exception {

        try {

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://@localhost:3306/mycadb";
            String username = "root";
            String password = "mbakoppearle2004";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);

            //jdbc:mysql://localhost:3306/?user=root
            return conn;

        } catch (Exception e) {

            System.out.println(e);
        }

        return null;

    }

    public void menu() throws Exception {
        try {

            System.out.println("----------------------------------------");
            System.out.println("Welcome to CCT platform");
            System.out.println("----------------------------------------");
            System.out.println("Please Select One Option");
            System.out.println("----------------------------------------");
            System.out.println("1) Sign in");
            System.out.println("2) Register");
            int log = scan.nextInt();

            if (log == num1) {
                signin();
            } else {
                System.out.println("please choose one of the option above");
            }
            if (log == num2) {
                registration();
            } else {
            }
        } catch (Exception e) {
            System.out.println("please choose one of the option above ");
        }

    }

    public void signin() throws Exception {
        try {
            System.out.println("----------------------------------------");
            System.out.println("Welcome dear User");
            System.out.println("----------------------------------------");
            System.out.println("Please select your Domain");
            System.out.println("----------------------------------------");
            System.out.println("1) Admin");
            System.out.println("2) User");
            int log = scan.nextInt();

            if (log == num1) {
                ad();
            }
            if (log == num2) {
                Ruser();
            }
            String exit = scan.next();
            if (exit.equals("END")) {
                menu();

            }

        } catch (Exception e) {
            System.out.println("please choose one of the option above or type in END to exit");

        }
    }

    public void registration() throws Exception {
        try {
            System.out.println("----------------------------------------");
            System.out.println("Welcome to CCT");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("Please fill in your details");
            System.out.println("----------------------------------------");
            System.out.println("****************************************");
            System.out.println("*  Please type in your First Name*");
            String Fname = scan.next();
            this.Fname = Fname;
            System.out.println("*  Please type in your Last Name*");
            String Lname = scan.next();
            this.Lname = Lname;
            System.out.println("*  Please type in your User Name*");
            String Uname = scan.next();
            this.Uname = Uname;
            System.out.println("*  Please type in your Password*");
            String Password = scan.next();
            this.Password = Password;
            System.out.println("****************************************");
            PreparedStatement prepareStatement = null;
            String query = "INSERT INTO user(user_id,firstName,lastName,user_name,password )" + "values (?,?,?,?,?)";
            int i = 0;
            i = i++;
            try {
                Connection conn = getConnection();// get connection
                PreparedStatement insert = conn.prepareStatement(query);//create the preparedStatement
                //set the values
                insert.setInt(1, i);
                insert.setString(2, Fname);
                insert.setString(3, Lname);
                insert.setString(4, Uname);
                insert.setString(5, Password);
                insert.executeUpdate(); // execute the querry
                // close the connection with database
                insert.close();
                conn.close();
                System.out.println("Details Insert to out database");
                System.out.println("Please type in MENU to login");
                String login = scan.next();
                if (login.equals("MENU")) {
                    signin();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        } catch (Exception e) {

            System.out.println("please choose one of the option above");
        }
    }

    public void ad() throws Exception {
        try {
            System.out.println("*****************************************");
            System.out.println("Welcome to your Admin Platform");
            System.out.println("****************************************");
            System.out.println("Fill in your Login details");
            System.out.println("***************************************");
            loginvalidator();
            menuad();
        } catch (Exception e) {
            System.out.println("INVALID Login details.Type in AGAIN to try again");
            String exit = scan.next();
            if (exit.equals("AGAIN")) {
                ad();

            }

        }

    }

    public void Ruser() throws Exception {
        try {
            System.out.println("__________________________________________________________");
            System.out.println("______________Welcome Back to CCT Platform________________");
            System.out.println("_________________________________________________________");
            System.out.println("_____________________Please fill in your Authentification____________");
            System.out.println("__________________________________________________________");
            loginvalidator1();
            menuuser();
        } catch (Exception e) {
        }

    }

    public void modification() throws Exception {
        try {
            Connection conn = getConnection();

            String query4 = "UPDATE admin SET firstName =? ,lastName =? ,Password =? ,userName=? WHERE LIKE (?,?,?,?)";
            // this querry give the possibilities to modify anything in the database of the user table
            PreparedStatement pstmt = conn.prepareStatement(query4);
            System.out.println("enter your modifications");
            System.out.println("\n firstname:");
            this.Fname = scan.next();
            System.out.println("\n lastname:");
            this.Lname = scan.next();
            System.out.println("\n username:");
            this.Uname = scan.next();
            System.out.println("\n password:");
            this.Password = scan.next();
            //assign parameters for statement
            pstmt.setString(1, this.Fname);
            pstmt.setString(2, this.Lname);
            pstmt.setString(3, this.Uname);
            pstmt.setString(4, this.Password);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery(query4);
            while (rs.next()) {
                System.out.println(rs.getString("firstname") + rs.getString("lastname") + rs.getString("userName") + rs.getString("Password"));
            }
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public void loginvalidator1() throws Exception {
        try {

            Connection conn = getConnection();
            String query2 = "SELECT password , user_name FROM user";
            Statement stmt = (Statement) conn.createStatement();
            System.out.println("User Name:");
            Uname = scan.next();
            System.out.println("Password:");
            Password = scan.next();
            rs = stmt.executeQuery(query2);
            while (rs.next()) {

                if (rs.getString("user_name").equals(Uname) && rs.getString("password").equals(Password)) {
                    System.out.println("Your are connected");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginvalidator() throws Exception {
        try {

            Connection conn = getConnection();
            String query2 = "SELECT password , userName FROM admin";
            Statement stmt = (Statement) conn.createStatement();
            System.out.println("User Name:");
            Uname = scan.next();// check if the user input is similar with hat is in the database
            System.out.println("Password:");
            Password = scan.next();// check if the user input is similar with hat is in the database
            rs = stmt.executeQuery(query2);
            while (rs.next()) {

                if (rs.getString("userName").equals(Uname) && rs.getString("password").equals(Password)) {
                    System.out.println("Your are connected");// verification code line 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuad() throws Exception {
        int i;
        try {
            System.out.println("____________________________");
            System.out.println(" Welcome dear ADMIN");
            System.out.println("this is your main menu");
            System.out.println("________________________________");
            System.out.println("1-Modify my profile");
            System.out.println("2-List of all users");
            System.out.println("3-Remove a user");
            System.out.println("4-Review operation");// print out the menu
            i = scan.nextInt();// choose one option from the menu list
            if (i == 1) {
                modification();
            }
            if (i == 2) {
                list();

            }
            if (i == 3) {
                remove();
            }
            if (i == 4) {

            }
            System.out.println("Type BACK to go back to the previous menu");
            String Back = scan.next();
            if (BACK.equals(Back)) {
                menuad();
            }
        } catch (Exception e) {

        }
    }

    public void menuuser() throws Exception {
        int i;
        try {
            System.out.println("____________________________");
            System.out.println(" Welcome dear USER");
            System.out.println("________________________________");
            System.out.println("this is your main menu");
            System.out.println("________________________________");
            System.out.println("Type in the Letter corresponding to your choose");
            System.out.println("________________________________");
            System.out.println("1-Modify my profile");
            System.out.println("2-Solve equation");
            System.out.println("3-Save result");
            // print out the menu
            i = scan.nextInt();// choose one option from the menu list
            if (i == 1) {
                modification();
            }
            if (i == 2) {
                solve();

            }
            if (i == 3) {
                save();
            }

            System.out.println("Type BACK to go back to the previous menu");
            String Back = scan.next();
            if (BACK.equals(Back)) {
                menuad();
            }
        } catch (Exception e) {

        }
    }

    public void list1() throws Exception { // print the list of users
        try {
            System.out.println("List of Admin");
            Connection conn = getConnection();
            Statement stmt = (Statement) conn.createStatement();
            String query3 = " SELECT idAdmin, firstName, lastName FROM admin";
            ResultSet rs = stmt.executeQuery(query3);
            while (rs.next()) {
                //retrieve by column name
                String first = rs.getString("firstName");
                String last = rs.getString("lastName");
                int id = rs.getInt("idAdmin");

                //display values
                System.out.print("id:" + id + "\r\n");
                System.out.print("firstname:" + first + "\r\n");
                System.out.print("lastname:" + last + "\r\n");

            }

        } catch (Exception e) {
            menuad();
        }
    }

    public void list() throws Exception {
        try {
            System.out.println("List of Users");
            Connection conn = getConnection();// gets the connection
            Statement stmt = (Statement) conn.createStatement();//
            String query3 = " SELECT user_id, firstName, lastName FROM user"; // set tthe querry with the database
            ResultSet rs = stmt.executeQuery(query3);
            while (rs.next()) {
                //retrieve by column name
                String first = rs.getString("firstName");
                String last = rs.getString("lastName");
                int id = rs.getInt("user_id");// analyse if the input 

                //display values
                System.out.print("id:" + id + "\r\n");
                System.out.print("firstname:" + first + "\r\n");
                System.out.print("lastname:" + last + "\r\n");

            }

        } catch (Exception e) {
        }
    }

    public void solve() throws Exception {
        UI();
        Inverse2X2();
        Inverse3X3();
    }

    public void remove() throws Exception {
        try {
           Connection conn = getConnection(); 
            System.out.println("________________________________");
            System.out.println("Type in the firstname and lastname of the user you want to remove");
            System.out.println("________________________________");
            System.out.println("firstname");  
            this.Fname = scan.next();
              System.out.println("lastname"); 
             this.Lname= scan.next();        
         String query6 = "DELETE * FROM user WHERE firstName, lastName" + "VALUE(?,?)";  
         PreparedStatement pstmt =  conn.prepareStatement(query6);
        pstmt.setString(1, this.Fname);
            pstmt.setString(2, this.Lname);
              rs.deleteRow();
            pstmt.executeUpdate();
           
           rs.close();
            }
     
         
        catch (Exception e) {
            
        }
}

    public void save() throws Exception {
        
                
    }
    }


    
