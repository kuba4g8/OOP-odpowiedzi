# Nr 3 – „modyfikatory dostępu oraz gettery/settery

**Autor:** Jakub Holdys  
**Grupa:** 1  
**Semestr:** III  
**Przedmiot:** *Programowanie Obiektowe*

---

## Opis zadania

Do zrealizowania były następujące zadania:

Stworzyc 4 klasy ktore bede opisywal w punkcie realizacji zadania

---

## Technologie wykorzystane w zadaniu

- **Java**

---

## Realizacja Zadań

1. Napisac klase UserProfile itd.

`userProfile`
```java
package Zad1;

public class UserProfile {
    private String username;
    private String email;

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String describe()
    {
        return "Username: " + username + " email: " + email;
    }
}

```
*output*:
```bash
napewno nie email
NiePosiadaczEmaila
Username: NiePosiadaczEmaila email: napewno nie email
```
`main`
```java
Zad1.UserProfile user = new UserProfile();

user.setEmail("napewno nie email");
user.setUsername("NiePosiadaczEmaila");
Utils.print(user.getEmail());
Utils.print(user.getUsername());

Utils.print(user.describe());

```

2. Napisac klase `Temperature` ktora posiada jakies właściwości

`Temperature`
```java
package Zad2;

public class Temperature
{
    private Double celcius;
    private Double farenhait;

    public Double getCelcius()
    {
        return celcius;
    }

    public void setCelcius(Double celcius)
    {
        this.celcius = celcius;
    }

    public Double getFarenhait()
    {
        return toFarenhait(this.celcius);
    }

    private Double toFarenhait(Double celcius)
    {
        return this.celcius * 2 + 30;
    }
}

```
*output*:
```bash
20.0
70.0
```
`main`
```java
Zad2.Temperature temperatura = new Temperature();

temperatura.setCelcius(20.0);
Utils.print(temperatura.getCelcius().toString());
Utils.print(temperatura.getFarenhait().toString());
```

3. Napisać klase `AccessLevelDemo` ktora zawiera pola o różnych modyfikatorach dostepu
`AccessLevelDemo`
```java
package Zad3;

public class AccessLevelDemo
{
    public String publicName;
    protected Integer protectedID;
    String packageLevel;
    private String privateSecret;

    public String getPrivateSecret()
    {
        return this.privateSecret;
    }

    public void setPrivateSecret(String secret)
    {
        this.privateSecret = secret;
    }

    public String summary()
    {
        return publicName + " " + protectedID + " " + packageLevel + " " + privateSecret;
    }
}

```
*output*:
```bash
Bardzo prywatny sekret
Public name null null Bardzo prywatny sekret
```
`main`
```java
AccessLevelDemo access = new AccessLevelDemo();

access.publicName = "Public name";
access.setPrivateSecret("Bardzo prywatny sekret");
Utils.print(access.getPrivateSecret());

Utils.print(access.summary());
// reszty pol nie da sie zmienic przez enkapsulacje.... chocbym chcial      
```
W outpucie pojawia sie null poniewaz niektore zmienne nigdy nie sa przypisane do zadnej wartosci. Jezeli byly by to prymitywne zmienne mialy by defaoultowe wartosci. Jak dla inta = 0

4. Własnosci write-only + kontrolowany odczyt
`WriteOnlySettings`
```java
package Zad4;

public class WriteOnlySettings
{
    private Integer volume;
    private boolean darkMode;

    public void setVolume(Integer volume)
    {
        this.volume = volume;
    }

    public void setDarkMode(Boolean darkMode)
    {
        this.darkMode = darkMode;
    }

    public String describe()
    {
        return volume + " " + darkMode;
    }

}
```
*output*:
```bash
10 true
```
`main`
```java
WriteOnlySettings settings = new WriteOnlySettings();
settings.setVolume(10);
settings.setDarkMode(true);

Utils.print(settings.describe());
```
5. Napisac klase ProductStock. Enkapsulacja i operacje na dwóch obiektach
`ProductStock`
```java
package Zad5;

public class ProductStock
{
    private String name;
    private Double price;
    private Integer quantity;

    public static void transferQuantity(ProductStock from, ProductStock to, Integer ammount)
    {
        from.quantity -= ammount;
        to.quantity += ammount;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public Double getPrice()
    {
        return price;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public String describe()
    {
        return name + " " + price + " " + quantity;
    }
}
```
*output*:
```bash
Black 2.5 30
Rower 300.0 2
Black 2.5 20
Rower 300.0 12
```
`main`
```java
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
```