package Zad5;

public abstract class RaportGenerator
{
    public final void generuj()
    {
        przygotujDane();
        String dane = zbudujTresc();
        System.out.println(dane);
    }
    abstract void przygotujDane();
    abstract String zbudujTresc();
}
