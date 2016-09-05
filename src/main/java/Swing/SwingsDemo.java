package Swing;

import javax.swing.*;
import java.awt.*;

public class SwingsDemo extends JFrame {
    public SwingsDemo() {
        String path = "//home//user//Documents//images";
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        Box myHorizontalBox = Box.createHorizontalBox();
        Box myVerticalBox = Box.createVerticalBox();

        myHorizontalBox.add(new JButton("My Button 1"));
        myHorizontalBox.add(new JButton("My Button 2"));
        myHorizontalBox.add(new JButton("My Button 3"));

        myVerticalBox.add(new JButton(new ImageIcon(path + "//Image1.jpg")));
        myVerticalBox.add(new JButton(new ImageIcon(path + "//Image2.jpg")));
        myVerticalBox.add(new JButton(new ImageIcon(path + "//Image3.jpg")));

        contentPane.add(myHorizontalBox);
        contentPane.add(myVerticalBox);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        new SwingsDemo();
    }
}