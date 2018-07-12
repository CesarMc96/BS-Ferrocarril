package Pantallas;

import BD.ControladorUsuario;
import BD.DataSourcePostgreSQL;
import BD.ModeloUsuario;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
    private final JTextField txtBuscar;
    private final JButton btnBuscar;
    private String Consulta;
    private JLabel lblUsuarioTitulo;
    private JPanel pnlBotones1;
    private JPanel pnlBotones2;

    public Usuarios() {
        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg")).getImage());

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Usuario = das.crearArreglo("Select * from usuario", "Usuario");

        controlador = new ControladorUsuario(Usuario);
        modelo = new ModeloUsuario(controlador.getDb());
        tblUsuario = new JTable(modelo);

        lblUsuarioTitulo = new JLabel();
        lblUsuarioTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblUsuarioTitulo.setText("USUARIOS");
        lblUsuarioTitulo.setForeground(Color.red);

        //Boton
        pnlBotones = new JPanel();
        pnlBotones.setLayout(new BorderLayout());
        pnlBotones1 = new JPanel();
        pnlBotones2 = new JPanel();
        pnlBotones.setBackground(Color.white);
        pnlBotones1.setBackground(Color.white);
        pnlBotones2.setBackground(Color.white);
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        pnlBotones1.add(lblUsuarioTitulo);
        pnlBotones2.add(btnNuevo);
        pnlBotones2.add(btnModificar);
        pnlBotones2.add(btnEliminar);
        pnlBotones.add(pnlBotones1, BorderLayout.PAGE_START);
        pnlBotones.add(pnlBotones2, BorderLayout.CENTER);
        txtBuscar = new JTextField(10);
        btnBuscar = new JButton("Buscar");

        pnlboton = new JPanel();
        pnlboton.setBackground(Color.white);
        btnAceptar = new JButton("Cerrar");
        pnlboton.add(btnAceptar);
        pnlboton.add(txtBuscar);
        pnlboton.add(btnBuscar);

        JScrollPane scrool = new JScrollPane(tblUsuario);
        scrool.getViewport().setBackground(Color.white);

        super.add(new JScrollPane(scrool));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

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

        btnAceptar.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            new Seleccion();
        });

        udn = new UsuariosDialog(this);

        super.setVisible(true);

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

        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Usuario = das.crearArreglo(Consulta, "Usuario");

        controlador = new ControladorUsuario(Usuario);
        modelo = new ModeloUsuario(controlador.getDb());
        tblUsuario = new JTable(modelo);

        lblUsuarioTitulo = new JLabel();
        lblUsuarioTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblUsuarioTitulo.setText("USUARIOS");
        lblUsuarioTitulo.setForeground(Color.red);

        //Boton
        pnlBotones = new JPanel();
        pnlBotones.setLayout(new BorderLayout());
        pnlBotones1 = new JPanel();
        pnlBotones2 = new JPanel();
        pnlBotones.setBackground(Color.white);
        pnlBotones1.setBackground(Color.white);
        pnlBotones2.setBackground(Color.white);
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        pnlBotones1.add(lblUsuarioTitulo);
        pnlBotones2.add(btnNuevo);
        pnlBotones2.add(btnModificar);
        pnlBotones2.add(btnEliminar);
        pnlBotones.add(pnlBotones1, BorderLayout.PAGE_START);
        pnlBotones.add(pnlBotones2, BorderLayout.CENTER);
        txtBuscar = new JTextField(10);
        btnBuscar = new JButton("Buscar");

        pnlboton = new JPanel();
        pnlboton.setBackground(Color.white);
        btnAceptar = new JButton("Cerrar");
        pnlboton.add(btnAceptar);
        pnlboton.add(txtBuscar);
        pnlboton.add(btnBuscar);

        JScrollPane scrool = new JScrollPane(tblUsuario);
        scrool.getViewport().setBackground(Color.white);

        super.add(new JScrollPane(scrool));
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

        btnAceptar.addActionListener((ActionEvent e) -> {
            this.dispose();
            new Seleccion();
        });

        udn = new UsuariosDialog(this);

        super.setVisible(true);

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

        btnBuscar.addActionListener((ActionEvent e) -> {
            Consulta = "Select * from usuario where nombre ilike '%" + txtBuscar.getText() + "%' or ap_paterno ilike '%" + txtBuscar.getText()
                    + "%' or ap_materno ilike '%" + txtBuscar.getText() + "%' or num_credencial ilike '%" + txtBuscar.getText() + "%' or correo ilike '%" + txtBuscar.getText() + "%'";

            this.setVisible(false);
            Usuarios us = new Usuarios(Consulta);
            us.setVisible(true);
        });
    }

}
