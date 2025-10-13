public class Zad3
{
	static class MathUtils
	{
		static Integer max(int a, int b)
		{
			return a > b ? a : b;
		}
		
		static Integer min(int a, int b)
		{
			return a > b ? b : a;
		}
		
		static Float avg(int a, int b)
		{
			return (float) ((a + b) / 2);
		}
	}
}
