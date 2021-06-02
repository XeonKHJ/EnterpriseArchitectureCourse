package Classes;


import Enums.*;

public class AuthorityMatrix {
    public static boolean IsOperationLegal(Roles role, Operations op)
    {
        boolean result = false;
        if(role == Roles.Admin)
        {
            result = true;
        }
        else if(role == Roles.Student)
        {
            if(op == Operations.SubmitHomework)
            {
                result = true;
            }
        }
        else if(role == Roles.Teacher)
        {
            if(op == Operations.CommentHomwork || op ==Operations.ScoreHomework)
            {
                result = true;
            }
        }

        return result;
    }
}
