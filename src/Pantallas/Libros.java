package Pantallas;

import BD.ControladorLibro;
import BD.ControladorUsuario;
import BD.DataSourcePostgreSQL;
import BD.ModeloLibros;
import BD.ModeloUsuario;
import Modelo.Libro;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Libros extends JFrame {
    
    private JTable tblUsuario;
    private ModeloLibros modelo;
    private ArrayList<Libro> libros;

    private ControladorLibro controlador;
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

    public Libros() {
        super.setSize(800, 800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        
        setIconImage( new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg")).getImage());

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        libros = das.crearArreglo("Select * from libro", "Libro");

        controlador = new ControladorLibro(libros);
        modelo = new ModeloLibros(controlador.getDb());
        tblUsuario = new JTable(modelo);

        lblUsuarioTitulo = new JLabel();
        lblUsuarioTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblUsuarioTitulo.setText("LIBROS");
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
                System.out.println(controlador.buscar(rowSelected).getIdLibro());
                controlador.eliminar(controlador.buscar(rowSelected).getIdLibro(), rowSelected);
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
            new LibrosDialog(Libros.this, "Agregar Libro");
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el libro a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);
                System.out.println(controlador.buscar(rowSelected).getIdLibro() + " Hola");
                udn.setModificar(controlador.buscar(rowSelected).getIdLibro());

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

    public Libros(String consulta) {
        Consulta = consulta;

        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        libros = das.crearArreglo(Consulta, "Libro");

        controlador = new ControladorLibro(libros);
        modelo = new ModeloLibros(controlador.getDb());
        tblUsuario = new JTable(modelo);

        lblUsuarioTitulo = new JLabel();
        lblUsuarioTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblUsuarioTitulo.setText("LIBROS");
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
                System.out.println(controlador.buscar(rowSelected).getIdLibro());
                controlador.eliminar(controlador.buscar(rowSelected).getIdLibro(), rowSelected);
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
                JOptionPane.showMessageDialog(null, "Seleccione el libro a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);
     
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

