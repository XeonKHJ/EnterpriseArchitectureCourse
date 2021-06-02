package Classes;

import java.util.ArrayList;
import java.util.List;

import Enums.Operations;

public class HomeworkManagerSession {
    public static List<User> Users = new ArrayList<User>();
    public static Homework Homework;
    private User _user;

    private HomeworkManagerSession(User user) {
        _user = user;
    }

    public static HomeworkManagerSession CreateSession(LoginIdentity identity) throws Exception {
        User logingUser = null;
        HomeworkManagerSession session;
        for (var user : Users) {
            if (user.getAccount().equals(identity.Username)) {
                logingUser = user;
                break;
            }
        }

        if (logingUser != null) {
            session = new HomeworkManagerSession(logingUser);
        } else {
            throw new Exception();
        }

        return session;
    }

    public User getUser()
    {
        return _user;
    }


    public void SubmitHomework(Homework homework, String content) throws Exception
    {
        if(AuthorityMatrix.IsOperationLegal(_user.getRole(), Operations.SubmitHomework))
        {
            homework.setContent(content);
        }
        else
        {
            throw new Exception("不允许");
        }
    }

    public void CommentHomework(Homework homework, String comment) throws Exception
    {
        if(AuthorityMatrix.IsOperationLegal(_user.getRole(), Operations.CommentHomwork))
        {
            homework.setComment(comment);
        }
        else
        {
            throw new Exception("不允许");
        }
    }
}
