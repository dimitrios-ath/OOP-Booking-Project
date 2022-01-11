import java.awt.*;
import javax.swing.*;
import java.util.Map;

public class adminForm extends JPanel {
    JFrame jframe;
    adminForm currentForm;
    private final Admin admin;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(adminForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     *  Constructor of adminForm
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
    public adminForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        jframe.setPreferredSize(new Dimension(315 , 395));
        jframe.pack();
        initComponents();
    }

    /**
     *  Display message form
     */
    private void messagesButtonClick() {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin.getUsername());
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    /**
     *  Logout
     */
    private void logoutButtonClick() {
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Save everything changed and exit
     */
    private void exitButtonClick() {this.mainUI.saveAndExit();}

    /**
     * Display search reservations form
     */
    private void searchReservationsButtonClick() {
        adminSearchReservationsForm adminSearchReservationsForm = new adminSearchReservationsForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        adminSearchReservationsForm.setCurrentForm(adminSearchReservationsForm);
        jframe.add(adminSearchReservationsForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Display search users form
     */
    private void searchUserButtonClick() {
        adminSearchUsersForm adminSearchUsersForm = new adminSearchUsersForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        adminSearchUsersForm.setCurrentForm(adminSearchUsersForm);
        jframe.add(adminSearchUsersForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Display change user state form
     */
    private void activateDeactivateAccountsButtonClick() {
        adminChangeAccountStateForm adminChangeAccountStateForm = new adminChangeAccountStateForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        adminChangeAccountStateForm.setCurrentForm(adminChangeAccountStateForm);
        jframe.add(adminChangeAccountStateForm);
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
        JButton button5 = new JButton();
        JButton button6 = new JButton();

        //======== this ========
        setForeground(new Color(51, 102, 255));
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Admin panel");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(75, 15, 171, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search reservations");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> searchReservationsButtonClick());
        add(button1);
        button1.setBounds(55, 60, 205, 40);

        //---- button2 ----
        button2.setText("Search users");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));

        button2.addActionListener(e -> searchUserButtonClick());
        add(button2);
        button2.setBounds(55, 105, 205, 40);

        //---- button3 ----
        button3.setText("Change user state");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(51, 102, 255));

        button3.addActionListener(e -> activateDeactivateAccountsButtonClick());
        add(button3);
        button3.setBounds(55, 150, 205, 40);

        //---- button4 ----
        button4.setText("Messages");
        button4.setFont(new Font("Tahoma", Font.BOLD, 14));
        button4.setForeground(new Color(51, 102, 255));

        button4.addActionListener(e -> messagesButtonClick());
        add(button4);
        button4.setBounds(55, 195, 205, 40);

        //---- button5 ----
        button5.setText("Log out");
        button5.setFont(new Font("Tahoma", Font.BOLD, 14));
        button5.setForeground(new Color(51, 102, 255));

        button5.addActionListener(e -> logoutButtonClick());
        add(button5);
        button5.setBounds(95, 260, 125, 40);

        //---- button6 ----
        button6.setText("Exit");
        button6.setFont(new Font("Tahoma", Font.BOLD, 14));
        button6.setForeground(new Color(51, 102, 255));

        button6.addActionListener(e -> exitButtonClick());
        add(button6);
        button6.setBounds(95, 305, 125, 40);

        setPreferredSize(new Dimension(315, 370));
    }
}
