package Zad3;

public class Kolo extends Figura
{
    Double radius;

    public Kolo(Double radius)
    {
        this.radius = radius;
    }

    @Override
    public double pole()
    {
        return 3.14*radius*radius;
    }
}
