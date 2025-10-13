public class Zad4
{
	static class CalcUtils
	{
		public static Integer add(int a, int b)
		{
			return a + b;
		}
		
		static Integer sub(int a, int b)
		{
			return  a - b;
		}
		
		public static Float mul(Integer a, Integer b)
		{
			return (float) (a * b);
		}
		
		static Float div(int a, int b)
		{
			if (b == 0)
				throw new IllegalArgumentException("nie dziel przez zero cholero");
			
			return (float) (a / b);
		}
		
		static Double pow(int a, int n)
		{
			double suma = 1;
			
			for (int i = 1; i < n; i++)
			{
				suma *= i;
			}
			return suma;
		}
	}
}
