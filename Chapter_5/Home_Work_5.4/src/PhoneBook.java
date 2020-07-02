import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private static Scanner scanner = new Scanner(System.in);
    private static final Pattern pattern = Pattern.compile("(?<command>LIST)\\s?|(?<phoneNo>\\d*)\\s?|(?<name>.*)\\s?");
    private static ArrayList<String> phoneBook = new ArrayList<>();
    private static Hashtable<String, String> notePad = new Hashtable<String, String>();
    private static final String ASK_USER_INPUT_NAME = "\nPlease enter your full name";
    private static final String ASK_USER_INPUT_PHONE = "\nPlease enter your phone number";
    private static final String ERR_WRONG_USER_INPUT = "\nOops, wrong input.\nPlease try again\n";
    private static final String ERR_PHONE_TOO_SHORT = "\nCome on!\nYour phone is too short\n";

    public static void showList() {
        if (notePad.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
            System.out.println("Phone book is empty\n");
        } else {
            Enumeration<String> enumeration = notePad.keys();
            while (enumeration.hasMoreElements()) {

                String key = enumeration.nextElement();
                System.out.println("Name : " + key
                        + "\t\t PhoneNo : " + notePad.get(key));
            }
        }
    }

    public static void detectCommand(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            if (matcher.group("command") != null) {
                showList();
            } else if (matcher.group("phoneNo") != null) {
                processWithPhone(matcher);
            } else if (matcher.group("name") != null) {
                processWithUserName(matcher);
            }
        } else {
            System.err.println("! INVALID INPUT !");
        }
    }

    private static void processWithUserName(Matcher matcher) {
        String userName = "";
        String phoneNumber = "";
        if (isExist(userName = (matcher.group("name"))) == false) {
            phoneNumber = getPhoneNo();
            if (validatePhone(phoneNumber) == true) {
                phoneNumber = formatInput(phoneNumber);
                addNotes(userName, phoneNumber);
            }
        }
    }

    private static boolean validatePhone(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{11}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println(ERR_PHONE_TOO_SHORT);
            return false;
        }
    }

    private static String getPhoneNo() {
        String phone = "";
        System.out.println(ASK_USER_INPUT_PHONE);
        phone = getInput();
        phone = phone.trim();
        return phone;
    }

    private static void processWithPhone(Matcher matcher) {
        String userName = "";
        String phoneNumber = "";
        if (validatePhone(matcher.group("phoneNo")) == true) {
            if (isExist(phoneNumber = formatInput(matcher.group("phoneNo"))) == false) {
                userName = getName();
                if (validateUserName(userName) == true) {
                    addNotes(userName, phoneNumber);
                }
            }
        }
    }

    private static void addNotes(String userName, String phoneNumber) {
        System.out.print("Processing");
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        notePad.put(userName, phoneNumber);
        System.out.println("\n# A new record created.");
        System.out.println("Name : " + userName
                + "\t\t PhoneNo : " + phoneNumber);
    }

    private static String getName() {
        String name = "";
        System.out.println(ASK_USER_INPUT_NAME);
        name = getInput();
        name = name.trim();
        return name;
    }

    private static boolean validateUserName(String name) {

        Pattern pattern = Pattern.compile("^[aA-zZ]{3,}");
        if (name == null) {
            System.out.println(ERR_WRONG_USER_INPUT);
            return false;
        }
        Matcher m = pattern.matcher(name);
        if (name.matches("[0-9]+")) {
            System.out.println(ERR_WRONG_USER_INPUT);
            return false;
        } else {
            return m.matches();
        }
    }

    private static String formatInput(String phoneNo) {
        String phoneNumber = "";
        String formatUserInput = phoneNo.replaceAll("[^0-9]", "");
        phoneNumber = formatUserInput.replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+$1 $2 $3-$4-$5");
        return phoneNumber;
    }

    private static boolean isExist(String data) {
        Set<String> phoneBook = notePad.keySet();

        for (String key : phoneBook) {

            if (notePad.get(key).equals(data)) {
                System.out.println("Name : " + key
                        + "\t\t PhoneNo : " + notePad.get(key));
                return true;
            } else if (key.equals(data)) {
                System.out.println("Name : " + key
                        + "\t\t PhoneNo : " + notePad.get(key));
                return true;
            }
        }
        return false;
    }

    public static void startProcess() {
        detectCommand(getInput());
    }

    public static String getInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }


    public static void runMenu() {
        System.out.print(
                "*==============PHONE*BOOK==============*\n" +
                        "Please type in your name or phone number\n" +
                        ": "
        );
        startProcess();
    }


    public static void main(String[] args) {
        while (true) {
            runMenu();
        }
    }
}
