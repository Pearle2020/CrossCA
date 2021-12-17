/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacrossmodule;

import java.util.Scanner;

/**
 *
 * @author ca_ro
 */
public class UI {
    
    public static void UI(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter The Number Of The Rows For The First Matrix ");         
        int matrixRow = scan.nextInt();
         
        System.out.println("Enter The Number Of The Columns For The Matrix ");         
        int matrixCol = scan.nextInt();
        
        System.out.println("");      
        
        if(matrixRow==2&&matrixCol==2){
            System.out.println("So then your second Matrix will have 2 rows (X and Y) an 1 column.");
            //SHOWS DETERMINANT AND INVERSE OF MATRIX 2x2
            Determinant.Inverse2X2();
        } else if(matrixRow==3&&matrixCol==3){
            System.out.println("So then your second Matrix will have 3(X, Y and Z) rows an 1 column.");
             //SHOWS DETERMINANT AND INVERSE OF MATRIX 3x3
            Determinant.Inverse3X3();
         }else{
             System.out.println("This program only calculate 2X2 or 3X3 Matrices."
                     + " Try again.");
         }
        System.out.println("Operation done!");
         
    }  
}
