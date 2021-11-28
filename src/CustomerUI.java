import java.util.HashMap;
import java.util.Map;

public class CustomerUI {
    private final Customer customer;
    private final Map<Integer,Room> rooms;

    public CustomerUI(Customer customer, Map<Integer,Room> rooms) {
        this.customer = customer;
        this.rooms = rooms;
    }

    public void search(HashMap<String,String> filters){
        // todo search rooms based on filters
    }
    public void reserve(){
        // todo call reservation constructor and add reservation to reservation hashset
    }
    public void cancel(int reservationID){
        // todo remove reservation from reservations hashmap
    }
    /*public boolean isAvailable(int roomID){
        // todo
    }
    public HashSet<Reservation> showReservations(String username){
        // todo
    }*/
    public void start(){
        // todo
    }
}
