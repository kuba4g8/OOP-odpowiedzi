package TextHelp;

public class TextStats {
    public static Integer countWords(String text)
    {
        return text.split(" ").length;
    }
}
