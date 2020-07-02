import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchEmail {

    private static Scanner scanner = new Scanner(System.in);
    private static final Pattern pattern = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");
    private static final Pattern commandDetection = Pattern.compile("(?<commandType>ADD|LIST)\\s?(?<email>.*)\\s?");
    private static TreeSet<String> emailList = new TreeSet<>();

    public static void doMatch(String word) {
        Matcher matcher = pattern.matcher(word);
        if (matcher.matches()) {
            if (emailList.contains(word)) {
                System.out.println("! This email already exist !");
            } else {
                System.out.println(
                        "Validation for " + word + (matcher.matches() ? " - passed" : " - not passed")
                );
                emailList.add(word);
            }
        }
    }

    public static void processCommand(String text) {
        Matcher matcher = commandDetection.matcher(text);
        if (matcher.matches()) {
            if (matcher.group("commandType").equals("LIST")) {
                if (emailList.isEmpty()) {
                    System.out.println("! Your list is empty !");
                } else {
                    for (String list : emailList) {
                        System.out.println(list);
                    }
                }
            } else if (matcher.group("commandType").equals("ADD")) {
                doMatch(matcher.group("email"));
            }
        } else {
            System.out.println("! Invalid Command !");
        }
    }

    public static void start() {
        System.out.print("Please enter command: ");
        String userInput = scanner.nextLine();
        processCommand(userInput);
    }

    public static void main(String[] args) {
        while (true) {
            start();
        }
    }
}
