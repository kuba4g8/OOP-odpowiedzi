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
