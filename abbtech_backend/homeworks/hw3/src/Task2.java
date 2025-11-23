
//Task 2: 2 Ölçülü array-də əsas və köməkçi diaqonalın
//        cəmi
//
//
//Şərt:
//
//
//        3x3 ölçülü kvadrat matrisi
//verilir.
//Əsas diaqonal: matrix[0][0],
//matrix[1][1], matrix[2][2]
//Köməkçi diaqonal: matrix[0][2],
//matrix[1][1], matrix[2][0]
//Hər iki diaqonalın cəmini hesabla
//və çap et
//
//        (hesablayan zaman sadece : matrix[0][0]+ matrix[1][1]+matrix[2][2]etmeyin,dovrlerden
//                istifade edin).



public class Task2 {
    public static void main(String[] args) {
        int [][] array_to_solve = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int diagonal1_sum = 0;
        int diagonal2_sum = 0;
        for(int i=0;i<array_to_solve.length;i++){
            for(int j=0;j<array_to_solve[i].length;j++){
                if (i == j){
                    diagonal1_sum += array_to_solve[i][j];
                }
            }
        }
        for (int i=0;i<array_to_solve.length;i++){
            int j = array_to_solve[i].length-i-1;
            diagonal2_sum += array_to_solve[j][i];
            }

        System.out.println(diagonal1_sum+diagonal2_sum);
        }

    }


