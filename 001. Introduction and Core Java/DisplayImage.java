import java.awt.*;
import java.applet.*;

/* <applet code = "DisplayImage.class" width = "655" height = "640"></applet> */

public class DisplayImage extends Applet {
    Image picture;

    public void init() {
        try {
            picture = getImage(getDocumentBase(), "CV_Pic.jpg");
        } catch (Exception e) {
            System.out.println("Error loading image: " + e);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(picture, 30, 30, this);
    }
}
