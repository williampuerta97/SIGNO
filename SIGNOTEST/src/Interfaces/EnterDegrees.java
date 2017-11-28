/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import extras.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo diseño
 * @version 1.0
 */
public class EnterDegrees extends javax.swing.JInternalFrame {

    /**
     * @author Grupo diseño
     * @version 1.0
     * Crea una nueva ventana para el ingreso de grados
     */
    Connection con;
    DefaultTableModel model;
    String id = "";
    
    /**
     * @author Grupo diseño
     * @version 1.0
     * Método constructor de la clase EnterDegrees, instanciando la clase
     * de la conexión a la base de datos, escribiendo el método de cargar la tabla,
     * vaciando los campos del frame y deshabilitando el botón de actualizar
     */
    public EnterDegrees() {
        initComponents();
        con = new Connection();
        loadTable("");
        emptyFields();
        btnUpdate.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        miModify = new javax.swing.JMenuItem();
        miDelete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNuip = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbSearch = new javax.swing.JLabel();
        lbNameDirector = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rbMorning = new javax.swing.JRadioButton();
        rbAfternoon = new javax.swing.JRadioButton();
        txtGroupName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        miModify.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        miModify.setText("Modificar");
        miModify.setComponentPopupMenu(jPopupMenu1);
        miModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miModifyActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miModify);

