package Pages;

import javax.swing.*;
import java.awt.*;

import Classes.StudentManagerSession;

public class ManagementPage
{
    private StudentManagerSession _session;
    public ManagementPage(StudentManagerSession session, JFrame portalFrame)
    {
        //JFrame portalFrame = new JFrame();

        if(session != null)
        {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
            panel.setLayout(new GridLayout(0, 1));
            panel.add(new JLabel("欢迎您：" + session.getUser().getAccount()));
            panel.add(new Button("dskjflskdf"));
    
        
            // set up the frame and display it
            portalFrame.add(panel, BorderLayout.CENTER);
            portalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            portalFrame.setTitle("shit");
            portalFrame.pack();
            portalFrame.setVisible(true);
        }
    }
}