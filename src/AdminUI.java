import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class AdminUI {
    private Map<String,Provider> providers;
    private Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private Map<String,Customer> customers;
    private Map<String,Admin> admins;
    private Map<String,Authentication> users;
    private static DecimalFormat df;
    Admin admin;
    Scanner scanner=new Scanner(System.in);
    MainUI mainUI;

    /**
     *  Constructor of AdminUI
     */
    public AdminUI(MainUI mainUI, Admin admin, Map<Integer,Reservation> reservations, Map<String, Customer> customers,
                   Map<String,Provider> providers,Map<String,Admin> admins,Map<String,Authentication> users, Map<Integer,Room> rooms){
        this.admin = admin;
        this.rooms = rooms;
        this.mainUI = mainUI;
        this.reservations=reservations;
        this.customers=customers;
        this.providers=providers;
        this.admins=admins;
        this.users = users;
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
        System.out.println("|  Search/Show Reservations   |");
        System.out.println("+============================+");
        int cmd=0;
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
        boolean validInput=false;
        int toSearch = 0;
        System.out.println("\n+============================+");
        System.out.println("|       Search/Show Users     |");
        System.out.println("\n+============================+");
        while (!validInput) {
            System.out.println("Users type:\n1.Customers\n2.Providers\n3.Admins");
            scanner.nextLine();
            try{
                toSearch=scanner.nextInt();
                if ((toSearch==1) || (toSearch==2) || (toSearch==3)){
                    validInput=true;
                }
                else{
                    System.out.println("\nInvalid input, enter a valid number");
                }
            }
            catch (Exception e){
                System.out.println("\nInvalid input, enter a valid number");
            }
        }

       switch (toSearch){
            case 1-> {
                    for (Map.Entry<String, Customer> entry : this.customers.entrySet()) {
                    String CustomerID = entry.getKey();
                    Customer value = entry.getValue();
                    System.out.println(new StringBuilder().append("username:").append(value.getUsername()).append(",email:").
                            append(value.getEmail()).append(",password:").append(value.getPassword()).append(",first Name:").
                            append(value.getFirstName()).append(",Last Name:").append(value.getLastName()).append(",gender:").append(value.getGender())
                            .append(",country:").append(value.getCountry()).append(",phone:").append(value.getPhone()).
                            append(",birthdate:").append(value.getBirthdate()).append(",Active Acount:").append(value.getActiveAccount()).toString());
                    }
            }
       case 2 -> {
            for (Map.Entry<String, Provider> entry : this.providers.entrySet()) {
                String ProviderID = entry.getKey();
                Provider value = entry.getValue();
                System.out.println(new StringBuilder().append("First Name:").append(value.getFirstName()).append(",Last Name:").append(value.getLastName())
                        .append("username:").append(value.getUsername()).append(",password:").append(value.getPassword()).append(",email:").
                        append(value.getEmail()).append(",country:").append(value.getCountry()).append(",office:").append(value.getOffice()).
                        append(",region:").append(value.getRegion()).toString());
            }
        }
        case 3 -> {
                for (Map.Entry<String, Admin> entry: this.admins.entrySet()){
                    String AdminID =entry.getKey();
                    Admin value=entry.getValue();
                    System.out.println(new StringBuilder().append("First Name:").append(value.getFirstName()).append(",Last Name:").
                            append(value.getLastName()).append(",username:").append(value.getUsername()).append(",password:").append(value.getPassword()).
                            append(",email:").append(value.getEmail()).append(",phone:").append(value.getPhone()).toString());
                }
        }
        default ->   {
               System.out.println("\nInvalid input, enter a valid number");
               scanner.nextLine();
           }

        }

    }


    /**
     * method for approving new Users
     */
    public void approvalNewUser(){
        //todo
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
                    case 5 -> {
                        System.out.println("");
                        this.mainUI.login();
                    }
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
