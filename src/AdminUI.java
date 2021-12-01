import java.util.Scanner;
import java.util.Map;
import java.util.function.BiConsumer;

public class AdminUI {
    private Map<String,Provider> providers;
    private Map<Integer,Reservation> reservations;
    private Map<String,Customer> customers;
    private Map<String,Admin> admins;
    Admin admin;
    Scanner scanner=new Scanner(System.in);
    MainUI mainUI;

    /**
     *
     * @param mainUI
     * @param admin
     * @param reservations
     * @param customers
     * @param providers
     */
    public AdminUI(MainUI mainUI, Admin admin, Map<Integer,Reservation> reservations, Map<String, Customer> customers,
                   Map<String,Provider> providers,Map<String,Admin> admins){
        this.admin = admin;
        this.mainUI = mainUI;
        this.reservations=reservations;
        this.customers=customers;
        this.providers=providers;
        this.admins=admins;
        panel();
    }

    /**
     * this function searches and shows all the reservations
     */
    public void searchReservations(){

        System.out.println("\n+============================+");
        System.out.println("|  Search/Show Reservations   |");
        System.out.println("\n+============================+");

        for (Map.Entry<Integer, Reservation> entry : this.reservations.entrySet()) {
            Integer reservationID = entry.getKey();
            Reservation value = entry.getValue();
            System.out.println(new StringBuilder().append("id:").append(value.getReservationID()).append(",guests:").
                    append(value.getGuestNumber()).append(",Nights:").append(value.getTotalNights()).append(",Room's Id:")
                    .append(value.getRoomID()).append(",Check in:").append(value.getCheckIn()).append(",check out:").append(value.getCheckOut())
                    .append(",Customer's username:").append(value.getUsername()).toString());
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
                System.out.println("\n+============================+");
                System.out.println("|       Admin    Panel       |");
                System.out.println("+============================+");
                System.out.println("| 1. Search/Show reservations|");
                System.out.println("| 2. Search/Show users       |");
                System.out.println("| 3. Approve new user        |");
                System.out.println("| 4. Send message to user    |");
                System.out.println("| 5. Log out                 |");
                System.out.println("| 6. Exit                    |");
                System.out.println("+============================+");
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
