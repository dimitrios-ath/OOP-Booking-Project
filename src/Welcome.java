import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Tue Jan 04 23:04:15 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class Welcome extends JFrame {
    private JLabel IconHotel2;

    public Welcome() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        panelWelcome = new JPanel();
        label2 = new JLabel();
        IconHotel = new JLabel();
        Percentage = new JLabel();
        IconHotel2 = new JLabel();
        progressBar1 = new JProgressBar();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();

        //======== panelWelcome ========
        {
            panelWelcome.setBackground(new Color(51, 51, 255));
            panelWelcome.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
            ),panelWelcome. getBorder()));panelWelcome. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName(
            )))throw new RuntimeException();}});

            //---- label2 ----
            label2.setText("me\u03a4\u03b1.booking");
            label2.setFont(new Font("Century Gothic", Font.BOLD, 48));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setBackground(Color.black);
            label2.setForeground(Color.white);

            //---- IconHotel ----
            IconHotel.setIcon(new ImageIcon(getClass().getResource("/hotel (5).png")));
            IconHotel.setBackground(new Color(51, 51, 255));

            //---- Percentage ----
            Percentage.setText("     ");
            Percentage.setForeground(Color.white);
            Percentage.setFont(new Font("Century Gothic", Font.BOLD, 14));
            Percentage.setFocusable(false);
            Percentage.setRequestFocusEnabled(false);
            Percentage.setVerifyInputWhenFocusTarget(false);

            //---- IconHotel2 ----
            IconHotel2.setIcon(new ImageIcon(getClass().getResource("/hotel (5).png")));
            IconHotel2.setBackground(new Color(51, 51, 255));

            GroupLayout panelWelcomeLayout = new GroupLayout(panelWelcome);
            panelWelcome.setLayout(panelWelcomeLayout);
            panelWelcomeLayout.setHorizontalGroup(
                panelWelcomeLayout.createParallelGroup()
                    .addGroup(panelWelcomeLayout.createSequentialGroup()
                        .addGroup(panelWelcomeLayout.createParallelGroup()
                            .addGroup(panelWelcomeLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(label2)
                                .addGap(76, 76, 76)
                                .addComponent(IconHotel2))
                            .addGroup(panelWelcomeLayout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(Percentage, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
                        .addGap(389, 389, 389)
                        .addComponent(IconHotel))
                    .addComponent(progressBar1, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
            );
            panelWelcomeLayout.setVerticalGroup(
                panelWelcomeLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelWelcomeLayout.createSequentialGroup()
                        .addContainerGap(95, Short.MAX_VALUE)
                        .addComponent(IconHotel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(panelWelcomeLayout.createSequentialGroup()
                        .addGroup(panelWelcomeLayout.createParallelGroup()
                            .addGroup(panelWelcomeLayout.createSequentialGroup()
                                .addGap(0, 111, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(Percentage, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelWelcomeLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(IconHotel2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressBar1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panelWelcome, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelWelcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
       
    }
    private JPanel panelWelcome;
    private JLabel label2;
    private JLabel IconHotel;
    private JLabel Percentage;
    private JProgressBar progressBar1;

    public static void main(String[] args){
        Welcome welcome=new Welcome();
        welcome.setVisible(true);
        try{
            for (int i=0; i<=100; i++) {
                Thread.sleep(40);
                welcome.progressBar1.setValue(i);
                welcome.Percentage.setText(Integer.toString(i) + "%");
            }

        }catch (Exception e){

        }
        new Login().setVisible(true);
        welcome.dispose();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis

  //GEN-END:variables
}
