import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.util.Map;
import java.util.Objects;
/*
 * Created by JFormDesigner on Thu Jan 06 22:28:31 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class newMessageForm extends JPanel {
    JFrame jframe;
    newMessageForm currentForm;
    String currentUsername;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
    
    public void setCurrentForm(newMessageForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public newMessageForm(JFrame jframe, Map<Integer,Reservation> reservations,
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
        textField1.setText(currentUsername);
        textField1.setEnabled(false);
    }

    private void cancelButtonClick(ActionEvent e) {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, currentUsername);
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    private void sendButtonClick(ActionEvent e) {
        if (users.containsKey(textField2.getText()) && !Objects.equals(textField2.getText(), "")) {
            label4.setForeground(null);
            label4.setVisible(false);
            if (!Objects.equals(textArea1.getText(), "")) {
                label5.setVisible(false);
                boolean addedToHashMap = false;
                int i = 1;
                while (!addedToHashMap && i < 1000) {
                    if (!messages.containsKey(i)) {
                        messages.put(i, new Message(i, textField2.getText(), currentUsername, textArea1.getText(), false));
                        addedToHashMap = true;
                        System.out.println("\nMessage successfully sent");
                    } else {
                        i++;
                    }
                }
                messageForm messageForm = new messageForm(
                        this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                        this.admins, this.messages, this.mainUI, currentUsername);
                messageForm.setCurrentForm(messageForm);
                this.jframe.add(messageForm);
                this.currentForm.setVisible(false);
            }
            else {
                label5.setForeground(Color.red);
                label5.setVisible(true);
            }
        }
        else {
            label4.setForeground(Color.red);
            label4.setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
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
            "[]"));

        //---- label1 ----
        label1.setText("New message");
        add(label1, "cell 6 0");

        //---- label2 ----
        label2.setText("From:");
        add(label2, "cell 5 2");

        //---- textField1 ----
        textField1.setText("currentName");
        add(textField1, "cell 6 2");

        //---- label3 ----
        label3.setText("To:");
        add(label3, "cell 5 3");
        add(textField2, "cell 6 3");

        //---- label5 ----
        label5.setText("Content can't be empty");
        label5.setVisible(false);
        add(label5, "cell 6 4");

        //---- label4 ----
        label4.setText("Username does not exist");
        label4.setVisible(false);
        add(label4, "cell 7 3");

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setRows(6);
            textArea1.setLineWrap(true);
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1, "cell 4 5 7 4");

        //---- button1 ----
        button1.setText("Cancel");
        button1.addActionListener(e -> cancelButtonClick(e));
        add(button1, "cell 5 10");

        //---- button2 ----
        button2.setText("Send");
        button2.addActionListener(e -> sendButtonClick(e));
        add(button2, "cell 8 10");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label5;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
