import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame {
    private Container Pane;
    private String player;
    private String playerNumber;
    private JButton [][] button;
    private JMenu menu;
    private JMenuBar menu_Bar;
    private JMenuItem restart;
    private JMenuItem playerChanger;
    private boolean Win;

    public gui (){
        super();
        Pane = getContentPane();
        Pane.setLayout(new GridLayout(3, 3));
        setTitle("Noughts and crosses");
        setSize(700,700);
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        player = "0";
        playerNumber = "1";
        button = new JButton[3][3];
        Win = false;
        initButton();
        initMenu();
        setVisible(true);
    }
    private void initMenu(){
        menu_Bar = new JMenuBar();
        menu = new JMenu("Options");
        restart = new JMenuItem("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartgame();
            }
        });
        playerChanger = new JMenuItem("Change players");
        playerChanger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartgame();
                turnChange();
            }
        });
        menu.add(restart);
        menu.add(playerChanger);
        menu_Bar.add(menu);
        setJMenuBar(menu_Bar);
    }
    private void restartgame(){
        player = "0";
        playerNumber = "1";
        Win = false;
        for (int j = 0; j < 3; j++){
            for (int k = 0; k < 3; k++){
                button[j][k].setText("");
            }
        }
    }
    private void initButton(){
        for (int j = 0; j < 3; j++){
            for (int k = 0; k < 3; k++){
                JButton screenbutton = new JButton();
                screenbutton.setFont(new Font(Font.SERIF,Font.ITALIC,225));
                button[j][k] = screenbutton;
                screenbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(((JButton)e.getSource()).getText().equals("") && Win == false){
                            screenbutton.setText(player);
                            win();
                            turnChange();
                        }
                    }
                });
                Pane.add(screenbutton);
            }
        }
    }
    private void turnChange(){
        if (player == "x"){
            player = "0";
            playerNumber = "1";
        }
        else {
            player = "x";
            playerNumber = "2";
        }
    }
    private void win(){
        if (button[0][0].getText().equals(player) && button[1][0].getText().equals(player) && button[2][0].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
        else if (button[0][1].getText().equals(player) && button[1][1].getText().equals(player) && button[2][1].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
        else if (button[0][2].getText().equals(player) && button[1][2].getText().equals(player) && button[2][2].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
        else if (button[0][0].getText().equals(player) && button[0][1].getText().equals(player) && button[0][2].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
        else if (button[1][0].getText().equals(player) && button[1][1].getText().equals(player) && button[1][2].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
        else if (button[2][0].getText().equals(player) && button[2][1].getText().equals(player) && button[2][2].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
        else if (button[0][0].getText().equals(player) && button[1][1].getText().equals(player) && button[2][2].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
        else if (button[0][2].getText().equals(player) && button[1][1].getText().equals(player) && button[2][0].getText().equals(player)){
            JOptionPane.showMessageDialog(null,"Player "+ playerNumber +" is winner");
        }
    }

}
