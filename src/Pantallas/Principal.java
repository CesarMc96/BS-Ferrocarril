package Pantallas;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Principal extends JFrame {

    private final JPanel pnlArriba;
    private final JPanel pnlEnmedio;
    private final JPanel pnlAbajo;
    private final JLabel txtTitulo;
    private final JButton btnIngresar;
    private final JLabel lblIma;
    private final ImageIcon img;
    private final ImageIcon imgEs;

    public Principal() {
        super.setSize(420, 480);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("BS Ferrocarril");
        //super.setUndecorated(true);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        pnlArriba = new JPanel();
        txtTitulo = new JLabel("BS Ferrocarril");
        txtTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pnlArriba.add(txtTitulo);
        pnlArriba.setBackground(Color.WHITE);

        pnlEnmedio = new JPanel();
        pnlEnmedio.setBackground(Color.WHITE);
        img = new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg"));
        imgEs = new ImageIcon(img.getImage().getScaledInstance(300, 360, java.awt.Image.SCALE_DEFAULT));
        lblIma = new JLabel(imgEs);
        pnlEnmedio.add(lblIma);
        
        pnlAbajo = new JPanel();
        btnIngresar = new JButton("Ingresar");
//        btnIngresar.setBorder(null);
        btnIngresar.setBackground(Color.WHITE);
        pnlAbajo.setBackground(Color.WHITE);
        pnlAbajo.add(btnIngresar);

        super.add(pnlArriba, BorderLayout.NORTH);
        super.add(pnlEnmedio, BorderLayout.CENTER);
        super.add(pnlAbajo, BorderLayout.SOUTH);
        super.setVisible(true);
        
        btnIngresar.addActionListener((ActionEvent e) -> {
            Seleccion s = new Seleccion();
            s.setVisible(true);
            this.setVisible(false);
        });
    }

    
}
