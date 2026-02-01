public class Main {
    
    public static void main(String[] args) {
        
        // Test 1: Przypadek pozytywny - wszystkie dane są poprawne
        try
        {
            Adres adresPoprawny = new Adres("Złota", 44, "00-001", "Warszawa");
            System.out.println("Sukces: Utworzono adres w mieście " + adresPoprawny.miasto);
        }
        catch (NieprawidlowyAdresException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println("--------------------------------------------------");
        
        try
        {
            Adres adresBledny = new Adres(null, -5, "80-000", null);
        }
        catch (NieprawidlowyAdresException e)
        {
            System.out.println(e.getMessage());
        }
    }
}