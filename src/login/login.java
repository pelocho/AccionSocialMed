import javax.swing.*;
import net.miginfocom.swing.*;
/**
 * @author Óscar
 */
public class login {
    public login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        MainPage = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== MainPage ========
        {
            MainPage.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,MainPage. getBorder( )) ); MainPage. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );
            MainPage.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[148,fill]" +
                "[fill]",
                // rows
                "[]" +
                "[66]" +
                "[]"));

            //---- label1 ----
            label1.setText("\u00a1Bienvenido a Acci\u00f3nSocialMed!");
            MainPage.add(label1, "cell 1 0");

            //---- button1 ----
            button1.setText("Iniciar Sesion");
            MainPage.add(button1, "cell 1 1");

            //---- button2 ----
            button2.setText("Registrarse");
            MainPage.add(button2, "cell 1 2");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel MainPage;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
