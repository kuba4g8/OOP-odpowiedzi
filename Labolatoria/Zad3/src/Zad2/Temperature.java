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
