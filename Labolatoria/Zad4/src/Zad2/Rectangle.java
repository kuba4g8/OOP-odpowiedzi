package Zad2;

public class Rectangle
{
    private double width;
    private double height;

    public Rectangle()
    {
        this(1, 1);
    }
    public Rectangle(double size)
    {
        this(Math.sqrt(size), Math.sqrt(size));
    }
    public Rectangle(double width, double height)
    {
        this.height = height;
        this.width = width;
    }

    public double area()
    {
        return width * height;
    }

    public double permineter()
    {
        return width * 2 + height * 2;
    }

    public String describe()
    {
        return "Dlugosc: " + width + " szerokosc " + height;
    }
}
