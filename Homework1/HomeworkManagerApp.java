import Classes.Homework;
import Classes.HomeworkManagerSession;
import Classes.User;
import Enums.Roles;

class HomeworkManagerApp
{
   
    public static void main(String[] args)
    {
        // Initiate first user
        User firstAdminUser = new User(0, Roles.Admin, "admin", "admin");
        User firstTeacherUser = new User(1, Roles.Teacher, "teacher1", "teacher");
        User secondTeacherUser = new User(1, Roles.Teacher, "teacher2", "teacher");
        User firstStudentUser = new User(2, Roles.Student, "student1", "student");
        User secondStudentUser = new User(2, Roles.Student, "student1", "student");
        HomeworkManagerSession.Users.add(firstAdminUser);
        HomeworkManagerSession.Users.add(firstTeacherUser);
        HomeworkManagerSession.Users.add(firstStudentUser);
        HomeworkManagerSession.Users.add(secondStudentUser);
        HomeworkManagerSession.Users.add(secondTeacherUser);
        HomeworkManagerSession.Homework = new Homework("企业架构作业", "1、完整的代码实现\n2、页面操作的显示\n3、对RBAC权限控制机制进行分析");
        HomeworkManagerUI ui = new HomeworkManagerUI();
    }
}