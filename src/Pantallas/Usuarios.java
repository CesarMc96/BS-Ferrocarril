package Pantallas;

import BD.ControladorUsuario;
import BD.DataSourcePostgreSQL;
import BD.ModeloUsuario;
import BD.UsuariosDialogListener;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Usuarios extends JDialog {

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
    private final JTextField txtBuscar;
    private final JButton btnBuscar;
    private String Consulta;

    public Usuarios(Frame f) {
        super(f, true);
        super.setSize(800, 800);
        super.setDefaultCloseOperation(0);
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
        txtBuscar = new JTextField(10);
        btnBuscar = new JButton("Buscar");

        pnlboton = new JPanel();
        btnAceptar = new JButton("Aceptar");
        pnlboton.add(btnAceptar);
        pnlboton.add(txtBuscar);
        pnlboton.add(btnBuscar);

        super.add(new JScrollPane(tblUsuario));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        //super.setVisible(true);
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

        udn = new UsuariosDialog(this);
        udn.setListener(new UsuariosDialogListener() {
            @Override
            public void aceptarButtonClick(Usuario usuario) {
                controlador.agregar(usuario);
                modelo.fireTableDataChanged();
            }

            @Override
            public void aceptarButtonClick(Usuario usuario, Integer in) {
                controlador.getDb();
                controlador.modificar(in, usuario);
                modelo.fireTableDataChanged();
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
            udn.setVisible(true);
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el usuario a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);
                System.out.println(controlador.buscar(rowSelected).getIdUsuario() + " Hola");
                udn.setModificar(controlador.buscar(rowSelected).getIdUsuario());
                udn.setTxtNombre(controlador.buscar(rowSelected).getNombre());
                udn.setTxtTelefono(controlador.buscar(rowSelected).getTelefono());
                udn.setTxtApMaterno(controlador.buscar(rowSelected).getApMaterno());
                udn.setTxtApPaterno(controlador.buscar(rowSelected).getApPaterno());
                udn.setTxtDireccion(controlador.buscar(rowSelected).getDireccion());
                udn.setTxtCredencial(controlador.buscar(rowSelected).getNumCredencial());
                udn.setTxtCorreo(controlador.buscar(rowSelected).getCorreo());
                udn.setVisible(true);
            }
        });

        btnAceptar.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            System.exit(0);
        });

        btnBuscar.addActionListener((ActionEvent e) -> {
            Consulta = "Select * from usuario where nombre ilike '%" + txtBuscar.getText() + "%' or ap_paterno ilike '%" + txtBuscar.getText()
                    + "%' or ap_materno ilike '%" + txtBuscar.getText() + "%' or num_credencial ilike '%" + txtBuscar.getText() + "%' or correo ilike '%" + txtBuscar.getText() + "%'";

            this.setVisible(false);
            Usuarios us = new Usuarios(Consulta);
            us.setVisible(true);
        });
    }

    public Usuarios(String consulta) {
        Consulta = consulta;
        super.setSize(800, 800);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("Usuarios");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Usuario = das.crearArreglo(Consulta, "Usuario");

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
        txtBuscar = new JTextField(10);
        btnBuscar = new JButton("Buscar");

        pnlboton = new JPanel();
        btnAceptar = new JButton("Aceptar");
        pnlboton.add(btnAceptar);
        pnlboton.add(txtBuscar);
        pnlboton.add(btnBuscar);

        super.add(new JScrollPane(tblUsuario));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        //super.setVisible(true);
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

        udn = new UsuariosDialog(this);
        udn.setListener(new UsuariosDialogListener() {
            @Override
            public void aceptarButtonClick(Usuario usuario) {
                controlador.agregar(usuario);
                modelo.fireTableDataChanged();
            }

            @Override
            public void aceptarButtonClick(Usuario usuario, Integer in) {
                controlador.getDb();
                controlador.modificar(in, usuario);
                modelo.fireTableDataChanged();
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
            udn.setVisible(true);
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el usuario a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);
                System.out.println(controlador.buscar(rowSelected).getIdUsuario() + " Hola");
                System.out.println(controlador.buscar(rowSelected).getFechaAlta() + " Fecha");
                udn.setModificar(controlador.buscar(rowSelected).getIdUsuario());
                udn.setTxtNombre(controlador.buscar(rowSelected).getNombre());
                udn.setTxtTelefono(controlador.buscar(rowSelected).getTelefono());
                udn.setTxtApMaterno(controlador.buscar(rowSelected).getApMaterno());
                udn.setTxtApPaterno(controlador.buscar(rowSelected).getApPaterno());
                udn.setTxtDireccion(controlador.buscar(rowSelected).getDireccion());
                udn.setTxtCredencial(controlador.buscar(rowSelected).getNumCredencial());
                udn.setTxtCorreo(controlador.buscar(rowSelected).getCorreo());
                System.out.println(controlador.buscar(rowSelected).getFechaAlta());
                udn.setVisible(true);
            }
        });

        btnAceptar.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            System.exit(0);
        });

        btnBuscar.addActionListener((ActionEvent e) -> {
            Consulta = "Select * from usuario where nombre ilike '%" + txtBuscar.getText() + "%' or ap_paterno ilike '%" + txtBuscar.getText()
                    + "%' or ap_materno ilike '%" + txtBuscar.getText() + "%' or num_credencial ilike '%" + txtBuscar.getText() + "%' or correo ilike '%" + txtBuscar.getText() + "%'";

            this.setVisible(false);
            Usuarios us = new Usuarios(Consulta);
            us.setVisible(true);
        });
    }

}
