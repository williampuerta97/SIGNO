package Interfaces;


import Resources.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andre
 */
public class TeacherForSubject extends javax.swing.JInternalFrame {

    /**
     * Clase principal para realizar la conexiÃ³n con las tablas grupos,materia
     * y docente
     * <pre>gestion de docentes por materia,por grupo ;</pre>
     *
     * @author Grupo de base de datos
     * @version 1.0 22-11-2017
     */
    Connection con;
    DefaultTableModel modelo;

    public TeacherForSubject() {
        initComponents();

        con = new Connection();
        Consult("");
        chargerSubject();
        chargerGroup();
        chargerTeacher();
        btnUpdate.setVisible(false);
    }

    public void chargerSubject() {
        /**
         * Clase utilizada para realizar la conexiÃ³n con la tabla materia de la
         * base de datos utilizando mysql como gestor de base de datos.
         * <pre>SELECT Nombre,id FROM materia;</pre>
         *
         * @author Grupo de base de datos
         * @version 1.0 22-11-2017
         */
        try {
            //seleccionar el nombre del grupo 
            ResultSet rs = con.consultDB("SELECT idMateria FROM materia");
            while (rs.next()) {
                cboSubject.addItem(rs.getString("idMateria"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherForSubject.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void chargerGroup() {
        /**
         * Clase utilizada para realizar la conexiÃ³n con la tabla grupo de la
         * base de datos utilizando mysql como gestor de base de datos.
         * <pre>SELECT id FROM grupo;</pre>
         *
         * @author Grupo de base de datos
         * @version 1.0 22-11-2017
         */
        try {
            //seleccionar el nombre del grupo 
            ResultSet rs = con.consultDB("SELECT idGrupo FROM Grupo");
            while (rs.next()) {
                cboGroupId.addItem(rs.getString("idGrupo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherForSubject.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void chargerTeacher() {
        /**
         * Clase utilizada para realizar la conexiÃ³n con la tabla Docente de la
         * base de datos utilizando mysql como gestor de base de datos.
         * <pre>SELECT id FROM grupo;</pre>
         *
         * @author Grupo de base de datos
         * @version 1.0 22-11-2017
         */
        try {
            //seleccionar el nombre del grupo 
            ResultSet rs = con.consultDB("SELECT Codigo FROM docente");
            while (rs.next()) {
                cboTeacherId.addItem(rs.getString("Codigo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherForSubject.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Consult(String value) {

        try {
            String titulos[] = {"Docente", "Materia", "Grupo"};
            String fila[] = new String[3];

            modelo = new DefaultTableModel(null, titulos);

            ResultSet rs = con.consultDB("SELECT CONCAT(u.PrimerNombre, ' ', u.PrimerApellido) Nombre, m.Nombre, g.Nombre "
                    + "FROM usuario u "
                    + "INNER JOIN Docente d "
                    + "ON u.NUIP = d.Codigo "
                    + "INNER JOIN Docente_materia_grupo dmg "
                    + "ON d.Codigo = dmg.Docente_id "
                    + "INNER JOIN Materia m "
                    + "ON dmg.Materia_id = m.idMateria "
                    + "INNER JOIN Grupo g "
                    + "ON dmg.Grupo_id = g.idGrupo "
                    + "WHERE CONCAT(u.PrimerNombre, ' ', u.PrimerApellido, ' ', m.Nombre, ' ', g.Nombre) LIKE '%" + value + "%' "
                    + "AND d.Activo = 1 AND g.Activo = 1 AND m.Activo = 1");

            while (rs.next()) {
                fila[0] = rs.getString("Nombre");
                fila[1] = rs.getString("m.Nombre");
                fila[2] = rs.getString("g.Nombre");

                modelo.addRow(fila);

            }
            tbTeachers.setModel(modelo);
            // cboCurso.setModel(modelo);
            // btnActualizar.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error" + e);

        }

    }

    void Search(String param) {

        try {
            String titulos[] = {"Docente_id", "Grupo_id", "Materia_id"};
            String fila[] = new String[3];

            modelo = new DefaultTableModel(null, titulos);

            //ResultSet rs =st.executeQuery("SELECT * FROM cursos where CONCAT (nomCurso,'',codEst) LIKE '%"+param+"%'" );
            //                                                                                ResultSet rs =conex.consultaBD("SELECT nombreCurso,codCurso FROM cursos where CONCAT (nombreCurso,'',codCurso,'') LIKE '%"+param+"%'" );
            //ResultSet rs =  conex.consultaBD("SELECT cur.codCurso,cur.nombreCurso,doce.codDocente,doce.nomDocente FROM cursos as cur LEFT JOIN docentes as doce ON doce.codCurso=cur.codCurso where (nombreCurso) LIKE '%"+param+"%'" );
            // ResultSet rs =  con.consultDB("SELECT e.codEst,e.nomEst,c.codCurso,c.nombreCurso  FROM estudiantes e INNER JOIN matriculas m ON e.codEst=m.codEst INNER JOIN cursos as c ON m.codCurso=c.codCurso where (e.codEst) LIKE '%"+param+"%'" );
            ResultSet rs = con.consultDB("SELECT * FROM docente_materia_grupo WHERE (Docente_id) LIKE '%" + param + "%'");
            while (rs.next()) {
                fila[0] = rs.getString("Docente_id");
                fila[1] = rs.getString("Grupo_id");
                fila[2] = rs.getString("Materia_id");

                modelo.addRow(fila);

            }
            tbTeachers.setModel(modelo);
        } catch (Exception e) {
            System.out.println("Error" + e);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmTeacher = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        Modificar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        lblSubjectName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboGroupId = new javax.swing.JComboBox<>();
        lblGroupName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboTeacherId = new javax.swing.JComboBox<>();
        lblTeacherName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTeachers = new javax.swing.JTable();
        lblAssign = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        Eliminar.setText("Eliminar");
        Eliminar.setToolTipText("");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jpmTeacher.add(Eliminar);

        Modificar.setText("Modificar");
        Modificar.setToolTipText("");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jpmTeacher.add(Modificar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Teacher For Subject and Group");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Materia ID");

        cboSubject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSubjectItemStateChanged(evt);
            }
        });
        cboSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectActionPerformed(evt);
            }
        });

        lblSubjectName.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Grupo ID");

        cboGroupId.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cboGroupId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGroupIdItemStateChanged(evt);
            }
        });

        lblGroupName.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Docente ID");

        cboTeacherId.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cboTeacherId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTeacherIdItemStateChanged(evt);
            }
        });

        lblTeacherName.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        tbTeachers.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tbTeachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbTeachers.setComponentPopupMenu(jpmTeacher);
        jScrollPane1.setViewportView(tbTeachers);

        lblAssign.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblAssign.setText("ASIGNAR");
        lblAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblAssignActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Buscar");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
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

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnUpdate.setText("ACTUALIZAR");
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
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cboTeacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lblTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cboGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lblGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(lblSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(btnUpdate))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblAssign)
                .addGap(65, 65, 65)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTeacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cboGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnUpdate)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAssign)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSubjectActionPerformed

