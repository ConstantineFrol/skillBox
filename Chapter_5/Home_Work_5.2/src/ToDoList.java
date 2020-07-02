import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static ArrayList<String> myList = new ArrayList<String>();
    public static final String ERROR_WRONG_INPUT = String.format("%n%s%n","Wrong input, please try again!");
    public static final String ERROR_WRONG_RANGE = String.format("%n%s%n","Wrong input, please select 1 - 6");
    public static final String ERROR_EMPTY_LIST = String.format("%n%s%n","Your list is empty");
    public static final String ERROR_LIST_STARTS_FROM_1 = String.format("%n%s%n", "Oops, wrong input. First line starts from 1");

    public static int validateUserInput(){
        Scanner scanner = new Scanner(System.in);
        int loopCount = 0;
        int number;

        do {
            // System.out.print("Your choice: ");
            loopCount++;
            if (loopCount > 2){
                System.err.print(ERROR_WRONG_RANGE);
                System.out.print("Your choice: ");
                loopCount = 0;
            }else {
                System.out.print("Your choice: ");
            }

            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.err.print(ERROR_WRONG_INPUT);
                System.out.print("Your choice: ");

            }
            number = scanner.nextInt();
        } while (number < 1 || number > 6);

        return number;
    }

    public static void processUserChoice(int value){
        Scanner in = new Scanner(System.in);
        switch(value){
            case 1: // List Command
                if (myList.isEmpty()){
                    System.err.print(ERROR_EMPTY_LIST);
                }else {
                    System.out.println("Your TO-DO List:");
                    for (int noticePos = 0; noticePos < myList.size(); noticePos++){
                        System.out.println((noticePos + 1) + " - " + myList.get(noticePos));
                    }
                }
                break;
            case 2: // Add Command
                System.out.println("Please enter a new topic:");
                String newData = in.nextLine();
                System.out.println("Your data is: " + newData);
                myList.add(newData);
                break;
            case 3: // Add @ Specific place Command
                System.out.println("Please select position where to set your topic");
                int position = in.nextInt();
                if (position - 1 > myList.size()){
                    System.out.println("Your list is only size of: " + myList.size());
                    break;
                }else{
                    System.out.println("Please enter a new topic:");
                    in.nextLine();
                    String integratedData = in.nextLine();
                    myList.add(position, integratedData);
                }
                break;
            case 4: // Edit Command
                int selectedPosition;
                do {
                    System.out.println("Please select position of topic to edit");
                    selectedPosition = in.nextInt();
                    if (selectedPosition < 1){
                        System.out.println(ERROR_LIST_STARTS_FROM_1);
                    }else if (selectedPosition > myList.size()){
                        System.out.println(ERROR_WRONG_INPUT);
                        System.out.println("Your list size is: " + myList.size());
                    }
                }while(selectedPosition < 1 || selectedPosition > myList.size());
                System.out.println("Your selection is: " + myList.get(selectedPosition - 1));
                System.out.println("Please enter a new topic:");
                in.nextLine();
                String changeData = in.nextLine();
                myList.set(selectedPosition - 1, changeData);
                break;
            case 5: // Delete Command
                System.out.println("Please select which topic to delete");
                int deletePosition = in.nextInt();
                System.out.println("Your selection is: " + myList.get(deletePosition - 1));
                myList.remove(deletePosition - 1);
                System.out.println("Your topic has been removed");
                break;
            case 6: // Exit Command
                System.exit(0);
        }
    }

    public static void displayMenu(){
        Scanner in = new Scanner(System.in);
        System.out.print(
                "============== MENU =============\n\n"+
                        "Please select from the following:\n"+
                        "1 - Display the List\n"+
                        "2 - Add data\n"+
                        "3 - Add data in specific place\n"+
                        "4 - Edit data\n"+
                        "5 - Delete data\n"+
                        "6 - Quit\n"
        );
    }

    public static void main(String[] args) {

        while(true) {
            displayMenu();
            processUserChoice(validateUserInput());
        }
    }
}
