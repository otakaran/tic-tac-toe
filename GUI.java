import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Creates a nice looking GUI for the game using Java.awt.
 * 
 * @author Ping-Chun Chung and Otakar Andrysek
 * @version v1.0.1
 */

public class GUI extends JFrame implements ActionListener
{   
    JButton vsPlayerButton;
    JButton vsComButton;
    boolean vsPlayer;
    boolean vsCom;

    int xScore = 0;
    int oScore = 0;
    JButton homeButton;
    JButton resetButton;
    JLabel menuBackground;
    JLabel gameBackground;
    JLabel xScoreLabel;
    JLabel oScoreLabel;
    JLabel[] line = new JLabel[8];

    JPanel winScreen;
    JButton winScreenButton;

    Button buttons[][] = new Button[3][3];
    int firstPlayer = 0;
    Game game;

    boolean playGame = false;
    public GUI(Game game)
    {
        super("TicTacToe");
        this.game = game;
        displayMenu();
        // Make window exit application on close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set display size
        setSize(500,500);
        // Center the frame to middle of screen
        setLocationRelativeTo(null);
        // Disable resize
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initalizes menu UI components
     */
    public void displayMenu()
    {
        menuBackground = new JLabel(new ImageIcon(this.getClass().getResource("ima/menu.gif")));
        add(menuBackground);
        menuBackground.setLayout(null);

        vsPlayerButton = new JButton();
        vsComButton = new JButton();

        vsPlayerButton.setBounds(311, 227, 166, 56);
        vsPlayerButton.setBorderPainted(false);
        vsPlayerButton.setContentAreaFilled(false);
        vsPlayerButton.addActionListener(this);

        vsComButton.setBounds(311, 357, 166, 56);
        vsComButton.setBorderPainted(false);
        vsComButton.setContentAreaFilled(false);
        vsComButton.addActionListener(this);

        menuBackground.add(vsPlayerButton);
        menuBackground.add(vsComButton);
    }

    /**
     * Initalizes game UI components
     */
    public void displayGame()
    {
        // Outer Panel
        gameBackground = new JLabel(new ImageIcon(this.getClass().getResource("ima/X_turn.jpg")));
        add(gameBackground);
        gameBackground.setLayout(null);

        // Center Panel
        JPanel centerPanel = new JPanel(); 
        centerPanel.setLayout(new GridLayout(3,3,6,6));
        gameBackground.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBounds(80, 103, 340, 340);
        centerPanel.setOpaque(false);

        // O and X buttons
        for(int i=0; i<3; i++)
        {
            for(int n=0; n<3; n++)
            {
                buttons[i][n] = new Button();
                centerPanel.add(buttons[i][n]);                
                buttons[i][n].addActionListener(this);
            }
        }

        // Home button
        homeButton = new JButton();
        gameBackground.add(homeButton);
        homeButton.setBounds(442, 355, 34, 34);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.addActionListener(this);

        // Reset button
        resetButton = new JButton();
        gameBackground.add(resetButton);
        resetButton.setBounds(442, 401, 34, 34);
        resetButton.setBorderPainted(false);
        resetButton.setContentAreaFilled(false);
        resetButton.addActionListener(this);

        // X score
        xScoreLabel = new JLabel(Integer.toString(xScore));
        gameBackground.add(xScoreLabel);
        xScoreLabel.setFont(xScoreLabel.getFont().deriveFont(24.0f));
        xScoreLabel.setBounds(108, 35, 24, 24);

        // O score
        oScoreLabel = new JLabel(Integer.toString(oScore));
        oScoreLabel.setText(Integer.toString(oScore));
        gameBackground.add(oScoreLabel);
        oScoreLabel.setFont(oScoreLabel.getFont().deriveFont(24.0f));
        oScoreLabel.setBounds(375, 35, 24, 24);

        // Line
        for(int i=0; i<8; i++)
        {
            line[i] = new JLabel();
            gameBackground.add(line[i],new Integer(2), 0);
            line[i].setBounds(0, -18, 500, 500);
            line[i].setIcon(new ImageIcon(this.getClass().getResource("ima/line"+(i+1)+".png")));
            line[i].setVisible(false);
        }
    }

    /**
     * Switch game background 
     */
    public void setGameBackground(String t)
    {
        ImageIcon icon = new ImageIcon(this.getClass().getResource("ima/"+t+"_turn.jpg"));
        gameBackground.setIcon(icon);
    }

    /**
     * Draw line on winning line
     */
    public void winningLine(int n)
    {
        line[n-1].setVisible(true);
    }

    /**
     * Initalizes finish screen UI components
     */
    public void iniWinScreen(String t)
    {
        winScreen = new JPanel();
        add(winScreen);
        winScreen.setLayout(null);

        JLabel icon = new JLabel(new ImageIcon(this.getClass().getResource("ima/"+t+".png")));
        winScreen.add(icon);
        icon.setBounds(250-45,150-45,90,90);

        JLabel winner = new JLabel();
        if (t.equals("tie"))
            winner.setText("TIE");
        else
            winner.setText("WIN");
        winner.setFont(winner.getFont().deriveFont(50.0f));
        winner.setBounds(210,250,400,90);
        winScreen.add(winner);

        winScreenButton = new JButton();
        winScreenButton.setBounds(0, 0, 500, 500);
        winScreen.add(winScreenButton);
        winScreenButton.setBorderPainted(true);
        winScreenButton.setContentAreaFilled(false);
        winScreenButton.addActionListener(this);

    }

    /**
     * Display finish screen UI components
     */
    public void displayWinScreen(String t)
    {
        iniWinScreen(t);
        menuBackground.setVisible(false);
        gameBackground.setVisible(false);
        winScreen.setVisible(true);
    }

    /**
     * Check if any button were clicked and performe action
     */
    public void actionPerformed(ActionEvent e)
    {   
        // Start menu
        if(e.getSource().equals(vsPlayerButton))
        {
            menuBackground.setVisible(false);
            displayGame();
            gameBackground.setVisible(true);

            vsPlayer = true;
            vsCom = false;
            playGame = true;
        }

        // Play against Ai
        if(e.getSource().equals(vsComButton))
        {
            menuBackground.setVisible(false);
            displayGame();
            gameBackground.setVisible(true);

            vsPlayer = false;
            vsCom = true;
            playGame = true;
        }

        // Play against another player
        String turn = "-";
        if (game.turn == 0)
            turn = "X";
        else if (game.turn == 1)
            turn = "O";

        if (vsPlayer)
        {
            for(int i=0; i<3; i++)
            {
                for(int n=0; n<3; n++)
                {
                    if(e.getSource().equals(buttons[i][n]) && game.isLegal(i,n))
                    {
                        game.playerPlay(i,n,turn);
                        if (turn.equals("X"))
                            game.turn++;
                        else if (turn.equals("O"))
                            game.turn--;
                    }
                }
            }
        }
        else if (vsCom)
        {
            for(int i=0; i<3; i++)
            {
                for(int n=0; n<3; n++)
                {
                    if(e.getSource().equals(buttons[i][n]) && game.isLegal(i,n) && turn.equals("X"))
                    {
                        game.playerPlay(i,n,turn);
                        game.turn++;
                    }
                }
            }
        }

        // Home button
        if(e.getSource().equals(homeButton))
        {
            game.resetGame();
            game.turn = 0;
            game.whoPlayFirst = 0;
            updataButtonIma();
            xScore = 0;
            oScore = 0;
            menuBackground.setVisible(true);
            gameBackground.setVisible(false);
        }

        // Reset button
        if(e.getSource().equals(resetButton))
        {
            game.resetGame();
            game.turn = game.whoPlayFirst;
            updataButtonIma();
        }

        // Win screen button
        if(e.getSource().equals(winScreenButton))
        {
            for(int i=0; i<8; i++)
                line[i].setVisible(false);

            gameBackground.setVisible(true);
            winScreen.setVisible(false);
            menuBackground.setVisible(false);
            game.resetGame();
            game.SwitchWhoPlayFirst();
            game.turn = game.whoPlayFirst;
            updataButtonIma();
            playGame = true;
        }
    }

    /**
     * Set board image equal to the board array
     */
    public void updataButtonIma()
    {
        for(int i=0; i<3; i++)
        {
            for(int n=0; n<3; n++)
            {
                buttons[i][n].setImaIcon(game.board[i][n]);
            }
        }
    } 

}
