public class Adres {
    
    String ulica;
    int numerDomu;
    String kodPocztowy;
    String miasto;
    
    public Adres(String ulica, int numerDomu, String kodPocztowy, String miasto) throws NieprawidlowyAdresException {
        String komunikatBledu = "";
        
        if (ulica == null) {
            komunikatBledu = komunikatBledu + "Ulica nie może być nullem. ";
        }
        
        if (numerDomu <= 0) {
            komunikatBledu = komunikatBledu + "Numer domu musi być liczbą > 0. ";
        }
        
        if (kodPocztowy == null) {
            komunikatBledu = komunikatBledu + "Kod pocztowy nie może być nullem. ";
        }
        
        if (miasto == null) {
            komunikatBledu = komunikatBledu + "Miasto nie może być nullem. ";
        }
        
        if (!komunikatBledu.equals("")) {
            throw new NieprawidlowyAdresException(komunikatBledu);
        }
        
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }
}