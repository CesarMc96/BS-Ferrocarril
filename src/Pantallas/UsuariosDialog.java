package Pantallas;

import BD.DataSourcePostgreSQL;
import BD.ModeloUsuario;
import BD.UsuariosDialogListener;
import DAO.DAOUsuarioImpl;
import Modelo.Usuario;
import com.placeholder.PlaceHolder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UsuariosDialog extends JDialog {

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
    private JTextField txtNombre;
    private JTextField txtApPaterno;
    private JTextField txtApMaterno;
    private JTextField txtCredencial;
    private JTextField txtDireccion;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private final JPanel pnlTexto;
    private final JPanel pnlTexto1;
    private final JPanel pnlTexto3;
    private final JPanel pnlTexto2;
    private ArrayList<Usuario> Usuarios;
    private UsuariosDialogListener listener;
    private int opcion;
    private int indice;
    private String tipo;
    private int modificar;
    private Date alta;

    public UsuariosDialog(Dialog f) {
        super(f, true);
        super.setSize(600, 280);
        super.setBackground(Color.WHITE);
        super.setLayout(new BorderLayout());
        super.setTitle("BS - Ferrocarril");
        super.setLocationRelativeTo(null);

        //Label
        lblUsuarioNuevo = new JLabel("Usuario");
        lblNombre = new JLabel("Nombre: ");
        lblApPaterno = new JLabel("Apellido: ");
        lblApMaterno = new JLabel("Materno: ");
        lblCredencial = new JLabel("Credencial: ");
        lblDireccion = new JLabel("Direccion: ");
        lblTelefono = new JLabel("Telefono: ");
        lblCorreo = new JLabel("Correo: ");

        //Text
        txtNombre = new JTextField(12);
        txtApPaterno = new JTextField(8);
        txtApMaterno = new JTextField(8);
        txtCredencial = new JTextField(5);
        txtDireccion = new JTextField(17);
        txtTelefono = new JTextField(10);
        txtCorreo = new JTextField(17);

        //Paneles 
        pnlTexto = new JPanel();
        pnlTexto.setLayout(new BorderLayout());
        pnlTexto1 = new JPanel();
        pnlTexto1.setPreferredSize(new Dimension(600, 50));
        pnlTexto2 = new JPanel();
        pnlTexto2.setPreferredSize(new Dimension(600, 50));
        pnlTexto3 = new JPanel();
        pnlTexto3.setPreferredSize(new Dimension(600, 50));
        pnlTexto1.setBackground(Color.WHITE);
        pnlTexto2.setBackground(Color.WHITE);
        pnlTexto3.setBackground(Color.WHITE);
        pnlTexto.add(pnlTexto1, BorderLayout.PAGE_START);
        pnlTexto.add(pnlTexto2, BorderLayout.CENTER);
        pnlTexto.add(pnlTexto3, BorderLayout.PAGE_END);

        pnlTexto1.add(lblNombre);
        pnlTexto1.add(txtNombre);
        pnlTexto1.add(new JLabel("                    "));
        pnlTexto1.add(lblApPaterno);
        pnlTexto1.add(txtApPaterno);
        pnlTexto1.add(txtApMaterno);

        pnlTexto2.add(lblDireccion);
        pnlTexto2.add(txtDireccion);
        pnlTexto2.add(new JLabel("           "));
        pnlTexto2.add(lblCredencial);
        pnlTexto2.add(txtCredencial);
        pnlTexto2.add(new JLabel("                      "));

        pnlTexto3.add(lblCorreo);
        pnlTexto3.add(txtCorreo);
        pnlTexto3.add(new JLabel("              "));
        pnlTexto3.add(lblTelefono);
        pnlTexto3.add(txtTelefono);

        //Titulo
        pnlTitulo = new JPanel();
        pnlTitulo.setPreferredSize(new Dimension(600, 50));
        lblUsuarioNuevo.setFont(new Font("Times New Roman", Font.BOLD, 22));
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
        super.add(pnlTexto, BorderLayout.CENTER);

        //acciones
        btnCancelar.addActionListener((ActionEvent e) -> {
            int n = JOptionPane.showConfirmDialog(
                    f,
                    "¿Deseas cancelar cambio?",
                    "¿Seguro?",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        });

        btnGuardar.addActionListener((ActionEvent e) -> {
            //1 para nuevo 2 para modificar

            if (opcion == 1) {
                DAOUsuarioImpl d = new DAOUsuarioImpl();

                java.util.Date fechaq = new java.util.Date();
                d.registrarUsuario(new Usuario(txtNombre.getText(), txtApPaterno.getText(), txtApMaterno.getText(), txtCredencial.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText(), new Date(fechaq.getYear(), fechaq.getMonth(), fechaq.getDay())));

                UsuariosDialog.this.setVisible(false);
                f.setVisible(false);
                Usuarios u = new Usuarios(new Frame());
                u.setVisible(true);
                DataSourcePostgreSQL ds = new DataSourcePostgreSQL();
                Usuarios = ds.crearArreglo("Select * from usuario", "Usuario");
                ModeloUsuario ma = new ModeloUsuario(Usuarios);
                listener.aceptarButtonClick(new Usuario(txtNombre.getText(), txtApPaterno.getText(), txtApMaterno.getText(), txtCredencial.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText(), new Date(fechaq.getYear(), fechaq.getMonth(), fechaq.getDay())));

                this.setVisible(false);
            } else if (opcion == 2) {

                DataSourcePostgreSQL d = new DataSourcePostgreSQL();
                System.out.println(modificar);
                Usuario usuario = new Usuario(txtNombre.getText(), txtApPaterno.getText(), txtApMaterno.getText(), txtCredencial.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText()), alta;

                d.ejecutarActualizacion("UPDATE usuario SET  nombre = '" + usuario.getNombre() + "', ap_paterno = '" + usuario.getApPaterno() + "', ap_materno = '" + usuario.getApMaterno()
                        + "', num_credencial = '" + usuario.getNumCredencial() + "', direccion = '" + usuario.getDireccion() + "', telefono = '" + usuario.getTelefono() + "', correo = '" + usuario.getCorreo()
                        + "' WHERE id_usuario = " + indice);

                this.setVisible(false);
                f.setVisible(false);
                Usuarios u = new Usuarios(new Frame());
                u.setVisible(true);
            }
        });
    }

    public void setListener(UsuariosDialogListener listener) {
        this.listener = listener;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre.setText(txtNombre);
    }

    public void setTxtApPaterno(String txtApPaterno) {
        this.txtApPaterno.setText(txtApPaterno);
    }

    public void setTxtApMaterno(String txtApMaterno) {
        this.txtApMaterno.setText(txtApMaterno);
    }

    public void setTxtCredencial(String txtCredencial) {
        this.txtCredencial.setText(txtCredencial);
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion.setText(txtDireccion);
    }

    public void setTxtCorreo(String txtCorreo) {
        this.txtCorreo.setText(txtCorreo);
    }

    public void setTxtTelefono(String txtTelefono) {
        this.txtTelefono.setText(txtTelefono);
    }

    public void setVariable(int v) {
        opcion = v;
    }

    public void setModificar(int v) {
        indice = v;
    }

    public void agregarPH(int Variable) {
        if (Variable == 1) {
            PlaceHolder holder = new PlaceHolder(txtApMaterno, "     Materno");
            PlaceHolder holder1 = new PlaceHolder(txtApPaterno, "     Paterno");
        }
    }

}
