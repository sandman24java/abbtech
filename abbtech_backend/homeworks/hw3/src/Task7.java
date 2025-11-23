//
//Şərt:
//Verilmiş cümlədə (String sentence) hər bir hərfin neçə dəfə təkrarlandığını hesablayın və nəticəni ekrana çıxarın.
//Boşluq simvollarını və xüsusi işarələri nəzərə almayın.
//
//Nümunə:
//
//String sentence = "Java is awesome";
//
//
//Gözlənilən çıxış (nümunə):
//
//a - 3
//e - 2
//i - 1
//j - 1
//        ...
//


public class Task7 {
    public static void main(String[] args) {
        String sentence = "Java is awesome";
        String result = sentence.replace(" ","").toLowerCase();
        String seen_letters = " ";
        for (int i = 0; i < result.length(); i++) {
            int counter = 0;
            for (int j = 0; j < result.length(); j++) {
                if (!seen_letters.contains(result.charAt(j) + "")) {
                    if (result.charAt(j) == result.charAt(i)) {
                        counter++;
                    }
                }
            }
            if (!seen_letters.contains(result.charAt(i) + ""))
                System.out.println(result.charAt(i) + " - " + counter);
            seen_letters += result.charAt(i);
        }

        }

    }
