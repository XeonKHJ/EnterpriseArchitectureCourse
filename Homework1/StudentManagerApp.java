import java.util.ArrayList;
import java.util.List;

class StudentManagerApp
{
    public static List<User> Users = new ArrayList<User>();
    public static void main(String[] args)
    {
        // Initiate first user
        User firstAdminUser = new User(0, Roles.Admin, "admin", "admin");
        users.add(firstAdminUser);

        StudentManagerUI ui = new StudentManagerUI();
    }
}