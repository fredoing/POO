/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yosua
 */

public class ventanaPrincipalCliente extends javax.swing.JFrame {
    DefaultTableModel m;
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

        jDialog2 = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanePostres = new javax.swing.JScrollPane();
        tablaPostres = new javax.swing.JTable();
        PaneBebidas = new javax.swing.JScrollPane();
        tablaBebidas = new javax.swing.JTable();
        PaneEntradas = new javax.swing.JScrollPane();
        tablaEntradas = new javax.swing.JTable();
        PanePlatoFuerte = new javax.swing.JScrollPane();
        tablaPlatosFuertes = new javax.swing.JTable();
        botonElimiar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrden = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPostres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                "Nombre", "Calorias", "Piezas por porcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PaneBebidas.setViewportView(tablaBebidas);

        jTabbedPane1.addTab("Bebidas", PaneBebidas);

        tablaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Calorias", "Piezas por porcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                "Nombre", "Calorias", "Piezas por porcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanePlatoFuerte.setViewportView(tablaPlatosFuertes);

        jTabbedPane1.addTab("Platos Fuertes", PanePlatoFuerte);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 420, 410));

        botonElimiar.setText("Enviar");
        botonElimiar.setMaximumSize(new java.awt.Dimension(126, 46));
        getContentPane().add(botonElimiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, -1));

        tablaOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Platillo", "Cantidad", "Calorias", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaOrden);

        jTabbedPane2.addTab("Orden", jScrollPane1);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 400, 410));

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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Total de calorias:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 50, 20));

        jLabel3.setText("Precio total:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, -1));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 260, 50));

        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\yosua\\Desktop\\fondo.jpg")); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEntradasMouseClicked
   
    }//GEN-LAST:event_tablaEntradasMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        
         
        
        
        
        
        
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        
        int filaEntrada = tablaEntradas.getSelectedRow();
        int filaPlatoFuerte = tablaPlatosFuertes.getSelectedRow();
        int filaPostre = tablaPostres.getSelectedRow();
        int filaBebida = tablaBebidas.getSelectedRow();
        
        
        try{
            if(filaEntrada == -1 && filaPlatoFuerte == -1 && filaPostre == -1 && filaBebida == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un platillo","Advertencia", JOptionPane.WARNING_MESSAGE);
            }else{
                String cantidadPorciones = JOptionPane.showInputDialog(null,"¿Cuantas porciones quieres?");
                String nombre="";
                String calorias="";
                String precio="";
                if(filaEntrada!= -1){
                    System.out.println("entradaa");
                     nombre = (String) tablaEntradas.getValueAt(filaEntrada, 0);
                     calorias = (String) tablaEntradas.getValueAt(filaEntrada, 1);
                     precio = (String) tablaEntradas.getValueAt(filaEntrada, 3);
                     //int x = (Integer.parseInt(precio) * Integer.parseInt(cantidadPorciones)); // Esta variable guarda el precio * cantidad de porciones.
                     //System.out.println(x);
                     //String subtotal = x.toString();
                     filaEntrada = -1;
                     DefaultTableModel model = (DefaultTableModel) tablaOrden.getModel();
                    String fila[] = {nombre,calorias,cantidadPorciones,precio};
                    model.addRow(fila);
                    tablaEntradas.clearSelection();
                }else if(filaPlatoFuerte!= -1){
                    System.out.println("platofuerte");
                     nombre = (String) tablaPlatosFuertes.getValueAt(filaPlatoFuerte, 0);
                     calorias = (String) tablaPlatosFuertes.getValueAt(filaPlatoFuerte, 1);
                     precio = (String) tablaPlatosFuertes.getValueAt(filaPlatoFuerte, 3);
                    // Integer x = (Integer.parseInt(precio) * Integer.parseInt(cantidadPorciones)); // Esta variable guarda el precio * cantidad de porciones.
                     filaPlatoFuerte = -1;
                     DefaultTableModel model = (DefaultTableModel) tablaOrden.getModel();
                    String fila[] = {nombre,calorias,cantidadPorciones,precio};
                    model.addRow(fila);
                    tablaPlatosFuertes.clearSelection();
                }else if(filaPostre!= -1){
                    System.out.println("postre");
                     nombre = (String) tablaPostres.getValueAt(filaPostre, 0);
                     calorias = (String) tablaPostres.getValueAt(filaPostre, 1);
                     precio = (String) tablaPostres.getValueAt(filaPostre, 3);
                     //Integer x = (Integer.parseInt(precio) * Integer.parseInt(cantidadPorciones)); // Esta variable guarda el precio * cantidad de porciones.
                     filaPostre =-1;
                    DefaultTableModel model = (DefaultTableModel) tablaOrden.getModel();
                    String fila[] = {nombre,calorias,cantidadPorciones,precio};
                    model.addRow(fila);
                    tablaPostres.clearSelection();
                }else if(filaBebida!= -1){
                    System.out.println("bebida");
                     nombre = (String) tablaBebidas.getValueAt(filaBebida, 0);
                     calorias = (String) tablaBebidas.getValueAt(filaBebida, 1);
                     precio = (String) tablaBebidas.getValueAt(filaBebida, 3);
                     //Integer x = (Integer.parseInt(precio) * Integer.parseInt(cantidadPorciones)); // Esta variable guarda el precio * cantidad de porciones.
                     filaBebida = -1;
                     DefaultTableModel model = (DefaultTableModel) tablaOrden.getModel();
                    String fila[] = {nombre,calorias,cantidadPorciones,precio};
                    model.addRow(fila);
                    tablaBebidas.clearSelection();
                }
                
                // Calculos 
                
                
                
                        
            }
        } catch(Exception e){
            
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    
    
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
        model.setColumnCount(4);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<4;j++){
                tablaEntradas.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    public void llenarTablaPostres(ArrayList<String[]> matriz ){
        DefaultTableModel model = (DefaultTableModel) tablaPostres.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(4);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<4;j++){
                tablaPostres.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    public void llenarTablaPlatoFuerte(ArrayList<String[]> matriz ){
        DefaultTableModel model = (DefaultTableModel) tablaPlatosFuertes.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(4);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<4;j++){
                tablaPlatosFuertes.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    public void llenarTablaBebida(ArrayList<String[]> matriz ){
        DefaultTableModel model = (DefaultTableModel) tablaBebidas.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(4);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<4;j++){
                tablaBebidas.setValueAt(matriz.get(i)[j], i, j);
            }
       }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PaneBebidas;
    private javax.swing.JScrollPane PaneEntradas;
    private javax.swing.JScrollPane PanePlatoFuerte;
    private javax.swing.JScrollPane PanePostres;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonElimiar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JLabel fondo;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tablaBebidas;
    private javax.swing.JTable tablaEntradas;
    private javax.swing.JTable tablaOrden;
    private javax.swing.JTable tablaPlatosFuertes;
    private javax.swing.JTable tablaPostres;
    // End of variables declaration//GEN-END:variables
}
