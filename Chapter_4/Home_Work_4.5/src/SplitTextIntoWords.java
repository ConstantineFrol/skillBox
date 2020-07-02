import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SplitTextIntoWords {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/wikiText.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (String word : data.split("Read data \\s+")){
                    System.out.println(word);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Oops, your file is missing");
            e.printStackTrace();
        }
    }
}
