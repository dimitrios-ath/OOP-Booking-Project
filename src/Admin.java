public class Admin {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
/**
 * Constructor of Admin
 * @param username  Admin's username
 * @param firstName Admin's firstName
 * @param lastName  Admin's lastName
 * @param password  Admin's password
 * @param email     Admin's email
 * @param phone     Admin's phone
 */
    public Admin(String username, String firstName, String lastName,
                 String password, String email, String phone) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    /**
     * getters of Admin's attributes
     */

    public String getUsername() {return username;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPassword() {return password;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    /**
     * setters  of Admin's attributes
     */
    public void setUsername(String username) {this.username = username;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
}
