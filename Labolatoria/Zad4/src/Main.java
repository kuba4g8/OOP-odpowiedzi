import Utilities.Utils;
import Zad1.Person;
import Zad2.Rectangle;
import Zad3.BankAccount;
import Zad4.Course;
import Zad5.Employee;
import jdk.jshell.execution.Util;

void main()
{
    // Zadanie 1
    Person osoba = new Person(); // uzywamy jezeli nie znamy imienia nazwiska i wieku przy tworzeniu obiektu aby przypisac wartosci domyslne
    Person osoba2 = new Person("Ala", "Kowalska", 21); // tutaj wiemy jak ktos sie nazywa i ile ma lat to mozna podac odrazu dane
    Utils.print(osoba.describe());
    Utils.print(osoba2.describe());
    // Zadanie 1

    // Zadanie 2
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

    // Zadanie 3
    Utils.print("Zadanie 3\n");
    BankAccount bank1 = new BankAccount("Czlowiek", 10);
    BankAccount bank2 = new BankAccount("Czlowiek2", -5);
    BankAccount bank3 = new BankAccount("", -5);

    bank1.deposit(-10);
    bank1.withdraw(9999999);

    Utils.print(bank1.describe());
    Utils.print(bank2.describe());
    Utils.print(bank3.describe());

    // Zadanie 4
    Utils.print("Zadanie 4\n");
    Course infa = new Course("Programowanie Obiektowe", 100, new String[]{"Najlepsze programowanie"});

    Course infa2 = new Course(infa);
    infa.addTag("Jakis inny tag na pewno");
    Utils.print(infa.describe());
    Utils.print(infa2.describe());

    // Zadanie 5
    Utils.print("Zadanie 5\n");
    Employee pracowanik = new Employee();
    Employee pracowanik2 = new Employee("Imienny");

    Utils.print(pracowanik.describe());
    Utils.print(pracowanik2.describe());
}
