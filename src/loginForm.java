import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Jan 05 22:50:03 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class loginForm extends JPanel {
    JFrame jframe;
    loginForm currentForm;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(loginForm currentForm) {
        this.currentForm = currentForm;
    }

    public loginForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        jframe.setPreferredSize(new Dimension(423 , 300));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
    }

    private void loginButtonClick(ActionEvent e) {
        int role = 0;
        String username = textField1.getText();
        String password = String.valueOf(passwordField1.getPassword());
        if (this.users.containsKey(username)) {
            Authentication temp = this.users.get(username);
            if (password.equals(temp.getPassword())){
                role = temp.getRole();
            }
            else {
                label4.setText("Wrong password");
                label4.setVisible(true);

            }
        }
        else {
            label4.setText("Login failed");
            label4.setVisible(true);
        }
        switch (role) {
            case 1 -> {
                customerForm customerForm = new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.customers.get(username));
                customerForm.setCurrentForm(customerForm);
                this.jframe.add(customerForm);
                this.currentForm.setVisible(false);
            }
            case 2 -> {
                providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.providers.get(username));
                providerForm.setCurrentForm(providerForm);
                this.jframe.add(providerForm);
                this.currentForm.setVisible(false);
            }
            case 3 -> {
                adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.admins.get(username));
                adminForm.setCurrentForm(adminForm);
                this.jframe.add(adminForm);
                this.currentForm.setVisible(false);
            }
        }
    }

    private void registerButtonClick(ActionEvent e) {
        registerForm registerForm = new registerForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI);
        registerForm.setCurrentForm(registerForm);
        this.jframe.add(registerForm);
        this.currentForm.setVisible(false);
    }

    private void exitButtonClick(ActionEvent e) {
        this.mainUI.saveAndExit();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label4 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(423, 278));
        setMaximumSize(new Dimension(423, 278));
        setFont(new Font("Droid Sans", Font.PLAIN, 12));
        setAlignmentY(2.5F);
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(null);

        //---- label4 ----
        label4.setText("Wrong password, please try again");
        label4.setVisible(false);
        add(label4);
        label4.setBounds(0, 0, 0, 0);

        //---- label1 ----
        label1.setText("Login");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(175, 30, 70, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Username:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(55, 100, 87, 20);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField1);
        textField1.setBounds(190, 100, 160, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(55, 135, 87, label3.getPreferredSize().height);

        //---- passwordField1 ----
        passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(passwordField1);
        passwordField1.setBounds(190, 130, 160, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Login");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(0, 51, 255));
        button1.addActionListener(e -> loginButtonClick(e));
        add(button1);
        button1.setBounds(70, 170, 100, 30);

        //---- button2 ----
        button2.setText("Register");
        button2.setActionCommand("Register");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(0, 51, 255));
        button2.addActionListener(e -> registerButtonClick(e));
        add(button2);
        button2.setBounds(210, 170, 100, 30);

        //---- button3 ----
        button3.setText("Exit");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(0, 51, 255));
        button3.addActionListener(e -> exitButtonClick(e));
        add(button3);
        button3.setBounds(140, 215, 110, 20);

        setPreferredSize(new Dimension(395, 290));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label4;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
