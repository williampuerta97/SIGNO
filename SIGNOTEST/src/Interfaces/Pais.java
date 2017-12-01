/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Resources.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valentina
 */
public class Pais extends javax.swing.JInternalFrame {

   DefaultTableModel modelo;
   Connection cone;
   
    public Pais() {
        initComponents();
        cone = new Connection();
        actualizar();
        
        btnUpdate.setVisible(false);
    }
    
    public void cargarId(){
 
        try{
            
            
            ResultSet rs = cone.consultDB("SELECT max(idPais) FROM Pais");
            if(rs.next()){
             lblCode.setText((rs.getInt("max(idPais)")+1)+"");
             
            }
            
        }catch (Exception e){
            System.out.println("Error" + e);
        }
        
    }
    
    public void actualizar(){
        
        try {
      String[] registros = new String[4];
      String[] titulos = {"IdPais","Nombre","Nombre Corto","Indicativo"};
      
      modelo = new DefaultTableModel(null, titulos);
      
       ResultSet rs = cone.consultDB("SELECT * FROM Pais" );
       
            while(rs.next()){
                registros[0] = rs.getString("idPais");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("NombreCorto");
                registros[3] = rs.getString("Indicativo");
                
                modelo.addRow(registros);
            } 
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        cargarId();
    }
    
    public void cargar(String valor){
    
        try{
      String[] registros = new String[2];
      String[] titulos = {"IdPais","Nombre"};
      
      modelo = new DefaultTableModel(null, titulos);
      
       ResultSet rs = cone.consultDB("SELECT * FROM pais WHERE CONCAT (idPais,'',Nombre) LIKE ' %"+valor+"%'" );
       
            while(rs.next( )){
                registros[0] = rs.getString("IdPais");
                registros[1] = rs.getString("Nombre");
     
                modelo.addRow(registros);
     
            }
            
            jTable1.setModel(modelo);
            
        }catch (Exception e){
            System.out.println("Error"+e);
        }
            cargarId();
        }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        eliminar = new javax.swing.JMenuItem();
        modificar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtShortName = new javax.swing.JTextField();
        txtIndicative = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(eliminar);

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("IdPais");

        jLabel2.setText("Nombre");

        jLabel3.setText("Nombre corto");

        jLabel4.setText("Indicativo");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(txtShortName)
                            .addComponent(txtIndicative, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnAdd)
                        .addGap(75, 75, 75)
                        .addComponent(btnUpdate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtShortName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIndicative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        cone.modifyDB("INSERT INTO pais VALUES(null,' "+txtName.getText()+" ',' "+txtShortName.getText()+" ',' "+txtIndicative.getText()+" ')");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String nombre = txtName.getText();
        String nomcorto = txtShortName.getText();
        int Id = Integer.parseInt(lblCode.getText());
        String Indicativo = txtIndicative.getText();
       
        try {
        cone.modifyDB("UPDATE pais SET Nombre=' "+nombre+" ',NombreCorto=' "+nomcorto+" ',Indicativo=' "+Indicativo+" ' WHERE idPais="+Id);    
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
        
        
        cargar("");
        actualizar();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
     int row = jTable1.getSelectedRow();
     
        try {
            cone.modifyDB("DELETE FROM pais WHERE idPais="+ jTable1.getValueAt(row, 0));
            actualizar();
            JOptionPane.showMessageDialog(rootPane, "el estudiantes a sido eliminado");
            
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
       btnUpdate.setVisible(true);
       
       int row = jTable1.getSelectedRow();
       
        try {
            ResultSet rs = cone.consultDB("SELECT * FROM pais WHERE idPais="+jTable1.getValueAt(row, 0));
            
            rs.next();
            lblCode.setText(rs.getString("idPais"));
            txtName.setText(rs.getString("Nombre"));
            txtShortName.setText(rs.getString("NombreCorto"));
            txtIndicative.setText(rs.getString("Indicativo"));
            
            
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }//GEN-LAST:event_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCode;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTextField txtIndicative;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtShortName;
    // End of variables declaration//GEN-END:variables
}