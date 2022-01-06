import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 03:28:51 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class registerAsProvider extends JPanel {
    JFrame jframe;
    registerAsProvider currentForm;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;

    public void setCurrentForm(registerAsProvider currentForm) {
        this.currentForm = currentForm;
    }

    public registerAsProvider(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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

    private void register(ActionEvent e) {
        String username = textField5.getText();
        boolean validInput = true;
        if (username.matches("^[a-zA-Z0-9_]*$")) {
            if (users.containsKey(username)) {
                textField5.setForeground(Color.red);
                validInput = false;
            } else {
                textField5.setForeground(null);
            }
        } else {textField5.setForeground(Color.red); validInput = false;}

        String password = String.valueOf(passwordField1.getPassword());
        String passwordConfirmation = String.valueOf(passwordField2.getPassword());
        if (!password.equals(passwordConfirmation) || password.equals("")){
            passwordField1.setForeground(Color.red);
            passwordField2.setForeground(Color.red);
            validInput = false;
        } else {passwordField1.setForeground(null); passwordField2.setForeground(null);}

        String firstName = textField8.getText();
        if (!firstName.matches("^[a-zA-Z]*$")) {
            textField8.setForeground(Color.red);
            validInput = false;
        } else {textField8.setForeground(null);}

        String lastName = textField9.getText();
        if (!lastName.matches("^[a-zA-Z]*$")) {
            textField9.setForeground(Color.red);
            validInput = false;
        } else {textField9.setForeground(null);}

        String email = textField10.getText();
        if (!email.matches("^(.+)@(.+)$")) {
            textField10.setForeground(Color.red);
            validInput = false;
        } else {textField10.setForeground(null);}

        String type = "";
        if (comboBox1.getSelectedItem() == "-") {
            comboBox1.setForeground(Color.red);
            validInput = false;
        } else {
            if (comboBox1.getSelectedItem() == "Hotelier") {
                type = "hotelier";
            } else {
                type = "private";
            }
            comboBox1.setForeground(null);
        }

        String country = textField7.getText();
        if (!country.matches("^[a-zA-Z]*$") || country.equals("")) {
            textField7.setForeground(Color.red);
            validInput = false;
        } else {
            textField7.setForeground(null);
        }

        String region = textField11.getText();
        if (!region.matches("^[a-zA-Z]*$") || region.equals("")) {
            textField11.setForeground(Color.red);
            validInput = false;
        } else {
            textField11.setForeground(null);
        }

        String office = textField11.getText();
        if (office.matches("")) {
            textField11.setForeground(Color.red);
            validInput = false;
        } else {
            textField11.setForeground(null);
        }

        if (validInput){
            users.put(username, new Authentication(username, password, 2));
            providers.put(username, new Provider(username, password, email, firstName, lastName,
                    office, country, region, type, false));
            loginForm loginForm = new loginForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                    this.providers, this.admins, this.messages, this.mainUI);
            loginForm.setCurrentForm(loginForm);
            this.jframe.add(loginForm);
            this.currentForm.setVisible(false);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        textField5 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        label11 = new JLabel();
        passwordField2 = new JPasswordField();
        label5 = new JLabel();
        textField8 = new JTextField();
        label6 = new JLabel();
        textField9 = new JTextField();
        label4 = new JLabel();
        textField10 = new JTextField();
        label9 = new JLabel();
        comboBox1 = new JComboBox<>();
        label8 = new JLabel();
        textField7 = new JTextField();
        label7 = new JLabel();
        textField11 = new JTextField();
        label10 = new JLabel();
        textField12 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;
        setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 5 5",
            // columns
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
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[]" +
            "[fill]" +
            "[fill]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Provider Registration Form");
        add(label1, "cell 2 0 2 1");

        //---- label2 ----
        label2.setText("Username:");
        add(label2, "cell 2 2");
        add(textField5, "cell 3 2");

        //---- label3 ----
        label3.setText("Password:");
        add(label3, "cell 2 3");
        add(passwordField1, "cell 3 3");

        //---- label11 ----
        label11.setText("Confirm Password:");
        add(label11, "cell 2 4");
        add(passwordField2, "cell 3 4");

        //---- label5 ----
        label5.setText("First name:");
        add(label5, "cell 2 5");
        add(textField8, "cell 3 5");

        //---- label6 ----
        label6.setText("Last name:");
        add(label6, "cell 2 6");
        add(textField9, "cell 3 6");

        //---- label4 ----
        label4.setText("Email:");
        add(label4, "cell 2 7");
        add(textField10, "cell 3 7");

        //---- label9 ----
        label9.setText("Type");
        add(label9, "cell 2 8");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "-",
            "Hotelier",
            "Private"
        }));
        add(comboBox1, "cell 3 8");

        //---- label8 ----
        label8.setText("Country:");
        add(label8, "cell 2 9");
        add(textField7, "cell 3 9");

        //---- label7 ----
        label7.setText("Region:");
        add(label7, "cell 2 10");
        add(textField11, "cell 3 10");

        //---- label10 ----
        label10.setText("Office address:");
        add(label10, "cell 2 11");
        add(textField12, "cell 3 11");

        //---- button1 ----
        button1.setText("Register");
        button1.addActionListener(e -> register(e));
        add(button1, "cell 3 12");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JLabel label2;
    private JTextField textField5;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JLabel label11;
    private JPasswordField passwordField2;
    private JLabel label5;
    private JTextField textField8;
    private JLabel label6;
    private JTextField textField9;
    private JLabel label4;
    private JTextField textField10;
    private JLabel label9;
    private JComboBox<String> comboBox1;
    private JLabel label8;
    private JTextField textField7;
    private JLabel label7;
    private JTextField textField11;
    private JLabel label10;
    private JTextField textField12;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
