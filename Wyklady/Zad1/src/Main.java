import Utilities.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		Utils.print("Zad 1:");
		Filary.printAll();
		Utils.print("Zad 2:");
		Filary.printRnd();
	}
	
	private static class Filary
	{
		public static String[] filaryOOP = {"Abstrakcja", "Enkapsulacja", "Dziedziczenie", "Polimorfizm"};
		
		public static void printAll()
		{
			Arrays.sort(filaryOOP);
			for (int i = 0; i < filaryOOP.length; i++)
			{
				Utils.print(i +" "+filaryOOP[i]);
			}
		}
		
		public static void printRnd()
		{
			List<Integer> used = new ArrayList<>();
			Random rnd = new Random();
			
			while (used.size() <= 3)
			{
				Integer rndNum = rnd.nextInt(4);
				if (!used.contains(rndNum))
				{
					Utils.print(rndNum +" "+filaryOOP[rndNum]);
					used.add(rndNum);
				}
			}
		}
	}
}