package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;

import java.awt.*;

public class SubmitPage extends Page implements ActionListener {
    private JFrame _frame;
    private JButton _saveButton;
    private JTextArea _textArea;
    public SubmitPage(JFrame frame)  {
        // JFrame portalFrame = new JFrame();
        _frame = frame;
        frame.getContentPane().removeAll();
        _saveButton = new JButton("提交");
        _saveButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(2, 1));
        _textArea = new JTextArea();
        panel.add(_textArea);
        panel.add(_saveButton);
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new DimensionUIResource(1024, 768));
        frame.setTitle("提交作业");
        // frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comment = _textArea.getText();
        InvokePageEvent(PageTypes.SubmitPage, comment);
        _frame.dispatchEvent(new WindowEvent(_frame, WindowEvent.WINDOW_CLOSING));
    }
}
