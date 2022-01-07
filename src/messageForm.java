import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.util.Map;
/*
 * Created by JFormDesigner on Thu Jan 06 22:15:53 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class messageForm extends JPanel {
    JFrame jframe;
    messageForm currentForm;
    String currentUsername;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;

    public void setCurrentForm(messageForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public messageForm(JFrame jframe, Map<Integer,Reservation> reservations,
                       Map<Integer,Room> rooms, Map<String,Authentication> users, Map<String,Customer> customers,
                       Map<String,Provider> providers, Map<String,Admin> admins, Map<Integer,Message> messages,
                       MainUI mainUI, String currentUsername) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI=mainUI;
        this.currentUsername = currentUsername;
        initComponents();
    }

    private void returnButtonClicked(ActionEvent e) {
        if (this.users.get(currentUsername).getRole()==2) {
            providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, 
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.providers.get(currentUsername));
            providerForm.setCurrentForm(providerForm);
            this.jframe.add(providerForm);
            this.currentForm.setVisible(false);
        }
    }

    private void newMessageButtonClick(ActionEvent e) {
        newMessageForm newMessageForm = new newMessageForm(this.jframe, this.reservations, this.rooms, this.users, 
                this.customers, this.providers, this.admins, this.messages, this.mainUI, currentUsername);
        newMessageForm.setCurrentForm(newMessageForm);
        this.jframe.add(newMessageForm);
        this.currentForm.setVisible(false);
    }

    private void inboxButtonClick(ActionEvent e) {
        inboxForm inboxForm = new inboxForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, currentUsername);
        inboxForm.setCurrentForm(inboxForm);
        this.jframe.add(inboxForm);
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label1 = new JLabel();
        button3 = new JButton();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Message");
        add(label1, "cell 4 0");

        //---- button3 ----
        button3.setText("New message");
        button3.addActionListener(e -> newMessageButtonClick(e));
        add(button3, "cell 4 2");

        //---- button1 ----
        button1.setText("Inbox");
        button1.addActionListener(e -> inboxButtonClick(e));
        add(button1, "cell 4 3");

        //---- button2 ----
        button2.setText("Return");
        button2.addActionListener(e -> returnButtonClicked(e));
        add(button2, "cell 4 4");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label1;
    private JButton button3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
