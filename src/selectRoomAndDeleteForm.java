import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 19:26:31 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class selectRoomAndDeleteForm extends JPanel {
    JFrame jframe;
    selectRoomAndDeleteForm currentForm;
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
    private final ArrayList<Integer> idsInList;

    public void setCurrentForm(selectRoomAndDeleteForm currentForm) {
        this.currentForm = currentForm;
    }

    public selectRoomAndDeleteForm(JFrame jframe, Map<Integer,Reservation> reservations,
                                   Map<Integer,Room> rooms, Map<String,Authentication> users,
                                   Map<String,Customer> customers, Map<String,Provider> providers,
                                   Map<String,Admin> admins, Map<Integer,Message> messages,
                                   MainUI mainUI, Provider provider) {
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
        jframe.setPreferredSize(new Dimension(930, 425));
        jframe.pack();
        jframe.setLocationRelativeTo(null);

        idsInList = new ArrayList<>();
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        AtomicBoolean noRoomsForProvider = new AtomicBoolean(true);
        this.rooms.forEach((id, Room) -> {
            if (Objects.equals(Room.getOwner(), this.provider.getUsername())){
                model.addElement("Name: \"" + rooms.get(id).getName() +
                        "\", type: " + rooms.get(id).getType() + ", capacity: " +
                        rooms.get(id).getCapacity().toString()+ ", price: $" +
                        df.format(rooms.get(id).getPrice()));
                idsInList.add(id);
                noRoomsForProvider.set(false);
            }
        });
        if (noRoomsForProvider.get()) {
            model.addElement("No rooms found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void cancelButtonClick() {
        providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.provider);
        providerForm.setCurrentForm(providerForm);
        this.jframe.add(providerForm);
        this.currentForm.setVisible(false);
    }

    private void removeButtonClick() {
        int id;
        if (!list1.isSelectionEmpty()) {
            id = idsInList.get(list1.getSelectedIndex());
            AtomicBoolean reservationsForRoomExist = new AtomicBoolean(false);
            int finalId = id;
            // check if there are existing reservations for specific room
            reservations.forEach((reservationID, Reservation) -> {
                if (Reservation.getRoomID() == finalId){
                    reservationsForRoomExist.set(true);
                }
            });

            if (rooms.containsKey(id) && Objects.equals(rooms.get(id).getOwner(), provider.getUsername()) &&
                    !reservationsForRoomExist.get() && id!=0) {
                rooms.remove(id);
                providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms,
                        this.users, this.customers, this.providers, this.admins, this.messages, this.mainUI,
                        this.provider);
                providerForm.setCurrentForm(providerForm);
                this.jframe.add(providerForm);
                this.currentForm.setVisible(false);
            }
            else if (id!=0 && reservationsForRoomExist.get()){
                label2.setText("Can't remove this room because there are existing reservations");
                label2.setForeground(Color.red);
                label2.setVisible(true);
            }
            else {
                label2.setText("Can't remove this room");
                label2.setForeground(Color.red);
                label2.setVisible(true);
            }
        }
        else {
            label2.setForeground(Color.red);
            label2.setVisible(true);
        }
    }

    private void cancelButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void removeButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.red
        ), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName(
        )))throw new RuntimeException();}});
        setLayout(null);

        //---- label1 ----
        label1.setText("Select a room to remove:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(label1);
        label1.setBounds(new Rectangle(new Point(375, 80), label1.getPreferredSize()));

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
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(55, 115, 820, 220);

        //---- button1 ----
        button1.setText("Cancel");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.addActionListener(e -> cancelButtonClick(e));
        add(button1);
        button1.setBounds(235, 370, 126, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Remove");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.addActionListener(e -> removeButtonClick(e));
        add(button2);
        button2.setBounds(565, 370, 125, button2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Remove existing room");
        label3.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label3);
        label3.setBounds(new Rectangle(new Point(340, 25), label3.getPreferredSize()));

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
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
