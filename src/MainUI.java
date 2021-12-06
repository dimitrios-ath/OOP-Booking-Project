import java.time.LocalDate;
import java.util.*;

public class MainUI {
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users; // username, class Authentication
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private MainUI mainUI;
    Scanner scanner;

    public void setMainUI(MainUI mainUI) {
        this.mainUI = mainUI;
    }

    /**
     * Constructor of MainUI
     * This constructor initializes all the different HashMaps and some users in memory.
     * Then it calls the login function
     */
    public MainUI(){
        this.reservations = new HashMap<>();
        this.rooms = new HashMap<>();
        this.users = new HashMap<>();
        this.customers = new HashMap<>();
        this.providers = new HashMap<>();
        this.admins = new HashMap<>();
        scanner = new Scanner(System.in);

        /*
            Create some users with the following credentials:
            
               +-----------+----------+---------------+
               | username  | password |     role      |
               +-----------+----------+---------------+
               | user1     | pass1    | customer      |
               | user2     | pass2    | customer      |
               | provider1 | pass1    | provider      |
               | admin1    | pass1    | administrator |
               +-----------+----------+---------------+
         */

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
        this.admins.put("admin1", new Admin("admin1", "pass1", "admin1First",
                "admin1Last", "admin1@email.com","6912345678"));

        this.rooms.put(1,new Room(1,"hotel1", "hotel",false,2, 40, 35, true, true, true, true, true, false, true, false, false));
        this.rooms.put(2,new Room(2, "apartment1", "apartment",false,2, 80, 35, true, true, false, true, true, false, false, false, false));
        this.rooms.put(3,new Room(3, "hotel2", "hotel",false,4, 30, 35, false, true, false, true, true, false, true, false, false));
        this.rooms.put(4,new Room(4, "room1", "room",false,3, 25, 35, false, true, false, true, true, false, false, false, false));
        this.reservations.put(1,new Reservation(1,2, 3, 3, LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 7), "user2", 50));
        this.reservations.put(2,new Reservation(2,1, 3, 2, LocalDate.of(2021, 6, 15), LocalDate.of(2021, 7, 17), "user1", 40));
    }

    /**
     *  This function implements the login function by asking for username and password. If the
     *  given username is contained in the HashMap `users` as key it checks if the given password
     *  matches the intended one, otherwise the login fails and asks again for credentials. Based
     *  on the authenticated user role {customer, provider, admin} the appropriate user interface
     *  is initialized.
     */
    public void login(){
        int role = 0;
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        if (this.users.containsKey(username)) {
            Authentication temp = this.users.get(username);
            if (password.equals(temp.getPassword())){
                System.out.println("\nLogin successful, welcome " + temp.getUsername() + "!");
                role = temp.getRole();
            }
            else {
                System.out.println("Login failed, please try again");
                login();
            }
        }
        else {
            System.out.println("Login failed, please try again");
            login();
        }
        switch (role){
            case 1 -> {
                CustomerUI customerUI = new CustomerUI(this.mainUI, this.customers.get(username), this.rooms, this.reservations);
            }
            case 2 -> {
                ProviderUI providerUI = new ProviderUI(this.mainUI, this.providers.get(username), this.rooms, this.reservations);
            }
            case 3 -> {
                AdminUI adminUI = new AdminUI(this.mainUI, this.admins.get(username),this.reservations,this.customers,this.providers,this.admins,this.users,this.rooms);
            }
            default -> System.exit(0);
        }
    }
}
