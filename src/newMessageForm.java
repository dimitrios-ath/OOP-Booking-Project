import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
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
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    
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
        jframe.setPreferredSize(new Dimension(419 , 218));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
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
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
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
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("New message");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(110, 5, 170, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("From:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(label2);
        label2.setBounds(5, 45, 50, 26);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField1.setBackground(Color.white);
        add(textField1);
        textField1.setBounds(80, 45, 85, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("To:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(label3);
        label3.setBounds(5, 80, 55, 26);

        //---- textField2 ----
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField2);
        textField2.setBounds(80, 75, 83, textField2.getPreferredSize().height);

        //---- label5 ----
        label5.setText("Content can't be empty");
        label5.setVisible(false);
        add(label5);
        label5.setBounds(0, 0, 0, 0);

        //---- label4 ----
        label4.setText("Username does not exist");
        label4.setVisible(false);
        add(label4);
        label4.setBounds(0, 0, 0, 0);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setRows(6);
            textArea1.setLineWrap(true);
            textArea1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(80, 105, 265, scrollPane1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Cancel");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));
        button1.addActionListener(e -> cancelButtonClick(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(80, 215), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Send");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));
        button2.addActionListener(e -> sendButtonClick(e));
        add(button2);
        button2.setBounds(185, 215, 160, button2.getPreferredSize().height);

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
