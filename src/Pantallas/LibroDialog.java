package Pantallas;

import BD.DataSourcePostgreSQL;
import Modelo.*;
import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class LibroDialog extends JDialog {

    private int indice;
    private int opcion;
    private final Frame da;
    private ArrayList Juegos;
    private ArrayList<Pais> array;
    private ArrayList<Compañia> array1;
    private ArrayList<Editorial> array2;

    public LibroDialog(Frame f) {
        super(f, true);
        super.setLocationRelativeTo(null);
        super.setTitle("BS - Ferrocarril");
        da = f;

        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblEditorial = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ListaCopias = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtAnio = new javax.swing.JTextField();
        ListaEditorial = new javax.swing.JComboBox<>();
        ListaPais = new javax.swing.JComboBox<>();
        ListaAutor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtFormato = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(700, 250));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("LIBROS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 20, 130, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setLabelFor(txtTitulo);
        jLabel3.setText("Titulo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 90, 70, 19);

        txtTitulo.setText("   ");
        jPanel1.add(txtTitulo);
        txtTitulo.setBounds(70, 90, 170, 22);

        lblEditorial.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblEditorial.setText("Editorial:");
        jPanel1.add(lblEditorial);
        lblEditorial.setBounds(280, 90, 80, 19);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Copias:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(250, 300, 90, 19);

        ListaCopias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "15", "16", "17", "18", "19", "20" }));
        ListaCopias.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(ListaCopias);
        ListaCopias.setBounds(310, 300, 50, 22);
        ListaCopias.setBackground(Color.white);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Folio:");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(260, 260, 50, 19);
        jPanel1.add(txtAutor);
        txtAutor.setBounds(310, 180, 150, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Folio:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(260, 180, 50, 20);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(290, 350, 80, 25);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(380, 350, 90, 25);
        jPanel1.add(txtAnio);
        txtAnio.setBounds(390, 130, 60, 22);

        jPanel1.add(ListaEditorial);
        ListaEditorial.setBounds(350, 90, 100, 22);

        jPanel1.add(ListaPais);
        ListaPais.setBounds(70, 130, 100, 22);

        jPanel1.add(ListaAutor);
        ListaAutor.setBounds(250, 130, 120, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Pais:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 130, 40, 19);

        txtFormato.setText(" ");
        jPanel1.add(txtFormato);
        txtFormato.setBounds(310, 220, 150, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Autor:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(200, 130, 50, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("ISBN:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 220, 40, 19);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/libro.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-70, 150, 330, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
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

        if (txtTitulo.getText().equals("") || txtFormato.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo Titulo y Formato no pueden estar vacios.", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            if (opcion == 1) {
                DataSourcePostgreSQL d = new DataSourcePostgreSQL();

                String consulta = "INSERT INTO multimedia(titulo, autor, anio, pais_id, compania_id, editorial_id, formato, copias) VALUES ( " + "'" + txtTitulo.getText() + "', '" + txtAutor.getText() + "', '" + txtAnio.getText() + "', '" + (ListaPais.getSelectedIndex() + 1) + "', '"
                        + (ListaAutor.getSelectedIndex() + 1) + "', '" + (ListaEditorial.getSelectedIndex() + 1) + "', '" + txtFormato.getText() + "', '" + (ListaCopias.getSelectedIndex() + 1) + "')";

                d.ejecutarActualizacion(consulta);

                this.setVisible(false);
                da.setVisible(false);
                Multimedias u = new Multimedias();
                u.setVisible(true);

                this.setVisible(false);
            } else if (opcion == 2) {
                DataSourcePostgreSQL d = new DataSourcePostgreSQL();

                String consulta = "UPDATE multimedia SET titulo= '" + txtTitulo.getText() + "', autor='" + txtAutor.getText() + "', anio='" + txtAnio.getText()
                        + "', pais_id='" + (ListaPais.getSelectedIndex() + 1) + "', compania_id='" + (ListaAutor.getSelectedIndex() + 1) + "', editorial_id='" + (ListaEditorial.getSelectedIndex() + 1)
                        + "', formato='" + txtFormato.getText() + "', copias='" + (ListaCopias.getSelectedIndex() + 1) + "' WHERE id_multimedia = " + indice;

                d.ejecutarActualizacion(consulta);

                this.setVisible(false);
                da.setVisible(false);
                Multimedias u = new Multimedias();
                u.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void setVariable(int v) {
        opcion = v;
    }

    public void setModificar(int v) {
        indice = v;
    }

    public void setTxtAnio(String anio) {
        txtAnio.setText(anio);
    }

    public void setTxtAutor(String autor) {
        txtAutor.setText(autor);
    }

    public void setTxtTitulo(String titulo) {
        txtTitulo.setText(titulo);
    }

    public void setTxtFormato(String formato) {
        txtFormato.setText(formato);
    }

    public void llenarArrayPaises(ArrayList arreglo, Integer hh) {
        array = arreglo;

        for (int i = 0; i < array.size(); i++) {
            ListaPais.addItem(array.get(i).toString());
        }

        ListaPais.setSelectedIndex(hh);
    }

    public void llenarArrayAutor(ArrayList arreglo1, Integer hhh) {
        array1 = arreglo1;

        for (int i = 0; i < array1.size(); i++) {
            ListaAutor.addItem(array1.get(i).toString());
        }

        ListaAutor.setSelectedIndex(hhh);
    }

    public void llenarArrayEditorial(ArrayList arreglo2, Integer ht) {
        array2 = arreglo2;

        for (int i = 0; i < array2.size(); i++) {
            ListaEditorial.addItem(array2.get(i).toString());
        }

        ListaEditorial.setSelectedIndex(ht);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListaAutor;
    private javax.swing.JComboBox<String> ListaCopias;
    private javax.swing.JComboBox<String> ListaEditorial;
    private javax.swing.JComboBox<String> ListaPais;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtFormato;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
