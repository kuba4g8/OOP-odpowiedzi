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
