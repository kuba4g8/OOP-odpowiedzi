# Laboratorium 5 — Dziedziczenie i polimorfizm (Java), część nr 1

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

# Opis zadania

- Stworzyc klase `Osoba` oraz `Pracownik` ktora dziedziczy po klasie `Osoba`.

---

# Technologie wykorzystane w zadaniu

- **Java**

---

# Realizacja zadań

## Zadanie 1:
Utworzyc klase `Osoba` oraz `Pracownik`. Program jak najbardziej sie kompiluje uruchamia i ma dwie linie podobne do podanych w notatkach

```java
package Zad1;

public class Osoba
{
    public String imie;
    public String nazwisko;

    @Override
    public String toString() {
        return "imie: " + imie + " nazwisko: " + nazwisko;
    }
}
```
```java
package Zad1;

public class Pracownik extends Osoba
{
    public int numerIndetyfikatora;
}

```
Stowrzylem obiekt przypisalem wartosci w `main`:
```java
Osoba osoba = new Osoba();
Pracownik prac = new Pracownik();
osoba.imie = "Antek";
osoba.nazwisko = "Jakiśnapewno";

prac.imie = "Zbigniew";
prac.nazwisko = "Bezpomyslowy";
prac.numerIndetyfikatora = 1234;

System.out.println(osoba.toString());
System.out.println(prac.toString());
```
output:
```bash
imie: Antek nazwisko: Jakiśnapewno
Pracownik Zbigniew Bezpomyslowy, indetyfikator: 1234
```
W outpucie pojawil sie `identyfikator` poniewaz w nastepnych zadaniach dodalem toString do pracownika.
## Zadanie 2:
Dodano statyczna klase wejdzDoBundynku ktora przyjmuje argument `(Osoba osoba)`. Reszta klasy jest bez zmian
```java
public static String wejdzDoBudynku(Osoba osoba)
{
    return osoba.toString() + " weszla do budynku";
}
```
tutaj osoba.toString() zwraca imie i nazwisko.
`main`:
```java
Osoba os2 = new Osoba();
Pracownik pracownik = new Pracownik();
os2.imie = "osoba1";
os2.nazwisko = "nazwiskowo";
pracownik.imie = "pracownik1";
pracownik.nazwisko = "sikorska";
System.out.println(Osoba.wejdzDoBudynku(os2));
System.out.println(Osoba.wejdzDoBudynku(pracownik));
```
output:
```bash
imie: osoba1 nazwisko: nazwiskowo weszla do budynku
Pracownik pracownik1 sikorska, indetyfikator: 0 weszla do budynku
```

## Zadanie 3:
Rzutowanie klasy `Osoba` do `Pracownik` robiac to bezpiecznie i niebezpiecznie. 
```java 
instanceof
```
Pozwala zrobic wlasnie to bezpiecznie. `main`:
```java
Osoba osobaNiePracownik = new Osoba();
osobaNiePracownik.imie = "Jan";
osobaNiePracownik.nazwisko = "Kowalski";
//osobaNiePracownik.numerIndetyfikatora = 1234; // tutaj jest blad kompilatora bo osoba nie ma tego pola

//Pracownik toJuzPracownik = (Pracownik) osobaNiePracownik; // w tym miejscu wywala blad poniewaz rzutowanie w javie nie zmienia obiektu tylko mowi kompilatorowi zeby traktowal referencje jako inny typ
//toJuzPracownik.numerIndetyfikatora = 1234; // tu juz spoczi bo jest to pracownik nie osoba

if (osobaNiePracownik instanceof Pracownik)
{
    Pracownik pracownikNapewno = (Pracownik) osobaNiePracownik; // tutaj nie ma bledu
}
```
outputu nie ma tym razem. ale w komentarzu sa napisane mądrości moje.

## Zadanie 4:
Dodanie toString do Pracownika ktory dziedziczy po Osobie.
```java
package Zad1;

public class Pracownik extends Osoba
{
    public int numerIndetyfikatora;


    @Override
    public String toString() {
        return "Pracownik " + imie + " " + nazwisko + ", indetyfikator: " + numerIndetyfikatora;
    }
}
```
`main`:
```java
Osoba pracownikZad4 = new Pracownik();
pracownikZad4.imie = "Jan";
pracownikZad4.nazwisko = "Kowalski";
System.out.println(pracownikZad4.toString()); // pomimo ze zmienna jest typu osoba tworzy sie obiekt Pracownik ktora ma wartosci wlasnie tego pracownika
// jako ze int w javie przypisuje sie automatycznie do defaultowej wartosci 0
// to string pokazal z klasy pracownik nie klasy osoba
```

output:
```bash
Pracownik Jan Kowalski, indetyfikator: 0
```