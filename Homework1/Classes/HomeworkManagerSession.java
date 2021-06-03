package Classes;

import java.util.ArrayList;
import java.util.List;

import Enums.Operations;
import Enums.Roles;

public class HomeworkManagerSession {
    public static List<User> Users = new ArrayList<User>();
    public static Homework Homework;

    private HomeworkResult _homeworkResult;
    private User _user;

    private static List<HomeworkResult> _homeworkResults = new ArrayList<HomeworkResult>();

    private HomeworkManagerSession(User student, Homework homework) {
        _user = student;

        HomeworkResult result = null;
        for(var hr : _homeworkResults)
        {
            if(hr.getUser() == student && hr.getHomework() == homework)
            {
                result = hr;
            }
        }
        if(result == null)
        {
            result = new HomeworkResult(student, homework);
            _homeworkResults.add(result);
        }

        _homeworkResult = result;
    }

    private HomeworkManagerSession(User student, User teacher, Homework homework)
    {
        _user = teacher;

        HomeworkResult result = null;
        for(var hr : _homeworkResults)
        {
            if(hr.getUser() == student && hr.getHomework() == homework)
            {
                result = hr;
                break;
            }
        }
        if(result == null)
        {
            result = new HomeworkResult(student, homework);
            _homeworkResults.add(result);
        }

        _homeworkResult = result;
    }

    public static HomeworkManagerSession CreateSession(User student, User teacher, Homework homework) throws Exception
    {
        if(student.getRole() != Roles.Student || teacher.getRole() != Roles.Teacher)
        {
            throw new Exception("身份错误！");
        }
        var session = new HomeworkManagerSession(student, teacher, homework);
        return session;
    }

    public static HomeworkManagerSession CreateSession(User student, Homework homework) throws Exception
    {
        if(student.getRole() != Roles.Student)
        {
            throw new Exception("身份错误");
        }
        var session = new HomeworkManagerSession(student, homework);
    
        return session;
    }

    public static User Authorize(LoginIdentity identity) throws Exception {
        User result = null;
        for (var user : Users) {
            if (user.getAccount().equals(identity.Username)) {
                result = user;
                break;
            }
        }

        if(result == null)
        {
            throw new Exception("授权失败！");
        }

        return result;
    }

    public User getUser()
    {
        return _user;
    }


    public void SubmitHomework(String content) throws Exception
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

    public void CommentHomework(String comment) throws Exception
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

    public List<HomeworkScoreInfo> getHomeworkResults() throws Exception
    {
        List<HomeworkScoreInfo> infos = new ArrayList<HomeworkScoreInfo>();
        if(AuthorityMatrix.IsOperationLegal(_user.getRole(), Operations.CommentHomwork))
        {
            for(var result : _homeworkResults)
            {
                infos.add(new HomeworkScoreInfo(result.getUser().getAccount(), result.getScore()));
            }
            
        }
        else{
            throw new Exception("不允许");
        }

        return infos;
    }

    public void ScoreHomework(int score) throws Exception
    {
        if(AuthorityMatrix.IsOperationLegal(_user.getRole(), Operations.CommentHomwork))
        {
            _homeworkResult.setScore(score);
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
