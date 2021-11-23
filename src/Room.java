import java.lang.String;
public class Room {
    private int id;
    private String type;
    private boolean longTime;
    private int capacity;
    private int m2;
    private boolean wiFi;
    private boolean parking;
    private boolean airCondition;
    private boolean balcony;
    private boolean fridge;
    private boolean price;
    private boolean kitchen;
    private boolean tv;
    private boolean smoking;
    private boolean pets;

    /**
     * Constructor of Room
     * @param id        the room's id
     * @param type      the room's type {hote,room,apartment}
     * @param  longTime {true/false} if room is available for long time or short time
     * @param capacity  number of people
     * @param m2        the size of the room
     * @param wiFi      {true/false} if room provides free internet
     * @param parking   {true/false} if room provides free parking
     * @param airCondition {true/false} if room provides airCondition
     * @param balcony    {true/false} if room provides balcony
     * @param fridge     {true/false} if room provides fridge
     * @param price      the price of room per night
     * @param kitchen    {true/false} if room provides kitchen
     * @param tv         {true/false} if room provides tv
     * @param smoking    {true/false} is room provides smoking area
     * @param pets       {true/false} if room provides area for pets
     */
    public Room(int id, String type, boolean longTime, int capacity, int m2, boolean wiFi, boolean parking,
                boolean airCondition, boolean balcony,
                boolean fridge, boolean price, boolean kitchen,
                boolean tv, boolean smoking, boolean pets) {
        this.id = id;
        this.type = type;
        this.longTime = longTime;
        this.capacity = capacity;
        this.m2 = m2;
        this.wiFi = wiFi;
        this.parking = parking;
        this.airCondition = airCondition;
        this.balcony = balcony;
        this.fridge = fridge;
        this.price = price;
        this.kitchen = kitchen;
        this.tv = tv;
        this.smoking = smoking;
        this.pets = pets;
    }


    /**
     * getters of Room's attributes
     */

    public boolean isWiFi() {return wiFi;}
    public boolean isParking() {return parking;}
    public boolean isAirCondition() {return airCondition;}
    public boolean isBalcony() {return balcony;}
    public boolean isFridge() {return fridge;}
    public boolean isPrice() {return price;}
    public boolean isKitchen() {return kitchen;}
    public boolean isTv() {return tv;}
    public boolean isSmoking() {return smoking;}
    public boolean isPets() {return pets;}
    public boolean isLongTime() {return longTime;}
    public int getM2() {return m2;}
    public int getCapacity() {return capacity;}
    public int getId() {return id;}
    public String getType() {return type;}

    /**
     * setters of Rooms's attributes
     */
    public void setId(int id) {this.id = id;}
    public void setType(String type) {this.type = type;}
    public void setLongTime(boolean longTime) {this.longTime = longTime;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
    public void setM2(int m2) {this.m2 = m2;}
    public void setWiFi(boolean wiFi) {this.wiFi = wiFi;}
    public void setParking(boolean parking) {this.parking = parking;}
    public void setAirCondition(boolean airCondition) {this.airCondition = airCondition;}
    public void setBalcony(boolean balcony) {this.balcony = balcony;}
    public void setFridge(boolean fridge) {this.fridge = fridge;}
    public void setPrice(boolean price) {this.price=price;}
    public void setKitchen(boolean kitchen) {this.kitchen = kitchen;}
    public void setTv(boolean tv) {this.tv = tv;}
    public void setSmoking(boolean smoking) {this.smoking = smoking;}
    public void setPets(boolean pets) {this.pets = pets;}
}
