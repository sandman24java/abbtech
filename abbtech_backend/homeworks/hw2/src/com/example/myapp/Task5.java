package com.example.myapp;
import java.util.Scanner;

//Task 5:
//Ask the user to enter their age and gender (M or F).
//If the user is under 18, print "Access denied".
//If the user is 18 or older, print:
//For M: "Male access granted"
//For F: "Female access granted"


public class Task5 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your gender... ");
            String gender_input = sc.nextLine();
            System.out.println("Enter your age: ");
            int age_input = sc.nextInt();
            if (age_input>=18) {
                if (gender_input.equals("M"))
                    System.out.println("Male access granted");
                else if (gender_input.equals("F"))
                    System.out.println("Female access granted");
                else
                   System.out.println("Invalid gender");
            }
            else
                System.out.println("Access denied");
            }










    }

