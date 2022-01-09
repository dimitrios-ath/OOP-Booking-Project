import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class customerTests {
    private Customer customer;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<Integer,Message> messages;

    @BeforeEach
    void setUp() {
        MainUI ui = new MainUI();
        ui.setMainUI(ui);
        this.reservations = ui.getReservations();
        this.rooms = ui.getRooms();
        this.users = ui.getUsers();
        this.customers = ui.getCustomers();
        this.messages = ui.getMessages();
        this.users.put("testCustomer", new Authentication("testCustomer","pass",1));
        this.customers.put("testCustomer", new Customer("testCustomer","test@mail.com","pass",
                "test","test","male","Greece","6912345678",
                LocalDate.of(2000, 1, 1),false));
        this.rooms.put(1,new Room(1, "testProvider", "test", "hotel",true,2, 40,
                35, true, true, true, true, true, false, true, false, false));
        this.customer = this.customers.get("testCustomer");
        reservations.put(1, new Reservation(1, 1, 2, 1,
                LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 3), this.customer.getUsername(),
                this.rooms.get(1).getPrice()*2));

    }

    @Test
    void testRegister() {
        // Register customer "testNewCustomer:pass"
        this.users.put("testNewCustomer", new Authentication("testNewCustomer","pass",1));
        this.customers.put("testNewCustomer", new Customer("testNewCustomer","test@mail.com","pass",
                "test","test","male","Greece","6912345678",
                LocalDate.of(2000, 1, 1),false));
        assertTrue(this.users.containsKey("testNewCustomer") && this.customers.containsKey("testNewCustomer"));
    }

    @Test
    void testLogin() {
        // Login as "testCustomer:pass"
        assertTrue(this.users.containsKey("testCustomer") && "pass".equals(this.users.get("testCustomer").getPassword())
                && this.users.get("testCustomer").getRole() != 0);
    }

    @Test
    void testReserveRoom() {
        reservations.put(2, new Reservation(2, 1, 2, 1,
                LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3), this.customer.getUsername(),
                this.rooms.get(1).getPrice()*2));
        assertTrue(this.reservations.containsKey(2));
    }

    @Test
    void testCancelReservation() {
        reservations.put(3, new Reservation(3, 1, 2, 1,
                LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 3), this.customer.getUsername(),
                this.rooms.get(1).getPrice()*2));
        if (reservations.containsKey(3) && Objects.equals(reservations.get(3).getUsername(),customer.getUsername())) {
            reservations.remove(3);
            assertFalse(reservations.containsKey(3));
        }
    }

    @Test
    void testShowReservations() {
        DecimalFormat df;
        df = new DecimalFormat("0.00");
        reservations.forEach((id,reservation)-> {
        if (Objects.equals(reservation.getUsername(),this.customer.getUsername())){
            assertEquals("Reservation ID: 1, Guest number: 1, Total nights: 2, Room id: 1, " +
                    "Room name: \"test\", Check in: 2022-03-01, Check out: 2022-03-03, Price/night: $40.00, " +
                    "Total cost: $80.00", ("Reservation ID: " + reservation.getReservationID()
                    + ", Guest number: " + reservation.getGuestNumber() + ", Total nights: " + reservation.getTotalNights() +
                    ", Room id: " + reservation.getRoomID() + ", Room name: \"" + this.rooms.get(reservation.getRoomID()).getName() +
                    "\", Check in: " + reservation.getCheckIn() + ", Check out: " + reservation.getCheckOut() + ", Price/night: $" +
                    df.format(reservation.getTotalPrice() / reservation.getTotalNights()) + ", Total cost: $" +
                    df.format(reservation.getTotalPrice())));
        }});
    }

    @Test
    void testNewMessage() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!messages.containsKey(i)) {
                messages.put(i, new Message(i, this.customer.getUsername(), this.customer.getUsername(), "Test message", false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        assertTrue(messages.containsKey(i));
    }

    @Test
    void testInbox() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!messages.containsKey(i)) {
                messages.put(i, new Message(i, this.customer.getUsername(), this.customer.getUsername(), "Test message", false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        assertEquals("Test message", messages.get(i).getContent());
    }
}