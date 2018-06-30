package Pantallas;

import BD.ControladorUsuario;
import BD.DataSourcePostgreSQL;
import BD.ModeloUsuario;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Usuarios extends JFrame {

    private JTable tblUsuario;
    private ModeloUsuario modelo;
    private ArrayList<Usuario> Usuario;

    private ControladorUsuario controlador;
    private Integer variable;

    private final JButton btnNuevo;
    private final JButton btnModificar;
    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JPanel pnlboton;
    private final JButton btnEliminar;
    private UsuariosDialogNuevo udn;

    public Usuarios() {
        super.setSize(800, 800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setTitle("Usuarios");
        super.setLayout(new BorderLayout());
        super.getContentPane().setBackground(Color.WHITE);

        DataSourcePostgreSQL das = new DataSourcePostgreSQL();
        Usuario = das.crearArreglo("Select * from usuario", "Usuario");

        controlador = new ControladorUsuario(Usuario);
        modelo = new ModeloUsuario(controlador.getDb());
        tblUsuario = new JTable(modelo);

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

        super.add(new JScrollPane(tblUsuario));
        super.add(pnlboton, BorderLayout.PAGE_END);
        super.add(pnlBotones, BorderLayout.PAGE_START);

        super.setVisible(true);

        //Acciones
        btnEliminar.addActionListener((ActionEvent ae) -> {

            int rowSelected = tblUsuario.getSelectedRow();

            if (rowSelected >= 0) {
                controlador.eliminar(controlador.buscar(rowSelected).getIdUsuario(), rowSelected);
                controlador.guardar();
                modelo.fireTableDataChanged();
            }
        });

        btnNuevo.addActionListener((ActionEvent e) -> {
            udn = new UsuariosDialogNuevo();
            udn.setVisible(true);
        });
    }
}
