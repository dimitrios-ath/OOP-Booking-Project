import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.time.ZoneId;

public class CustomerUI {
    private final Customer customer;
    private final Map<Integer,Room> rooms;
    private final Map<Integer,Reservation> reservations;
    private final Scanner scanner;
    private final MainUI mainUI;
    private static DecimalFormat df;
    private Object Integer;

    public CustomerUI(MainUI mainUI, Customer customer, Map<Integer,Room> rooms, Map<Integer,Reservation> reservations) {
        this.customer = customer;
        this.rooms = rooms;
        this.reservations = reservations;
        this.mainUI = mainUI;
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
        scanner.nextLine();
        System.out.print("\n> ");
        try {
            input = scanner.nextInt();
        }
        catch (java.util.InputMismatchException ignored){
            System.out.println("\nInvalid input, enter a valid number");
        }
        return input;
    }

    public void scanBooleanFilter(String message, int possibleAnswers, String filterName, Map<String,String> filters){
        int input = 0;
        boolean validInput = false;
        while (!validInput){
            System.out.println(message);
            scanner.nextLine();
            System.out.print("\n> ");
            try {
                input = scanner.nextInt();
                if (input <= possibleAnswers && input != 0){
                    validInput = true;
                }
                else {
                    System.out.println("\nInvalid input, enter a valid number");
                }
            }
            catch (java.util.InputMismatchException ignored){
                System.out.println("\nInvalid input, enter a valid number");
            }
        }
        if (input==1) {
            filters.put(filterName, "yes");
        }
        else if (input==2) {
            filters.put(filterName, "no");
        }
    }

    /**
     *
     * @param filters
     * this function registers some filters based on
     * customers satisfactions in the purpose of making
     * the search more efficient
     */
    public void filtersUI(Map<String, String> filters) {
        boolean defaultPrice = true;
        boolean readyToSearch = false;
        while (!readyToSearch){
            if (!(Objects.equals(filters.get("Price"), "-"))){
                defaultPrice = false;
            }
            System.out.println("\n+============================+");
            System.out.println("|        Add filters         |");
            System.out.println("+============================+");
            System.out.println("\nSelect a filter to add:");
            System.out.println("\n0. Search with current filters\n------------------------------");
            if(!defaultPrice) {System.out.println("1. Maximum room price per night -> $" + df.format(Double.parseDouble(filters.get("Price"))));}
            else {System.out.println("1. Maximum room price per night -> " + filters.get("Price"));}
            System.out.println("2. Room type -> " + filters.get("Type"));
            System.out.println("3. Has balcony -> "+ filters.get("Balcony"));
            System.out.println("4. Has kitchen -> " + filters.get("Kitchen"));
            System.out.println("5. Free WiFi provided -> " + filters.get("Wifi"));
            System.out.println("6. Free parking provided -> " + filters.get("Parking"));
            System.out.println("7. Has air condition -> " + filters.get("AirCondition"));
            System.out.println("8. Has fridge -> " + filters.get("Fridge"));
            System.out.println("9. Has television -> " + filters.get("Tv"));
            System.out.println("10. Smoking allowed -> " + filters.get("Smoking"));
            System.out.println("11. Pets allowed -> " + filters.get("Pets"));

            int cmd = scanInput();

            switch (cmd) {
                case 0 -> readyToSearch = true;
                case 1 -> {
                    Double input = 0.0;
                    boolean validInput = false;
                    while (!validInput){
                        System.out.println("\nEnter maximum room price per night:");
                        scanner.nextLine();
                        System.out.print("\n> ");
                        try {
                            input = scanner.nextDouble();
                            if (input != 0){
                                validInput = true;
                            }
                            else {
                                System.out.println("\nInvalid input, enter a valid number");
                            }
                        }
                        catch (java.util.InputMismatchException ignored){
                            System.out.println("\nInvalid input, enter a valid number");
                        }
                    }
                    filters.put("Price", input.toString());
                }
                case 2 -> {
                    int input = 0;
                    boolean validInput = false;
                    while (!validInput){
                        System.out.println("\nRoom type:\n1. Hotel\n2. Room\n3. Apartment");
                        scanner.nextLine();
                        System.out.print("\n> ");
                        try {
                            input = scanner.nextInt();
                            if (input <= 3 && input != 0){
                                validInput = true;
                            }
                            else {
                                System.out.println("\nInvalid input, enter a valid number");
                            }
                        }
                        catch (java.util.InputMismatchException ignored){
                            System.out.println("\nInvalid input, enter a valid number");
                        }
                    }
                    if (input==1) {
                        filters.put("Type", "hotel");
                    }
                    else if (input==2) {
                        filters.put("Type", "room");
                    }
                    else if (input==3) {
                        filters.put("Type", "apartment");
                    }
                }
                case 3 -> scanBooleanFilter("\nHas balcony:\n1. Yes\n2. No", 2, "Balcony", filters);
                case 4 -> scanBooleanFilter("\nHas kitchen:\n1. Yes\n2. No", 2, "Kitchen", filters);
                case 5 -> scanBooleanFilter("\nFree WiFi provided:\n1. Yes\n2. No", 2, "Wifi", filters);
                case 6 -> scanBooleanFilter("\nFree parking provided:\n1. Yes\n2. No", 2, "Parking", filters);
                case 7 -> scanBooleanFilter("\nHas air condition:\n1. Yes\n2. No", 2, "AirCondition", filters);
                case 8 -> scanBooleanFilter("\nHas fridge:\n1. Yes\n2. No", 2, "Fridge", filters);
                case 9 -> scanBooleanFilter("\nHas television:\n1. Yes\n2. No", 2, "Tv", filters);
                case 10 -> scanBooleanFilter("\nSmoking allowed:\n1. Yes\n2. No", 2, "Smoking", filters);
                case 11 -> scanBooleanFilter("\nPets allowed:\n1. Yes\n2. No", 2, "Pets", filters);
                default -> {
                    System.out.println("\nInvalid input, enter a valid number");
                    scanner.nextLine();
                }
            }
        }

    }

