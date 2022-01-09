import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class providerTests {
    private Provider provider;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<Integer,Message> messages;

    @BeforeEach
    void setUp() {
        MainUI ui = new MainUI();
        ui.setMainUI(ui);
        this.reservations = ui.getReservations();
        this.rooms = ui.getRooms();
        this.users = ui.getUsers();
        this.customers = ui.getCustomers();
        this.providers = ui.getProviders();
        this.messages = ui.getMessages();
        this.users.put("testProvider", new Authentication("testProvider","pass",2));
        this.providers.put("testProvider", new Provider("testProvider","pass","test@mail.com",
                "test","test","Street 123","Greece", "Thessaloniki","hotelier",true));
        this.users.put("testCustomer", new Authentication("testCustomer","pass",1));
        this.customers.put("testCustomer", new Customer("testCustomer","test@mail.com","pass",
                "test","test","male","Greece","6912345678",
                LocalDate.of(2000, 1, 1),false));
        this.rooms.put(1,new Room(1, "testProvider", "test", "hotel",true,2, 40,
                35, true, true, true, true, true, false, true, false, false));
        this.provider = this.providers.get("testProvider");
        reservations.put(1, new Reservation(1, 1, 2, 1,
                LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 3), "testCustomer",
                this.rooms.get(1).getPrice()*2));

    }

    @Test
    void testRegister() {
        // Register customer "testNewProvider:pass"
        this.users.put("testNewProvider", new Authentication("testNewProvider","pass",2));
        this.providers.put("testNewProvider", new Provider("testNewProvider","pass","test@mail.com",
                "test","test","Street 123","Greece", "Thessaloniki","hotelier",true));
        assertTrue(this.users.containsKey("testNewProvider") && this.providers.containsKey("testNewProvider"));
    }

    @Test
    void testLogin() {
        // Login as "testProvider:pass"
        assertTrue(this.users.containsKey("testProvider") && "pass".equals(this.users.get("testProvider").getPassword())
                && this.users.get("testProvider").getRole() != 0);
    }

    @Test
    void testAddRoom() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!rooms.containsKey(i)) {
                rooms.put(i, new Room(i, provider.getUsername(), "testNewRoom", "hotel",true,2, 40,
                        35, true, true, true, true, true, false, true, false, false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        assertTrue(this.rooms.containsKey(i) && Objects.equals(this.rooms.get(i).getOwner(), this.provider.getUsername()));
    }

    @Test
    void testEditRoom() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!rooms.containsKey(i)) {
                rooms.put(i, new Room(i, provider.getUsername(), "testNewRoom", "hotel",true,2, 40,
                        35, true, true, true, true, true, false, true, false, false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        rooms.put(i, new Room(i, provider.getUsername(), "testNewEditedRoom", "hotel",true,2, 40,
                35, true, true, true, true, true, false, true, false, false));
        assertTrue(this.rooms.containsKey(i) && Objects.equals(this.rooms.get(i).getOwner(), this.provider.getUsername())
                && Objects.equals(this.rooms.get(i).getName(), "testNewEditedRoom"));
    }

    @Test
    void testDeleteRoom() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!rooms.containsKey(i)) {
                rooms.put(i, new Room(i, provider.getUsername(), "testNewRoom", "hotel",true,2, 40,
                        35, true, true, true, true, true, false, true, false, false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        if (rooms.containsKey(i) && Objects.equals(rooms.get(i).getOwner(), provider.getUsername())) {
            rooms.remove(i);
        }
        assertFalse(this.rooms.containsKey(i));
    }

    @Test
    void testShowRooms() {
        DecimalFormat df;
        df = new DecimalFormat("0.00");
        rooms.forEach((id,room)-> {
            if (Objects.equals(room.getOwner(), this.provider.getUsername())){
                assertEquals("Name: \"test\", type: hotel, capacity: 2, price: $40.00",
                        "Name: \"" + rooms.get(id).getName() +
                        "\", type: " + rooms.get(id).getType() + ", capacity: " +
                        rooms.get(id).getCapacity().toString()+ ", price: $" +
                        df.format(rooms.get(id).getPrice()));
            }});
    }

    @Test
    void testShowReservations() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!rooms.containsKey(i)) {
                rooms.put(i, new Room(i, provider.getUsername(), "testNewRoom", "hotel",true,2, 40,
                        35, true, true, true, true, true, false, true, false, false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        addedToHashMap = false;
        i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!reservations.containsKey(i)) {
                reservations.put(i, new Reservation(i, 1, 2, i,
                        LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 3), "testCustomer",
                        this.rooms.get(1).getPrice()*2));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        DecimalFormat df;
        df = new DecimalFormat("0.00");
        int finalI = i;
        reservations.forEach((id, reservation)-> {
            if (Objects.equals(id, finalI)){
                assertEquals("Reservation ID: "+finalI+", Username: \"testCustomer\", Guests: 1, Check in: 01-03-2022, " +
                        "Check out: 03-03-2022, Total price: $80.00", "Reservation ID: " + reservation.getReservationID() + ", Username: \""
                        + reservation.getUsername() + "\", Guests: " + reservation.getGuestNumber() + ", Check in: "
                        + reservation.getCheckIn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Check out: " + reservation.getCheckOut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Total price: $" + df.format((reservation.getTotalPrice())));
            }});
    }

    @Test
    void testNewMessage() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!messages.containsKey(i)) {
                messages.put(i, new Message(i, this.provider.getUsername(), this.provider.getUsername(), "Test message", false));
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
                messages.put(i, new Message(i, this.provider.getUsername(), this.provider.getUsername(), "Test message", false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        assertEquals("Test message", messages.get(i).getContent());
    }
}