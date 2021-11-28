import java.util.Map;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class ProviderUI {
    private final Provider provider;
    private final Map<Integer,Room> rooms;
    private final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * The constructor of ProviderUI assigns the authenticated provider object and a
     * HashMap of all available rooms to local objects for local access. Then it calls
     * the main provider panel.
     * @param provider     The authenticated provider object
     * @param rooms        A Hashmap of <Integer roomID, Room room>
     */
    public ProviderUI(Provider provider, Map<Integer,Room> rooms) {
        this.provider = provider;
        this.rooms = rooms;
        panel();
    }


    /**
     * This function reads an integer from user and returns it. If the input is
     * invalid it returns 0.
     * @return  the entered integer
     */
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

    /**
     *  This function adds a new room with a random roomID from 0-999 to the `rooms`
     *  HashMap, using roomID as key and Room object as value. It asks provider for
     *  every room attribute.
     */
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

        System.out.println("\n+============================+");
        System.out.println("|        Add new Room        |");
        System.out.println("+============================+");
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
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
                case 2 -> validInput = true;
                default -> System.out.println("\nInvalid input, enter a valid number\n");
            }
        }

        boolean addedToHashMap = false;
        Random rand = new Random();
        while(!addedToHashMap) {
            Integer random = rand.nextInt(1000);
            if (!rooms.containsKey(random)) {
                rooms.put(random, new Room(random, type, longTime, capacity, price, m2, wifi, parking,
                        airCondition, balcony, fridge, kitchen, tv, smoking, pets));
                addedToHashMap = true;
                provider.addRoomID(random);
                System.out.println("\nAdded new room with id: " + random);
            }
        }
    }


    /**
     *  Prints some basic attributes (id, type, capacity and price) for all the rooms
     *  of the current provider
     */
    public void displayAllRooms(){
        for(Integer id : this.provider.getRoomID()){
            System.out.println("id: " + rooms.get(id).getId().toString() +
                    ", type: " + rooms.get(id).getType() + ", capacity: " +
                    rooms.get(id).getCapacity().toString()+ ", price: $" +
                    df.format(rooms.get(id).getPrice()));
        }
    }

    /**
     *  Edits an existing room based on its unique roomID, if it belongs to the current
     *  provider. It asks for the room id, and it retrieves all the updated room attributes
     *  from the user. Then it updates the existing `rooms` HashMap entry.
     */
    public void editRoom(){
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

        System.out.println("\n+============================+");
        System.out.println("|         Edit room          |");
        System.out.println("+============================+\n");
        displayAllRooms();
        System.out.println("\nEnter room ID to edit:");
        int id = 0;
        boolean validInput = false;
        System.out.print("\n> ");
        try {
            id = scanner.nextInt();
            validInput = true;
        }
        catch (java.util.InputMismatchException ignored){
            scanner.nextLine();
            System.out.println("\nInvalid input, enter a valid number");
        }
        if (rooms.containsKey(id) && provider.getRoomID().contains(id) && validInput) {
            validInput = false;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
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
                    case 2 -> validInput = true;
                    default -> System.out.println("\nInvalid input, enter a valid number\n");
                }
            }
            rooms.put(id, new Room(id, type, longTime, capacity, price, m2, wifi, parking,
                    airCondition, balcony, fridge, kitchen, tv, smoking, pets));
            System.out.println("\nSuccessfully edited room with the following id: " + id);
        }
        else if (validInput){
            System.out.println("\nFailed to edit room with the following id: " + id);
        }
    }


    /**
     *   Deletes a room based on unique room ID. It prints all the rooms that belong
     *   to the authenticated provider and asks for a room identifier. If the given
     *   room belongs to the current provider it gets removed from the `rooms` HashMap
     *   and the provider `roomID` HashSet, otherwise it fails.
     */
    public void deleteRoom(){
        System.out.println("\n+============================+");
        System.out.println("|        Delete room         |");
        System.out.println("+============================+\n");
        displayAllRooms();
        System.out.println("\nEnter room ID to delete:");
        Integer id = 0;
        boolean validInput = false;
        System.out.print("\n> ");
        try {
            id = scanner.nextInt();
            validInput = true;
        }
        catch (java.util.InputMismatchException ignored){
            scanner.nextLine();
            System.out.println("\nInvalid input, enter a valid number");
        }
        if (rooms.containsKey(id) && provider.getRoomID().contains(id) && validInput) {
            rooms.remove(id);
            provider.removeRoomID(id);
            System.out.println("\nSuccessfully removed room with the following id: " + id);
        }
        else if (validInput){
            System.out.println("\nFailed to remove room with the following id: " + id);
        }

    }


    /**
     *   Prints all rooms that belong to the authenticated provider
     */
    public void showRooms(){
        System.out.println("\n+============================+");
        System.out.println("|       Show all rooms       |");
        System.out.println("+============================+\n");
        displayAllRooms();
    }

    /**  TODO
     *   Prints all the reservations for a specific room. It asks for a room id and
     *   outputs all the reservations made for this room.
     */
    public void returnAllReservations(){}


    /**
     *   The main provider user interface. It asks for a command and calls the
     *   appropriate function.
     */
    public void panel(){
        while (true){
        System.out.println("\n+============================+");
        System.out.println("|       Provider Panel       |");
        System.out.println("+============================+");
        System.out.println("| 1. Add new room            |");
        System.out.println("| 2. Edit existing room      |");
        System.out.println("| 3. Delete existing room    |");
        System.out.println("| 4. Show all rooms          |");
        System.out.println("| 5. Return all reservations |");
        System.out.println("| 6. Exit                    |");
        System.out.println("+============================+");
            int cmd = 0;
            System.out.print("\n> ");
            try {
                cmd = scanner.nextInt();
            }
            catch (java.util.InputMismatchException ignored){}
            switch (cmd) {
                case 1 -> addRoom();
                case 2 -> editRoom();
                case 3 -> deleteRoom();
                case 4 -> showRooms();
                case 5 -> returnAllReservations();
                case 6 -> System.exit(0);
                default -> {
                    System.out.println("\nInvalid input, enter a valid number");
                    scanner.nextLine();
                }
            }
        }
    }
}
