package Zad1;

public class Pracownik extends Osoba
{
    public int numerIndetyfikatora;


    @Override
    public String toString() {
        return "Pracownik " + imie + " " + nazwisko + ", indetyfikator: " + numerIndetyfikatora;
    }
}
