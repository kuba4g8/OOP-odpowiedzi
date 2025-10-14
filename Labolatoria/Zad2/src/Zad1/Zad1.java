package Zad1;

public class Zad1 {
    public static class Osoba
    {
        private Integer wiek;
        private String imie;
        private String nazwisko;

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

        public String opisOsoby()
        {
            return imie + " " + nazwisko + " " + wiek;
        }
    }

}
