import java.awt.*;
import javax.swing.*;
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
        initComponents();
        textField1.setText(currentUsername);
        textField1.setEnabled(false);
    }

    private void cancelButtonClick() {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, currentUsername);
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    private void sendButtonClick() {
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
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
        . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing
        .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
        Font ( "Dialo\u0067", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
        ) , getBorder () ) );  addPropertyChangeListener(e -> { if( "borde\u0072" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;});
        setLayout(null);

        //---- label1 ----
        label1.setText("New message");
        add(label1);
        label1.setBounds(117, 25, 93, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("From:");
        add(label2);
        label2.setBounds(25, 46, 87, 26);

        //---- textField1 ----
        textField1.setText("currentName");
        add(textField1);
        textField1.setBounds(new Rectangle(new Point(117, 46), textField1.getPreferredSize()));

        //---- label3 ----
        label3.setText("To:");
        add(label3);
        label3.setBounds(25, 77, 87, 26);
        add(textField2);
        textField2.setBounds(117, 77, 93, textField2.getPreferredSize().height);

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
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(25, 108), scrollPane1.getPreferredSize()));

        //---- button1 ----
        button1.setText("Cancel");
        button1.addActionListener(e -> cancelButtonClick());
        add(button1);
        button1.setBounds(new Rectangle(new Point(25, 255), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Send");
        button2.addActionListener(e -> sendButtonClick());
        add(button2);
        button2.setBounds(235, 270, 172, button2.getPreferredSize().height);

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
