package ImageScale;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

public class RescaleImage {
    public static void main(String[] args) throws Exception {
        BufferedImage imgSource = ImageIO.read(new File("/Users/Qstar/spring/helloJava/src/ImageScale/image.jpg"));
        BufferedImage imgDestination = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imgDestination.createGraphics();
        AffineTransform affinetransformation = AffineTransform.getScaleInstance(2, 2);
        g.drawRenderedImage(imgSource, affinetransformation);
        ImageIO.write(imgDestination, "JPG", new File("/Users/Qstar/spring/helloJava/src/ImageScale/outImage.jpg"));
    }
}
