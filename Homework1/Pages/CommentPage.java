package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import Classes.Homework;
import Classes.HomeworkResult;

import java.awt.event.*;

import java.awt.*;


public class CommentPage extends Page implements ActionListener {
    private JTextArea _commentArea;
    private JTextArea _contentArea;
    private JButton _saveButton;
    private JFrame _frame;
    public CommentPage(JFrame frame, HomeworkResult homeworkResult) {
        // JFrame portalFrame = new JFrame();
        _frame = frame;
        frame.getContentPane().removeAll();
        _saveButton = new JButton("保存");
        _saveButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        GridLayout layout = new GridLayout(3,1);
        panel.setLayout(layout);
        _contentArea = new JTextArea();
        _contentArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        _contentArea.setText(homeworkResult.getContent());
        _contentArea.setEditable(false);
        panel.add(_contentArea);
        _commentArea = new JTextArea();
        panel.add(_commentArea);
        panel.add(_saveButton);
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new DimensionUIResource(1024, 768));
        frame.setTitle("作业点评");
        // frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comment = _commentArea.getText();
        InvokePageEvent(PageTypes.CommentPage, comment);
        _frame.dispatchEvent(new WindowEvent(_frame, WindowEvent.WINDOW_CLOSING));
    }

    
}
