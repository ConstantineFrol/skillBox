import java.util.ArrayList;

public class GetDataFromString {
    public static String text = "Vasia earn 5000 rebels, Petia - 7563 rebels, and Masha - 30000 rebels";

    private static ArrayList<Integer> namesCoordinates = new ArrayList<Integer>();
    private static ArrayList<String> namesList = new ArrayList<String>();
    private static ArrayList<Integer> wagesList = new ArrayList<Integer>();


    // Catch capital letters in the string
    public static void findNamePosition(String text) {
        for (int charPosition = 0; charPosition < text.length(); charPosition++) {
            char c = text.charAt(charPosition);
            if (Character.isUpperCase(c)) {
                namesCoordinates.add(charPosition);
                namesList.add(identifyName(charPosition, text));
            }
        }
    }

    // Recognize names in the string, return name
    public static String identifyName(int charIndex, String text) {
        String name = "";
        for (int i = charIndex; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                name = text.substring(charIndex, i);
                break;
            }
        }
        return name;
    }

    // Create a list of all wages, return sum of all wages
    public static int createWageList(String text){
        String wages[] = text.split("\\s+");
        int sum = 0;
        for (String wage : wages) {
            Integer amount = Integer.parseInt(wage);
            wagesList.add(amount);
            sum += amount;
        }
        return sum;
    }

    public static void main(String[] args) {

        findNamePosition(text);
        String wages = text.replaceAll("\\D+"," ");
        wages = wages.trim();
        int sumOfWages = createWageList(wages);
        String names = " ";
        int salary = 0;
        for(int i  = 0; i < wagesList.size(); i++){
            System.out.println(
                    " Name: " + namesList.get(i) +
                    " Wage: " + wagesList.get(i)
            );
            if (i == 0){
                names = namesList.get(i);
                salary = wagesList.get(i);
            }else if (i == 2){
                names += " and " + namesList.get(i);
                salary += wagesList.get(i);
            }
        }
        System.out.println(
                "The total amount that they earn is: " + sumOfWages + "\n" +
                "So " + names + " earn in total: " + salary
        );


    }
}
