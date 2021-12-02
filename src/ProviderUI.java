import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ProviderUI {
    private final Provider provider;
    private final Map<Integer,Room> rooms;
    private final Map<Integer,Reservation> reservations;
    private final Scanner scanner;
    private final MainUI mainUI;
    private static DecimalFormat df;

    /**
     * The constructor of ProviderUI assigns the authenticated provider object and a
     * HashMap of all available rooms to local objects for local access. Then it calls
     * the main provider panel.
     * @param provider     The authenticated provider object
     * @param rooms        A Hashmap of <Integer roomID, Room room>
     */
    public ProviderUI(MainUI mainUI, Provider provider, Map<Integer,Room> rooms, Map<Integer,Reservation> reservations) {
        this.provider = provider;
        this.rooms = rooms;
        this.mainUI = mainUI;
        this.reservations = reservations;
        this.scanner = new Scanner(System.in);
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

    /**
     *
     * this function deescalates the term of complexity
     * (in the purpose of not writing the same code again
     * and again) by creating cases loop that helps the
     * progress of the program to be more efficient
     * @param message recieves a guestion-string
     * return ret   the outcome of this method
     */
    public boolean scanBooleanFilter(String message){
        int input = 0;
        boolean validInput = false;
        boolean ret=false;
        while (!validInput){
            System.out.println(message);
            System.out.print("\n> ");
            try {
                input = scanner.nextInt();
                if (input <= 2 && input != 0){
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
        }
        if (input==1) {
            ret=true;
        }
        else if (input==2) {
            ret=false;
        }
        return ret;
    }
    /**
     *  This function adds a new room with ascending roomID from 1-999 to the `rooms`
     *  HashMap, using roomID as key and Room object as value. It asks provider for
     *  every room attribute.
     */
    public void addRoom(){
        String name="";
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
                default -> System.out.println("\nInvalid input, enter a valid number");
            }
        }
        validInput = false;
        while (!validInput){
            if (type.equals("hotel")){
                System.out.println("\nEnter hotel name:");
                scanner.nextLine();
                System.out.print("\n> ");
                try {
                    name = scanner.nextLine();
                    validInput = true;
                }
                catch (java.util.InputMismatchException ignored){}
            }
            else if (type.equals("room")){
                System.out.println("\nEnter room name:");
                scanner.nextLine();
                System.out.print("\n> ");
                try {
                    name = scanner.nextLine();
                    validInput = true;
                }
                catch (java.util.InputMismatchException ignored){}
            }
            else {
                System.out.println("\nEnter apartment name:");
                scanner.nextLine();
                System.out.print("\n> ");
                try {
                    name = scanner.nextLine();
                    validInput = true;
                }
                catch (java.util.InputMismatchException ignored){}
            }
        }
        longTime = scanBooleanFilter("\nIs room available for long term reservation?\n1. Yes\n2. No");
        validInput = false;
        while (!validInput){
            System.out.println("\nEnter the maximum amount of people in the room:");
            input = scanInput();
            if (input == 0 || input >= 10){
                System.out.println("\nInvalid input, enter a valid number");
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
                System.out.println("\nInvalid input, enter a valid price");
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
                System.out.println("\nInvalid input, enter a valid number");
            }
            else {
                m2 = input;
                validInput = true;
            }
        }
        wifi = scanBooleanFilter("\nDoes the room provide free WiFi access?\n1. Yes\n2. No");
        parking = scanBooleanFilter("\nDoes the room provide free parking?\n1. Yes\n2. No");
        airCondition = scanBooleanFilter("\nDoes the room have air condition?\n1. Yes\n2. No");
        balcony = scanBooleanFilter("\nDoes the room have balcony?\n1. Yes\n2. No");
        fridge = scanBooleanFilter("\nDoes the room have fridge?\n1. Yes\n2. No");
        kitchen = scanBooleanFilter("\nDoes the room have kitchen?\n1. Yes\n2. No");
        tv = scanBooleanFilter("\nDoes the room have TV?\n1. Yes\n2. No");
        smoking = scanBooleanFilter("\nIs smoking allowed in the room?\n1. Yes\n2. No");
        pets = scanBooleanFilter("\nAre pets allowed in the room?\n1. Yes\n2. No");

        boolean addedToHashMap = false;
        int i=1;
        while(!addedToHashMap && i<1000) {
            if (!rooms.containsKey(i)) {
                rooms.put(i, new Room(i, name, type, longTime, capacity, price, m2, wifi, parking,
                        airCondition, balcony, fridge, kitchen, tv, smoking, pets));
                addedToHashMap = true;
                provider.addRoomID(i);
                System.out.println("\nAdded new room with id: " + i);
            }
            else {i++;}
        }
    }


    /**
     *  Prints some basic attributes (id, type, capacity and price) for all the rooms
     *  of the current provider
     */
    public void displayAllRooms(){
        for(Integer id : this.provider.getRoomIDs()){
            System.out.println("id: " + rooms.get(id).getId().toString() +
                    ", name: \"" + rooms.get(id).getName() +
                    "\", type: " + rooms.get(id).getType() + ", capacity: " +
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
        String name="";
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
        if (rooms.containsKey(id) && provider.getRoomIDs().contains(id) && validInput) {
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
                    default -> System.out.println("\nInvalid input, enter a valid number");
                }
            }
            validInput = false;
            while (!validInput){
                if (type.equals("hotel")){
                    System.out.println("\nEnter hotel name:");
                    scanner.nextLine();
                    System.out.print("\n> ");
                    try {
                        name = scanner.nextLine();
                        validInput = true;
                    }
                    catch (java.util.InputMismatchException ignored){}
                }
                else if (type.equals("room")){
                    System.out.println("\nEnter room name:");
                    scanner.nextLine();
                    System.out.print("\n> ");
                    try {
                        name = scanner.nextLine();
                        validInput = true;
                    }
                    catch (java.util.InputMismatchException ignored){}
                }
                else {
                    System.out.println("\nEnter apartment name:");
                    scanner.nextLine();
                    System.out.print("\n> ");
                    try {
                        name = scanner.nextLine();
                        validInput = true;
                    }
                    catch (java.util.InputMismatchException ignored){}
                }
            }
            longTime = scanBooleanFilter("\nIs room available for long term reservation?\n1. Yes\n2. No");
            validInput = false;
            while (!validInput){
                System.out.println("\nEnter the maximum amount of people in the room:");
                input = scanInput();
                if (input == 0 || input >= 10){
                    System.out.println("\nInvalid input, enter a valid number");
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
                    System.out.println("\nInvalid input, enter a valid price");
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
                    System.out.println("\nInvalid input, enter a valid number");
                }
                else {
                    m2 = input;
                    validInput = true;
                }
            }
            wifi = scanBooleanFilter("\nDoes the room provide free WiFi access?\n1. Yes\n2. No");
            parking = scanBooleanFilter("\nDoes the room provide free parking?\n1. Yes\n2. No");
            airCondition = scanBooleanFilter("\nDoes the room have air condition?\n1. Yes\n2. No");
            balcony = scanBooleanFilter("\nDoes the room have balcony?\n1. Yes\n2. No");
            fridge = scanBooleanFilter("\nDoes the room have fridge?\n1. Yes\n2. No");
            kitchen = scanBooleanFilter("\nDoes the room have kitchen?\n1. Yes\n2. No");
            tv = scanBooleanFilter("\nDoes the room have TV?\n1. Yes\n2. No");
            smoking = scanBooleanFilter("\nIs smoking allowed in the room?\n1. Yes\n2. No");
            pets = scanBooleanFilter("\nAre pets allowed in the room?\n1. Yes\n2. No");

            rooms.put(id, new Room(id, name, type, longTime, capacity, price, m2, wifi, parking,
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
        if (rooms.containsKey(id) && provider.getRoomIDs().contains(id) && validInput) {
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
            System.out.println("| 6. Log out                 |");
            System.out.println("| 7. Exit                    |");
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
                    case 6 -> {
                        System.out.println("");
                        this.mainUI.login();
                    }
                    case 7 -> System.exit(0);
                    default -> {
                        System.out.println("\nInvalid input, enter a valid number");
                        scanner.nextLine();
                }
            }
        }
    }
}
