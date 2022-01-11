import java.awt.*;
import javax.swing.*;
import java.util.Map;

public class messageForm extends JPanel {
    JFrame jframe;
    messageForm currentForm;
    String currentUsername;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(messageForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Constructor of messageForm
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
     * @param currentUsername
     */
    public messageForm(JFrame jframe, Map<Integer,Reservation> reservations,
                       Map<Integer,Room> rooms, Map<String,Authentication> users, Map<String,Customer> customers,
                       Map<String,Provider> providers, Map<String,Admin> admins, Map<Integer,Message> messages,
                       MainUI mainUI, String currentUsername) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI=mainUI;
        this.currentUsername = currentUsername;
        initComponents();
        jframe.setPreferredSize(new Dimension(270 , 250));
        jframe.pack();
    }

    /**
     *  Returns to the appropriate panel based on authenticated user role
     */
    private void returnButtonClicked() {
        if (this.users.get(currentUsername).getRole()==1) {
            customerForm customerForm = new customerForm(this.jframe, this.reservations, this.rooms, this.users,
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.customers.get(currentUsername));
            customerForm.setCurrentForm(customerForm);
            this.jframe.add(customerForm);
            this.currentForm.setVisible(false);
        } else if (this.users.get(currentUsername).getRole()==2) {
            providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, 
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.providers.get(currentUsername));
            providerForm.setCurrentForm(providerForm);
            this.jframe.add(providerForm);
            this.currentForm.setVisible(false);
        } else if (this.users.get(currentUsername).getRole()==3) {
            adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admins.get(currentUsername));
            adminForm.setCurrentForm(adminForm);
            this.jframe.add(adminForm);
            this.currentForm.setVisible(false);
        }
    }

    /**
     * Displays new message form
     */
    private void newMessageButtonClick() {
        messageNewMessageForm messageNewMessageForm = new messageNewMessageForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, currentUsername);
        messageNewMessageForm.setCurrentForm(messageNewMessageForm);
        this.jframe.add(messageNewMessageForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Displays inbox form
     */
    private void inboxButtonClick() {
        messageInboxForm messageInboxForm = new messageInboxForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, currentUsername);
        messageInboxForm.setCurrentForm(messageInboxForm);
        this.jframe.add(messageInboxForm);
        this.currentForm.setVisible(false);
    }

    /**
     *   Form generator
     */
    private void initComponents() {
        JLabel label1 = new JLabel();
        JButton button3 = new JButton();
        JButton button1 = new JButton();
        JButton button2 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Messages");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(80, 15, 110, label1.getPreferredSize().height);

        //---- button3 ----
        button3.setText("New message");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(51, 102, 255));

        button3.addActionListener(e -> newMessageButtonClick());
        add(button3);
        button3.setBounds(50, 60, 170, 40);

        //---- button1 ----
        button1.setText("Inbox");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> inboxButtonClick());
        add(button1);
        button1.setBounds(50, 105, 170, 40);

        //---- button2 ----
        button2.setText("Return");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));

        button2.addActionListener(e -> returnButtonClicked());
        add(button2);
        button2.setBounds(75, 165, 125, 40);

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
