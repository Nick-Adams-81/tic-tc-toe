import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;


    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        titlePanel.add(textField);


        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if(player1Turn) {
                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O Turn");
                        check();
                    }
                } else {
                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X Turn");
        } else {
            player1Turn = false;
            textField.setText("O Turn");
        }
    }

    public void check() {

    }

    public void xWins(int a, int b, int c) {

    }

    public void oWins(int a, int b, int c) {

    }
}
