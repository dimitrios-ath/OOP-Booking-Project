import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainUI {
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users; // username, class Authentication
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
    private MainUI mainUI;
    Scanner scanner;

    public Map<Integer, Reservation> getReservations() {return reservations;}
    public Map<Integer, Room> getRooms() {return rooms;}
    public Map<String, Authentication> getUsers() {return users;}
    public Map<String, Customer> getCustomers() {return customers;}
    public Map<String, Provider> getProviders() {return providers;}
    public Map<String, Admin> getAdmins() {return admins;}
    public Map<Integer, Message> getMessages() {return messages;}
    public void setMainUI(MainUI mainUI) {
        this.mainUI = mainUI;
    }

    /**
     * Constructor of MainUI
     * Loads all serialized hashmaps from ./data/ if they exist, otherwise hashmaps are
     * initialized in memory.
     */
    @SuppressWarnings("unchecked")
    public MainUI(){
        File directory = new File("./data/");
        if (!directory.exists()){
            //noinspection ResultOfMethodCallIgnored
            directory.mkdir();
        }

        File f = new File("./data/reservations.dat");
        if(f.exists() && !f.isDirectory()) {
            try {
                InputStream file = new FileInputStream("./data/reservations.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                this.reservations = (HashMap<Integer, Reservation>) input.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {this.reservations = new HashMap<>();}

        f = new File("./data/rooms.dat");
        if(f.exists() && !f.isDirectory()) {
            try {
                InputStream file = new FileInputStream("./data/rooms.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                this.rooms = (HashMap<Integer, Room>) input.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {this.rooms = new HashMap<>();}

        f = new File("./data/users.dat");
        if(f.exists() && !f.isDirectory()) {
            try {
                InputStream file = new FileInputStream("./data/users.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                this.users = (HashMap<String, Authentication>) input.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {this.users = new HashMap<>();}

        f = new File("./data/customers.dat");
        if(f.exists() && !f.isDirectory()) {
            try {
                InputStream file = new FileInputStream("./data/customers.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                this.customers = (HashMap<String, Customer>) input.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {this.customers = new HashMap<>();}

        f = new File("./data/providers.dat");
        if(f.exists() && !f.isDirectory()) {
            try {
                InputStream file = new FileInputStream("./data/providers.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                this.providers = (HashMap<String, Provider>) input.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {this.providers = new HashMap<>();}

        f = new File("./data/admins.dat");
        if(f.exists() && !f.isDirectory()) {
            try {
                InputStream file = new FileInputStream("./data/admins.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                this.admins = (HashMap<String, Admin>) input.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {this.admins = new HashMap<>();}

        f = new File("./data/messages.dat");
        if(f.exists() && !f.isDirectory()) {
            try {
                InputStream file = new FileInputStream("./data/messages.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                this.messages = (HashMap<Integer, Message>) input.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
                }
        } else {this.messages = new HashMap<>();}

        scanner = new Scanner(System.in);

        // First time initialization
        this.users.put("user1", new Authentication("user1","pass1",1));
        this.users.put("user2", new Authentication("user2","pass2",1));
        this.users.put("provider1", new Authentication("provider1","pass1",2));
        this.users.put("admin1", new Authentication("admin1","pass1",3));
        this.customers.put("user1", new Customer("user1","user1@mail.com","pass1",
                "user1First","user1Last","male","Greece","6912345678",
                LocalDate.of(1990, 1, 5),false));
        this.customers.put("user2", new Customer("user2","user2@mail.com","pass2",
                "user2First","user2Last","female","Germany","6912345678",
                LocalDate.of(2000, 5,2),false));
        this.providers.put("provider1", new Provider("provider1","pass1","provider1@email.com",
                "provider1First","provider1Last","Street 123","Greece",
                "Thessaloniki","hotelier",true));
        this.admins.put("admin1", new Admin("admin1", "pass1", "admin1First",
                "admin1Last", "admin1@email.com","6912345678",true));

        this.rooms.put(1,new Room(1, "provider1", "hotel1", "hotel",false,2, 40, 35, true, true, true, true, true, false, true, false, false));
        this.rooms.put(2,new Room(2, "provider1","apartment1", "apartment",false,2, 80, 35, true, true, false, true, true, false, false, false, false));
        this.rooms.put(3,new Room(3, "provider1", "hotel2", "hotel",false,4, 30, 35, false, true, false, true, true, false, true, false, false));
        this.rooms.put(4,new Room(4, "provider1","room1", "room",false,3, 25, 35, false, true, false, true, true, false, false, false, false));
        this.reservations.put(1,new Reservation(1,2, 3, 3, LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 7), "user2", 50));
        this.reservations.put(2,new Reservation(2,1, 3, 2, LocalDate.of(2021, 6, 15), LocalDate.of(2021, 7, 17), "user1", 40));
        this.reservations.put(3,new Reservation(3,1, 1, 2, LocalDate.of(2021, 6, 1), LocalDate.of(2021, 7, 2), "user1", 40));

    }

    public void optionHandlerGUI() {
        JFrame jframe = new JFrame("myBooking");
        jframe.setPreferredSize(new Dimension(700, 700));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.setResizable(false);
        jframe.add(loginForm);
        jframe.setVisible(true);
    }

    public void saveAndExit(){
        try (FileOutputStream fos = new FileOutputStream("./data/reservations.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.reservations);
        } catch (IOException ignored) {}
        try (FileOutputStream fos = new FileOutputStream("./data/rooms.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.rooms);
        } catch (IOException ignored) {}
        try (FileOutputStream fos = new FileOutputStream("./data/users.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.users);
        } catch (IOException ignored) {}
        try (FileOutputStream fos = new FileOutputStream("./data/customers.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.customers);
        } catch (IOException ignored) {}
        try (FileOutputStream fos = new FileOutputStream("./data/providers.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.providers);
        } catch (IOException ignored) {}
        try (FileOutputStream fos = new FileOutputStream("./data/admins.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.admins);
        } catch (IOException ignored) {}
        try (FileOutputStream fos = new FileOutputStream("./data/messages.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.messages);
        } catch (IOException ignored) {}
        System.exit(0);
    }
}
