# Nr 4 – „pola klas, modyfikatory dostępu"

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

1. Jakie powinny być nazwy getterów i setterów następujących pól?
2. Czym jest i do czego służy this?
3. Kiedy możemy zobaczyć błąd Null Pointer Exception?
4. Jak uchronić się przed potencjalnym błędem Null Pointer Exception?
5. Co zostanie wypisane na ekranie w poniższym programie?
6. Jaki będzie efekt próby kompilacji poniższych klas?
7. Co zostanie wypisane na ekranie w poniższym programie?
8. Co zostanie wypisane na ekranie w poniższym programie?
9. Co zostanie wypisane na ekranie w poniższym programie?

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja zadania
1. dla wszystkich innych zmiennych innych niz bool getNazwaZM setNazwaZM, dla booleana isUzytkownikicyZalgowani i senUzytkownicyZalogowani

2. this odwoluje sie do aktualnego obiektu w klasie, upewniamy sie ze korzystamy ze zmiennej ze srodka klasy a nie argumentu czy cos.

3. Sa 2 rodzaje zmiennych w javie. Prymitywne i obiektowe. Roznia sie literka na poczatku, ale tak ogolnie to calym slowem. Zmienna prymitywna nigdy nie przyjmie obiektowego typu danych jakim np jest wlasnie null. Jezeli zmienna w rejestrze bedzie wskazywac na null, czyli nie zostala zadeklarowana przez slowko *new* lub przypisana do jakiejs liczby, to przy przyrowaniu albo wykorzystaniu tej zmiennej w kodzie wyrzuci wlasnie blad null pointer exception

4. Wylapywanie błedów 
```java
try()
{
    Integer liczba;
    if (liczba > 0)
    {
        // na tym ifie catch wylapie blad
    }
}
catch(NullPointerException ex)
{
    println(ex.toString());
}
``` 
Lub zwykly if sprawdzajacy czy obiekt jest nullem
```java
if (liczba == null)
    liczba = 0;
//reszta kodu
```
5. Zostanie wypisane:
```bash
Liczba wynosi: 0
```
Ponieważ w setterze nie ma slowa this a wiec przypisujemy argument do argumentu (nie ma sensu), ale poniewaz typ zmiennej nie jest obiektowy java autoatycznie prymitywne typy przypisuje do jakiejs wartosci podczas deklaracji. Dla inta jest to 0. Dlatego zwrocilo 0

6. Próba udana i zwróciło 
```bash
Liczba wynosi: Antek
``` 
```java
public class PytanieMetody {
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    private String nazwa;
}

public void main(String[] args) {
    PytanieMetody o = new PytanieMetody();
    o.setNazwa("Antek");
    System.out.println("Liczba wynosi: " + o.getNazwa());
}
```
Jendak druga klasa 
```java
public class PytaniePola {
    private int x = y;
    private int y = 0;
}
```
Podczas kompilacji wyrzuci blad, poniewaz nie mozemy przypisac x do nie istniejacej jeszcze zmiennej
```bash
java: illegal forward reference
```

7. Output:
```bash
Pewna nazwa
Inna nazwa
```
8. Output:
```bash
0 false null
```

9.Output: 
```bash
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because the return value of "Main$UzycieWartosci.getNazwa()" is null
```
Null Pointer Exception