import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Created by JFormDesigner on Fri Jan 07 16:29:55 EET 2022
 */



/**
 * @author asdfasdfa
 */
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
        jframe.setPreferredSize(new Dimension(490, 520));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        
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

    private void returnButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void searchButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox<>();
        label3 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("User search");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label1);
        label1.setBounds(new Rectangle(new Point(180, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("User type:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(label2);
        label2.setBounds(30, 95, 87, label2.getPreferredSize().height);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Customer",
            "Provider",
            "Admin"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(comboBox1);
        comboBox1.setBounds(120, 80, 89, comboBox1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Name filter:");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(label3);
        label3.setBounds(new Rectangle(new Point(245, 95), label3.getPreferredSize()));

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField1);
        textField1.setBounds(335, 90, 115, textField1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

            //---- list1 ----
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(60, 160, 365, 245);

        //---- button2 ----
        button2.setText("Return");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.addActionListener(e -> returnButtonClick(e));
        add(button2);
        button2.setBounds(75, 450, 116, button2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.addActionListener(e -> searchButtonClick(e));
        add(button1);
        button1.setBounds(290, 450, 115, button1.getPreferredSize().height);

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
    private JLabel label2;
    private JComboBox<String> comboBox1;
    private JLabel label3;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
