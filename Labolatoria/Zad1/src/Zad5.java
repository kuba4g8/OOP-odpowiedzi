import Utilities.Utils;

public class Zad5
{
	public static class IDGenenrator
	{
		public static Integer total = 0;
		
		public static int nextID()
		{
			total++;
			Utils.print(total.toString());
			return total;
		}
	}
}
