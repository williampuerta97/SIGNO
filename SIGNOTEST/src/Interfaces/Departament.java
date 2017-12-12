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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jcPais = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPrefijoTel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/valle.gif"))); // NOI18N

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcPaisItemStateChanged(evt);
            }
        });
        jPanel1.add(jcPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 194, -1));

        jLabel3.setText("Prefijo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));
        jPanel1.add(txtPrefijoTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 194, -1));

        jLabel2.setText("Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 28, -1));

        jLabel4.setText("Pais");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 194, -1));
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 194, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate)
                            .addComponent(btnAdd)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(570, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
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
