# Zadanie nr 9 (Wyjatki) 

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:


    1. Do czego służą wyjątki?
    2. W której z metod wymienionych w poniższym stack trace rzucony został wyjątek?
    3. Jak w języku Java obsługuje się wyjątki?
    4. Do czego służy sekcja finally i czy jest wymagana?
    5. Jak rzuca się wyjątki?
    6. Do czego służy słowo kluczowe throws?
    7. Jaką regułę muszą spełniać klasy, aby były klasami wyjątków?
    8. Do czego służy try-with-resources i jak się tego mechanizmu używa?
    9. Napisz program z klasą Adres, która będzie miała podane poniżej pola, które będą ustawiane w konstruktorze klasy Adres. Konstruktor powinien sprawdzić wszystkie podane wartości i      rzucić wyjątek NieprawidlowyAdresException rodzaju Checked, jeżeli któraś z wartości będzie nieprawidłowa.
---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja Zadań

1. Wyjątki w javie służa do pokazywania, że cos poszlo nie tak. Używa sie ich żeby nie robic za kazdym razem gdy w jakies funkcji cos pojdzie nie tak kodu bledu np -1, tylko obiekt jakies wyjatku co ulepsza czytelnosc kodu.
2. Bład byl wyrzucony w: 
   - `at Pytania.innaMetoda(Pytania.java:13)`
3. Wyjatki w javie obsluguje sie za pomoca try catch finnally. Try tam probuje wykonac kod, jak bedzie jakis wyjatek idzie do catcha. A jak jest finnally to zawsze tam wejdzie na samym koncu, try albo catcha.
4. finally sluzy do umieszczenia instrukcji ktora MUSI sie wywolac na koncu bloku try catch. Np zamkniecie strumienia odczytywania pliku w finally, nie wazne czy byl blad czy nie ten strumien i tak trzeba zamknac. Nie musi byc finally w try catch
5. Wyjatki rzuca sie za pomoca slowka kluczeowego `throw`
6. throws sie umieszcza aby dac informacje ze ta metoda MOZE wyrzucic typ wyjatku jaki sie da po tym slowku throws oraz ze trzeba ztry catch`owac ta metode jak sie bedzie chcialo jej uzyc.
7. Aby klasa byla klasami wyjatkow musi rozszerzac klase po Throwable, lub jej pochodne (np Exception)
8. try-with-resources to taka struktura gdzie w slowo try piszemy co chcemy otworzyc i java automatycznie po tej strukturze zamknie to za nas.
```java
try (Scanner scanner = new Scanner(new File("test.txt")))
{
// cos tam    
}
catch(FileNotFoundException e)
{
// cos tam
}
```
9. Zadanie rozwiazane w kodzie, ale output:
```bash
Sukces: Utworzono adres w mieście Warszawa
--------------------------------------------------
Złapano wyjątek z komunikatem:
Ulica nie może być nullem. Numer domu musi być liczbą > 0. Miasto nie może być nullem. 
```