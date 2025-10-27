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

//    public static Position getPosition(String input) {
//
//        // Takes input and make it to upper case if it's not
////        String input = scanner.nextLine().toUpperCase();
//
//        try {
//            int col = input.charAt(0) - 'A';
//            int row = Integer.parseInt(input.substring(1)) - 1;
//            return new Position(row, col);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public static Position getPosition(String input) {
        String convertedInput = input.toUpperCase();
        if ((convertedInput.length() == 3) && (input.charAt(2) == 'f' || input.charAt(2) == 'F')) {
            convertedInput = input.substring(0, 2);
        } else if((convertedInput.length() == 4) && (input.charAt(3) == 'f' || input.charAt(3) == 'F')) {
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

    public static String getString() {
        return scanner.nextLine().toUpperCase();
    }
}