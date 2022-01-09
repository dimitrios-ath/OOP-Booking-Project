import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class adminTests {
    private Admin admin;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
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
        this.admins = ui.getAdmins();
        this.messages = ui.getMessages();
        this.users.put("testAdmin", new Authentication("testAdmin","pass",3));
        this.admins.put("testAdmin", new Admin("testAdmin", "pass", "test",
                "test", "test@mail.com","6912345678",true));
        this.users.put("testCustomer", new Authentication("testCustomer","pass",1));
        this.customers.put("testCustomer", new Customer("testCustomer","test@mail.com","pass",
                "test","test","male","Greece","6912345678",
                LocalDate.of(2000, 1, 1),false));
        this.users.put("testProvider", new Authentication("testProvider","pass",2));
        this.providers.put("testProvider", new Provider("testProvider","pass","test@mail.com",
                "test","test","Street 123","Greece", "Thessaloniki","hotelier",true));
        this.rooms.put(1,new Room(1, "testProvider", "test", "hotel",true,2, 40,
                35, true, true, true, true, true, false, true, false, false));
        this.admin = this.admins.get("testAdmin");
        reservations.put(1, new Reservation(1, 1, 2, 1,
                LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 3), "testCustomer",
                this.rooms.get(1).getPrice()*2));

    }

    @Test
    void testLogin() {
        // Login as "testAdmin:pass"
        assertTrue(this.users.containsKey("testAdmin") && "pass".equals(this.users.get("testAdmin").getPassword())
                && this.users.get("testAdmin").getRole() != 0);
    }

    @Test
    void testSearchReservations() {
        reservations.forEach((id,reservation) -> {
            if (Objects.equals(reservation.getUsername(), "testCustomer")) {
                assertEquals("testCustomer", reservation.getUsername());
            }
        });
    }

    @Test
    void testSearchUser() {
        users.forEach((username,user) -> {
            if (Objects.equals(user.getUsername(), "testCustomer")) {
                assertEquals("testCustomer", user.getUsername());
            }
        });
    }

    @Test
    void testChangeState() {
        customers.forEach((username,customer) -> {
            if (!customer.getActiveAccount()) {
                customer.setActiveAccount(true);
                assertTrue(customer.getActiveAccount());
            }
        });
    }

    @Test
    void testNewMessage() {
        boolean addedToHashMap = false;
        int i = 1;
        while (!addedToHashMap && i < 1000) {
            if (!messages.containsKey(i)) {
                messages.put(i, new Message(i, this.admin.getUsername(), this.admin.getUsername(), "Test message", false));
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
                messages.put(i, new Message(i, this.admin.getUsername(), this.admin.getUsername(), "Test message", false));
                addedToHashMap = true;
            } else {
                i++;
            }
        }
        assertEquals("Test message", messages.get(i).getContent());
    }
}