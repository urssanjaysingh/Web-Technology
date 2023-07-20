import javax.swing.*;
import java.awt.*;

public class GraphicsDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraphics(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void drawGraphics(Graphics g) {
        // Draw a rectangle
        g.drawRect(50, 50, 200, 200);

        // Draw a circle inside the rectangle
        g.drawOval(50, 50, 200, 200);

        // Draw a line in the center of the rectangle and circle
        int centerX = 50 + 200 / 2;
        int centerY = 50 + 200 / 2;
        g.drawLine(centerX, 50, centerX, 250);
        g.drawLine(50, centerY, 250, centerY);
    }
}
