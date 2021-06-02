package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;

import java.awt.*;


public class CommentPage {
    public CommentPage(JFrame frame) {
        // JFrame portalFrame = new JFrame();
        frame.getContentPane().removeAll();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(2, 1));

        panel.add(new JTextArea());
        panel.add(new JButton("保存"));
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new DimensionUIResource(1024, 768));
        frame.setTitle("作业点评");
        // frame.pack();
        frame.setVisible(true);
    }
}
