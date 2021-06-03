package Classes;

public class HomeworkResult {
    private User _user;
    private Homework _homework;
    private String _comment = "无点评";
    private int _score = 0;
    private String _content = "暂未提交";
    public HomeworkResult(User user, Homework homework)
    {
        _user = user;
        _homework = homework;
    }

    public void setContent(String content)
    {
        if(content == null)
        {
            content = "暂未提交";
        }
        _content = content;
    }

    public String getContent()
    {
        return _content;
    }

    public void setComment(String comment)
    {
        if(comment == null)
        {
            comment = "无点评";
        }
        _comment = comment;
    }

    public String getComment()
    {
        return _comment;
    }

    public User getUser()
    {
        return _user;
    }

    public Homework getHomework()
    {
        return _homework;
    }

    public void setScore(int score)
    {
        _score = score;
    }

    public int getScore()
    {
        return _score;
    }
}
