import java.io.FileNotFoundException;
import java.awt.event.*;
import javax.swing.*;
// Model's Controller

//Refers to methods call on model
public class Controller implements ActionListener {
	private final Model model;
	private View view;

	protected Controller(Model model) {
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton) e.getSource();
		String name = o.getName();
		switch (name) {
			case "nextQ":
				model.bonusClicked = false;
				model.teamABuzzed = false;
				model.teamBBuzzed = false;
				if (model.bonusCounter < 0) {
					model.teamTurn = 0;
					model.nextQuestion();
					if (model.moreQuestions == false) {
						model.setWin(true);
					}
				} else {
					model.nextBonusQuestion();
					model.bonusCounter += 1;
					if (model.bonusCounter == 3) {
						model.bonusCounter = -1;
						if (model.moreQuestions == false) {
							model.setWin(true);
						}
					}
				}
				break;
			case "buzzA":
				if (model.teamABuzzed == false && model.teamTurn == 0) {
					model.teamABuzzed = true;
					model.bonusClicked = true;
					buzz(1);
				}
				break;
			case "buzzB":
				if (model.teamBBuzzed == false && model.teamTurn == 0) {
					model.teamBBuzzed = true;
					model.bonusClicked = true;
					buzz(2);
				}
				break;
			case "bonusA":
				if (model.bonusClicked == false && model.teamTurn == 1) {
					model.changePoints(5, view.askPlayer(), 1);
					model.bonusClicked = true;
				}
				break;
			case "bonusB":
				if (model.bonusClicked == false && model.teamTurn == 2) {
					model.changePoints(5, view.askPlayer(), 2);
					model.bonusClicked = true;

				}
				break;
		}
	}

	public void setView(View view) {
		this.view = view;
	}

	public void buzz(int team) {
		int p = view.askPoints();
		if (p != 0) {
			int player = view.askPlayer();
			model.changePoints(p, player, team);
			if (p == -5) {
				model.incrementCounter(model.getCounterFive(), team, player);
			}
			if (p == 10) {
				bonus(team);
				model.incrementCounter(model.getCounterTen(), team, player);
			} else if (!model.moreQuestions) {
				model.setWin(true);
			}
		}
	}

	public void bonus(int team) {
		model.bonusCounter = 0;
		model.teamTurn = team;
	}
}