import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Nov 16 13:58:32 CET 2019
 */



/**
 * @author Oscar Morente Mateo
 */
public class home  {

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        MainPage = new JPanel();
        label1 = new JLabel();
        login = new JButton();

        //======== MainPage ========
        {
            MainPage.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,MainPage. getBorder( )) ); MainPage. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
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

            //---- login ----
            login.setText("Iniciar Sesion");
            MainPage.add(login, "cell 1 1");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel MainPage;
    private JLabel label1;
    private JButton login;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
