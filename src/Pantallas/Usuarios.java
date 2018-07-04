package Pantallas;

import BD.ControladorUsuario;
import BD.DataSourcePostgreSQL;
import BD.ModeloUsuario;
import BD.UsuariosDialogListener;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Usuarios extends JFrame {

    private JTable tblUsuario;
    private ModeloUsuario modelo;
    private ArrayList<Usuario> Usuario;

    private ControladorUsuario controlador;
    private Integer variable;

    private final JButton btnNuevo;
    private final JButton btnModificar;
    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JPanel pnlboton;
    private final JButton btnEliminar;
    private UsuariosDialog udn;

    public Usuarios() {
        super.setSize(800, 800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setTitle("Usuarios");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Usuario = das.crearArreglo("Select * from usuario", "Usuario");

        controlador = new ControladorUsuario(Usuario);
        modelo = new ModeloUsuario(controlador.getDb());
        tblUsuario = new JTable(modelo);

        //Boton
        pnlBotones = new JPanel();
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);

        pnlboton = new JPanel();
        btnAceptar = new JButton("Aceptar");
        pnlboton.add(btnAceptar);

        super.add(new JScrollPane(tblUsuario));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        super.setVisible(true);

        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {
            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected >= 0) {
                System.out.println(controlador.buscar(rowSelected).getIdUsuario());
                controlador.eliminar(controlador.buscar(rowSelected).getIdUsuario(), rowSelected);
                controlador.guardar();
                modelo.fireTableDataChanged();
            }
        });

        udn = new UsuariosDialog(new Dialog(this));
        udn.setListener(new UsuariosDialogListener() {
            @Override
            public void aceptarButtonClick(Usuario usuario) {
                controlador.agregar(usuario);
                modelo.fireTableDataChanged();
            }

            @Override
            public void aceptarButtonClick(Usuario usuario, Integer in) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        btnNuevo.addActionListener((ActionEvent e) -> {
            variable = 1;
            udn.setTxtNombre("");
            udn.setTxtTelefono("");
            udn.setTxtApMaterno("");
            udn.setTxtApPaterno("");
            udn.setTxtDireccion("");
            udn.setTxtCredencial("");
            udn.setTxtCorreo("");
            udn.agregarPH(variable);
            udn.setVariable(variable);
            udn.repaint();
            udn.setVisible(true);
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el usuario a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.agregarPH(variable);
                udn.setVariable(variable);
                udn.setTxtNombre(controlador.buscar(rowSelected).getNombre());
                udn.setTxtTelefono(controlador.buscar(rowSelected).getTelefono());
                udn.setTxtApMaterno(controlador.buscar(rowSelected).getApMaterno());
                udn.setTxtApPaterno(controlador.buscar(rowSelected).getApPaterno());
                udn.setTxtDireccion(controlador.buscar(rowSelected).getDireccion());
                udn.setTxtCredencial(controlador.buscar(rowSelected).getNumCredencial());
                udn.setTxtCorreo(controlador.buscar(rowSelected).getCorreo());
                udn.setModificar(rowSelected);
                udn.setVisible(true);
            }
        });
    }
}
