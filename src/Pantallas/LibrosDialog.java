package Pantallas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.Controlador;
import Modelo.Autor;
import Modelo.Editorial;
import Modelo.Estante;
import Modelo.Libro;
import Modelo.Pais;
import Modelo.Sala;

public class LibrosDialog extends JDialog {
	
	private JLabel lblTitulo;
	private JPanel pnlTitulo;
	private JPanel pnlNorte;
	private JLabel lblFolio;
	private JLabel lblAutor;
	private JLabel lblIsbn;
	private JLabel lblEditorial;
	private JLabel lblAnio;
	private JLabel lblPais;
	private JLabel lblEstante;
	private JLabel lblSala;
	private JLabel lblDescripcion;
	private JLabel lblStatus;
	private JTextField txtFolio;
	private JComboBox cmbAutores;
	private JTextField txtIsbn;
	private JComboBox cmbEditorial;
	private JComboBox cmbAnio;
	private JComboBox cmbPaises;
	private JComboBox cmbEstantes;
	private JComboBox cmbSala;
	private JTextArea area;
	private JComboBox cmbStatus;
	private JPanel pnlFolio;
	private JPanel pnlAutores;
	private JPanel pnlIsbn;
	private JPanel pnlEditoriales;
	private JPanel pnlAnio;
	private JPanel pnlPaises;
	private JPanel pnlEstantes;
	private JPanel pnlSala;
	private JPanel pnlStatus;
	private Controlador controlador;
	private JPanel pnlTextos;
	private JPanel pnlCombos;
	private JPanel pnlCentroNorte;
	private JPanel pnlCentroSur;
	private JPanel pnlComponentes;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private JPanel pnlBotones;
	private JPanel pnlCentro;
	private JPanel pnlTotal;
        private Libro libro;
	
	Object[] autores, editoriales, paises, estantes, anios;
	String[] salas, status;
        Autor autor;
        Editorial editorial;
        Estante estante;
        Pais pais;
        Sala sala;
	Integer anio, id_editorial, id_autor, id_pais, id_estante, id_status, id_sala;
        
