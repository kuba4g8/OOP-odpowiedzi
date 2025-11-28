class Osoba {
    public String toString(){
        return "Osoba";
    }
}

class Pracownik extends Osoba {
    public String toString(){
        return "Pracownik";
    }
}

public class Main {
    public static void main(String[] args) {
        Osoba a = new Pracownik();
        System.out.println(a); // Linia A

        if (a instanceof Pracownik) {
            Pracownik p = (Pracownik) a;
            System.out.println(p); // Linia B
        }

        Osoba b = new Osoba();
        Pracownik q = (Pracownik) b; // Linia C - BŁĄD KRYTYCZNY
        System.out.println(q);
    }
}