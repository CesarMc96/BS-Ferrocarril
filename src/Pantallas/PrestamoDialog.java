
package Pantallas;

import DAO.Controlador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PrestamoDialog extends JDialog {
    
    private JLabel lblTituloo;
    private JLabel lblNumRenovacion;
    private JLabel lblTitulo;
    private JLabel lblAutor;
    private JLabel lblEditorial;
    private JLabel lblObservaciones;
    private JLabel lblAcciones;
    private JComboBox cmbRenovacion;
    private JComboBox cmbTitulo;
    private JComboBox cmbAutor;
    private JComboBox cmbEditorial;
    private JTextArea area; 
    private JPanel pnlArea;
    private JScrollPane scrollArea;
    private JComboBox cmbAcciones;
    private JButton btnIngresar;
    private JButton btnCancelar;
    private JPanel pnlBotones;
    private JPanel pnlComponentes;
    private JPanel pnlTotal;
    private JPanel pnlTitulo;
    private JPanel pnlRenovacion;
    private JPanel pnltitulo;
    private JPanel pnlAutor;
    private JPanel pnlEditorial;
    private JPanel pnlObservaciones;
    private JPanel pnlAcciones;
    private Controlador controlador;

    String[] acciones, renovacion;
    Object[] titulos, autores, editoriales;
    
    public PrestamoDialog( Frame frame, String titulo ) {
        
        super(frame, titulo, true);
        super.setSize(550, 450);
        super.setLayout( new BorderLayout() );
        super.setLocationRelativeTo(null);
        
        controlador = new Controlador();
        
        lblTituloo = new JLabel( " Agregar Prestamo " );
        lblTituloo.setFont( new Font("", Font.BOLD, 31) );
        
        pnltitulo = new JPanel();
        pnltitulo.add(lblTituloo);
        
        titulos = controlador.librosToArray();
        
        autores = controlador.auotoresToArray();
        
        editoriales = controlador.editorialesToArray();
        
        acciones = new String[] { "", "Devuelto", "Retraso", "Maltrato"};
        
        renovacion = new String[] {"", "1", "2", "3"};
        
        lblNumRenovacion = new JLabel("Numero Renovacion : " );
        
        area = new JTextArea();
        area.setPreferredSize( new Dimension(130, 80));
        
        scrollArea = new JScrollPane(area);
       // scrollArea.setPreferredSize( new Dimension(130, 80));
        
        lblTitulo = new JLabel( " Titulo : " );
        
        lblAutor = new JLabel( " Autor : " );
        
        lblEditorial = new JLabel( " Editorial : " );
        
        lblObservaciones = new JLabel( " Observaciones " );
        
        lblAcciones = new JLabel( " Accoiones : " );
        
        cmbAcciones = new JComboBox(acciones);
        
        cmbRenovacion = new JComboBox(renovacion);
        
        cmbTitulo = new JComboBox(titulos);
        
        cmbAutor = new JComboBox(autores);
        
        cmbEditorial = new JComboBox(editoriales);
        
        btnCancelar = new JButton( " Cancelar ");
        
        btnIngresar = new JButton( " Ingresar " );
        
        pnlBotones = new JPanel();
        pnlBotones.add(btnCancelar);
        pnlBotones.add(btnIngresar);
        
        pnlAcciones = new JPanel();
        pnlAcciones.add(lblAcciones);
        pnlAcciones.add(cmbAcciones);
        
        pnlAutor = new JPanel();
        pnlAutor.add(lblAutor);
        pnlAutor.add(cmbAutor);
        
        pnlEditorial = new JPanel();
        pnlEditorial.add(lblEditorial);
        pnlEditorial.add(cmbEditorial);
                
        pnlObservaciones = new JPanel();
        pnlObservaciones.setLayout( new BorderLayout() );
        pnlObservaciones.add(lblObservaciones, BorderLayout.NORTH);
        pnlObservaciones.add(scrollArea, BorderLayout.CENTER);
                
        pnlRenovacion = new JPanel();
        pnlRenovacion.add(lblNumRenovacion);
        pnlRenovacion.add(cmbRenovacion);
        
        pnlTitulo = new JPanel();
        pnlTitulo.add(lblTitulo);
        pnlTitulo.add(cmbTitulo);
        
        pnlComponentes = new JPanel();
        pnlComponentes.setLayout( new BoxLayout(pnlComponentes, BoxLayout.PAGE_AXIS) );
        pnlComponentes.add(pnlRenovacion);
        pnlComponentes.add(pnlTitulo);
        pnlComponentes.add(pnlAutor);
        pnlComponentes.add(pnlEditorial);
        pnlComponentes.add(pnlObservaciones);
        pnlComponentes.add(pnlAcciones);
        
        pnlTotal = new JPanel();
        pnlTotal.setLayout( new BorderLayout() );
        pnlTotal.add(pnltitulo, BorderLayout.NORTH);
        pnlTotal.add(pnlComponentes, BorderLayout.CENTER);
        
        super.add(pnlTotal, BorderLayout.CENTER);
        
        super.setVisible(true);
        
        
    }
    
    
    
}
