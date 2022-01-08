import java.awt.*;
import java.util.Map;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Jan 05 23:06:58 EET 2022
 */



/**
 * @author asdfasdfa
 */
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
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        button1 = new JButton();
        comboBox1 = new JComboBox<>();
        button2 = new JButton();
        label2 = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (e -> {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); });
        setLayout(null);

        //---- label1 ----
        label1.setText("Register");
        add(label1);
        label1.setBounds(205, 30, 97, 50);

        //---- button1 ----
        button1.setText("Back");
        button1.addActionListener(e -> backToLogin());
        add(button1);
        button1.setBounds(95, 240, 97, 42);

        //---- comboBox1 ----
        comboBox1.setDoubleBuffered(true);
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Customer",
            "Provider"
        }));
        add(comboBox1);
        comboBox1.setBounds(190, 140, 95, comboBox1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Next");
        button2.addActionListener(e -> registerWithRole());
        add(button2);
        button2.setBounds(255, 240, 100, 45);

        //---- label2 ----
        label2.setText("Select account type:");
        add(label2);
        label2.setBounds(new Rectangle(new Point(175, 105), label2.getPreferredSize()));

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
    private JButton button1;
    private JComboBox<String> comboBox1;
    private JButton button2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
