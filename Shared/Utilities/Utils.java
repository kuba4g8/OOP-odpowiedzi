package Utilities;

public class Utils
{
	// zaleznie od argumentu stawia enter po napisaniu czegos w konsoli
	public static void print(String text)
	{
		System.out.println(text);
	}
	public static void print(String text, boolean dontPressEnter)
	{
		System.out.print(text);
	}
	
	public static void clearConsole()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
