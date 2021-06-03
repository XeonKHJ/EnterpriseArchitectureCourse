package Classes;

import Enums.Operations;

public class UserListPageEventArgs {
    private Operations _operation;
    private User _user;
    private User _student;
    private User _teacher;
    public UserListPageEventArgs(Operations op, User user)
    {
        _user = user;
        _operation = op;
    }

    public Operations getOperation()
    {
        return _operation;
    }

    public User getUser()
    {
        return _user;
    }

}
