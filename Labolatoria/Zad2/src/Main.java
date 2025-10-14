import Utilities.*;
import Zad1.Zad1;
import Zad2.Zad2;
import Zad3.Zad3_Rectangle;
import Zad4.Zad4_ImmutablePoint;
import jdk.jshell.execution.Util;

public class Main {
    public void main(String[] args)
    {
        // Zadanie 1
        Zad1.Osoba osoba = new Zad1.Osoba();

        //osoba.wiek = 5 tak nie zrobie bo wiek jest zmienna prywatna nie ma dostepu
        osoba.ustawWiek(5);
        osoba.ustawImie("Kuba");
        osoba.ustawNazwisko("Holdys");
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