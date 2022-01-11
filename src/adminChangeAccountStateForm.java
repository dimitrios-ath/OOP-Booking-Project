import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;

public class adminChangeAccountStateForm extends JPanel {
    JFrame jframe;
    adminChangeAccountStateForm currentForm;
    private final Admin admin;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    DefaultListModel<String> model;
    private ArrayList<String> usernamesInList;

    public void setCurrentForm(adminChangeAccountStateForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Constructor of adminChangeAccountStateForm. Adds to displayed list all user's username, account
     * type and activation state
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
    public adminChangeAccountStateForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        this.mainUI=mainUI;
        this.admin = admin;
        jframe.setPreferredSize(new Dimension(505 , 415));
        jframe.pack();
        initComponents();

        model = new DefaultListModel<>();
        AtomicBoolean noUsersFound = new AtomicBoolean(true);
        usernamesInList = new ArrayList<>();
        this.users.forEach((username, auth) -> {
            String state = "Suspended";
            if (auth.getRole()==1){
                if (this.customers.get(username).getActiveAccount()) {state = "Active";}
                model.addElement("Name: \"" + username + "\", Type: Customer, Account: " + state);
                usernamesInList.add(username);
                noUsersFound.set(false);
            } else if (auth.getRole()==2){
                if (this.providers.get(username).getActiveAccount()) {state = "Active";}
                model.addElement("Name: \"" + auth.getUsername() + "\", Type: Provider, Account: " + state);
                usernamesInList.add(username);
                noUsersFound.set(false);
            } else if (auth.getRole()==3){
                if (this.admins.get(username).getActiveAccount()) {state = "Active";}
                model.addElement("Name: \"" + auth.getUsername() + "\", Type: Admin, Account: " + state);
                usernamesInList.add(username);
                noUsersFound.set(false);
            }
        });
        if (noUsersFound.get()) {
            model.addElement("No users found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    /**
     *  Updates the list items with the new account activation state
     */
    private void updateList() {
        model = new DefaultListModel<>();
        AtomicBoolean noUsersFound = new AtomicBoolean(true);
        usernamesInList = new ArrayList<>();
        this.users.forEach((username, auth) -> {
            String state = "Suspended";
            if (username.contains(textField1.getText())) {
                switch (comboBox1.getSelectedIndex()) {
                    case 0 -> {
                        if (auth.getRole() == 1) {
                            if (this.customers.get(username).getActiveAccount()) {state = "Active";}
                            model.addElement("Name: \"" + username + "\", Type: Customer, Account: " + state);
                            usernamesInList.add(username);
                            noUsersFound.set(false);
                        } else if (auth.getRole() == 2) {
                            if (this.providers.get(username).getActiveAccount()) {state = "Active";}
                            model.addElement("Name: \"" + auth.getUsername() + "\", Type: Provider, Account: " + state);
                            usernamesInList.add(username);
                            noUsersFound.set(false);
                        } else if (auth.getRole() == 3) {
                            if (this.admins.get(username).getActiveAccount()) {state = "Active";}
                            model.addElement("Name: \"" + auth.getUsername() + "\", Type: Admin, Account: " + state);
                            usernamesInList.add(username);
                            noUsersFound.set(false);
                        }
                    }
                    case 1 -> {
                        if (auth.getRole() == 1) {
                            if (this.customers.get(username).getActiveAccount()) {state = "Active";}
                            model.addElement("Name: \"" + username + "\", Type: Customer, Account: " + state);
                            usernamesInList.add(username);
                            noUsersFound.set(false);
                        }
                    }
                    case 2 -> {
                        if (auth.getRole() == 2) {
                            if (this.providers.get(username).getActiveAccount()) {state = "Active";}
                            model.addElement("Name: \"" + auth.getUsername() + "\", Type: Provider, Account: " + state);
                            usernamesInList.add(username);
                            noUsersFound.set(false);
                        }
                    }
                    case 3 -> {
                        if (auth.getRole() == 3) {
                            if (this.admins.get(username).getActiveAccount()) {state = "Active";}
                            model.addElement("Name: \"" + auth.getUsername() + "\", Type: Admin, Account: " + state);
                            usernamesInList.add(username);
                            noUsersFound.set(false);
                        }
                    }
                }
                list1.setEnabled(true);
            }
        });
        if (noUsersFound.get()) {
            model.addElement("No users found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    /**
     * Return to admin panel
     */
    private void returnButtonClick() {
        adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admin);
        adminForm.setCurrentForm(adminForm);
        this.jframe.add(adminForm);
        this.currentForm.setVisible(false);
    }

    private void searchButtonClick() {
        label1.setVisible(false);
        updateList();
    }

    /**
     *  Changes the selected account ActiveAccount boolean.
     */
    private void changeStateButtonClick() {
        String username = usernamesInList.get(list1.getSelectedIndex());
        int role = this.users.get(username).getRole();
        if (!Objects.equals(username, this.admin.getUsername())) {
            switch (role) {
                case 1 -> {
                    this.customers.get(username).setActiveAccount(!this.customers.get(username).getActiveAccount());
                    if (this.customers.get(username).getActiveAccount()) {
                        label1.setText("Activated user \"" + username + "\" account");
                    } else {
                        label1.setText("Suspended user \"" + username + "\" account");
                    }
                }
                case 2 -> {
                    this.providers.get(username).setActiveAccount(!this.providers.get(username).getActiveAccount());
                    if (this.providers.get(username).getActiveAccount()) {
                        label1.setText("Activated user \"" + username + "\" account");
                    } else {
                        label1.setText("Suspended user \"" + username + "\" account");
                    }
                }
                case 3 -> {
                    this.admins.get(username).setActiveAccount(!this.admins.get(username).getActiveAccount());
                    if (this.admins.get(username).getActiveAccount()) {
                        label1.setText("Activated user \"" + username + "\" account");
                    } else {
                        label1.setText("Suspended user \"" + username + "\" account");
                    }
                }
            }
            label1.setForeground(Color.BLACK);
        } else {
            label1.setText("Can't change current user state");
            label1.setForeground(Color.red);
        }
        label1.setVisible(true);
        updateList();
    }

    /**
     *   Form generator
     */
    private void initComponents() {
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        JLabel label4 = new JLabel();
        textField1 = new JTextField();
        JScrollPane scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        label1 = new JLabel();
        JButton button2 = new JButton();
        JButton button1 = new JButton();
        JButton button3 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label2 ----
        label2.setText("Change account state");
        label2.setFont(new Font("Tahoma", Font.BOLD, 22));
        label2.setForeground(Color.white);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2);
        label2.setBounds(120, 20, 259, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("User type:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label3);
        label3.setBounds(135, 65, 90, 25);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Customer",
            "Provider",
            "Admin"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.BOLD, 14));

        comboBox1.setForeground(Color.black);
        add(comboBox1);
        comboBox1.setBounds(235, 65, comboBox1.getPreferredSize().width, 25);

        //---- label4 ----
        label4.setText("Name filter:");
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label4);
        label4.setBounds(135, 100, 90, 25);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField1.setForeground(Color.black);
        add(textField1);
        textField1.setBounds(235, 100, 135, 25);

        //======== scrollPane1 ========
        {


            //---- list1 ----
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setModel(new AbstractListModel<>() {
                final String[] values = {
                        "Name: \"userExample\", Type: Customer, Account: Suspended"
                };

                @Override
                public int getSize() {
                    return values.length;
                }

                @Override
                public String getElementAt(int i) {
                    return values[i];
                }
            });

            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(45, 160, 415, 106);

        //---- label1 ----
        label1.setText("\"user\" Account ...");
        label1.setVisible(false);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(80, 130, 350, 25);

        //---- button2 ----
        button2.setText("Return");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));

        button2.addActionListener(e -> returnButtonClick());
        add(button2);
        button2.setBounds(200, 335, 105, 40);

        //---- button1 ----
        button1.setText("Search");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> searchButtonClick());
        add(button1);
        button1.setBounds(110, 280, 130, 40);

        //---- button3 ----
        button3.setText("Change state");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(51, 102, 255));

        button3.addActionListener(e -> changeStateButtonClick());
        add(button3);
        button3.setBounds(260, 280, 130, 40);

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
    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JList<String> list1;
    private JLabel label1;
}
