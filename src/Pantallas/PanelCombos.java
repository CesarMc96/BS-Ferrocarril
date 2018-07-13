
package Pantallas;

import DAO.Controlador;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelCombos extends  JFrame {
    
    private JLabel lblTitulo;
    private JPanel pnlTitulo;
    private JLabel lblAutores;
    private JLabel lblPaises;
    private JLabel lblEditoriales;
    private JComboBox cmbAutores;
    private JComboBox cmbPaises;
    private JComboBox cmbEditoriales;
    private Controlador controlador;
    private JPanel pnlPaises;
    private JPanel pnlEditoriales;
    private JPanel pnlAutores;
    private JPanel pnlComponentes;
    private JPanel pnlCentral;
    
    Object[] autores, paises, editoriales;

    public PanelCombos() {
        
        super.setSize(450, 400);
        super.setTitle("Panel Combos");
        super.setLocationRelativeTo(null);
        super.setLayout( new BorderLayout() );
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lblTitulo = new JLabel("PANEL COMBOS");
        lblTitulo.setFont( new Font("", Font.BOLD, 32) );
        
        controlador = new Controlador();
        
        autores = controlador.auotoresToArray();
        
        paises = controlador.paisesToArray();
        
        editoriales = controlador.editorialesToArray();
        
        pnlTitulo = new JPanel();
        pnlTitulo.add(lblTitulo);
        
        lblAutores = new JLabel("Autores : " );
        
        lblEditoriales = new JLabel("Editoriales : " );
        
        lblPaises = new JLabel("Paises : " );
        
        cmbAutores = new JComboBox(autores);
        
        cmbEditoriales = new JComboBox(editoriales);
        
        cmbPaises = new JComboBox(paises);
        
        pnlAutores = new JPanel();
        pnlAutores.add(lblAutores);
        pnlAutores.add(cmbAutores);
        
        pnlEditoriales = new JPanel();
        pnlEditoriales.add(lblEditoriales);
        pnlEditoriales.add(cmbEditoriales);
        
        pnlPaises = new JPanel();
        pnlPaises.add(lblPaises);
        pnlPaises.add(cmbPaises);
        
        pnlComponentes = new JPanel();
        pnlComponentes.setLayout( new BoxLayout(pnlComponentes, BoxLayout.PAGE_AXIS) );
        pnlComponentes.add(pnlAutores);
        pnlComponentes.add(pnlEditoriales);
        pnlComponentes.add(pnlPaises);
        
        pnlCentral = new JPanel();
        pnlCentral.setLayout( new BorderLayout() );
        pnlCentral.add(pnlTitulo, BorderLayout.NORTH);
        pnlCentral.add(pnlComponentes, BorderLayout.CENTER);
        
        super.add(pnlCentral, BorderLayout.CENTER);
        
        super.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        
        PanelCombos pnlCombos = new PanelCombos();
        
    }
    
    
    
}
