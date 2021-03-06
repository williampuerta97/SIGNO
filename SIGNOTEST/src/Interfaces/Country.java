/* MODULO DE CREACION DE PAIS */
package Interfaces;

import Resources.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/* @author Grupo prueba y calidad  */
public class Country extends javax.swing.JInternalFrame {

   DefaultTableModel modelo;
   Connection cone;
   
   /**
 @author Grupo prueba y calidad 
 @version 1.0 
 Constructor para iniciar la conexion a la base de datos,iniciar el metodo actualizar de la tabla y deshabilitar el boton actualizar en la interfaz.
 
*/
    public Country() {
        initComponents();
        setSize(1237,629);
        setLocation(0,0);
        cone = new Connection();
        update();        
        btnUpdate.setVisible(false);
    }
 
    
/**
 @author Grupo prueba y calidad 
 @version 1.0 
 Metodo que genera el ID o identificacion de cada pais que se registre en la base de datos.
*/
    
    public void chargeId(){
 
        try{
            
            
            ResultSet rs = cone.consultDB("SELECT max(idPais) FROM Pais");
            if(rs.next()){
             lblCode.setText((rs.getInt("max(idPais)")+1)+"");
             
            }
            
        }catch (Exception e){
            System.out.println("Error" + e);
        }
        
    }
    
    
    /**
 @author Grupo prueba y calidad 
 @version 1.0 
 Metodo que reestablece los datos de la tabla al ser modificada por un usuario.
*/
    public void update(){
        
        try {
      String[] registros = new String[4];
      String[] titulos = {"Id","Nombre","Nombre Corto","Indicativo"};
      
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
        chargeId();
    }
    
    /**
 @author Grupo prueba y calidad 
 @version 1.0 
 Metodo que tiene la funcion de cargar nuevamente la tabla con datos al ser actualizada.
 @param valor El parametro valor es el que contiene el dato que genera la consulta en la base de datos especificamente en la tabla pais.
*/
    public void charge(String valor){
    
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
            chargeId();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtShortName = new javax.swing.JTextField();
        txtIndicative = new javax.swing.JTextField();

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

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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

        btnAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregarpng.png"))); // NOI18N
        btnAdd.setText("AGREGAR");
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.setBorder(null);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MapaMund.gif"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("IdPais");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setText("Nombre corto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel4.setText("Indicativo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lblCode.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(lblCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 150, 14));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 80, 270, -1));
        jPanel1.add(txtShortName, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 120, 270, -1));
        jPanel1.add(txtIndicative, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 170, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5)))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 179, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd))))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        cone.modifyDB("INSERT INTO pais VALUES(null,'"+txtName.getText()+"','"+txtShortName.getText()+"','"+txtIndicative.getText()+"')");
        JOptionPane.showMessageDialog(rootPane, "El pais ha sido registrado exitosamente");
        
        charge("");
        update();
        txtName.setText("");
        txtShortName.setText("");
        txtIndicative.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String nombre = txtName.getText();
        String nomcorto = txtShortName.getText();
        int Id = Integer.parseInt(lblCode.getText());
        String Indicativo = txtIndicative.getText();
       
        try {
        cone.modifyDB("UPDATE pais SET Nombre=' "+nombre+" ',NombreCorto=' "+nomcorto+" ',Indicativo=' "+Indicativo+" ' WHERE idPais="+Id); 
        
        JOptionPane.showMessageDialog(rootPane, "El pais ha sido actualizado exitosamente");
            
        
        } catch (Exception e) {
            System.out.println("Error"+ e);
            
        }        
        charge("");
        update();               
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
     int row = jTable1.getSelectedRow();
     
        try {
            cone.modifyDB("DELETE FROM pais WHERE idPais="+ jTable1.getValueAt(row, 0));
            update();
            JOptionPane.showMessageDialog(rootPane, "el Pais ha sido eliminado");
            
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
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
