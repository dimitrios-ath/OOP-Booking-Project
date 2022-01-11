import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;

public class providerSelectRoomToReturnReservationsForm extends JPanel {
    JFrame jframe;
    providerSelectRoomToReturnReservationsForm currentForm;
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
    
    public void setCurrentForm(providerSelectRoomToReturnReservationsForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public providerSelectRoomToReturnReservationsForm(JFrame jframe, Map<Integer,Reservation> reservations,
                                                      Map<Integer,Room> rooms, Map<String,Authentication> users, Map<String,Customer> customers,
                                                      Map<String,Provider> providers, Map<String,Admin> admins, Map<Integer,Message> messages,
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
        jframe.setPreferredSize(new Dimension(665, 400));
        jframe.pack();

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

    private void nextButtonClick() {
        if (!list1.isSelectionEmpty()) {
            providerReturnAllReservationsForRoomForm providerReturnAllReservationsForRoomForm = new providerReturnAllReservationsForRoomForm(this.jframe,
                    this.reservations, this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                    this.mainUI, this.provider, idsInList.get(list1.getSelectedIndex()));
            providerReturnAllReservationsForRoomForm.setCurrentForm(providerReturnAllReservationsForRoomForm);
            this.jframe.add(providerReturnAllReservationsForRoomForm);
            this.currentForm.setVisible(false);
        } else {
            label2.setForeground(Color.red);
            label2.setVisible(true);
        }
    }

    private void initComponents() {
        JLabel label1 = new JLabel();
        label2 = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JLabel label3 = new JLabel();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Select a room for the list below:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(new Rectangle(new Point(225, 90), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Please select a room");
        label2.setVisible(false);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2);
        label2.setBounds(55, 55, 560, 25);

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setModel(new AbstractListModel<>() {
                final String[] values = {
                        "Name: \"test\", type: hotel, capacity: 2, price: $40.00"
                };

                @Override
                public int getSize() {
                    return values.length;
                }

                @Override
                public String getElementAt(int i) {
                    return values[i];
                }
            });

            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(50, 115, 565, 190);

        //---- button1 ----
        button1.setText("Cancel");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> cancelButtonClick());
        add(button1);
        button1.setBounds(105, 320, 125, 40);

        //---- button2 ----
        button2.setText("Next");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));

        button2.addActionListener(e -> nextButtonClick());
        add(button2);
        button2.setBounds(435, 320, 125, 40);

        //---- label3 ----
        label3.setText("Reservations");
        label3.setFont(new Font("Tahoma", Font.BOLD, 22));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(new Rectangle(new Point(260, 15), label3.getPreferredSize()));

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
    private JLabel label2;
    private JList<String> list1;
}
