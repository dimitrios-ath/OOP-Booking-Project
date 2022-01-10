import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

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
        jframe.setPreferredSize(new Dimension(380 , 480));
        jframe.pack();
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

    private void cancelButtonClick(ActionEvent e) {
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.add(loginForm);
        this.currentForm.setVisible(false);
        jframe.setVisible(true);
    }

    private void textField10MouseClicked(MouseEvent e) {
        textField10.setText("");
        textField10.setForeground(Color.black);
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
        button2 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("Provider registration");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(40, 20, 305, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Username:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label2);
        label2.setBounds(30, 75, 140, 25);

        //---- textField5 ----
        textField5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField5.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField5.setForeground(Color.black);
        add(textField5);
        textField5.setBounds(185, 75, 150, 25);

        //---- label3 ----
        label3.setText("Password:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label3);
        label3.setBounds(30, 105, 140, 25);

        //---- passwordField1 ----
        passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        passwordField1.setForeground(Color.black);
        add(passwordField1);
        passwordField1.setBounds(185, 105, 150, 25);

        //---- label11 ----
        label11.setText("Confirm Password:");
        label11.setForeground(Color.white);
        label11.setFont(new Font("Tahoma", Font.BOLD, 14));
        label11.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label11);
        label11.setBounds(30, 135, 140, 25);

        //---- passwordField2 ----
        passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        passwordField2.setForeground(Color.black);
        add(passwordField2);
        passwordField2.setBounds(185, 135, 150, 25);

        //---- label5 ----
        label5.setText("First name:");
        label5.setForeground(Color.white);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label5);
        label5.setBounds(30, 165, 140, 25);

        //---- textField8 ----
        textField8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField8.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField8.setForeground(Color.black);
        add(textField8);
        textField8.setBounds(185, 165, 150, 25);

        //---- label6 ----
        label6.setText("Last name:");
        label6.setForeground(Color.white);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label6);
        label6.setBounds(30, 195, 140, 25);

        //---- textField9 ----
        textField9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField9.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField9.setForeground(Color.black);
        add(textField9);
        textField9.setBounds(185, 195, 150, 25);

        //---- label4 ----
        label4.setText("Email:");
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label4);
        label4.setBounds(30, 225, 140, 25);

        //---- textField10 ----
        textField10.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField10.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField10.setText("mail@example.com");
        textField10.setForeground(Color.gray);
        textField10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField10MouseClicked(e);
            }
        });
        add(textField10);
        textField10.setBounds(185, 225, 150, 25);

        //---- label9 ----
        label9.setText("Type");
        label9.setForeground(Color.white);
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label9);
        label9.setBounds(30, 255, 140, 25);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "-",
            "Hotelier",
            "Private"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        comboBox1.setForeground(Color.black);
        add(comboBox1);
        comboBox1.setBounds(185, 255, 150, 25);

        //---- label8 ----
        label8.setText("Country:");
        label8.setForeground(Color.white);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label8);
        label8.setBounds(30, 285, 140, 25);

        //---- textField7 ----
        textField7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField7.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField7.setForeground(Color.black);
        add(textField7);
        textField7.setBounds(185, 285, 150, 25);

        //---- label7 ----
        label7.setText("Region:");
        label7.setForeground(Color.white);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label7);
        label7.setBounds(30, 315, 140, 25);

        //---- textField11 ----
        textField11.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField11.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField11.setForeground(Color.black);
        add(textField11);
        textField11.setBounds(185, 315, 150, 25);

        //---- label10 ----
        label10.setText("Office address:");
        label10.setForeground(Color.white);
        label10.setFont(new Font("Tahoma", Font.BOLD, 14));
        label10.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label10);
        label10.setBounds(30, 345, 140, 25);

        //---- textField12 ----
        textField12.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField12.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField12.setForeground(Color.black);
        add(textField12);
        textField12.setBounds(185, 345, 150, 25);

        //---- button1 ----
        button1.setText("Register");
        button1.setForeground(Color.white);
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> register(e));
        add(button1);
        button1.setBounds(210, 395, 125, 40);

        //---- button2 ----
        button2.setText("Cancel");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.setForeground(Color.white);
        button2.addActionListener(e -> cancelButtonClick(e));
        add(button2);
        button2.setBounds(45, 395, 125, 40);

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
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
