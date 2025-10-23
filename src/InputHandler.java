import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

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
                return input;
            } else {
                System.out.println(text);
            }
        }
    }

    public static int getInt(String text) {
        while (!scanner.hasNextInt()) {
            System.out.println(text);
            scanner.nextLine();
        }

        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static int getInt(int min, int max, String text) {


        while (true) {
            int input = getInt(text + " " + min + "-" + max);

            if (input >= min && input <= max) {
                return input;
            }

            System.out.println(text + " " + min + "-" + max);
        }
    }

    public static String getMove() {

        String input;
        while (true) {
            // Takes input and make it to upper case if it's not, to match the cases in the switch
            input = scanner.nextLine().toUpperCase();

            if (input.length() != 2) {
                System.out.println("Wrong input, enter example A1..B2..C5..");
                continue;
            }

            boolean validCol = false;
            boolean validRow = false;

            for (int i = 0; i < input.length(); i++) {
                if (Character.isLetter(input.charAt(i))) {
                    validCol = true;
                    break;
                }
            }

            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))) {
                    validRow = true;
                    break;
                }
            }

            if (validCol && validRow) {
                return input.charAt(0) + "-" + input.charAt(1); // Ex: "B3"
            }

            System.out.println("Invalid input");

//            if (input.length() == 2 &&
//                    (input.charAt(0) == 'A' || input.charAt(0) == 'B' || input.charAt(0) == 'C' || input.charAt(0) == 'D' || input.charAt(0) == 'E' || input.charAt(0) == 'F') &&
//                    (input.charAt(1) == '1' || input.charAt(1) == '2' || input.charAt(1) == '3' || input.charAt(1) == '4' || input.charAt(1) == '5' || input.charAt(1) == '6')) {
//
//                return input.charAt(0) + "-" + input.charAt(1);
//
//            } else {
//                System.out.println("""
//                        Wrong input.
//                        Enter a coordinate e.g., 'A1':""");
//            }
//        }
        }
    }
}