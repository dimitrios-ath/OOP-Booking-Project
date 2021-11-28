import java.lang.String;
import java.time.LocalDate;

public class Customer {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String phone;
    private LocalDate birthdate;
    private Boolean activeAccount;

    /**
     * Constructor of Customer
     * @param username          customer unique username
     * @param email             customer email
     * @param password          customer password
     * @param firstName         customer first name
     * @param lastName          customer last name
     * @param gender            customer gender
     * @param country           customer country
     * @param phone             customer phone number
     * @param birthdate         customer birthdate
     * @param activeAccount     is account active {true/false}
     */
    public Customer(String username, String email, String password,
                    String firstName, String lastName, String gender,
                    String country, String phone, LocalDate birthdate,
                    Boolean activeAccount) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.phone = phone;
        this.birthdate = birthdate;
        this.activeAccount = activeAccount;
    }

    /**
     * getters of Customer attributes
     */
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getGender() {return gender;}
    public String getCountry() {return country;}
    public String getPhone() {return phone;}
    public LocalDate getBirthdate() {return birthdate;}
    public Boolean getActiveAccount() {return activeAccount;}

    /**
     * setters of Customer attributes
     */
    public void setUsername(String username) {this.username = username;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setGender(String gender) {this.gender = gender;}
    public void setCountry(String country) {this.country = country;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setBirthdate(LocalDate birthdate) {this.birthdate = birthdate;}
    public void setActiveAccount(Boolean activeAccount) {this.activeAccount = activeAccount;}


}
