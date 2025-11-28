# Zadanie nr 6 (dziedziczenie i polimorfizm)

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

- Wyjaśnij pojęcia: klasa bazowa (nadrzędna), klasa pochodna (podrzędna), słowo kluczowe extends. Podaj własny przykład zdania typu „X jest Y”, które ilustruje relację dziedziczenia
- Co zostanie wypisane na ekranie?
- Czy poniższy kod skompiluje się? Jeśli tak, co wypisze program? Zwróć uwagę na polimorfizm (upcasting).
- Nadpisywanie metod a super: jaki będzie wynik uruchomienia?
- Czy poniższy kod się skompiluje? Jeśli nie – dlaczego? Jak naprawić?
- Dostęp do pól prywatnych a dziedziczenie: jaki będzie wynik kompilacji?
- final w dziedziczeniu: oceń poprawność i wyjaśnij.
- Klasy i metody abstrakcyjne: co jest nie tak? Jak to naprawić?
- Rzutowanie (downcasting) i instanceof: co zostanie wypisane, a czy dojdzie do wyjątku?

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja zadań
1) Wyjaśnienie pojęć i przykład

    - Klasa bazowa (nadrzędna): To klasa, z której inne klasy pobierają (dziedziczą) pola i metody. Jest "rodzicem" w hierarchii.

    - Klasa pochodna (podrzędna): To klasa, która dziedziczy po klasie bazowej. Może korzystać z jej publicznych/chronionych elementów oraz dodawać własne lub zmieniać działanie odziedziczonych.

    - Słowo kluczowe `extends`: Używamy go w deklaracji klasy, żeby wskazać, po której klasie ona dziedziczy.

    - Przykład relacji: "Osoba jest Pracownikiem". W tym przypadku Osoba to klasa bazowa, a Pracownik to klasa pochodna. Osoba ma imie, nazwisko, wiek. A pracownik ma jeszcze numerIdentyfikatora
2) Na ekranie zostanie wypisane: `Osoba Anna Nowak`
3) Kod skompiluje się poprawnie i wypisze: `Witaj, Jan Kowalski`
4) Program wypisze `Osoba(Ola Lis), id=101`
5) Najpierw Baza, potem pochodna
```terminaloutput
konstruktor Baza
konstruktor Pochodna
```
6) Trzeba dodac super(0) do konstruktora
```java
Pochodna() { /* domyślnie wołane jest super() */
    super(0);
} 
```
7) Program sie nie skompiluję poniewaz klasa dziecko nie ma dostepu do wlasciwosci klasy rodzica. Jezeli `private` zmieni sie na `protected` to zadziala.
8) Zakomentowanych linii nie można odkomentować, kod się nie skompiluje.

   `// public void f() {}:` Metoda f w klasie Baza jest oznaczona jako final. Metod finalnych nie można nadpisywać w klasach pochodnych.

   `// class X extends NieDoDziedziczenia {}:` Klasa NieDoDziedziczenia jest final. Po klasach finalnych nie można dziedziczyć.
9) Klasa bazowa `Zwierze` ma klase ktorej klasa dziecko nie posaida, czyli `daj_glos()`. Wystarczy ja dodac, dodac jakas implementacje i wszysciutko bedzie dzialac
10) Oznaczenia lini A B i C:
```java
class Osoba {
    public String toString(){
        return "Osoba";
    }
}

class Pracownik extends Osoba {
    public String toString(){
        return "Pracownik";
    }
}

public class Main {
    public static void main(String[] args) {
        Osoba a = new Pracownik();
        System.out.println(a); // Linia A

        if (a instanceof Pracownik) {
            Pracownik p = (Pracownik) a;
            System.out.println(p); // Linia B
        }

        Osoba b = new Osoba();
        Pracownik q = (Pracownik) b; // Linia C
        System.out.println(q);
    }
}
```
Mozna rzutowac obiekt tylko w góre z Osoby Na Pracownika tylko wtedy gdy ten obiekt pod spodem został stworzony jako `new Pracownik()` a nie `new Osoba()`