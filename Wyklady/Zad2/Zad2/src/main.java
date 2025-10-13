import Utilities.Utils;

public class main {

    public static void main(String[] args)
    {
        Osoba antek = new Osoba();

        antek.ustawImie("Antek");
        antek.ustawNazwisko("Antrykowy");
        antek.ustawWiek(20);

        Utils.print(antek.toString());
    }
}
