package Pantallas;

import BD.ControladorAutor;
import BD.DataSourcePostgreSQL;
import BD.ModeloAutor;
import Modelo.Autor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Autores extends JFrame {

    private JTable tblAutor;
    private ModeloAutor modelo;
    private ArrayList<Autor> Autor;

    private ControladorAutor controlador;
    private Integer variable;

    private final JButton btnNuevo;
    private final JButton btnModificar;
    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JPanel pnlboton;
    private final JButton btnEliminar;
    
    private AutorDialogNuevo autorDialog;

    public Autores() {
        super.setSize(800, 800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setTitle("Autores");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Autor = das.crearArreglo("Select * from autor", "Autor");

        controlador = new ControladorAutor(Autor);
        modelo = new ModeloAutor(controlador.getDb());
        tblAutor = new JTable(modelo);

        //Boton
        pnlBotones = new JPanel();
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);

        pnlboton = new JPanel();
        btnAceptar = new JButton("Aceptar");
        pnlboton.add(btnAceptar);

        super.add(new JScrollPane(tblAutor));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        super.setVisible(true);

        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {

            int rowSelected = tblAutor.getSelectedRow();

            if (rowSelected >= 0) {
                controlador.eliminar(controlador.buscar(rowSelected).getIdAutor(), rowSelected);
                controlador.guardar();
                modelo.fireTableDataChanged();
            }
        });
        
        btnNuevo.addActionListener((ActionEvent ae) -> {
            variable = 1;
            autorDialog = new AutorDialogNuevo();
            autorDialog.setVisible(true);
//            userDialog.setVariable(variable);
//            userDialog.setTxtNombre("");
//            userDialog.setTxtNickName("");
//            userDialog.setTxtContrasena("");
//            userDialog.setRol("");
//            userDialog.setPermitido("");
//            userDialog.setVisible(true);
        });
        
    }
}
