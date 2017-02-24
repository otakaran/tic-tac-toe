import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class generates button objects used in the GUI.
 * 
 * @author Ping-Chun Chung and Otakar Andrysek
 * @version v1.0.1
 */

public class Button extends JButton
{
    ImageIcon X,O;    

    // Prepares X and O images for placing
    public Button()
    {
        X =new ImageIcon(this.getClass().getResource("ima/X.png"));
        O =new ImageIcon(this.getClass().getResource("ima/O.png"));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    // Inserts X and O images into board
    public void setImaIcon(String icon)
    {
        if (icon.equals("-"))
        {
            setIcon(null);
        }
        else if (icon.equals("X"))
        {
            setIcon(X);
        }
        else if (icon.equals("O"))
        {
            setIcon(O);
        }
    }
}