    /**
     * this function displays all the rooms
     * with their characteristics
     */
    public void displayAllRooms(){
        this.rooms.forEach((id, room) -> {
            System.out.println("Type: " + rooms.get(id).getType() + ", capacity: " +
                    rooms.get(id).getCapacity().toString()+ ", price: $" +
                    df.format(rooms.get(id).getPrice()));
        });
    }
    /**
     *  this function searches rooms based on some
     *  user's filters and calls the function reserve
     *  giving the capacity to the user to reserve
     *  whatever room he wants
     */
    public void search(){
        Map<String, String> filters = new HashMap<>();
        Map<Integer, Room> filteredRooms = new HashMap<>();
        AtomicBoolean matchingRoom = new AtomicBoolean(false);
        boolean validInput;
        int guests = 0, input=0;
        LocalDate checkIn = LocalDate.of(1,1,1) , checkOut = LocalDate.of(1,1,1);

        filters.put("Type","-");
        filters.put("Price","-");
        filters.put("Balcony","-");
        filters.put("Kitchen","-");
        filters.put("Wifi","-");
        filters.put("Parking","-");
        filters.put("AirCondition","-");
        filters.put("Fridge","-");
        filters.put("Tv","-");
        filters.put("Smoking","-");
        filters.put("Pets","-");

        System.out.println("\n+============================+");
        System.out.println("|    Search/Reserve Room     |");
        System.out.println("+============================+");

        validInput = false;
        while (!validInput){
            System.out.println("\nEnter the number of guests:");
            guests = scanInput();
            if (guests != 0) {
                validInput = true;
            }
        }

        validInput = false;
        while (!validInput){
            System.out.println("\nEnter the check in date (dd-mm-yyyy):");
            System.out.print("\n> ");
            String date = scanner.next();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                checkIn = LocalDate.parse(date, dtf);
                validInput = true;
            } catch (java.time.format.DateTimeParseException ignored){
                System.out.println("\nInvalid input, please enter a valid date");
            }
        }

