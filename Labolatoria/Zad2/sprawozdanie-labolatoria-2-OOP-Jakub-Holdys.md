# Nr 1 – „modyfikatory dostępu bez klas domenowych"

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

1. Prysoty opis osoby
2. Symulacja konta
3. Prostokat
4. Punkty

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja zadania

*Zadanie 1 :*
```java
package Zad1;

public class Zad1 {
    public static class Osoba
    {
        private Integer wiek;
        private String imie;
        private String nazwisko;

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

        public String opisOsoby()
        {
            return imie + " " + nazwisko + " " + wiek;
        }
    }

}

```

*Zadanie 2*:
```java
package Zad2;

public class Zad2 {
    public static class KontoBankowe
    {
        private static String owner;
        private static Float balance;

        public static void reset(String newOwner, Float newBalance)
        {
            owner = newOwner;
            balance = newBalance;
        }

        public static void deposit(Float newBalance)
        {
            balance += newBalance;
        }

        public static String withdraw(float kwota)
        {
            if (balance < kwota)
            {
                return "Za malo kasy na koncie";
            }
            else
            {
                balance -= kwota;
                return balance.toString();
            }
        }
    }
}

```

*Zadanie 3*:
```java
package Zad3;

public class Zad3_Rectangle
{
    public class Oblicz
    {
        static Integer width;
        static Integer heigth;

        public static Integer getWidth() {return width;}
        public static Integer getHeight() {return heigth;}
        public static void setWidth(Integer newWidth) {width = newWidth;}
        public static void setHeigt(Integer newHighth) {heigth = newHighth;}

        public static Integer area()
        {
            return width * heigth;
        }

        public static Integer obwod()
        {
            return 2 * width + 2 * heigth;
        }
    }
}

```

*Zadanie 4*:
```java
package Zad4;

import Utilities.Utils;

public class Zad4_ImmutablePoint {

    public static class Punkty
    {
        public Float x;
        public Float y;
        private Float dx;
        private Float dy;

        public Float[] moveBy(Float xMoved, Float yMoved)
        {
            dx = x + xMoved;
            dy = y + yMoved;
            Float[] tab = {dx, dy};
            return tab;
        }

        public void formatPoint()
        {
            Utils.print("Nie poruszone: " + x + " " + y);
            Utils.print("poruszone: " + dx + " " + dy);
        }
    }
}
```

Klasa `main`:
```java

import Utilities.*;
import Zad1.Zad1;
import Zad2.Zad2;
import Zad3.Zad3_Rectangle;
import Zad4.Zad4_ImmutablePoint;

public class Main {
    public void main(String[] args)
    {
        // Zadanie 1
        Zad1.Osoba osoba = new Zad1.Osoba();

        //osoba.wiek = 5 tak nie zrobie bo wiek jest zmienna prywatna nie ma dostepu
        osoba.ustawWiek(5);
        osoba.ustawImie("Kuba");
        Utils.print(osoba.opisOsoby());

        // Zadanie 2
        Zad2.KontoBankowe.reset("Antek", 15f);
        Zad2.KontoBankowe.deposit(10f);
        Zad2.KontoBankowe.withdraw(5f);

        //zadanie 3
        Zad3_Rectangle.Oblicz.setHeigt(5);
        Zad3_Rectangle.Oblicz.setWidth(7);
        Utils.print(Zad3_Rectangle.Oblicz.area().toString());
        Utils.print(Zad3_Rectangle.Oblicz.obwod().toString());
        Zad4_ImmutablePoint.Punkty punkty = new Zad4_ImmutablePoint.Punkty();


        //zadanie 4
        punkty.x = 5f;
        punkty.y = 10f;

        punkty.moveBy(10f, 15f);
        punkty.formatPoint();
    }
}
```
`Output`:
```bash
Kuba Holdys 5 //zad 1
35 //area
24 //bowod
Nie poruszone: 5.0 10.0 //punkty
poruszone: 15.0 25.0
```