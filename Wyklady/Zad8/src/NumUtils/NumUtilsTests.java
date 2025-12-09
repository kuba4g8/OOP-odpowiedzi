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