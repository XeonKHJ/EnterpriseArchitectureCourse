package Classes;
import Enums.Roles;

public class User {
    private int _id;
    private Roles _role;
    private String _account;
    private String _password;
    public User(int id, Roles role, String account, String password)
    {
        _id = id;
        _role = role;
        _account = account;
        _password = password;
    }

    public String getPassword()
    {
        return _password;
    }

    public String getAccount()
    {
        return _account;
    }

    public int getId()
    {
        return _id;
    }

    public void setRole(Roles role)
    {
        _role = role;
    }

    public Roles getRole()
    {
        return _role;
    }
}
