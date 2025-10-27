void main()
{
    PytanieKonstruktor o1 = new PytanieKonstruktor();
    PytanieKonstruktor o2 = new PytanieKonstruktor(20);
    System.out.println(o1);
    System.out.println(o2);
}

public class PytanieKonstruktor {
    private int x;
    public PytanieKonstruktor() {
        x = 10;
    }
    public PytanieKonstruktor(int x) {
        x = x;
    }
    public String toString() {
        return "x = " + x;
    }
    public static void main(String[] args) {

    }
}