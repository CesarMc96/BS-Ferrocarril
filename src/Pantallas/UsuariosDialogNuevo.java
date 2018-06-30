
package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UsuariosDialogNuevo extends JDialog{

    private final JPanel pnlBotones;
    private final JButton btnGuardar;
    private final JButton btnCancelar;
    private final JLabel lblNombre;
    private final JLabel lblApMaterno;
    private final JLabel lblApPaterno;
    private final JLabel lblCredencial;
    private final JLabel lblDireccion;
    private final JLabel lblTelefono;
    private final JLabel lblCorreo;
    private final JLabel lblUsuarioNuevo;
    private final JPanel pnlTitulo;
    
    public UsuariosDialogNuevo() {
        super.setSize(400, 400);
        super.setBackground(Color.WHITE);
        super.setLayout(new BorderLayout());
        super.setTitle("Usuario Nuevo");
        
        //Textos
        lblUsuarioNuevo = new JLabel("Usuario Nuevo");
        lblNombre = new JLabel("Nombre: ");
        lblApPaterno = new JLabel("Apellido Paterno: ");
        lblApMaterno = new JLabel("Materno: ");
        lblCredencial = new JLabel("Numero de Credencial: ");
        lblDireccion = new JLabel("Direccion: ");
        lblTelefono = new JLabel("Telefono: ");
        lblCorreo = new JLabel("Correo: ");
        
        pnlTitulo = new JPanel();
        pnlTitulo.add(lblUsuarioNuevo);
        pnlTitulo.setBackground(Color.white);
        super.add(pnlTitulo, BorderLayout.PAGE_START);
        
        //Botones
        pnlBotones = new JPanel();
        pnlBotones.setBackground(Color.WHITE);
        
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        
        pnlBotones.add(btnGuardar);
        pnlBotones.add(new JLabel("            "));
        pnlBotones.add(btnCancelar);
        
        super.add(pnlBotones, BorderLayout.PAGE_END); 
        
        //acciones
        btnCancelar.addActionListener((ActionEvent e) -> {
            super.setVisible(false);
        });
        
    }
}
