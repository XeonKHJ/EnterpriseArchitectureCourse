public class StudentManagerSession {
    private StudentManagerSession(User user) {

    }

    public static StudentManagerSession CreateSession(LoginIdentity identity) throws Exception {
        User logingUser = null;
        StudentManagerSession session;
        for (var user : StudentManagerApp.Users) {
            if (user.getAccount().equals(identity.Username)) {
                logingUser = user;
                break;
            }
        }

        if(logingUser != null)
        {
            session = new StudentManagerSession(logingUser);
        }
        else{
            throw new Exception();
        }

        return session;
    }
}
