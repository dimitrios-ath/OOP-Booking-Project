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

    /**
     *   This function implements the register function by asking for username and password. If the
     *   given username is contained in the HashMap `users` the functions calls re log in method
     *   otherwise based on the role of the user{1.customer2.provider} aks for credentials.
     *
     */
    public void register() {

        System.out.print("1.Register\n2.Log in");
        System.out.print("\n> ");
        int input;
        input=scanner.nextInt();

        if (input==2){
            login();
        }
        else {
            System.out.println("\n+============================+");
            System.out.println("|    Registration panel      |");
            System.out.println("+============================+");


            int role = 0;
            System.out.print("Enter your username: ");
            String usernametoEntry = scanner.next();
            String passwordtoEntry = " ";
            boolean validInput = false;
            while (!validInput) {
                for (Map.Entry<String, Authentication> entry : this.users.entrySet()) {
                    Authentication value = entry.getValue();
                    if (!Objects.equals(usernametoEntry, value.getUsername())) {
                        validInput = true;
                        System.out.print("Enter your password: ");
                        passwordtoEntry = scanner.next();
                        break;
                    } else {
                        System.out.println("This username: " + usernametoEntry + "is already exists, please try again");
                        register();
                    }
                }
            }
            validInput = false;
            while (!validInput) {
                System.out.print("Enter your role:\n1.Customer\n2.Provicer\n3.Admin");
                System.out.print("\n>");
                role = scanner.nextInt();
                if (role == 1 || role == 2 || role == 3) {
                    validInput = true;
                    this.users.put(usernametoEntry, new Authentication(usernametoEntry, passwordtoEntry, role));
                } else {
                    System.out.println("\nInvalid input,enter a valid number:");
                }
            }
            switch (role) {
                case 1 -> {
                    String username;
                    String email=null;
                    String password;
                    String firstName=null;
                    String lastName=null;
                    String gender=null;
                    String country=null;
                    String phone=null;
                    LocalDate birthdate =null;
                    username = usernametoEntry;
                    password = passwordtoEntry;
                    validInput = false;
                    String nameFirst;
                    while (!validInput){
                        System.out.println("Enter your First Name: ");
                        System.out.print("\n> ");
                        nameFirst = scanner.next();
                        try {
                            if (nameFirst.matches("[a-zA-Z]+")){
                                firstName=nameFirst;
                                validInput = true;
                            }
                            else {
                                System.out.println("\nInvalid input, enter a valid name");
                            }
                        }
                        catch (InputMismatchException ignored){
                            System.out.println("\nInvalid input, enter a valid name");
                            scanner.nextLine();
                        }
                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your Last Name: ");
                        System.out.print("\n> ");
                        String name = " ";
                        try {
                            name = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (name.matches("[a-zA-Z]+")) {
                            lastName = name;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your email: ");
                        System.out.print("\n> ");
                        String emailto;
                        emailto = " ";
                        try {
                            emailto = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (emailto.contains("@mail.com")) {
                            email = emailto;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid email");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your gender: ");
                        System.out.print("\n1.Male\n2.Female");
                        System.out.print("\n> ");
                        int genderto = 0;
                        try {
                            genderto = scanner.nextInt();
                        } catch (InputMismatchException ignored) {
                        }
                        if ((genderto == 1 || genderto == 2)) {
                            if (genderto == 1)
                                gender = "Male";
                            else
                                gender = "Female";
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid gender");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your country: ");
                        System.out.print("\n> ");
                        String countryto = null;
                        try {
                            countryto = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        assert countryto != null;
                        if (countryto.matches("[a-zA-Z]+")) {
                            country = countryto;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your phone: ");
                        System.out.print("\n> ");
                        String phoneto = " ";
                        try {
                            phoneto = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (phoneto.matches("[0-9]+")) {
                            phone = phoneto;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        System.out.print("\nEnter your birthdate: ");
                        System.out.print("\n> ");
                        String date = scanner.next();
                        try {
                            birthdate = LocalDate.parse(date, dtf);
                            validInput = true;
                        } catch (DateTimeParseException ignored) {
                            System.out.println("\nInvalid input, please enter a valid date");
                        }
                    }
                    System.out.println("Registration successful, welcome" +" " +firstName + "!");
                    this.customers.put(username, new Customer(username, email, password, firstName, lastName, gender, country, phone, birthdate, false));
                    CustomerUI customerUI = new CustomerUI(this.mainUI, this.customers.get(username), this.rooms, this.reservations);
                }
                case 2 -> {
                    String firstName =null;
                    String lastName = null;
                    String email =null;
                    String username;
                    String password;
                    String office = null;
                    String country = null;
                    String region = null;
                    String type = null;
                    username = usernametoEntry;
                    password = passwordtoEntry;
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your first Name: ");
                        System.out.print("\n> ");
                        firstName=scanner.next();
                        if (firstName.matches("[a-zA-Z]+")) {
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your last Name: ");
                        System.out.print("\n> ");
                        String namelast = " ";
                        namelast = scanner.next();

                        if (namelast.matches("[a-zA-Z]+")) {
                            firstName = namelast;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }
                    }


                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your email: ");
                        System.out.print("\n> ");
                        String emailto;
                        emailto = " ";
                        try {
                            emailto = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (emailto.contains("@mail.com")) {
                            email = emailto;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid email");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your country: ");
                        System.out.print("\n> ");
                        String countryto = null;
                        try {
                            countryto = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (countryto.matches("[a-zA-Z]+")) {
                            country = countryto;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your office: ");
                        System.out.print("\n> ");
                        String officeto = null;
                        try {
                            officeto = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (officeto.matches("[a-zA-Z]+") ) {
                            office = officeto;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your region: ");
                        System.out.print("\n> ");
                        String regionto = null;
                        try {
                            regionto = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (regionto.matches("[a-zA-Z]+")) {
                            region = regionto;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your type: ");
                        System.out.print("\n1.Hotelier\n2.Roomer\n3.Apartmenter");
                        System.out.print("\n> ");
                        int typeto = 0;
                        try {
                            typeto = scanner.nextInt();
                        } catch (InputMismatchException ignored) {
                        }
                        if ((typeto == 1 || typeto == 2 || typeto == 3)) {
                            if (typeto == 1)
                                type = "Hotelier";
                            else if (typeto == 2)
                                type = "Roomer";
                            else
                                type = "Apartmenter";

                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid gender");
                        }

                    }
                    System.out.println("Registration successful, welcome  " + firstName + "!");
                    this.providers.put(username, new Provider(username, password, email, firstName, lastName, office, country, region, type,false));
                    ProviderUI providerUI = new ProviderUI(this.mainUI, this.providers.get(username), this.rooms, this.reservations);


                }
            case 3->{
                    String username;
                    String firstName = null;
                    String lastName=null;
                    String password;
                    String email=null;
                    String phone=null;
                    username=usernametoEntry;
                    password=passwordtoEntry;
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your first Name: ");
                        System.out.print("\n> ");
                        firstName=scanner.next();
                        if (firstName.matches("[a-zA-Z]+")) {
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your last Name: ");
                        System.out.print("\n> ");
                        String namelast;
                        namelast = scanner.next();

                        if (namelast.matches("[a-zA-Z]+")) {
                            firstName = namelast;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }
                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your email: ");
                        System.out.print("\n> ");
                        String adminemail;
                        adminemail = " ";
                        try {
                            adminemail = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (adminemail.contains("@mail.com")) {
                            email = adminemail;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid email");
                        }
                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.print("\nEnter your phone: ");
                        System.out.print("\n> ");
                        String adminPhone = " ";
                        try {
                            adminPhone = scanner.next();
                        } catch (InputMismatchException ignored) {
                        }
                        if (adminPhone.matches("[0-9]+")) {
                            phone = adminPhone;
                            validInput = true;
                        } else {
                            System.out.println("\nInvalid Input, enter a valid name");
                        }

                    }

                System.out.println("Registration successful, welcome  " + firstName + "!");
                this.admins.put(username, new Admin(username, firstName,lastName,password,email,phone,false));
                AdminUI adminUI = new AdminUI(this.mainUI, this.admins.get(username),this.reservations,this.customers,this.providers,this.admins,this.rooms);

                }
                default -> System.exit(0);



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
        System.out.println("\n+============================+");
        System.out.println("|         Log in  panel      |");
        System.out.println("+============================+");
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
                AdminUI adminUI = new AdminUI(this.mainUI, this.admins.get(username),this.reservations,this.customers,this.providers,this.admins,this.rooms);
            }
            default -> System.exit(0);
        }
    }


}
