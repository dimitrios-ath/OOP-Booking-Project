import java.util.Scanner;
import java.util.Map;

public class AdminUI {
    private Map<Integer,Reservation> reservations;
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
        //todo
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
                System.out.println("| 1. Search  reservations    |");
                System.out.println("| 2. Search  users           |");
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
