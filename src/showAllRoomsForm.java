import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 20:22:31 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class showAllRoomsForm extends JPanel {
    JFrame jframe;
    showAllRoomsForm currentForm;
    private final Provider provider;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    DefaultListModel<String> model;
    private static DecimalFormat df;

    public void setCurrentForm(showAllRoomsForm currentForm) {
        this.currentForm = currentForm;
    }

    public showAllRoomsForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                            Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                            Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Provider provider) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI=mainUI;
        this.provider = provider;
        initComponents();
        jframe.setPreferredSize(new Dimension(665, 400));
        jframe.pack();

        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        AtomicBoolean noRoomsForProvider = new AtomicBoolean(true);
        this.rooms.forEach((id, Room) -> {
            if (Objects.equals(Room.getOwner(), this.provider.getUsername())){
                model.addElement("Name: \"" + rooms.get(id).getName() +
                        "\", type: " + rooms.get(id).getType() + ", capacity: " +
                        rooms.get(id).getCapacity().toString()+ ", price: $" +
                        df.format(rooms.get(id).getPrice()));
                noRoomsForProvider.set(false);
            }
        });
        if (noRoomsForProvider.get()) {
            model.addElement("No rooms found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void returnButtonClick(ActionEvent e) {
        providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.provider);
        providerForm.setCurrentForm(providerForm);
        this.jframe.add(providerForm);
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        button1 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
        .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".equals(e.
        getPropertyName()))throw new RuntimeException();}});
        setLayout(null);

        //---- label1 ----
        label1.setText("Available rooms");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(new Rectangle(new Point(245, 20), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Please select a room");
        label2.setVisible(false);
        add(label2);
        label2.setBounds(0, 0, 0, 0);

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "Name: \"test\", type: hotel, capacity: 2, price: $40.00"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            list1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(50, 60, 565, 245);

        //---- button1 ----
        button1.setText("Return");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> returnButtonClick(e));
        add(button1);
        button1.setBounds(270, 320, 125, 40);

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
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
