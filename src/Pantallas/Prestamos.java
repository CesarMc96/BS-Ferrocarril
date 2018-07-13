
package Pantallas;

import BD.ControladorPrestamo;
import BD.DataSourcePostgreSQL;
import BD.ModeloPrestamos;
import DAO.Controlador;
import Modelo.Prestamo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Prestamos extends JFrame {
    
    private JTable tblUsuario;
    private ModeloPrestamos modelo;
    private ArrayList<Prestamo> prestamos;

    private ControladorPrestamo controlador;
    private Integer variable;

    private JButton btnNuevo;
    private JButton btnModificar;
    private JPanel pnlBotones;
    private JButton btnAceptar;
    private JPanel pnlboton;
    private JButton btnEliminar;
    private UsuariosDialog udn;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private String Consulta;
    private JLabel lblUsuarioTitulo;
    private JPanel pnlBotones1;
    private JPanel pnlBotones2;
    
    private Controlador controller;
    private DefaultTableModel model;
    private JTable tabla;
    private JScrollPane scroll;
    
    Object[][] matriz;
    String[] cabeceras;

    public Prestamos() {
        
        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        
        cabeceras = new String[] {"Fecha Prestamo", "Fecha Devolucion", "No. Renovacion", "Titulo", "Autor", "Editorial", 
            "Usuario", "No. Credencial", "Observaciones", "Accion" };
        
        controller = new Controlador();
        
        matriz = controller.toMatrizPrestamos();
        
        model = new DefaultTableModel(matriz, cabeceras);
        
        tabla = new JTable(model);
        
        scroll = new JScrollPane(tabla);

        controlador = new ControladorPrestamo(prestamos);
        modelo = new ModeloPrestamos(controlador.getDb());
        tblUsuario = new JTable(modelo);

        lblUsuarioTitulo = new JLabel();
        lblUsuarioTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblUsuarioTitulo.setText("PRESTAMOS");
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

        JScrollPane scrool = new JScrollPane(scroll);
        scrool.getViewport().setBackground(Color.white);

        super.add(new JScrollPane(scrool));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {
            int rowSelected = tabla.getSelectedRow();
            Prestamo prestamo;
            String numUsuario;
            
            if (rowSelected >= 0) {
                
                numUsuario = (String) tabla.getValueAt(rowSelected, 7);
                prestamo = controller.buscarPrestamoUsuario(numUsuario);
                
                if ( controller.eliminarPrestamoNumUsuario(numUsuario) == 1 ) {
                    JOptionPane.showMessageDialog(null, "¡El Prestamo se ha Borrado!. \n ", 
                           "Prestamo Eliminado Exitosamente.", JOptionPane.INFORMATION_MESSAGE);
                    
                    Prestamos.this.setVisible(false);
                    new Prestamos();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "¡El Prestamo No Ha Sido Borrado. \n ", 
                           "Prestamo No Eliminado.", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        btnAceptar.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            new Seleccion();
        });
        
        txtBuscar.setText("Num. Credencial");
        txtBuscar.setForeground(Color.LIGHT_GRAY);
        txtBuscar.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
                txtBuscar.setText(null);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        udn = new UsuariosDialog(this);

        super.setVisible(true);

        btnNuevo.addActionListener((ActionEvent e) -> {
            variable = 1;
            new PrestamoDialog(Prestamos.this, "Nuevo Prestamo");
     
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el Prestamo a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);
                System.out.println(controlador.buscar(rowSelected).getIdPrestamo()+ " Hola");
                udn.setModificar(controlador.buscar(rowSelected).getIdPrestamo());

                udn.setVisible(true);
            }
        });

        btnBuscar.addActionListener((ActionEvent e) -> {
            prestamos = controller.buscarPrestamoNumUsuario( txtBuscar.getText() );
            System.out.println(prestamos);
            this.setVisible(false);
            Prestamos pre = new Prestamos(prestamos);
            pre.setVisible(true);
        });
    }

    public Prestamos( ArrayList<Prestamo> prestamos ) {

        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        cabeceras = new String[] {"Fecha Prestamo", "Fecha Devolucion", "No. Renovacion", "Titulo", "Autor", "Editorial", 
            "Usuario", "No. Credencial", "Observaciones", "Accion" };
        
        controller = new Controlador();
        
        matriz = controller.toMatrizPrestamos( prestamos );
        
        model = new DefaultTableModel(matriz, cabeceras);
        
        tabla = new JTable(model);
        
        scroll = new JScrollPane(tabla);

        lblUsuarioTitulo = new JLabel();
        lblUsuarioTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblUsuarioTitulo.setText("PRESTAMOS");
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

        //super.setVisible(true);
        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {
            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected >= 0) {
                System.out.println(controlador.buscar(rowSelected).getIdPrestamo());
                controlador.eliminar(controlador.buscar(rowSelected).getIdPrestamo(), rowSelected);
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
