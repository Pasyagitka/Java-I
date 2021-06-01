package pasyagitka.Model;

public class CurrentUser {
    private static CurrentUser instance;
    private String username;

    private CurrentUser() { username = ""; }

    public void setCurrentUser(String username)
    {
        this.username = username;
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
