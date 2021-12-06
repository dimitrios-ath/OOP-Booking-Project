import java.lang.String;
import java.util.HashSet;

public class Provider {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String office;
    private String country;
    private String region;
    private String type;
    private boolean activeAccount;
    private HashSet<Integer> roomIDs;

    /**
     * @param username      unique provider username
     * @param password      provider password
     * @param email         provider email
     * @param firstName     provider first name
     * @param lastName      provider last name
     * @param office        provider office location
     * @param country       provider country
     * @param region        provider region
     * @param type          provider type {hotelier/private}
     */
    public Provider(String username, String password, String email,
                    String firstName, String lastName, String office,
                    String country, String region, String type,boolean activeAccount) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
        this.country = country;
        this.region = region;
        this.type = type;
        this.activeAccount=activeAccount;
        this.roomIDs = new HashSet<>();
    }

    public void removeRoomID(Integer roomID) {this.roomIDs.remove(roomID);}

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
    public boolean getActiveAccount() {return this.activeAccount;}
    public HashSet<Integer> getRoomIDs() {return this.roomIDs;}

    /**
     * setters of Provider class attributes
     */
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setOffice(String office) {this.office = office;}
    public void setCountry(String country) {this.country = country;}
    public void setRegion(String region) {this.region = region;}
    public void setType(String type) {this.type = type;}
    public void setActiveAccount(boolean activeAccount) {this.activeAccount=activeAccount;}
    public void addRoomID(Integer roomID) {this.roomIDs.add(roomID);}
}
