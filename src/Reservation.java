import java.lang.String;
import java.util.Date;

public class Reservation {
    private int reservationID;
    private int guestNumber;
    private int totalNights;
    private Date checkIn;
    private Date checkOut;
    private String paymentType;
    private String username;
    private double amountPaid;
    private double totalPrice;
    private boolean breakfast;
    private boolean pets;

    /**
     * Constructor of Reservation
     * @param reservationID          unique reservation identifier
     * @param guestNumber            number of guests
     * @param totalNights            total nights
     * @param checkIn                check in date
     * @param checkOut               check out date
     * @param paymentType            payment type {cash/card}
     * @param username               unique username of the customer
     * @param amountPaid             amount already paid
     * @param totalPrice             total reservation cost
     * @param breakfast              with breakfast {true/false}
     * @param pets                   pets allowed {true/false}
     */
    public Reservation(int reservationID, int guestNumber,
                       int totalNights, Date checkIn, Date checkOut,
                       String paymentType, String username, double amountPaid,
                       double totalPrice, boolean breakfast,
                       boolean pets) {
        this.reservationID = reservationID;
        this.guestNumber = guestNumber;
        this.totalNights = totalNights;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.paymentType = paymentType;
        this.username = username;
        this.amountPaid = amountPaid;
        this.totalPrice = totalPrice;
        this.breakfast = breakfast;
        this.pets = pets;
    }

    /**
     * getters of Reservation class attributes
     */
    public int getReservationID() {return this.reservationID;}
    public int getGuestNumber() {return this.guestNumber;}
    public int getTotalNights() {return this.totalNights;}
    public Date getCheckIn() {return this.checkIn;}
    public Date getCheckOut() {return this.checkOut;}
    public String getPaymentType() {return this.paymentType;}
    public String getUsername() {return this.username;}
    public double getAmountPaid() {return this.amountPaid;}
    public double getTotalPrice() {return this.totalPrice;}
    public boolean getBreakfast() {return this.breakfast;}
    public boolean getPets() {return this.pets;}

    /**
     * setters of Reservation class attributes
     */
    public void setReservationID(int reservationID) {this.reservationID = reservationID;}
    public void setGuestNumber(int guestNumber) {this.guestNumber = guestNumber;}
    public void setTotalNights(int totalNights) {this.totalNights = totalNights;}
    public void setCheckIn(Date checkIn) {this.checkIn = checkIn;}
    public void setCheckOut(Date checkOut) {this.checkOut = checkOut;}
    public void setPaymentType(String paymentType) {this.paymentType = paymentType;}
    public void setUsername(String username) {this.username = username;}
    public void setAmountPaid(double amountPaid) {this.amountPaid = amountPaid;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
    public void setBreakfast(boolean breakfast) {this.breakfast = breakfast;}
    public void setPets(boolean pets) {this.pets = pets;}
}
