//Şərt:
//Verilmiş String tipli sözün palindrome olub-olmadığını yoxlayın.
//Palindrome — tərsinə oxunduqda da eyni olan sözdür.
//
//Nümunə:
//
//String word = "madam";
//
//
//Gözlənilən çıxış:
//
//madam palindrome-dur.


import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        String word = "madam";
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        if  (word.equals(reversed)) {
            System.out.println("It is a palindrome word");
        }
        else {
            System.out.println("It is not a palindrome word");
        }
        }
    }



