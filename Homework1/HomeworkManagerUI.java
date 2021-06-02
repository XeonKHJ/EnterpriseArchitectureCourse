import javax.swing.*;

import Classes.LoginIdentity;
import Classes.HomeworkManagerSession;
import Pages.*;

public class HomeworkManagerUI implements PageListener
{
    private JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    public HomeworkManagerUI()
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
                    var session = HomeworkManagerSession.CreateSession(identity);
                    if(session != null)
                    {
                        var managementPage = new ManagementPage(session,HomeworkManagerSession.Homework, frame);
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
