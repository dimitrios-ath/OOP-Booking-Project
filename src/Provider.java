import java.lang.String;
import java.util.HashSet;

public class Provider {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String office;
    private String country;
    private String region;
    private String type;
    private HashSet<Integer> roomID;

    /**
     * @param firstName     provider's first name
     * @param lastName      provider's last name
     * @param email         provider's email
     * @param username      unique provider's username
     * @param password      provider's password
     * @param office        provider's office location
     * @param country       provider's country
     * @param region        provider's region
     * @param type          provider type {hotelier/private}
     */
    public Provider(String firstName, String lastName, String email,
                    String username, String password, String office,
                    String country, String region,
                    String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.office = office;
        this.country = country;
        this.region = region;
        this.type = type;
        this.roomID = new HashSet<>();
    }

    /**
     * getters of Provider class attributes
     */
    public String getFirstName() {return this.firstName;}

    public String getLastName() {return this.lastName;}

    public String getEmail() {return this.email;}

    public String getUsername() {return this.username;}

    public String getPassword() {return this.password;}

    public String getOffice() {return this.office;}

    public String getCountry() {return this.country;}

    public String getRegion() {return this.region;}

    public String getType() {return this.type;}

    public HashSet<Integer> getRoomID() {return this.roomID;}

    /**
     * setters of Provider class attributes
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;}

    public void setLastName(String lastName) {
        this.lastName = lastName;}

    public void setEmail(String email) {
        this.email = email;}

    public void setUsername(String username) {
        this.username = username;}

    public void setPassword(String password) {
        this.password = password;}

    public void setOffice(String office) {
        this.office = office;}

    public void setCountry(String country) {
        this.country = country;}

    public void setRegion(String region) {
        this.region = region;}

    public void setType(String type) {
        this.type = type;}
}
