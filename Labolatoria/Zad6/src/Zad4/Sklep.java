package Zad4;

public class Sklep implements Platnosc
{
    public Platnosc platnosc;

    public Sklep(Platnosc platnosc)
    {
        this.platnosc = platnosc;
    }

    public void kup(Double kwota)
    {
        platnosc.zaplac(kwota);
    }

    @Override
    public Boolean zaplac(Double kwota)
    {
        return true;
    }
}