        validInput = false;
        while (!validInput){
            System.out.println("\nEnter the check out date (dd-mm-yyyy):");
            System.out.print("\n> ");
            String date = scanner.next();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                checkOut = LocalDate.parse(date, dtf);
                if (checkOut.isAfter(checkIn)){
                    validInput = true;
                }
                else {
                    System.out.println("\nInvalid input, please enter a valid date");
                }
            } catch (java.time.format.DateTimeParseException ignored){
                System.out.println("\nInvalid input, please enter a valid date");
            }
        }

        validInput = false;
        while (!validInput){
            System.out.println("\n1. Add new search filters\n2. Continue search with current filters");
            input = scanInput();
            switch (input) {
                case 1 -> {
                    filtersUI(filters);
                    validInput = true;
                }
                case 2 -> validInput = true;
                default -> validInput = false;
            }

        }

        this.rooms.forEach((roomID,room) -> {
            matchingRoom.set(true);
            filters.forEach((filter,value) -> {
                if (!Objects.equals(value, "-") && !Objects.equals(filter, "Price")) {
                    Method method = null;
                    boolean booleanValue = false;
                    if (Objects.equals(value, "yes")) {booleanValue = true;}
                    else if (Objects.equals(value, "no")) {booleanValue = false;}
                    try {
                        method = Room.class.getDeclaredMethod("get" + filter);
                    } catch (NoSuchMethodException ignored) {
                    }
                    try {
                        assert method != null;
                        if (!Objects.equals(filter, "Type")){
                            if ((boolean) method.invoke(room) != booleanValue) {
                                matchingRoom.set(false);
                            }
                        }
                        else {
                            if (method.invoke(room) != value) {
                                matchingRoom.set(false);
                            }
                        }
                    } catch (IllegalAccessException | InvocationTargetException ignored) {}
                }
            });
            if (matchingRoom.get()){
                filteredRooms.put(room.getId(),room);
            }
        });

        HashSet<Integer> idsToRemove = new HashSet<>();
        int finalGuests = guests;
        filteredRooms.forEach((id, room) -> {
            if (room.getCapacity() < finalGuests){
                idsToRemove.add(id);
            }
        });
        idsToRemove.forEach(filteredRooms::remove);
        idsToRemove.clear();

        // filteredRooms guest number filtered

        LocalDate finalCheckin = checkIn;
        LocalDate finalCheckout = checkOut;
        filteredRooms.forEach((roomID, room) -> {
            this.reservations.forEach((reservationID, reservation) -> {
                if (reservations.get(reservationID).getRoomID() == roomID){
                    if ((finalCheckin.isBefore(reservation.getCheckIn()) && finalCheckout.isAfter(reservation.getCheckIn()))
                            || ( finalCheckin.isBefore(reservation.getCheckOut()) && finalCheckout.isAfter(reservation.getCheckOut()))
                            || (finalCheckin.isBefore(reservation.getCheckIn()) && finalCheckout.isAfter(reservation.getCheckOut()))
                            || (finalCheckin.isAfter(reservation.getCheckIn()) && finalCheckout.isBefore(reservation.getCheckOut()))) {
                             idsToRemove.add(roomID);
                    }
                }
            });
        });
        idsToRemove.forEach(filteredRooms::remove);
        System.out.println("\nFinal rooms after all filters");
        filteredRooms.forEach((id, room) -> System.out.println(room));


        int nights= (int) ChronoUnit.DAYS.between(finalCheckin,finalCheckout);
        System.out.println("nights : "+nights);


        System.out.println("\nDo you want to continue for reversing a room:\n ");
        System.out.println("\n1.Yes\n2.No");
        int continueToReservation = 0;
        validInput = false;
        while (!validInput) {
            System.out.println("\n>");
            continueToReservation = scanner.nextInt();
            try {
                if ((continueToReservation==1)|| (continueToReservation==2))
                    validInput = true;
                else {
                    System.out.println("\nInvalid input, enter a valid number");
                }
            }
            catch (Exception e) {
                System.out.println("\nInvalid input, please enter a valid option");
            }
        }
        if (continueToReservation==1){
            reserve( reservations, filteredRooms, filteredRooms.get(rooms).getId(), finalCheckin, finalCheckout, nights);
        }


        filters.clear();

    }
    public void reserve(Map<Integer,Reservation> reservations,Map<Integer, Room> filteredRooms, Integer roomID, LocalDate finalCheckin, LocalDate finalCheckout,int nights) {
        System.out.println("\n+============================+");
        System.out.println("|       Reverse a room         |");
        System.out.println("+============================+");




    }

    public void cancel(){
        // todo remove reservation from reservations hashmap
    }
    public boolean isAvailable(int roomID){
        System.out.println("todo");
        return false;
    }
    /**
     *   this function shows all reservations with
     *   their characteristics
     */
    public void showReservations(){
        for(Integer id : this.customer.getReservationIDs()){
            System.out.println("id: " + reservations.get(id).getReservationID() +
                    ", guests: " + reservations.get(id).getGuestNumber() + ", check in: " +
                    reservations.get(id).getCheckIn().toString() + ", check out: " +
                    reservations.get(id).getCheckOut().toString() + ", price: $" +
                    df.format(reservations.get(id).getTotalPrice()));
        }
    }
    /**
     *   The main provider user interface. It asks for a command and calls the
     *   appropriate function.
     */
    public void panel(){
        while (true){
            System.out.println("\n+============================+");
            System.out.println("|       Customer Panel       |");
            System.out.println("+============================+");
            System.out.println("| 1. Search/reserve a room   |");
            System.out.println("| 2. Cancel reservation      |");
            System.out.println("| 3. Show all reservations   |");
            System.out.println("| 4. Log out                 |");
            System.out.println("| 5. Exit                    |");
            System.out.println("+============================+");
            int cmd = 0;
            System.out.print("\n> ");
            try {
                cmd = scanner.nextInt();
            }
            catch (java.util.InputMismatchException ignored){}
            switch (cmd) {
                case 1 -> search();
                case 2 -> cancel();
                case 3 -> showReservations();
                case 4 -> {
                    System.out.println("");
                    this.mainUI.login();
                }
                case 5 -> System.exit(0);
                default -> {
                    System.out.println("\nInvalid input, enter a valid number");
                    scanner.nextLine();
                }
            }
        }
    }
}