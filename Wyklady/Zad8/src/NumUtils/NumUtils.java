package NumUtils;

public class NumUtils
{
    public Boolean czyParzysta(int liczba)
    {
        if (liczba % 2 == 0)
            return true;
        else
            return false;
    }

    public int czyDodatnia(int liczba)
    {
        if (liczba < 0)
            return -1;
        else if (liczba == 0)
            return 0;
        else
            return 1;
    }

    public int sprawdzCzyJestNaTablicy(int[] tablica, int liczba)
    {
        for (int i = 0; i < tablica.length; i++)
        {
            if (tablica[i] == liczba)
            {
                return i;
            }
        }
        return -1;
    }
}
