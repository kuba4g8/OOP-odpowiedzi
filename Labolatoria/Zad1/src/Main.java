import Utilities.Utils;

public class Main
{
	public static void main(String[] args)
	{
		// zadanie 1
		Zad1.DemoMetod.info();
		Utils.print(Zad1.DemoMetod.imie("Kuba"));
		
		//zadania 2
		try
		{
			Zad2.KoloUtils.obwod(0.5);
			Zad2.KoloUtils.obwod(-0.5);
			
			Zad2.KoloUtils.pole(0.5);
			Zad2.KoloUtils.pole(-0.5);
			
			Zad2.KoloUtils.porownajPole(0, 1);
			Zad2.KoloUtils.porownajPole(1, 1);
			Zad2.KoloUtils.porownajPole(5, 1);
			Zad2.KoloUtils.porownajPole(0, 0);
			Zad2.KoloUtils.obwod(0);
			Zad2.KoloUtils.pole(0);
		}
		catch (IllegalArgumentException ex)
		{
			Utils.print(ex.toString());
		}
		
		//zadanie 3
		try
		{
			Utils.print(Zad3.MathUtils.max(10, 5).toString());
			Utils.print(Zad3.MathUtils.min(10, 5).toString());
			Utils.print(Zad3.MathUtils.avg(10, 5).toString());
		}
		catch (IllegalArgumentException ex)
		{
			Utils.print(ex.toString());
		}
		
		//zadanie 4
		try
		{
			Utils.print(Zad4.CalcUtils.add(5, 10).toString());
			Utils.print(Zad4.CalcUtils.sub(5, 10).toString());
			Utils.print(Zad4.CalcUtils.div(5, 10).toString());
			Utils.print(Zad4.CalcUtils.pow(8, 3).toString());
			Utils.print(Zad4.CalcUtils.div(5, 0).toString());
		}
		catch (IllegalArgumentException ex)
		{
			Utils.print(ex.toString());
		}
		
		//zadanie 5
		for (int i = 0; i < 20; i++)
		{
			Zad5.IDGenenrator.nextID();
		}
	}
}