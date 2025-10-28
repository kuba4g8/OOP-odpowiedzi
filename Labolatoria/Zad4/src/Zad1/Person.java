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
