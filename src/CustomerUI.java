import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

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
     * Reads an integer from user and returns it. If the input is
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
     *  Used in searchAndReserve() to search room based on given filters
     *  @param filters   Map of filter and value
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
                    double input = 0.0;
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
                    filters.put("Price", Double.toString(input));
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
     *  this function searches rooms based on some
     *  user's filters and calls the function reserve
     *  giving the capacity to the user to reserve
     *  whatever room he wants
     */
    public void searchAndReserve(){
        Map<String, String> filters = new HashMap<>();
        Map<Integer, Room> filteredRooms = new HashMap<>();
        AtomicBoolean matchingRoom = new AtomicBoolean(false);
        boolean validInput;
        int guests = 0, input;
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

        long nights = ChronoUnit.DAYS.between(checkIn,checkOut);

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
            }

        }

        this.rooms.forEach((roomID,room) -> {
            matchingRoom.set(true);
            filters.forEach((filter,value) -> {
                if (!Objects.equals(value, "-") && !Objects.equals(filter, "Price")) {
                    Method method = null;
                    boolean booleanValue = Objects.equals(value, "yes");
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
        filteredRooms.forEach((id, room) -> {
            if (!Objects.equals(filters.get("Price"), "-")) {
                if (room.getPrice() > Double.parseDouble(filters.get("Price"))) {
                    idsToRemove.add(id);
                }
            }
        });
        idsToRemove.forEach(filteredRooms::remove);
        idsToRemove.clear();


        int finalGuests = guests;
        filteredRooms.forEach((id, room) -> {
            if (room.getCapacity() < finalGuests){
                idsToRemove.add(id);
            }
        });
        idsToRemove.forEach(filteredRooms::remove);
        idsToRemove.clear();


        // filteredRooms guest number filtered

        LocalDate finalCheckIn = checkIn;
        LocalDate finalCheckOut = checkOut;
        filteredRooms.forEach((roomID, room) -> this.reservations.forEach((reservationID, reservation) -> {
            if (reservations.get(reservationID).getRoomID() == roomID){
                if ((finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckIn()))
                        || ( finalCheckIn.isBefore(reservation.getCheckOut()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isAfter(reservation.getCheckIn()) && finalCheckOut.isBefore(reservation.getCheckOut()))) {
                         idsToRemove.add(roomID);
                }
            }
        }));
        idsToRemove.forEach(filteredRooms::remove);

        System.out.println("\n+============================+");
        System.out.println("|      Available rooms       |");
        System.out.println("+============================+");

        var ref = new Object() {int c = 1;};
        System.out.println("\n0. Return to menu without reservation\n-------------------------------------");
        Map<Integer, Integer> matchingRooms = new HashMap<>();
        if(filteredRooms.size()==0){
            System.out.println("No rooms available\n\nReturning to main menu");
        }
        else {
            filteredRooms.forEach((id, room) -> {
                System.out.println(ref.c + ". " + "Name: \"" + filteredRooms.get(id).getName() + "\", type: " + filteredRooms.get(id).getType() + ", Capacity: " +
                        filteredRooms.get(id).getCapacity().toString() + ", Price/night: $" + df.format(filteredRooms.get(id).getPrice())+
                        ", Total price: $" + df.format((filteredRooms.get(id).getPrice()*nights)));
                matchingRooms.put(ref.c, room.getId());
                ref.c++;
            });

            int roomToReserve = -1;
            validInput = false;
            while (!validInput){
                System.out.println("\nSelect a room to reserve or press 0 to return to main menu:");
                scanner.nextLine();
                System.out.print("\n> ");
                try {
                    roomToReserve = scanner.nextInt();
                    if (roomToReserve < ref.c && roomToReserve > -1){
                        validInput = true;
                    }
                    else {
                        System.out.println("\nInvalid input, enter a valid number");
                    }
                } catch (java.util.InputMismatchException ignored){
                    System.out.println("\nInvalid input, enter a valid number");
                }
            }
            if (roomToReserve != 0){
                boolean addedToHashMap = false;
                int i=1;
                while(!addedToHashMap && i<1000) {
                    if (!reservations.containsKey(i)) {
                        reservations.put(i, new Reservation(i, guests, nights, matchingRooms.get(roomToReserve),
                                checkIn, checkOut, this.customer.getUsername(),
                                this.rooms.get(matchingRooms.get(roomToReserve)).getPrice()*nights));
                        addedToHashMap = true;
                        customer.addReservationID(i);
                        System.out.println("\nReservation complete with id: " + i);
                    }
                    else {i++;}
                }
            }
        }


        filters.clear();
    }

    public void cancelReservation(){
        System.out.println("\n+============================+");
        System.out.println("|     Cancel reservation     |");
        System.out.println("+============================+");
        showReservations();
        System.out.println("\nEnter reservation ID to cancel:");
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
        if (reservations.containsKey(id) && customer.getReservationIDs().contains(id) && validInput) {
            reservations.remove(id);
            customer.removeReservationID(id);
            System.out.println("\nSuccessfully canceled with the following id: " + id);
        }
        else if (validInput){
            System.out.println("\nFailed to cancel reservation with the following id: " + id);
        }
    }

    /**
     *   this function shows all reservations with
     *   their characteristics
     */
    public void showReservations(){
        System.out.println("\n+============================+");
        System.out.println("|     Show reservations      |");
        System.out.println("+============================+");
        if (this.customer.getReservationIDs().size()==0){
            System.out.println("\nNo reservations found");
        } else {System.out.println();}
        for(Integer id : this.customer.getReservationIDs()){
            System.out.println("Reservation id: " + reservations.get(id).getReservationID() +
                    ", Room name: \"" + this.rooms.get(reservations.get(id).getRoomID()).getName() +
                    "\", Room type: " + this.rooms.get(reservations.get(id).getRoomID()).getType() +
                    ", Guests: " + reservations.get(id).getGuestNumber() + ", Check in: " +
                    reservations.get(id).getCheckIn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ", Check out: " +
                    reservations.get(id).getCheckOut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ", Total price: $" +
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
                case 1 -> searchAndReserve();
                case 2 -> cancelReservation();
                case 3 -> showReservations();
                case 4 -> this.mainUI.optionHandler();
                case 5 -> System.exit(0);
                default -> {
                    System.out.println("\nInvalid input, enter a valid number");
                    scanner.nextLine();
                }
            }
        }
    }
}