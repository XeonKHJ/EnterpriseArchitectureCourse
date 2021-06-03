package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import Classes.HomeworkManagerSession;
import Classes.HomeworkResult;
import Classes.HomeworkScoreInfo;

import java.awt.event.*;

import java.awt.*;

public class ScorePage extends Page{
    private JFrame _frame;
    private JTextArea _textArea;
    public ScorePage(JFrame frame, HomeworkManagerSession session) {
        // JFrame portalFrame = new JFrame();
        _frame = frame;
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(2, 1));
        String scoreInfo = "";
        try {
            for(HomeworkScoreInfo result : session.getHomeworkResults())
            {
                scoreInfo += result.getStudentName() + ":" + result.getScore() + "\n";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        _textArea = new JTextArea(scoreInfo);
        panel.add(_textArea);
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new DimensionUIResource(1024, 768));
        frame.setTitle("成绩统计");
        // frame.pack();
        frame.setVisible(true);
    }
}
