import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AdminUI {
    Admin admin;
    public AdminUI(Admin admin){
        this.admin = admin;
    }
    public void searchReservations(){}
    public void searchUsers(){}
    public void approvalNewUser(){}
    public void sendMessages(){}
    Scanner scanner=new Scanner(System.in);


    public void panel(){{
            while (true){
                System.out.println("\n+============================+");
                System.out.println("|       Admin    Panel       |");
                System.out.println("+============================+");
                System.out.println("| 1. Search  reservations    |");
                System.out.println("| 2. Search  users           |");
                System.out.println("| 3. Approve new user        |");
                System.out.println("| 4. Send message to user    |");
                System.out.println("| 5. Exit                    |");
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
                    case 5 -> System.exit(0);
                    default -> {
                        System.out.println("\nInvalid input, enter a valid number");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}
