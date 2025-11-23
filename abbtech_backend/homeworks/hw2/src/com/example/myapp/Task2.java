package com.example.myapp;

//Task 2:
//Ask the user to enter a number between 1 and 7. Print the corresponding day of the week for that number.
//
//For example:
//
//1 – Monday
//
//2 – Tuesday
//
//... and so on.


import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to receive a corresponding day of the week");
        int user_input = sc.nextInt();
        String[] days_of_week = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        System.out.println(user_input + "-"+ days_of_week[user_input-1]);

    }
}

