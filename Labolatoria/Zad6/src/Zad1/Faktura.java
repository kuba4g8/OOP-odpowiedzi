package Zad1;

import Interfejsy.Drukowalne;
import Interfejsy.Eksportowalne;

public class Faktura implements Drukowalne, Eksportowalne
{
    Double kwota;

    public Faktura(Double kwota)
    {
        this.kwota = kwota;
    }

    @Override
    public void drukuj()
    {
        System.out.println("Kwota: " + kwota);
    }

    @Override
    public String eksportuj() {
        return kwota.toString();
    }
}
