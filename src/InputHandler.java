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

}
