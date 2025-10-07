# 🧠 Sprawozdanie – Laboratorium 1 OOP (Java)

**Autor:** *Jakub Holdys*  
**Przedmiot:** Programowanie Obiektowe  
**Temat:** Klasy i metody statyczne w języku Java

---

## 🎯 Cel laboratorium

Celem laboratorium było:

- utrwalenie umiejętności tworzenia i korzystania z **metod statycznych**,
- zastosowanie **operatora warunkowego `?:`** w praktyce,
- implementacja prostych narzędzi matematycznych w postaci klas pomocniczych (**Utils**),
- obsługa wyjątków z wykorzystaniem konstrukcji `try-catch`,
- zrozumienie różnic pomiędzy metodami statycznymi a instancyjnymi,
- wykorzystanie klas pomocniczych do organizacji kodu.

---

## 🧱 Struktura projektu

Plik źródłowy: `Main.java`  
Zawiera klasę główną `Main` oraz klasy wewnętrzne:

| Klasa           | Opis                                                                 |
|-----------------|----------------------------------------------------------------------|
| `DemoMetod`     | Demonstruje działanie prostych metod statycznych.                    |
| `KoloUtils`     | Obliczenia na kołach: pole, obwód, porównanie pól, walidacja promienia. |
| `MathUtils`     | Operacje matematyczne: `max`, `min`, `avg`.                          |
| `CalcUtils`     | Działania arytmetyczne: `add`, `sub`, `mul`, `div`, `pow`.          |
| `IDGenenrator`  | Generowanie kolejnych identyfikatorów.                              |
| `Utilities.Utils` | Klasa z metodą pomocniczą `print()` do wypisywania wyników.       |

---

## 📂 Opis funkcjonalności

### 🔹 Klasa `DemoMetod`
```java
static void info() {
    Utils.print("To jest informacyjna metoda statyczna");
}

static String imie(String imie) {
    return imie;
}
```

Metody pokazują użycie `static` oraz przekazywanie argumentów.

Klasa `MathUtils`:
```java
static Integer max(int a, int b) {
    return a > b ? a : b;
}

static Integer min(int a, int b) {
    return a > b ? b : a;
}

static Float avg(int a, int b) {
    return (float) ((a + b) / 2);
}
```

`zadanie 2` klasa `KoloUtils`:

```java

public static class KoloUtils
{
  public static final double PI = 3.14159;
  
  private static boolean checkPromien(double promien)
  {
    return true ? promien >= 0 : false;
  }
  
  public static int porownajPole(double r1, double r2)
  {
    if (!checkPromien(r1) || !checkPromien(r2))
      throw new IllegalArgumentException("promien za maly:(");
    
    var pole1 = pole(r1);
    var pole2 = pole(r2);
    
    if (pole1 > pole2)
    {
      Utils.print("Pole1 o r: " + r1 + " jest wieksze niz Pole2 o r: " + r2);
      return 1;
    }
    else if (pole1 < pole2)
    {
      Utils.print("Pole1 o r: " + r1 + " jest mniejsze niz Pole2 o r: " + r2);
      return -1;
    }
    else
    {
      Utils.print("Pola sa rowne!");
      return 0;
    }
  }

  public static double obwod(double promien)
  {
    if (!checkPromien(promien))
      throw new IllegalArgumentException("Pormien za mały:(");
    
    return 2 * PI * promien;
  }
  
  public static double pole(double promien)
  {
    if (!checkPromien(promien))
      throw new IllegalArgumentException("Pormien za mały:(");
    
    return PI * promien * promien;
  }
}
```
*Zadanie 4* z klasą `CalcUtils`:
```java
static class CalcUtils
{
  public static Integer add(int a, int b)
  {
    return a + b;
  }
  
  static Integer sub(int a, int b)
  {
    return  a - b;
  }
  
  public static Float mul(Integer a, Integer b)
  {
    return (float) (a * b);
  }
  
  static Float div(int a, int b)
  {
    if (b == 0)
      throw new IllegalArgumentException("nie dziel przez zero cholero");
    
    return (float) (a / b);
  }
  
  static Double pow(int a, int n)
  {
    double suma = 1;
    
    for (int i = 1; i < n; i++)
    {
      suma *= i;
    }
    return suma;
  }
}
```

I ostatnie zadanie, bo *zadanie 5* z klasą `IDGenerator`:
```java
public static class IDGenenrator
{
  public static Integer total = 0;
  
  public static int nextID()
  {
    total++;
    Utils.print(total.toString());
    return total;
  }
}
```