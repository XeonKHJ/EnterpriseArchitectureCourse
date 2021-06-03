package Classes;

public class HomeworkScoreInfo {
    private String _studentName;
    private int _score;
    public HomeworkScoreInfo(String studentName, int score)
    {
        _studentName = studentName;
        _score = score;
    }

    public String getStudentName()
    {
        return _studentName;
    }

    public int getScore()
    {
        return _score;
    }
    
}
