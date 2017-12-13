package Interfaces;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Resources.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/* @author 1354951 */
public class periodo extends javax.swing.JInternalFrame {
    
    Connection cone;
    DefaultTableModel modelo;
    int temp2 = 0;
    
    public periodo() {
        initComponents();
        setSize(1237,629);
        setLocation(0,0);
        cone = new Connection();
        loadPercent();   
        consultDB();
    }
    
    public void disableElements(){
     
    /*
    @autor:Bases de datos
    @version:1.0
    @metodo: Se deshabilita los campos cuado se sobrepasa del porcentaje establecido(100%)       
    */

            if (temp2 <=0) {
            txtName.setEnabled(false);
            spiPercent.setEnabled(false);
            jButton2.setEnabled(false);
        JOptionPane.showMessageDialog(rootPane, "Ya ha superado el máximo de porcentaje por periodo");
        }else{
             txtName.setEnabled(true);
             spiPercent.setEnabled(true);
             jButton2.setEnabled(true);
        }
    }
    
    public void consultDB(){
     /*
    @autor:Bases de datos
    @version:1.0
    @metodo:Consulta los datos de la tabla periodo y muestra los datos que se encuentran en ella 
    */
        String titulos[] = {"ID_PERIODO", "NOMBRE", "PORCENTAJE"};
        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[3];
        
        try {
            ResultSet rs = cone.consultDB("SELECT idperiodo, Nombre, Porcentaje FROM periodo");

            while (rs.next()) {
                fila[0] = rs.getString("idperiodo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("Porcentaje");
                

                modelo.addRow(fila);
                
            }
            jTable1.setModel(modelo);
            loadPercent();
            disableElements();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    public int loadPercent(){
     
    /*
    @autor:Bases de datos
    @version:1.0
    @metodo: Consulta y suma los datoa de la tabla periodo y obtiene el porcentaje
    */
        ResultSet rs = cone.consultDB("select sum(porcentaje) from periodo");
        int temp=0;
        try {
            if(rs.next())
             temp = rs.getInt("sum(porcentaje)");
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        temp2 = 100-temp;
        lblPercent.setText(""+temp2);
        return temp2;
    }
    
//   public void eliminar(JTable jTable1) {
//        modelo = (DefaultTableModel) jTable1.getModel();
//        int fila = jTable1.getSelectedRow();
//        if (fila >= 0) {
//           int []filasselec  = jTable1.getSelectedRows();
//           for (int i=0; i<filasselec.length;i++)
//           {
//            modelo.removeRow(filasselec[i]);
//            
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
//        }
//    }
       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spiPercent = new javax.swing.JSpinner();
        lblPercent = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREACIÓN DE PERIODOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        jButton1.setText("ACTUALIZAR");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregarpng.png"))); // NOI18N
        jButton2.setText("AGREGAR");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("NOMBRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 49, -1, -1));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 46, 177, -1));

        jLabel3.setText("PORCENTAJE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        spiPercent.setModel(new javax.swing.SpinnerNumberModel(1, 1, 200, 1));
        jPanel1.add(spiPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 110, 80, 28));

        lblPercent.setText("000");
        jPanel1.add(lblPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, 28));

        jLabel5.setText("%");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 144, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/calendario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultDB();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int temp2 = loadPercent();
        int percent = (int) spiPercent.getValue();
        if (percent <= temp2) {
             cone.modifyDB("insert into periodo( idperiodo, Nombre, Porcentaje) values(null, '"+txtName.getText()+"',"+percent+")");
         //  cone.modifyDB("insert into periodo( idperiodo, Nombre, Porcentaje) values(null, "+txtName.getText()+","+percent+")");  
           consultDB();
             JOptionPane.showMessageDialog(null, "Se agregó el dato exitosamente");
        }else{
            JOptionPane.showMessageDialog(rootPane, "Error, el valor no puede ser mayor a "+temp2);
        }
       loadPercent();
       disableElements();
        System.out.println(temp2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //eliminar(jTable1);
        
        int fila = jTable1.getSelectedRow();
        String value = jTable1.getValueAt(fila, 0).toString();
        
        if (fila >= 0) {
            cone.modifyDB("DELETE FROM periodo WHERE idperiodo= '" + value + "'");
            JOptionPane.showMessageDialog(rootPane, "Dato eliminado");
        }
        
        consultDB();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPercent;
    private javax.swing.JSpinner spiPercent;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
