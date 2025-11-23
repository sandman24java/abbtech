package com.example.myapp;

//Task 1:
//Ask the user to enter a number. Determine if the number is positive, negative, or zero, and print the result.


import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int user_input = sc.nextInt();
        if (user_input < 0) {
            System.out.println("Your input is negative");
        } else if (user_input > 0) {
            System.out.println("Your input is positive");
        } else {
            System.out.println("Your input is zero");
        }
    }
}
