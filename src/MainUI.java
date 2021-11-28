import java.time.LocalDate;
import java.util.*;

public class MainUI {
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users; // username, class Authentication
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    Scanner scanner;

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

        login();
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
                CustomerUI customerUI = new CustomerUI(this.customers.get(username), this.rooms);
            }
            case 2 -> {
                ProviderUI providerUI = new ProviderUI(this.providers.get(username), this.rooms);
            }
            case 3 -> {
                AdminUI adminUI = new AdminUI(this.admins.get(username));
            }
            default -> System.exit(0);
        }
    }

}
