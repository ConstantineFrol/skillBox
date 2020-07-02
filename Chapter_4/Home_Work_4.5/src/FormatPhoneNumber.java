import java.util.Scanner;

public class FormatPhoneNumber {
    public static void main(String[] args) {
        String phoneNumber = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Please input your phone number:\n");
        String userInput = in.nextLine();
        String formatUserInput = userInput.replaceAll("[^0-9]", "");
        if(formatUserInput.length() < 11){
            System.err.println("Oops, your phone number is too short");
        }else{
            phoneNumber = formatUserInput.replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+$1 $2 $3-$4-$5");
        }
        System.out.println("Your Phone Number is: " + phoneNumber);
    }
}
