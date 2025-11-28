package Zad3;

public class TrojkatRownoboczny extends Figura
{
    Double a;

    public TrojkatRownoboczny(Double a)
    {
        this.a = a;
    }

    @Override
    public double pole()
    {
        return (a*a*Math.sqrt(3)) / 4;
    }
}
