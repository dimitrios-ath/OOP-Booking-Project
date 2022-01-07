import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Created by JFormDesigner on Thu Jan 06 21:58:12 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class FilteredSearchRoomList extends JPanel {

    JFrame jframe;
    FilteredSearchRoomList currentForm;
    private Customer customer;
    private Room room;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
   boolean balcony=false;
    boolean kitchen=false ;
    boolean wifi=false ;
    boolean parking=false;
    boolean airCondition=false;
    boolean fridge=false;
    boolean tv=false;
    boolean smoking=false;
    boolean pets=false;
    int guests=0;
    int metres=0;
    private ArrayList<Integer> idsInList;
    DefaultListModel<String> model;
    private static DecimalFormat df;
    LocalDate dateCheckinn;
    LocalDate dateCheckoutt;
    double price;
    boolean longAccomond=false;



    public void setCurrentForm(FilteredSearchRoomList currentForm) {
        this.currentForm = currentForm;
    }


    public FilteredSearchRoomList(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                                          Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                                          Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI,Customer customer,
                                  boolean balcony,boolean kitchen,boolean wifi,boolean parking,boolean airCondition,boolean fridge,
                                  boolean tv,boolean smoking,boolean longAccomond,boolean pets,int guests,LocalDate dateCheckinn,LocalDate dateCheckoutt,double price,int metres) {
         this.jframe = jframe;
         this.reservations = reservations;
         this.rooms = rooms;
         this.users = users;
         this.customers = customers;
         this.providers = providers;
         this.admins = admins;
         this.messages = messages;
         this.mainUI = mainUI;
         this.customer= customer;
         this.balcony=balcony;
         this.kitchen=kitchen;
         this.wifi=wifi;
         this.parking=parking;
         this.airCondition=airCondition;
         this.fridge = fridge ;
         this.tv = tv;
         this.smoking=smoking ;
         this.longAccomond=longAccomond;
         this.pets=pets ;
         this.guests=guests;
        this.dateCheckinn = dateCheckinn;
        this.dateCheckoutt = dateCheckoutt;
        this.price=price;
        this.metres=metres;
        initComponents();

        idsInList = new ArrayList<>();
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<String>();
        long nights = ChronoUnit.DAYS.between(dateCheckinn, dateCheckoutt);


        Map<Integer, Room> filteredRooms = new HashMap<>();
        HashSet<Integer> idsToRemove = new HashSet<>();

        this.rooms.forEach((roomID,room) -> {
            if (room.getCapacity() <= guests && room.getPrice() > price && room.getBalcony() == balcony && room.getAirCondition() == airCondition
                    &&room.getFridge() == fridge && room.getKitchen() == kitchen && room.getParking() == parking && room.getWifi() == wifi && room.getLongTime() == longAccomond
                    &&room.getSmoking() == smoking && room.getPets() == pets && room.getM2() < metres )
                      filteredRooms.put(room.getId(),room);
        });


        filteredRooms.forEach((id, room) -> {
            if (room.getCapacity() <= guests || room.getPrice() > price || room.getBalcony() != balcony || room.getAirCondition() != airCondition
                    ||room.getFridge() != fridge || room.getKitchen() != kitchen || room.getParking() != parking || room.getWifi() != wifi || room.getLongTime() != longAccomond
                    ||room.getSmoking() != smoking || room.getPets() != pets || room.getM2() < metres )
                idsToRemove.add(id);
        });

        idsToRemove.forEach(filteredRooms::remove);
        LocalDate finalCheckIn = dateCheckinn;
        LocalDate finalCheckOut = dateCheckoutt;
        filteredRooms.forEach((roomID, room) -> this.reservations.forEach((reservationID, reservation) -> {
            if (reservations.get(reservationID).getRoomID() == roomID) {
                if ((finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckIn()))
                        || (finalCheckIn.isBefore(reservation.getCheckOut()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isAfter(reservation.getCheckIn()) && finalCheckOut.isBefore(reservation.getCheckOut()))) {
                    idsToRemove.add(roomID);
                }
            }
        }));
        idsToRemove.forEach(filteredRooms::remove);

        if (filteredRooms.size() == 0) {
            model.addElement("No rooms for reservation found");
            list1.setModel(model);
            list1.setEnabled(false);

        } else {
            filteredRooms.forEach((id, room) -> {

                model.addElement(  "Name: \"" + filteredRooms.get(id).getName() + "\", type: " + filteredRooms.get(id).getType() + ", Capacity: " +
                        filteredRooms.get(id).getCapacity().toString() + ", Price/night: $" + df.format(filteredRooms.get(id).getPrice()) +
                        ", Total price: $" + df.format((filteredRooms.get(id).getPrice() * nights)));
                idsInList.add(id);
            });
            list1.setModel(model);
        }

        
    }
    private void reserveButtonClick(ActionEvent e){
        long nights = ChronoUnit.DAYS.between(dateCheckinn, dateCheckoutt);
        int id=0 ;
        int i = 1;
        if (!list1.isSelectionEmpty()) {
            id = idsInList.get(list1.getSelectedIndex());
            int ID = id;
            AtomicBoolean addedToHashMap = new AtomicBoolean(false);
            while (!addedToHashMap.get() && i < 100) {
                if (!reservations.containsKey(i)) {
                    this.reservations.put(i, new Reservation(i, guests, nights, rooms.get(ID).getId(), dateCheckinn, dateCheckoutt,
                            this.customer.getUsername(), rooms.get(ID).getPrice() * nights));
                    addedToHashMap.set(true);
                    label1.setText("Successful reservatio with id: " + i);
                    label1.setVisible(true);
                }
                else
                {
                    i++;
                }
            }
        }
        else{
            label1.setText("ads reservatio with id: " + id);
            label1.setVisible(true);
        }
    }
    private void cancelButtonClick(ActionEvent e){
        FilteredSearchRoomCustomerForm filteredSearchRoomCustomerForm= new FilteredSearchRoomCustomerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI,this.customer);
        filteredSearchRoomCustomerForm.setCurrentForm(filteredSearchRoomCustomerForm);
        this.jframe.add(filteredSearchRoomCustomerForm);
        this.currentForm.setVisible(false);
    }
    


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
        javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax
        .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
        .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.
        PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".
        equals(e.getPropertyName()))throw new RuntimeException();}});

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("cancel");
        button1.addActionListener(e->cancelButtonClick(e));

        //---- button2 ----
        button2.setText("reserve");
        button2.addActionListener(e ->reserveButtonClick(e));

        //---- label1 ----
        label1.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(169, 169, 169))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(157, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                    .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(23, 23, 23))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
