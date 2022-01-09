import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;

/*
 * Created by JFormDesigner on Fri Jan 07 16:58:50 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class changeAccountStateForm extends JPanel {
    JFrame jframe;
    changeAccountStateForm currentForm;
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

    public void setCurrentForm(changeAccountStateForm currentForm) {
        this.currentForm = currentForm;
    }

    public changeAccountStateForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        jframe.setPreferredSize(new Dimension(611 , 282));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
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

    private void returnButtonClick(ActionEvent e) {
        adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admin);
        adminForm.setCurrentForm(adminForm);
        this.jframe.add(adminForm);
        this.currentForm.setVisible(false);
    }

    private void searchButtonClick(ActionEvent e) {
        label1.setVisible(false);
        updateList();
    }

    private void changeStateButtonClick(ActionEvent e) {
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



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label2 = new JLabel();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        label4 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        button2 = new JButton();
        button1 = new JButton();
        button3 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label2 ----
        label2.setText("Change account state");
        label2.setFont(new Font("Tahoma", Font.BOLD, 22));
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(210, 7, 259, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("User type:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(label3);
        label3.setBounds(70, 40, 94, label3.getPreferredSize().height);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Customer",
            "Provider",
            "Admin"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(comboBox1);
        comboBox1.setBounds(150, 40, comboBox1.getPreferredSize().width, 15);

        //---- label4 ----
        label4.setText("Name filter:");
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(label4);
        label4.setBounds(330, 40, 85, label4.getPreferredSize().height);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField1);
        textField1.setBounds(420, 40, 110, textField1.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(75, 115, 457, 121);

        //---- label1 ----
        label1.setText("\"user\" Account ...");
        label1.setVisible(false);
        add(label1);
        label1.setBounds(0, 0, 0, 0);

        //---- button2 ----
        button2.setText("Return");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));
        button2.addActionListener(e -> returnButtonClick(e));
        add(button2);
        button2.setBounds(75, 240, 120, button2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));
        button1.addActionListener(e -> searchButtonClick(e));
        add(button1);
        button1.setBounds(240, 240, 130, button1.getPreferredSize().height);

        //---- button3 ----
        button3.setText("Change state");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(51, 102, 255));
        button3.addActionListener(e -> changeStateButtonClick(e));
        add(button3);
        button3.setBounds(410, 240, 125, button3.getPreferredSize().height);

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
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label2;
    private JLabel label3;
    private JComboBox<String> comboBox1;
    private JLabel label4;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label1;
    private JButton button2;
    private JButton button1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
