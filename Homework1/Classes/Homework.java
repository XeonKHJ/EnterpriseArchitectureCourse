package Classes;

public class Homework {
    private String _title;
    private String _description;
    public Homework(String title, String description)
    {
        _title = title;
        _description = description;
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
