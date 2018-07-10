package Pantallas;

import BD.ControladorMultimedia;
import BD.DataSourcePostgreSQL;
import BD.ModeloMultimedia;
import Modelo.Multimedia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Multimedias extends JFrame {

    private JTable tblMultimedia;
    private ModeloMultimedia modelo;
    private final ArrayList<Multimedia> Multimedia;

    private ControladorMultimedia controlador;
    private Integer variable;

    private final JButton btnNuevo;
    private final JButton btnModificar;
    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JPanel pnlboton;
    private final JButton btnEliminar;
    private MultimediaDialog udn;
    private String Consulta;
    private Integer indice;
    private final JPanel pnlBotones1;
    private final JPanel pnlBotones2;
    private final String Consulta2;
    private final JLabel lblMultimediaTitulo;

    public Multimedias() {
        super.setSize(800, 600);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();

        Consulta = "Select multimedia.titulo, multimedia.autor, multimedia.anio, pais.nombre, compania.nombre, editorial.nombre, multimedia.formato, multimedia.copias from multimedia "
                + " join  pais on pais_id = pais.id_pais"
                + " join editorial on editorial_id = id_editorial"
                + " join compania on compania_id = id_compania";

        Consulta2 = "Select * from multimedia "
                + " join  pais on pais_id = pais.id_pais"
                + " join editorial on editorial_id = id_editorial"
                + " join compania on compania_id = id_compania order by titulo asc";

        Multimedia = das.crearArreglo(Consulta2, "Multimedia");
        controlador = new ControladorMultimedia(Multimedia);
        modelo = new ModeloMultimedia(controlador.getDb());
        tblMultimedia = new JTable(modelo);

        lblMultimediaTitulo = new JLabel();
        lblMultimediaTitulo.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblMultimediaTitulo.setText("MULTIMEDIA");
        lblMultimediaTitulo.setForeground(Color.red);
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
        pnlBotones1.add(lblMultimediaTitulo);
        pnlBotones2.add(btnNuevo);
        pnlBotones2.add(btnModificar);
        pnlBotones2.add(btnEliminar);
        pnlBotones.add(pnlBotones1, BorderLayout.PAGE_START);
        pnlBotones.add(pnlBotones2, BorderLayout.CENTER);

        pnlboton = new JPanel();
        pnlboton.setBackground(Color.white);
        btnAceptar = new JButton("Cerrar");
        pnlboton.add(btnAceptar);

        JScrollPane scrool = new JScrollPane(tblMultimedia);
        scrool.getViewport().setBackground(Color.white);

        super.add(new JScrollPane(scrool));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {
            int rowSelected = tblMultimedia.getSelectedRow();

            if (rowSelected >= 0) {
                System.out.println(controlador.buscar(rowSelected).getId_multimedia());
                controlador.eliminar(controlador.buscar(rowSelected).getId_multimedia(), rowSelected);
                controlador.guardar();
                modelo.fireTableDataChanged();
            }
        });

        btnAceptar.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            new Seleccion();
        });

        udn = new MultimediaDialog(this);

        super.setVisible(true);

        btnNuevo.addActionListener((ActionEvent e) -> {
            variable = 1;

            DataSourcePostgreSQL das1 = new DataSourcePostgreSQL();
            DataSourcePostgreSQL das2 = new DataSourcePostgreSQL();
            DataSourcePostgreSQL das3 = new DataSourcePostgreSQL();

            udn.llenarArrayPaises(das3.crearArreglo("Select nombre from pais", "Pais"), 0);
            udn.llenarArrayCompañia(das1.crearArreglo("Select nombre from compania", "Compañia"), 0);
            udn.llenarArrayEditorial(das2.crearArreglo("Select nombre from editorial", "Editorial"), 0);
            udn.setTxtTitulo("");
            udn.setTxtAnio("");
            udn.setTxtFormato("");
            udn.setTxtAutor("");
            udn.setVariable(variable);
            udn.setVisible(true);
        });

        btnModificar.addActionListener((ActionEvent e) -> {
            variable = 2;

            int rowSelected = tblMultimedia.getSelectedRow();

            if (rowSelected < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione el titulo a modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                udn.setVariable(variable);

                DataSourcePostgreSQL das1 = new DataSourcePostgreSQL();
                DataSourcePostgreSQL das2 = new DataSourcePostgreSQL();
                DataSourcePostgreSQL das3 = new DataSourcePostgreSQL();

                System.out.println(controlador.buscar(rowSelected).getPais().getIdPais() - 1);
                System.out.println(controlador.buscar(rowSelected).getEditorial().getIdEditorial() - 1);
                System.out.println(controlador.buscar(rowSelected).getCompañia().getId_compañia() - 1);

                udn.llenarArrayPaises(das3.crearArreglo("Select nombre from pais", "Pais"), (controlador.buscar(rowSelected).getPais().getIdPais() - 1));
                udn.llenarArrayCompañia(das1.crearArreglo("Select nombre from compania", "Compañia"), (controlador.buscar(rowSelected).getCompañia().getId_compañia() - 1));
                udn.llenarArrayEditorial(das2.crearArreglo("Select nombre from editorial", "Editorial"), (controlador.buscar(rowSelected).getEditorial().getIdEditorial() - 1));
                udn.setModificar(controlador.buscar(rowSelected).getId_multimedia());
                udn.setTxtTitulo(controlador.buscar(rowSelected).getTitulo());
                udn.setTxtAnio(controlador.buscar(rowSelected).getAnio());
                udn.setTxtFormato(controlador.buscar(rowSelected).getFormato());
                udn.setTxtAutor(controlador.buscar(rowSelected).getAutor());
                udn.setVisible(true);
            }
        });
    }

}
