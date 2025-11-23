package com.example.myapp;
import java.util.Scanner;


//Task 6:
//Write a program that prints Fibonacci numbers.
//
//Ask the user how many Fibonacci numbers to print.
//If the entered number is zero or negative, print "Please enter a valid number".
//Use loops to print the Fibonacci sequence.
//Use a to show whether each Fibonacci number is even or odd.





public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how many Fibonacci numbers should be printed ");
        int quantity_numbers = sc.nextInt();
        int first_number = 0;
        int second_number = 1;
        String odd_even_output_1 = first_number % 2 == 0 ? "Even" : "Odd";
        String odd_even_output_2 = second_number % 2 == 0 ? "Even" : "Odd";

        if (quantity_numbers <= 0) {
            System.out.println("Please enter a valid number");
        } else if (quantity_numbers == 1) {
            System.out.println(first_number + " " + odd_even_output_1);
        } else if (quantity_numbers >= 2) {
            System.out.println(first_number + " " + odd_even_output_1 + "\n " + second_number + " " + odd_even_output_2);
            if (quantity_numbers > 2) {
                for (int i = 0; i < quantity_numbers - 2; i++) {
                    int result = first_number + second_number;
                    first_number = second_number;
                    second_number = result;
                    String odd_even_output_3 = result % 2 == 0 ? "Even" : "Odd";
                    System.out.println(result + " " + odd_even_output_3);
                }
            }
        }
    }
}

