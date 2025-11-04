import Zad1.Osoba;
import Zad1.Pracownik;

void main()
{
    System.out.println("Zad 1");

    // zad 1
    Osoba osoba = new Osoba();
    Pracownik prac = new Pracownik();
    osoba.imie = "Antek";
    osoba.nazwisko = "Jakiśnapewno";

    prac.imie = "Zbigniew";
    prac.nazwisko = "Bezpomyslowy";
    prac.numerIndetyfikatora = 1234;

    System.out.println(osoba.toString());
    System.out.println(prac.toString());
    // zad 1
    System.out.println("Zad 2\n");

    // zad 2
    Osoba os2 = new Osoba();
    Pracownik pracownik = new Pracownik();
    os2.imie = "osoba1";
    os2.nazwisko = "nazwiskowo";
    pracownik.imie = "pracownik1";
    pracownik.nazwisko = "sikorska";
    System.out.println(Osoba.wejdzDoBudynku(os2));
    System.out.println(Osoba.wejdzDoBudynku(pracownik));
    // zad 2
    System.out.println("Zad 3\n");

    // zad 3
    Osoba osobaNiePracownik = new Osoba();
    osobaNiePracownik.imie = "Jan";
    osobaNiePracownik.nazwisko = "Kowalski";
    //osobaNiePracownik.numerIndetyfikatora = 1234; // tutaj jest blad kompilatora bo osoba nie ma tego pola

    //Pracownik toJuzPracownik = (Pracownik) osobaNiePracownik; // w tym miejscu wywala blad poniewaz rzutowanie w javie nie zmienia obiektu tylko mowi kompilatorowi zeby traktowal referencje jako inny typ
    //toJuzPracownik.numerIndetyfikatora = 1234; // tu juz spoczi bo jest to pracownik nie osoba

    if (osobaNiePracownik instanceof Pracownik)
    {
        Pracownik pracownikNapewno = (Pracownik) osobaNiePracownik;
    }

    // zad 3
    System.out.println("Zad 4\n");
    // zad 4
    Osoba pracownikZad4 = new Pracownik();
    pracownikZad4.imie = "Jan";
    pracownikZad4.nazwisko = "Kowalski";
    System.out.println(pracownikZad4.toString()); // pomimo ze zmienna jest typu osoba tworzy sie obiekt Pracownik ktora ma wartosci wlasnie tego pracownika
    // jako ze int w javie przypisuje sie automatycznie do defaultowej wartosci 0
    // to string pokazal z klasy pracownik nie klasy osoba
}
