import java.io.Serializable;
import java.lang.String;

/**
 *   An object of this class is used during login. This object holds some basic info
 *   like username, password and role, and it's used for the authentication.
 */
public class Authentication implements Serializable {
    String username, password;
    int role;

    /**
     *   Constructor of Authentication class
     *   @param username    user username
     *   @param password    user password
     *   @param role        user role {1:customer, 2:provider, 3:admin}
     */
    public Authentication(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * getters of Authentication class attributes
     */
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public int getRole() {return role;}


}
