import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MainUI {
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users; // username, class Authentication
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
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
                "Thessaloniki","hotelier",true));
        this.admins.put("admin1", new Admin("admin1", "pass1", "admin1First",
                "admin1Last", "admin1@email.com","6912345678",true));

        this.rooms.put(1,new Room(1,"hotel1", "hotel",false,2, 40, 35, true, true, true, true, true, false, true, false, false));
        this.rooms.put(2,new Room(2, "apartment1", "apartment",false,2, 80, 35, true, true, false, true, true, false, false, false, false));
        this.rooms.put(3,new Room(3, "hotel2", "hotel",false,4, 30, 35, false, true, false, true, true, false, true, false, false));
        this.rooms.put(4,new Room(4, "room1", "room",false,3, 25, 35, false, true, false, true, true, false, false, false, false));
        this.reservations.put(1,new Reservation(1,2, 3, 3, LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 7), "user2", 50));
        this.reservations.put(2,new Reservation(2,1, 3, 2, LocalDate.of(2021, 6, 15), LocalDate.of(2021, 7, 17), "user1", 40));
    }

    public void optionHandler(){
        System.out.println("\n+====================+");
        System.out.println("|     MyBooking      |");
        System.out.println("+====================+");
        int input = 0;
        boolean validInput = false;
        System.out.println("\nChoose an option:\n\n1.Login\n2.Register");
        System.out.print("\n> ");
        try {
            input = scanner.nextInt();
            if (input <= 2 && input > 0){
                validInput = true;
            }
            else {
                System.out.println("\nInvalid input, enter a valid number");
            }
        }
        catch (java.util.InputMismatchException ignored){
            System.out.println("\nInvalid input, enter a valid number");
            scanner.nextLine();
        }
        if (validInput){
            switch (input) {
                case 1 -> login();
                case 2 -> register();
            }
        }
        else {
            this.optionHandler();
        }
    }

    /**
     *   This function implements the register function by asking for username and password. If the
     *   given username is contained in the HashMap `users` the functions calls re log in method
     *   otherwise based on the role of the user{1.customer2.provider} aks for credentials.
     *
     */
    public void register() {
        System.out.println("\n+============================+");
        System.out.println("|     Registration panel     |");
        System.out.println("+============================+\n");
        int role = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Choose the account type:\n\n1. Customer\n2. Provider\n3. Admin");
            System.out.print("\n> ");
            try {
                role = scanner.nextInt();
                if (role > 0 && role <= 3) {
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input, enter a valid number\n");
                }
            } catch (java.util.InputMismatchException ignored) {
                System.out.println("\nInvalid input, enter a valid number\n");
                scanner.nextLine();
            }
        }
        String username = "";
        validInput = false;
        while (!validInput) {
            System.out.println("\nEnter a username:");
            System.out.print("\n> ");
            try {
                username = scanner.next();
                scanner.nextLine();
                if (username.matches("^[a-zA-Z0-9_]*$")) {
                    if (!users.containsKey(username)) {
                        validInput = true;
                    } else {
                        System.out.println("\nUsername already exists, choose another one");
                    }
                } else {
                    System.out.println("\nInvalid input, enter a valid username (only alphanumeric characters and underscores accepted)");
                }
            } catch (java.util.InputMismatchException ignored) {
                System.out.println("\nInvalid input, enter a valid username (only alphanumeric characters and underscores accepted)");
                scanner.nextLine();
            }
        }
        String password = "";
        validInput = false;
        while (!validInput) {
            System.out.println("\nEnter a password:");
            System.out.print("\n> ");
            try {
                password = scanner.nextLine();
                if (!Objects.equals(password, "")) {
                    validInput = true;
                }
            } catch (java.util.InputMismatchException ignored) {
                System.out.println("\nInvalid input, enter a valid password");
                scanner.nextLine();
            }
        }
        String firstName = "";
        validInput = false;
        while (!validInput) {
            System.out.println("\nEnter your first name:");
            System.out.print("\n> ");
            try {
                firstName = scanner.next();
                scanner.nextLine();
                if (firstName.matches("^[a-zA-Z]*$")) {
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input, enter a valid first name (only alpha characters accepted)");
                }
            } catch (java.util.InputMismatchException ignored) {
                System.out.println("\nInvalid input, enter a valid first name (only alpha characters accepted)");
                scanner.nextLine();
            }
        }
        String lastName = "";
        validInput = false;
        while (!validInput) {
            System.out.println("\nEnter your last name:");
            System.out.print("\n> ");
            try {
                lastName = scanner.next();
                scanner.nextLine();
                if (lastName.matches("^[a-zA-Z]*$")) {
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input, enter a valid last name (only alpha characters accepted)");
                }
            } catch (java.util.InputMismatchException ignored) {
                System.out.println("\nInvalid input, enter a valid last name (only alpha characters accepted)");
                scanner.nextLine();
            }
        }
        String email = "";
        validInput = false;
        while (!validInput) {
            System.out.println("\nEnter your email address:");
            System.out.print("\n> ");
            try {
                email = scanner.next();
                scanner.nextLine();
                if (email.matches("^(.+)@(.+)$")) {
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input, enter a valid email address");
                }
            } catch (java.util.InputMismatchException ignored) {
                System.out.println("\nInvalid input, enter a valid email address");
                scanner.nextLine();
            }
        }
        switch (role) {
            case 1 -> {      //  Customer
                String gender = "";
                int input;
                validInput = false;
                while (!validInput) {
                    System.out.println("\nChoose your gender:\n\n1. Male\n2. Female");
                    System.out.print("\n> ");
                    try {
                        input = scanner.nextInt();
                        if (input > 0 && input <= 2) {
                            validInput = true;
                            switch (input) {
                                case 1 -> gender = "male";
                                case 2 -> gender = "female";
                            }
                        } else {
                            System.out.println("\nInvalid input, enter a valid number\n");
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid number\n");
                        scanner.nextLine();
                    }
                }
                String country = "";
                validInput = false;
                while (!validInput) {
                    System.out.println("\nEnter your country:");
                    System.out.print("\n> ");
                    try {
                        country = scanner.next();
                        scanner.nextLine();
                        if (country.matches("^[a-zA-Z]*$")) {
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid input, enter a valid country (only alpha characters accepted)");
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid country (only alpha characters accepted)");
                        scanner.nextLine();
                    }
                }
                String phone = "";
                validInput = false;
                while (!validInput) {
                    System.out.println("\nEnter your phone number:");
                    System.out.print("\n> ");
                    try {
                        phone = scanner.nextLine();
                        if (phone.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid input, enter a valid phone number");
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid phone number");
                        scanner.nextLine();
                    }
                }
                LocalDate birthdate = LocalDate.of(1, 1, 1);
                validInput = false;
                while (!validInput) {
                    System.out.println("\nEnter your birthdate (dd-mm-yyyy):");
                    System.out.print("\n> ");
                    String date = scanner.next();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    try {
                        birthdate = LocalDate.parse(date, dtf);
                        validInput = true;
                    } catch (java.time.format.DateTimeParseException ignored) {
                        System.out.println("\nInvalid input, please enter a valid date");
                    }
                }
                users.put(username, new Authentication(username, password, role));
                customers.put(username, new Customer(username, email, password, firstName, lastName,
                        gender, country, phone, birthdate, false));
                System.out.println("\nRegistration successful with username: " + username);
                optionHandler();
            }
            case 2 -> {     //  Provider
                String type = "";
                int input;
                validInput = false;
                while (!validInput) {
                    System.out.println("\nChoose your type:\n\n1. Hotelier\n2. Private");
                    System.out.print("\n> ");
                    try {
                        input = scanner.nextInt();
                        if (input > 0 && input <= 2) {
                            validInput = true;
                            scanner.nextLine();
                            switch (input) {
                                case 1 -> type = "hotelier";
                                case 2 -> type = "private";
                            }
                        } else {
                            System.out.println("\nInvalid input, enter a valid type number\n");
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid type number\n");
                        scanner.nextLine();
                    }
                }
                String office = "";
                validInput = false;
                while (!validInput) {
                    System.out.println("\nEnter your office:");
                    System.out.print("\n> ");
                    try {
                        office = scanner.nextLine();
                        if (!Objects.equals(office, "")) {
                            validInput = true;
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid office address");
                        scanner.nextLine();
                    }
                }
                String country = "";
                validInput = false;
                while (!validInput) {
                    System.out.println("\nEnter your country:");
                    System.out.print("\n> ");
                    try {
                        country = scanner.next();
                        scanner.nextLine();
                        if (country.matches("^[a-zA-Z]*$")) {
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid input, enter a valid country (only alpha characters accepted)");
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid country (only alpha characters accepted)");
                        scanner.nextLine();
                    }
                }
                String region = "";
                validInput = false;
                while (!validInput) {
                    System.out.println("\nEnter your region:");
                    System.out.print("\n> ");
                    try {
                        region = scanner.next();
                        scanner.nextLine();
                        if (region.matches("^[a-zA-Z]*$")) {
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid input, enter a valid region (only alpha characters accepted)");
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid region (only alpha characters accepted)");
                        scanner.nextLine();
                    }
                }
                users.put(username, new Authentication(username, password, role));
                providers.put(username, new Provider(username, password, email, firstName, lastName,
                        office, country, region, type, false));
                System.out.println("\nRegistration successful with username: " + username);
                optionHandler();
            }
            case 3 -> {
                String phone = "";
                validInput = false;
                while (!validInput) {
                    System.out.println("\nEnter your phone number:");
                    System.out.print("\n> ");
                    try {
                        phone = scanner.nextLine();
                        if (phone.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid input, enter a valid phone number");
                        }
                    } catch (java.util.InputMismatchException ignored) {
                        System.out.println("\nInvalid input, enter a valid phone number");
                        scanner.nextLine();
                    }
                }
                users.put(username, new Authentication(username, password, role));
                admins.put(username, new Admin(username, password, firstName, lastName, email, phone, true));
                System.out.println("\nRegistration successful with username: " + username);
                optionHandler();
            }
        }
    }
    /**
     *  This function implements the login function by asking for username and password. If the
     *  given username is contained in the HashMap `users` as key it checks if the given password
     *  matches the intended one, otherwise the login fails and asks again for credentials. Based
     *  on the authenticated user role {customer, provider, admin} the appropriate user interface
     *  is initialized.
     */
    public void login(){
        System.out.println("\n+====================+");
        System.out.println("|     Login panel    |");
        System.out.println("+====================+\n");
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
                System.out.println("\nLogin failed, please try again");
                optionHandler();
            }
        }
        else {
            System.out.println("\nLogin failed, please try again");
            optionHandler();
        }
        switch (role){
            case 1 -> {
                CustomerUI customerUI = new CustomerUI(this.mainUI, this.customers.get(username), this.rooms, this.reservations);
            }
            case 2 -> {
                ProviderUI providerUI = new ProviderUI(this.mainUI, this.providers.get(username), this.rooms, this.reservations);
            }
            case 3 -> {
                AdminUI adminUI = new AdminUI(this.mainUI, this.admins.get(username),this.reservations,this.customers,this.providers,this.admins,this.rooms);
            }
            default -> System.exit(0);
        }
    }
}
