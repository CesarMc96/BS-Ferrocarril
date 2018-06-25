
package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Seleccion extends JFrame{

    private final ImageIcon libros;
    private final ImageIcon librosEs;
    private final ImageIcon bebes;
    private final ImageIcon bebesEs;
    private final ImageIcon multimedia;
    private final ImageIcon multimediaEs;
    private final ImageIcon juegos;
    private final ImageIcon juegosEs;
    private final JLabel lblLibros;
    private final JLabel lblmultimedia;
    private final JLabel lblJuegos;
    private final JPanel pnlSeccion;
    private final JLabel lblBebes;
    
    public Seleccion(){
        super.setSize(600, 450);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("BS Ferrocarril");
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        
        libros = new ImageIcon(getClass().getResource("/Imagenes/libros.png"));
        librosEs = new ImageIcon(libros.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        
        bebes = new ImageIcon(getClass().getResource("/Imagenes/bebes.png"));
        bebesEs = new ImageIcon(bebes.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        
        multimedia = new ImageIcon(getClass().getResource("/Imagenes/multimedia.png"));
        multimediaEs = new ImageIcon(multimedia.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        
        juegos = new ImageIcon(getClass().getResource("/Imagenes/juegos.png"));
        juegosEs = new ImageIcon(juegos.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        
        lblLibros = new JLabel(librosEs);
        lblmultimedia = new JLabel(multimediaEs);
        lblJuegos = new JLabel(juegosEs);
        lblBebes = new JLabel(bebesEs);
        
        pnlSeccion = new JPanel();
        pnlSeccion.setBackground(Color.WHITE);
        
        pnlSeccion.add(lblLibros);
        pnlSeccion.add(lblmultimedia);
        pnlSeccion.add(lblJuegos);
        pnlSeccion.add(lblBebes);
        
        super.add(pnlSeccion);
    }
}
