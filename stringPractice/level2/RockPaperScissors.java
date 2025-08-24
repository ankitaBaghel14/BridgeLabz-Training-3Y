import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    /**
     * Finds the length of a string without using the built-in length() method.
     * (Reused from previous example for tabular display formatting)
     * @param text The input string.
     * @return The length of the string.
     */
    public static int getStringLengthWithoutBuiltIn(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception, ignore
        }
        return count;
    }

    /**
     * Generates the computer's choice (Rock, Paper, or Scissors) randomly.
     * @return A string representing the computer's choice.
     */
    public static String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int randomIndex = random.nextInt(choices.length);
        return choices[randomIndex];
    }

    /**
     * Determines the winner of a single round of Rock-Paper-Scissors.
     * @param playerChoice The user's choice.
     * @param computerChoice The computer's choice.
     * @return "Player Wins", "Computer Wins", or "It's a Tie".
     */
    public static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a Tie";
        }

        switch (playerChoice.toLowerCase()) {
            case "rock":
                return (computerChoice.equalsIgnoreCase("scissors")) ? "Player Wins" : "Computer Wins";
            case "paper":
                return (computerChoice.equalsIgnoreCase("rock")) ? "Player Wins" : "Computer Wins";
            case "scissors":
                return (computerChoice.equalsIgnoreCase("paper")) ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Player Choice"; // Should not happen with validation
        }
    }

    /**
     * Calculates the average and percentage of wins for the user and computer.
     * @param playerWins Number of games won by the player.
     * @param computerWins Number of games won by the computer.
     * @param totalGames Total number of games played.
     * @return A 2D String array: [[Avg Player, % Player], [Avg Computer, % Computer]].
     */
    public static String[][] calculateWinStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][2];

        double playerWinAvg = (totalGames > 0) ? (double) playerWins / totalGames : 0;
        double computerWinAvg = (totalGames > 0) ? (double) computerWins / totalGames : 0;

        double playerWinPercentage = playerWinAvg * 100;
        double computerWinPercentage = computerWinAvg * 100;

        stats[0][0] = String.format("%.2f", playerWinAvg);
        stats[0][1] = String.format("%.2f%%", playerWinPercentage);
        stats[1][0] = String.format("%.2f", computerWinAvg);
        stats[1][1] = String.format("%.2f%%", computerWinPercentage);

        return stats;
    }

    /**
     * Displays game results and overall statistics in tabular format.
     * (Reused and adapted from previous example)
     * @param data The 2D array to display.
     * @param headers An array of column headers.
     */
    public static void display2DStringArrayTabular(String[][] data, String[] headers) {
        // Calculate max column widths for formatting
        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = getStringLengthWithoutBuiltIn(headers[i]);
        }
        for (String[] row : data) {
            for (int j = 0; j < row.length; j++) {
                if (getStringLengthWithoutBuiltIn(row[j]) > colWidths[j]) {
                    colWidths[j] = getStringLengthWithoutBuiltIn(row[j]);
                }
            }
        }

        // Print headers
        for (int i = 0; i < headers.length; i++) {
            System.out.printf("%-" + (colWidths[i] + 2) + "s", headers[i]);
        }
        System.out.println();
        // Print separator
        for (int i = 0; i < headers.length; i++) {
            for (int j = 0; j < colWidths[i] + 2; j++) {
                System.out.print("-");
            }
        }
        System.out.println();

        // Print data
        for (String[] row : data) {
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%-" + (colWidths[j] + 2) + "s", row[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of games you want to play: ");
        int numGames = input.nextInt();
        input.nextLine(); // Consume newline

        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;

        // Store outcomes for detailed display later
        String[][] gameOutcomes = new String[numGames][4]; // Game#, Player, Computer, Result

        for (int i = 0; i < numGames; i++) {
            System.out.println("\n--- Game " + (i + 1) + " ---");
            String playerChoice;
            while (true) {
                System.out.print("Enter your choice (Rock, Paper, or Scissors): ");
                playerChoice = input.nextLine().trim();
                if (playerChoice.equalsIgnoreCase("rock") ||
                        playerChoice.equalsIgnoreCase("paper") ||
                        playerChoice.equalsIgnoreCase("scissors")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                }
            }

            String computerChoice = getComputerChoice();
            System.out.println("Player chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            gameOutcomes[i][0] = String.valueOf(i + 1);
            gameOutcomes[i][1] = playerChoice;
            gameOutcomes[i][2] = computerChoice;
            gameOutcomes[i][3] = result;

            if (result.equals("Player Wins")) {
                playerWins++;
            } else if (result.equals("Computer Wins")) {
                computerWins++;
            } else {
                ties++;
            }
        }

        System.out.println("\n--- Game History ---");
        String[] historyHeaders = {"Game", "Player", "Computer", "Result"};
        display2DStringArrayTabular(gameOutcomes, historyHeaders);


        System.out.println("\n--- Overall Stats ---");
        String[][] winStats = calculateWinStats(playerWins, computerWins, numGames);
        String[] statHeaders = {"Metric", "Value"};
        String[][] displayStats = {
                {"Player Wins", String.valueOf(playerWins)},
                {"Computer Wins", String.valueOf(computerWins)},
                {"Ties", String.valueOf(ties)},
                {"Player Win Avg", winStats[0][0]},
                {"Player Win %", winStats[0][1]},
                {"Computer Win Avg", winStats[1][0]},
                {"Computer Win %", winStats[1][1]}
        };
        display2DStringArrayTabular(displayStats, statHeaders);


        input.close();
    }
}