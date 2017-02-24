import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Write a description of class Button here.
 * 
 * @author Ping-Chun Chung
 * @version v1.0
 */
public class Button extends JButton
{
    ImageIcon X,O;    

    public Button()
    {
        X =new ImageIcon(this.getClass().getResource("ima/X.png"));
        O =new ImageIcon(this.getClass().getResource("ima/O.png"));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

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
