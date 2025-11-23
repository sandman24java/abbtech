//
//Şərt:
//Verilmiş int[] tipli massivdən istifadə edərək:
//
//Ən böyük ədədi tapın.
//Ən kiçik ədədi tapın.
//Hər iki ədədi ekrana çap edin.
//
//Nümunə kod:
//
//int[] numbers = {4, 7, -2, 15, 0, 99, -100};
//
//
//Gözlənilən çıxış:
//
//Ən böyük ədəd: 99
//Ən kiçik ədəd: -100



//Method 1 if else Method
public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {4, 7, -2, 15, 0, 99, -100};
//        int max_number = numbers[0];
//        int min_number = numbers[0];
//        for (int i = 1; i < numbers.length; i++){
//        if (numbers[i] > max_number){
//            max_number = numbers[i];
//        }
//        else{
//            min_number = numbers[i];
//        }
//        }
//        System.out.println(max_number);
//        System.out.println(min_number);
//    }
//    }



//Method 2 Math class method
        int max_number = numbers[0];
        int min_number = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            max_number = Math.max(max_number, numbers[i]);
            min_number = Math.min(max_number,numbers[i]);
        }
        System.out.println(max_number);
        System.out.println(min_number);
    }
}





