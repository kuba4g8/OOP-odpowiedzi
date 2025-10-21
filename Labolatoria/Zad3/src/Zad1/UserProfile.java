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
