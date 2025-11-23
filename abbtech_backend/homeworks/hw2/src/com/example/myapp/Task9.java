package com.example.myapp;
import java.util.Scanner;

//An is defined as:
//
//If the sum of each digit raised to the power of the number of digits equals the number itself, then it is an .
//        153 → 1³ + 5³ + 3³ = 1 + 125 + 27 = → ✅
//        9474 → 9⁴ + 4⁴ + 7⁴ + 4⁴ = 6561 + 256 + 2401 + 256 = → ✅
//        123 → 1³ + 2³ + 3³ = 1 + 8 + 27 = ≠ 123 → ❌
//Extract the digits of the number.
//Count how many digits it has.
//Raise each digit to the power of the number of digits.
//Sum the results and compare with the original number.







public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check if it is a \"Armstrong number\"");
        int number_input = sc.nextInt();
        int number_to_check = number_input;
        int numbers_quantity = Integer.toString(number_to_check).length();
        int result = 0;
        for (int i = 1; i <= numbers_quantity; i++) {
            int digit = number_input % 10;
            int digit_in_cube = (int)Math.pow(digit, numbers_quantity);
            result+=digit_in_cube;
            number_input = number_input / 10;
        }
        if (number_to_check == result){
            System.out.println("The number is a \"Armstrong number\"");
        }
    }
}




