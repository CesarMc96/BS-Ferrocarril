
package Pantallas;

import BDA.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Libros extends JFrame {
    
    private JTable tabla;
    private DefaultTableModel modelo;
    private JPanel panel;
    private Object[][] matriz;
    private JScrollPane scroll;
    private Controlador controlador;
    String[] cabeceras = new String[] { "Folio", "Titulo", "Autor", "ISBN", "Editorial", "Año", "Pais", "Estante", "Sala", "Descripcion", "Status"};
    
    public Libros(){
        super.setSize(800,800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);
        
        controlador = new Controlador();
        
        matriz = controlador.toMatrizLibros();
        
        modelo = new DefaultTableModel(matriz, cabeceras);
        
        tabla = new JTable(modelo);
        
        scroll = new JScrollPane(tabla);
        
        panel = new JPanel();
        panel.add(scroll);
        
        super.add(panel, BorderLayout.CENTER);
        
        super.setVisible(true);
    }
    
    
}
