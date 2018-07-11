package Pantallas;

import BD.DataSourcePostgreSQL;
import BD.JuegosDialogListener;
import BD.ModeloJuegos;
import Modelo.Juego;
import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JuegosDialog extends JDialog {

    private int indice;
    private int opcion;
    private JuegosDialogListener listener;
    private final Frame da;
    private ArrayList Juegos;

    public JuegosDialog(Frame f) {
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
        txtDescripcion = new javax.swing.JTextPane();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ListaCantidad = new javax.swing.JComboBox<>();
        txtPiezas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAccesorios = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(700, 250));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("JUEGOS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(310, 10, 220, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setLabelFor(txtNombre);
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 90, 70, 19);

        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(280, 220, 180, 60);

        txtNombre.setText("   ");
        jPanel1.add(txtNombre);
        txtNombre.setBounds(90, 90, 180, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Piezas:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(220, 140, 45, 19);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Cantidad:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(290, 90, 90, 19);

        ListaCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "15", "16", "17", "18", "19", "20" }));
        ListaCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(ListaCantidad);
        ListaCantidad.setBounds(370, 90, 50, 22);
        ListaCantidad.setBackground(Color.white);
        jPanel1.add(txtPiezas);
        txtPiezas.setBounds(280, 140, 180, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Accesorios:");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(190, 180, 73, 19);
        jPanel1.add(txtAccesorios);
        txtAccesorios.setBounds(280, 180, 180, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Descripción:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(190, 220, 90, 20);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(280, 300, 80, 25);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(370, 300, 90, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/juegos.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 110, 480, 430);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
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
        //1 para nuevo 2 para modificar

        if (txtNombre.getText().equals("") || txtAccesorios.getText().equals("") || txtPiezas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Las campos Nombre, Accesorios y Piezas no pueden ir vacios.", "Error", JOptionPane.WARNING_MESSAGE);
        } else {

            if (opcion == 1) {
                DataSourcePostgreSQL d = new DataSourcePostgreSQL();
                Juego juego = new Juego(txtNombre.getText(), ListaCantidad.getSelectedIndex() + 1, txtPiezas.getText(), txtAccesorios.getText(), txtDescripcion.getText());

                String consulta = "INSERT INTO juegos(nombre, cantidad, piezas, accesorios, descripcion) VALUES ( '" + juego.getNombre() + "', '" + juego.getCantidad() + "', '" + juego.getPiezas() + "', '" + juego.getAccesorios() + "', '" + juego.getDescripcion() + "')";

                d.ejecutarActualizacion(consulta);

                this.setVisible(false);
                da.setVisible(false);
                Juegos u = new Juegos();
                u.setVisible(true);

                DataSourcePostgreSQL ds = new DataSourcePostgreSQL();
                Juegos = ds.crearArreglo("Select * from juegos", "Juego");
                ModeloJuegos ma = new ModeloJuegos(Juegos);
                listener.aceptarButtonClick(juego);

                this.setVisible(false);
            } else if (opcion == 2) {
                DataSourcePostgreSQL d = new DataSourcePostgreSQL();
                Juego juego = new Juego(txtNombre.getText(), ListaCantidad.getSelectedIndex() + 1, txtPiezas.getText(), txtAccesorios.getText(), txtDescripcion.getText());

                d.ejecutarActualizacion("UPDATE juegos SET  nombre = '" + juego.getNombre() + "',cantidad = '" + juego.getCantidad() + "', piezas = '" + juego.getPiezas()
                        + "', accesorios = '" + juego.getAccesorios() + "', descripcion = '" + juego.getDescripcion() + "' WHERE id_juegos= " + indice);

                this.setVisible(false);
                da.setVisible(false);
                Juegos u = new Juegos();
                u.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void setListener(JuegosDialogListener listener) {
        this.listener = listener;
    }

    public void setVariable(int v) {
        opcion = v;
    }

    public void setModificar(int v) {
        indice = v;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre.setText(txtNombre);
    }

    public void setTxtPiezas(String txtPiezas) {
        this.txtPiezas.setText(txtPiezas);
    }

    public void setTxtAccesorios(String txtAccesorios) {
        this.txtAccesorios.setText(txtAccesorios);
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion.setText(txtDescripcion);
    }

    public void setTxtCantidad(Integer indice) {
        ListaCantidad.setSelectedIndex(indice);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListaCantidad;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAccesorios;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPiezas;
    // End of variables declaration//GEN-END:variables
}
