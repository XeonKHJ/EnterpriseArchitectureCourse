import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentManagerUI implements ActionListener
{
    private int clicks = 0;
    private JLabel label = new JLabel("Number of clicks:  0     ");
    private JFrame frame = new JFrame();
    private JTextArea userNameTextArea = new JTextArea();
    private JPasswordField passwordArea = new JPasswordField();
    JButton loginButton = new JButton("Login");
    public StudentManagerUI()
    {
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
            int i = 0;
        }
        else
        {
            clicks++;
            label.setText("Number of clicks:  " + clicks);
        }
    }
}
