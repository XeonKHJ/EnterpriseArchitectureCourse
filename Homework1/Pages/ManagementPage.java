package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;

import java.awt.*;

import Classes.Homework;
import Classes.HomeworkManagerSession;
import Enums.Operations;
import Enums.Roles;

public class ManagementPage extends Page implements ActionListener {
    private JButton submitButton = new JButton("作业提交");
    private JButton commentButton = new JButton("作业点评");
    private JButton scoreButton = new JButton("成绩统计");
    private JLabel commentLabel = new JLabel("作业点评：");
    private JLabel scoreLabel = new JLabel("作业成绩：");
    private HomeworkManagerSession _session;

    public ManagementPage(HomeworkManagerSession session, JFrame frame) {
        // JFrame portalFrame = new JFrame();
        _session = session;
        frame.getContentPane().removeAll();
        if (session != null) {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
            panel.setLayout(new GridLayout(4, 1));
            // panel.add(new JLabel("欢迎您：" + session.getUser().getAccount()));
            // panel.add(new JPanel());
            JLabel homeworkTitleLabel = new JLabel();
            panel.add(homeworkTitleLabel);
            JTextArea homeworkDescriptionLabel = new JTextArea();
            panel.add(homeworkDescriptionLabel);

            JPanel commentAndScorePanel = new JPanel();
            commentAndScorePanel.setLayout(new GridLayout(1, 2));
            panel.add(commentAndScorePanel);
            commentAndScorePanel.add(commentLabel);
            commentAndScorePanel.add(scoreLabel);
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1, 3));
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

            homeworkTitleLabel.setText(session.Homework.getTitle());
            homeworkDescriptionLabel.setText(session.Homework.getDescription());

            // frame.pack();
            frame.setVisible(true);
        }
    }

    public void UpdateInfo() {
        commentLabel.setText(_session.getHomeworkResult().getComment());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var source = e.getSource();
        if (source == commentButton) {
            InvokePageEvent(PageTypes.ManagementPage, Operations.CommentHomwork);
        } else if (source == submitButton) {
            InvokePageEvent(PageTypes.ManagementPage, Operations.SubmitHomework);
        } else if (source == scoreButton) {
            InvokePageEvent(PageTypes.ManagementPage, Operations.ScoreHomework);
        }
    }
}
