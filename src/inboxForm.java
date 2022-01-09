import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
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
        jframe.setPreferredSize(new Dimension(540 , 346));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
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

    private void listValueSelected(ListSelectionEvent e) {
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

    private void returnButtonClicked(ActionEvent e) {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, currentUsername);
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
        new javax.swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
        ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
        ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12)
        ,java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
        setLayout(null);

        //---- label1 ----
        label1.setText("Inbox");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label1);
        label1.setBounds(240, 5, label1.getPreferredSize().width, 30);

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.addListSelectionListener(e -> listValueSelected(e));
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(50, 35, 440, scrollPane1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("From:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(new Rectangle(new Point(65, 235), label2.getPreferredSize()));
        add(label3);
        label3.setBounds(150, 217, 20, label3.getPreferredSize().height);

        //======== scrollPane2 ========
        {

            //---- textArea1 ----
            textArea1.setRows(5);
            textArea1.setLineWrap(true);
            textArea1.setEnabled(false);
            textArea1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            scrollPane2.setViewportView(textArea1);
        }
        add(scrollPane2);
        scrollPane2.setBounds(165, 215, 210, 50);

        //---- button1 ----
        button1.setText("Return");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));
        button1.addActionListener(e -> returnButtonClicked(e));
        add(button1);
        button1.setBounds(200, 285, 145, button1.getPreferredSize().height);

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
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
