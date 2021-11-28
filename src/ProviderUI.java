import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class ProviderUI {
    private Provider provider;
    private Map<Integer,Room> rooms;
    private Scanner scanner = new Scanner(System.in);

    public ProviderUI(Provider provider, Map<Integer,Room> rooms) {
        this.provider = provider;
        this.rooms = rooms;
        panel();
    }

    public int scanInput(){
        int input = 0;
        scanner.nextLine();
        System.out.print("\n> ");
        try {
            input = scanner.nextInt();
        }
        catch (java.util.InputMismatchException ignored){}
        return input;
    }

    public void addRoom(){
        String type="";
        boolean longTime=false;
        int capacity=0;
        double price=0;
        int m2=0;
        boolean wifi=false;
        boolean parking=false;
        boolean airCondition=false;
        boolean balcony=false;
        boolean fridge=false;
        boolean kitchen=false;
        boolean tv=false;
        boolean smoking=false;
        boolean pets=false;

        int input;
        boolean validInput = false;

        while (!validInput){
            System.out.println("\nSelect room type:\n1.Hotel\n2.Room\n3.Apartment");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    type = "hotel";
                    validInput = true;
                }
                case 2 -> {
                    type = "room";
                    validInput = true;
                }
                case 3 -> {
                    type = "apartment";
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nIs room available for long term reservation?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    longTime = true;
                    validInput = true;
                }
                case 2 -> {
                    longTime = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nEnter the maximum amount of people in the room:");
            input = scanInput();
            if (input == 0 || input >= 10){
                System.out.println("\nInvalid input, enter a valid number\n");
            }
            else {
                capacity = input;
                validInput = true;
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nEnter the room price per night:");
            double scannedPrice = 0;
            scanner.nextLine();
            System.out.print("\n> ");
            try {
                scannedPrice = scanner.nextDouble();
            }
            catch (java.util.InputMismatchException ignored){}
            if (scannedPrice<=0){
                System.out.println("\nInvalid input, enter a valid price\n");
            }
            else {
                price = scannedPrice;
                validInput = true;
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nEnter the room size in square meters:");
            input = scanInput();
            if (input <= 0){
                System.out.println("\nInvalid input, enter a valid number\n");
            }
            else {
                m2 = input;
                validInput = true;
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nDoes the room provide free WiFi access?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    wifi = true;
                    validInput = true;
                }
                case 2 -> {
                    wifi = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nDoes the room provide free parking?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    parking = true;
                    validInput = true;
                }
                case 2 -> {
                    parking = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nDoes the room have air condition?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    airCondition = true;
                    validInput = true;
                }
                case 2 -> {
                    airCondition = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nDoes the room have balcony?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    balcony = true;
                    validInput = true;
                }
                case 2 -> {
                    balcony = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nDoes the room have fridge?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    fridge = true;
                    validInput = true;
                }
                case 2 -> {
                    fridge = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nDoes the room have kitchen?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    kitchen = true;
                    validInput = true;
                }
                case 2 -> {
                    kitchen = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nDoes the room have TV?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    tv = true;
                    validInput = true;
                }
                case 2 -> {
                    tv = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nIs smoking allowed in the room?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    smoking = true;
                    validInput = true;
                }
                case 2 -> {
                    smoking = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }
        validInput = false;
        while (!validInput){
            System.out.println("\nAre pets allowed in the room?\n1. Yes\n2. No");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    pets = true;
                    validInput = true;
                }
                case 2 -> {
                    pets = false;
                    validInput = true;
                }
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }

        boolean addedToHashMap = false;
        Random rand = new Random();
        while(!addedToHashMap) {
            int random = rand.nextInt(1000);
            if (!rooms.containsKey(random)) {
                rooms.put(random, new Room(random, type, longTime, capacity, price, m2, wifi, parking,
                        airCondition, balcony, fridge, kitchen, tv, smoking, pets));
                addedToHashMap = true;
                provider.addRoomID(random);
            }
        }
        //rooms.forEach((k,n) -> System.out.println(n));
        //rooms.put(1,new Room(1,"hotel",false,2, 40, 35, true, true, true, true, true, false, true, false, false));
        panel();
    }

    public void editRoom(){}
    public void deleteRoom(){}
    public void showRooms(){}
    public void returnAllReservations(){}

    public void panel(){
        System.out.println("+============================+");
        System.out.println("|       Provider Panel       |");
        System.out.println("+============================+");
        System.out.println("|  1. Add new room           |");
        System.out.println("|  2. Edit existing room     |");
        System.out.println("|  3. Delete existing room   |");
        System.out.println("|  4. Show all rooms         |");
        System.out.println("|  5. Exit                   |");
        System.out.println("+============================+");
        System.out.print("\n> ");
        int cmd = scanner.nextInt();

        switch (cmd) {
            case 1 -> addRoom();
            case 2 -> editRoom();
            case 3 -> deleteRoom();
            case 4 -> showRooms();
            case 5 -> System.exit(0);
            default -> {
                System.out.println("\nInvalid input, enter a valid number\n");
                panel();
            }
        }
    }
}
