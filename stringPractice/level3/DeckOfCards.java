import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DeckOfCards {

    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int NUM_CARDS = SUITS.length * RANKS.length;

    /**
     * Initializes a deck of cards.
     *
     * @return An array of strings representing the deck.
     */
    public static String[] initializeDeck() {
        String[] deck = new String[NUM_CARDS];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
        return deck;
    }

    /**
     * Shuffles the deck of cards.
     *
     * @param deck The deck to shuffle.
     */
    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = i + rand.nextInt(deck.length - i);
            String temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
    }

    /**
     * Distributes a shuffled deck to players.
     *
     * @param deck The shuffled deck.
     * @param numPlayers The number of players.
     * @param cardsPerPlayer The number of cards each player gets.
     * @return A 2D array of players and their cards.
     */
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Error: Not enough cards for distribution.");
            return null;
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }
        return players;
    }

    /**
     * Prints the cards of each player.
     *
     * @param players The 2D array of players and their cards.
     */
    public static void printPlayerHands(String[][] players) {
        if (players == null) {
            return;
        }
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " has: " + Arrays.toString(players[i]));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] deck = initializeDeck();

        System.out.println("--- Deck of Cards ---");
        System.out.println("Initial deck size: " + deck.length);

        shuffleDeck(deck);
        System.out.println("Deck shuffled successfully!");

        System.out.print("Enter the number of players: ");
        int numPlayers = input.nextInt();
        System.out.print("Enter the number of cards per player: ");
        int cardsPerPlayer = input.nextInt();

        String[][] players = distributeCards(deck, numPlayers, cardsPerPlayer);
        System.out.println("\n--- Distributing Cards ---");
        printPlayerHands(players);

        input.close();
    }
}