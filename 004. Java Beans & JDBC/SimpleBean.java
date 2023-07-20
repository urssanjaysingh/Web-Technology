import java.awt.*;
import javax.swing.JFrame;

public class SimpleBean extends Canvas {

    public SimpleBean() {
        setSize(60, 40);
        setBackground(Color.red);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Bean Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimpleBean bean = new SimpleBean();

        frame.getContentPane().add(bean);
        frame.pack();
        frame.setVisible(true);
    }
}