	public LibrosDialog( Frame frame, String titulo ) {

		super(frame, titulo , true);
		super.setTitle("BS - FERROCARRIL");
		super.setLayout( new BorderLayout()  );
		super.setLocationRelativeTo(null);
		
		controlador = new Controlador();
		
		autores = controlador.auotoresToArray();
		
		editoriales = controlador.editorialesToArray();
		
		paises = controlador.paisesToArray();
		
		estantes = controlador.estantesToArray();
		
		anios = controlador.cargarAños();
		
		salas = new String[] {"", "Infantil", "Juvenil", "Bebeteca"};
		
		status = new String[] {"", "Prestamo", "Disponible", "Restauracion", "Baja"};
		
		lblTitulo = new JLabel( " Agregar Libro " );
		lblTitulo.setFont( new Font("", Font.BOLD, 31) );
		
		pnlTitulo = new JPanel();
		pnlTitulo.add(lblTitulo);
		
		lblFolio = new JLabel( " Folio : " );
		
		lblAutor = new JLabel( " Autor : " );
		
		lblIsbn = new JLabel( " ISBN : " );
		
		lblEditorial = new JLabel( " Editorial : " );
		
		lblAnio = new JLabel( " Año : " );
		
		lblPais = new JLabel( " Pais : " );
		
		lblEstante = new JLabel( " Estante : " );
		
		lblSala = new JLabel( " Sala : " );
		
		lblDescripcion = new JLabel( " Descripcion : " );
		
		lblStatus = new JLabel( " Status : " );
		
		txtFolio = new JTextField(11);
		
		txtIsbn = new JTextField(11);
		
		cmbAutores = new JComboBox<>(autores);
                cmbAutores.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        String nombre, apellidos;

                        autor = (Autor) cmbAutores.getSelectedItem();

                        nombre = autor.getNombre();
                        apellidos = autor.getApellidos();

                        id_autor = controlador.getAutorID(nombre, apellidos);

                    }
                });
                
		cmbAnio = new JComboBox<>(anios);
		cmbAnio.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        anio = (Integer) cmbAnio.getSelectedItem();
                        
                    }
                });				
 
		cmbEditorial = new JComboBox<>(editoriales);
                cmbEditorial.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String nombre;
                        
                        editorial = (Editorial) cmbEditorial.getSelectedItem();

                        nombre = editorial.getNombre();

                        id_editorial = controlador.getEditorialID( nombre );
                        
                    }
                });
		
		cmbEstantes = new JComboBox<>(estantes);
                cmbEstantes.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        Integer est;
                        String nivel;
                        
                        estante = (Estante) cmbEstantes.getSelectedItem();
                        
                        est = estante.getEstante();
                        nivel = estante.getNivel();
                        
                        id_estante = controlador.getEstanteID( est, nivel );
                        
                    }
                });
		
		cmbPaises = new JComboBox<>(paises);
                cmbPaises.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        String nombre;
                        
                        pais = (Pais) cmbPaises.getSelectedItem();
                        
                        nombre = pais.getNombre();
                        
                        id_pais = controlador.getPaisID( nombre );
                        
                    }
                });
		
		cmbSala = new JComboBox<>(salas);
                cmbSala.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        Integer id = cmbSala.getSelectedIndex();
                        
                        if ( id == 1 ) {
                            id_sala = id;
                            sala = new Sala("Infantil");
                        }
                        else if ( id == 2 ) {
                            id_sala = id;
                            sala = new Sala("Juvenil");
                        }
                        else if ( id == 3 ) {
                            id_sala = id;
                            sala = new Sala("Bebeteca");
                        }
                        else{
                            
                        }
                        
                    }
                });
		
		cmbStatus = new JComboBox<>(status);
                cmbStatus.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        Integer id = cmbStatus.getSelectedIndex();
                        
                        if ( id == 1 ) 
                            id_status = id;
                        else if ( id == 2 )
                            id_status = id;
                        else if ( id == 3 )
                            id_status = id;
                        else if ( id == 4 )
                            id_status = id;
                        else{
                            
                        }
                        
                    }
                });
		
		pnlNorte = new JPanel();
		pnlNorte.add(pnlTitulo);
		
		pnlFolio = new JPanel();
		pnlFolio.add(lblFolio);
		pnlFolio.add(txtFolio);
		
		pnlIsbn = new JPanel();
		pnlIsbn.add(lblIsbn);
		pnlIsbn.add(txtIsbn);
		
		pnlTextos = new JPanel();
		pnlTextos.setLayout( new BoxLayout(pnlTextos, BoxLayout.PAGE_AXIS ) );
		pnlTextos.add(pnlFolio);
		pnlTextos.add(pnlIsbn);
		
		pnlAutores = new JPanel();
		pnlAutores.add(lblAutor);
		pnlAutores.add(cmbAutores);
		
		pnlAnio = new JPanel();
		pnlAnio.add(lblAnio);
		pnlAnio.add(cmbAnio);
		
		pnlEditoriales = new JPanel();
		pnlEditoriales.add(lblEditorial);
		pnlEditoriales.add(cmbEditorial);
		
		pnlEstantes = new JPanel();
		pnlEstantes.add(lblEstante);
		pnlEstantes.add(cmbEstantes);
		
		pnlPaises = new JPanel();
		pnlPaises.add(lblPais);
		pnlPaises.add(cmbPaises);
		
		pnlSala = new JPanel();
		pnlSala.add(lblSala);
		pnlSala.add(cmbSala);
		
		pnlStatus = new JPanel();
		pnlStatus.add(lblStatus);
		pnlStatus.add(cmbStatus);
		
		pnlCombos = new JPanel();
		pnlCombos.setLayout( new BoxLayout(pnlCombos, BoxLayout.PAGE_AXIS ) );
		pnlCombos.add(pnlAutores);
		pnlCombos.add(pnlAnio);
		pnlCombos.add(pnlEditoriales);
		pnlCombos.add(pnlEstantes);
		pnlCombos.add(pnlPaises);
		pnlCombos.add(pnlSala);
		pnlCombos.add(pnlStatus);
		
		
		pnlComponentes = new JPanel();
		pnlComponentes.setLayout( new BorderLayout() );
		pnlComponentes.add(pnlTextos, BorderLayout.WEST);
		pnlComponentes.add(pnlCombos, BorderLayout.EAST);
		
		pnlCentroNorte = new JPanel();
		pnlCentroNorte.setLayout( new BorderLayout() );
		pnlCentroNorte.add(pnlNorte, BorderLayout.NORTH);
		pnlCentroNorte.add(pnlComponentes, BorderLayout.CENTER);
		
		btnCancelar = new JButton( " Cancelar " );
		btnCancelar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                            LibrosDialog.this.setVisible(false);
				
			}
		});
		
		btnIngresar = new JButton( " Registrar Libro " );
		btnIngresar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

                            String folio, isbn;
                            folio = txtFolio.getText();
                            isbn = txtIsbn.getText();
                            
                            
				
			}
		});
		
		pnlBotones = new JPanel();
		pnlBotones.add(btnCancelar);
		pnlBotones.add(btnIngresar);
		
		pnlCentroSur = new JPanel();
		pnlCentroSur.setLayout( new BorderLayout() );
		pnlCentroSur.add(pnlCentroNorte, BorderLayout.NORTH);
		pnlCentroSur.add(pnlBotones, BorderLayout.CENTER);

				
		pnlCentro = new JPanel();
		pnlCentro.setLayout( new BorderLayout() );
		pnlCentro.add(pnlCentroSur, BorderLayout.NORTH);
		pnlCentro.add(pnlBotones, BorderLayout.CENTER);
		
		pnlTotal = new JPanel();
		pnlTotal.setLayout( new BorderLayout() );
		pnlTotal.add(pnlCentro, BorderLayout.CENTER);
		
		super.add(pnlTotal, BorderLayout.CENTER);
				
				
		super.setVisible(true);
		
	}
	
	

}
