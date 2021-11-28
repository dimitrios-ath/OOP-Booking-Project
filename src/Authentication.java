import java.lang.String;

public class Authentication {
    String username, password;
    int role;

    public Authentication(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public int getRole() {return role;}


}
