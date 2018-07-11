package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AutorDialogNuevo extends JDialog {

    private final JPanel pnlBotones;
    private final JPanel pnlBotonesIn;
    private final JButton btnAceptar;
    private final JButton btnCancelar;
    private final JLabel lblEspacio;
    private final JPanel pnlDatos;
    private final JPanel pnlDatos1;
    private final JLabel lblNombre;
    private final TextField txtNombre;
    private final JPanel pnlDatos2;
    private final JLabel lblApellidos;
    private final TextField txtApellidos;

//    public AutorDialogNuevo(Dialog f) {
    public AutorDialogNuevo() {
//        super(f, true);
        super.setSize(400, 210);
        super.setTitle("Nuevo Autor");
        super.getContentPane().setBackground(Color.WHITE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        
        setIconImage( new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg")).getImage());

        pnlBotones = new JPanel();
        pnlBotones.setLayout(new BorderLayout());

        pnlBotonesIn = new JPanel();
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        lblEspacio = new JLabel("   ");
        pnlBotonesIn.add(btnAceptar);
        pnlBotonesIn.add(btnCancelar);
        pnlBotonesIn.add(lblEspacio);
        pnlBotones.add(pnlBotonesIn, BorderLayout.EAST);

        pnlDatos = new JPanel();
        pnlDatos.setLayout(new BorderLayout());
        
        pnlDatos1 = new JPanel();
        pnlDatos1.setLayout(new BorderLayout());
        lblNombre = new JLabel("          Nombre  ");
        txtNombre = new TextField(15);
        pnlDatos2 = new JPanel();
        lblApellidos = new JLabel("Apellidos  ");
        txtApellidos = new TextField(15);
        
        pnlBotones.setBackground(Color.WHITE);
        pnlBotonesIn.setBackground(Color.WHITE);
        pnlDatos.setBackground(Color.WHITE);
        pnlDatos1.setBackground(Color.WHITE);
        pnlDatos2.setBackground(Color.WHITE);
        
        pnlDatos1.add(lblNombre, BorderLayout.WEST);
        pnlDatos1.add(txtNombre);
        pnlDatos1.add(new JLabel("                                    "), BorderLayout.EAST);

        pnlDatos2.add(lblApellidos, BorderLayout.WEST);
        pnlDatos2.add(txtApellidos);
        
        pnlDatos.add(pnlDatos1, BorderLayout.PAGE_START);
        pnlDatos.add(pnlDatos2, BorderLayout.CENTER);
        
        super.add(pnlDatos, BorderLayout.CENTER);
        super.add(pnlBotones, BorderLayout.PAGE_END);
    }
}
