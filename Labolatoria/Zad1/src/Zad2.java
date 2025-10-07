import Utilities.Utils;

public class Zad2
{
	public static class KoloUtils
	{
		public static final double PI = 3.14159;
		
		private static boolean checkPromien(double promien)
		{
			return true ? promien >= 0 : false;
		}
		
		public static int porownajPole(double r1, double r2)
		{
			if (!checkPromien(r1) || !checkPromien(r2))
				throw new IllegalArgumentException("promien za maly:(");
			
			var pole1 = pole(r1);
			var pole2 = pole(r2);
			
			if (pole1 > pole2)
			{
				Utils.print("Pole1 o r: " + r1 + " jest wieksze niz Pole2 o r: " + r2);
				return 1;
			}
			else if (pole1 < pole2)
			{
				Utils.print("Pole1 o r: " + r1 + " jest mniejsze niz Pole2 o r: " + r2);
				return -1;
			}
			else
			{
				Utils.print("Pola sa rowne!");
				return 0;
			}
		}
		
		public static double obwod(double promien)
		{
			if (!checkPromien(promien))
				throw new IllegalArgumentException("Pormien za mały:(");
			
			return 2 * PI * promien;
		}
		
		public static double pole(double promien)
		{
			if (!checkPromien(promien))
				throw new IllegalArgumentException("Pormien za mały:(");
			
			return PI * promien * promien;
		}
	}
}
