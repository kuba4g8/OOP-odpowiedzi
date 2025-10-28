package Zad4;

public class Course
{
    private String title;
    private int ects;
    private String[] tags;

    public Course(String title, int ects, String[] tags)
    {
        this.title = title;
        this.ects = ects;
        this.tags = tags;
    }

    public Course(Course docelowyKurs)
    {
        this.title = docelowyKurs.title;
        this.ects = docelowyKurs.ects;
        this.tags = docelowyKurs.tags.clone();
    }

    public void addTag(String tag)
    {
        String[] newTags = new String[tags.length + 1];

        for (int i = 0; i < tags.length; i++)
        {
            newTags[i] = tags[i];
        }

        newTags[tags.length] = tag;

        this.tags = newTags;
    }

    public String describe()
    {
        String retStr = title + " " + ects + "\n";

        for (int i = 0; i < this.tags.length; i++)
        {
            retStr += tags[i] + "\n";
        }

        return retStr;
    }
}
