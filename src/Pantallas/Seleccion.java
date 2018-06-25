
package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Seleccion extends JFrame{
    
    public Seleccion(){
        super.setSize(600, 450);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("BS Ferrocarril");
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        
    }
}
