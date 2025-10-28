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
            this.balance = balance;

        }
        if (balance < 0)
        {
            this.balance = 0.0;
            this.owner = owner;

        }
        else
        {
            this.balance = balance;
            this.owner = owner;
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
