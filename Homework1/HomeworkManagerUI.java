import javax.swing.*;

import Classes.LoginIdentity;
import Classes.User;
import Classes.UserListPageEventArgs;
import Enums.Operations;
import Enums.Roles;
import Classes.AuthorityMatrix;
import Classes.CommentPageEventArg;
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
    UserListPage userListPage;
    User loginedUser;

    @Override
    public void pageEvent(PageTypes pageType, Object object) {
        frame = new JFrame();
        if (pageType == PageTypes.LoginPage) {
            if (object != null) {
                LoginIdentity identity = (LoginIdentity) object;
                try {
                    loginedUser = HomeworkManagerSession.Authorize(identity);
                    // _session = HomeworkManagerSession.CreateSession(loginedUser,
                    // HomeworkManagerSession.Homework);
                    if (loginedUser.getRole() == Roles.Admin) {
                        userListPage = new UserListPage(frame, loginedUser);
                        userListPage.addPageListener(this);
                    } else if (loginedUser.getRole() == Roles.Teacher) {
                        userListPage = new UserListPage(frame, loginedUser);
                        userListPage.addPageListener(this);
                    } else {
                        _session = HomeworkManagerSession.CreateSession(loginedUser, HomeworkManagerSession.Homework);
                        managementPage = new ManagementPage(_session, frame);
                        managementPage.addPageListener(this);
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
                        ScorePage page = new ScorePage(new JFrame(), _session);
                        page.addPageListener(this);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "不允许", "错误", 0);
                }

            }
        } else if (pageType == PageTypes.CommentPage) {
            try {
                var arg = (CommentPageEventArg)object;
                _session.CommentHomework(arg.getComment());
                _session.ScoreHomework(arg.getScore());
                managementPage.UpdateInfo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "错误", 0);
            }
        } else if (pageType == PageTypes.ScorePage) {
            try {
                _session.CommentHomework((String) object);
                managementPage.UpdateInfo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "错误", 0);
            }
        } else if (pageType == PageTypes.SubmitPage) {
            try {
                _session.SubmitHomework((String) object);
                managementPage.UpdateInfo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "错误", 0);
            }
        } else if (pageType == PageTypes.UserListPage) {
            UserListPageEventArgs arg = (UserListPageEventArgs) object;

            if (arg.getOperation() == Operations.AddUser) {
                HomeworkManagerSession.Users.add(arg.getUser());
                userListPage.UpdatePage();
            } else {
                try {
                    _session = HomeworkManagerSession.CreateSession(arg.getUser(), loginedUser,
                            HomeworkManagerSession.Homework);
                    managementPage = new ManagementPage(_session, frame);
                    managementPage.addPageListener(this);
                } catch (Exception ex) {

                }
            }
        }
    }
}
