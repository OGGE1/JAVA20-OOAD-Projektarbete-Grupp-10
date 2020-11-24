package Window;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-11-24 <br>
 * Time: 15:08 <br>
 * Project: JAVA20-OOAD-Projektarbete-Grupp-10 <br>
 */
public class Window2 extends JFrame {

    // Paneler
    JPanel eastPanel = new JPanel(new BorderLayout());
    JLabel tableLabel = new JLabel(" Omgång      Poäng ");
    JPanel buttonPanel = new JPanel(new GridLayout(1,3));
    JLabel name = new JLabel("Namn: Orvar Karlsson");

    // Knappar
    JButton roll = new JButton("Kasta");
    JButton save = new JButton("Spara highscore");
    JButton show = new JButton("Visa highscore");

    // ScoreBoard
    JPanel scoreBoard = new JPanel(new GridLayout(1,2));
    JPanel scoreBoardRounds = new JPanel(new GridLayout(8,1));
    JPanel scoreBoardScores = new JPanel(new GridLayout(8,1));
    List<JLabel> scoreLabels = new ArrayList<>();
    List<JLabel> roundLabels = new ArrayList<>();

    JToggleButton[] dices; // Ej instansierad
    

    public Window2(){
        setUpJFrame();
        setUpPanels();
        setUpScoreBoard();

    }

    public void setUpPanels(){
        this.add(eastPanel,BorderLayout.EAST);
        scoreBoardRounds.setBackground(Color.WHITE);
        scoreBoardScores.setBackground(Color.WHITE);
        scoreBoard.add(scoreBoardRounds);
        scoreBoard.add(scoreBoardScores);
        eastPanel.add(scoreBoard, BorderLayout.CENTER);
        eastPanel.add(tableLabel, BorderLayout.NORTH);
        buttonPanel.add(roll);
        buttonPanel.add(save);
        buttonPanel.add(show);
        buttonPanel.setPreferredSize(new Dimension(390,40));
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.add(name, BorderLayout.NORTH);
    }

    public void setUpScoreBoard(){
        for(int i = 0; i < 8; i++){
            roundLabels.add(new JLabel(String.valueOf(i+1)));
            roundLabels.get(i).setBorder(new EtchedBorder());
            roundLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            roundLabels.get(i).setFont(new Font("MonoSpaced", Font.BOLD, 18));
            scoreBoardRounds.add(roundLabels.get(i));
            if (i == 6) roundLabels.get(i).setText("Bonus");
            if (i == 7) roundLabels.get(i).setText("Summa");
        }

        for(int i = 0; i < 8; i++){
            scoreLabels.add(new JLabel("")); // Just for show. this should be blank
            scoreLabels.get(i).setFont(new Font("MonoSpaced", Font.PLAIN, 20));
            scoreLabels.get(i).setBorder(new EtchedBorder());
            scoreLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            scoreBoardScores.add(scoreLabels.get(i));
        }

    }

    public void setUpJFrame(){
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(400, 480));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Window2();
    }
}
