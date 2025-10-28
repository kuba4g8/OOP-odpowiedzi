# Lab 4 – Zadania: konstruktory (grupa 1)

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

# Opis zadania

- Stworzyc 4 `klasy` ktore zostana lepiej opisane pozniej

---

# Technologie wykorzystane w zadaniu

- **Java**

---

# Realizacja zadań

## Zadanie 1. Domyślny i parametryczny konstruktor – klasa Person
```java
package Zad1;

public class Person
{
    private String firstName;
    private String lastName;
    private int age;

    public Person()
    {
        firstName = "Jhon";
        lastName = "Doe";
        age = 18;
    }

    public Person(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String describe()
    {
        return firstName + " " + lastName + " wiek: " + age;
    }
}
```
output:
```bash
Jhon Doe wiek: 18
Ala Kowalska wiek: 21
```
`main`:
```java
Person osoba = new Person(); // uzywamy jezeli nie znamy imienia nazwiska i wieku przy tworzeniu obiektu aby przypisac wartosci domyslne
Person osoba2 = new Person("Ala", "Kowalska", 21); // tutaj wiemy jak ktos sie nazywa i ile ma lat to mozna podac odrazu dane
Utils.print(osoba.describe());
Utils.print(osoba2.describe());
```
2 konstruktory moge odwolac sie do jednego podczas tworzenia klasy. Albo z argumentami albo domyslne argumenty dopisze.

Moze miec to zastosowanie na serwerze kiedy uzytkownik laczy sie z socketem, to ta chwila zanim wysle swoj nick najczesciej
jako pierwsza wiadomosc przypisuje sie jego nick do null

# Zadanie 2. Przeciążanie konstruktorów + delegacja przez this() – klasa Rectangle

```java
package Zad2;

public class Rectangle
{
    private double width;
    private double height;

    public Rectangle()
    {
        this(1, 1);
    }
    public Rectangle(double size)
    {
        this(Math.sqrt(size), Math.sqrt(size));
    }
    public Rectangle(double width, double height)
    {
        this.height = height;
        this.width = width;
    }

    public double area()
    {
        return width * height;
    }

    public double permineter()
    {
        return width * 2 + height * 2;
    }

    public String describe()
    {
        return "Dlugosc: " + width + " szerokosc " + height;
    }
}
```
output:
```bash
Dlugosc: 1.0 szerokosc 1.0
1.0
4.0
Dlugosc: 2.0 szerokosc 2.0
4.0
8.0
Dlugosc: 2.0 szerokosc 2.0
4.0
8.0
```
`main`:
```java
Utils.print("Zadanie 2\n");
Rectangle rect1 = new Rectangle();
Rectangle rect2 = new Rectangle(4);
Rectangle rect3 = new Rectangle(2, 2);

Utils.print(rect1.describe());
Utils.print(String.valueOf(rect1.area()));
Utils.print(String.valueOf(rect1.permineter()));

Utils.print(rect2.describe());
Utils.print(String.valueOf(rect2.area()));
Utils.print(String.valueOf(rect2.permineter()));

Utils.print(rect3.describe());
Utils.print(String.valueOf(rect3.area()));
Utils.print(String.valueOf(rect3.permineter()));
```
`this` -> odwoluje sie do innego konstruktora zaleznie ile argumento podam. Musi byc zawsze na poczatku

## Zadanie 3. Walidacja w konstruktorze BEZ wyjątków – klasa BankAccount
```java
package Zad3;

import Utilities.Utils;

public class BankAccount
{
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance)
    {
        if (owner.isEmpty())
        {
            owner = "Unknown";
        }
        if (balance < 0)
        {
            this.balance = 0.0;
        }
        else if (!owner.isEmpty() && balance >= 0)
        {
            this.owner = owner;
            this.balance = balance;
        }
    }

    public void deposit(double ammount)
    {
        if (ammount < 0)
        {
            Utils.print("Co ty chcesz wplacic -zl lol");
            return;
        }
        this.balance += ammount;
    }

    public void withdraw(double balance)
    {
        if (this.balance > balance)
            this.balance -= balance;
        else
        {
            System.out.println("Nie ma kaski");
        }
    }

    public String describe()
    {
        return this.owner + ": " + this.balance;
    }
}
```
output:
```bash
Co ty chcesz wplacic -zl lol
Nie ma kaski
Czlowiek: 10.0
Czlowiek2: 0.0
Unknown: 0.0
```
`main`:
```java
Utils.print("Zadanie 3\n");
BankAccount bank1 = new BankAccount("Czlowiek", 10);
BankAccount bank2 = new BankAccount("Czlowiek2", -5);
BankAccount bank3 = new BankAccount("", -5);

bank1.deposit(-10);
bank1.withdraw(9999999);

Utils.print(bank1.describe());
Utils.print(bank2.describe());
Utils.print(bank3.describe());
```
## Zadanie 4. Konstruktor kopiujący vs. klon powierzchowny – klasa Course
```java
package Zad4;

public class Course
{
    private String title;
    private int ects;
    private String[] tags;

    public Course(String title, int ects, String[] tags)
    {
        this.title = title;
        this.ects = ects;
        this.tags = tags;
    }

    public Course(Course docelowyKurs)
    {
        this.title = docelowyKurs.title;
        this.ects = docelowyKurs.ects;
        this.tags = docelowyKurs.tags.clone();
    }

    public void addTag(String tag)
    {
        String[] newTags = new String[tags.length + 1];

        for (int i = 0; i < tags.length; i++)
        {
            newTags[i] = tags[i];
        }

        newTags[tags.length] = tag;

        this.tags = newTags;
    }

    public String describe()
    {
        String retStr = title + " " + ects + "\n";

        for (int i = 0; i < this.tags.length; i++)
        {
            retStr += tags[i] + "\n";
        }

        return retStr;
    }
}
```
output:
```bash
Programowanie Obiektowe 100
Najlepsze programowanie
Jakis inny tag na pewno

Programowanie Obiektowe 100
Najlepsze programowanie
```
`main`:
```java
Course infa = new Course("Programowanie Obiektowe", 100, new String[]{"Najlepsze programowanie"});

Course infa2 = new Course(infa);
infa.addTag("Jakis inny tag na pewno");
Utils.print(infa.describe());
Utils.print(infa2.describe());
```

## Zadanie 5. Łańcuch inicjalizacji: pola, inicjalizatory, konstruktor – klasa Employee (bez dziedziczenia)
```java
package Zad5;

import Utilities.*;
public class Employee
{
    String name;

    public Employee()
    {
        this("Bez imienny");
        Utils.print("Bez imienny");
    }

    public Employee(String imie)
    {
        Utils.print("Inicjalizacja: " + imie);
        Utils.print("Konstruktor: Pracownik(" + imie + ")");
        this.name = imie;
    }

    public String describe()
    {
        return name;
    }
}
```
output:
```bash
Inicjalizacja: Bez imienny
Konstruktor: Pracownik(Bez imienny)
Bez imienny
Inicjalizacja: Imienny
Konstruktor: Pracownik(Imienny)
Bez imienny
Imienny
```
`main`:
```java
Utils.print("Zadanie 5\n");
Employee pracowanik = new Employee();
Employee pracowanik2 = new Employee("Imienny");

Utils.print(pracowanik.describe());
Utils.print(pracowanik2.describe());
```