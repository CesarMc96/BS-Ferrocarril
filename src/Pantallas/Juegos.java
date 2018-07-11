package Pantallas;

import BD.ControladorJuegos;
import BD.DataSourcePostgreSQL;
import BD.JuegosDialogListener;
import BD.ModeloJuegos;
import Modelo.Juego;
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

public class Juegos extends JFrame {

    private JTable tblJuegos;
    private ModeloJuegos modelo;
    private final ArrayList<Juego> Juego;

    private ControladorJuegos controlador;
    private Integer variable;

    private final JButton btnNuevo;
    private final JButton btnModificar;
    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JPanel pnlboton;
    private final JButton btnEliminar;
    private JuegosDialog udn;
    private String Consulta;
    private Integer indice;
    private final JLabel lblJuegosTitulo;
    private final JPanel pnlBotones1;
    private final JPanel pnlBotones2;

    public Juegos() {
        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        
        setIconImage( new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg")).getImage());

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Juego = das.crearArreglo("Select * from juegos order by nombre asc", "Juego");

        controlador = new ControladorJuegos(Juego);
        modelo = new ModeloJuegos(controlador.getDb());
        tblJuegos = new JTable(modelo);

        lblJuegosTitulo = new JLabel();
        lblJuegosTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblJuegosTitulo.setText("JUEGOS");
        lblJuegosTitulo.setForeground(Color.red);

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
        pnlBotones1.add(lblJuegosTitulo);
        pnlBotones2.add(btnNuevo);
        pnlBotones2.add(btnModificar);
        pnlBotones2.add(btnEliminar);
        pnlBotones.add(pnlBotones1, BorderLayout.PAGE_START);
        pnlBotones.add(pnlBotones2, BorderLayout.CENTER);

        pnlboton = new JPanel();
        pnlboton.setBackground(Color.white);
        btnAceptar = new JButton("Cerrar");
        pnlboton.add(btnAceptar);

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

        super.setVisible(true);

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
