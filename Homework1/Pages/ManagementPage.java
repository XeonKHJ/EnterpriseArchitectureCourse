package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;

import java.awt.*;

import Classes.Homework;
import Classes.HomeworkManagerSession;
import Enums.Roles;

public class ManagementPage implements ActionListener
{
    private HomeworkManagerSession _session;
    private JButton submitButton = new JButton("作业提交");
    private JButton commentButton = new JButton("作业点评");
    private JButton scoreButton = new JButton("成绩统计");
    private Homework _homework;
    public ManagementPage(HomeworkManagerSession session, Homework homework, JFrame frame)
    {
        //JFrame portalFrame = new JFrame();
        _homework = homework;
        frame.getContentPane().removeAll();
        if(session != null)
        {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
            panel.setLayout(new GridLayout(4, 1));
            //panel.add(new JLabel("欢迎您：" + session.getUser().getAccount()));
            //panel.add(new JPanel());
            JLabel homeworkTitleLabel = new JLabel();
            panel.add(homeworkTitleLabel);
            JTextArea homeworkDescriptionLabel = new JTextArea();
            panel.add(homeworkDescriptionLabel);

            JPanel commentAndScorePanel = new JPanel();
            commentAndScorePanel.setLayout(new GridLayout(1,2));
            panel.add(commentAndScorePanel);
            commentAndScorePanel.add(new JLabel("作业点评"));
            commentAndScorePanel.add(new JLabel("作业成绩："));
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1,3));
            submitButton.addActionListener(this);
            buttonsPanel.add(submitButton);
            commentButton.addActionListener(this);
            buttonsPanel.add(commentButton);
            scoreButton.addActionListener(this);
            buttonsPanel.add(scoreButton);
            panel.add(buttonsPanel);

            // set up the frame and display it
            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new DimensionUIResource(1024, 768));
            frame.setTitle("作业点评");

            if(_homework != null)
            {
                homeworkTitleLabel.setText(_homework.getTitle());
                homeworkDescriptionLabel.setText(_homework.getDescription());
            }
            //frame.pack();
            frame.setVisible(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        var source = e.getSource();
        if(source == commentButton)
        {
            new CommentPage(new JFrame());
            int sdfjsldf = 0;
        }
    }
}
