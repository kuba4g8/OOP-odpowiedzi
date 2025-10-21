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
