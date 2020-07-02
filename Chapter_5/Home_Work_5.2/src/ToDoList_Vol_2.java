import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToDoList_Vol_2 {

    private static ArrayList<String> aList;
    private static Scanner scanner = new Scanner(System.in);

    private enum Procedure {LIST, ADD, ADD_AT, EDIT, DELETE}

    public static final String ERROR_EMPTY_LIST = String.format("%n%s%n", "Your list is empty");
    public static final String ERROR_WRONG_INDEX = String.format("%n%s%n%s", "incorrect command", "Your list is only size of: ");
    private static final Pattern detectionPattern = Pattern.compile("(?<commandType>ADD|LIST|EDIT|DELETE)\\s?(?<dealNo>\\d*)\\s?(?<text>.*)\\s?");

    public static void start() {
        System.out.println("Please type in your command: ");
        String userInput = scanner.nextLine();
        processInput(userInput);
    }

    private static void processInput(String text) {

        Matcher matcher = detectionPattern.matcher(text);
        if (matcher.matches()) {

            System.out.println("Command Detected: " + matcher.group("commandType"));
            System.out.println("Index: " + matcher.group("dealNo"));
            System.out.println("Text: " + matcher.group("text"));

            if (matcher.group("commandType").equals("LIST")) {
                operateTheList(Procedure.LIST, 0, "");
            } else if (matcher.group("commandType").equals("EDIT")) {
                operateTheList(Procedure.EDIT, Integer.parseInt(matcher.group("dealNo")), matcher.group("text"));
            } else if (matcher.group("commandType").equals("DELETE")) {
                operateTheList(Procedure.DELETE, Integer.parseInt(matcher.group("dealNo")), "");
            } else if (matcher.group("commandType").equals("ADD")) {
                if (!matcher.group("dealNo").equals("")) {
                    operateTheList(Procedure.ADD_AT, Integer.parseInt(matcher.group("dealNo")), matcher.group("text"));
                } else {
                    operateTheList(Procedure.ADD, 0, matcher.group("text"));
                }
            }
        } else {
            System.out.println("Invalid");
        }
    }

    private static void operateTheList(Procedure whichOne, int index, String data) {
        switch (whichOne) {
            case LIST:
                if (aList.isEmpty()) {
                    System.out.println(ERROR_EMPTY_LIST);
                } else {
                    System.out.println("Your TO-DO List:");
                    for (int noticePos = 0; noticePos < aList.size(); noticePos++) {
                        System.out.println((noticePos + 1) + " - " + aList.get(noticePos));
                    }
                }
                break;
            case ADD:
                aList.add(data);
                break;
            case ADD_AT:
                if (index < 0 || index > aList.size()) {
                    System.out.println(ERROR_WRONG_INDEX + aList.size());
                    break;
                } else {
                    aList.add(index, data);
                }
                break;
            case EDIT:
                if (index < 0 || index > aList.size()) {
                    System.out.println(ERROR_WRONG_INDEX + aList.size());
                    break;
                } else {
                    aList.set(index, data);
                }
                break;
            case DELETE:
                if (index < 0 || index > aList.size()) {
                    System.out.println(ERROR_WRONG_INDEX + aList.size());
                    break;
                } else {
                    aList.remove(index);
                }
                break;
        }
    }

    public static void main(String[] args) {

        aList = new ArrayList<String>();
        while (true) {
            start();
        }
    }
}
