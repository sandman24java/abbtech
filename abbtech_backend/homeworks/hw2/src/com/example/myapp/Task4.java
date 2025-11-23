package com.example.myapp;
import java.util.Scanner;


//Ask the user to enter a number. Perform the following checks:
//If the number is a palindrome (e.g., 12321), display:
//If the digits of the number are in increasing order (e.g., 123489), indicate that.
//If the digits of the number are in decreasing order (e.g., 97530), indicate that.
//Otherwise, display:  "The digits are neither in increasing nor decreasing order."



public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check the requirements");
        String user_input = sc.nextLine();
        String reversed = "";

        for (int i = user_input.length() - 1; i >= 0; i--) {
            reversed += user_input.charAt(i);
        }
        int increase_check_number = Integer.parseInt(user_input);
        int decrease_check_number = increase_check_number;
        int reversed_number = Integer.parseInt(reversed);
        if (increase_check_number == reversed_number) {
            System.out.println("It is a palindrome number");
        }
        
        boolean increasing = true,decreasing = true;
        while (increase_check_number >= 10) {
            int last_number = increase_check_number % 10;
            int previous_number = (increase_check_number / 10) % 10;
            if (last_number > previous_number) {
                increase_check_number = increase_check_number / 10;
            }
            else {
                increasing = false;
                break;
            }
        }
        while (decrease_check_number >= 10) {
            int last_number = decrease_check_number % 10;
            int previous_number = (decrease_check_number / 10) % 10;
            if (last_number < previous_number) {
                decrease_check_number = decrease_check_number / 10;
            }
            else {
                decreasing = false;
                break;
            }
        }


        if (increasing) {
            System.out.println("Numbers are in fully increasing order");
        }
        if (decreasing) {
            System.out.println("Numbers are in fully decreasing order");
        }
        if (!increasing && !decreasing) {
            System.out.println("Numbers are neither fully increasing nor strictly decreasing");
        }
    }
}
