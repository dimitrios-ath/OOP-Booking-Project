import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class searchUsersForm extends JPanel {
    JFrame jframe;
    searchUsersForm currentForm;
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

    public void setCurrentForm(searchUsersForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public searchUsersForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        initComponents();
        jframe.setPreferredSize(new Dimension(365, 480));
        jframe.pack();

        model = new DefaultListModel<>();
        AtomicBoolean noUsersFound = new AtomicBoolean(true);
        this.users.forEach((username, auth) -> {
            if (auth.getRole()==1){
                model.addElement("Name: \"" + auth.getUsername() +
                        "\", Type: Customer");
                noUsersFound.set(false);
            } else if (auth.getRole()==2){
                model.addElement("Name: \"" + auth.getUsername() +
                        "\", Type: Provider");
                noUsersFound.set(false);
            } else if (auth.getRole()==3){
                model.addElement("Name: \"" + auth.getUsername() +
                        "\", Type: Admin");
                noUsersFound.set(false);
            }
        });
        if (noUsersFound.get()) {
            model.addElement("No users found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void searchButtonClick() {
        model = new DefaultListModel<>();
        AtomicBoolean noUsersFound = new AtomicBoolean(true);
        this.users.forEach((username, auth) -> {
            if (username.contains(textField1.getText())) {
                switch (comboBox1.getSelectedIndex()) {
                    case 0 -> {
                        if (auth.getRole() == 1) {
                            model.addElement("Name: \"" + auth.getUsername() +
                                    "\", Type: Customer");
                            noUsersFound.set(false);
                        } else if (auth.getRole() == 2) {
                            model.addElement("Name: \"" + auth.getUsername() +
                                    "\", Type: Provider");
                            noUsersFound.set(false);
                        } else if (auth.getRole() == 3) {
                            model.addElement("Name: \"" + auth.getUsername() +
                                    "\", Type: Admin");
                            noUsersFound.set(false);
                        }
                    }
                    case 1 -> {
                        if (auth.getRole() == 1) {
                            model.addElement("Name: \"" + auth.getUsername() +
                                    "\", Type: Customer");
                            noUsersFound.set(false);
                        }
                    }
                    case 2 -> {
                        if (auth.getRole() == 2) {
                            model.addElement("Name: \"" + auth.getUsername() + "\", Type: Provider");
                            noUsersFound.set(false);
                        }
                    }
                    case 3 -> {
                        if (auth.getRole() == 3) {
                            model.addElement("Name: \"" + auth.getUsername() + "\", Type: Admin");
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

    private void returnButtonClick() {
        adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admin);
        adminForm.setCurrentForm(adminForm);
        this.jframe.add(adminForm);
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        comboBox1 = new JComboBox<>();
        JLabel label3 = new JLabel();
        textField1 = new JTextField();
        JScrollPane scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        JButton button2 = new JButton();
        JButton button1 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("User search");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(new Rectangle(new Point(120, 20), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("User type:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(75, 80, 80, 20);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Customer",
            "Provider",
            "Admin"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        comboBox1.setForeground(Color.black);
        add(comboBox1);
        comboBox1.setBounds(160, 70, 145, comboBox1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Name filter:");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(new Rectangle(new Point(65, 125), label3.getPreferredSize()));

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField1.setForeground(Color.black);
        add(textField1);
        textField1.setBounds(160, 120, 145, textField1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

            //---- list1 ----
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(40, 170, 285, 205);

        //---- button2 ----
        button2.setText("Return");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(Color.white);
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.addActionListener(e -> returnButtonClick());
        add(button2);
        button2.setBounds(35, 400, 120, 40);

        //---- button1 ----
        button1.setText("Search");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> searchButtonClick());
        add(button1);
        button1.setBounds(210, 400, 120, 40);

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
}
