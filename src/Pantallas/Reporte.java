package Pantallas;

import DAO.Controlador;
import Modelo.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Reporte extends javax.swing.JFrame {

    private Controlador controlador;
    private Autor autor;
    private Libro libro;
    private Integer[] numLibrosDisponibles;
    private Integer numLibrosPrestados;
    private ArrayList<Libro> libros;
    private int numLibrosAgregados;
    private String mes;

    public Reporte() {
        super.setTitle("BS - Ferrocarril");
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/LOGOBS-01.jpg")).getImage());
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jPanel2.setVisible(false);
        controlador = new Controlador();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ListaMes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblLibrosPrestados = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblLibroSolicitado = new javax.swing.JLabel();
        lblLibroDisponible = new javax.swing.JLabel();
        lblLibroNoDisponible = new javax.swing.JLabel();
        lblLibroNuevo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("REPORTES");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(350, 10, 220, 60);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Seleccione el mes en el que este interesado:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 90, 310, 16);

        ListaMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jPanel1.add(ListaMes);
        ListaMes.setBounds(330, 90, 93, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporteico.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 130, 290, 250);

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerar);
        btnGenerar.setBounds(470, 90, 80, 25);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Libros prestados:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Autor mas solicitado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Libro mas solicitado:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Libros disponibles:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Libros NO disponibles:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Libros nuevos:");

        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblLibrosPrestados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLibrosPrestados.setText("libro");

        lblAutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAutor.setText("jLabel10");

        lblLibroSolicitado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLibroSolicitado.setText("jLabel11");

        lblLibroDisponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLibroDisponible.setText("jLabel12");

        lblLibroNoDisponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLibroNoDisponible.setText("jLabel13");

        lblLibroNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLibroNuevo.setText("jLabel14");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblLibrosPrestados))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblAutor))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lblLibroNoDisponible))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(29, 29, 29)
                        .addComponent(lblLibroNuevo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblLibroDisponible))
                            .addComponent(lblLibroSolicitado))))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblLibrosPrestados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblLibroSolicitado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblLibroDisponible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblLibroNoDisponible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblLibroNuevo))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(280, 130, 310, 240);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Cerrar");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 370, 60, 17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        mes = ListaMes.getSelectedItem().toString();
        System.out.println(mes);

        numLibrosPrestados = controlador.numLibrosPrestados(mes);
        autor = controlador.autorMasSolicitado(mes);
        libro = controlador.libroMasPrestado(mes);
        numLibrosDisponibles = controlador.numLibrosDisponibles();
        libros = controlador.librosRegistrados(mes);

        controlador.getDaoReporte().getDs().iniciarConexion();

        lblLibrosPrestados.setText(numLibrosPrestados + "");
        lblAutor.setText(autor + "");
        lblLibroSolicitado.setText(libro + "");
        lblLibroDisponible.setText(numLibrosDisponibles[0] + "");
        lblLibroNoDisponible.setText(numLibrosDisponibles[1] + "");
        lblLibroNuevo.setText(libros.size() + "");

        numLibrosAgregados = libros.size();
        jPanel2.setVisible(true);
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Modelo.Reporte repo = new Modelo.Reporte(numLibrosPrestados, autor, libro, numLibrosDisponibles, numLibrosAgregados, libros);
        controlador.exportarDatos(mes, repo, controlador.getDaoReporte().getAnio());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        this.dispose();
        new Seleccion();
    }//GEN-LAST:event_jLabel10MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListaMes;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblLibroDisponible;
    private javax.swing.JLabel lblLibroNoDisponible;
    private javax.swing.JLabel lblLibroNuevo;
    private javax.swing.JLabel lblLibroSolicitado;
    private javax.swing.JLabel lblLibrosPrestados;
    // End of variables declaration//GEN-END:variables
}
