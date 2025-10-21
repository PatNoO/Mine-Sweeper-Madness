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
                        c != 'Å' && c != 'Ä' && c != 'Ö' ){
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
        while(!scanner.hasNextInt()) {
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
}
