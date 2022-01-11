import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.*;

public class registerAsCustomerForm extends JPanel {
    JFrame jframe;
    registerAsCustomerForm currentForm;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(registerAsCustomerForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Constructor of registerAsCustomerForm
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
     */
    public registerAsCustomerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        jframe.setPreferredSize(new Dimension(400 , 475));
        jframe.pack();
        initComponents();
    }

    /**
     *  If the form input is valid, it registers new customer to the appropriate HashMaps
     */
    private void register() {
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

        String gender = "";
        if (comboBox1.getSelectedItem() == "-") {
            comboBox1.setForeground(Color.red);
            validInput = false;
        } else {
            if (comboBox1.getSelectedItem() == "Male") {
                gender = "male";
            } else {
                gender = "female";
            }
            comboBox1.setForeground(null);
        }

        String country = textField7.getText();
        if (!country.matches("^[a-zA-Z]*$")) {
            textField7.setForeground(Color.red);
            validInput = false;
        } else {
            textField7.setForeground(null);
        }

        String phone = textField11.getText();
        if (!phone.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
            textField11.setForeground(Color.red);
            validInput = false;
        } else {
            textField11.setForeground(null);
        }

        String date = textField12.getText();
        LocalDate birthdate = LocalDate.of(1, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            birthdate = LocalDate.parse(date, dtf);
            textField12.setForeground(null);
        } catch (java.time.format.DateTimeParseException ignored) {
            textField12.setForeground(Color.red);
            validInput = false;
        }
        System.out.println(validInput);
        if (validInput){
            this.users.put(username, new Authentication(username, password, 1));
            this.customers.put(username, new Customer(username, email, password, firstName, lastName,
                    gender, country, phone, birthdate, false));
            loginForm loginForm = new loginForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                    this.providers, this.admins, this.messages, this.mainUI);
            loginForm.setCurrentForm(loginForm);
            this.jframe.add(loginForm);
            this.currentForm.setVisible(false);
        }

    }

    /**
     * Returns to log in form
     */
    private void CancelButtonClick() {
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.add(loginForm);
        this.currentForm.setVisible(false);
        jframe.setVisible(true);
    }

    private void birthdayMouseClicked() {
        textField12.setText("");
        textField12.setForeground(Color.black);
    }

    private void textField10MouseClicked() {
        textField10.setText("");
        textField10.setForeground(Color.black);
    }

    private void textField11MouseClicked() {
        textField11.setText("");
        textField11.setForeground(Color.black);
    }


    /**
     *   Form generator
     */
    private void initComponents() {
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        textField5 = new JTextField();
        JLabel label3 = new JLabel();
        passwordField1 = new JPasswordField();
        JLabel label11 = new JLabel();
        passwordField2 = new JPasswordField();
        JLabel label5 = new JLabel();
        textField8 = new JTextField();
        JLabel label6 = new JLabel();
        textField9 = new JTextField();
        JLabel label4 = new JLabel();
        textField10 = new JTextField();
        JLabel label9 = new JLabel();
        comboBox1 = new JComboBox<>();
        JLabel label8 = new JLabel();
        textField7 = new JTextField();
        JLabel label7 = new JLabel();
        JLabel label10 = new JLabel();
        textField12 = new JTextField();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        textField11 = new JTextField();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Customer registration");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(40, 20, 315, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Username:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label2);
        label2.setBounds(30, 65, 140, 25);

        //---- textField5 ----
        textField5.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField5.setForeground(Color.black);
        add(textField5);
        textField5.setBounds(195, 65, 160, 25);

        //---- label3 ----
        label3.setText("Password:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label3);
        label3.setBounds(30, 95, 140, 25);

        //---- passwordField1 ----
        passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 14));

        passwordField1.setForeground(Color.black);
        add(passwordField1);
        passwordField1.setBounds(195, 95, 160, 25);

        //---- label11 ----
        label11.setText("Confirm Password:");
        label11.setForeground(Color.white);
        label11.setFont(new Font("Tahoma", Font.BOLD, 14));
        label11.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label11);
        label11.setBounds(30, 125, 140, 25);

        //---- passwordField2 ----
        passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 14));

        passwordField2.setForeground(Color.black);
        add(passwordField2);
        passwordField2.setBounds(195, 125, 160, 25);

        //---- label5 ----
        label5.setText("First name:");
        label5.setForeground(Color.white);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label5);
        label5.setBounds(30, 155, 140, 25);

        //---- textField8 ----
        textField8.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField8.setForeground(Color.black);
        add(textField8);
        textField8.setBounds(195, 155, 160, 25);

        //---- label6 ----
        label6.setText("Last name:");
        label6.setForeground(Color.white);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label6);
        label6.setBounds(30, 185, 140, 25);

        //---- textField9 ----
        textField9.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField9.setForeground(Color.black);
        add(textField9);
        textField9.setBounds(195, 185, 160, 25);

        //---- label4 ----
        label4.setText("Email:");
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label4);
        label4.setBounds(30, 215, 140, 25);

        //---- textField10 ----
        textField10.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField10.setForeground(Color.gray);
        textField10.setText("mail@example.com");
        textField10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField10MouseClicked();
            }
        });
        add(textField10);
        textField10.setBounds(195, 215, 160, 25);

        //---- label9 ----
        label9.setText("Gender:");
        label9.setForeground(Color.white);
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label9);
        label9.setBounds(30, 245, 140, 25);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "-",
            "Male",
            "Female"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));

        comboBox1.setForeground(Color.black);
        add(comboBox1);
        comboBox1.setBounds(195, 245, 160, 25);

        //---- label8 ----
        label8.setText("Country:");
        label8.setForeground(Color.white);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label8);
        label8.setBounds(30, 275, 140, 25);

        //---- textField7 ----
        textField7.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField7.setForeground(Color.black);
        add(textField7);
        textField7.setBounds(195, 275, 160, 25);

        //---- label7 ----
        label7.setText("Phone number:");
        label7.setForeground(Color.white);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label7);
        label7.setBounds(30, 305, 140, 25);

        //---- label10 ----
        label10.setText("Birthdate:");
        label10.setForeground(Color.white);
        label10.setFont(new Font("Tahoma", Font.BOLD, 14));
        label10.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label10);
        label10.setBounds(30, 335, 140, 25);

        //---- textField12 ----
        textField12.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField12.setForeground(Color.gray);
        textField12.setText("dd-MM-yyyy");
        textField12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                birthdayMouseClicked();
            }
        });
        add(textField12);
        textField12.setBounds(195, 335, 160, 25);

        //---- button1 ----
        button1.setText("Register");
        button1.setForeground(new Color(51, 102, 255));
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));

        button1.addActionListener(e -> register());
        add(button1);
        button1.setBounds(230, 385, 125, 40);

        //---- button2 ----
        button2.setText("Cancel");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));

        button2.setForeground(new Color(51, 102, 255));
        button2.addActionListener(e -> CancelButtonClick());
        add(button2);
        button2.setBounds(40, 385, 125, 40);

        //---- textField11 ----
        textField11.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textField11.setForeground(Color.gray);
        textField11.setText("+xx xxxxxxxxxx");
        textField11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField11MouseClicked();
            }
        });
        add(textField11);
        textField11.setBounds(195, 305, 160, 25);

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

    private JTextField textField5;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JComboBox<String> comboBox1;
    private JTextField textField7;
    private JTextField textField12;
    private JTextField textField11;
}
