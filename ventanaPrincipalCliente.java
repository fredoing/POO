/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yosua
 */

public class ventanaPrincipalCliente extends javax.swing.JFrame {

    /**
     * Creates new form ventanaPrincipalCliente
     */
    
   
    public ventanaPrincipalCliente() {
       
        initComponents();
        Utilidades xml = new Utilidades();
        ArrayList<String[]> matriz1 = xml.crearMatriz("entrada");
        llenarTablaEntradas(matriz1);
        ArrayList<String[]> matriz2 = xml.crearMatriz("platofuerte");
        llenarTablaPlatoFuerte(matriz2);
        ArrayList<String[]> matriz3 = xml.crearMatriz("postre");
        llenarTablaPostres(matriz3);
        ArrayList<String[]> matriz4 = xml.crearMatriz("bebida");
        llenarTablaBebida(matriz4);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanePlatoFuerte = new javax.swing.JScrollPane();
        tablaPlatosFuertes = new javax.swing.JTable();
        PanePostres = new javax.swing.JScrollPane();
        tablaPostres = new javax.swing.JTable();
        PaneBebidas = new javax.swing.JScrollPane();
        tablaBebidas = new javax.swing.JTable();
        PaneEntradas = new javax.swing.JScrollPane();
        tablaEntradas = new javax.swing.JTable();
        botonElimiar = new javax.swing.JButton();
        ComboBox_tipo_envio = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPlatosFuertes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion"
            }
        ));
        PanePlatoFuerte.setViewportView(tablaPlatosFuertes);

        jTabbedPane1.addTab("Platos Fuertes", PanePlatoFuerte);

        tablaPostres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion"
            }
        ));
        PanePostres.setViewportView(tablaPostres);

        jTabbedPane1.addTab("Postres", PanePostres);

        tablaBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion"
            }
        ));
        PaneBebidas.setViewportView(tablaBebidas);

        jTabbedPane1.addTab("Bebidas", PaneBebidas);

        tablaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion"
            }
        ));
        tablaEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEntradasMouseClicked(evt);
            }
        });
        PaneEntradas.setViewportView(tablaEntradas);

        jTabbedPane1.addTab("Entradas", PaneEntradas);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 420, 410));

        botonElimiar.setText("Enviar");
        botonElimiar.setMaximumSize(new java.awt.Dimension(126, 46));
        getContentPane().add(botonElimiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, -1));

        ComboBox_tipo_envio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sitio", "Recoger", "Express" }));
        ComboBox_tipo_envio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_tipo_envioActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox_tipo_envio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Platillo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane2.addTab("Orden", jScrollPane1);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 260, 410));

        botonAgregar.setText("Agregar a la Orden");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, -1));

        botonEliminar.setText("Eliminar de la Orden");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, -1));

        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\yosua\\Desktop\\fondo.jpg")); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEntradasMouseClicked
   
    }//GEN-LAST:event_tablaEntradasMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void ComboBox_tipo_envioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_tipo_envioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_tipo_envioActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            
            new ventanaPrincipalCliente().setVisible(true);
            
        });
    }

    public void llenarTablaEntradas(ArrayList<String[]> matriz ){
        DefaultTableModel model = (DefaultTableModel) tablaEntradas.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(3);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<3;j++){
                tablaEntradas.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    public void llenarTablaPostres(ArrayList<String[]> matriz ){
        DefaultTableModel model = (DefaultTableModel) tablaPostres.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(3);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<3;j++){
                tablaPostres.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    public void llenarTablaPlatoFuerte(ArrayList<String[]> matriz ){
        DefaultTableModel model = (DefaultTableModel) tablaPlatosFuertes.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(3);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<3;j++){
                tablaPlatosFuertes.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    public void llenarTablaBebida(ArrayList<String[]> matriz ){
        DefaultTableModel model = (DefaultTableModel) tablaBebidas.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(3);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<3;j++){
                tablaBebidas.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_tipo_envio;
    private javax.swing.JScrollPane PaneBebidas;
    private javax.swing.JScrollPane PaneEntradas;
    private javax.swing.JScrollPane PanePlatoFuerte;
    private javax.swing.JScrollPane PanePostres;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonElimiar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaBebidas;
    private javax.swing.JTable tablaEntradas;
    private javax.swing.JTable tablaPlatosFuertes;
    private javax.swing.JTable tablaPostres;
    // End of variables declaration//GEN-END:variables
}
