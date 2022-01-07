import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 13:42:26 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class customerForm extends JPanel {
    JFrame jframe;
    customerForm currentForm;
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

    public void setCurrentForm(customerForm currentForm) {
        this.currentForm = currentForm;
    }


    public customerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        this.customer= customer;
        initComponents();
    }
    
    private void cancelReservationButtonClick(ActionEvent e){
        cancelReservationCustomerForm cancelReservationCustomerForm= new cancelReservationCustomerForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        cancelReservationCustomerForm.setCurrentForm(cancelReservationCustomerForm);
        this.jframe.add(cancelReservationCustomerForm);
        this.currentForm.setVisible(false);
    }

    private void showAllReservationsButtonClick(ActionEvent e){
        showAllReservationsCustomerForm showAllReservationsCustomerForm=new showAllReservationsCustomerForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        showAllReservationsCustomerForm.setCurrentForm(showAllReservationsCustomerForm);
        this.jframe.add(showAllReservationsCustomerForm);
        this.currentForm.setVisible(false);
    }
    
    private void messagesButtonClick(ActionEvent e) {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer.getUsername());
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    private void logoutButtonClick(ActionEvent e) {
        loginForm loginForm = new loginForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages,this.mainUI);
        loginForm.setCurrentForm(loginForm);
        this.jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }

    private void exitButtonClick(ActionEvent e) {
        this.mainUI.saveAndExit();
    }

    private void reserveRoomButtonClick(ActionEvent e) {
        reserveRoomForm reserveRoomForm =new reserveRoomForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer,this.room);
        reserveRoomForm.setCurrentForm(reserveRoomForm);
        this.jframe.add(reserveRoomForm);
        this.currentForm.setVisible(false);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        SearchAndReserveRoom = new JButton();
        cancelReservation = new JButton();
        showAllReservations = new JButton();
        button1 = new JButton();
        Logout = new JButton();
        exit = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 5 5",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Customer Form");
        add(label1, "cell 3 0");

        //---- SearchAndReserveRoom ----
        SearchAndReserveRoom.setText("Reserve room");
        SearchAndReserveRoom.addActionListener(e -> reserveRoomButtonClick(e));
        add(SearchAndReserveRoom, "cell 3 2");

        //---- cancelReservation ----
        cancelReservation.setText("Cancel Reservation");
        cancelReservation.addActionListener(e -> cancelReservationButtonClick(e));
        add(cancelReservation, "cell 3 3");

        //---- showAllReservations ----
        showAllReservations.setText("Show All Reservations");
        showAllReservations.addActionListener(e -> showAllReservationsButtonClick(e));
        add(showAllReservations, "cell 3 4");

        //---- button1 ----
        button1.setText("Messages");
        button1.addActionListener(e -> messagesButtonClick(e));
        add(button1, "cell 3 5");

        //---- Logout ----
        Logout.setText("Log Out");
        Logout.addActionListener(e -> logoutButtonClick(e));
        add(Logout, "cell 3 6");

        //---- exit ----
        exit.setText("Exit");
        exit.addActionListener(e -> exitButtonClick(e));
        add(exit, "cell 3 7");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JButton SearchAndReserveRoom;
    private JButton cancelReservation;
    private JButton showAllReservations;
    private JButton button1;
    private JButton Logout;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
