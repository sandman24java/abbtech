
//Şərt:
//Verilmiş 3 ölçülü (int[][][]) massivdə 6-dan böyük olan bütün ədədləri tapın və ekrana çap edin.
//
//Nümunə:
//
//int[][][] cube = {
//        {
//                {1, 2}, {3, 4}
//        },
//        {
//                {5, 6}, {7, 8}
//        }
//};
//
//
//Gözlənilən çıxış:
//
//        6-dan böyük ədədlər: 7, 8











public class Task3 {
    public static void main(String[] args) {
        int[][][] cube = {
                {
                        {1, 2},
                        {3, 4}
                },
                {
                        {5, 6},
                        {7, 8}
                }};
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    if (cube[i][j][k] > 6) {
                        System.out.println(cube[i][j][k]);
                    }
                }
            }
        }
    }
}

