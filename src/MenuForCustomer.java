import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Mon Jan 03 12:12:26 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class MenuForCustomer  {

    public JButton getButtonRegister() {
        return ButtonRegister;
    }

    public JButton getButtonRegister2() {
        return ButtonRegister2;
    }

    public JButton getButtonRegister3() {
        return ButtonRegister3;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        createUIComponents();

        panel3 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label12 = new JLabel();
        labelFirstName = new JLabel();
        labelFirstName3 = new JLabel();

        //======== panel3 ========
        {
            panel3.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel3. getBorder () ) ); panel3. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //======== panel4 ========
            {
                panel4.setBackground(new Color(51, 51, 255));

                //---- label2 ----
                label2.setIcon(new ImageIcon(getClass().getResource("/calendar.png")));

                //---- label12 ----
                label12.setText("meTa");
                label12.setFont(new Font("Century Gothic", Font.BOLD, 28));
                label12.setForeground(Color.white);

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGroup(panel4Layout.createParallelGroup()
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addGap(126, 126, 126)
                                    .addComponent(label1))
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(label12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(309, Short.MAX_VALUE))
                );
            }

            //---- labelFirstName ----
            labelFirstName.setText("Find deals on hotels,home and much more..");
            labelFirstName.setForeground(new Color(51, 51, 255));
            labelFirstName.setFont(new Font("Century Gothic", Font.BOLD, 14));

            //---- labelFirstName3 ----
            labelFirstName3.setText("From cosy country homes to funky city flats.");
            labelFirstName3.setForeground(new Color(51, 51, 255));
            labelFirstName3.setFont(new Font("Century Gothic", Font.BOLD, 14));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(labelFirstName, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFirstName3))
                        .addGap(0, 130, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addComponent(panel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelFirstName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFirstName3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 441, Short.MAX_VALUE))
            );
        }

        //---- ButtonRegister3 ----
        ButtonRegister3.setText("Show all reservations");
        ButtonRegister3.setForeground(new Color(51, 51, 255));
        ButtonRegister3.setFont(new Font("Century Gothic", Font.BOLD, 18));
        ButtonRegister3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));

        //---- ButtonRegister2 ----
        ButtonRegister2.setText("Cance Reservation");
        ButtonRegister2.setForeground(new Color(51, 51, 255));
        ButtonRegister2.setFont(new Font("Century Gothic", Font.BOLD, 18));
        ButtonRegister2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));

        //---- ButtonRegister ----
        ButtonRegister.setText("Search/Reserve");
        ButtonRegister.setForeground(new Color(51, 51, 255));
        ButtonRegister.setFont(new Font("Century Gothic", Font.BOLD, 18));
        ButtonRegister.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JPanel panel3;
    private JPanel panel4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label12;
    private JLabel labelFirstName;
    private JLabel labelFirstName3;
    private JButton ButtonRegister3;
    private JButton ButtonRegister2;
    private JButton ButtonRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
