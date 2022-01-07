import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.util.Map;
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
                        Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI,Customer customer) {
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

    private void searchReserveButtonClick(ActionEvent e){
        /*SearchAndReserveCustomerForm searchAndReserveCustomerForm=new SearchAndReserveCustomerForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer,this.room);
        searchAndReserveCustomerForm.setCurrentForm(searchAndReserveCustomerForm);
        this.jframe.add(searchAndReserveCustomerForm);
        this.currentForm.setVisible(false);
*/
    }
    private void cancelReservationButtonClick(ActionEvent e){
        CancelReservationCustomerForm cancelReservationCustomerForm= new CancelReservationCustomerForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        cancelReservationCustomerForm.setCurrentForm(cancelReservationCustomerForm);
        this.jframe.add(cancelReservationCustomerForm);
        this.currentForm.setVisible(false);
    }
    private void showAllReservationsButtonClick(ActionEvent e){
        ShowAllReservationsCustomerForm showAllReservationsCustomerForm=new ShowAllReservationsCustomerForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        showAllReservationsCustomerForm.setCurrentForm(showAllReservationsCustomerForm);
        this.jframe.add(showAllReservationsCustomerForm);
        this.currentForm.setVisible(false);
    }
    private void messagesClickButton(ActionEvent e){
        /*MessagesCustomerForm messagesCustomerForm= new MessagesCustomerForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        messagesCustomerForm.setCurrentForm(messagesCustomerForm);
        this.jframe.add(messagesCustomerForm);
        this.currentForm.setVisible(false);*/
    }
    private void logoutClickButton(ActionEvent e) {
        loginForm loginForm = new loginForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages,this.mainUI);
        loginForm.setCurrentForm(loginForm);
        this.jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }
    private void exitClickButton (ActionEvent e){
            this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label1 = new JLabel();
        SearchAndReserveRoom = new JButton();
        cancelReservation = new JButton();
        showAllReservations = new JButton();
        message = new JButton();
        Logout = new JButton();
        exit = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;

        //---- label1 ----
        label1.setText("Customer Form");

        //---- SearchAndReserveRoom ----
        SearchAndReserveRoom.setText("Search/ Reserve a room");

        //---- cancelReservation ----
        cancelReservation.setText("Cancel Reservation");
        cancelReservation.addActionListener(e ->cancelReservationButtonClick(e));

        //---- showAllReservations ----
        showAllReservations.setText("Show All Reservations");
        showAllReservations.addActionListener(e ->showAllReservationsButtonClick(e));

        //---- message ----
        message.setText("Messages");
        message.addActionListener(e -> messagesClickButton(e));

        //---- Logout ----
        Logout.setText("Log Out");
        Logout.addActionListener(e ->logoutClickButton(e));

        //---- exit ----
        exit.setText("Exit");
        exit.addActionListener(e ->exitClickButton(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(82, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(exit, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addComponent(message, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addComponent(showAllReservations, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addComponent(cancelReservation, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addComponent(SearchAndReserveRoom, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addComponent(Logout, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                    .addContainerGap(42, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(211, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(SearchAndReserveRoom)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cancelReservation)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(showAllReservations)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(message)
                    .addGap(8, 8, 8)
                    .addComponent(Logout)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(exit)
                    .addContainerGap(80, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label1;
    private JButton SearchAndReserveRoom;
    private JButton cancelReservation;
    private JButton showAllReservations;
    private JButton message;
    private JButton Logout;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
