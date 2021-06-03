package Classes;

public class HomeworkResult {
    private User _user;
    private Homework _homework;
    private String _comment = "";
    private int _score = 0;
    private String _content = "";
    public HomeworkResult(User user, Homework homework)
    {
        _user = user;
        homework = _homework;
    }

    public void setContent(String content)
    {
        if(content == null)
        {
            content = "";
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
            comment = "";
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
