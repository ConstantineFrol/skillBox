import java.util.Scanner;

public class Main {

    // Global final var
    final static int NUM_OF_CONTAINERS_PER_TRUCK = 12;
    final static int NUM_OF_BOXES_PER_CONTAINER = 27;

    // This method calculating the number of containers that we gonna need
    public static int calcContainersQty(int boxes) {

        double containers = (double)boxes / NUM_OF_BOXES_PER_CONTAINER;
        double result = Math.ceil(containers);

        // Display number of containers that we will need
        System.out.println(
                "for " + boxes + " boxes we need " + (int)result +
                        " containers"
        );

        // return number of containers
        return (int)result;
    }

    // This method calculating the number of trucks that we will need
    public static int calcTrucksQty(int containers) {

        //local var
        int trucks;
        int remainder;

        // find num of trucks
        trucks = containers / NUM_OF_CONTAINERS_PER_TRUCK;

        // find remainder
        remainder = containers % NUM_OF_CONTAINERS_PER_TRUCK;

        // add 1 to no of trucks if remainder > 0
        if (remainder > 0) {
            trucks++;
        }

        // display no of trucks that we will need
        System.out.println(
                "for " + containers + " containers we need " +
                        trucks + " trucks"
        );

        // return no of trucks
        return trucks;
    }

    public static void main(String[] args) {

        /**
         * Truck may contain 12 containers
         * Container may contain 27 boxes
         *
         * ask user to get number of boxes
         * display : number of truck, containers and boxes with their numeration
         *
         */

        // variables
        int trucksNo;
        int containersQty;
        int boxesQty;

        // counters used to count boxes and containers inside nested for loop
        int countBoxes = 0;
        int countContainers = 0;

        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Validate user input
        do {
            // Ask user to input data
            System.out.println("\nPlease input number of boxes: \n");

            // Warn user if input is not an Integer
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println("\nthis is invalid input: \'" + input + "\'\n");
            }
            // Read input again
            boxesQty = scanner.nextInt();

            //repeat loop if the input is a negative value
        } while (boxesQty < 0);

        // Calling method and passing parameters into it
        trucksNo = calcTrucksQty(containersQty = calcContainersQty(boxesQty));

        // Nested loop used to display results in the terminal
        for (int t = 1; t <= trucksNo; t++) {
            for (int c = 1; c <= containersQty; c++) {
                for (int b = 1; b <= boxesQty; ) {

                    // Display results
                    System.out.println("\nTruck " + t + ":");
                    System.out.println("\t  Container " + c + ":");

                    // Loop is for printing qty boxes in each container
                    do {
                        System.out.println("\t\t box " + b);
                        countBoxes++;
                        b++;
                        if (b > boxesQty) {
                            break;
                        }
                    } while (countBoxes < NUM_OF_BOXES_PER_CONTAINER && countBoxes < boxesQty);

                    // Conditions where adding 1 to no of containers
                    if (countBoxes >= NUM_OF_BOXES_PER_CONTAINER) {
                        c++;
                        countContainers++;
                    }

                    // Conditions where adding 1 to no of trucks
                    if (countContainers >= NUM_OF_CONTAINERS_PER_TRUCK) {
                        t++;

                        // reset counter
                        countContainers = 0;
                    }

                    // reset counter
                    countBoxes = 0;
                }
            }
        }
    }
}