    private void cboSubjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSubjectItemStateChanged
        Connection conex2 = new Connection();
        try {

            ResultSet rs2 = conex2.consultDB("SELECT Nombre FROM Materia where idMateria=" + cboSubject.getSelectedItem());
            if (rs2.next()) {
                lblSubjectName.setText(rs2.getString("Nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);

        }
    }//GEN-LAST:event_cboSubjectItemStateChanged

    private void cboGroupIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGroupIdItemStateChanged
        Connection conex3 = new Connection();
        try {

            ResultSet rs2 = conex3.consultDB("SELECT Nombre FROM Grupo where idGrupo=" + cboGroupId.getSelectedItem());
            if (rs2.next()) {
                lblGroupName.setText(rs2.getString("Nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);

        }
    }//GEN-LAST:event_cboGroupIdItemStateChanged

    private void cboTeacherIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTeacherIdItemStateChanged
        Connection conex4 = new Connection();
        try {

            ResultSet rs2 = conex4.consultDB("SELECT PrimerNombre from usuario u INNER JOIN rol r ON r.idRol=u.Rol_id INNER JOIN docente d ON r.idrol=d.Rol_Id where d.Codigo=" + cboTeacherId.getSelectedItem());
            if (rs2.next()) {
                lblTeacherName.setText(rs2.getString("PrimerNombre"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);

        }
    }//GEN-LAST:event_cboTeacherIdItemStateChanged

    private void lblAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblAssignActionPerformed
        String teacher = (String) cboTeacherId.getSelectedItem();
        String group = (String) cboGroupId.getSelectedItem();
        String subject = (String) cboSubject.getSelectedItem();

        con.modifyDB("INSERT INTO docente_materia_grupo VALUES('" + subject + "','" + group + "','" + teacher + "')");
        JOptionPane.showMessageDialog(null, "El registro ha sido ingresado");
        // txtNombre.setText("");

        Consult("");
    }//GEN-LAST:event_lblAssignActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        Consult(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int filaselec;
        String cod;

        // try{
        filaselec = tbTeachers.getSelectedRow();
        if (filaselec == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
        } else {

            DefaultTableModel modelo = (DefaultTableModel) tbTeachers.getModel();
            cod = (String) modelo.getValueAt(filaselec, 0);
            modelo.removeRow(filaselec);

            con.modifyDB("DELETE FROM docente_materia_grupo WHERE Docente_id='" + cod + "'");
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado");

        }
        Consult("");
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        int filaselec;

        filaselec = tbTeachers.getSelectedRow();
        String group = (String) modelo.getValueAt(filaselec, 1);
        String teacher = (String) modelo.getValueAt(filaselec, 0);
        String subject = (String) modelo.getValueAt(filaselec, 2);

        btnUpdate.setVisible(true);

        cboTeacherId.setSelectedItem(teacher);
        cboSubject.setSelectedItem(subject);
        cboGroupId.setSelectedItem(group);


    }//GEN-LAST:event_ModificarActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboGroupId;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JComboBox<String> cboTeacherId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu jpmTeacher;
    private javax.swing.JButton lblAssign;
    private javax.swing.JLabel lblGroupName;
    private javax.swing.JLabel lblSubjectName;
    private javax.swing.JLabel lblTeacherName;
    private javax.swing.JTable tbTeachers;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
