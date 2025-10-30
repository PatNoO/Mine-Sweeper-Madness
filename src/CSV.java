import java.io.*;
import java.util.ArrayList;

/**
 * CSV utility class for reading and writing Player data to CSV files.
 * Handles:
 * - Writing Player objects as CSV lines
 * - Escaping strings to handle commas and quotes
 * - Reading CSV files and converting them back into Player objects
 * <p>
 * This class does not manage CSV headers or complex CSV features.
 */
public class CSV {
    /**
     * Writes a Player object to the CSV file.
     * Appends to the file if it exists.
     *
     * @param player   Player to be saved in the CSV file
     * @param filePath Path to the CSV file
     */
    public static void write(Player player, String filePath) throws IOException {
        File file = new File(filePath);
        boolean fileExists = file.exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            // Write the player data as a CSV line
            writer.write(escape(player.getName()) + "," + escape(player.getDifficulty()) + "," + player.getTime());
            writer.newLine();
            writer.flush();

        }
    }

    /**
     * Escape commas or quotes (basic CSV safety)
     *
     * @param value The string to be made CSV-safe
     * @return The encoded string for CSV storage
     */
    private static String escape(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"")) {
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }
        return value;
    }

    /**
     * Reads a CSV file (no header)
     *
     * @param filePath Path to the CSV file
     * @return List of Player objects
     */
    public static ArrayList<Player> readCsvFile(String filePath) throws IOException {
        ArrayList<Player> playerList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String name = parts[0];
                    String difficulty = parts[1];

                    int time = 0;
                    try {
                        time = Integer.parseInt(parts[2]);
                    } catch (NumberFormatException ignored) {
                    }

                    playerList.add(new Player(name, difficulty, time));
                }
            }
        }

        return playerList;
    }
}
