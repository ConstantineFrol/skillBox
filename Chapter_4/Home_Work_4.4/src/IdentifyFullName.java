import java.util.Scanner;

public class IdentifyFullName{

    private static final String ERR_NAME_TOO_SHORT = "\nCome on!\nYour name is too short\n";
    private static final String ERR_WRONG_USER_INPUT = "\nOops, wrong input.\nPlease try again\n";
    private static final String ERR_DISPLAY_EXPECTED_LAYOUT = "\nError,\tExpected:\nFirst name, Middle name and Last name\n";
    private static final String ERR_INPUT_CONTAIN_ONLY_LOWERCASE_CHAR = "\nFirst name,Middle name and Last name must starts from capital character !\n";
    private static final String ASK_USER_INPUT_DATA = "\nPlease enter your full name\n";

    public static void handleUserInput(){
        Scanner in = new Scanner(System.in);
        String name = "";
        System.out.println(ASK_USER_INPUT_DATA);
        if (!(in.hasNextInt())){
            name = in.nextLine();
        }else{
            System.out.println(ERR_WRONG_USER_INPUT);
            handleUserInput();
        }
        processUserName(name);
    }

    public static void processUserName(String userInput){

        while(!(userInput.length() > 3)){
            System.out.println(ERR_NAME_TOO_SHORT);
            handleUserInput();
        }

        userInput = userInput.trim();

        String [] fullName = userInput.split(" ");

        for (int charPos = 0; charPos < fullName.length; charPos++){
            if (fullName.length != 3){
                System.out.println(ERR_DISPLAY_EXPECTED_LAYOUT);
                handleUserInput();
            }
            if (!Character.isUpperCase(fullName[charPos].charAt(0))){
                System.out.println(ERR_INPUT_CONTAIN_ONLY_LOWERCASE_CHAR);
                handleUserInput();
            }
            else{
                System.out.println(
                        "Last name: " + fullName[0] + "\n" +
                        "First name: " + fullName[1] + "\n" +
                        "Middle name: " + fullName[2]
                );
                System.exit(0);
            }
        }


    }

    public static void main(String[] args) {
        handleUserInput();
    }
}