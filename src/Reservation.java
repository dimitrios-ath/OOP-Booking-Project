import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;

public class Reservation implements Serializable {
    private int reservationID;
    private int guestNumber;
    private long totalNights;
    private int roomID;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String username;
    private double totalPrice;

    /**
     * Constructor of Reservation
     * @param reservationID          unique reservation identifier
     * @param guestNumber            number of guests
     * @param totalNights            total nights
     * @param checkIn                check in date
     * @param checkOut               check out date
     * @param username               unique username of the customer
     * @param totalPrice             total reservation cost
     */
    public Reservation(int reservationID, int guestNumber,
                       long totalNights, int roomID, LocalDate checkIn,
                       LocalDate checkOut, String username,
                       double totalPrice) {
        this.reservationID = reservationID;
        this.guestNumber = guestNumber;
        this.totalNights = totalNights;
        this.roomID = roomID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.username = username;
        this.totalPrice = totalPrice;
    }

    /**
     * getters of Reservation class attributes
     */
    public int getReservationID() {return this.reservationID;}
    public int getGuestNumber() {return this.guestNumber;}
    public long getTotalNights() {return this.totalNights;}
    public int getRoomID() {return this.roomID;}
    public LocalDate getCheckIn() {return this.checkIn;}
    public LocalDate getCheckOut() {return this.checkOut;}
    public String getUsername() {return this.username;}
    public double getTotalPrice() {return this.totalPrice;}

    /**
     * setters of Reservation class attributes
     */
    public void setReservationID(int reservationID) {this.reservationID = reservationID;}
    public void setGuestNumber(int guestNumber) {this.guestNumber = guestNumber;}
    public void setTotalNights(long totalNights) {this.totalNights = totalNights;}
    public void setRoomID(int roomID) {this.roomID = roomID;}
    public void setCheckIn(LocalDate checkIn) {this.checkIn = checkIn;}
    public void setCheckOut(LocalDate checkOut) {this.checkOut = checkOut;}
    public void setUsername(String username) {this.username = username;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
}
