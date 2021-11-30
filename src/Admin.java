import java.lang.String;

public class Admin {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;

    /**
     * Constructor of Admin
     * @param username      admin username
     * @param password      admin password
     * @param firstName     admin firstName
     * @param lastName      admin lastName
     * @param email         admin email
     * @param phone         admin phone number
     */
    public Admin(String username, String password, String firstName,
                 String lastName, String email, String phone) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }



    /**
     * getters of Admin class attributes
     */
    public String getUsername() {return this.username;}
    public String getFirstName() {return this.firstName;}
    public String getLastName() {return this.lastName;}
    public String getPassword() {return this.password;}
    public String getEmail() {return this.email;}
    public String getPhone() {return this.phone;}

    /**
     * setters  of Admin class attributes
     */
    public void setUsername(String username) {this.username = username;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
}