        miDelete.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        miDelete.setText("Eliminar");
        miDelete.setComponentPopupMenu(jPopupMenu1);
        miDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miDelete);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("GRADOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Director:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Nombre:");

        txtNuip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuipActionPerformed(evt);
            }
        });

        lbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscador-de-lupa.png"))); // NOI18N
        lbSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbSearchMousePressed(evt);
            }
        });

        lbNameDirector.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNameDirector)
                    .addComponent(txtNuip, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNuip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbSearch))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbNameDirector))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Jornada:");

        buttonGroup1.add(rbMorning);
        rbMorning.setText("Mañana");

        buttonGroup1.add(rbAfternoon);
        rbAfternoon.setText("Tarde");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Nombre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(rbMorning)
                        .addGap(17, 17, 17)
                        .addComponent(rbAfternoon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbMorning)
                        .addComponent(jLabel3))
                    .addComponent(rbAfternoon))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnRegister.setText("REGISTRAR");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tbData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbData.setComponentPopupMenu(jPopupMenu1);
        tbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbData);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Buscar:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addGap(151, 151, 151)
                        .addComponent(btnUpdate)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegister)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         String code = txtNuip.getText();
        String name = txtGroupName.getText();
        String type = "";
        if(rbMorning.isSelected()){
            type = "Mañana";
        }else{
            type = "Tarde";
        }
            
        try {
            con.modifyDB("UPDATE grupo SET Director = "+ code +", Jornada = '"+ type +"', "
                    + "Nombre = '"+ name +"' WHERE idGrupo = "+id);
            JOptionPane.showMessageDialog(rootPane, "GRUPO ACTUALIZADO EXITOSAMENTE");
            loadTable("");
        } catch (Exception e) {
        }
        btnRegister.setEnabled(true);
        btnUpdate.setEnabled(false);
        emptyFields();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNuipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNuipActionPerformed

    private void lbSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearchMousePressed
        String code = txtNuip.getText();
        try {
            ResultSet rs = con.consultDB("SELECT CONCAT(usu.PrimerNombre, "
                    + "' ', usu.PrimerApellido) as Nombre "
                    + "FROM usuario as usu "
                    + "INNER JOIN docente as doc "
                    + "ON usu.Nuip = doc.Codigo "
                    + "WHERE doc.Codigo = "+ code  
                    +" AND doc.Activo = 1");
            if(rs.next()){
                lbNameDirector.setText(rs.getString("Nombre"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lbSearchMousePressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String value = txtSearch.getText();
        loadTable(value);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataMouseClicked
        if(evt.getButton() == 3){
            jPopupMenu1.show(this, evt.getX(), evt.getY());
            
        }
    }//GEN-LAST:event_tbDataMouseClicked

    private void miModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miModifyActionPerformed
        int row =  tbData.getSelectedRow();
         id = (String) tbData.getValueAt(row, 0);
        try {
            ResultSet rs = con.consultDB("SELECT CONCAT(usu.PrimerNombre, "
                    + "' ', usu.PrimerApellido) as Nombre,"
                    + "gru.Director, gru.Jornada,"
                    + "gru.Nombre "
                    + "FROM usuario as usu "
                    + "INNER JOIN docente as doc "
                    + "ON usu.Nuip = doc.Codigo "
                    + "INNER JOIN grupo as gru "
                    + "ON doc.Codigo = gru.Director");
            if(rs.next()){
                lbNameDirector.setText(rs.getString("Nombre"));
                txtNuip.setText(rs.getString("gru.Director"));                
                if(rs.getString("gru.Jornada").equals("Mañana")){
                    rbMorning.setSelected(true);
                }else{
                    rbAfternoon.setSelected(true);
                }
                txtGroupName.setText(rs.getString("gru.Nombre"));
            }
        } catch (Exception e) {
        }
        btnUpdate.setEnabled(true);
        btnRegister.setEnabled(false);
    }//GEN-LAST:event_miModifyActionPerformed

    private void miDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteActionPerformed
        int row = tbData.getSelectedRow();
        id = (String) tbData.getValueAt(row, 0);
        try {
            con.modifyDB("UPDATE grupo SET Activo = 0 WHERE idGrupo = "+id);
            JOptionPane.showMessageDialog(rootPane, "GRUPO ELIMINADO EXITOSAMENTE");
            loadTable("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_miDeleteActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String code = txtNuip.getText();
        String name = txtGroupName.getText();
        String type = "";
        if(rbMorning.isSelected()){
            type = "Mañana";
        }else{
            type = "Tarde";
        }
            
        try {
            con.modifyDB("INSERT INTO grupo VALUES (null, "+ code +", '"+ type +"', '"+ name +"', 1)");
            JOptionPane.showMessageDialog(rootPane, "GRUPO REGISTRADO EXITOSAMENTE");
            loadTable("");
            emptyFields();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegisterActionPerformed
/**
 * @author Grupo diseño
 * @version 1.0
 * @param value Recibe un parámetro de tipo cadena para el filtro de busqueda
 * en la tabla
 * Este método carga los datos (id, director de grupo, jornada, nombre) del grado
 * en una tabla
 */
void loadTable(String value){
    String title[] = {"ID Grado", "Director", "Jornada", "Nombre"};
        String records[] = new String[4];
        String sql = "SELECT gru.idGrupo, CONCAT(usu.PrimerNombre, ' ',\n" +
"usu.PrimerApellido) as Nombre,\n" +
"gru.Jornada,\n" +
"gru.Nombre\n" +
"FROM usuario as usu\n" +
" INNER JOIN docente as doc\n" +
" ON usu.NUIP = doc.Codigo\n" +
" INNER JOIN grupo as gru\n" +
" ON doc.Codigo = gru.Director  "+
"WHERE gru.Activo = 1 AND CONCAT(gru.idGrupo, ' ', CONCAT(usu.PrimerNombre, ' ',\n" +
"usu.PrimerApellido), ' ', gru.Jornada, ' ', gru.Nombre ) LIKE '%"+value+"%' ";
         
        model = new DefaultTableModel(null, title);
    
         try{
            ResultSet rs = con.consultDB(sql); 
            
            while(rs.next()){
                records[0] = rs.getString("gru.idGrupo");
                records[1] = rs.getString("Nombre");
                records[2] = rs.getString("gru.Jornada");
                records[3] = rs.getString("gru.Nombre");
                model.addRow(records);
            }
            
            tbData.setModel(model);
        }catch(Exception e){
            System.out.println("Error 2 "+e);
        }
}

/**
 * @author Grupo diseño
 * @version 1.0
 * Este método vacía todos los campos del frame menos la tabla, para el ingreso
 * de nuevos grados.
 */
void emptyFields(){
    txtGroupName.setText("");
    txtNuip.setText("");
    txtSearch.setText("");
    if(rbMorning.isSelected()){
        rbMorning.setSelected(false);
    }else{
        rbAfternoon.setSelected(false);
    }
    lbNameDirector.setText("");
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbNameDirector;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JMenuItem miModify;
    private javax.swing.JRadioButton rbAfternoon;
    private javax.swing.JRadioButton rbMorning;
    private javax.swing.JTable tbData;
    private javax.swing.JTextField txtGroupName;
    private javax.swing.JTextField txtNuip;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
