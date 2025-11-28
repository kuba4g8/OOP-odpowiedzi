package Interfejsy;

public interface Eksportowalne
{
    public String eksportuj();
    public default void zapiszDo(String path)
    {
        System.out.println(path + ": " + eksportuj());
    }
}
