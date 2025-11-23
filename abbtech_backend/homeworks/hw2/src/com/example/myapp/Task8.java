package com.example.myapp;
import java.util.Scanner;


//A "Strong number" is defined as follows:
//
//If the sum of the factorials of each digit of the number equals the number itself, then it is a .
//145 → 1! + 4! + 5! = 1 + 24 + 120 = → ✅
//        123 → 1! + 2! + 3! = 1 + 2 + 6 = ≠ 123 → ❌
//Calculate the factorial for each digit.
//Sum them up and compare the result with the original number.



public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check if it is a \"Strong\" one");
        int number_input = sc.nextInt();
        int number_to_check = number_input;
        if (number_input >= 1) {
            int result = 0;
            for (int i = 1; i <= Integer.toString(number_to_check).length(); i++) {
                int factorial_digit = 1;
                int digit = number_input%10;
                for (int j = 1; j <= digit; j++) {
                    factorial_digit *= j;
                }
                result += factorial_digit;
                number_input = number_input / 10;
            }
            if (result == number_to_check){
                System.out.println("The number " + number_to_check + " is a strong one");
            }
        }
    }







    }

