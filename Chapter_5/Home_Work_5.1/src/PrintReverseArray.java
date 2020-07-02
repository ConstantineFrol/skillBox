import java.util.Arrays;

public class PrintReverseArray {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s+");

        for(int colorElem = 0; colorElem < colors.length / 2; colorElem++){
            String temp = colors[colorElem];
            colors[colorElem] = colors[colors.length -colorElem -1];
            colors[colors.length -colorElem -1] = temp;
        }

        System.out.println(Arrays.toString(colors));

    }
}
