import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Map;
import javax.swing.border.*;
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
        jframe.setPreferredSize(new Dimension(310 , 400));
        jframe.pack();
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
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        SearchAndReserveRoom = new JButton();
        cancelReservation = new JButton();
        showAllReservations = new JButton();
        button1 = new JButton();
        Logout = new JButton();
        exit = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
        EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing
        . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
        java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
        { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )
        throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("Customer Form");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(65, 20, 180, label1.getPreferredSize().height);

        //---- SearchAndReserveRoom ----
        SearchAndReserveRoom.setText("Reserve room");
        SearchAndReserveRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        SearchAndReserveRoom.setForeground(Color.white);
        SearchAndReserveRoom.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        SearchAndReserveRoom.addActionListener(e -> reserveRoomButtonClick(e));
        add(SearchAndReserveRoom);
        SearchAndReserveRoom.setBounds(50, 70, 210, 40);

        //---- cancelReservation ----
        cancelReservation.setText("Cancel Reservation");
        cancelReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelReservation.setForeground(Color.white);
        cancelReservation.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        cancelReservation.addActionListener(e -> cancelReservationButtonClick(e));
        add(cancelReservation);
        cancelReservation.setBounds(50, 115, 210, 40);

        //---- showAllReservations ----
        showAllReservations.setText("Show Reservations");
        showAllReservations.setFont(new Font("Tahoma", Font.BOLD, 14));
        showAllReservations.setForeground(Color.white);
        showAllReservations.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        showAllReservations.addActionListener(e -> showAllReservationsButtonClick(e));
        add(showAllReservations);
        showAllReservations.setBounds(50, 160, 210, 40);

        //---- button1 ----
        button1.setText("Messages");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> messagesButtonClick(e));
        add(button1);
        button1.setBounds(50, 205, 210, 40);

        //---- Logout ----
        Logout.setText("Log Out");
        Logout.setFont(new Font("Tahoma", Font.BOLD, 14));
        Logout.setForeground(Color.white);
        Logout.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        Logout.addActionListener(e -> logoutButtonClick(e));
        add(Logout);
        Logout.setBounds(95, 270, 125, 40);

        //---- exit ----
        exit.setText("Exit");
        exit.setFont(new Font("Tahoma", Font.BOLD, 14));
        exit.setForeground(Color.white);
        exit.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        exit.addActionListener(e -> exitButtonClick(e));
        add(exit);
        exit.setBounds(95, 315, 125, 40);

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
