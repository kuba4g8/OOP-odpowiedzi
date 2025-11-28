package Zad5;

import java.util.ArrayList;

public class RaportJSON extends RaportGenerator
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
    public String zbudujTresc()
    {
        // Sprawdzanie, czy dane są puste lub nie mają nagłówków
        if (dane.size() < 2) {
            return "[]"; // Zwróć pustą tablicę JSON
        }

        String[] naglowki = dane.get(0);
        StringBuilder wynik = new StringBuilder();

        wynik.append("[\n");

        for (int i = 1; i < dane.size(); i++)
        {
            String[] wierszDanych = dane.get(i);

            wynik.append("  {\n");

            for (int j = 0; j < wierszDanych.length; j++)
            {
                wynik.append("    \"").append(naglowki[j]).append("\": \"").append(wierszDanych[j]).append("\"");

                if (j < wierszDanych.length - 1) {
                    wynik.append(",\n");
                } else {
                    wynik.append("\n"); // Koniec obiektu
                }
            }

            wynik.append("  }");

            if (i < dane.size() - 1) {
                wynik.append(",\n");
            } else {
                wynik.append("\n"); // Koniec tablicy
            }
        }

        wynik.append("]");

        return wynik.toString();
    }
}
