package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
   
    int num1 =1;
    int num2 =2;
    String END ,Fname , Lname , Password , Uname ,AGAIN;
   Connection conn= null;
   Statement DB= null;
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

    public String getUname() {
        return Uname;
    }

    public void setUname(String Uname) {
        this.Uname = Uname;
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
   
    
   
    Scanner scan= new Scanner(System.in);
    
     public Connection getConnection() throws Exception {

        try {

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mycadb";
            String username = "root";
            String password = "mbakoppearle2004";
            Class.forName(driver);
           Connection conn = DriverManager.getConnection(url, username, password);
          //  System.out.println("-----------------------------------------------");
           // System.out.println("Database Updated!");
           // System.out.println("-----------------------------------------------");
           return conn;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

        
    } 
     public void menu ()throws Exception {
         try {
             
          System.out.println ("----------------------------------------");
          System.out.println ("Welcome to CCT platform");
          System.out.println("----------------------------------------");
          System.out.println("Please Select One Option");
          System.out.println("----------------------------------------");
          System.out.println("1) Sign in");
          System.out.println("2) Register");
          int log = scan.nextInt();
          
             if (log == num1) {
                 signin();
             } 
             else {
                 System.out.println("please choose one of the option above");
             }
             if (log == num2) {
                 registration();
             } 
             else {
             }
         }
         catch (Exception e) {
             System.out.println("please choose one of the option above ");
         }
   
     } 
     public void signin()throws Exception{
         try {
            System.out.println ("----------------------------------------");
            System.out.println ("Welcome dear User");
            System.out.println ("----------------------------------------");
            System.out.println ("Please select your Domain");
            System.out.println ("----------------------------------------");
            System.out.println("1) Admin");
            System.out.println("2) User");
            int log = scan.nextInt();
             
             if (log== num1) {
                 ad();
             }
             if( log== num2){
                         
                         }
             String exit= scan.next();
             if ( exit.equals("END")) {
                 menu();
                 
             }
                     
         } 
         catch (Exception e) {
             System.out.println("please choose one of the option above or type in END to exit");
            
         }
     }
     public void registration() throws Exception{
         try {
           System.out.println ("----------------------------------------");
            System.out.println (            "Welcome to CCT"             );
            System.out.println ("----------------------------------------");
            System.out.println ("----------------------------------------");
            System.out.println (       "Please fill in your details"      );
            System.out.println ("----------------------------------------");
            System.out.println ("****************************************");
             System.out.println ("*  Please type in your First Name*");
             String Fname = scan.next();
             System.out.println ("*  Please type in your Last Name*");
             String Lname = scan.next();
             System.out.println ("*  Please type in your User Name*");
             String Uname = scan.next();
             System.out.println ("*  Please type in your Password*");
             String PassWord = scan.next();
             System.out.println ("****************************************");
             Connection con = getConnection();
             DB =conn.createStatement();
            1String query = "INSERT INTO user(user_firstname,user_lastname,user_username,user_password )"+ "values (?,?,?,?)";
            PreparedStatement insert = con.prepareStatement(query);
            insert.setString(1, this.getFname());
            insert.setString(2, this.getLname());
            insert.setString(3, this.getUname());
            insert.setString(4, this.getPassword());
            DB.executeUpdate(query);
             
            
         } 
         catch (Exception e) {
              System.out.println("please choose one of the option above");
         }
     }
     public void  ad() throws Exception{
         try {
             System.out.println ("*****************************************");
          System.out.println ("Welcome to your Admin Platform");
          System.out.println("****************************************");
          System.out.println("Fill in your Login details");
          System.out.println("***************************************");
          System.out.println("User Name:");
          String Uname = scan.next();
          System.out.println("Password:");
          String Password = scan.next();  
         }
         catch (Exception e) {
             System.out.println("INVALID Login details.Type in AGAIN to try again");
             String exit = scan.next();
             if (exit.equals("AGAIN")) {
                 ad();
                 
             }
             
         }
          
     }
     
}
