import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Nov 16 13:58:32 CET 2019
 */



/**
 * @author Oscar Morente Mateo
 */
public class home  {

    private void loginMouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        MainPage = new JPanel();
        label1 = new JLabel();
        login = new JButton();

        //======== MainPage ========
        {
            MainPage.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,MainPage. getBorder( )) ); MainPage. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );
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
            login.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loginMouseClicked(e);
                }
            });
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
