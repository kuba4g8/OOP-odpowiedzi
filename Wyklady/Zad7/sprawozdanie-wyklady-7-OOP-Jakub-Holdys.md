# Zadanie nr 7 (interfejsy i klasy abstrakcyjne)

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

- Kiedy użyć interfejsu, a kiedy klasy abstrakcyjnej? Podaj po 2–3 typowe przypadki i krótkie uzasadnienie. Wymień co najmniej dwie różnice semantyczne i dwie różnice techniczne między interface i abstract class.
- Jakie są domyślne modyfikatory dla pól i metod w interfejsie?
- Metody default, static i private w interfejsach: różnice i zastosowanie.
- Konflikt metod domyślnych w wielu interfejsach – jak rozwiązać?
- Czy można tworzyć instancje klas abstrakcyjnych? Jak mimo to można używać typu abstrakcyjnego w kodzie klienta?
- Czy klasa może dziedziczyć po wielu klasach w Javie? A czy może implementować wiele interfejsów? Wyjaśnij pojęcie „wielodziedziczenia typu”.
- Słowo kluczowe final a abstrakcja i interfejsy.
- Słowa kluczowe abstract i private/static.

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja zadań

1) **Interfejs vs Klasa Abstrakcyjna**

    * **Kiedy Interfejs:** Gdy chcemy zdefiniować kontrakt "co obiekt potrafi" (np. `Runnable`, `Comparable`) bez narzucania, czym jest.
    * **Kiedy Klasa Abstrakcyjna:** Gdy tworzymy szkielet dla powiązanych klas (relacja "jest czymś", np. `Pies` jest `Zwierzęciem`) i chcemy współdzielić kod (pola, metody nieabstrakcyjne).
    * **Różnice semantyczne:** Interfejs opisuje zachowanie (behavior), klasa abstrakcyjna opisuje tożsamość i wspólne cechy.
    * **Różnice techniczne:** Klasa abstrakcyjna może mieć stan (zwykłe pola instancyjne) i konstruktory, interfejs ma tylko stałe (`public static final`). Klasę dziedziczymy jedną, interfejsów implementujemy wiele.

2) **Domyślne modyfikatory**

    * „Pola w interfejsie są domyślnie `public`, `static` i `final`.” (Są to stałe).
    * „Metody bez ciała w interfejsie są domyślnie `public` i `abstract`.”
    * W interfejsie można mieć metody z ciałem: `default` , `private` i `static`

3) **Metody default, static i private**

    * **Różnica default vs static:** Metoda `default` należy do obiektu i można ją nadpisać w klasie implementującej. Metoda `static` należy do interfejsu (jak funkcja pomocnicza) i wywołuje się ją przez nazwę interfejsu, nie jest dziedziczona przez obiekty.
    * **Metody private:** Wprowadzone, aby unikać duplikacji kodu wewnątrz interfejsu. Jeśli dwie metody `default` robią coś podobnego, wspólną logikę wyrzucamy do metody `private`, która nie jest widoczna na zewnątrz.

4) **Konflikt metod domyślnych**
   Kompilator zgłasza błąd, bo nie wie, którą wersję metody `f()` (z A czy z B) wybrać. Trzeba nadpisać metodę w klasie C i ręcznie wskazać, co ma się stać (np. wywołać wersję z A).

```java
interface A { default void f() { System.out.println("A.f"); } }
interface B { default void f() { System.out.println("B.f"); } }

class C implements A, B {
    @Override
    public void f() {
        A.super.f();
    }
}

void main()
{
    C c = new C();
    c.f();
    // maaaasakra....
}
```
5) **Instancje klas abstrakcyjnych**

* **Czy można tworzyć instancje:** Nie, bezpośrednie utworzenie obiektu klasy abstrakcyjnej (np. `new KlasaAbstrakcyjna()`) zakończy się błędem kompilacji.
* **Użycie w kodzie:** Typu abstrakcyjnego używamy jako typu referencji (zmiennej). Dzięki polimorfizmowi przypisujemy do niej obiekt konkretnej klasy pochodnej. Pozwala to pisać uniwersalny kod, który działa na ogólnym typie.
* **Przykład:**
    ```java
    // Pojazd to klasa abstrakcyjna
    Pojazd p = new Samochod(); // Samochod to konkretna klasa dziedzicząca
    ```

6) **Wielodziedziczenie w Javie**

* **Dziedziczenie klas:** Klasa **nie może** dziedziczyć po wielu klasach. Java dopuszcza tylko jednego "rodzica" (single inheritance).
* **Implementacja interfejsów:** Klasa **może** implementować dowolną liczbę interfejsów.
* **Wielodziedziczenie typu:** To mechanizm, dzięki któremu jeden obiekt może być traktowany jako wystąpienie wielu różnych typów jednocześnie.
* **Przykład:**
  Mamy interfejsy `Grajacy` i `Czytajacy`. Klasa `Smartfon` implementuje oba.
  Obiekt `Smartfon s = new Smartfon();` może zostać przypisany do zmiennej typu `Grajacy` (np. w metodzie obsługującej muzykę) oraz do zmiennej typu `Czytajacy` (w metodzie do e-booków).

7) **Słowo kluczowe final a abstrakcja**

* **Final na metodach interfejsu:** Jest to błąd kompilacji dla metod abstrakcyjnych. Metoda interfejsu z założenia ma być zaimplementowana w klasie potomnej, a `final` to blokuje.
* **Final na klasie abstrakcyjnej:** To **sprzeczność**, która powoduje błąd kompilacji.


8) **Słowa kluczowe abstract i private/static**

* **Abstract i private:** Taka kombinacja jest **niedozwolona**. Metody prywatne nie są widoczne w klasach dziedziczących, więc nie ma fizycznej możliwości, aby klasa pochodna dostarczyła implementację ("nadpisała") taką metodę.
* **Abstract i static:** Taka kombinacja również jest **niedozwolona**. Metody statyczne nie podlegają polimorfizmowi (nie są nadpisywane, lecz ukrywane), więc mechanizm metod abstrakcyjnych nie miałby tu zastosowania. Metoda statyczna musi mieć ciało.