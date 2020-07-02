public class PrintSymbols {
    public static void main(String[] args) {
        char c = 'a';

        System.out.print(
                "*---------------*---------------*\n" +
                "|\tCharacter\t|\tCode\t\t|\n" +
                "*---------------*---------------*" +
                "---------------*---------------*\n"
        );

        while (c <= 'z') {
            System.out.print("|\t\t" + c + "\t\t|\t\t" + (int)c + "\t\t|");
            char upperC = Character.toUpperCase(c);
            System.out.println("\t\t" + upperC + "\t\t|\t\t" + (int)upperC + "\t\t|");
            c++;
            if (upperC == 'Z'){
                System.out.print(
                        "*---------------*---------------*---*" +
                        "-----------*---*-----------*-------*\n"
                );
                c = 'а';
                do {
                    System.out.print("|\t\t" + c + "\t\t|\t\t" + (int) c + "\t\t|");
                    char upperRusC = Character.toUpperCase(c);
                    System.out.println("\t\t" + upperRusC + "\t\t|\t\t" + (int)upperRusC + "\t\t|");
                    c++;
                }while(c <= 'я');
            }
        }
        System.out.print(
                "*---------------*-------------------*" +
                "---------------*-------------------*\n"
        );
    }
}
