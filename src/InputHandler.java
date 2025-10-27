import java.util.Scanner;

public class InputHandler {

    /// Creates the scanner for all methods

    private static final Scanner scanner = new Scanner(System.in);


    /// Method for making the name of the player valid

    public static String getStringName(String text) {

        while (true) {
            String input = scanner.nextLine();
            boolean isValid = true;

            for (char c : input.toCharArray()) {
                if (!Character.isLetter(c) &&
                        c != '-' && c != '\'' && c != 'å' && c != 'ä' && c != 'ö' &&
                        c != 'Å' && c != 'Ä' && c != 'Ö') {
                    isValid = false;
                    break;
                }
            }

            if (isValid && !input.isEmpty()) {
                return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
            } else {
                // Prints "error text" when wrong input
                System.out.println(text);
            }
        }
    }


    /// Method for handle wrong input when Integer is expected

    public static int getInt(String text) {
        while (!scanner.hasNextInt()) {

            // Prints "error text" when wrong input
            System.out.println(text);

            scanner.nextLine(); // Clears the scanner
        }

        int result = scanner.nextInt();
        scanner.nextLine(); // Clears the scanner

        return result;
    }

    /// Method for handle wrong input when Integer with "min-max"-condition is expected

    public static int getInt(int min, int max, String text) {

        while (true) {
            int input = getInt(text + " " + min + "-" + max);

            if (input >= min && input <= max) {
                return input;
            }

            // Prints "error text" when wrong input
            System.out.println(text + " " + min + "-" + max);
        }
    }

    /// Method for handle wrong input when a Position in the grid is expected

    public static Position getPosition(String input) {
        String convertedInput = input.toUpperCase();

        if ((convertedInput.length() == 3) &&
                (input.charAt(2) == 'f' || input.charAt(2) == 'F')) {

            convertedInput = input.substring(0, 2);

        } else if((convertedInput.length() == 4) &&
                    (input.charAt(3) == 'f' || input.charAt(3) == 'F')) {

            convertedInput = input.substring(0, 3);
        }
        try {
            int col = convertedInput.charAt(0) - 'A';
            int row = Integer.parseInt(convertedInput.substring(1)) - 1;

            return new Position(row, col);
        } catch (Exception e) {
            return null;
        }
    }


    /*
        Method for getting a String from the scanner
        so no extra scanner is needed in another class
     */

    public static String getString() {
        return scanner.nextLine().toUpperCase();
    }
}