# Nr 5 – „Konstruktory"

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

1. Do czego służą konstruktory?
2. Czy każda klasa posiada konstruktor?
3. Jak zdefiniować konstruktor?
4. Czym jest konstruktor domyślny i kiedy jest definiowany?
5. Czy klasa może mieć wiele konstruktorów?
6. Jak z jednego konstruktora wywołać inny konstruktor?
7. Jaki warunek musi spełniać wywołanie jednego konstruktora z drugiego konstruktora?
8. Jaki będzie wynik kompilacji i uruchomienia poniższego kodu?
9. Ile konstruktorów posiada poniższa klasa?
10. Czy poniższa klasa ma domyślny konstruktor?
11. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
12. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
13. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
itd.

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja Zadania
1. Do czego słuza konstruktory
   - Konstruktor jest to metoda klasy ktora wywoluje się na poczatku stworzenia obiektu w javie poprzez słówko new
   - Zawsze (przynajmniej w javie) ma taka sama nazwe jak klasa 
2. Czy kazda klasa posaiada konstruktor. Nie każda klasa posiada konstruktor. Np statyczne.
3. Nic nie zwraca nawet void. W javie:
```java
public class Osoba {
    String imie;
    int wiek;
    public Osoba(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }
}
```
4. Jeżeli tworze klase `nie` statyczna i nie zdefiniuje konstruktora. Java tworzy wtedy przy kompilacji do maszyny pusty konstruktor:
```java
public Osoba() {}
```
5. Tak klasa moze miec wiecej konstruktorow. W javie mozna przeciazac konstruktory aby przyjmowaly inne argumenty itd.
```java
    public Osoba(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }
    public Osoba() {
        this.imie = "";
        this.wiek = 0;
    }
```
6. Mozna wywolac inny konstruktor z jeszcze innego konstruktora za pomoca słówka `this`
```java
    public Osoba(String imie, int wiek) {
    this.imie = imie;
    this.wiek = wiek;
}
public Osoba() {
    this("", 0);
}
```
7. this musi miec taka ilosc argumentow jak inny konstruktor ktory mamy na mysli
```java
void main()
{
    Osoba os = new Osoba();
    Osoba os2 = new Osoba("Antek", 15);
    System.out.println(os.toString());
    System.out.println(os2.toString());
}

public class Osoba
{
    String imie;
    int wiek;

    @Override
    public String toString() {
        return imie + " " + wiek;
    }

    public Osoba(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }
    public Osoba() {
        this("testowy", 0);
    }
}
```
output:
```bash
testowy 0
Antek 15
```
8. Bedzie taki wynik:
```java
public class PytanieKonstruktor {
  private int x;
  public PytanieKonstruktor(int x) {
    this.x = x;
  }
  public void setX(int x) {
    this.x = x;
  }
  public String toString() {
    return "x = " + x;
  }
  public static void main(String[] args) {
    PytanieKonstruktor o = new PytanieKonstruktor();
    System.out.println(o);
  }
}
```
output:
```bash
java: constructor PytanieKonstruktor in class Main.PytanieKonstruktor cannot be applied to given types;
  required: int
  found:    no arguments
  reason: actual and formal argument lists differ in length 
```
9. Posiada jeden konstruktor domyślny
```java
public class PytanieKonstruktor {
  private int pewnePole;
}
```
```java
public PytanieKonstruktor() {} 
```
10. Ta klasa ma zdefiniowany konstruktor 
```java
public class PytanieKonstruktor {
  private int pewnePole;
    
  public PytanieKonstruktor() {
  }
}
```
Nie, nie ma. Ma juz zdefiniowany ktory wyglada tak samo jak domyslny ale jest zdefiniowany. YYYYY

11. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
```java
public class PytanieKonstruktor {
    private final int liczba;
    private final String nazwa;
    public PytanieKonstruktor(int liczba) {
        this.liczba = liczba;
    }
    public PytanieKonstruktor(int liczba, String nazwa) {
        this.liczba = liczba;
        this.nazwa = nazwa;
    }
    public static void main(String[] args) {
        PytanieKonstruktor o = new PytanieKonstruktor(10, "Tekst");
    }
} 
```
output:
 - Wyrzuca błąd kompilacji
```bash
java: variable nazwa might not have been initialized
```
12. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
```java
public class PytanieKonstruktor {
  private final int liczba;
  public PytanieKonstruktor() {
    System.out.println("Wywolano konstruktor bez argumentow.");
    this(0);
  }
  public PytanieKonstruktor(int liczba) {
    this.liczba = liczba;
  }
  public static void main(String[] args) {
    PytanieKonstruktor o = new PytanieKonstruktor(10);
  }
}
```
Kompilacja wykona się, ale nic nie napisze ponieważ w main jest podany argument. Obiekt tylko przypisze liczbe 10 to this.liczba

13. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
```java
public class PytanieKonstruktor {
  private final int liczba;
  private final String nazwa;
  public PytanieKonstruktor(int liczba) {
    this(liczba, "brak nazwy");
    this.liczba = liczba;
  }
  public PytanieKonstruktor(int liczba, String nazwa) {
    this.liczba = liczba;
    this.nazwa = nazwa;
  }
  public static void main(String[] args) {
    PytanieKonstruktor o = new PytanieKonstruktor(10, "Tekst");
  }
}
```
Pole final moze w javie byc ustawione tylko raz, a jezeli przkazalibysmy argument bez nazwy to liczba ustawia sie 2 razy
```bash
java: variable liczba might already have been assigned
```
14. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
```java
public class PytanieKonstruktor {
    private int x;
    public void PytanieKonstruktor(int x) {
        this.x = x;
    }
    public String toString() {
        return "x = " + x;
    }
    public static void main(String[] args) {
        PytanieKonstruktor o = new PytanieKonstruktor();
        System.out.println(o);
    }
}
```
output:
```bash
x = 0
```
Wyswietlilo sie x = 0, poniewaz 0 jest domyslna wartoscia jaka `java` przypisuje pod zmienna `int`

15. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
```java
public class PytanieKonstruktor {
  private int x;
  public Pytaniekonstruktor(int x) {
    this.x = x;
  }
  public String toString() {
    return "x = " + x;
  }
  public static void main(String[] args) {
    PytanieKonstruktor o = new PytanieKonstruktor();
    System.out.println(o);
  }
}
```
```bash
java: invalid method declaration; return type required
```
Wyswietlilo sie cos takiego poniewaz java traktuje `Pytaniekonstruktor` jako metode, poniewaz konstruktor jest z malej litery a to juz inna nazwa niz taka sama jak w klasie.

16. Jaki będzie wynik kompilacji i uruchomienia poniższej klasy?
```java
public class PytanieKonstruktor {
  private int x;
  public PytanieKonstruktor() {
    x = 10;
  }
  public PytanieKonstruktor(int x) {
    x = x;
  }
  public String toString() {
    return "x = " + x;
  }
  public static void main(String[] args) {
    PytanieKonstruktor o1 = new PytanieKonstruktor();
    PytanieKonstruktor o2 = new PytanieKonstruktor(20);
    System.out.println(o1);
    System.out.println(o2);
  }
}
```
```bash
x = 10
x = 0
```
Poniewaz w pierwszym przypadku nie dalismy zadnego argumentu x przypisal sie do wartosci 10. Jako ze w drugim przypadku konstruktora ktory przyjmuje argument nie ma slowa this przed x
```java
x = x;
```

Z tego powodu argument jest przypisywany argumentowi
