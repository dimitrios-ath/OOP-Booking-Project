import java.lang.String;

public class Room {
    private int id;
    private String type;
    private boolean longTime;
    private int capacity;
    private double price;
    private int m2;
    private boolean wifi;
    private boolean parking;
    private boolean airCondition;
    private boolean balcony;
    private boolean fridge;
    private boolean kitchen;
    private boolean tv;
    private boolean smoking;
    private boolean pets;

    /**
     * Constructor of Room
     * @param id            room id
     * @param type          room type {hotel,room,apartment}
     * @param longTime      is room available for long term reservation {true/false}
     * @param capacity      number of people
     * @param price         room price per night
     * @param m2            size of the room in square meters
     * @param wifi          room provides free wifi {true/false}
     * @param parking       room provides free parking {true/false}
     * @param airCondition  room has airCondition {true/false}
     * @param balcony       room has balcony {true/false}
     * @param fridge        room has fridge {true/false}
     * @param kitchen       room has kitchen {true/false}
     * @param tv            room has tv {true/false}
     * @param smoking       smoking allowed {true/false}
     * @param pets          pets allowed {true/false}
     */
    public Room(int id, String type, boolean longTime, int capacity,
                double price, int m2, boolean wifi, boolean parking,
                boolean airCondition, boolean balcony,
                boolean fridge, boolean kitchen,
                boolean tv, boolean smoking, boolean pets) {
        this.id = id;
        this.type = type;
        this.longTime = longTime;
        this.capacity = capacity;
        this.price = price;
        this.m2 = m2;
        this.wifi = wifi;
        this.parking = parking;
        this.airCondition = airCondition;
        this.balcony = balcony;
        this.fridge = fridge;
        this.kitchen = kitchen;
        this.tv = tv;
        this.smoking = smoking;
        this.pets = pets;
    }

    /**
     * getters of Room class attributes
     */
    public Integer getId() {return this.id;}
    public String getType() {return this.type;}
    public Integer getCapacity() {return this.capacity;}
    public Double getPrice() {return this.price;}
    public Integer getM2() {return this.m2;}
    public boolean getLongTime() {return this.longTime;}
    public boolean getWifi() {return this.wifi;}
    public boolean getParking() {return this.parking;}
    public boolean getAirCondition() {return this.airCondition;}
    public boolean getBalcony() {return this.balcony;}
    public boolean getFridge() {return this.fridge;}
    public boolean getKitchen() {return this.kitchen;}
    public boolean getTv() {return this.tv;}
    public boolean getSmoking() {return this.smoking;}
    public boolean getPets() {return this.pets;}

    /**
     * setters of Room class attributes
     */
    public void setId(int id) {this.id = id;}
    public void setType(String type) {this.type = type;}
    public void setLongTime(boolean longTime) {this.longTime = longTime;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
    public void setPrice(double price) {this.price=price;}
    public void setM2(int m2) {this.m2 = m2;}
    public void setWiFi(boolean wifi) {this.wifi = wifi;}
    public void setParking(boolean parking) {this.parking = parking;}
    public void setAirCondition(boolean airCondition) {this.airCondition = airCondition;}
    public void setBalcony(boolean balcony) {this.balcony = balcony;}
    public void setFridge(boolean fridge) {this.fridge = fridge;}
    public void setKitchen(boolean kitchen) {this.kitchen = kitchen;}
    public void setTv(boolean tv) {this.tv = tv;}
    public void setSmoking(boolean smoking) {this.smoking = smoking;}
    public void setPets(boolean pets) {this.pets = pets;}
}