import java.lang.String;
import java.time.LocalDate;

public class Reservation {
    private int reservationID;
    private int roomdID;
    private int guestNumber;
    private int totalNights;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String username;
    private double amountPaid;
    private double totalPrice;
    private boolean breakfast;


    /**
     * Constructor of Reservation
     * @param reservationID          unique reservation identifier
     * @param guestNumber            number of guests
     * @param totalNights            total nights
     * @param checkIn                check in date
     * @param checkOut               check out date
     * @param username               unique username of the customer
     * @param amountPaid             amount already paid
     * @param totalPrice             total reservation cost
     * @param breakfast              with breakfast {true/false}
     */
    public Reservation(int reservationID,int roomdID,int guestNumber,
                       int totalNights, LocalDate checkIn, LocalDate checkOut,
                       String username, double amountPaid,
                       double totalPrice, boolean breakfast) {
        this.reservationID = reservationID;
        this.roomdID=roomdID;
        this.guestNumber = guestNumber;
        this.totalNights = totalNights;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.username = username;
        this.amountPaid = amountPaid;
        this.totalPrice = totalPrice;
        this.breakfast = breakfast;
    }

    /**
     * getters of Reservation class attributes
     */
    public int getReservationID() {return this.reservationID;}
    public int getRoomdID() {return this.roomdID;}
    public int getGuestNumber() {return this.guestNumber;}
    public int getTotalNights() {return this.totalNights;}
    public LocalDate getCheckIn() {return this.checkIn;}
    public LocalDate getCheckOut() {return this.checkOut;}
    public String getUsername() {return this.username;}
    public double getAmountPaid() {return this.amountPaid;}
    public double getTotalPrice() {return this.totalPrice;}
    public boolean getBreakfast() {return this.breakfast;}


    /**
     * setters of Reservation class attributes
     */
    public void setReservationID(int reservationID) {this.reservationID = reservationID;}
    public void setRoomdID(int roomdID) {this.roomdID=roomdID;}
    public void setGuestNumber(int guestNumber) {this.guestNumber = guestNumber;}
    public void setTotalNights(int totalNights) {this.totalNights = totalNights;}
    public void setCheckIn(LocalDate checkIn) {this.checkIn = checkIn;}
    public void setCheckOut(LocalDate checkOut) {this.checkOut = checkOut;}
    public void setUsername(String username) {this.username = username;}
    public void setAmountPaid(double amountPaid) {this.amountPaid = amountPaid;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
    public void setBreakfast(boolean breakfast) {this.breakfast = breakfast;}
}
