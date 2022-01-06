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

    }

    public void optionHandlerGUI() {
        JFrame jframe = new JFrame("myBooking");
        jframe.setPreferredSize(new Dimension(700, 700));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.add(loginForm);
        jframe.setVisible(true);
    }

    public void optionHandler(){
        System.out.println("\n+====================+");
        System.out.println("|     MyBooking      |");
        System.out.println("+====================+");
        int input = 0;
        boolean validInput = false;
        System.out.println("\nChoose an option:\n\n1. Login\n2. Register\n3. Exit");
        System.out.print("\n> ");
        try {
            input = scanner.nextInt();
            if (input <= 3 && input > 0){
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
                case 3 -> saveAndExit();
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
                CustomerUI customerUI = new CustomerUI(this.mainUI, this.customers.get(username), this.rooms,
                        this.reservations, this.messages, this.users);
            }
            case 2 -> {
                ProviderUI providerUI = new ProviderUI(this.mainUI, this.providers.get(username), this.rooms,
                        this.reservations, this.messages, this.users);
            }
            case 3 -> {
                AdminUI adminUI = new AdminUI(this.mainUI, this.admins.get(username), this.reservations,
                        this.customers, this.providers, this.admins, this.rooms, this.messages, this.users);
            }
            default -> System.exit(0);
        }
    }
}
