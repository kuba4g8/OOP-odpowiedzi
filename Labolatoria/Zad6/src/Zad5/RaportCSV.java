package Zad5;

import java.util.ArrayList;

public class RaportCSV extends RaportGenerator
{
    String tresc;
    private ArrayList<String[]> dane = new ArrayList<>();

    @Override
    void przygotujDane()
    {
        dane.clear();
        dane.add(new String[]{"id", "nazwa", "wartosc"});
        dane.add(new String[]{"1", "A", "10"});
        dane.add(new String[]{"2", "B", "20"});
    }

    @Override
    String zbudujTresc()
    {
        String wynik = "";
        for (int i = 0; i < dane.size(); i++)
        {
            String[] tempDane = dane.get(i);
            for (int j = 0; j < tempDane.length; j++)
            {
                wynik += tempDane[j] + ", ";
            }
        }
        return wynik;
    }
}
