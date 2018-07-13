package Pantallas;

import BD.ControladorLibro;
import BD.DataSourcePostgreSQL;
import BD.ModeloLibros;
import DAO.Controlador;
import Modelo.Libro;
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
import javax.swing.table.DefaultTableModel;

public class Libros extends JFrame {
    
    private JTable tblLibros;
    private ModeloLibros modelo;
    private ArrayList<Libro> libros;

    private ControladorLibro controlador;
    private Controlador controller;
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
    
    private JTable tabla;
    private DefaultTableModel model;
    private JScrollPane scroll;
    
    Object[][] matriz;
    String[] cabeceras;

    public Libros() {
        super.setSize(800, 800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        
        setIconImage( new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg")).getImage());

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        libros = das.crearArreglo("Select * From libro", "Libro");
        
        cabeceras = new String[] {"Folio", "Titulo", "Autor", "ISBN", "Editorial", "Año", "Pais", "Estante", "Sala", "Descripcion", "Status"};

        controller = new Controlador();
        
        matriz = controller.toMatrizLibros();
        
        model = new DefaultTableModel(matriz, cabeceras);
        
        tabla = new JTable(model);
        
        scroll = new JScrollPane(tabla);
        
        controlador = new ControladorLibro(libros);
        modelo = new ModeloLibros(controlador.getDb());
        tblLibros = new JTable(modelo);

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

        JScrollPane scrool = new JScrollPane(tabla);
        scrool.getViewport().setBackground(Color.white);

        super.add(new JScrollPane(scrool));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {
            int rowSelected = tabla.getSelectedRow(), id = 0;
            Libro libro;
            String folio;

            if (rowSelected >= 0) {
               // System.out.println(controlador.buscar(rowSelected).getIdLibro());
               // controlador.eliminar(controlador.buscar(rowSelected).getIdLibro(), rowSelected);
                //controlador.guardar();
               // modelo.fireTableDataChanged();
               folio = (String) tabla.getValueAt(rowSelected, 0);
                System.out.println("Folio : " + folio);
                
               libro = controller.buscarLibro(folio);
               id = libro.getIdLibro();
               
               if ( controller.eliminarLibro(folio ) == 1 ) {
                   
                   JOptionPane.showMessageDialog(null, "¡El Libro Ha Sido Borrado Exitosamente!. \n ", 
                           "Libro Eliminado.", JOptionPane.INFORMATION_MESSAGE);
                   
                   Libros.this.setVisible(false);
                   new Libros();
                   
               } else {
                   JOptionPane.showMessageDialog(null, "¡El Libro No Ha Sido Borrado. \n ", 
                           "Libro No Eliminado.", JOptionPane.ERROR_MESSAGE);
               }
                
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
            new LibroDialog(Libros.this, "Agregar Libro");
            System.out.println("Funciona?");
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tabla.getSelectedRow();
            String folio;
            Libro libro;

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el libro a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                //udn.setVariable(variable);
                //System.out.println(controlador.buscar(rowSelected).getIdLibro() + " Hola");
                //udn.setModificar(controlador.buscar(rowSelected).getIdLibro());

               // udn.setVisible(true);
                folio = (String) tabla.getValueAt(rowSelected, 0);
                System.out.println("Folio : " + folio);
                
               libro = controller.buscarLibro(folio);
               
               new LibroDialog(Libros.this, "Modificar Libro", libro);
               
            }
        });

        btnBuscar.addActionListener((ActionEvent e) -> {
            libros = controller.buscarLibros(txtBuscar.getText());
            System.out.println("Encontrados : " + libros);
            
            this.setVisible(false);
            Libros books = new Libros(libros);
            books.setVisible(true);
        });
    }

    public Libros(ArrayList<Libro> libros) {

        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        cabeceras = new String[] {"Folio", "Titulo", "Autor", "ISBN", "Editorial", "Año", "Pais", "Estante", "Sala", "Descripcion", "Status"};

        controller = new Controlador();
        
        matriz = controller.toMatrizLibros(libros);
        
        model = new DefaultTableModel(matriz, cabeceras);
        
        tabla = new JTable(model);
        
        scroll = new JScrollPane(tabla);;
        
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
        btnNuevo.setEnabled(false);
        btnModificar = new JButton("Modificar");
        btnModificar.setEnabled(false);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        pnlBotones1.add(lblUsuarioTitulo);
        pnlBotones2.add(btnNuevo);
        pnlBotones2.add(btnModificar);
        pnlBotones2.add(btnEliminar);
        pnlBotones.add(pnlBotones1, BorderLayout.PAGE_START);
        pnlBotones.add(pnlBotones2, BorderLayout.CENTER);
        txtBuscar = new JTextField(10);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setEnabled(false);

        pnlboton = new JPanel();
        pnlboton.setBackground(Color.white);
        btnAceptar = new JButton("Cerrar");
        pnlboton.add(btnAceptar);
        pnlboton.add(txtBuscar);
        pnlboton.add(btnBuscar);

        JScrollPane scrool = new JScrollPane(tabla);
        scrool.getViewport().setBackground(Color.white);

        super.add(new JScrollPane(scrool));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        //super.setVisible(true);
        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {
            int rowSelected = tblLibros.getSelectedRow();

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

            int rowSelected = tblLibros.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el libro a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);
     
                udn.setVisible(true);
            }
        });

        btnBuscar.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            Usuarios us = new Usuarios(Consulta);
            us.setVisible(true);
        });
    }

}

