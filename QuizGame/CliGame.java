import javax.swing.*;
import java.util.*;
import java.io.FileNotFoundException;

class CliGame {
	private static Model model;

	public static void main(String args[]) {
		try {
			startGame();
			Scanner sc = new Scanner(System.in);
			String[] qAndA = model.nextQuestion();
			String lastQuestion = "";
			while (!model.gameWon()) {
				System.out.println(qAndA[0]);
				System.out.println(qAndA[1]);
				printMenu(0);
				int menuChoice = sc.nextInt();
				switch (menuChoice) {
					case 1:
						buzz(0);
						qAndA = model.nextQuestion();
						break;
					case 2:
						qAndA = model.nextQuestion();
						break;
					case 3:
						printScore();
						break;
				}
				if (lastQuestion == qAndA[0]) {
					// end game
					model.setWin(true);
				} else {
					lastQuestion = qAndA[0];
				}
			}
			int[] teamPoints = model.getTeamPoints();
			printScore();
			if (teamPoints[0] > teamPoints[1]) {
				System.out.println(model.teams[0] + " has won the game!");
			} else {
				System.out.println(model.teams[1] + " has won the game!");
			}
		} catch (FileNotFoundException ex) {
			// insert code to run when exception occurs
		}
	}

	private static void startGame() throws FileNotFoundException {
		// create new model
		model = new Model();
		// ask user for input
		askForInput();

	}

	private static void askForInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you wish to enter custom names? (Enter 1 for yes, or any key for no)");
		if (sc.nextInt() == 1) {
			System.out.println("Tournament name:");
			model.tournament = sc.nextLine();
			System.out.println("Name for team A:");
			model.teams[0] = sc.nextLine();
			System.out.println("Name for team B:");
			model.teams[1] = sc.nextLine();
			System.out.println("Player 1, " + model.teams[0] + ":");
			model.players[0][0] = sc.nextLine();
			System.out.println("Player 2, " + model.teams[0] + ":");
			model.players[0][1] = sc.nextLine();
			System.out.println("Player 3, " + model.teams[0] + ":");
			model.players[0][2] = sc.nextLine();
			System.out.println("Player 4, " + model.teams[0] + ":");
			model.players[0][3] = sc.nextLine();
			System.out.println("Player 1, " + model.teams[1] + ":");
			model.players[1][0] = sc.nextLine();
			System.out.println("Player 2, " + model.teams[1] + ":");
			model.players[1][1] = sc.nextLine();
			System.out.println("Player 3, " + model.teams[1] + ":");
			model.players[1][2] = sc.nextLine();
			System.out.println("Player 4, " + model.teams[1] + ":");
			model.players[1][3] = sc.nextLine();
		}
	}

	private static void buzz(int pointModifier) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Who answered the question? ");
		int player = sc.nextInt();
		System.out.println("On which team? ");
		int team = sc.nextInt();
		if (pointModifier != 5) {
			System.out.println(
					"Was the question answered correctly?: (press 0 for -5 points, 1 for 10 points, and anything else for 0 points");
		} else {
			System.out.println("Was the question answered correctly?: (press 0 for 0 points, 1 for 5 points");
		}
		int correctAnswer = sc.nextInt();
		if (correctAnswer == 1) {
			model.changePoints(10 - pointModifier, player, team);
			if (pointModifier != 5) {
				bonusQuestions();
			}
		} else if (correctAnswer == 0) {
			model.changePoints(pointModifier - 5, player, team);
		}
	}

	private static void printScore() {
		int[][] points = model.getPoints();
		for (int i = 0; i < points.length; i++) {
			System.out.println("Team " + model.teams[i] + ": " + model.getTeamPoints()[i]);
			for (int v = 0; v < points[i].length; v++) {
				System.out.println("Player " + model.players[i][v] + ": " + points[i][v]);
			}
		}
	}

	private static void printMenu(int questionType) {
		if (questionType == 0) {
			System.out.println("1) Buzz\n2) Next question\n3) Show scores");
		} else if (questionType == 1) {
			System.out.println("1) Bonus\n2) Next question\n3) Show scores");
		}
	}

	private static void bonusQuestions() {
		String[] qAndA = model.nextBonusQuestion();
		System.out.println(model.getBonusInfo());
		System.out.println(qAndA[0]);
		System.out.println(qAndA[1]);
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		while (counter < 3) {

			printMenu(1);
			int menuChoice = sc.nextInt();
			switch (menuChoice) {
				case 1:
					buzz(5);
					qAndA = model.nextBonusQuestion();
					counter += 1;
					break;
				case 2:
					qAndA = model.nextBonusQuestion();
					counter += 1;
					break;
				case 3:
					printScore();
					break;
			}
			System.out.println(model.getBonusInfo());
			System.out.println(qAndA[0]);
			System.out.println(qAndA[1]);

			/*
			 * System.out.println("Who answered the question? ");
			 * int player = sc.nextInt();
			 * System.out.println("Was the question answered correctly?: ");
			 */
		}
	}
}
