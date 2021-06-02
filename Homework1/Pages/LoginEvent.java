package Pages;
import java.util.EventObject;
import Classes.LoginIdentity;
public class LoginEvent extends EventObject {
    private LoginIdentity _loginIdentity;
    public LoginEvent(Object source, LoginIdentity identity)
    {
        super(source);
        _loginIdentity = identity;
    }
    public LoginIdentity GetLoginIdentity()
    {
        return _loginIdentity;
    }
}
