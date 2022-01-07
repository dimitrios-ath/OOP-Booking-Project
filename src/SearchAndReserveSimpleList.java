import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.time.LocalDate.parse;
/*
 * Created by JFormDesigner on Thu Jan 06 23:00:15 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class SearchAndReserveSimpleList extends JPanel {
    JFrame jframe;
    SearchAndReserveSimpleList currentForm;
    private Room room;
    private Customer customer;
    private MainUI mainUI;
    private Map<Integer, Reservation> reservations;
    private Map<Integer, Room> rooms;
    private Map<String, Authentication> users;
    private Map<String, Customer> customers;
    private Map<String, Provider> providers;
    private Map<String, Admin> admins;
    private Map<Integer, Message> messages;
    private ArrayList<Integer> idsInList;
    DefaultListModel<String> model;
    private static DecimalFormat df;
    private MainUI mainui;
    private int guests;
    LocalDate dateCheckinn;
    LocalDate dateCheckoutt;
    private long night;


    public void setCurrentForm(SearchAndReserveSimpleList currentForm) {
        this.currentForm = currentForm;
    }

    public SearchAndReserveSimpleList(JFrame jframe, Map<Integer, Reservation> reservations, Map<Integer, Room> rooms,
                                      Map<String, Authentication> users, Map<String, Customer> customers, Map<String, Provider> providers,
                                      Map<String, Admin> admins, Map<Integer, Message> messages, MainUI mainUI, Customer customer,
                                      int guests,LocalDate dateCheckinn,LocalDate dateCheckoutt) {
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

        this.guests = guests;
        this.dateCheckinn = dateCheckinn;
        this.dateCheckoutt = dateCheckoutt;
        initComponents();


        idsInList = new ArrayList<>();
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<String>();
        AtomicBoolean noRoomsForReservatioon = new AtomicBoolean(true);

       /* String dateIn = dateCheckinn;
        LocalDate dateCheckin = LocalDate.of(1, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            dateCheckin = LocalDate.parse(dateIn, dtf);
        } catch (java.time.format.DateTimeParseException ignored) {
        }

        String dateOut = dateCheckoutt;
        LocalDate dateCheckout = LocalDate.of(1, 1, 1);
        DateTimeFormatter pos = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            dateCheckout = LocalDate.parse(dateOut, pos);
        } catch (java.time.format.DateTimeParseException ignored) {
        }
        */

        long nights = ChronoUnit.DAYS.between(dateCheckinn, dateCheckoutt);

        HashSet<Integer> idsToRemove = new HashSet<>();
        rooms.forEach((id, room) -> {
            if (room.getCapacity() <= guests)
                idsToRemove.add(id);
        });
        idsToRemove.forEach(rooms::remove);
        LocalDate finalCheckIn = dateCheckinn;
        LocalDate finalCheckOut = dateCheckoutt;
        rooms.forEach((roomID, room) -> this.reservations.forEach((reservationID, reservation) -> {
            if (reservations.get(reservationID).getRoomID() == roomID) {
                if ((finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckIn()))
                        || (finalCheckIn.isBefore(reservation.getCheckOut()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isAfter(reservation.getCheckIn()) && finalCheckOut.isBefore(reservation.getCheckOut()))) {
                    idsToRemove.add(roomID);
                }
            }
        }));
        if (rooms.size() == 0) {
            model.addElement("No rooms for reservation found");
            list1.setEnabled(false);
            list1.setModel(model);
        } else {
            rooms.forEach((id, room) -> {

                model.addElement(  "Name: \"" + rooms.get(id).getName() + "\", type: " + rooms.get(id).getType() + ", Capacity: " +
                        rooms.get(id).getCapacity().toString() + ", Price/night: $" + df.format(rooms.get(id).getPrice()) +
                        ", Total price: $" + df.format((rooms.get(id).getPrice() * nights)));
                idsInList.add(id);
            });
            list1.setModel(model);
        }
    }

        private void reserveButtonClick (ActionEvent e) {

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


        public void cancelButtonClick(ActionEvent e){
            SearchAndReserveCustomerForm searchAndReserveCustomerForm= new SearchAndReserveCustomerForm(this.jframe,this.reservations,this.rooms,this.users,this.customers,this.providers,this.admins,
                  this.messages,this.mainui,this.customer,this.room);
            searchAndReserveCustomerForm.setCurrentForm(searchAndReserveCustomerForm);
            this.jframe.add(searchAndReserveCustomerForm);
            this.currentForm.setVisible(false);
        }


            private void initComponents () {
                // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
                scrollPane1 = new JScrollPane();
                list1 = new JList();
                button1 = new JButton();
                button2 = new JButton();
                label1 = new JLabel();

                //======== this ========
                setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
                , 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
                , new java. awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
                 getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
                ) { if( "borde\u0072" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(list1);
                }

                //---- button1 ----
                button1.setText("cancel");
                button1.addActionListener(e ->cancelButtonClick(e));

                //---- button2 ----
                button2.setText("reserve");
                button2.addActionListener(e->reserveButtonClick(e));

                //---- label1 ----
                label1.setText("label");

                GroupLayout layout = new GroupLayout(this);
                setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(button1)
                                    .addGap(76, 76, 76)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                    .addGap(257, 257, 257))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(104, 104, 104)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(45, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(16, 16, 16))
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
