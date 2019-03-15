/**
 * ChoHan is a traditional Japanese gambling game using dice. The game uses two 
 * standard six-sided dice, which are shaken in a bamboo cup or bowl by a dealer. 
 * The cup is then overturned onto the floor. Players then place their wagers 
 * on whether the sum total of numbers showing on the two dice will 
 * be "Chō" (even) or "Han" (odd). The dealer then removes the cup, displaying the dice. 
 * The winners collect their money.
 */
package chohan;

import java.util.Random;
import java.util.Scanner;

public class ChoHan {

    /**
     * The game of ChoHan
     * @param args
     */
    public static void main(String[] args) {
        final int MAX_ROUNDS = 5;	// Number of rounds
        String player1Name = "CompJohn";  // First player's name
        String player2Name;		// Second player's name

        // Create a Scanner object fort keyboard input.
        Scanner kb = new Scanner(System.in);

        // Create a Random object.
        Random rand = new Random();

        System.out.println("We're playing a game of ChoHan. 'Cho' is even, 'Han' is odd");

        // Get the player's names.
        System.out.println("Player 1: " + player1Name);
        System.out.print("Enter the second player's name: ");
        player2Name = kb.nextLine();

        // Create the dealer.
        Dealer dealer = new Dealer();

        // Create the two players.
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        // Play the rounds.
        for (int round = 0; round < MAX_ROUNDS; round++) {
            System.out.println("-----------------------------------------------");
            System.out.println("Now playing round " + (round + 1) + ".\n");

            // Roll the dice.
            dealer.rollDice();

            // Player 1 makes a guess.
            // Get a random number, either 0 or 1.
            int guessNumber = rand.nextInt(2);
            // Convert the random number to a guess of either "Cho (even)" or "Han (odd)"
            if (guessNumber == 0) {
                player1.setGuess("Cho");
            } else {
                player1.setGuess("Han");
            }
            
            // Player 2 makes a guess.
            System.out.println("The Dealer rolled the dice.");
            System.out.println("Cho(even) or Han(odd)? ");
            String guess = kb.nextLine();
            player2.setGuess(guess);

            // Determine the winner of this round.
            roundResults(dealer, player1, player2);

        }

        // Display the grand winner.
        displayGrandWinner(player1, player2);
    }

    /**
     * The roundResults method determines the results of the current round.
     * @param dealer The Dealer object
     * @param player1 Player #1 object
     * @param player2 Player #2 object
     */
    public static void roundResults(Dealer dealer, Player player1, Player player2) {

        // Show the dice values.
        System.out.println("The dealer rolled " + dealer.getDie1Value() + " and " + dealer.getDie2Value());
        System.out.println("Result: " + dealer.getChoOrHan());

        // Check each player's guess and award points.
        checkGuess(player1, dealer);
        checkGuess(player2, dealer);
    }

    /**
     * The checkGuess method checks a player's guess against the Dealer's
     * result.
     * @param player The Player object to check.
     * @param dealer The Dealer object.
     */
    public static void checkGuess(Player player, Dealer dealer) {
        final int POINTS_TO_ADD = 1;	// Points to award winner
        String guess = player.getGuess();	// Player's guess
        String choHanResult = dealer.getChoOrHan();		// Cho or Han

        // Display the player's guess.
        System.out.println("The player " + player.getName() + " guessed " + player.getGuess());

        // Award points if the player guessed correctly.
        if (guess.equalsIgnoreCase(choHanResult)) {
            player.addPoints(POINTS_TO_ADD);
            System.out.println("Awarding " + POINTS_TO_ADD + " point(s) to " + player.getName());
        }
    }

    /**
     * The displayGrandWinner method displays the game's grand winner.
     * @param player1 Player #1
     * @param player2 Player #2
     */
    public static void displayGrandWinner(Player player1, Player player2) {
        System.out.println("----------------------------");
        System.out.println("Game over. Here are the results:");
        System.out.println(player1.getName() + ": " + player1.getPoints() + " points. ");
        System.out.println(player2.getName() + ": " + player2.getPoints() + " points. ");

        if (player1.getPoints() > player2.getPoints()) {
            System.out.println(player1.getName() + " is the grand winner!");
        } else if (player2.getPoints() > player1.getPoints()) {
            System.out.println(player2.getName() + " is the grand winner!");
        } else {
            System.out.println("Both players are tied!");
        }
    }

}
