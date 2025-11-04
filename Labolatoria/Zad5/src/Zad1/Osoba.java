package Zad1;

public class Osoba
{
    public String imie;
    public String nazwisko;

    public static String wejdzDoBudynku(Osoba osoba)
    {
        return osoba.toString() + " weszla do budynku";
    }
    @Override
    public String toString() {
        return "imie: " + imie + " nazwisko: " + nazwisko;
    }
}

