import java.awt.*;
import javax.swing.*;
import java.util.Map;
import java.util.Objects;

public class messageNewMessageForm extends JPanel {
    JFrame jframe;
    messageNewMessageForm currentForm;
    String currentUsername;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    
    public void setCurrentForm(messageNewMessageForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public messageNewMessageForm(JFrame jframe, Map<Integer,Reservation> reservations,
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
        jframe.setPreferredSize(new Dimension(450 , 390));
        jframe.pack();
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
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        textField1 = new JTextField();
        JLabel label3 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        label4 = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        JButton button1 = new JButton();
        JButton button2 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("New message");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(140, 20, 170, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("From:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label2);
        label2.setBounds(95, 65, 55, 25);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField1.setForeground(Color.black);

        add(textField1);
        textField1.setBounds(170, 65, 110, 25);

        //---- label3 ----
        label3.setText("To:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label3);
        label3.setBounds(95, 95, 55, 25);

        //---- textField2 ----
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField2.setForeground(Color.black);

        add(textField2);
        textField2.setBounds(170, 95, 110, 25);

        //---- label5 ----
        label5.setText("Content can't be empty");
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setVisible(false);
        add(label5);
        label5.setBounds(110, 125, 225, 25);

        //---- label4 ----
        label4.setText("Username not found");
        label4.setVisible(false);
        add(label4);
        label4.setBounds(290, 100, 165, 25);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setRows(6);
            textArea1.setLineWrap(true);
            textArea1.setFont(new Font("Tahoma", Font.PLAIN, 14));

            textArea1.setForeground(Color.black);
            textArea1.setBackground(Color.white);
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(50, 155, 350, 120);

        //---- button1 ----
        button1.setText("Cancel");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> cancelButtonClick());
        add(button1);
        button1.setBounds(80, 300, 125, 40);

        //---- button2 ----
        button2.setText("Send");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));

        button2.addActionListener(e -> sendButtonClick());
        add(button2);
        button2.setBounds(245, 300, 125, 40);

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
    }
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label5;
    private JLabel label4;
    private JTextArea textArea1;
}
