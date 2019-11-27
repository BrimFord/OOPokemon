import java.io.*;
import java.util.*;

public class Score{
	
	private static Scanner input;
	private static Formatter output;
	private static int score;
	private static ArrayList<Player> playerList = new ArrayList<Player>(10);
	private static ArrayList<Integer> scoreList = new ArrayList<Integer>(10);
	
	public static void setScore(int score) {
		score += score;
	}

	public static int getScore() {
		return score;
	}
	
	//load all the data from score file by calling the openInputFile(), readScoreFile() and closeInputFile() methods
	public static void loadScore() {
		input = openInputFile("C:\\Users\\user\\eclipse-workspace\\Assignment\\src\\score.txt");
		readScoreFile();
		closeInputFile(input);
	}
	
	//store back all the data to score file by calling the openOutputFile(), writeScoreFile() and closeOutputFile() methods
	public void storeScore() {
		output = openOutputFile("C:\\Users\\user\\eclipse-workspace\\Assignment\\src\\score.txt");
		writeScoreFile();
		closeOutputFile(output);
	}
	
	//open the score.txt file for reading
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
	
	//open the score.txt file for writing
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
	
	//close the input file
	public static void closeInputFile(Scanner input) {
		if (input != null)
			input.close();
	}
	
	//close the output file
	public void closeOutputFile(Formatter output) {
		if (output != null)
			output.close();
	}
	
	//read every line in the score.txt file
	//add the winner and score to the scoreList
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
	
	//loop each of the record in array list and 
	//write it into the score.txt file
	public static void writeScoreFile() {
		for (int s=0; s < 10; s++) {
			output.format("%s \t %d\n", playerList.get(s), scoreList.get(s));
		}
	}
	
}