
//Şərt:
//Verilmiş String tipli mətni (sözü) tərsinə çevirin və yeni yaranmış string-i ekrana çap edin.
//
//Nümunə:
//
//String input = "OpenAI";
//
//
//Gözlənilən çıxış:
//
//Tərsinə çevrilmiş string: IanepO


import java.util.Scanner;

public class Task5 {
    public static void main(String[] args){
        String input = "OpenAI";
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        System.out.println(reversed);



    }
}
