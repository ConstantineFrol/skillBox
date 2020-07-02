import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPlateNo {

    private static final int MAX = 199;
    private static final int PLATE_QTY = 10;
    private static ArrayList<String> plateNoList = new ArrayList<>();
    private static HashSet<String> hashSet = new HashSet<>();
    private static TreeSet<String> treeSet = new TreeSet<>();
    private static Scanner scanner = new Scanner(System.in);
    public static final Pattern pattern = Pattern.compile
            ("^[СМТВАРОНЕУX]{1}\\d{3}[СМТВАРОНЕУX]{2}((^?[0][1-9]$)|(^?[1][0-9]$)|(^?[1][0-9][0-9]$))");


    private static void doesArrayListContains(String plateNo) {
        long start = System.nanoTime();
        if (plateNoList.contains(plateNo)) {
            System.out.println(
                    "Поиск перебором: номер найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        } else {
            System.out.println(
                    "Поиск перебором: номер не найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        }
    }

    private static void doesHashSetContains(String plateNo) {
        long start = System.nanoTime();
        if (hashSet.contains(plateNo) == true) {
            System.out.println(
                    "Поиск в HashSet: номер найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        } else {
            System.out.println(
                    "Поиск в HashSet: номер не найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        }
    }

    private static void doesTreeSetContains(String plateNo) {
        long start = System.nanoTime();
        if (treeSet.contains(plateNo) == true) {
            System.out.println(
                    "Поиск в TreeSet: номер найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        } else {
            System.out.println(
                    "Поиск в TreeSet: номер не найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        }
    }

    private static void binarySearchArrayList(String plateNo) {
        long start = System.currentTimeMillis();
        Collections.sort(plateNoList);
        if (Collections.binarySearch(plateNoList, plateNo) >= 0) {
            System.out.println(
                    "Бинарный поиск: номер найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        } else {
            System.out.println(
                    "Бинарный поиск: номер не найден, поиск занял " +
                            (System.nanoTime() - start) +
                            "нс"
            );
        }
    }

    private static String createPlateNo() {
        StringBuilder s = new StringBuilder();
        char ch1 = (char) (Math.random() * 33 + 'А');
        s.append(ch1);

        char digit3 = (char) (Math.random() * 10 + '0');
        for (int i = 0; i < 3; i++) {
            s.append(digit3);
        }

        for (int i = 0; i < 2; i++) {
            char ch2 = (char) (Math.random() * 33 + 'А');
            s.append(ch2);
        }

        int digit1 = (int) (Math.random() * MAX);
        if (digit1 == 0) {
            digit1++;
        }
//        System.out.println(s + String.format("%02d", digit1));
        return s + String.format("%02d", digit1);
    }

    private static void generateLoop() {
        int loopNo = 0;

        do {
            String temp;

            temp = createPlateNo();
            Matcher matcher = pattern.matcher(temp);
            if (!matcher.matches()){
                temp = createPlateNo();
            }else{
                if (plateNoList.contains(temp)) {
                    generateLoop();
                }
            }
            plateNoList.add(temp);
            System.out.println(temp);
            loopNo++;
        } while (loopNo < PLATE_QTY);

        fillInSets();
    }

    private static void fillInSets() {
        hashSet.addAll(plateNoList);
        treeSet.addAll(plateNoList);
    }

    private static void start() {
        generateLoop();
        System.out.println("ArrayList > " + plateNoList.size());
        System.out.println("HashSet > " + hashSet.size());
        System.out.println("TreeSet > " + treeSet.size());
        String plateNo = getUserInput();
        doesArrayListContains(plateNo);
        doesHashSetContains(plateNo);
        doesTreeSetContains(plateNo);
        binarySearchArrayList(plateNo);

    }

    private static String getUserInput() {
        System.out.println("Please input plate number");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println("Oops , Wrong input\nPlease try again");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
            if (matcher.matches()) break;
        }
        return input;
    }

    public static void main(String[] args) {
        start();
    }

}
