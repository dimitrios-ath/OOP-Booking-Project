import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 07 15:16:45 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class returnAllReservationsAdminForm extends JPanel {
    JFrame jframe;
    returnAllReservationsAdminForm currentForm;
    private Admin admin;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
    DefaultListModel<String> model;
    private static DecimalFormat df;
    AtomicBoolean noReservationsFound;

    public void setCurrentForm(returnAllReservationsAdminForm currentForm) {
        this.currentForm = currentForm;
    }

    public returnAllReservationsAdminForm(JFrame jframe, Map<Integer,Reservation> reservations,
                          Map<Integer,Room> rooms, Map<String,Authentication> users, Map<String,Customer> customers,
                          Map<String,Provider> providers, Map<String,Admin> admins,
                          Map<Integer,Message> messages, MainUI mainUI, Admin admin) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.admin = admin;
        initComponents();

        df = new DecimalFormat("0.00");
        model = new DefaultListModel<String>();
        noReservationsFound = new AtomicBoolean(true);
        this.reservations.forEach((reservationID, reservation) -> {
            model.addElement("Reservation ID: " + reservation.getReservationID()
                    +", Total Guests: " + reservation.getGuestNumber()+", Total nights: " + reservation.getTotalNights()+
                    ", Room ID: " + reservation.getRoomID() +", Check in: " + reservation.getCheckIn() + ", Check out: " +
                    reservation.getCheckOut() + ", Price/night: " + df.format(reservation.getTotalPrice() /
                    reservation.getTotalNights()) + "$, Total cost: " + df.format(reservation.getTotalPrice()) + "$");
            noReservationsFound.set(false);
        });
        if (noReservationsFound.get()) {
            model.addElement("No reservations found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void returnButtonClick(ActionEvent e) {
        adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admin);
        adminForm.setCurrentForm(adminForm);
        this.jframe.add(adminForm);
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(new MigLayout(
            "hidemode 3",
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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("All reservations:");
        add(label1, "cell 6 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 3 2 6 1");

        //---- button1 ----
        button1.setText("Return");
        button1.addActionListener(e -> returnButtonClick(e));
        add(button1, "cell 6 4");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
