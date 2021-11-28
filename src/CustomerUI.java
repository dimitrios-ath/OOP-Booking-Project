import java.util.HashMap;
import java.util.HashSet;

public class CustomerUI {
    Customer customer;
    public CustomerUI(Customer customer) {
        this.customer = customer;
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
