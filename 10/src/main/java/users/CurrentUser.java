package users;

public class CurrentUser {
    private static CurrentUser instance;
    private String username;

    private CurrentUser() { username = ""; }

    public boolean isLogged()
    {
        return !(username == null || username.equals(""));
    }
    public void setCurrentUser(String username)
    {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public static synchronized CurrentUser getInstance()
    {
        if ( instance != null) {
            return instance;
        }
        instance = new CurrentUser();
        return instance;
    }
}
