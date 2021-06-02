package Pages;

import javax.swing.*;

import Classes.LoginIdentity;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.HashSet;

public class LoginPage extends Page implements ActionListener 
{
    private int clicks = 0;
    private JLabel label = new JLabel("Number of clicks:  0     ");
    private JTextArea userNameTextArea = new JTextArea();
    private JPasswordField passwordArea = new JPasswordField();
    JButton loginButton = new JButton("Login");
    public LoginPage(JFrame frame)
    {
        frame.getContentPane().removeAll();
        JButton button = new JButton("Click Me");
        button.addActionListener(this);
        loginButton.addActionListener(this);
        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(new JLabel("用户名："));
        panel.add(userNameTextArea);
        panel.add(new JLabel("密码："));
        panel.add(passwordArea);
        panel.add(loginButton);
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var source = e.getSource();

        if(source == loginButton)
        {
            clicks++;
            label.setText("Number of clicks:  " + clicks);
            var username = userNameTextArea.getText();
            var password = passwordArea.getPassword();
            var identity = new LoginIdentity(username, password);
            logining(identity);
        }
        else
        {
            clicks++;
            label.setText("Number of clicks:  " + clicks);
        }
    }

    protected void logining(LoginIdentity loginIdentity)
    {
        InvokePageEvent(PageTypes.LoginPage, loginIdentity);
    }
}
