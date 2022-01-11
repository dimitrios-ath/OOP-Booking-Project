import java.awt.*;
import javax.swing.*;
import java.util.Map;

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

    /**
     * Constructor of customerForm
     *
     * @param jframe
     * @param reservations
     * @param rooms
     * @param users
     * @param customers
     * @param providers
     * @param admins
     * @param messages
     * @param mainUI
     * @param customer
     */
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

    /**
     *  Display the customer cancel reservation form
     */
    private void cancelReservationButtonClick(){
        customerCancelReservationForm customerCancelReservationForm = new customerCancelReservationForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        customerCancelReservationForm.setCurrentForm(customerCancelReservationForm);
        this.jframe.add(customerCancelReservationForm);
        this.currentForm.setVisible(false);
    }

    /**
     *  Display the customer show all reservations form
     */
    private void showAllReservationsButtonClick(){
        customerShowAllReservationsForm customerShowAllReservationsForm =new customerShowAllReservationsForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        customerShowAllReservationsForm.setCurrentForm(customerShowAllReservationsForm);
        this.jframe.add(customerShowAllReservationsForm);
        this.currentForm.setVisible(false);
    }

    /**
     *  Display the message form
     */
    private void messagesButtonClick() {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer.getUsername());
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    /**
     *  Logout
     */
    private void logoutButtonClick() {
        loginForm loginForm = new loginForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages,this.mainUI);
        loginForm.setCurrentForm(loginForm);
        this.jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Save everything changed and exit
     */
    private void exitButtonClick() {
        this.mainUI.saveAndExit();
    }

    /**
     *  Display the reserve room form
     */
    private void reserveRoomButtonClick() {
        customerReserveRoomFiltersForm customerReserveRoomFiltersForm =new customerReserveRoomFiltersForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.customer);
        customerReserveRoomFiltersForm.setCurrentForm(customerReserveRoomFiltersForm);
        this.jframe.add(customerReserveRoomFiltersForm);
        this.currentForm.setVisible(false);
    }

    /**
     *   Form generator
     */
    private void initComponents() {
        JLabel label1 = new JLabel();
        JButton searchAndReserveRoom = new JButton();
        JButton cancelReservation = new JButton();
        JButton showAllReservations = new JButton();
        JButton button1 = new JButton();
        JButton logout = new JButton();
        JButton exit = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Customer Form");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(65, 20, 180, label1.getPreferredSize().height);

        //---- SearchAndReserveRoom ----
        searchAndReserveRoom.setText("Reserve room");
        searchAndReserveRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchAndReserveRoom.setForeground(new Color(51, 102, 255));

        searchAndReserveRoom.addActionListener(e -> reserveRoomButtonClick());
        add(searchAndReserveRoom);
        searchAndReserveRoom.setBounds(50, 70, 210, 40);

        //---- cancelReservation ----
        cancelReservation.setText("Cancel Reservation");
        cancelReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelReservation.setForeground(new Color(51, 102, 255));

        cancelReservation.addActionListener(e -> cancelReservationButtonClick());
        add(cancelReservation);
        cancelReservation.setBounds(50, 115, 210, 40);

        //---- showAllReservations ----
        showAllReservations.setText("Show Reservations");
        showAllReservations.setFont(new Font("Tahoma", Font.BOLD, 14));
        showAllReservations.setForeground(new Color(51, 102, 255));

        showAllReservations.addActionListener(e -> showAllReservationsButtonClick());
        add(showAllReservations);
        showAllReservations.setBounds(50, 160, 210, 40);

        //---- button1 ----
        button1.setText("Messages");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> messagesButtonClick());
        add(button1);
        button1.setBounds(50, 205, 210, 40);

        //---- Logout ----
        logout.setText("Log Out");
        logout.setFont(new Font("Tahoma", Font.BOLD, 14));
        logout.setForeground(new Color(51, 102, 255));

        logout.addActionListener(e -> logoutButtonClick());
        add(logout);
        logout.setBounds(95, 270, 125, 40);

        //---- exit ----
        exit.setText("Exit");
        exit.setFont(new Font("Tahoma", Font.BOLD, 14));
        exit.setForeground(new Color(51, 102, 255));

        exit.addActionListener(e -> exitButtonClick());
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
    }
}
