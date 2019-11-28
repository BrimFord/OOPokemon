import java.io.*;
import java.util.*;
/**
 * Date: 28-Nov-2019
 * This is a class used to manage the scores in the game
 * 
 * @author Group 25 (Ng Yee Jien, Ibrahim Keith Harold Ford, Choy Ee Lee, Teo Yun Xian)
 * @version 1.0
 *
 *
 */
public class Score{
	
	/**
	 * input scaner for user to input
	 */
	private static Scanner input;
	/**
	 * output formatter
	 */
	private static Formatter output;
	/**
	 * score of the player
	 */
	private static int score;
	/**
	 * a list of top 10 player
	 */
	private static ArrayList<Player> playerList = new ArrayList<Player>(10);
	/**
	 * a list of top 10 player's score
	 */
	private static ArrayList<Integer> scoreList = new ArrayList<Integer>(10);
	
	/**
	 * This method sets the score of the player
	 * @param score is the player's score 
	 */
	public static void setScore(int score) {
		score += score;
	}

	/**
	 * This method returns the score of the player
	 * @return player's score
	 */
	public static int getScore() {
		return score;
	}
	
	/**
	 * This method loads all the data from score file by calling the openInputFile(), readScoreFile() and closeInputFile() methods
	 */
	public static void loadScore() {
		input = openInputFile("C:\\Users\\user\\eclipse-workspace\\Assignment\\src\\score.txt");
		readScoreFile();
		closeInputFile(input);
	}
	
	/**
	 * This method stores back all the data to score file by calling the openOutputFile(), writeScoreFile() and closeOutputFile() methods
	 */
	public void storeScore() {
		output = openOutputFile("C:\\Users\\user\\eclipse-workspace\\Assignment\\src\\score.txt");
		writeScoreFile();
		closeOutputFile(output);
	}
	
	/**
	 * This method opens the score.txt file for reading
	 * @param filename is the name of the file opened
	 * @return the output of the file
	 */
	public static Scanner openInputFile(String filename) {
		Scanner tempinput = null;
		try {
			tempinput = new Scanner(new File(filename));
		}
		catch(FileNotFoundException fileNotFoundException){
			System.err.println("Error opening file.");
			System.exit(1);
		}
		return tempinput;
	}
	
	/**
	 * This method opens the score.txt file for writing
	 * @param filename is the name of the file
	 * @return the file to write
	 */
	public Formatter openOutputFile(String filename) {
		Formatter tempoutput = null;
		try {
			tempoutput = new Formatter(new File(filename));
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
		return tempoutput;
	}
	

	/**
	 * This method closes the input file
	 * @param input is the file closed
	 */
	public static void closeInputFile(Scanner input) {
		if (input != null)
			input.close();
	}
	
	
	/**
	 * This method closes the output file
	 * @param output is the file closed
	 */
	public void closeOutputFile(Formatter output) {
		if (output != null)
			output.close();
	}
	


	/**
	 * This method reads every line in the score.txt file and add the winner and score to the scoreList
	 */
	public static void readScoreFile() {
		try {
			while(input.hasNext()) {
				for(int s:scoreList) {
					if (score < s){
						playerList.remove(9);
						scoreList.remove(9);
						playerList.add(Player.getName());
						scoreList.add(score);
					}
				}
				
			}
		}
		catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		}
		catch (IllegalStateException stateException){
			System.err.println("Error reading from file.");
			System.exit(1);
		}
	}
	
	
	/**
	 * This method loop each of the record in array list and write it into the score.txt file
	 */
	public static void writeScoreFile() {
		for (int s=0; s < 10; s++) {
			output.format("%s \t %d\n", playerList.get(s), scoreList.get(s));
		}
	}
	
}