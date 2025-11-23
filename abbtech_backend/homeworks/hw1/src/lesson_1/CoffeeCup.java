package lesson_1;

public class CoffeeCup {
    public static void main(String[] args) {
        // 1. Declare an int primitive variable and an Integer wrapper variable.
        int amount = 50;
        Integer amount_wrapped = 50;


        // 2. Assign the int value to the Integer variable (autoboxing).
        Integer amount_wrapped_cl = amount;


        // 3. Declare another Integer wrapper variable and assign it a value.
        Integer capacity_wrapped = 80;


        // 4. Assign the Integer value to an int variable (unboxing).
        int capacity = capacity_wrapped;


        // Print the results
        System.out.println(amount);
        System.out.println(amount_wrapped);
        System.out.println(amount_wrapped_cl);
        System.out.println(capacity_wrapped);
        System.out.println(capacity);
    }
}




