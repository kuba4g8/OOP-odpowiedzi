package Zad1;

import Interfejsy.Drukowalne;
import Interfejsy.Eksportowalne;

public class Raport implements Drukowalne, Eksportowalne
{
    private String tresc;

    public Raport(String tresc)
    {
        this.tresc = tresc;
    }

    public void setTresc(String tresc)
    {
        this.tresc = tresc;
    }

    @Override
    public void drukuj()
    {
        System.out.println("Tresc: " + tresc);
    }

    @Override
    public String eksportuj() {
        return tresc;
    }
}
