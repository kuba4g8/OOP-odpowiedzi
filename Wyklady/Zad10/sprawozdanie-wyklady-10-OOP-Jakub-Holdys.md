# Zadanie nr 10 (referencje do obiektów) 

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

1. Co to jest sterta i stos?
2. Czym różnią się typy prymitywne od typów referencyjnych (złożonych)?
3. Co charakteryzuje obiekty niemutowalne?
4. Czy i dlaczego, obiekty poniższej klasy są, lub nie są, niemutowalne?
```java
    public class ZagadkaMutowalne {
      public final int x;
      public ZagadkaMutowalne(int x) {
        this.x = x;
      }
    }
```
5. Czy i dlaczego, obiekty poniższej klasy są, lub nie są, niemutowalne?

```java
    public class ZagadkaMutowalne2 {
      private String komunikat;
      public void setKomunikat(String komunikat) {
        this.komunikat = komunikat;
      }
      public String getKomunikat() {
        return komunikat;
      }
    }
```
6. Czy i dlaczego, obiekty poniższej klasy są, lub nie są, niemutowalne?

```java
    public class ZagadkaMutowalne3 {
      private final String[] slowa;
      public ZagadkaMutowalne3(String[] slowa) {
        this.slowa = slowa;
      }
    }
```
---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja Zadań
1. Stos vs Sterta
   - Stos sluzy jako pamiec podreczna programu. Przechowywane sa na nim zmienne typow prymitywnych (int, float, double itd.) oraz ma duzo mniej pamieci do wykorzystania niz sterta.
   - Sterta to miejsce gdzie sa tworzone i przechowywane obiekty typow zlozonych.
2. Typy prymitywne vs zlozone
   - Typy prymitywne to np: int, float, double. Nie obiektowe typy danych tworzone z malej litery w javie. Sa tworzone na stosie i maja konkretne wartosci zawsze. Tworzy sie je bez slowka new.
   - Typy Referencyjne (zlozone) to takie ktore sa tworzone za pomoca slowka new. Zazwyczaj sa to obiekty ktore mozna bardzo latwo samemu napisac. Sa tworzone na stercie, a mozna przypisac do nich wartosc null.
3. Obiekty niemutowalne to takie obiekty ktorych wartosci nie moge sie zmienic po ich utworzeniu. Nie posiadaja setterow a pola klasy powinny byc prywatne i finalne. Klasy bez mozliwosci dziedziczenia.
4. Obiekt klasy ZagadkaMutowalna `jest` niemutowalna poniewaz zmienna x zawiera slowka final, co oznacza ze po ustawieniu w konstruktorze tej wartosci ona nigdy wiecej sie nie zmienii.
5. Obiekt klasy ZagadkaMutowalne2 `nie sa` niemutowalne, bo klasa zawiera setter i mozna w locie zmieniac wartosc zmiennej komunikat
6. Obiekt klasy ZagadkaMutowalna3 `nie sa` niemutowalne, bo my przekazujemy referencje do tablicy w konstruktorze i w kodzie mozna zmienic tablice slowa[]. Aby ta klasa byla niemutowalna to trzeba by zrobic defensive copy