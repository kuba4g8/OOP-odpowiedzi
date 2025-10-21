import Zad1.UserProfile;
import Utilities.*;
import Zad2.Temperature;
import Zad3.AccessLevelDemo;
import Zad4.WriteOnlySettings;
import Zad5.ProductStock;

void main()
{
    // Zadanie 1
    Zad1.UserProfile user = new UserProfile();

    user.setEmail("napewno nie email");
    user.setUsername("NiePosiadaczEmaila");
    Utils.print(user.getEmail());
    Utils.print(user.getUsername());

    Utils.print(user.describe());

    // Zadanie 2
    Zad2.Temperature temperatura = new Temperature();

    temperatura.setCelcius(20.0);
    Utils.print(temperatura.getCelcius().toString());
    Utils.print(temperatura.getFarenhait().toString());

    // Zadanie 3
    AccessLevelDemo access = new AccessLevelDemo();

    access.publicName = "Public name";
    access.setPrivateSecret("Bardzo prywatny sekret");
    Utils.print(access.getPrivateSecret());

    Utils.print(access.summary());
    // reszty pol nie da sie zmienic przez enkapsulacje.... chocbym chcial

    // Zadanie 4
    WriteOnlySettings settings = new WriteOnlySettings();
    settings.setVolume(10);
    settings.setDarkMode(true);

    Utils.print(settings.describe());

    // Zadanie 5
    ProductStock produkt1 = new ProductStock();
    ProductStock produkt2 = new ProductStock();

    produkt1.setName("Black");
    produkt1.setPrice(2.5);
    produkt1.setQuantity(30);

    produkt2.setName("Rower");
    produkt2.setPrice(300.0);
    produkt2.setQuantity(2);

    Utils.print(produkt1.describe());
    Utils.print(produkt2.describe());

    ProductStock.transferQuantity(produkt1, produkt2, 10);
    // Wlasnie zmienilem Blacki w rowery. STONKS

    Utils.print(produkt1.describe());
    Utils.print(produkt2.describe());
}
