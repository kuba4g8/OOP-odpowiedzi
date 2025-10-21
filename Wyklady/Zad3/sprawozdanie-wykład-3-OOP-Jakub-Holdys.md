# Nr 1 – „Klasy i obiekty”

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

1). Czym różni się klasa od obiektu? 2). Z czego składają się klasy? 3). Jak utworzyć nowy obiekt klasy? 4). Czy poniższa klasa jest poprawna?
I *inne*

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja zadania

*Zadanie 1 :*
1. Klasa to np przepis na ciasto, a obiekt to juz wypieczone ciasto, ale może brakować kilku składników jak polewa czekoladowa. Ale samo ciasto zawsze jest
    Klasa to szablon, a obiekt to konretna definicja z klasy

2. Klasa składa się z właściwości, metod oraz konstruktorów.
3. Zaleznie od jezyka lecz w javie:
```java
Random rnd = new Random();
```

Gdzie po lewej stronie jest deklaracja zmiennej o typie danej klasy, a po prawej definicja samego obiektu.

4. 
```java
public class Pytanie {
    public static void main(String[] args) {
        System.out.println( "Witaj!" );
    }
}
```

Tak.

5. Co zostanie wypisane na ekran?:

```java
public class Punkt {
    private int x , y ;
    
    public void ustawX( int wartoscX) {
        x = wartoscX;
    }
    
    public void ustawY( int wartoscY) {
        y = wartoscY;
    }
    
    public String toString() {
        return "X, Y: " + x + ", " + y ;
    }
    
    public static void main(String[] args) {
        Punkt a = new Punkt();
        Punkt b = new Punkt();
        a.ustawX( 10 );
        a.ustawY( 20 );
        b.ustawX( 0 );
        b.ustawY( 5 );
        System.out.println(a);
        System.out.println(b);
    }
}
```

**output:**

```bash
X, Y: 10, 20
X, Y: 0, 5
```

6. Napisz klasę `Osoba`, która będzie zawierała itd. itd. itd:

```java
public class Osoba
{
    public Integer wiek;
    public String imie;
    public String nazwisko;

    public void ustawWiek(Integer wiek)
    {
        this.wiek = wiek;
    }

    public void ustawImie(String imie)
    {
        this.imie = imie;
    }

    public void ustawNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString()
    {
        return imie + " " + nazwisko + " " + wiek;
    }
}
```
`main`
```java
public static void main(String[] args)
{
    Osoba antek = new Osoba();

    antek.ustawImie("Antek");
    antek.ustawNazwisko("Antrykowy");
    antek.ustawWiek(20);

    Utils.print(antek.toString());
}
```
output:
```bash
Antek Antrykowy 20
```