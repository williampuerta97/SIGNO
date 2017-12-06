/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS SE7EN
 */
public class Period extends javax.swing.JInternalFrame {
    
    Connection con;
    DefaultTableModel modelo;
    int temp2 = 0;
    
    public Period() {
        initComponents();
        con = new Connection();
        loadPercent();   
        consultDB();
    }
    
    public void disableElements(){
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
        String titulos[] = {"ID_PERIODO", "NOMBRE", "PORCENTAJE"};
        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[3];
        
        try {
            ResultSet rs = con.consultDB("SELECT idperiodo, Nombre, Porcentaje FROM periodo");

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
        ResultSet rs = con.consultDB("select sum(porcentaje) from periodo");
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
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spiPercent = new javax.swing.JSpinner();
        lblPercent = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("CREACIÓN DE PERIODOS");

        jLabel2.setText("NOMBRE");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("PORCENTAJE");

        spiPercent.setModel(new javax.swing.SpinnerNumberModel(1, 1, 200, 1));

        lblPercent.setText("000");

        jLabel5.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(98, 98, 98)
                .addComponent(jButton2)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spiPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPercent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spiPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
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
             con.modifyDB("insert into periodo( idperiodo, Nombre, Porcentaje) values(null, '"+txtName.getText()+"',"+percent+")");
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
            con.modifyDB("DELETE FROM periodo WHERE idperiodo= '" + value + "'");
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPercent;
    private javax.swing.JSpinner spiPercent;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
