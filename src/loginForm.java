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
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;

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
    }

    private void loginButtonClick(ActionEvent e) {
        int role = 0;
        String username = textField1.getText();
        String password = String.valueOf(passwordField1.getPassword());
        System.out.println(password);
        if (this.users.containsKey(username)) {
            Authentication temp = this.users.get(username);
            if (password.equals(temp.getPassword())){
                System.out.println("\nLogin successful, welcome " + temp.getUsername() + "!");
                role = temp.getRole();
            }
            else {
                System.out.println("\nLogin failed, please try again");
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
                //label4.setText("success as customer");
                //label4.setVisible(true);
                customerForm customerForm = new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.customers.get(username));
                customerForm.setCurrentForm(customerForm);
                this.jframe.add(customerForm);
                this.currentForm.setVisible(false);
            }
            case 2 -> {
                //label4.setText("success as provider");
                //label4.setVisible(true);
                providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.providers.get(username));
                providerForm.setCurrentForm(providerForm);
                this.jframe.add(providerForm);
                this.currentForm.setVisible(false);
            }
            case 3 -> {
                //label4.setText("success as admin");
                //label4.setVisible(true);
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

    private void register(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        button3 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
        .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax
        . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,
        12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans
        .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e.
        getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 5 5",
            // columns
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
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Login");
        add(label1, "cell 3 0");

        //---- label2 ----
        label2.setText("Username:");
        add(label2, "cell 2 2 2 1");
        add(textField1, "cell 4 2");

        //---- label3 ----
        label3.setText("Password:");
        add(label3, "cell 2 3 2 1");
        add(passwordField1, "cell 4 3");

        //---- button1 ----
        button1.setText("Login");
        button1.addActionListener(e -> loginButtonClick(e));
        add(button1, "cell 2 4");

        //---- button2 ----
        button2.setText("Register");
        button2.setActionCommand("Register");
        button2.addActionListener(e -> registerButtonClick(e));
        add(button2, "cell 4 4");

        //---- label4 ----
        label4.setText("Wrong password, please try again");
        label4.setVisible(false);
        add(label4, "cell 3 6");

        //---- button3 ----
        button3.setText("Exit");
        button3.addActionListener(e -> exitButtonClick(e));
        add(button3, "cell 3 8 3 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
