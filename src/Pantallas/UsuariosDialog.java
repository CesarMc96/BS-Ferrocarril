package Pantallas;

import BD.DataSourcePostgreSQL;
import BD.ModeloUsuario;
import DAO.DAOUsuarioImpl;
import Modelo.Usuario;
import com.placeholder.PlaceHolder;
import java.awt.Frame;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class UsuariosDialog extends JDialog {

    private int indice;
    private int opcion;
    private final Frame da;
    private ArrayList Usuarios;

    public UsuariosDialog(Frame f) {
        super(f, true);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        da = f;

        initComponents();
        setIconImage( new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextPane();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApMaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCredencial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtApPaterno = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(700, 250));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("USUARIO");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(310, 0, 220, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setLabelFor(txtNombre);
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 80, 70, 19);

        jScrollPane1.setViewportView(txtDireccion);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(220, 170, 220, 50);

        txtNombre.setText("   ");
        jPanel1.add(txtNombre);
        txtNombre.setBounds(220, 80, 220, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 120, 70, 19);
        jPanel1.add(txtApMaterno);
        txtApMaterno.setBounds(340, 120, 100, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Credencial:");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(270, 330, 73, 19);
        jPanel1.add(txtCredencial);
        txtCredencial.setBounds(350, 330, 90, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Direccion:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(150, 170, 90, 20);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(270, 390, 80, 25);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(360, 390, 90, 25);
        jPanel1.add(txtApPaterno);
        txtApPaterno.setBounds(220, 120, 100, 22);

        txtCorreo.setText("   ");
        jPanel1.add(txtCorreo);
        txtCorreo.setBounds(220, 240, 220, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setLabelFor(txtNombre);
        jLabel4.setText("Correo:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 240, 70, 19);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setLabelFor(txtNombre);
        jLabel8.setText("Telefono:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(250, 290, 70, 19);

        txtTelefono.setText("   ");
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(320, 290, 120, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-260, -60, 520, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int n = JOptionPane.showConfirmDialog(
                da,
                "¿Deseas cancelar cambio?",
                "¿Seguro?",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtApMaterno.getText().equals("") || txtApPaterno.getText().equals("") || txtCredencial.getText().equals("") || txtDireccion.getText().equals("") || txtNombre.getText().equals("") || txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El unico campo que puede estar vacio es correo.", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            if (opcion == 1) {
                DAOUsuarioImpl d = new DAOUsuarioImpl();

                java.util.Date fechaq = new java.util.Date();
                d.registrarUsuario(new Usuario(txtNombre.getText(), txtApPaterno.getText(), txtApMaterno.getText(), txtCredencial.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText(), new Date(fechaq.getYear(), fechaq.getMonth(), fechaq.getDay())));

                this.setVisible(false);
                da.setVisible(false);
                Usuarios u = new Usuarios();
                u.setVisible(true);
                DataSourcePostgreSQL ds = new DataSourcePostgreSQL();
                Usuarios = ds.crearArreglo("Select * from usuario", "Usuario");
                ModeloUsuario ma = new ModeloUsuario(Usuarios);

                this.setVisible(false);
            } else if (opcion == 2) {

                DataSourcePostgreSQL d = new DataSourcePostgreSQL();
                Usuario usuario = new Usuario(txtNombre.getText(), txtApPaterno.getText(), txtApMaterno.getText(), txtCredencial.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText()), alta;

                d.ejecutarActualizacion("UPDATE usuario SET  nombre = '" + usuario.getNombre() + "', ap_paterno = '" + usuario.getApPaterno() + "', ap_materno = '" + usuario.getApMaterno()
                        + "', num_credencial = '" + usuario.getNumCredencial() + "', direccion = '" + usuario.getDireccion() + "', telefono = '" + usuario.getTelefono() + "', correo = '" + usuario.getCorreo()
                        + "' WHERE id_usuario = " + indice);

                this.setVisible(false);
                da.setVisible(false);
                Usuarios u = new Usuarios();
                u.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void setTxtNombre(String txtNombre) {
        this.txtNombre.setText(txtNombre);
    }

    public void setTxtApPaterno(String txtApPaterno) {
        this.txtApPaterno.setText(txtApPaterno);
    }

    public void setTxtApMaterno(String txtApMaterno) {
        this.txtApMaterno.setText(txtApMaterno);
    }

    public void setTxtCredencial(String txtCredencial) {
        this.txtCredencial.setText(txtCredencial);
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion.setText(txtDireccion);
    }

    public void setTxtCorreo(String txtCorreo) {
        this.txtCorreo.setText(txtCorreo);
    }

    public void setTxtTelefono(String txtTelefono) {
        this.txtTelefono.setText(txtTelefono);
    }

    public void setVariable(int v) {
        opcion = v;
    }

    public void setModificar(int v) {
        indice = v;
    }

    public void agregarPH(int Variable) {
        if (Variable == 1) {
            PlaceHolder holder = new PlaceHolder(txtApMaterno, "     Materno");
            PlaceHolder holder1 = new PlaceHolder(txtApPaterno, "     Paterno");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApMaterno;
    private javax.swing.JTextField txtApPaterno;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCredencial;
    private javax.swing.JTextPane txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
