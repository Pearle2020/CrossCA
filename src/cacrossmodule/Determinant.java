/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacrossmodule;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author ca_ro
 */

 // The class will find the 
// Determinant of a matrix
public class Determinant {
    
    public  static void Inverse2X2(){
     //Create a Matrix to store a 2X2 Matrix   
        int[][] arr = new int[2][2];  
        double[][] arrReults = new double[2][2];	
	int i, j;    
	double determinant=0;      
	Scanner sc= new Scanner(System.in);
		
	System.out.println("\n Please Enter the Matrix Items :  ");
            // for each loop related with the rows
	    for(i = 0; i < 2; i++) {
                // for each loop related to the column
                for(j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
            }		
	}
                
	//determinant calculation
                
	determinant = (arr[0][0] * arr[1][1]) - (arr[0][1] * arr[1][0]);

        System.out.println("The Determinant of 2 * 2 Matrix = " + determinant );
		
        System.out.println("================================================");
        
        System.out.println("\n The Inverse of Matrix is:");
                
              
                //for loop related to the row
        for(i = 0; i < 2; ++i){
            // for loop related to the column
            for(j = 0; j < 2; ++j){
            //Inverse of Matrix calculation
            double result = (arr[i][j]/determinant);
            arrReults[i][j] = result;                   
                System.out.println(result);
            System.out.print("\n");
           }
        }

        double arrFun1 = 0;
        double arrFun2 = 0;
        
        System.out.println("\n Please type the number of the Matrix 2X1:  ");
        
        //array on the inputs to get the number of variables for the second matrix 
        for(i = 0; i < 2; i++) {
            if(i == 0)
                arrFun1 = sc.nextInt();
            if(i == 1)
                arrFun2 = sc.nextInt();
            
        }

        for(i = 0; i < 2; ++i){
            for(j = 0; j < 2; ++j){ 
                double invxf1=  (arrFun1) * (arrReults[i][j]); 
                double invxf2=  (arrFun2) * (arrReults[i][j]); 
               
               //everytime when is on the last column it'll print thr result 
               if (j==1)
               
               //Result of equation 
               {      
                   double Total = (invxf1) + (invxf2);
                   System.out.println("======================================="); 
                   System.out.println("The result of the equation is = "+Total);
               }
           
               
           
        }
        
        
        }
    }
  
    
    public static void Inverse3X3(){         
        Scanner sc1 = new Scanner(System.in);
        sc1= new Scanner(System.in);
         // Create a Matrix 3X3 using array         
        int[][] arr = new int[3][3];
        double[][] arrReults = new double[3][3];
        
        int i, j = 0, x, y, z;
        double determinant=0;
       
        System.out.println("\n Please Enter the Matrix Items :  ");
        // for each loop related with the row
        for(i = 0; i < 3; i++) {
               // for each loop related with the column
                for(j = 0; j < 3; j++) {

                        arr[i][j] = sc1.nextInt();
                }		
        }

        x = (arr[1][1] * arr[2][2]) - (arr[2][1] * arr[1][2]);
        y = (arr[1][0] * arr[2][2]) - (arr[2][0] * arr[1][2]);
        z = (arr[1][0] * arr[2][1]) - (arr[2][0] * arr[1][1]);

        //determinant calculation
        determinant = (arr[0][0] * x)- (arr[0][1] * y) + (arr[0][2] * z);

        System.out.println("The Determinant of 3 * 3 Matrix = " + determinant );
        System.out.println("=================================================");
        System.out.println("\n The Inverse of Matrix is: ");

        //for loop related to the row
        for(i = 0; i < 3; ++i){
              // for loop related to the column
            for(j = 0; j < 3; ++j){
               //Inverse of Matrix calculation
                double result = (((arr[(j+1)%3][(i+1)%3] * arr[(j+2)%3][(i+2)%3]) - (arr[(j+1)%3][(i+2)%3] * arr[(j+2)%3][(i+1)%3]))/ determinant);
                arrReults[i][j] = result;                   
                System.out.print(result + " ");
                
           }
                System.out.print("\n");
        }

        int arrFun1 = 0;
        int arrFun2 = 0;
        int arrFun3 = 0;
        System.out.println("\n Please type the number of the Matrix 3X1:  ");
        
        //array on the inputs to get the number of variables for the second matrix 
        for(i = 0; i < 3; i++) {
            if(i == 0)
                arrFun1 = sc1.nextInt();
            if(i == 1)
                arrFun2 = sc1.nextInt();
            if(i == 2)
                arrFun3 = sc1.nextInt();
        }

        for(i = 0; i < 3; ++i){
            
            for(j = 0; j < 3; ++j){ 
                double invxf1=  (arrFun1)*arrReults[i][j]; 
                double invxf2=  (arrFun2)*arrReults[i][j]; 
                double invxf3=  (arrFun3)*arrReults[i][j]; 
      
      //when interate to the array through the column 3 the following code will run      
                if(j==2){
                double Total = (invxf1)+(invxf2)+(invxf3);
                arrReults[i][j] = Total;    
                System.out.println("===============================================");
                System.out.println("The result of the equation is  "+Total);
                
                System.out.println("\n");
           }
                
            
        }
        

    }
    
    }
}
    
    


    
