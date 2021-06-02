package Classes;

public class Homework {
    private String _title;
    private String _description;
    private String _comment = "";
    private String _content;
    public Homework(String title, String description)
    {
        _title = title;
        _description = description;
    } 

    public void setContent(String content)
    {
        if(content == null)
        {
            content = "";
        }
        _content = content;
    }

    public String getContent()
    {
        return _content;
    }

    public void setComment(String comment)
    {
        if(comment == null)
        {
            comment = "";
        }
        _comment = comment;
    }

    public String getComment()
    {
        return _comment;
    }

    public String getTitle()
    {
        return _title;
    }

    public String getDescription()
    {
        return _description;
    }
}
