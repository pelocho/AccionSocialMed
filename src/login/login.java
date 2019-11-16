import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Nov 16 13:56:55 CET 2019
 */



/**
 * @author Oscar Morente Mateo
 */
public class login  {

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        IniciarSesion = new JPanel();
        label1 = new JLabel();
        separator1 = new JSeparator();
        label3 = new JLabel();
        correoInput = new JTextField();
        label4 = new JLabel();
        passwordInput = new JTextField();

        //======== IniciarSesion ========
        {
            IniciarSesion.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,IniciarSesion. getBorder( )) ); IniciarSesion. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            IniciarSesion.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[50,fill]" +
                "[52,fill]" +
                "[56,fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[29]" +
                "[34]"));

            //---- label1 ----
            label1.setText("Iniciar Sesi\u00f3n");
            IniciarSesion.add(label1, "cell 1 0 3 2");
            IniciarSesion.add(separator1, "cell 0 2 6 1");

            //---- label3 ----
            label3.setText("Correo:");
            IniciarSesion.add(label3, "cell 0 4");
            IniciarSesion.add(correoInput, "cell 1 4 4 1");

            //---- label4 ----
            label4.setText("Contrase\u00f1a:");
            IniciarSesion.add(label4, "cell 0 5");
            IniciarSesion.add(passwordInput, "cell 1 5 4 1");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel IniciarSesion;
    private JLabel label1;
    private JSeparator separator1;
    private JLabel label3;
    private JTextField correoInput;
    private JLabel label4;
    private JTextField passwordInput;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
