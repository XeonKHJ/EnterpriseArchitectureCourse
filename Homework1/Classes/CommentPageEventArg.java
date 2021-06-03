package Classes;


public class CommentPageEventArg {
    private String _comment;
    private int _score;

    public CommentPageEventArg(String comment, int score)
    {
        _score = score;
        _comment = comment;
    }

    public String getComment()
    {
        return _comment;
    }

    public int getScore()
    {
        return _score;
    }
}
