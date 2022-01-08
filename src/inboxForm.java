import javax.swing.*;

import net.miginfocom.swing.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Created by JFormDesigner on Thu Jan 06 22:55:35 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class inboxForm extends JPanel {
    JFrame jframe;
    inboxForm currentForm;
    String currentUsername;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    DefaultListModel<String> model;
    private ArrayList<Integer> idsInList;

    public void setCurrentForm(inboxForm currentForm) {
        this.currentForm = currentForm;
    }

    public inboxForm(JFrame jframe, Map<Integer,Reservation> reservations,
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

        idsInList = new ArrayList<>();
        model = new DefaultListModel<>();
        AtomicBoolean noMessages = new AtomicBoolean(true);
        this.messages.forEach((id, message) -> {
            if (Objects.equals(message.getRecipient(), currentUsername)){
                if (!message.isRead()) {
                    try {
                        model.addElement("(new) From: \"" + message.getSender() +
                                "\", Content: " + message.getContent().substring(0, 10) + "...");
                        noMessages.set(false);
                        idsInList.add(message.getID());
                    } catch (StringIndexOutOfBoundsException ignored) {
                        model.addElement("(new) From: \"" + message.getSender() +
                                "\", Content: " + message.getContent() + "...");
                        noMessages.set(false);
                        idsInList.add(message.getID());
                    }
                }
            }
        });
        this.messages.forEach((id, message) -> {
            if (Objects.equals(message.getRecipient(), currentUsername)){
                if (message.isRead()) {
                    try {
                    model.addElement("From: \"" + message.getSender() +
                            "\", Content: " + message.getContent().substring(0,10) + "...");
                    noMessages.set(false);
                    idsInList.add(message.getID());
                    } catch (StringIndexOutOfBoundsException ignored) {
                        model.addElement("From: \"" + message.getSender() +
                                "\", Content: " + message.getContent() + "...");
                        noMessages.set(false);
                        idsInList.add(message.getID());
                    }
                }
            }
        });
        if (noMessages.get()) {
            model.addElement("No messages found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void listValueSelected() {
        label3.setText(messages.get(idsInList.get(list1.getSelectedIndex())).getSender());
        textArea1.setText(messages.get(idsInList.get(list1.getSelectedIndex())).getContent());
        messages.get(idsInList.get(list1.getSelectedIndex())).setRead(true);

        idsInList = new ArrayList<>();
        model = new DefaultListModel<>();
        AtomicBoolean noMessages = new AtomicBoolean(true);
        this.messages.forEach((id, message) -> {
            if (Objects.equals(message.getRecipient(), currentUsername)){
                if (!message.isRead()) {
                    try {
                        model.addElement("(new) From: \"" + message.getSender() +
                                "\", Content: " + message.getContent().substring(0, 10) + "...");
                        noMessages.set(false);
                        idsInList.add(message.getID());
                    } catch (StringIndexOutOfBoundsException ignored) {
                        model.addElement("(new) From: \"" + message.getSender() +
                                "\", Content: " + message.getContent() + "...");
                        noMessages.set(false);
                        idsInList.add(message.getID());
                    }
                }
            }
        });
        this.messages.forEach((id, message) -> {
            if (Objects.equals(message.getRecipient(), currentUsername)){
                if (message.isRead()) {
                    try {
                        model.addElement("From: \"" + message.getSender() +
                                "\", Content: " + message.getContent().substring(0,10) + "...");
                        noMessages.set(false);
                        idsInList.add(message.getID());
                    } catch (StringIndexOutOfBoundsException ignored) {
                        model.addElement("From: \"" + message.getSender() +
                                "\", Content: " + message.getContent() + "...");
                        noMessages.set(false);
                        idsInList.add(message.getID());
                    }
                }
            }
        });
        if (noMessages.get()) {
            model.addElement("No messages found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void returnButtonClicked() {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, currentUsername);
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(e -> {if("\u0062order".equals(e.
        getPropertyName()))throw new RuntimeException();});
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
            "[]"));

        //---- label1 ----
        label1.setText("Inbox");
        add(label1, "cell 6 0");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.addListSelectionListener(e -> listValueSelected());
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 2 2 14 1");

        //---- label2 ----
        label2.setText("From:");
        add(label2, "cell 4 4");
        add(label3, "cell 5 4");

        //======== scrollPane2 ========
        {

            //---- textArea1 ----
            textArea1.setRows(5);
            textArea1.setLineWrap(true);
            textArea1.setEnabled(false);
            scrollPane2.setViewportView(textArea1);
        }
        add(scrollPane2, "cell 4 5 10 4");

        //---- button1 ----
        button1.setText("Return");
        button1.addActionListener(e -> returnButtonClicked());
        add(button1, "cell 7 10");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
