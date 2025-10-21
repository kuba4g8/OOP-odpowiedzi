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
