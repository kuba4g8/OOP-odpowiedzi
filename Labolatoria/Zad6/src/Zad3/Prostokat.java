package Zad3;

public class Prostokat extends Figura
{
    Double a;
    Double b;

    public Prostokat(Double a, Double b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public double pole()
    {
        return a * b;
    }
}
