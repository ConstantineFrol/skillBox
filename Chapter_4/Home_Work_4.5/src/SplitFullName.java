public class SplitFullName {
    public static void main(String[] args) {
        String fullName = "Pomelnikov Nikolay Rodionovich";
        String[] splittedFullName = fullName.split("\\s+");
        for (String word: splittedFullName){
            System.out.println(word);
        }
    }
}
