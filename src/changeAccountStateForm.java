import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 07 16:58:50 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class changeAccountStateForm extends JPanel {
    JFrame jframe;
    changeAccountStateForm currentForm;
    private Admin admin;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
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
        model = new DefaultListModel<String>();
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
        // Generated using JFormDesigner Evaluation license - asdfasdfa
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label2 ----
        label2.setText("Change account state");
        add(label2, "cell 6 0");

        //---- label3 ----
        label3.setText("User type:");
        add(label3, "cell 4 3");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Customer",
            "Provider",
            "Admin"
        }));
        add(comboBox1, "cell 5 3");

        //---- label4 ----
        label4.setText("Name filter:");
        add(label4, "cell 8 3");
        add(textField1, "cell 9 3 3 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 4 8 8 1");

        //---- label1 ----
        label1.setText("\"user\" Account ...");
        label1.setVisible(false);
        add(label1, "cell 6 10");

        //---- button2 ----
        button2.setText("Return");
        button2.addActionListener(e -> returnButtonClick(e));
        add(button2, "cell 4 15");

        //---- button1 ----
        button1.setText("Search");
        button1.addActionListener(e -> searchButtonClick(e));
        add(button1, "cell 6 15");

        //---- button3 ----
        button3.setText("Change state");
        button3.addActionListener(e -> changeStateButtonClick(e));
        add(button3, "cell 9 15");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
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
