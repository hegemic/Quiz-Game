import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Observable;

public class Model extends Observable {
	private boolean win;
	public boolean moreQuestions = true;;

	private String question = "";
	private String bonusQuestion = "";
	private String answer = "";
	private String bonusAnswer = "";
	private String bonusInfo = "";
	private String currentQuestion = "";
	private String currentAnswer = "";

	public int teamTurn = 0;
	public int bonusCounter = -1;

	public boolean teamABuzzed = true;
	public boolean teamBBuzzed = true;
	public boolean bonusClicked = true;

	public String tournament;
	public String[][] players = { { "Player 1", "Player 2", "Player 3", "Player 4" },
			{ "Player 1", "Player 2", "Player 3", "Player 4" } };
	public String[] teams = { "Team A", "Team B" };

	private int[][] points = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	private int[][] tenPointCounter = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	private int[][] minusFivePointCounter = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	private int[] teamPoints = { 0, 0 };

	public Model() {
		// Call to create object
	}

	protected String[] nextQuestion() {
		File file = new File("packet.txt");
		assert file.exists() : "the file words.txt doesn't exist";
		try {
			Scanner sc = new Scanner(file);
			boolean found = false;
			boolean bonus = false;
			String l = sc.nextLine();
			while (!l.contains(question)) {
				l = sc.nextLine();
			}
			bonusInfo = "";
			while (!bonus && sc.hasNextLine() & !found) {
				l = sc.nextLine();
				if (l.contains("BONUSES")) {
					bonus = true;
				}
				if (!bonus && l.length() > 1 && !l.contains("ANSWER")) {
					question = l;
					sc.nextLine();
					while (!bonus && sc.hasNextLine() & !found) {
						l = sc.nextLine();
						if (l.length() > 1) {

							answer = l;
							sc.nextLine();
							found = true;
						}
					}
				}
			}
			currentQuestion = question;
			currentAnswer = answer;
			String[] a = { question, answer };
			sc.nextLine();
			sc.nextLine();
			if (sc.nextLine().contains("BONUSES")) {
				moreQuestions = false;
			}
			sc.close();
			setChanged();
			notifyObservers();
			return a;
		} catch (FileNotFoundException ex) {
			// insert code to run when exception occurs
			return null;
		}
	}

	protected String[] nextBonusQuestion() {
		File file = new File("packet.txt");
		assert file.exists() : "the file words.txt doesn't exist";
		try {
			Scanner sc = new Scanner(file);
			boolean found = false;
			String l = sc.nextLine();
			while (!l.contains("BONUS")) {
				l = sc.nextLine();
			}
			while (!l.contains(bonusQuestion)) {
				l = sc.nextLine();
			}
			while (sc.hasNextLine() & !found) {
				l = sc.nextLine();
				if (l.length() > 1 && Character.isDigit(l.charAt(0))) {
					bonusInfo = l;
					l = sc.nextLine();
				}
				if (l.length() > 1 && !l.contains("ANSWER")) {
					bonusQuestion = l;
					sc.nextLine();
					while (sc.hasNextLine() & !found) {
						l = sc.nextLine();
						if (l.length() > 1) {

							bonusAnswer = l;
							sc.nextLine();
							found = true;
						}
					}
				}
			}

			String[] a = { bonusQuestion, bonusAnswer };
			currentQuestion = bonusQuestion;
			currentAnswer = bonusAnswer;
			sc.close();
			setChanged();
			notifyObservers();
			return a;
		} catch (FileNotFoundException ex) {
			// insert code to run when exception occurs
			return null;
		}
	}

	protected void changePoints(int numberOfPoints, int playerNumber, int team) {
		points[team - 1][playerNumber - 1] += numberOfPoints;
		teamPoints[team - 1] += numberOfPoints;
		setChanged();
		notifyObservers();

	}

	public void incrementCounter(int[][] counter, int team, int player) {
		counter[team - 1][player - 1] += 1;
		setChanged();
		notifyObservers();
	}

	public boolean gameWon() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public int[][] getPoints() {
		return points;
	}

	public int[][] getCounterFive() {
		return minusFivePointCounter;
	}

	public int[][] getCounterTen() {
		return tenPointCounter;
	}

	public int[] getTeamPoints() {
		return teamPoints;
	}

	public String getBonusInfo() {
		return bonusInfo;
	}

	public String getCurrentQuestion() {
		return currentQuestion;
	}

	public String getCurrentAnswer() {
		return currentAnswer;
	}

}