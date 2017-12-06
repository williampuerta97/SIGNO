/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Resources.*;

/**
 *
 * @author usuario
 */
public class Events extends javax.swing.JInternalFrame {
    //DECLARAMOS LAS VARIABLES GLOBALES//
    DefaultTableModel model;
    Connection con;
    String id;
    /**
     * Creates new form subjects
     */
    public Events() {
        
        initComponents();
        con = new Connection();
        Load("");
        txtRoute.setVisible(false);
        btnUpdate.setEnabled(false);
        id();
        lbId.setVisible(false);
    }
   //DECLARAMOS LOS CAMPOS, LA CONSULTA Y LOS CAMPOS A TRAER Y SU RESPECTIVA POSICION//
void Load(String valor){
      int act = 1;
      String [] Titles={"ID","Nombre","Descripcion","Fecha","Imagen"}; 
      String [] Registry = new String[5];
      
      String sql ="SELECT * FROM evento where Activo = '"+act+"' AND Nombre LIKE '%"+valor+"%'";
      model = new DefaultTableModel(null,Titles);
      
      try {
             ResultSet rs = con.consultDB(sql);
             if(act == 1){
                while(rs.next()){
                    Registry[0]=rs.getString("idEvento");
                    Registry[1]=rs.getString("Nombre");
                    Registry[2]=rs.getString("Descripcion");
                    Registry[3]=rs.getString("Fecha");
                    Registry[4]=rs.getString("Imagen");   
                    model.addRow(Registry);

                }
             }
        
             tbEvents.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
   
    }
//DELCARAMOS EL ROW PARA CUANDO SE SELECIONE UN CAMPO A ACTUALIZAR//
 public void selectUpdate() {
        Connection cone2 = new Connection();
        
        int selectRow;

        selectRow = tbEvents.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(null, "no ha seleccionado ninguna fila");
        } else {
            try {
                
                id = (String) model.getValueAt(tbEvents.getSelectedRow(), 0);
                ResultSet rs = cone2.consultDB("select * from evento where idEvento  = '" + id+"'");

                if (rs.next()) {
                    txtTitle.setText(rs.getString("Nombre"));
                    txtDescription.setText(rs.getString("Descripcion"));
                    txtDate.setDate(rs.getDate("Fecha"));
                    txtImage.setText(rs.getString("Imagen"));
                    
                    
                } else {
                    JOptionPane.showMessageDialog(rootPane, "El codigo no existe");
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex);
            }
        }
    }
// METODO PARA LIMPIAR LA INTERFAS//
    public void clear() {
        txtTitle.setText("");
        txtDescription.setText("");
        
        

    }
// METODO PARA QUE LO CAMPOS REGRESEN A ALA POSICION DE REGISTRAR CON EL FIN DE SER ACTUALIZADOS//
    public void updateTable() {
        
        String formato = txtDate.getDateFormatString();
        Date date = (Date) txtDate.getDate();
        SimpleDateFormat formt = new SimpleDateFormat(formato);
        String Dates = String.valueOf(formt.format(date));
        id = (String) model.getValueAt(tbEvents.getSelectedRow(), 0);
       
       int responsable=1111;
        con.modifyDB("UPDATE evento SET Nombre='" + txtTitle.getText()+ "',"
                + " Descripcion='" + txtDescription.getText() + "', Fecha='"+Dates+
                "', Imagen='"+txtRoute.getText()+"', Responsable="+responsable
                + " WHERE idEvento="+id);
        JOptionPane.showMessageDialog(null, "Actualización Exitosa");

    }
    //METODO PARA INACTIVAR LOS CAMPOS //
     public void inactivation() {
        
       
       id = (String) model.getValueAt(tbEvents.getSelectedRow(), 0);
        con.modifyDB("UPDATE evento SET Activo= '0' WHERE idEvento="+id);
        JOptionPane.showMessageDialog(null, "Inactivación Exitosa");

    }
// METODO QUE MOSTRARA LOS CAMPOS INACTIVOS//
    void inactivos(){
      int inactivo = 0;
      String [] Titles={"ID","Nombre","Descripcion","Fecha","Imagen"}; 
      String [] Registry = new String[5];
      
      String sql ="SELECT * FROM evento where Activo = '"+ inactivo+"'";
      model = new DefaultTableModel(null,Titles);
      
      //conectar cc=new conectar();
      //Connection cn = cc.conexion();
      try {
             ResultSet rs = con.consultDB(sql);
             if(inactivo == 0){
                while(rs.next()){
                    Registry[0]=rs.getString("idEvento");
                    Registry[1]=rs.getString("Nombre");
                    Registry[2]=rs.getString("Descripcion");
                    Registry[3]=rs.getString("Fecha");
                    Registry[4]=rs.getString("Imagen");   
                    model.addRow(Registry);

                }
             }
        
             tbEvents.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
   
    }
    
    public void id(){
         ResultSet rs = con.consultDB("select MAX(idEvento) from evento");
            try {
                if(rs.next()){
                    int num = rs.getInt("MAX(idEvento)");
                    if(num == 0){
                        lbId.setText(1 +""); 
                    }else{
                        lbId.setText((num+1) + "");
                    }
    }
            } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popSubjects = new javax.swing.JPopupMenu();
        popUpdate = new javax.swing.JMenuItem();
        popInactivate = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnSelectImage = new javax.swing.JButton();
        txtRoute = new javax.swing.JTextField();
        txtDate = new com.toedter.calendar.JDateChooser();
        lbId = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEvents = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtImage = new javax.swing.JLabel();
        btnon = new javax.swing.JButton();
        btnoff = new javax.swing.JButton();

        popUpdate.setText("Modificar");
        popUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popUpdateActionPerformed(evt);
            }
        });
        popSubjects.add(popUpdate);

        popInactivate.setText("Inactivación");
        popInactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popInactivateActionPerformed(evt);
            }
        });
        popSubjects.add(popInactivate);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EVENTOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Titulo de evento");

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Fecha de Evento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Descripcion");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Cargar Imagen");

        btnSelectImage.setText("Cargar");
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        txtRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRouteActionPerformed(evt);
            }
        });

        txtDate.setDateFormatString("yyyy/dd/MM/");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSelectImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRoute))
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelectImage)
                            .addComponent(jLabel6)
                            .addComponent(txtRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnInsert.setText("REGISTRAR");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tbEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbEvents.setComponentPopupMenu(popSubjects);
        jScrollPane1.setViewportView(tbEvents);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Buscar:");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnon.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnon.setText("Activos");
        btnon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnonActionPerformed(evt);
            }
        });

        btnoff.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnoff.setText("Inactivos");
        btnoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnoff, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnon, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnon)
                                .addGap(27, 27, 27)
                                .addComponent(btnoff)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        txtTitle.transferFocus();
    }//GEN-LAST:event_txtTitleActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        
            
           
                    int responsable;
                    // COMANDOS PARA EL MANEJO DE LA FECHA //
                    String formato = txtDate.getDateFormatString();
                    Date date = (Date) txtDate.getDate();
                    responsable = 1111;
                    SimpleDateFormat formt = new SimpleDateFormat(formato);
                    String Dates = String.valueOf(formt.format(date));
                    // METODO PARA INSERTAR LOS DATOS//
                    con.modifyDB("INSERT INTO evento VALUES (" + lbId.getText() + ",'" + txtTitle.getText() +"',"
                            + "'" + txtDescription.getText() +"','"+ Dates  + "','" + txtRoute.getText() + "'"
                            + ",'" + responsable + "',1)");
        try {
            FileInputStream archivofoto = new FileInputStream(txtRoute.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }
                    JOptionPane.showMessageDialog(rootPane, "REGISTRADO EXITOSAMENTE");
                    txtRoute.setText(null);
                    txtImage.setIcon(null);
                    Load("");
                    id();
                    clear();
                
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateTable();
        btnUpdate.setEnabled(false);
        btnInsert.setEnabled(true);
        Load("");
        clear();
    }//GEN-LAST:event_btnUpdateActionPerformed

    
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
    Load(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        // METODO PARA SELECIONAR IMAGEN //
        JFileChooser archivo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg","jpeg");
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File Route = new File("D:");
        archivo.setCurrentDirectory(Route);
        int ventana = archivo.showOpenDialog(null);
        
        if(ventana == JFileChooser.APPROVE_OPTION)
            {
            File File = archivo.getSelectedFile();
            txtRoute.setText(String.valueOf(File));
            Image foto = getToolkit().getImage(txtRoute.getText());
            foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            txtImage.setIcon(new ImageIcon(foto));
           
        }   
                
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void popInactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popInactivateActionPerformed
        inactivation();
        Load("");
    }//GEN-LAST:event_popInactivateActionPerformed

    private void popUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popUpdateActionPerformed
        btnUpdate.setEnabled(false);
        selectUpdate();
        
    }//GEN-LAST:event_popUpdateActionPerformed

    private void btnonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnonActionPerformed
        Load("");
    }//GEN-LAST:event_btnonActionPerformed

    private void btnoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoffActionPerformed
        inactivos();
    }//GEN-LAST:event_btnoffActionPerformed

    private void txtRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRouteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRouteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnoff;
    private javax.swing.JButton btnon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbId;
    private javax.swing.JMenuItem popInactivate;
    private javax.swing.JPopupMenu popSubjects;
    private javax.swing.JMenuItem popUpdate;
    private javax.swing.JTable tbEvents;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JLabel txtImage;
    private javax.swing.JTextField txtRoute;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
