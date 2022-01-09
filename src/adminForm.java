import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.util.Map;
/*
 * Created by JFormDesigner on Fri Jan 07 13:21:13 EET 2022
 */

/**
 * @author asdfasdfa
 */
public class adminForm extends JPanel {
    JFrame jframe;
    adminForm currentForm;
    private final Admin admin;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(adminForm currentForm) {
        this.currentForm = currentForm;
    }

    public adminForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        this.mainUI = mainUI;
        this.admin = admin;
        initComponents();
    }

    private void messagesButtonClick() {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin.getUsername());
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    private void logoutButtonClick() {
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }

    private void exitButtonClick() {this.mainUI.saveAndExit();}

    private void searchReservationsButtonClick() {
        searchReservationsForm searchReservationsForm = new searchReservationsForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        searchReservationsForm.setCurrentForm(searchReservationsForm);
        jframe.add(searchReservationsForm);
        this.currentForm.setVisible(false);
    }

    private void searchUserButtonClick() {
        searchUsersForm searchUsersForm = new searchUsersForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        searchUsersForm.setCurrentForm(searchUsersForm);
        jframe.add(searchUsersForm);
        this.currentForm.setVisible(false);
    }

    private void activateDeactivateAccountsButtonClick() {
        changeAccountStateForm changeAccountStateForm = new changeAccountStateForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        changeAccountStateForm.setCurrentForm(changeAccountStateForm);
        jframe.add(changeAccountStateForm);
        this.currentForm.setVisible(false);
    }

    private void searchReservationsButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void searchUserButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void activateDeactivateAccountsButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void messagesButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void logoutButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void exitButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        label2 = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(null);

        //---- label1 ----
        label1.setText("Admin panel");
        label1.setFont(new Font("Century Gothic", Font.BOLD, 18));
        add(label1);
        label1.setBounds(165, 10, 121, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search reservations");
        button1.setFont(new Font("Century Gothic", Font.BOLD, 14));
        button1.addActionListener(e -> searchReservationsButtonClick(e));
        add(button1);
        button1.setBounds(85, 130, 245, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Search users");
        button2.setFont(new Font("Century Gothic", Font.BOLD, 14));
        button2.addActionListener(e -> searchUserButtonClick(e));
        add(button2);
        button2.setBounds(85, 160, 245, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("Change user state");
        button3.setFont(new Font("Century Gothic", Font.BOLD, 14));
        button3.addActionListener(e -> activateDeactivateAccountsButtonClick(e));
        add(button3);
        button3.setBounds(85, 190, 245, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("Messages");
        button4.setFont(new Font("Century Gothic", Font.BOLD, 14));
        button4.addActionListener(e -> messagesButtonClick(e));
        add(button4);
        button4.setBounds(85, 220, 245, button4.getPreferredSize().height);

        //---- button5 ----
        button5.setText("Log out");
        button5.setFont(new Font("Century Gothic", Font.BOLD, 14));
        button5.addActionListener(e -> logoutButtonClick(e));
        add(button5);
        button5.setBounds(85, 250, 245, button5.getPreferredSize().height);

        //---- button6 ----
        button6.setText("Exit");
        button6.setFont(new Font("Century Gothic", Font.BOLD, 14));
        button6.addActionListener(e -> exitButtonClick(e));
        add(button6);
        button6.setBounds(85, 280, 245, button6.getPreferredSize().height);

        //---- label2 ----
        label2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        add(label2);
        label2.setBounds(20, 80, 215, 15);

        setPreferredSize(new Dimension(415, 335));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
