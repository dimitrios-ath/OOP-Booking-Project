import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import net.miginfocom.swing.*;

/*
 * Created by JFormDesigner on Thu Jan 06 23:00:15 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class reserveRoomCustomerForm extends JPanel {
    JFrame jframe;
    reserveRoomCustomerForm currentForm;
    private final Customer customer;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    private final ArrayList<Integer> idsInList;
    DefaultListModel<String> model;
    private static DecimalFormat df;
    private final int guests;
    LocalDate checkIn;
    LocalDate checkOut;
    Map<Integer, Room> filteredRooms;
    Map<String,Boolean> previousFilters;
    private final long nights;
    String type;
    String maxPrice;


    public void setCurrentForm(reserveRoomCustomerForm currentForm) {
        this.currentForm = currentForm;
    }

    public reserveRoomCustomerForm(JFrame jframe, Map<Integer, Reservation> reservations, Map<Integer, Room> rooms,
                                   Map<String, Authentication> users, Map<String, Customer> customers, Map<String, Provider> providers,
                                   Map<String, Admin> admins, Map<Integer, Message> messages, MainUI mainUI, Customer customer,
                                   int guests, LocalDate checkIn, LocalDate checkOut, Map<Integer, Room> filteredRooms,
                                   Map<String,Boolean> previousFilters, String type, String maxPrice) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.customer = customer;
        this.filteredRooms = filteredRooms;
        this.guests = guests;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.previousFilters = previousFilters;
        this.type = type;
        this.maxPrice = maxPrice;
        initComponents();

        idsInList = new ArrayList<>();
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        AtomicBoolean noRoomsForReservation = new AtomicBoolean(true);
        this.filteredRooms.forEach((roomID, room) -> {
            model.addElement("Name: \"" + room.getName() +
                    "\", Type: " + room.getType() + ", Capacity: " +
                    room.getCapacity() + ", Price/night: $" +
                    df.format(room.getPrice()) + ", Total price: $" +
                    df.format((room.getPrice()*nights)));
            idsInList.add(roomID);
            noRoomsForReservation.set(false);
        });
        if (noRoomsForReservation.get()) {
            model.addElement("No rooms found");
            list1.setEnabled(false);
            button2.setEnabled(false);
        }
        list1.setModel(model);
    }

        private void reserveButtonClick() {
            if (list1.isEnabled() && !list1.isSelectionEmpty()) {
                boolean addedToHashMap = false;
                int i=1;
                while(!addedToHashMap && i<1000) {
                    if (!reservations.containsKey(i)) {
                        int roomID = idsInList.get(list1.getSelectedIndex());
                        reservations.put(i, new Reservation(i, guests, nights, roomID,
                                checkIn, checkOut, this.customer.getUsername(),
                                this.rooms.get(roomID).getPrice()*nights));
                        addedToHashMap = true;
                        cancelButtonClick();
                    }
                    else {i++;}
                }
            }
        }

        public void backButtonClick(){
            reserveRoomForm reserveRoomForm = new reserveRoomForm(this.jframe, this.reservations, this.rooms,
                    this.users,this.customers,this.providers,this.admins, this.messages, this.mainUI, this.customer);
            reserveRoomForm.setCurrentForm(reserveRoomForm);
            reserveRoomForm.returnToPreviousFormState(guests, checkIn, checkOut, maxPrice, type, previousFilters);
            this.jframe.add(reserveRoomForm);
            this.currentForm.setVisible(false);
        }

        private void cancelButtonClick() {
            customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users,
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.customer);
            customerForm.setCurrentForm(customerForm);
            this.jframe.add(customerForm);
            this.currentForm.setVisible(false);
        }

        private void initComponents () {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - asdfasdfa
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            list1 = new JList<>();
            button3 = new JButton();
            button1 = new JButton();
            button2 = new JButton();

            //======== this ========
            setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.
            awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
            ; addPropertyChangeListener(e -> {if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException();})
            ;
            setLayout(new MigLayout(
                "insets 0,hidemode 3,gap 5 5",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[fill]" +
                "[]" +
                "[fill]" +
                "[fill]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("Reserve a room");
            add(label1, "cell 3 1");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(list1);
            }
            add(scrollPane1, "cell 1 3 13 1");

            //---- button3 ----
            button3.setText("Cancel");
            button3.addActionListener(e -> cancelButtonClick());
            add(button3, "cell 3 6");

            //---- button1 ----
            button1.setText("Back");
            button1.addActionListener(e -> backButtonClick());
            add(button1, "cell 6 6");

            //---- button2 ----
            button2.setText("Reserve");
            button2.addActionListener(e -> reserveButtonClick());
            add(button2, "cell 9 6");
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

            // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
            // Generated using JFormDesigner Evaluation license - asdfasdfa
            private JLabel label1;
            private JScrollPane scrollPane1;
            private JList<String> list1;
            private JButton button3;
            private JButton button1;
            private JButton button2;
            // JFormDesigner - End of variables declaration  //GEN-END:variables
        }
