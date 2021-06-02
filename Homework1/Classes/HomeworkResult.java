package Classes;

public class HomeworkResult {
    private User _user;
    private Homework _homework;
    public HomeworkResult(User user, Homework homework)
    {
        _user = user;
        homework = _homework;
    }

    public User getUser()
    {
        return _user;
    }

    public Homework getHomework()
    {
        return _homework;
    }
}
