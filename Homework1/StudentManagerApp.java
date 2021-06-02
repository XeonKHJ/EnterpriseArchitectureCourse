import java.util.ArrayList;
import java.util.List;

import Classes.StudentManagerSession;
import Classes.User;
import Enums.Roles;

class StudentManagerApp
{
   
    public static void main(String[] args)
    {
        // Initiate first user
        User firstAdminUser = new User(0, Roles.Admin, "admin", "admin");
        StudentManagerSession.Users.add(firstAdminUser);

        StudentManagerUI ui = new StudentManagerUI();
    }
}