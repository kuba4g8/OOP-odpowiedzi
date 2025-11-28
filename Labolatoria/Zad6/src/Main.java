import Zad1.*;
import Zad3.Figura;
import Zad3.Kolo;
import Zad3.Prostokat;
import Zad3.TrojkatRownoboczny;
import Zad4.Blik;
import Zad4.KartaKredytowa;
import Zad4.Przelew;
import Zad4.Sklep;
import Zad5.RaportCSV;
import Zad5.RaportJSON;

void main()
{
    // ZAD 1 i 2
    ArrayList<Raport> raporty = new ArrayList<>();
    raporty.add(new Raport("raport1"));
    raporty.add(new Raport("raport2"));
    raporty.add(new Raport("raport3"));

    ArrayList<Faktura> faktury = new ArrayList<>();
    faktury.add(new Faktura(123.0));
    faktury.add(new Faktura(125.0));
    faktury.add(new Faktura(127.0));

    for (Raport r : raporty)
    {
        r.drukuj();
        r.eksportuj();
        r.zapiszDo("C:/");
    }

    for (Faktura f : faktury)
    {
        f.drukuj();
        f.eksportuj();
        f.zapiszDo("C:/");
    }
    // ZAD 1 i 2

    // ZAD 3
    ArrayList<Figura> figury = new ArrayList<>();

    figury.add(new Kolo(2.0));
    figury.add(new Prostokat(3.0, 2.0));
    figury.add(new TrojkatRownoboczny(2.0));

    Double polaSuma = 0.0;

    for (Figura f : figury)
    {
        System.out.println(f.pole());
        polaSuma += f.pole();
    }
    System.out.println(polaSuma.toString());
    // ZAD 3

    // ZAD 4
    Sklep sklep = new Sklep(new KartaKredytowa());
    System.out.println(sklep.zaplac(100.0));

    sklep.platnosc = new Blik();
    System.out.println(sklep.zaplac(123.0));

    sklep.platnosc = new Przelew();
    System.out.println(sklep.zaplac(123.0));
    // ZAD 4

    // ZAD 5
    RaportCSV raport = new RaportCSV();
    raport.generuj();

    RaportJSON raportJSON = new RaportJSON();
    raportJSON.generuj();
    // ZAD 5
}
