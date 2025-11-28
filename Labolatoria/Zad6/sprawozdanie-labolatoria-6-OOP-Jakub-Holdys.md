# Laboratorium 6 — Interfejsy i klasy abstrakcyjne (Java)

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

# Opis zadania

- Stworzyć interface Drukowalne
- Interface z metoda default
- Klasa abstrakcyjna Figura
- Strategia płatności (interfejs)
- Metoda szablonowa (Template Method)

---

# Technologie wykorzystane w zadaniu

- **Java**

---

# Realizacja Zadań
## Zad 1 i 2 kod:
Klasa `Faktura`:
```java
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
```
Klasa `Raport`
```java
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
```
Interface `Drukowalne`:
```java
package Interfejsy;

public interface Drukowalne
{
    public void drukuj();
}
```
Interface `Eksportowalne`:
```java
package Interfejsy;

public interface Eksportowalne
{
    public String eksportuj();
    public default void zapiszDo(String path)
    {
        System.out.println(path + ": " + eksportuj());
    }
}
```
## Zad 3:
Klasa abstrakcyjna `Figura`:
```java
package Zad3;

public abstract class Figura
{
    public abstract double pole();
}
```
Klasa `kolo` która rozszerza własności o klase Figura, `prosokat` oraz `TrojkatRownoboczny` polega mniej wiecej na tym samym. Gdzie różnica jest tylko taka że trzymają uknikalne wartości boków i innych parametrów w klasie:
```java
package Zad3;

public class Kolo extends Figura
{
    Double radius;

    public Kolo(Double radius)
    {
        this.radius = radius;
    }

    @Override
    public double pole()
    {
        return 3.14*radius*radius;
    }
}
```
```java
package Zad3;

public class Prostokat extends Figura
{
    Double a;
    Double b;

    public Prostokat(Double a, Double b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public double pole()
    {
        return a * b;
    }
}
```
```java
package Zad3;

public class TrojkatRownoboczny extends Figura
{
    Double a;

    public TrojkatRownoboczny(Double a)
    {
        this.a = a;
    }

    @Override
    public double pole()
    {
        return (a*a*Math.sqrt(3)) / 4;
    }
}
```
### Zadanie 4
Strategia płatności w sklepie.

Na początku był tylko interface `platnosc`:
```java
package Zad4;

public interface Platnosc
{
    Boolean zaplac(Double kwota);
}
```
Sklep Przyjmuje platnosc w konstruktorze czyli kazda klasa jaka implenetuje interface Platnosc mzoe wejsc w konstruktorze jako argument. (chyba):
```java
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
```
Teraz beda klasy które zarzadzaja platnoscia. `Blik`, `KartaKredytowa` oraz `Przelew`
```java
package Zad4;

public class Blik implements Platnosc
{
    @Override
    public Boolean zaplac(Double kwota)
    {
        return false;
    }
}
```
```java
package Zad4;

public class KartaKredytowa implements Platnosc
{

    @Override
    public Boolean zaplac(Double kwota) {
        return false;
    }
}
```
```java
package Zad4;

public class Przelew implements Platnosc
{
    @Override
    public Boolean zaplac(Double kwota)
    {
        return false;
    }
}
```
### Zadanie 5
Metody szablonowe

Została stworzona metoda abstrakcyjna `RaportGenerator`. 
```java
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
```
Stowrzyłem generator Raportu w formacie JSON klase
```java
package Zad5;

import java.util.ArrayList;

public class RaportJSON extends RaportGenerator
{
    String tresc;
    private ArrayList<String[]> dane = new ArrayList<>();

    @Override
    void przygotujDane()
    {
        dane.clear();
        dane.add(new String[]{"id", "nazwa", "wartosc"});
        dane.add(new String[]{"1", "A", "10"});
        dane.add(new String[]{"2", "B", "20"});
    }

    @Override
    public String zbudujTresc()
    {
        if (dane.size() < 2) {
            return "[]"; 
        }

        String[] naglowki = dane.get(0);
        StringBuilder wynik = new StringBuilder();

        wynik.append("[\n");

        for (int i = 1; i < dane.size(); i++)
        {
            String[] wierszDanych = dane.get(i);

            wynik.append("  {\n");

            for (int j = 0; j < wierszDanych.length; j++)
            {
                wynik.append("    \"").append(naglowki[j]).append("\": \"").append(wierszDanych[j]).append("\"");

                if (j < wierszDanych.length - 1) {
                    wynik.append(",\n");
                } else {
                    wynik.append("\n"); 
                }
            }

            wynik.append("  }");

            if (i < dane.size() - 1) {
                wynik.append(",\n");
            } else {
                wynik.append("\n");
            }
        }

        wynik.append("]");

        return wynik.toString();
    }
}
```
Program przygotowuje dane podczas wywolania z maina generujDane() a potem buduje tresc. Inaczej mowiac wykonuje sie to co w klasie abstrakcyjnej

Klasa `RaportCSV`. To samo tylko bardziej czytelne.
```java
package Zad5;

import java.util.ArrayList;

public class RaportCSV extends RaportGenerator
{
    String tresc;
    private ArrayList<String[]> dane = new ArrayList<>();

    @Override
    void przygotujDane()
    {
        dane.clear();
        dane.add(new String[]{"id", "nazwa", "wartosc"});
        dane.add(new String[]{"1", "A", "10"});
        dane.add(new String[]{"2", "B", "20"});
    }

    @Override
    String zbudujTresc()
    {
        String wynik = "";
        for (int i = 0; i < dane.size(); i++)
        {
            String[] tempDane = dane.get(i);
            for (int j = 0; j < tempDane.length; j++)
            {
                wynik += tempDane[j] + ", ";
            }
        }
        return wynik;
    }
}
```
