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
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox<>();
        label3 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (e -> {if ("bord\u0065r" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); });
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

        //---- label1 ----
        label1.setText("User search");
        add(label1, "cell 6 0");

        //---- label2 ----
        label2.setText("User type:");
        add(label2, "cell 4 3");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Customer",
            "Provider",
            "Admin"
        }));
        add(comboBox1, "cell 5 3");

        //---- label3 ----
        label3.setText("Name filter:");
        add(label3, "cell 8 3");
        add(textField1, "cell 9 3 3 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 4 8 8 1");

        //---- button2 ----
        button2.setText("Return");
        button2.addActionListener(e -> returnButtonClick());
        add(button2, "cell 4 15");

        //---- button1 ----
        button1.setText("Search");
        button1.addActionListener(e -> searchButtonClick());
        add(button1, "cell 11 15");
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
    private JList<String> list1;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
