public class UzycieWartosci {
    private int liczba;
    private String nazwa;
    private int getLiczba() {
        return liczba;
    }
    private String getNazwa() {
        return nazwa;
    }

}
public void main(String[] args) {
    UzycieWartosci o = new UzycieWartosci();
    System.out.println(o.getLiczba());
    System.out.println(o.getNazwa().toUpperCase());
}