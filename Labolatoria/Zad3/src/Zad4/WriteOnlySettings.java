package Zad4;

public class WriteOnlySettings
{
    private Integer volume;
    private boolean darkMode;

    public void setVolume(Integer volume)
    {
        this.volume = volume;
    }

    public void setDarkMode(Boolean darkMode)
    {
        this.darkMode = darkMode;
    }

    public String describe()
    {
        return volume + " " + darkMode;
    }

}
