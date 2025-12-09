# Zadanie nr 8 (testowanie kodu) 

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

Napisz testy oraz metodę, która odpowiada na pytanie, czy podana liczba jest parzysta.

Napisz testy oraz metodę, która przyjmuje liczbę całkowitą jako argument i zwraca:

-1, jeżeli podana liczba jest ujemna,
0, jeżeli podana liczba jest równa 0,
1, jeżeli podana liczba jest dodatnia.

Napisz testy oraz metodę, która przyjmuje jako argument tablicę liczb oraz liczbę i zwraca indeks w tej tablicy, pod którym znajduje się liczba podana jako drugi argument.
Jeżeli podanej liczby nie ma w tablicy, metoda powinna zwrócić liczbę -1.

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja Zadań

# Zad 1: Metody testowania kodu
`NumUtils`:

```java
package NumUtils;

public class NumUtils
{
    public Boolean czyParzysta(int liczba)
    {
        if (liczba % 2 == 0)
            return true;
        else
            return false;
    }

    public int czyDodatnia(int liczba)
    {
        if (liczba < 0)
            return -1;
        else if (liczba == 0)
            return 0;
        else
            return 1;
    }

    public int sprawdzCzyJestNaTablicy(int[] tablica, int liczba)
    {
        for (int i = 0; i < tablica.length; i++)
        {
            if (tablica[i] == liczba)
            {
                return i;
            }
        }
        return -1;
    }
}
```

Klasa testujaca `NumUtilsTest`:

```java
package NumUtils;

public class NumUtilsTests {
    public static void czyParzysta_liczbaParzysta_zwrociTrue() {
        NumUtils utils = new NumUtils();
        int liczba = 4;
        boolean wynik = utils.czyParzysta(liczba);
        if (!wynik) {
            System.out.println("Blad! Liczba 4 jest parzysta, oczekiwano true.");
        }
    }

    public static void czyParzysta_liczbaNieparzysta_zwrociFalse() {
        NumUtils utils = new NumUtils();
        int liczba = 7;
        boolean wynik = utils.czyParzysta(liczba);
        if (wynik) {
            System.out.println("Blad! Liczba 7 jest nieparzysta, oczekiwano false.");
        }
    }

    public static void czyDodatnia_liczbaDodatnia_zwrociJeden() {
        NumUtils utils = new NumUtils();
        int liczba = 10;
        int wynik = utils.czyDodatnia(liczba);
        assertEquals(1, wynik);
    }

    public static void czyDodatnia_liczbaUjemna_zwrociMinusJeden() {
        NumUtils utils = new NumUtils();
        int liczba = -5;
        int wynik = utils.czyDodatnia(liczba);
        assertEquals(-1, wynik);
    }

    public static void czyDodatnia_liczbaZero_zwrociZero() {
        NumUtils utils = new NumUtils();
        int liczba = 0;
        int wynik = utils.czyDodatnia(liczba);
        assertEquals(0, wynik);
    }

    public static void sprawdzCzyJestNaTablicy_elementIstnieje_zwrociIndeks() {
        NumUtils utils = new NumUtils();
        int[] tablica = {10, 20, 30, 40};
        int szukana = 30;
        int indeks = utils.sprawdzCzyJestNaTablicy(tablica, szukana);
        assertEquals(2, indeks);
    }

    public static void sprawdzCzyJestNaTablicy_brakElementu_zwrociMinusJeden() {
        NumUtils utils = new NumUtils();
        int[] tablica = {1, 2, 3};
        int szukana = 99;
        int indeks = utils.sprawdzCzyJestNaTablicy(tablica, szukana);
        if (indeks != -1) {
            System.out.println("Blad! Elementu 99 nie ma w tablicy, oczekiwano -1, otrzymano: " + indeks);
        }
    }

    public static void sprawdzCzyJestNaTablicy_pustaTablica_zwrociMinusJeden() {
        NumUtils utils = new NumUtils();
        int[] tablica = {};
        int szukana = 5;
        int indeks = utils.sprawdzCzyJestNaTablicy(tablica, szukana);
        if (indeks != -1) {
            System.out.println("Blad! Pusta tablica nie powinna nic zawierac, oczekiwano -1.");
        }
    }

    public static void sprawdzCzyJestNaTablicy_elementNaPoczatku_zwrociZero() {
        NumUtils utils = new NumUtils();
        int[] tablica = {100, 200, 300};
        int szukana = 100;
        int indeks = utils.sprawdzCzyJestNaTablicy(tablica, szukana);
        assertEquals(0, indeks);
    }

    public static void sprawdzCzyJestNaTablicy_elementNaKoncu_zwrociOstatniIndeks() {
        NumUtils utils = new NumUtils();
        int[] tablica = {100, 200, 300};
        int szukana = 300;
        int indeks = utils.sprawdzCzyJestNaTablicy(tablica, szukana);
        assertEquals(2, indeks);
    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            System.out.println("Spodziewano sie liczby " + expected + ", ale otrzymano: " + actual);
        }
    }
}
```

Klasa `main`:

```java
import static NumUtils.NumUtilsTests.*;

public static void main(String[] args) {
    // Testy dla czyParzysta
    czyParzysta_liczbaParzysta_zwrociTrue();
    czyParzysta_liczbaNieparzysta_zwrociFalse();

    // Testy dla czyDodatnia
    czyDodatnia_liczbaDodatnia_zwrociJeden();
    czyDodatnia_liczbaUjemna_zwrociMinusJeden();
    czyDodatnia_liczbaZero_zwrociZero();

    // Testy dla sprawdzCzyJestNaTablicy
    sprawdzCzyJestNaTablicy_elementIstnieje_zwrociIndeks();
    sprawdzCzyJestNaTablicy_brakElementu_zwrociMinusJeden();
    sprawdzCzyJestNaTablicy_pustaTablica_zwrociMinusJeden();
    sprawdzCzyJestNaTablicy_elementNaPoczatku_zwrociZero();
    sprawdzCzyJestNaTablicy_elementNaKoncu_zwrociOstatniIndeks();
}
```
