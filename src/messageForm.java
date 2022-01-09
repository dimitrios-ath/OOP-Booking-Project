import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

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
        jframe.setPreferredSize(new Dimension(315 , 173));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        initComponents();
        initComponents();
    }

    private void returnButtonClicked(ActionEvent e) {
        if (this.users.get(currentUsername).getRole()==1) {
            customerForm customerForm = new customerForm(this.jframe, this.reservations, this.rooms, this.users,
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.customers.get(currentUsername));
            customerForm.setCurrentForm(customerForm);
            this.jframe.add(customerForm);
            this.currentForm.setVisible(false);
        } else if (this.users.get(currentUsername).getRole()==2) {
            providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, 
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.providers.get(currentUsername));
            providerForm.setCurrentForm(providerForm);
            this.jframe.add(providerForm);
            this.currentForm.setVisible(false);
        } else if (this.users.get(currentUsername).getRole()==3) {
            adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admins.get(currentUsername));
            adminForm.setCurrentForm(adminForm);
            this.jframe.add(adminForm);
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
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Messages");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label1);
        label1.setBounds(100, 10, 110, label1.getPreferredSize().height);

        //---- button3 ----
        button3.setText("New message");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(51, 102, 255));
        button3.addActionListener(e -> newMessageButtonClick(e));
        add(button3);
        button3.setBounds(90, 50, 130, button3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Inbox");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));
        button1.addActionListener(e -> inboxButtonClick(e));
        add(button1);
        button1.setBounds(90, 80, 130, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Return");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));
        button2.addActionListener(e -> returnButtonClicked(e));
        add(button2);
        button2.setBounds(90, 120, 130, button2.getPreferredSize().height);

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
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label1;
    private JButton button3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
