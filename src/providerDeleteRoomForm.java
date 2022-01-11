import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;

public class providerDeleteRoomForm extends JPanel {
    JFrame jframe;
    providerDeleteRoomForm currentForm;
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

    public void setCurrentForm(providerDeleteRoomForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Constructor of providerDeleteRoomForm. Adds to displayed list all rooms of the authenticated provider
     *
     * @param jframe
     * @param reservations
     * @param rooms
     * @param users
     * @param customers
     * @param providers
     * @param admins
     * @param messages
     * @param mainUI
     * @param provider
     */
    public providerDeleteRoomForm(JFrame jframe, Map<Integer,Reservation> reservations,
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

    /**
     * Returns to the provider panel
     */
    private void cancelButtonClick() {
        providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.provider);
        providerForm.setCurrentForm(providerForm);
        this.jframe.add(providerForm);
        this.currentForm.setVisible(false);
    }

    /**
     * If no reservations for the selected room exist, the selected room is removed.
     * Otherwise, the appropriate error message is displayed
     */
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

    /**
     *   Form generator
     */
    private void initComponents() {
        JLabel label1 = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JLabel label3 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setForeground(Color.white);
        setLayout(null);

        //---- label1 ----
        label1.setText("Select a room to remove:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(new Rectangle(new Point(245, 90), label1.getPreferredSize()));

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
        button1.setBounds(140, 320, 120, 40);

        //---- button2 ----
        button2.setText("Remove");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));

        button2.addActionListener(e -> removeButtonClick());
        add(button2);
        button2.setBounds(410, 320, 120, 40);

        //---- label3 ----
        label3.setText("Remove existing room");
        label3.setFont(new Font("Tahoma", Font.BOLD, 22));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(new Rectangle(new Point(210, 15), label3.getPreferredSize()));

        //---- label2 ----
        label2.setText("Please select a room");
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.white);
        label2.setVisible(false);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2);
        label2.setBounds(55, 55, 560, 25);

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
    private JList<String> list1;
    private JLabel label2;
}
