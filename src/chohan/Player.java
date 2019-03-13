package chohan;

/**
 * The Player class establishes the player for a game.
 * @author Ashika Shallow
 */
public class Player {

    private String name;	// The player's name
    private String guess;	// The player's guess
    private int points;		// The player's points

    /**
     * Constructor
     * @param playerName The player's name
     */
    public Player(String playerName) {
        name = playerName;
        guess = "";
        points = 0;
    }

    /**
     * The addPoints method adds a specified number of points to the player's
     * current balance.
     *
     * @param newPoints The points to add.
     */
    public void addPoints(int newPoints) {
        points += newPoints;
    }

    /**
     * The setGuess method specifies a player's choice
     * @param playerGuess 
     */
    public void setGuess(String playerGuess){
        guess = playerGuess;
    }
    
    /**
     * The getName method returns the player's name
     * @return The value of the name field.
     */
    public String getName() {
        return name;
    }

    /**
     * The getGuess method returns the player's guess.
     * @return The value of the guess field.
     */
    public String getGuess() {
        return guess;
    }

    /**
     * The getPoints method returns the player's points
     * @return The value of the points field.
     */
    public int getPoints() {
        return points;
    }
}
