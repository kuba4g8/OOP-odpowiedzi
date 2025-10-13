# Nr 1 – „Paradygmaty obiektowości”

**Autor:** Jakub Hołdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

- Z pomocą dowolnego języka programowania napisz program, który po uruchomieniu:
  - wyświetli w kolejności alfabetycznej nazwy czterech filarów OOP,
  - wyświetli w kolejności losowej nazwy czterech filarów OOP,
- W obu przypadkach wskazane jest użycie wbudowanych metod dostępnych w danym języku programowania.

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja zadania

W zadaniu wykorzystałem stworzoną przeze mnie **statyczną klasę** `Filary`.  
Oraz metodę `Arrays.sort()` w celu **posortowania** listy.
```java
private static class Filary {

    public static String[] filaryOOP = {"Abstrakcja", "Enkapsulacja", "Dziedziczenie", "Polimorfizm"};
		
		public static void printAll()
		{
			Arrays.sort(filaryOOP);
			for (int i = 0; i < filaryOOP.length; i++)
			{
				Utils.print(i +" "+filaryOOP[i]);
			}
		}

    public static void printRnd() {
        List<Integer> used = new ArrayList<>();
        Random rnd = new Random();

        while (used.size() <= 3) {
            int rndNum = rnd.nextInt(4);
            if (!used.contains(rndNum)) {
                Utils.print(rndNum + " " + filaryOOP[rndNum]);
                used.add(rndNum);
            }
        }
    }
}
```
A wszystkie metody są **statyczne**, aby można było korzystać z nich **bez tworzenia obiektu klasy**.
```java
public static void main(String[] args)
{
  Utils.print("Zad 1:");
  Filary.printAll();
  Utils.print("Zad 2:");
  Filary.printRnd();
}
```
**output:**
```bash
Zad 1:
0 Abstrakcja
1 Dziedziczenie
2 Enkapsulacja
3 Polimorfizm
Zad 2:
2 Enkapsulacja
0 Abstrakcja
3 Polimorfizm
1 Dziedziczenie
```