package Classes;

import java.util.ArrayList;
import java.util.List;

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

    public void AddUsers(User user) {
        
    }

    public void DeleteUsers(User user) {

    }

    public void EditProfile(User user) {

    }

    public void ChooseCourse() {

    }
}
