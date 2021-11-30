import java.util.Scanner;
import java.util.Map;
import java.util.function.BiConsumer;

public class AdminUI {
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Customer> customers;
    Admin admin;
    Scanner scanner=new Scanner(System.in);
    MainUI mainUI;

    public AdminUI(MainUI mainUI, Admin admin, Map<Integer,Reservation> reservations){
        this.admin = admin;
        this.mainUI = mainUI;
        this.reservations=reservations;
        panel();
    }
    public void searchReservations(){

        System.out.println("\n+============================+");
        System.out.println("|  Search/Show Reservations   |");
        System.out.println("\n+============================+");

        for (Map.Entry<Integer, Reservation> entry : this.reservations.entrySet()) {
            Integer reservationID = entry.getKey();
            Reservation value = entry.getValue();
            System.out.println(new StringBuilder().append("id:").append(value.getReservationID()).append(",guests:").
                    append(value.getGuestNumber()).append(",Nights:").append(value.getTotalNights()).append(",Room's Id:").append(value.getRoomID()).append(",Check in:").append(value.getCheckIn()).append(",check out:").append(value.getCheckOut())
                    .append(",username of Customer:").append(value.getUsername()).toString());
        }
    }
    public void searchUsers(){
         //todo
    }
    public void approvalNewUser(){
        //todo
    }
    public void sendMessages(){
        //todo
    }

    /**
     * The main admin user interface. It asks for a command and calls the
     * appropriate function
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
