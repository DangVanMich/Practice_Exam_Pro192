/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validateInput;

import java.util.Scanner;

public class ValidateInput {

    public static String stringEmpty(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.println("Enter " + name);
            s = sc.next();
        }
        return s;
    }
    
    public static int validateInputInt(String name, int min){
        Scanner sc  = new Scanner(System.in);
        int number = 0;
        while(number<=min){
            System.out.println("Enter "+name);
            number = sc.nextInt();
        }
        return number;
    }
}
