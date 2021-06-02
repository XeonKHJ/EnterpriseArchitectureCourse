import javax.swing.*;

import Classes.LoginIdentity;
import Classes.StudentManagerSession;
import Pages.*;
import java.awt.*;
import java.awt.event.*;

public class StudentManagerUI implements ActionListener, PageListener
{
    private int clicks = 0;
    private JLabel label = new JLabel("Number of clicks:  0     ");
    private JFrame frame = new JFrame();
    private JTextArea userNameTextArea = new JTextArea();
    private JPasswordField passwordArea = new JPasswordField();
    private StudentManagerSession session;
    JButton loginButton = new JButton("Login");
    public StudentManagerUI()
    {
        LoginPage loginPage = new LoginPage(frame);
        loginPage.addLoginListener(this);
    }
    
    @Override
    public void pageEvent(PageTypes pageType, Object object) {
        if(pageType == PageTypes.LoginPage)
        {
            if(object != null)
            {
                LoginIdentity identity = (LoginIdentity)object;
                try{
                    var session = StudentManagerSession.CreateSession(identity);
                    if(session != null)
                    {
                        var managementPage = new ManagementPage(session, new JFrame());
                    }
                }
                catch(Exception exception)
                {

                }
            }
        }
        else if(pageType == PageTypes.ManagementPage)
        {

        }
    }
}
