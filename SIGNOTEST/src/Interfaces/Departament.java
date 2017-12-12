/* MODULO DE CREACION DE DEPARTAMENTO */
package Interfaces;

import Resources.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo prueba y calidad
 */
public class Departament extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo;
    Connection cone;
    String idPais[];
    
      /**
 @author Grupo prueba y calidad 
 @version 1.0 
 Constructor para iniciar la conexion a la base de datos, iniciar el metodo actualizar de la tabla, el metodo que carga los departamentos de la base de datos y deshabilitar el boton actualizar en la interfaz.
*/
    
    public Departament() {
        initComponents();
        setSize(1237,629);
        setLocation(0,0);
        cone = new Connection();
        update();
        chargeCountry();
        btnUpdate.setVisible(false);
    }
    
        
/**
 @author Grupo prueba y calidad 
 @version 1.0 
 Metodo que genera el ID o identificacion de cada departamento que se registre en la base de datos.
*/
    
    public void chargeId(){
 
        try{
            
            
            ResultSet rs = cone.consultDB("SELECT max(idDepartamento) FROM departamento");
            if(rs.next()){
             lblId.setText((rs.getInt("max(idDepartamento)")+1)+"");
             
            }
            
        }catch (Exception e){
            System.out.println("Error" + e);
        }
        
    }
       /**
 @author Grupo prueba y calidad 
 @version 1.0 
 Metodo que reestablece los datos de la tabla al ser modificada por el usuario.
*/
    
    public void update(){
        
        try {
      String[] registros = new String[4];
      String[] titulos = {"IdDepartamento","Nombre","Prefijo Telefonico", "Pais_id"};
      
      modelo = new DefaultTableModel(null, titulos);
      
       ResultSet rs = cone.consultDB("SELECT * FROM Departamento" );
       
            while(rs.next()){
                registros[0] = rs.getString("idDepartamento");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("PrefijoTelefonico");
                registros[3] = rs.getString("Pais_id");
                
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
 @param valor El parametro valor es el que contiene el dato que genera la consulta en la base de datos especificamente en la tabla departamento.
*/
    public void charge(String valor){
    
        try{
      String[] registros = new String[2];
      String[] titulos = {"IdDepartamento","Nombre"};
      
      modelo = new DefaultTableModel(null, titulos);
      
       ResultSet rs = cone.consultDB("SELECT * FROM Departamento WHERE CONCAT (idDepartamento,'',Nombre) LIKE ' %"+valor+"%'" );
       
            while(rs.next( )){
                registros[0] = rs.getString("IdDepartamento");
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
 @author Grupo prueba y calidad 
 @version 1.0 
 Metodo que devuelve el nombre de los paises existentes en la base de datos signo_db y los carga en el jcombobox.
*/
    public void chargeCountry() {
        
        try {
            ResultSet resul = cone.consultDB("SELECT COUNT(*) cuenta FROM pais");
            if(resul.next()){
                idPais = new String[resul.getInt("cuenta")];
            }
         } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        try {
            int i = 0;
            ResultSet rs=cone.consultDB("SELECT idPais,Nombre FROM pais");
            
            while (rs.next()) {
             idPais[i] = rs.getString("idPais");
            System.out.println(idPais[i]);
            jcPais.addItem(rs.getString("Nombre"));
            i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        eliminar = new javax.swing.JMenuItem();
        modificar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jcPais = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPrefijoTel = new javax.swing.JTextField();

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

        jLabel1.setText("Nombre");

        jLabel2.setText("Id");

        jLabel4.setText("Pais");

        jcPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcPaisItemStateChanged(evt);
            }
        });

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

        jLabel3.setText("Prefijo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcPais, 0, 194, Short.MAX_VALUE)
                            .addComponent(txtPrefijoTel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrefijoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int pos = (int) jcPais.getSelectedIndex();
        String pais = (String) jcPais.getSelectedItem();
        System.out.println(pos);
        cone.modifyDB("INSERT INTO Departamento VALUES (NULL, '" +txtName.getText()+ "', '" +txtPrefijoTel.getText()+ "' , '" +idPais[pos]+"')");
        JOptionPane.showMessageDialog(rootPane, "El Departamento ha sido registrado exitosamente");
        
        charge("");
        update();
    }//GEN-LAST:event_btnAddActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();  
        
        try {
            cone.modifyDB("DELETE FROM departamento WHERE idDepartamento="+jTable1.getValueAt(row, 0));
            update();
            JOptionPane.showMessageDialog(rootPane, "El Departamento ha sido eliminado");
            
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
      btnUpdate.setVisible(true);
       
       int row = jTable1.getSelectedRow();
       
        try {
            ResultSet rs = cone.consultDB("SELECT * FROM departamento INNER JOIN pais ON pais.idPais= departamento.Pais_id  WHERE idDepartamento="+jTable1.getValueAt(row, 0)+" ");
            
            rs.next();
            lblId.setText(rs.getString("idDepartamento"));
            txtName.setText(rs.getString("departamento.Nombre"));
            txtPrefijoTel.setText(rs.getString("PrefijoTelefonico"));
            jcPais.setSelectedItem(rs.getString("pais.Nombre"));
           
            
            
        } catch (Exception e) {
            System.out.println("Error"+e);
        }  
      
    }//GEN-LAST:event_modificarActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String nombre = txtName.getText();
        String Prefijo = txtPrefijoTel.getText();
        int Id = Integer.parseInt( lblId.getText());
        int pos = jcPais.getSelectedIndex();
        
        try {
            cone.modifyDB("UPDATE Departamento SET Nombre=' "+nombre+" ',PrefijoTelefonico= "+Prefijo+", Pais_id = "+idPais[pos]+" WHERE idDepartamento="+Id);
            
        JOptionPane.showMessageDialog(rootPane, "El Departamento ha sido actualizado exitosamente");
        
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
        
        
        charge("");
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jcPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcPaisItemStateChanged
         int pos = jcPais.getSelectedIndex();
         System.out.println(idPais[pos]);
    }//GEN-LAST:event_jcPaisItemStateChanged


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
    private javax.swing.JComboBox<String> jcPais;
    private javax.swing.JLabel lblId;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrefijoTel;
    // End of variables declaration//GEN-END:variables
}
