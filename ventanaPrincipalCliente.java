/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javax.swing.JButton;
import javax.swing.JSpinner;

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
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PaneEntradas = new javax.swing.JScrollPane();
        tablaEntradas = new javax.swing.JTable();
        PanePlatoFuerte = new javax.swing.JScrollPane();
        tablaPlatosFuertes = new javax.swing.JTable();
        PanePostres = new javax.swing.JScrollPane();
        tablaPostres = new javax.swing.JTable();
        PaneBebidas = new javax.swing.JScrollPane();
        tablaBebidas = new javax.swing.JTable();
        btn_enviar = new javax.swing.JButton();
        ComboBox_tipo_envio = new javax.swing.JComboBox<>();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion", "Porciones", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEntradasMouseClicked(evt);
            }
        });
        PaneEntradas.setViewportView(tablaEntradas);

        jTabbedPane1.addTab("Entradas", PaneEntradas);

        tablaPlatosFuertes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion", "Porciones", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanePlatoFuerte.setViewportView(tablaPlatosFuertes);

        jTabbedPane1.addTab("Platos Fuertes", PanePlatoFuerte);

        tablaPostres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion", "Porciones", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanePostres.setViewportView(tablaPostres);

        jTabbedPane1.addTab("Postres", PanePostres);

        tablaBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion", "Porciones", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PaneBebidas.setViewportView(tablaBebidas);

        jTabbedPane1.addTab("Bebidas", PaneBebidas);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 600, 360));

        btn_enviar.setText("Enviar");
        btn_enviar.setMaximumSize(new java.awt.Dimension(126, 46));
        getContentPane().add(btn_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 560, -1, -1));

        ComboBox_tipo_envio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sitio", "Recoger", "Express" }));
        getContentPane().add(ComboBox_tipo_envio, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\yosua\\Desktop\\fondo.jpg")); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEntradasMouseClicked
   
    }//GEN-LAST:event_tablaEntradasMouseClicked

    
    
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

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_tipo_envio;
    private javax.swing.JScrollPane PaneBebidas;
    private javax.swing.JScrollPane PaneEntradas;
    private javax.swing.JScrollPane PanePlatoFuerte;
    private javax.swing.JScrollPane PanePostres;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JLabel fondo;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaBebidas;
    private javax.swing.JTable tablaEntradas;
    private javax.swing.JTable tablaPlatosFuertes;
    private javax.swing.JTable tablaPostres;
    // End of variables declaration//GEN-END:variables
}
