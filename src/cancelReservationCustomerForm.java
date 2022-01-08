import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 16:02:24 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class cancelReservationCustomerForm extends JPanel {
    JFrame jframe;
    cancelReservationCustomerForm currentForm;
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

    public void setCurrentForm(cancelReservationCustomerForm currentForm) {
        this.currentForm = currentForm;
    }

    public cancelReservationCustomerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                                         Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                                         Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Customer customer) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.customer=customer;
        initComponents();

        idsInList = new ArrayList<>() ;
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        AtomicBoolean noRoomsForCustomer = new AtomicBoolean(true);

        this.reservations.forEach((reservationID, reservation) -> {
         if (Objects.equals(reservation.getUsername(),this.customer.getUsername())){
             model.addElement("Reservation ID: " + reservation.getReservationID()
                     + ", Guest number: " + reservation.getGuestNumber()+", Total nights: " + reservation.getTotalNights()+
                     ", Room id: " + reservation.getRoomID() + ", Room name: \"" + this.rooms.get(reservation.getRoomID()).getName() +
                     "\", Check in: " + reservation.getCheckIn() + ", Check out: " + reservation.getCheckOut() + ", Price/night: $" +
                     df.format(reservation.getTotalPrice()/reservation.getTotalNights()) + ", Total cost: $" +
                     df.format(reservation.getTotalPrice()));
             idsInList.add(reservationID);
             noRoomsForCustomer.set(false);
         }
        });
        if (noRoomsForCustomer.get()){
            model.addElement("No reservations found");
            list1.setEnabled(false);
        }
        list1.setModel(model);


    }

   private void cancelReservationButtonClick() {
       int id;
       if (!list1.isSelectionEmpty()){
           id=idsInList.get(list1.getSelectedIndex());
           if (reservations.containsKey(id) && Objects.equals(reservations.get(id).getUsername(),customer.getUsername())){
               reservations.remove(id);
               label1.setText("Successfully canceled reservation");
               label1.setForeground(Color.green);
               label1.setVisible(true);
               customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                       this.providers, this.admins, this.messages, this.mainUI, this.customer);
               customerForm.setCurrentForm(customerForm);
               this.jframe.add(customerForm);
               this.currentForm.setVisible(false);
           }
           else{
               label1.setText("Failed to cancel this reservation");
               label1.setForeground(Color.red);
               label1.setVisible(true);
           }


       }
   }

   private void returnButtonClick() {
       customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
               this.providers, this.admins, this.messages, this.mainUI, this.customer);
       customerForm.setCurrentForm(customerForm);
       this.jframe.add(customerForm);
       this.currentForm.setVisible(false);
   }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        buttonCancel = new JButton();
        buttonCancelReservation = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
        .border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder
        .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.
        awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
        ; addPropertyChangeListener(e -> {if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();})
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
            "[fill]",
            // rows
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Cancel Reservation");
        add(label1, "cell 5 0");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 4 2 3 1");

        //---- buttonCancel ----
        buttonCancel.setText("Return");
        buttonCancel.addActionListener(e -> returnButtonClick());
        add(buttonCancel, "cell 3 4");

        //---- buttonCancelReservation ----
        buttonCancelReservation.setText("Cancel");
        buttonCancelReservation.addActionListener(e -> cancelReservationButtonClick());
        add(buttonCancelReservation, "cell 8 4");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JButton buttonCancel;
    private JButton buttonCancelReservation;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
