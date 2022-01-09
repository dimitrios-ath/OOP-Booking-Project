import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
    private final Customer customer;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

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
        jframe.setPreferredSize(new Dimension(385 , 318));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
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
                this.admins, this.messages, this.mainUI, this.customer);
        reserveRoomForm.setCurrentForm(reserveRoomForm);
        this.jframe.add(reserveRoomForm);
        this.currentForm.setVisible(false);
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label1 = new JLabel();
        SearchAndReserveRoom = new JButton();
        cancelReservation = new JButton();
        showAllReservations = new JButton();
        button1 = new JButton();
        Logout = new JButton();
        exit = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("Customer Form");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(105, 5, 180, label1.getPreferredSize().height);

        //---- SearchAndReserveRoom ----
        SearchAndReserveRoom.setText("Reserve room");
        SearchAndReserveRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        SearchAndReserveRoom.setForeground(new Color(51, 102, 255));
        SearchAndReserveRoom.addActionListener(e -> reserveRoomButtonClick(e));
        add(SearchAndReserveRoom);
        SearchAndReserveRoom.setBounds(90, 80, 200, SearchAndReserveRoom.getPreferredSize().height);

        //---- cancelReservation ----
        cancelReservation.setText("Cancel Reservation");
        cancelReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelReservation.setForeground(new Color(51, 102, 255));
        cancelReservation.addActionListener(e -> cancelReservationButtonClick(e));
        add(cancelReservation);
        cancelReservation.setBounds(90, 110, 200, cancelReservation.getPreferredSize().height);

        //---- showAllReservations ----
        showAllReservations.setText("Show All Reservations");
        showAllReservations.setFont(new Font("Tahoma", Font.BOLD, 14));
        showAllReservations.setForeground(new Color(51, 102, 255));
        showAllReservations.addActionListener(e -> showAllReservationsButtonClick(e));
        add(showAllReservations);
        showAllReservations.setBounds(90, 170, 200, showAllReservations.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Messages");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));
        button1.addActionListener(e -> messagesButtonClick(e));
        add(button1);
        button1.setBounds(90, 140, 200, button1.getPreferredSize().height);

        //---- Logout ----
        Logout.setText("Log Out");
        Logout.setFont(new Font("Tahoma", Font.BOLD, 14));
        Logout.setForeground(new Color(51, 102, 255));
        Logout.addActionListener(e -> logoutButtonClick(e));
        add(Logout);
        Logout.setBounds(90, 215, 200, Logout.getPreferredSize().height);

        //---- exit ----
        exit.setText("Exit");
        exit.setFont(new Font("Tahoma", Font.BOLD, 14));
        exit.setForeground(new Color(51, 102, 255));
        exit.addActionListener(e -> exitButtonClick(e));
        add(exit);
        exit.setBounds(90, 245, 200, exit.getPreferredSize().height);

        //---- label2 ----
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        label2.setBackground(new Color(51, 102, 255));
        add(label2);
        label2.setBounds(20, 35, 300, 15);

        //---- label3 ----
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setBackground(new Color(51, 102, 255));
        add(label3);
        label3.setBounds(20, 55, 300, 15);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label1;
    private JButton SearchAndReserveRoom;
    private JButton cancelReservation;
    private JButton showAllReservations;
    private JButton button1;
    private JButton Logout;
    private JButton exit;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
