package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Seleccion extends JFrame {

    private final ImageIcon libros;
    private final ImageIcon librosEs;
    private final ImageIcon bebes;
    private final ImageIcon bebesEs;
    private final ImageIcon multimedia;
    private final ImageIcon multimediaEs;
    private final ImageIcon juegos;
    private final ImageIcon juegosEs;
    private final ImageIcon derecha;
    private final ImageIcon derechaEs;
    private final ImageIcon izquierda;
    private final ImageIcon izquierdaEs;
    private final ImageIcon usuario;
    private final ImageIcon usuarioEs;
    private final ImageIcon prestamo;
    private final ImageIcon prestamoEs;
    private final ImageIcon reporte;
    private final ImageIcon reporteEs;
    private final ImageIcon blanco;
    private final ImageIcon blancoEs;
    private final JPanel pnlSeccion;
    private final JPanel pnlTitulo;
    private final JLabel lblTitulo;
    private final JLabel lblTexto;
    private final JButton btnLibros;
    private final JButton btnMultimedia;
    private final JButton btnJuegos;
    private final JButton btnBebes;
    private final JPanel pnlAbajo;
    private final JButton btnDerecha;
    private final JButton btnUsuario;
    private final JPanel pnlSeccion2;
    private final JButton btnPrestamo;
    private final JButton btnReporte;
    private final JButton btnIzquierda;
    private final JButton btnBlanco;
    private final JButton btnBlanco1;

    public Seleccion() {
        super.setSize(850, 390);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("BS Ferrocarril");
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        //Imagenes
        libros = new ImageIcon(getClass().getResource("/Imagenes/libros.png"));
        librosEs = new ImageIcon(libros.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));

        bebes = new ImageIcon(getClass().getResource("/Imagenes/bebes.png"));
        bebesEs = new ImageIcon(bebes.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));

        multimedia = new ImageIcon(getClass().getResource("/Imagenes/multimedia.png"));
        multimediaEs = new ImageIcon(multimedia.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));

        juegos = new ImageIcon(getClass().getResource("/Imagenes/juegos.png"));
        juegosEs = new ImageIcon(juegos.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));

        derecha = new ImageIcon(getClass().getResource("/Imagenes/der.png"));
        derechaEs = new ImageIcon(derecha.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));

        izquierda = new ImageIcon(getClass().getResource("/Imagenes/izq.png"));
        izquierdaEs = new ImageIcon(izquierda.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));

        //Botones
        btnLibros = new JButton();
        btnLibros.setIcon(librosEs);
        btnLibros.setBorder(null);
        btnLibros.setBackground(Color.WHITE);
        btnLibros.setToolTipText("Libros");

        btnMultimedia = new JButton();
        btnMultimedia.setIcon(multimediaEs);
        btnMultimedia.setBorder(null);
        btnMultimedia.setBackground(Color.WHITE);
        btnMultimedia.setToolTipText("Multimedia");

        btnJuegos = new JButton();
        btnJuegos.setIcon(juegosEs);
        btnJuegos.setBorder(null);
        btnJuegos.setBackground(Color.WHITE);
        btnJuegos.setToolTipText("Juegos");

        btnBebes = new JButton();
        btnBebes.setIcon(bebesEs);
        btnBebes.setBorder(null);
        btnBebes.setBackground(Color.WHITE);
        btnBebes.setToolTipText("Bebés");

        btnDerecha = new JButton();
        btnDerecha.setIcon(derechaEs);
        btnDerecha.setBorder(null);
        btnDerecha.setBackground(Color.WHITE);
        btnDerecha.setToolTipText("Siguiente");
        
        pnlSeccion = new JPanel();
        pnlSeccion.setBackground(Color.WHITE);

        pnlSeccion.add(btnLibros);
        pnlSeccion.add(btnMultimedia);
        pnlSeccion.add(btnJuegos);
        pnlSeccion.add(btnBebes);
        pnlSeccion.add(new JLabel("     "));
        pnlSeccion.add(btnDerecha);

        //Seccion 2
        usuario = new ImageIcon(getClass().getResource("/Imagenes/usuario_1.png"));
        usuarioEs = new ImageIcon(usuario.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));

        prestamo = new ImageIcon(getClass().getResource("/Imagenes/prestamo.png"));
        prestamoEs = new ImageIcon(prestamo.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));

        reporte = new ImageIcon(getClass().getResource("/Imagenes/reporte.png"));
        reporteEs = new ImageIcon(reporte.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));
        
        blanco = new ImageIcon(getClass().getResource("/Imagenes/Blanco.png"));
        blancoEs = new ImageIcon(blanco.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));

        btnUsuario = new JButton();
        btnUsuario.setIcon(usuarioEs);
        btnUsuario.setBorder(null);
        btnUsuario.setBackground(Color.WHITE);
        btnUsuario.setToolTipText("Usuario");

        btnPrestamo = new JButton();
        btnPrestamo.setIcon(prestamoEs);
        btnPrestamo.setBorder(null);
        btnPrestamo.setBackground(Color.WHITE);
        btnPrestamo.setToolTipText("Prestamo");
        
        btnReporte = new JButton();
        btnReporte.setIcon(reporteEs);
        btnReporte.setBorder(null);
        btnReporte.setBackground(Color.WHITE);
        btnReporte.setToolTipText("Reporte");
        
        btnIzquierda = new JButton();
        btnIzquierda.setIcon(izquierdaEs);
        btnIzquierda.setBorder(null);
        btnIzquierda.setBackground(Color.WHITE);
        btnIzquierda.setToolTipText("Atras");
        
        btnBlanco = new JButton();
        btnBlanco.setIcon(blancoEs);
        btnBlanco.setBorder(null);
        btnBlanco.setBackground(Color.WHITE);

        btnBlanco1 = new JButton();
        btnBlanco1.setIcon(blancoEs);
        btnBlanco1.setBorder(null);
        btnBlanco1.setBackground(Color.WHITE);

        pnlSeccion2 = new JPanel();
        pnlSeccion2.setBackground(Color.WHITE);

        pnlSeccion2.add(btnBlanco);
        pnlSeccion2.add(btnUsuario);
        pnlSeccion2.add(btnPrestamo);
        pnlSeccion2.add(btnReporte);
        pnlSeccion2.add(btnBlanco1);
        pnlSeccion2.add(btnIzquierda);

        //Acciones
        btnDerecha.addActionListener((ActionEvent e) -> {
            pnlSeccion.setVisible(false);
            super.add(pnlSeccion2, BorderLayout.CENTER);
            pnlSeccion2.setVisible(true);
        });

        btnIzquierda.addActionListener((ActionEvent e) -> {
            pnlSeccion2.setVisible(false);
            super.add(pnlSeccion, BorderLayout.CENTER);
            pnlSeccion.setVisible(true);
        });

        btnJuegos.addActionListener((ActionEvent e) -> {
            new Juegos();
            this.setVisible(false);
        });

        btnBebes.addActionListener((ActionEvent e) -> {

        });

        btnLibros.addActionListener((ActionEvent e) -> {
            new Libros();
            this.setVisible(false);
        });

        btnMultimedia.addActionListener((ActionEvent e) -> {
            new Multimedias();
            this.setVisible(false);
        });
        
        btnUsuario.addActionListener((ActionEvent e) -> {
            new Usuarios();
            this.setVisible(false);
        });

        //Panel arriba
        pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new BorderLayout());
        pnlTitulo.setBackground(Color.black);
        lblTitulo = new JLabel("                                         BIENVENIDO");
        lblTexto = new JLabel("                                                                                     Elija la opcion deseada:");
        lblTexto.setForeground(Color.WHITE);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 27));
        lblTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        pnlTitulo.add(lblTitulo, BorderLayout.PAGE_START);
        pnlTitulo.add(new JLabel(), BorderLayout.CENTER);
        pnlTitulo.add(lblTexto, BorderLayout.PAGE_END);

        //Panel abajo
        pnlAbajo = new JPanel();
        pnlAbajo.setBackground(Color.black);
        pnlAbajo.add(new JLabel("BS - Ferrocarril. Museo Infantil de Oaxaca"));

        super.add(pnlSeccion, BorderLayout.CENTER);
        super.add(pnlTitulo, BorderLayout.PAGE_START);
        super.add(pnlAbajo, BorderLayout.PAGE_END);

        super.setVisible(true);
    }
}
