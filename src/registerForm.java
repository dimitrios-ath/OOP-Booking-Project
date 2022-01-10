import java.awt.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

public class registerForm extends JPanel {
    JFrame jframe;
    registerForm currentForm;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(registerForm currentForm) {
        this.currentForm = currentForm;
    }

    public registerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                        Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                        Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI=mainUI;
        jframe.setPreferredSize(new Dimension(345 , 255));
        jframe.pack();
        initComponents();
    }

    private void backToLogin() {
        loginForm loginForm = new loginForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        this.jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }

    private void registerWithRole() {
        if (comboBox1.getSelectedItem()=="Customer") {
            registerAsCustomer registerAsCustomer = new registerAsCustomer(this.jframe, this.reservations,
                    this.rooms, this.users, this.customers, this.providers, this.admins, this.messages, this.mainUI);
            registerAsCustomer.setCurrentForm(registerAsCustomer);
            this.jframe.add(registerAsCustomer);
        }
        else {
            registerAsProvider registerAsProvider = new registerAsProvider(this.jframe, this.reservations,
                    this.rooms, this.users, this.customers, this.providers, this.admins, this.messages, this.mainUI);
            registerAsProvider.setCurrentForm(registerAsProvider);
            this.jframe.add(registerAsProvider);
        }
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        JLabel label1 = new JLabel();
        JButton button1 = new JButton();
        comboBox1 = new JComboBox<>();
        JButton button2 = new JButton();
        JLabel label2 = new JLabel();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Registration");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(100, 10, 145, 50);

        //---- button1 ----
        button1.setText("Back");
        button1.setForeground(Color.white);
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> backToLogin());
        add(button1);
        button1.setBounds(45, 170, 110, 35);

        //---- comboBox1 ----
        comboBox1.setDoubleBuffered(true);
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Customer",
            "Provider"
        }));
        comboBox1.setForeground(Color.black);
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        add(comboBox1);
        comboBox1.setBounds(110, 105, 125, 40);

        //---- button2 ----
        button2.setText("Next");
        button2.setForeground(Color.white);
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.addActionListener(e -> registerWithRole());
        add(button2);
        button2.setBounds(185, 170, 110, 35);

        //---- label2 ----
        label2.setText("Select account type:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2);
        label2.setBounds(85, 70, 175, 25);

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
}
