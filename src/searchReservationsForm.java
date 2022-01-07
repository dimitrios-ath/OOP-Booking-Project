import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 07 13:41:10 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class searchReservationsForm extends JPanel {
    JFrame jframe;
    searchReservationsForm currentForm;
    private Admin admin;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
    
    public void setCurrentForm(searchReservationsForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public searchReservationsForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                                  Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                                  Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Admin admin) {
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
    }

    private void searchByCustomerUsernameButtonClick(ActionEvent e) {
        searchByCustomerUsernameForm searchByCustomerUsernameForm = new searchByCustomerUsernameForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        searchByCustomerUsernameForm.setCurrentForm(searchByCustomerUsernameForm);
        this.jframe.add(searchByCustomerUsernameForm);
        this.currentForm.setVisible(false);
    }

    private void searchByRoomButtonClick(ActionEvent e) {
        searchByRoomIDForm searchByRoomIDForm = new searchByRoomIDForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        searchByRoomIDForm.setCurrentForm(searchByRoomIDForm);
        this.jframe.add(searchByRoomIDForm);
        this.currentForm.setVisible(false);
    }

    private void showAllReservationsButtonClick(ActionEvent e) {
        returnAllReservationsAdminForm returnAllReservationsAdminForm = new returnAllReservationsAdminForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        returnAllReservationsAdminForm.setCurrentForm(returnAllReservationsAdminForm);
        this.jframe.add(returnAllReservationsAdminForm);
        this.currentForm.setVisible(false);
    }

    private void cancelButtonClick(ActionEvent e) {
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
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
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
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Search reservations");
        add(label1, "cell 3 0");

        //---- button1 ----
        button1.setText("Search by customer");
        button1.addActionListener(e -> searchByCustomerUsernameButtonClick(e));
        add(button1, "cell 3 2");

        //---- button2 ----
        button2.setText("Search by room");
        button2.addActionListener(e -> searchByRoomButtonClick(e));
        add(button2, "cell 3 3");

        //---- button3 ----
        button3.setText("Show all reservations");
        button3.addActionListener(e -> showAllReservationsButtonClick(e));
        add(button3, "cell 3 4");

        //---- button4 ----
        button4.setText("Cancel");
        button4.addActionListener(e -> cancelButtonClick(e));
        add(button4, "cell 3 5");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
