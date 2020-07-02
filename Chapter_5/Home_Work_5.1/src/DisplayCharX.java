public class DisplayCharX {

    private static final int ROWS = 7;
    private static final int COLUMNS = 7;

    public static void main(String[] args) {

        /****************
        *** VERSION 1 ***
        ****************/
        //================== Limited in size 7 x 7 ==========================

        // Create Strings
        String topRow = String.format("%c%5s%c",'X'," ", 'X');
        String secondRow = String.format("%1s%c%3s%c%1s", " ", 'X', " ", 'X', " ");
        String thirdRow = String.format("%2s%c%1s%c%2s", " ", 'X', " ", 'X', " ");
        String bottomRow = String.format("%3s%c%3s", " ", 'X', " ");

        // Create 2D array
        String[][] box = {
                {topRow},
                {secondRow},
                {thirdRow}
        };

        // Display Array: box
        for (int i = 0; i < box.length; i++){

            // Loop through all elements of current row
            for (int j = 0; j < box[i].length; j++) {
                System.out.print(box[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println(bottomRow + "\n");

        // Display Array: box - Reverse
        for (int i = box.length - 1; i >= 0; i--){

            // Loop through all elements of current row
            for (int j = 0; j < box[i].length; j++) {
                System.out.print(box[i][j]);
            }
            System.out.println("\n");
        }

        /****************
         *** VERSION 2 ***
         ****************/

        //================== Unlimited in size 7 x 7 ==========================

        // Create 2D Shape
        char[][] xShape = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                xShape[i][j] = ( i == j || i + j == COLUMNS - 1 ) ? 'X' : ' ';
            }
        }

        // // Display 2D Shape
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(xShape[i][j]);
            }
            System.out.println("\n");
        }
    }
}
