//Şərt:
//Verilmiş int[] tipli massivi artan sıraya görə sort edin.
//Daha sonra həmin massivin tərs versiyasını (azalan sıra ilə) ekrana çap edin.
//Arrays.sort() metodundan istifadə etməyin.
//
//Nümunə:
//
//int[] arr = {10, 5, 8, 3, 1};
//
//
//Gözlənilən çıxış:
//
//Tərsinə sort edilmiş array: 10 8 5 3 1


import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = {10,5,8,3,1};
        int EMPTY = Integer.MIN_VALUE;
        int[] array_sorted = new int[5];
        int n = 0;
        for (int j = 0; j < arr.length; j++)
        {   int max_number = arr[0];
            for (int i = 0; i < arr.length; i++){
                max_number = Math.max(max_number, arr[i]);
            }

            for(int i = 0; i < arr.length; i++){
                if (arr[i] == max_number){
                    arr[i] = EMPTY;
                }
            }
            array_sorted[n] = max_number;
            n=n+1;
        }
        System.out.println(Arrays.toString(array_sorted));

    }
}
