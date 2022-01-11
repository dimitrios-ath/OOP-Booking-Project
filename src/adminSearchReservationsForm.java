import java.awt.*;
import java.util.Map;
import javax.swing.*;

public class adminSearchReservationsForm extends JPanel {
    JFrame jframe;
    adminSearchReservationsForm currentForm;
    private final Admin admin;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    
    public void setCurrentForm(adminSearchReservationsForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Constructor of adminSearchReservationsForm
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
     * @param admin
     */
    public adminSearchReservationsForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        jframe.setPreferredSize(new Dimension(320, 320));
        jframe.pack();
    }

    /**
     * Proceeds to search customer reservations form
     */
    private void searchByCustomerUsernameButtonClick() {
        adminSearchCustomerReservationsForm adminSearchCustomerReservationsForm = new adminSearchCustomerReservationsForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        adminSearchCustomerReservationsForm.setCurrentForm(adminSearchCustomerReservationsForm);
        this.jframe.add(adminSearchCustomerReservationsForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Proceeds to search room reservations form
     */
    private void searchByRoomButtonClick() {
        adminSearchRoomReservationsForm adminSearchRoomReservationsForm = new adminSearchRoomReservationsForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        adminSearchRoomReservationsForm.setCurrentForm(adminSearchRoomReservationsForm);
        this.jframe.add(adminSearchRoomReservationsForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Proceeds to display all reservations form
     */
    private void showAllReservationsButtonClick() {
        adminReturnAllReservationsForm adminReturnAllReservationsForm = new adminReturnAllReservationsForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        adminReturnAllReservationsForm.setCurrentForm(adminReturnAllReservationsForm);
        this.jframe.add(adminReturnAllReservationsForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Returns to admin panel
     */
    private void cancelButtonClick() {
        adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admin);
        adminForm.setCurrentForm(adminForm);
        this.jframe.add(adminForm);
        this.currentForm.setVisible(false);
    }

    /**
     *   Form generator
     */
    private void initComponents() {
        JLabel label1 = new JLabel();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Search reservations");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBackground(Color.white);
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(40, 30, 240, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search by customer");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> searchByCustomerUsernameButtonClick());
        add(button1);
        button1.setBounds(55, 80, 210, 40);

        //---- button2 ----
        button2.setText("Search by room");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));

        button2.addActionListener(e -> searchByRoomButtonClick());
        add(button2);
        button2.setBounds(55, 125, 210, 40);

        //---- button3 ----
        button3.setText("All reservations");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(51, 102, 255));

        button3.addActionListener(e -> showAllReservationsButtonClick());
        add(button3);
        button3.setBounds(55, 170, 210, 40);

        //---- button4 ----
        button4.setText("Cancel");
        button4.setFont(new Font("Tahoma", Font.BOLD, 14));
        button4.setForeground(new Color(51, 102, 255));

        button4.addActionListener(e -> cancelButtonClick());
        add(button4);
        button4.setBounds(100, 235, 125, 40);

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
