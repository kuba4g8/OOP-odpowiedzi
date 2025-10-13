public class Osoba
{
    public Integer wiek;
    public String imie;
    public String nazwisko;

    public void ustawWiek(Integer wiek)
    {
        this.wiek = wiek;
    }

    public void ustawImie(String imie)
    {
        this.imie = imie;
    }

    public void ustawNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString()
    {
        return imie + " " + nazwisko + " " + wiek;
    }
}