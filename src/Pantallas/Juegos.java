package Pantallas;

import BD.ControladorJuegos;
import BD.DataSourcePostgreSQL;
import BD.JuegosDialogListener;
import BD.ModeloJuegos;
import Modelo.Juego;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Juegos extends JFrame {

    private JTable tblJuegos;
    private ModeloJuegos modelo;
    private ArrayList<Juego> Juego;

    private ControladorJuegos controlador;
    private Integer variable;

    private final JButton btnNuevo;
    private final JButton btnModificar;
    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JPanel pnlboton;
    private final JButton btnEliminar;
    private JuegosDialog udn;
//    private final JTextField txtBuscar;
//    private final JButton btnBuscar;
    private String Consulta;
    private Integer indice;

    public Juegos() {
        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("Juegos");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Juego = das.crearArreglo("Select * from juegos order by nombre asc", "Juego");

        controlador = new ControladorJuegos(Juego);
        modelo = new ModeloJuegos(controlador.getDb());
        tblJuegos = new JTable(modelo);

        //Boton
        pnlBotones = new JPanel();
        pnlBotones.setBackground(Color.white);
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);
//        txtBuscar = new JTextField(10);
//        btnBuscar = new JButton("Buscar");

        pnlboton = new JPanel();
        pnlboton.setBackground(Color.white);
        btnAceptar = new JButton("Cerrar");
        pnlboton.add(btnAceptar);
//        pnlboton.add(txtBuscar);
//        pnlboton.add(btnBuscar);

//        tblJuegos.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane scrool = new JScrollPane(tblJuegos);
        scrool.getViewport().setBackground(Color.white);

        super.add(new JScrollPane(scrool));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {
            int rowSelected = tblJuegos.getSelectedRow();

            if (rowSelected >= 0) {
                System.out.println(controlador.buscar(rowSelected).getIdJuego());
                controlador.eliminar(controlador.buscar(rowSelected).getIdJuego(), rowSelected);
                controlador.guardar();
                modelo.fireTableDataChanged();
            }
        });

        btnAceptar.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            new Seleccion();
        });

        udn = new JuegosDialog(this);
        udn.setListener(new JuegosDialogListener() {
            @Override
            public void aceptarButtonClick(Juego juego) {
                controlador.agregar(juego);
                modelo.fireTableDataChanged();
            }

            @Override
            public void aceptarButtonClick(Juego juego, Integer in) {
                controlador.getDb();
                controlador.modificar(in, juego);
                modelo.fireTableDataChanged();
            }

        });

        System.out.println(indice + " indice");
        super.setVisible(true);

//        btnBuscar.addActionListener((ActionEvent e) -> {
//            Consulta = "Select * from juegos where nombre ilike '%" + txtBuscar.getText() + "%'";
//
//            this.setVisible(false);
//            Usuarios us = new Usuarios(Consulta);
//            us.setVisible(true);
//        });
        btnNuevo.addActionListener((ActionEvent e) -> {
            variable = 1;
            udn.setTxtNombre("");
            udn.setTxtCantidad(0);
            udn.setTxtPiezas("");
            udn.setTxtAccesorios("");
            udn.setTxtDescripcion("");
            udn.setVariable(variable);
            udn.setVisible(true);
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tblJuegos.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el juego a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);
                System.out.println(controlador.buscar(rowSelected).getIdJuego() + " Hola");
                udn.setModificar(controlador.buscar(rowSelected).getIdJuego());
                udn.setTxtNombre(controlador.buscar(rowSelected).getNombre());
                udn.setTxtCantidad(controlador.buscar(rowSelected).getCantidad() - 1);
                udn.setTxtPiezas(controlador.buscar(rowSelected).getPiezas());
                udn.setTxtAccesorios(controlador.buscar(rowSelected).getAccesorios());
                udn.setTxtDescripcion(controlador.buscar(rowSelected).getDescripcion());
                udn.setVisible(true);
            }
        });
    }

}
