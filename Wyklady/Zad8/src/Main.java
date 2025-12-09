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