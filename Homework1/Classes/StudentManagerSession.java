package Classes;

import java.util.ArrayList;
import java.util.List;

public class StudentManagerSession {
    public static List<User> Users = new ArrayList<User>();
    
    private User _user;

    private StudentManagerSession(User user) {
        _user = user;
    }

    public static StudentManagerSession CreateSession(LoginIdentity identity) throws Exception {
        User logingUser = null;
        StudentManagerSession session;
        for (var user : Users) {
            if (user.getAccount().equals(identity.Username)) {
                logingUser = user;
                break;
            }
        }

        if (logingUser != null) {
            session = new StudentManagerSession(logingUser);
        } else {
            throw new Exception();
        }

        return session;
    }

    public User getUser()
    {
        return _user;
    }

    public void AddUsers(User user) {
        
    }

    public void DeleteUsers(User user) {

    }

    public void EditProfile(User user) {

    }

    public void ChooseCourse() {

    }
}
