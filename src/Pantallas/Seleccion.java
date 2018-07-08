package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
    private final JPanel pnlSeccion;
    private final JPanel pnlTitulo;
    private final JLabel lblTitulo;
    private final JLabel lblTexto;
    private final JButton btnLibros;
    private final JButton btnMultimedia;
    private final JButton btnJuegos;
    private final JButton btnBebes;
    private final JPanel pnlAbajo;

    public Seleccion() {
        super.setSize(850, 350);
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

        //Botones
        btnLibros = new JButton();
        btnLibros.setIcon(librosEs);
        btnLibros.setBorder(null);
        btnLibros.setBackground(Color.WHITE);
        
        btnMultimedia = new JButton();
        btnMultimedia.setIcon(multimediaEs);
        btnMultimedia.setBorder(null);
        btnMultimedia.setBackground(Color.WHITE);
        
        btnJuegos = new JButton();
        btnJuegos.setIcon(juegosEs);
        btnJuegos.setBorder(null);
        btnJuegos.setBackground(Color.WHITE);
        
        btnBebes = new JButton();
        btnBebes.setIcon(bebesEs);
        btnBebes.setBorder(null);
        btnBebes.setBackground(Color.WHITE);
        
        pnlSeccion = new JPanel();
        pnlSeccion.setBackground(Color.WHITE);

        pnlSeccion.add(btnLibros);
        pnlSeccion.add(btnMultimedia);
        pnlSeccion.add(btnJuegos);
        pnlSeccion.add(btnBebes);
        
        //Acciones
        btnJuegos.addActionListener((ActionEvent e) -> {
            new Juegos();
            this.setVisible(false);
        });
        
        btnBebes.addActionListener((ActionEvent e) -> {
            
        });
        
        btnLibros.addActionListener((ActionEvent e) -> {
            new Libros();
            this.setVisible(false);
//           Usuarios u = new Usuarios(this);
//           u.setVisible(true);
        });
        
        btnMultimedia.addActionListener((ActionEvent e) -> {
            
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
