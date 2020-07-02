import java.util.regex.Pattern;

public class GetSumOfNumbersFromString {

    public static String text = "Vasia earn 5000 rebels, Petia - 7563 rebels, and Masha - 30000 rebels";

    // Calculate sum of numbers from a string, return sum of all numbers
    public static int calculateWages(String text){
        String sentence[] = text.split("\\s+");
        int sum = 0;
        int value = 0;
        for (String word : sentence) {
            if (word.matches("[0-9]+")) {
                value = Integer.parseInt(word);
                sum += value;
            }
        }
        return sum;
    }

    // Calculate sum of numbers from a string using regex search, return sum of all numbers
    public static int calculateWagesWithRegex(String text){
        int sum = 0;
        var m = Pattern.compile("([0-9]+)").matcher(text);
        while (m.find()) {
            sum += Integer.parseInt(m.group(0));
        }
        return sum;
    }


    public static void main(String[] args) {
        int totalAmount = calculateWages(text);
        System.out.println("Total amount is: " + totalAmount + " " + '\u20BD');


        int totalAmountWithRegexSearch = calculateWagesWithRegex(text);
        System.out.println("Total amount is: " + totalAmountWithRegexSearch + " " + '\u20BD');
    }
}
