import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageUI {
    private final Map<Integer,Message> messages;
    private final Map<String,Authentication> users;
    private final Scanner scanner;
    private final String currentUsername;

    // Constructor
    public MessageUI(Map<Integer, Message> messages, String currentUsername, Map<String,Authentication> users) {
        this.messages = messages;
        this.scanner = new Scanner(System.in);
        this.currentUsername = currentUsername;
        this.users = users;
    }

    /**
     *   Asks for recipient username. If user exists, it asks for message content.
     *   Then it creates a new object of Message class and adds it to the messages
     *   Hashmap.
     */
    public void sentMessage() {
        String recipientUsername = "";
        String content = "";

        boolean validInput = false;
        while (!validInput){
            System.out.println("\nEnter recipient username:");
            scanner.nextLine();
            System.out.print("\n> ");
            try {
                recipientUsername = scanner.next();
                if (users.containsKey(recipientUsername)) {
                    validInput = true;
                }
                else {
                    System.out.println("\nUser " + recipientUsername + " not found");
                }
            } catch (java.util.InputMismatchException ignored) {}
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nType message content:");
            scanner.nextLine();
            System.out.print("\n> ");
            try {
                content = scanner.nextLine();
                validInput = true;
            } catch (java.util.InputMismatchException ignored) {}
        }

        boolean addedToHashMap = false;
        int i=1;
        while(!addedToHashMap && i<1000) {
            if (!messages.containsKey(i)) {
                messages.put(i, new Message(i, recipientUsername, currentUsername, content, false));
                addedToHashMap = true;
                System.out.println("\nMessage successfully sent");
            }
            else {i++;}
        }
    }

    /**
     *   Prints all messages included in the messages Hashmap that belong to the
     *   authenticated user. If a message is not read yet, it prints it to the
     *   "New messages" section and marks it as read.
     */
    public void inbox() {
        // New messages
        System.out.println("\nNew messages:\n\n+=======================================+\n");
        HashSet<Integer> readMessages = new HashSet<>();
        AtomicBoolean noNewMessages = new AtomicBoolean(true);
        messages.forEach((id, message) -> {
            if (Objects.equals(message.getRecipient(), currentUsername)){
                if (!message.isRead()) {
                    System.out.println("From: " + message.getSender());
                    System.out.println("Content: " + message.getContent() + "\n");
                    message.setRead(true);
                    noNewMessages.set(false);
                }
                else {
                    readMessages.add(message.getID());
                }
            }
        });
        if (noNewMessages.get()) {
            System.out.println("No new messages\n");
        }
        System.out.println("+=======================================+");

        // Older messages
        AtomicBoolean noOlderMessages = new AtomicBoolean(true);
        System.out.println("\nOlder messages:");
        readMessages.forEach((id) -> {
            System.out.println("\nFrom: " + messages.get(id).getSender());
            System.out.println("Content: " + messages.get(id).getContent());
            noOlderMessages.set(false);
        });
        if (noOlderMessages.get()){
            System.out.println("\nNo older messages");
        }
    }

    public void panel(){
        while (true){
            System.out.println("\n+======================+");
            System.out.println("|       Messages       |");
            System.out.println("+======================+");
            System.out.println("| 1. Send new message  |");
            System.out.println("| 2. Open inbox        |");
            System.out.println("| 3. Return            |");
            System.out.println("+======================+");
            int cmd = 0;
            System.out.print("\n> ");
            try {
                cmd = scanner.nextInt();
            }
            catch (java.util.InputMismatchException ignored){}
            switch (cmd) {
                case 1 -> sentMessage();
                case 2 -> inbox();
                case 3 -> {return;}
                default -> {
                    System.out.println("\nInvalid input, enter a valid number");
                    scanner.nextLine();
                }
            }
        }
    }
}
