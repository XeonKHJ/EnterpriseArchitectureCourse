import javax.swing.*;

import Classes.LoginIdentity;
import Enums.Operations;
import Enums.Roles;
import Classes.AuthorityMatrix;
import Classes.HomeworkManagerSession;
import Pages.*;

public class HomeworkManagerUI implements PageListener {
    private JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    private HomeworkManagerSession _session;

    public HomeworkManagerUI() {
        LoginPage loginPage = new LoginPage(frame);
        loginPage.addPageListener(this);
    }

    ManagementPage managementPage;

    @Override
    public void pageEvent(PageTypes pageType, Object object) {
        if (pageType == PageTypes.LoginPage) {
            if (object != null) {
                LoginIdentity identity = (LoginIdentity) object;
                try {
                    _session = HomeworkManagerSession.CreateSession(identity);
                    if (_session != null) {
                        if(_session.getUser().getRole() == Roles.Admin)
                        {
                            UserListPage userListPage = new UserListPage(frame);
                        }
                        else{
                            managementPage = new ManagementPage(_session, frame);
                            managementPage.addPageListener(this);
                        }

                    }


                } catch (Exception exception) {

                }
            }
        } else if (pageType == PageTypes.ManagementPage) {
            if (object != null) {
                Operations op = (Operations) object;
                if (AuthorityMatrix.IsOperationLegal(_session.getUser().getRole(), op)) {
                    if (op == Operations.CommentHomwork) {
                        CommentPage page = new CommentPage(new JFrame(), _session.getHomeworkResult());
                        page.addPageListener(this);
                    } else if (op == Operations.SubmitHomework) {
                        SubmitPage page = new SubmitPage(new JFrame());
                        page.addPageListener(this);
                    } else if (op == Operations.ScoreHomework) {
                        ScorePage page = new ScorePage(new JFrame());
                        page.addPageListener(this);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "不允许", "错误", 0);
                }

            }
        } else if (pageType == PageTypes.CommentPage) {
            try {
                _session.CommentHomework(HomeworkManagerSession.Homework, (String) object);
                managementPage.UpdateInfo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "错误", 0);
            }
        } else if (pageType == PageTypes.ScorePage) {
            try {
                _session.CommentHomework(HomeworkManagerSession.Homework, (String) object);
                managementPage.UpdateInfo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "错误", 0);
            }
        } else if(pageType == PageTypes.SubmitPage)
        {
            try {
                _session.SubmitHomework(HomeworkManagerSession.Homework, (String) object);
                managementPage.UpdateInfo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "错误", 0);
            }
        }
    }
}
