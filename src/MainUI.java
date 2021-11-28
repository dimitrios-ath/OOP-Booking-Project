import java.time.LocalDate;
import java.util.*;

public class MainUI {
    public HashSet<Reservation> reservations;
    public HashSet<Room> rooms;
    public Map<String,Authentication> users;
    public Map<String,Customer> customers;
    public Map<String,Provider> providers;
    public Map<String,Admin> admins;
    Scanner scanner;

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }
    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public MainUI(){
        this.reservations = new HashSet<>();    // replace with files
        this.rooms = new HashSet<>();           // replace with files
        this.users = new HashMap<>();           // replace with files
        this.customers = new HashMap<>();           // replace with files
        this.providers = new HashMap<>();           // replace with files
        this.admins = new HashMap<>();           // replace with files
        scanner = new Scanner(System.in);       // scan for mode

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
                "Thessaloniki","hotelier"));
        this.admins.put("admin1", new Admin("admin1", "pass1", "admin1First", "admin1Last",
                "admin1@email.com","6912345678"));

        start();
    }

    public void start(){
        int role = 0;
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        if (this.users.containsKey(username)) {
            Authentication temp = this.users.get(username);
            if (password.equals(temp.getPassword())){
                System.out.println("Login successful as " + temp.getUsername());
                role = temp.getRole();
            }
            else {
                System.out.println("Login failed, try again");
                start();
            }
        }
        else {
            System.out.println("Login failed, try again");
            start();
        }
        switch (role){
            case 1:
                CustomerUI customerUI = new CustomerUI(this.customers.get(username));
            case 2:
                ProviderUI providerUI = new ProviderUI(this.providers.get(username));
            case 3:
                AdminUI adminUI = new AdminUI(this.admins.get(username));
            default:
                System.exit(0);
        }
    }

}
