/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Resources.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Grupo diseño
 */
public class EnterSubjects extends javax.swing.JInternalFrame {

    /**
     * Creates new form EnterSubjects
     */
    Connection con;
    DefaultTableModel tableModel;

    public EnterSubjects() {
        initComponents();
        con = new Connection();
        loadTabel("", 1);
        btnUpdate.setEnabled(false);
        miInactive.setVisible(false);
    }

    public void loadTabel(String value, int num) {
        //load : Cargar
        //Table : tabla
        String query = "SELECT idAsignatura, Nombre FROM asignatura "
                + "WHERE Activo = " + num + " "
                + "AND CONCAT(idAsignatura, ' ', Nombre) LIKE '%" + value + "%'";
        String[] title = {"Id", "Nombre"};
        String[] registry = new String[2];
        ResultSet rs = con.consultDB(query);
        tableModel = new DefaultTableModel(null, title);

        try {
            while (rs.next()) {
                registry[0] = rs.getString("idAsignatura");
                registry[1] = rs.getString("Nombre");

                tableModel.addRow(registry);
            }

            tbAsignatura.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(EnterSubjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertSubjects() {
        /**
         * Deshabilitar btnUpdate
         */
        btnUpdate.setEnabled(false);

        /**
         * Selecciona el id de asignatura
         */
        String query = "SELECT MAX(idAsignatura + 1) as id FROM asignatura";
        ResultSet rs = con.consultDB(query);
        String id = "";
        try {
            while (rs.next()) {
                id = rs.getString("id");
                if (id == null) {
                    id = "1";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnterSubjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Inserta asignatura
         */
        int idAsig = Integer.parseInt(id);
        String sql = "INSERT INTO asignatura VALUES("
                + "" + idAsig + ",'" + txtName.getText() + "','" + txtDescription.getText() + "'," + 1
                + ")";

        con.modifyDB(sql);
        txtName.setText("");
        txtDescription.setText("");
        loadTabel("",1);
    }

    public void modifySubjects() {

        /**
         *
         */
        btnRegister.setEnabled(false);
        btnUpdate.setEnabled(true);

        int row = tbAsignatura.getSelectedRow();
        int id = Integer.parseInt((String) tbAsignatura.getValueAt(row, 0));

        String query = "SELECT Nombre, descripcion FROM asignatura WHERE idAsignatura = " + id;
        ResultSet rs = con.consultDB(query);

        try {
            while (rs.next()) {
                txtName.setText(rs.getString("Nombre"));
                txtDescription.setText(rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnterSubjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSubjects(){
        int row = tbAsignatura.getSelectedRow();
        int id = Integer.parseInt((String) tbAsignatura.getValueAt(row, 0));

        String sql = "UPDATE asignatura SET Nombre = '" + txtName.getText() + "', "
                + "descripcion = '" + txtDescription.getText() + "' "
                + "WHERE idAsignatura = " + id;

        con.modifyDB(sql);

        txtName.setText("");
        txtDescription.setText("");
        btnRegister.setEnabled(true);
        btnUpdate.setEnabled(false);
        loadTabel("",1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        miModify = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miActive = new javax.swing.JMenuItem();
        miInactive = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnRegister = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAsignatura = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnActive = new javax.swing.JButton();
        btnInactive = new javax.swing.JButton();

        miModify.setText("Modificar");
        miModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miModifyActionPerformed(evt);
            }
        });
        popMenu.add(miModify);
        popMenu.add(jSeparator1);

        miActive.setText("Activar");
        miActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miActiveActionPerformed(evt);
            }
        });
        popMenu.add(miActive);

        miInactive.setText("Inactivar");
        miInactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInactiveActionPerformed(evt);
            }
        });
        popMenu.add(miInactive);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("INGRESO DE ASIGNATURAS");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Descripción");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
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

        tbAsignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tbAsignatura.setComponentPopupMenu(popMenu);
        tbAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAsignaturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAsignatura);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Buscar");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/math-add-icon.png"))); // NOI18N
        btnActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActiveActionPerformed(evt);
            }
        });

        btnInactive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/math-minus-icon.png"))); // NOI18N
        btnInactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInactive)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActive)
                    .addComponent(btnInactive))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateSubjects();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        insertSubjects();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void tbAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAsignaturaMouseClicked
        if (evt.getButton() == 3) {
            popMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbAsignaturaMouseClicked

    private void miModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miModifyActionPerformed
        modifySubjects();
    }//GEN-LAST:event_miModifyActionPerformed

    private void miInactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInactiveActionPerformed
        int row = tbAsignatura.getSelectedRow();
        String id = (String)tbAsignatura.getValueAt(row, 0);
        con.modifyDB("UPDATE asignatura SET Activo = 0 WHERE idAsignatura = " +id);
        loadTabel("", 1);
    }//GEN-LAST:event_miInactiveActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        loadTabel(txtSearch.getText(),1);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActiveActionPerformed
        loadTabel("", 1);
        miActive.setVisible(false);
        miModify.setVisible(true);
        miInactive.setVisible(true);
        jSeparator1.setVisible(true);
    }//GEN-LAST:event_btnActiveActionPerformed

    private void btnInactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactiveActionPerformed
        loadTabel("", 0);
        miModify.setVisible(false);
        miInactive.setVisible(false);
        jSeparator1.setVisible(false);
        miActive.setVisible(true);
    }//GEN-LAST:event_btnInactiveActionPerformed

    private void miActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miActiveActionPerformed
        int row = tbAsignatura.getSelectedRow();
        String id = (String)tbAsignatura.getValueAt(row, 0);
        con.modifyDB("UPDATE asignatura SET Activo = 1 WHERE idAsignatura = " +id);
        loadTabel("", 0);
    }//GEN-LAST:event_miActiveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActive;
    private javax.swing.JButton btnInactive;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem miActive;
    private javax.swing.JMenuItem miInactive;
    private javax.swing.JMenuItem miModify;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JTable tbAsignatura;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
