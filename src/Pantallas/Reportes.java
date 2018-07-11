
package Pantallas;

import DAO.Controlador;
import Modelo.Autor;
import Modelo.Libro;
import Modelo.Reporte;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Reportes extends JFrame {

    private JLabel lblTitulo;
    private JPanel pnlNorte;
    private JPanel pnlTitulo;
    private JTextArea area;
    private JPanel pnlInfo;
    private JLabel lblNumLibrosPrestados;
    private JLabel lblAutorMasSolicitado;
    private JLabel lblLibroMasPrestado;
    private JLabel lblLibrosDisponibles;
    private JLabel lblLibrosNoDisponibles;
    private JLabel lblNumLibrosAgregados;
    private JLabel lblLibros;
    private JPanel pnlInformacion;
    private JPanel pnlTotal;
    private JScrollPane scroll;
    private JPanel pnlScroll;
    private JLabel lblMes;
    private JComboBox combo;
    private JButton btnGenerar;
    private JPanel pnlBusqueda;
    private JPanel pnlDatos;
    private Controlador controlador;
    private JMenuBar menuBar;

    String[] meses;
    String mes;
    Integer numLibrosPrestados, numLibrosAgregados = null;
    Integer[] numLibrosDisponibles;
    ArrayList<Libro> libros;
    Autor autor;
    Libro libro;

    public Reportes() {
        
        super.setTitle(" Pantalla Reportes ");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(450, 400);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);

        lblTitulo = new JLabel(" PANTALLA REPORTES ");
        lblTitulo.setFont(new Font("", Font.BOLD, 22));

        pnlTitulo = new JPanel();
        pnlTitulo.add(lblTitulo);

        meses = new String[]{"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
            "Octubre", "Noviembre", "Diciembre"};

        controlador = new Controlador();

        lblMes = new JLabel(" Mes : ");

        pnlNorte = new JPanel();
        pnlNorte.setLayout(new BorderLayout());
        pnlNorte.add(createMenuBar(), BorderLayout.NORTH);
        pnlNorte.add(pnlTitulo, BorderLayout.CENTER);

        combo = new JComboBox<>(meses);
        combo.addActionListener((ActionEvent e) -> {
            mes = combo.getSelectedItem().toString();
        });

        lblNumLibrosPrestados = new JLabel();

        lblAutorMasSolicitado = new JLabel();

        lblLibroMasPrestado = new JLabel();

        lblLibrosDisponibles = new JLabel();

        lblLibrosNoDisponibles = new JLabel();

        lblNumLibrosAgregados = new JLabel();

        lblLibros = new JLabel();

        area = new JTextArea();

        pnlScroll = new JPanel();

        btnGenerar = new JButton(" Generar Reporte");
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                numLibrosPrestados = controlador.numLibrosPrestados(mes);
                autor = controlador.autorMasSolicitado(mes);
                libro = controlador.libroMasPrestado(mes);
                numLibrosDisponibles = controlador.numLibrosDisponibles();
                libros = controlador.librosRegistrados(mes);

                controlador.getDaoReporte().getDs().iniciarConexion();

                lblNumLibrosPrestados.setText(" El Numero de Libros Prestados en el Mes de " + mes + " es : " + numLibrosPrestados);

                lblAutorMasSolicitado.setText(" El Autor Mas Solicitado en el Mes de : " + mes + " es : " + autor);

                lblLibroMasPrestado.setText(" El Libro Mas Prestado en el Mes de : " + mes + " es : " + libro);

                lblLibrosDisponibles.setText(" El Numero de Libros Disponibles es : " + numLibrosDisponibles[0]);

                lblLibrosNoDisponibles.setText(" El Numero de Libros No Disponibles es : " + numLibrosDisponibles[1]);

                lblNumLibrosAgregados.setText(" El Numero de Libros Agregados en el Mes de : " + mes + " es : " + libros.size());

                lblLibros.setText(" Lista de Libros Agregados en el Mes de : " + mes + ". \n ");

                area.setText(libros.toString());
                area.setEditable(false);

                scroll = new JScrollPane(area);
                pnlScroll.add(scroll);

                revalidate();
                repaint();

                controlador.getDaoReporte().getDs().cerrarConexion();

            }
        });

        pnlBusqueda = new JPanel();
        pnlBusqueda.add(lblMes);
        pnlBusqueda.add(combo);
        pnlBusqueda.add(btnGenerar);

        pnlInfo = new JPanel();
        pnlInfo.setLayout(new BoxLayout(pnlInfo, BoxLayout.PAGE_AXIS));
        pnlInfo.add(lblNumLibrosPrestados);
        pnlInfo.add(lblAutorMasSolicitado);
        pnlInfo.add(lblLibroMasPrestado);
        pnlInfo.add(lblLibrosDisponibles);
        pnlInfo.add(lblLibrosNoDisponibles);
        pnlInfo.add(lblNumLibrosAgregados);
        pnlInfo.add(lblLibros);
        pnlInfo.add(pnlScroll);

        pnlDatos = new JPanel();
        pnlDatos.add(pnlInfo);

        pnlInformacion = new JPanel();
        pnlInformacion.setLayout(new BorderLayout());
        pnlInformacion.add(pnlBusqueda, BorderLayout.NORTH);
        pnlInformacion.add(pnlDatos, BorderLayout.CENTER);

        pnlTotal = new JPanel();
        pnlTotal.setLayout(new BorderLayout());
        pnlTotal.add(pnlNorte, BorderLayout.NORTH);
        pnlTotal.add(pnlInformacion, BorderLayout.CENTER);

        super.add(pnlTotal, BorderLayout.CENTER);

        super.setVisible(true);

    }

    private JMenuBar createMenuBar() {

        menuBar = new JMenuBar();

        JMenu mmArchivo = new JMenu(" Archivo ");

        JMenuItem mnExportar = new JMenuItem(" Exportar ");
        mnExportar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Reporte repo = new Reporte(numLibrosPrestados, autor, libro, numLibrosDisponibles, numLibrosAgregados, libros);

                controlador.exportarDatos(mes, repo, controlador.getDaoReporte().getAnio());

                JOptionPane.showMessageDialog(null, "¡La Informacion del Reporte del Mes se ha Exportado de Manera Satisfactoria!. \n",
                        "¡Exportacion Exitosa!. \n ", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        JMenuItem mnSalir = new JMenuItem(" Salir ");
        mnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int res = JOptionPane.showConfirmDialog(null, "¿Realmente Desea Cerrar Esta Ventana? \n ", null, JOptionPane.YES_NO_OPTION);

                if (res == JOptionPane.YES_OPTION) {

                    Reportes.this.setVisible(false);
                    System.exit(0);

                } else {

                }

            }
        });

        mmArchivo.add(mnExportar);
        mmArchivo.add(mnSalir);

        menuBar.add(mmArchivo);

        return menuBar;

    }
    
}
