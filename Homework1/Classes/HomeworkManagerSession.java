package Classes;

import java.util.ArrayList;
import java.util.List;

import Enums.Operations;

public class HomeworkManagerSession {
    public static List<User> Users = new ArrayList<User>();
    public static Homework Homework;

    private HomeworkResult _homeworkResult;
    private User _user;

    private HomeworkManagerSession(User user) {
        _user = user;
        _homeworkResult = new HomeworkResult(user, Homework);
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
            _homeworkResult.setContent(content);
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
            _homeworkResult.setComment(comment);
        }
        else
        {
            throw new Exception("不允许");
        }
    }

    public HomeworkResult getHomeworkResult()
    {
        return _homeworkResult;
    }
}
