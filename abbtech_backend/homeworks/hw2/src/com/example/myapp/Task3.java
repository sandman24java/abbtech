package com.example.myapp;
import java.util.Scanner;

//Task 3:
//Ask the user to enter a number. Using a loop, print all the odd numbers up to that number.


public class Task3 {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter the number to see the odd numbers up to it ");
          int user_input = sc.nextInt();
          for (int i = 1; i <= user_input; i++) {
              int divider_output = i%2;
              if (divider_output != 0){
                  System.out.println(i);
              }
              }



    }

}
