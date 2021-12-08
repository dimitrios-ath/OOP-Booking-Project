import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AdminUI {
    private final Map<String,Provider> providers;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Customer> customers;
    private final Map<String,Admin> admins;
    private static DecimalFormat df;
    Admin admin;
    Scanner scanner=new Scanner(System.in);
    MainUI mainUI;

    /**
     *  Constructor of AdminUI
     */
    public AdminUI(MainUI mainUI, Admin admin, Map<Integer,Reservation> reservations, Map<String, Customer> customers,
                   Map<String,Provider> providers,Map<String,Admin> admins, Map<Integer,Room> rooms){
        this.admin = admin;
        this.rooms = rooms;
        this.mainUI = mainUI;
        this.reservations=reservations;
        this.customers=customers;
        this.providers=providers;
        this.admins=admins;
        df = new DecimalFormat("0.00");
        panel();
    }

    /**
     * This function reads an integer from user and returns it. If the input is
     * invalid it returns 0.
     * @return  the entered integer
     */
    public int scanInput(){
        int input = 0;
        System.out.print("\n> ");
        try {
            input = scanner.nextInt();
        }
        catch (java.util.InputMismatchException ignored){scanner.nextLine();}
        return input;
    }

    public void searchReservationsByUsername(String username){
        AtomicBoolean roomFound = new AtomicBoolean(false);
        AtomicInteger counter = new AtomicInteger(1);
        this.customers.get(username).getReservationIDs().forEach((reservationID) -> {
            System.out.println(counter + ". " + "reservation ID: " + reservations.get(reservationID).getReservationID()
                    + ", Username: \"" + reservations.get(reservationID).getUsername() + "\", Guests: "
                    + reservations.get(reservationID).getGuestNumber() + ", Check in: "
                    + reservations.get(reservationID).getCheckIn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    + ", Check out: " + reservations.get(reservationID).getCheckOut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    + ", Total price: $" + df.format((reservations.get(reservationID).getTotalPrice())));
            roomFound.set(true);
            counter.getAndIncrement();
        });
        if (!roomFound.get()) {
            System.out.println("\nNo reservations found for username: " + username);
        }
    }

    public void returnAllProviders(){
        var ref = new Object() {int c = 1;};
        System.out.println();
        this.providers.forEach((username, provider) -> {
            System.out.println(ref.c + ". Username: \""
                    + provider.getUsername() + "\", email: \"" + provider.getEmail() + "\", First name: \""
                    + provider.getFirstName() + "\", Last name: \"" + provider.getLastName() + "\", Office: \""
                    + provider.getOffice() + "\", Type: " + provider.getType() + ", Country: " + provider.getCountry()
                    + ", Region: " + provider.getRegion());
            ref.c++;
        });
    }

    public void searchProvidersByUsername(String pattern) {
        var ref = new Object() {int c = 1;};
        AtomicBoolean userFound = new AtomicBoolean(false);
        this.providers.forEach((username, provider) -> {
            if (username.contains(pattern)) {
                if (ref.c == 1){System.out.println();}
                System.out.println(ref.c + ". Username: \""
                        + provider.getUsername() + "\", email: \"" + provider.getEmail() + "\", First name: \""
                        + provider.getFirstName() + "\", Last name: \"" + provider.getLastName() + "\", Office: \""
                        + provider.getOffice() + "\", Type: " + provider.getType() + ", Country: " + provider.getCountry()
                        + ", Region: " + provider.getRegion());
                ref.c++;
                userFound.set(true);
            }
        });
        if (!userFound.get()) {
            System.out.println("\nNo providers found with the pattern: " + pattern);
        }
    }

    public void returnAllCustomers(){
        var ref = new Object() {int c = 1;};
        System.out.println();
        this.customers.forEach((username, user) -> {
            System.out.println(ref.c + ". Username: \""
                    + user.getUsername() + "\", email: \"" + user.getEmail() + "\", First name: \""
                    + user.getFirstName() + "\", Last name: \"" + user.getLastName() + "\", Birthdate: "
                    + user.getBirthdate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    + ", Gender: " + user.getGender() + ", Country: " + user.getCountry() + ", Tel: " + user.getPhone());
            ref.c++;
        });
    }

    public void searchUsersByUsername(String pattern) {
        var ref = new Object() {int c = 1;};
        AtomicBoolean userFound = new AtomicBoolean(false);
        this.customers.forEach((username, user) -> {
            if (username.contains(pattern)) {
                if (ref.c == 1){System.out.println();}
                System.out.println(ref.c + ". Username: \""
                        + user.getUsername() + "\", email: \"" + user.getEmail() + "\", First name: \""
                        + user.getFirstName() + "\", Last name: \"" + user.getLastName() + "\", Birthdate: "
                        + user.getBirthdate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Gender: " + user.getGender() + ", Country: " + user.getCountry() + ", Tel: " + user.getPhone());
                ref.c++;
                userFound.set(true);
            }
        });
        if (!userFound.get()) {
            System.out.println("\nNo customers found with the pattern: " + pattern);
        }
    }

    public void returnAllAdmins(){
        var ref = new Object() {int c = 1;};
        System.out.println();
        this.admins.forEach((username, admin) -> {
            System.out.println(ref.c + ". Username: \""
                    + admin.getUsername() + "\", email: \"" + admin.getEmail() + "\", First name: \""
                    + admin.getFirstName() + "\", Last name: \"" + admin.getLastName() + "\", Tel: "
                    + admin.getPhone());
            ref.c++;
        });
    }

    public void searchAdminsByUsername(String pattern) {
        var ref = new Object() {int c = 1;};
        AtomicBoolean userFound = new AtomicBoolean(false);
        this.admins.forEach((username, admin) -> {
            if (username.contains(pattern)) {
                if (ref.c == 1){System.out.println();}
                System.out.println(ref.c + ". Username: \""
                        + admin.getUsername() + "\", email: \"" + admin.getEmail() + "\", First name: \""
                        + admin.getFirstName() + "\", Last name: \"" + admin.getLastName() + "\", Tel: "
                        + admin.getPhone());
                ref.c++;
                userFound.set(true);
            }
        });
        if (!userFound.get()) {
            System.out.println("\nNo administrators found with the pattern: " + pattern);
        }
    }

    public void searchReservationsByRoomID(int roomID){
        System.out.println();
        AtomicBoolean roomFound = new AtomicBoolean(false);
        AtomicInteger counter = new AtomicInteger(1);
        reservations.forEach((id, reservation) -> {
            if (reservation.getRoomID() == roomID) {
                System.out.println(counter + ". " + "reservation ID: " + reservation.getReservationID() + ", Username: \""
                        + reservation.getUsername() + "\", Guests: " + reservation.getGuestNumber() + ", Check in: "
                        + reservation.getCheckIn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Check out: " + reservation.getCheckOut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Total price: $" + df.format((reservation.getTotalPrice())));
                roomFound.set(true);
                counter.getAndIncrement();
            }
        });
        if (!roomFound.get()) {
            System.out.println("\nNo reservations found for this room");
        }
    }

    public void returnAllReservations(){
        var ref = new Object() {
            int c = 1;
        };
        reservations.forEach((reservationID, reservation) -> {
            System.out.println(ref.c + ". " + "reservation ID: " + reservation.getReservationID() + ", Username: \""
                    + reservation.getUsername() + "\", Guests: " + reservation.getGuestNumber() + ", Check in: "
                    + reservation.getCheckIn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    + ", Check out: " + reservation.getCheckOut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    + ", Total price: $" + df.format((reservation.getTotalPrice())));
            ref.c++;
        });}

    /**
     *    search reservations by username, by room identifier or return all of them
     */
    public void searchReservations(){
        System.out.println("\n+============================+");
        System.out.println("|  Search/Show Reservations  |");
        System.out.println("+============================+");
        int cmd;
        boolean validInput=false;

        while (!validInput){
            System.out.println("\n1. Search by customer username\n2. Search by room ID\n3. Return all reservations");
            cmd = scanInput();
            switch (cmd) {
                case 1 -> {
                    validInput = true;
                    System.out.println("\nEnter the customer username to search reservations for:");
                    System.out.print("\n> ");
                    String username="";
                    try {
                        username = scanner.next();
                    }
                    catch (java.util.InputMismatchException ignored){scanner.nextLine();}
                    if (!this.customers.containsKey(username)){
                        scanner.nextLine();
                        System.out.println("\nUsername \"" + username + "\" not found");
                    }
                    else {searchReservationsByUsername(username);}
                }
                case 2 -> {
                    validInput = true;
                    System.out.println("\nEnter the room ID to search reservations for:");
                    System.out.print("\n> ");
                    int roomID = 0;
                    try {roomID = scanner.nextInt();}
                    catch (java.util.InputMismatchException ignored){
                        scanner.nextLine();
                    }
                    if (!this.rooms.containsKey(roomID)){
                        if (roomID!=0) {System.out.println("\nRoom with id " + roomID + " not found");}
                        else {System.out.println("\nInvalid input. Enter a valid room ID");}
                    }
                    else if (roomID>0) {searchReservationsByRoomID(roomID);}
                }
                case 3 -> {
                    validInput = true;
                    System.out.println("\nReturning all reservations\n");
                    returnAllReservations();
                }
                default -> System.out.println("\nInvalid input, enter a valid number");
            }
        }
    }

    /**
     * this function searches and shows all the users
     */
    public void searchUsers() {
        System.out.println("\n+============================+");
        System.out.println("|      Search/Show Users     |");
        System.out.println("+============================+");
        int cmd = 0;
        boolean validInput=false;
        while (!validInput) {
            System.out.println("\nSelect user type to search:\n1. Customer\n2. Provider\n3. Admin");
            cmd = scanInput();
            if (cmd > 0 && cmd <= 3){
                    validInput = true;
            }
            else {
                System.out.println("\nInvalid input, enter a valid number");
            }
        }
       switch (cmd){
            case 1 -> {
                validInput = false;
                while (!validInput) {
                    System.out.println("\nSearch customers:\n1. Search by name pattern\n2. Return all customers");
                    cmd = scanInput();
                    if (cmd > 0 && cmd <= 2) {validInput = true;}
                    else {System.out.println("\nInvalid input, enter a valid number");}
                    switch (cmd){
                        case 1 -> {
                            String username = "";
                            System.out.println("\nEnter search pattern:");
                            System.out.print("\n> ");
                            try {
                                username = scanner.next();
                            } catch (Exception e) {System.out.println("Invalid input. Enter a valid pattern");}
                            scanner.nextLine();
                            searchUsersByUsername(username);
                        }
                        case 2 -> returnAllCustomers();
                    }
                }
            }
           case 2 -> {
               validInput = false;
               while (!validInput) {
                   System.out.println("\nSearch providers:\n1. Search by name pattern\n2. Return all providers");
                   cmd = scanInput();
                   if (cmd > 0 && cmd <= 2) {validInput = true;}
                   else {System.out.println("\nInvalid input, enter a valid number");}
                   switch (cmd){
                       case 1 -> {
                           String username = "";
                           System.out.println("\nEnter search pattern:");
                           System.out.print("\n> ");
                           try {
                               username = scanner.next();
                           } catch (Exception e) {System.out.println("Invalid input. Enter a valid pattern");}
                           scanner.nextLine();
                           searchProvidersByUsername(username);
                       }
                       case 2 -> returnAllProviders();
                   }
               }
           }
           case 3 -> {
               validInput = false;
               while (!validInput) {
                   System.out.println("\nSearch administrators:\n1. Search by name pattern\n2. Return all administrators");
                   cmd = scanInput();
                   if (cmd > 0 && cmd <= 2) {validInput = true;}
                   else {System.out.println("\nInvalid input, enter a valid number");}
                   switch (cmd){
                       case 1 -> {
                           String username = "";
                           System.out.println("\nEnter search pattern:");
                           System.out.print("\n> ");
                           try {
                               username = scanner.next();
                           } catch (Exception e) {System.out.println("Invalid input. Enter a valid pattern");}
                           scanner.nextLine();
                           searchAdminsByUsername(username);
                       }
                       case 2 -> returnAllAdmins();
                   }
               }
           }
       default ->   {
               System.out.println("\nInvalid input, enter a valid number");
               scanner.nextLine();
           }
       }
    }


    /**
     * method for approving new Users based on username
     */
    public void approvalNewUser(){
        System.out.println("\n+============================+");
        System.out.println("|     Approval of New User    |");
        System.out.println("+============================+");

        System.out.print("\nApproving\n1.Customer\n2.Provider\n3.Admin");
        int role;
        System.out.print("\n>");
        role=scanner.nextInt();

        switch(role){
            case 1->{
                int counterOfApprovals=0;
                for (Map.Entry<String, Customer > entry: this.customers.entrySet() ){
                    Customer value=entry.getValue();
                    if (!value.getActiveAccount()){
                        value.setActiveAccount(true);
                        counterOfApprovals++;
                    }

                }
                System.out.print("\nThe total number of new Approvals is: "+ counterOfApprovals);
            }
            case 2->{
                int counterOfApprovals=0;
                for (Map.Entry<String, Provider> entry: this.providers.entrySet() ){
                    Provider value=entry.getValue();
                    if (!value.getActiveAccount()){
                        value.setActiveAccount(true);
                    }
                }
                System.out.print("\nThe total number of new Approvals is: "+ counterOfApprovals);
            }
            case 3->{
                int counterOfApprovals=0;
                for (Map.Entry<String , Admin> entry: this.admins.entrySet()){
                    Admin value=entry.getValue();
                    if (!value.getActiveAccount()){
                        value.setActiveAccount(true);
                    }
                }
                System.out.print("\nThe total number of new Approvals is: "+ counterOfApprovals);
            }
            default -> {
                System.out.println("\nInvalid input, enter a valid number");
                scanner.nextLine();
            }
        }

    }

    /**
     * method for sending messages
     */
    public void sendMessages(){
        //todo
    }

    /**
     *   The main provider user interface. It asks for a command and calls the
     *   appropriate function.
     */
    public void panel(){{
            while (true){
                System.out.println("\n+=============================+");
                System.out.println("|         Admin Panel         |");
                System.out.println("+=============================+");
                System.out.println("| 1. Search/Show reservations |");
                System.out.println("| 2. Search/Show users        |");
                System.out.println("| 3. Approve new user         |");
                System.out.println("| 4. Send message to user     |");
                System.out.println("| 5. Log out                  |");
                System.out.println("| 6. Exit                     |");
                System.out.println("+=============================+");
                int input = 0;
                System.out.print("\n> ");
                try {
                    input = scanner.nextInt();
                }
                catch (java.util.InputMismatchException ignored){}
                switch (input) {
                    case 1 -> searchReservations();
                    case 2 -> searchUsers();
                    case 3 -> approvalNewUser();
                    case 4 -> sendMessages();
                    case 5 -> this.mainUI.optionHandler();
                    case 6 -> System.exit(0);
                    default -> {
                        System.out.println("\nInvalid input, enter a valid number");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}
