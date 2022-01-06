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
                     Map<String,Admin> admins, Map<Integer,Message> messages) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
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
                label4.setText("success as customer");
                label4.setVisible(true);
                //CustomerUI customerUI = new CustomerUI(this.mainUI, this.customers.get(username), this.rooms,
                //        this.reservations, this.messages, this.users);
            }
            case 2 -> {
                label4.setText("success as provider");
                label4.setVisible(true);
                //ProviderUI providerUI = new ProviderUI(this.mainUI, this.providers.get(username), this.rooms,
                //        this.reservations, this.messages, this.users);
            }
            case 3 -> {
                label4.setText("success as admin");
                label4.setVisible(true);
                //AdminUI adminUI = new AdminUI(this.mainUI, this.admins.get(username), this.reservations,
                //        this.customers, this.providers, this.admins, this.rooms, this.messages, this.users);
            }
        }
    }

    private void registerButtonClick(ActionEvent e) {
        registerForm registerForm = new registerForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages);
        registerForm.setCurrentForm(registerForm);
        this.jframe.add(registerForm);
        this.currentForm.setVisible(false);
    }

    private void loginButton(ActionEvent e) {
        // TODO add your code here
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
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        passwordField1 = new JPasswordField();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.red
        ), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName(
        )))throw new RuntimeException();}});

        //---- label1 ----
        label1.setText("Login");

        //---- label2 ----
        label2.setText("Username:");

        //---- label3 ----
        label3.setText("Password:");

        //---- button1 ----
        button1.setText("Login");
        button1.addActionListener(e -> {
			loginButton(e);
			loginButtonClick(e);
		});

        //---- button2 ----
        button2.setText("Register");
        button2.setActionCommand("Register");
        button2.addActionListener(e -> {
			register(e);
			registerButtonClick(e);
		});

        //---- label4 ----
        label4.setText("Wrong password, please try again");
        label4.setVisible(false);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(label1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                    .addGap(41, 41, 41))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                    .addGap(68, 68, 68)))
                            .addGroup(layout.createParallelGroup()
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(label4)))
                    .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addComponent(label4)
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addContainerGap(95, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
