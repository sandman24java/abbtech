package com.example.myapp;
import java.util.Scanner;


//Task 7:
//Ask the user to enter a number and calculate its factorial.
//If the user enters a negative number, print "Factorial does not exist for negative numbers".
//Use loops and (like i++ or --) during the calculation.
//Print the result.





public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number to calculate its factorial ");
        int number_input = sc.nextInt();
        if (number_input>0) {
            int result = 1;
            for (int i = 1; i <= number_input; i++) {
                result *= i;
            }
            System.out.println(result);
        }
        else
            System.out.println("Factorial does not exist for negative numbers");












    }
}
