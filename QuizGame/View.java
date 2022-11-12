import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class View implements Observer {

    private Model model;
    private Controller controller;

    JTextField tournamentText, roundText, roomText, readerText;
    JTextField teamAText, player1AText, player2AText, player3AText, player4AText, pointsATeam1, pointsATeam2,
            pointsATeam3, pointsATeam4, pointsATeam5, pointsATeam6, pointsATeam7, pointsATeam8, pointsATeam9,
            pointsATeam10, pointsATeam11, pointsATeam12, pointsATeam13, pointsATeam14, pointsATeam15;
    JTextField teamBText, player1BText, player2BText, player3BText, player4BText, pointsBTeam1, pointsBTeam2,
            pointsBTeam3, pointsBTeam4, pointsBTeam5, pointsBTeam6, pointsBTeam7, pointsBTeam8, pointsBTeam9,
            pointsBTeam10, pointsBTeam11, pointsBTeam12, pointsBTeam13, pointsBTeam14, pointsBTeam15;
    JTextArea questionInfo, questionText, answerText;
    JButton buzzATeam, buzzBTeam, bonusATeam, bonusBTeam, nextQuestionButton;

    public static void placeholderStyle(JTextField textField) {
        Font font = textField.getFont();
        textField.setFont(font);
        textField.setForeground(Color.gray); // font colour
    }

    public View(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
        // this.controller.setView(this);
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz Bowl Reader");
        frame.add(panel);

        panel.setLayout(null);

        // Column 1
        tournamentText = new JTextField("Tournament");
        tournamentText.setBounds(10, 20, 165, 30);
        placeholderStyle(tournamentText);
        panel.add(tournamentText);

        roundText = new JTextField("Round");
        roundText.setBounds(10, 50, 165, 30);
        placeholderStyle(roundText);
        panel.add(roundText);

        // Column 2
        teamAText = new JTextField("Team A");
        teamAText.setBounds(200, 20, 165, 30);
        placeholderStyle(teamAText);
        panel.add(teamAText);

        player1AText = new JTextField("Player 1");
        player1AText.setBounds(200, 50, 165, 30);
        placeholderStyle(player1AText);
        panel.add(player1AText);

        player2AText = new JTextField("Player 2");
        player2AText.setBounds(200, 80, 165, 30);
        placeholderStyle(player2AText);
        panel.add(player2AText);

        player3AText = new JTextField("Player 3");
        player3AText.setBounds(200, 110, 165, 30);
        placeholderStyle(player3AText);
        panel.add(player3AText);

        player4AText = new JTextField("Player 4");
        player4AText.setBounds(200, 140, 165, 30);
        placeholderStyle(player4AText);
        panel.add(player4AText);

        // Column 3 - points A team
        // First row
        pointsATeam1 = new JTextField("10");
        pointsATeam1.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam1.setBounds(420, 20, 40, 30);
        panel.add(pointsATeam1);

        pointsATeam2 = new JTextField("-5");
        pointsATeam2.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam2.setBounds(460, 20, 40, 30);
        panel.add(pointsATeam2);

        pointsATeam3 = new JTextField("0");
        pointsATeam3.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam3.setBounds(500, 20, 40, 30);
        placeholderStyle(pointsATeam3);
        panel.add(pointsATeam3);

        // Second row
        pointsATeam4 = new JTextField("0");
        pointsATeam4.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam4.setBounds(420, 50, 40, 30);
        placeholderStyle(pointsATeam4);
        panel.add(pointsATeam4);

        pointsATeam5 = new JTextField("0");
        pointsATeam5.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam5.setBounds(460, 50, 40, 30);
        placeholderStyle(pointsATeam5);
        panel.add(pointsATeam5);

        pointsATeam6 = new JTextField("0");
        pointsATeam6.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam6.setBounds(500, 50, 40, 30);
        placeholderStyle(pointsATeam6);
        panel.add(pointsATeam6);

        // Third row
        pointsATeam7 = new JTextField("0");
        pointsATeam7.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam7.setBounds(420, 80, 40, 30);
        placeholderStyle(pointsATeam7);
        panel.add(pointsATeam7);

        pointsATeam8 = new JTextField("0");
        pointsATeam8.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam8.setBounds(460, 80, 40, 30);
        placeholderStyle(pointsATeam8);
        panel.add(pointsATeam8);

        pointsATeam9 = new JTextField("0");
        pointsATeam9.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam9.setBounds(500, 80, 40, 30);
        placeholderStyle(pointsATeam9);
        panel.add(pointsATeam9);

        // Fourth row
        pointsATeam10 = new JTextField("0");
        pointsATeam10.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam10.setBounds(420, 110, 40, 30);
        placeholderStyle(pointsATeam10);
        panel.add(pointsATeam10);

        pointsATeam11 = new JTextField("0");
        pointsATeam11.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam11.setBounds(460, 110, 40, 30);
        placeholderStyle(pointsATeam11);
        panel.add(pointsATeam11);

        pointsATeam12 = new JTextField("0");
        pointsATeam12.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam12.setBounds(500, 110, 40, 30);
        placeholderStyle(pointsATeam12);
        panel.add(pointsATeam12);

        // Fifth row
        pointsATeam13 = new JTextField("0");
        pointsATeam13.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam13.setBounds(420, 140, 40, 30);
        placeholderStyle(pointsATeam13);
        panel.add(pointsATeam13);

        pointsATeam14 = new JTextField("0");
        pointsATeam14.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam14.setBounds(460, 140, 40, 30);
        placeholderStyle(pointsATeam14);
        panel.add(pointsATeam14);

        pointsATeam15 = new JTextField("0");
        pointsATeam15.setHorizontalAlignment(JTextField.CENTER);
        pointsATeam15.setBounds(500, 140, 40, 30);
        placeholderStyle(pointsATeam15);
        panel.add(pointsATeam15);

        // Column 4
        teamBText = new JTextField("Team B");
        teamBText.setBounds(600, 20, 165, 30);
        placeholderStyle(teamBText);
        panel.add(teamBText);

        player1BText = new JTextField("Player 1");
        player1BText.setBounds(600, 50, 165, 30);
        placeholderStyle(player1BText);
        panel.add(player1BText);

        player2BText = new JTextField("Player 2");
        player2BText.setBounds(600, 80, 165, 30);
        placeholderStyle(player2BText);
        panel.add(player2BText);

        player3BText = new JTextField("Player 3");
        player3BText.setBounds(600, 110, 165, 30);
        placeholderStyle(player3BText);
        panel.add(player3BText);

        player4BText = new JTextField("Player 4");
        player4BText.setBounds(600, 140, 165, 30);
        placeholderStyle(player4BText);
        panel.add(player4BText);

        // Column 5 - points B team
        // First row
        pointsBTeam1 = new JTextField("10");
        pointsBTeam1.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam1.setBounds(820, 20, 40, 30);
        panel.add(pointsBTeam1);

        pointsBTeam2 = new JTextField("-5");
        pointsBTeam2.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam2.setBounds(860, 20, 40, 30);
        panel.add(pointsBTeam2);

        pointsBTeam3 = new JTextField("0");
        pointsBTeam3.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam3.setBounds(900, 20, 40, 30);
        placeholderStyle(pointsBTeam3);
        panel.add(pointsBTeam3);

        // Second row
        pointsBTeam4 = new JTextField("0");
        pointsBTeam4.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam4.setBounds(820, 50, 40, 30);
        placeholderStyle(pointsBTeam4);
        panel.add(pointsBTeam4);

        pointsBTeam5 = new JTextField("0");
        pointsBTeam5.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam5.setBounds(860, 50, 40, 30);
        placeholderStyle(pointsBTeam5);
        panel.add(pointsBTeam5);

        pointsBTeam6 = new JTextField("0");
        pointsBTeam6.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam6.setBounds(900, 50, 40, 30);
        placeholderStyle(pointsBTeam6);
        panel.add(pointsBTeam6);

        // Third row
        pointsBTeam7 = new JTextField("0");
        pointsBTeam7.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam7.setBounds(820, 80, 40, 30);
        placeholderStyle(pointsBTeam7);
        panel.add(pointsBTeam7);

        pointsBTeam8 = new JTextField("0");
        pointsBTeam8.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam8.setBounds(860, 80, 40, 30);
        placeholderStyle(pointsBTeam8);
        panel.add(pointsBTeam8);

        pointsBTeam9 = new JTextField("0");
        pointsBTeam9.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam9.setBounds(900, 80, 40, 30);
        placeholderStyle(pointsBTeam9);
        panel.add(pointsBTeam9);

        // Fourth row
        pointsBTeam10 = new JTextField("0");
        pointsBTeam10.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam10.setBounds(820, 110, 40, 30);
        placeholderStyle(pointsBTeam10);
        panel.add(pointsBTeam10);

        pointsBTeam11 = new JTextField("0");
        pointsBTeam11.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam11.setBounds(860, 110, 40, 30);
        placeholderStyle(pointsBTeam11);
        panel.add(pointsBTeam11);

        pointsBTeam12 = new JTextField("0");
        pointsBTeam12.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam12.setBounds(900, 110, 40, 30);
        placeholderStyle(pointsBTeam12);
        panel.add(pointsBTeam12);

        // Fifth row
        pointsBTeam13 = new JTextField("0");
        pointsBTeam13.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam13.setBounds(820, 140, 40, 30);
        placeholderStyle(pointsBTeam13);
        panel.add(pointsBTeam13);

        pointsBTeam14 = new JTextField("0");
        pointsBTeam14.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam14.setBounds(860, 140, 40, 30);
        placeholderStyle(pointsBTeam14);
        panel.add(pointsBTeam14);

        pointsBTeam15 = new JTextField("0");
        pointsBTeam15.setHorizontalAlignment(JTextField.CENTER);
        pointsBTeam15.setBounds(900, 140, 40, 30);
        placeholderStyle(pointsBTeam15);
        panel.add(pointsBTeam15);

        // Column 6
        roomText = new JTextField("Room");
        roomText.setBounds(1000, 20, 165, 30);
        placeholderStyle(roomText);
        panel.add(roomText);

        readerText = new JTextField("Reader");
        readerText.setBounds(1000, 50, 165, 30);
        placeholderStyle(readerText);
        panel.add(readerText);

        // Info, question and answer part
        questionInfo = new JTextArea("Info:");
        questionInfo.setBounds(10, 200, 1170, 100);
        questionInfo.setLineWrap(true);
        questionInfo.setWrapStyleWord(true);
        panel.add(questionInfo);

        questionText = new JTextArea("Question:");
        questionText.setBounds(10, 300, 1170, 100);
        questionText.setLineWrap(true);
        questionText.setWrapStyleWord(true);
        panel.add(questionText);

        answerText = new JTextArea("Answer:");
        answerText.setBounds(10, 400, 1170, 100);
        answerText.setLineWrap(true);
        answerText.setWrapStyleWord(true);
        panel.add(answerText);

        // Lower part
        buzzATeam = new JButton("Buzz!");
        buzzATeam.setBounds(10, 550, 590, 30);
        panel.add(buzzATeam);
        buzzATeam.setName("buzzA");
        buzzATeam.addActionListener(controller);

        buzzBTeam = new JButton("Buzz!");
        buzzBTeam.setBounds(600, 550, 590, 30);
        panel.add(buzzBTeam);
        buzzBTeam.setName("buzzB");
        buzzBTeam.addActionListener(controller);

        bonusATeam = new JButton("+ Bonus");
        bonusATeam.setBounds(10, 575, 590, 30);
        panel.add(bonusATeam);
        bonusATeam.setName("bonusA");
        bonusATeam.addActionListener(controller);

        bonusBTeam = new JButton("+ Bonus");
        bonusBTeam.setBounds(600, 575, 590, 30);
        panel.add(bonusBTeam);
        bonusBTeam.setName("bonusB");
        bonusBTeam.addActionListener(controller);

        nextQuestionButton = new JButton("Next Question >");
        nextQuestionButton.setBounds(600, 630, 590, 45);
        panel.add(nextQuestionButton);
        nextQuestionButton.setName("nextQ");
        nextQuestionButton.addActionListener(controller);

        frame.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        // update to see if gameOver
        if (model.gameWon()) {
            disableButtons();
            gameOver();
        } else {
            updateScoreboard();
            updateQuestionBox();
            updateButtons();
        }

    }

    public void updateButtons() {
        if (model.bonusClicked == false && model.teamTurn == 1) {
            bonusATeam.setEnabled(true);
        } else {
            bonusATeam.setEnabled(false);
        }
        if (model.bonusClicked == false && model.teamTurn == 2) {
            bonusBTeam.setEnabled(true);
        } else {
            bonusBTeam.setEnabled(false);
        }
        if (model.teamBBuzzed == false && model.teamTurn == 0) {
            buzzBTeam.setEnabled(true);
        } else {
            buzzBTeam.setEnabled(false);
        }
        if (model.teamABuzzed == false && model.teamTurn == 0) {
            buzzATeam.setEnabled(true);
        } else {
            buzzATeam.setEnabled(false);
        }

    }

    public void disableButtons() {
        bonusATeam.setEnabled(false);
        bonusBTeam.setEnabled(false);
        buzzBTeam.setEnabled(false);
        buzzATeam.setEnabled(false);
        bonusATeam.setEnabled(false);
        bonusBTeam.setEnabled(false);
        nextQuestionButton.setEnabled(false);
    }

    private void gameOver() {
        questionInfo.setText("");
        if (model.getTeamPoints()[0] < model.getTeamPoints()[1]) {
            questionText.setText(teamBText.getText() + " won!");
        } else {
            questionText.setText(teamAText.getText() + " won!");
        }
        answerText.setText("");
    }

    public JButton getButton() {
        return nextQuestionButton;
    }

    private void updateScoreboard() {
        int[][] points = model.getPoints();
        int[] teamPoints = model.getTeamPoints();
        int[][] fiveCounter = model.getCounterFive();
        int[][] tenCounter = model.getCounterTen();
        pointsATeam3.setText(String.valueOf(teamPoints[0]));
        pointsATeam6.setText(String.valueOf(points[0][0]));
        pointsATeam9.setText(String.valueOf(points[0][1]));
        pointsATeam12.setText(String.valueOf(points[0][2]));
        pointsATeam15.setText(String.valueOf(points[0][3]));
        pointsBTeam3.setText(String.valueOf(teamPoints[1]));
        pointsBTeam6.setText(String.valueOf(points[1][0]));
        pointsBTeam9.setText(String.valueOf(points[1][1]));
        pointsBTeam12.setText(String.valueOf(points[1][2]));
        pointsBTeam15.setText(String.valueOf(points[1][3]));

        pointsATeam4.setText(String.valueOf(tenCounter[0][0]));
        pointsATeam7.setText(String.valueOf(tenCounter[0][1]));
        pointsATeam10.setText(String.valueOf(tenCounter[0][2]));
        pointsATeam13.setText(String.valueOf(tenCounter[0][3]));
        pointsBTeam4.setText(String.valueOf(tenCounter[1][0]));
        pointsBTeam7.setText(String.valueOf(tenCounter[1][1]));
        pointsBTeam10.setText(String.valueOf(tenCounter[1][2]));
        pointsBTeam13.setText(String.valueOf(tenCounter[1][3]));

        pointsATeam5.setText(String.valueOf(fiveCounter[0][0]));
        pointsATeam8.setText(String.valueOf(fiveCounter[0][1]));
        pointsATeam11.setText(String.valueOf(fiveCounter[0][2]));
        pointsATeam14.setText(String.valueOf(fiveCounter[0][3]));
        pointsBTeam5.setText(String.valueOf(fiveCounter[1][0]));
        pointsBTeam8.setText(String.valueOf(fiveCounter[1][1]));
        pointsBTeam11.setText(String.valueOf(fiveCounter[1][2]));
        pointsBTeam14.setText(String.valueOf(fiveCounter[1][3]));

    }

    private void updateQuestionBox() {
        questionInfo.setText(model.getBonusInfo());
        questionText.setText(model.getCurrentQuestion());
        answerText.setText(model.getCurrentAnswer());
    }

    public int askPoints() {
        int p = Integer.parseInt(JOptionPane.showInputDialog("How many points?", null));
        return p;
    }

    public int askPlayer() {
        int p = Integer.parseInt(JOptionPane.showInputDialog("Which player answered the question?", null));
        return p;
    }
}