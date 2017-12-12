package Interfaces;

import Resources.Connection;
import com.toedter.calendar.demo.DateChooserPanel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Activity extends javax.swing.JInternalFrame {

    Connection cone;
    DefaultTableModel model;
    int temp2 = 0;
    int idAch, idGroup;

    public Activity() {
        initComponents();
        cone = new Connection();
        consult();
        cargarComboGrupo();
        comboMateria();
        comboPeriodo();
        comboLogros();
        cargarId();
        porcent();
        //desactivar();
    }

    /* public void desactivar(){
       
       if(i < jPanel1.getComponents().length) {
            jPanel2.getComponent(i).setEnabled(false);
        } else {
           jPanel2.setEnabled(true);
       }
           
                
    }*/
    public void consult() {

        /*
      @autor: Bases de datos  
      @version: 1.0
      @metodo: Su función es consultar registros a la base de datos
        
         */
//        String titulos[] = {"ID_GRUPO", "DIRECTOR", "JORNADA", "NOMBRE", "ACTIVO"};
//        model = new DefaultTableModel(null, titulos);
//        String fila[] = new String[5];
//        
//        try {
//            ResultSet rs = cone.consultDB("SELECT idGrupo, Director, Jornada, Nombre, Activo FROM grupo");
//            
//            while (rs.next()) {
//                fila[0] = rs.getString("idGrupo");
//                fila[1] = rs.getString("Director");
//                fila[2] = rs.getString("Jornada");
//                fila[3] = rs.getString("Nombre");
//                fila[4] = rs.getString("Activo");
//                
//                model.addRow(fila);
//            }
//            jTable1.setModel(model);
//        } catch (Exception e) {
//            System.out.println("Error" + e);
//        }
        String titulos[] = {"ID_ACTIVIDAD", "NOMBRE", "DESCRIPCION", "ESTADO", "ENTREGA", "GRUPO", "LOGRO", "PORCENTAJE"};
        model = new DefaultTableModel(null, titulos);
        String fila[] = new String[8];

        try {
            ResultSet rs = cone.consultDB("SELECT idActividad, Nombre, Descripcion, Estado, Fecha_Entrega, Grupo_Id, Logro_Id, Porcentaje FROM actividad WHERE  Estado = 1 ");

            while (rs.next()) {
                fila[0] = rs.getString("idActividad");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Descripcion");
                fila[3] = rs.getString("Estado");
                fila[4] = rs.getString("Fecha_Entrega");
                fila[5] = rs.getString("Grupo_Id");
                fila[6] = rs.getString("Logro_Id");
                fila[7] = rs.getString("Porcentaje");

                model.addRow(fila);
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
    }

    public void cargarComboGrupo() {
        /*
    @autor:Bases de datos
    @version:1.0
    @metodo: Consulta los datos de la tabla grupo y muestra los datos que estan activos mediante un jComboBox
         */
        try {
            //seleccionar el nombre del grupo 
            ResultSet rs = cone.consultDB("SELECT Nombre FROM grupo WHERE Activo = 1 ");
            while (rs.next()) {
                //Group.addItem(rs.getObject("Nombre"));
                cboGroup.addItem(rs.getString("Nombre"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void comboMateria() {
        /*
    @autor:Bases de datos
    @version:1.0
    @metodo:Consulta los datos de la tabla materia y muestra los datos que estan activos mediante un jComboBox
         */
        try {

            ResultSet rs = cone.consultDB("SELECT Nombre FROM materia WHERE Activo= 1");
            while (rs.next()) {

                cboSubjects.addItem(rs.getString("Nombre"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comboPeriodo() {

        /*
    @autor:Bases de datos
    @version:1.0
    @metodo:Consulta los datos de la tabla periodo y muestra los datos  mediante un jComboBox
         */
        try {

            ResultSet rs = cone.consultDB("SELECT Nombre FROM periodo");
            while (rs.next()) {

                cboPeriod.addItem(rs.getString("Nombre"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comboLogros() {

        /*
    @autor:Bases de datos
    @version:1.0
    @metodo:Consulta los datos de la tabla logro y muestra los datos que están activos mediante un jComboBox
         */
        try {

            ResultSet rs = cone.consultDB("SELECT Nombre FROM logro WHERE Activo=1");
            while (rs.next()) {

                txtAchievements.addItem(rs.getString("Nombre"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarId() {

        /*
    @autor:Bases de datos
    @version:1.0
    @metodo: Muestra el untimo datos de idActividad que están en la tabla Actividad por medio de un jLabel
         */
        try {
            ResultSet rs = cone.consultDB("SELECT max(idActividad) FROM actividad");

            if (rs.next()) {
                lblId.setText((rs.getInt("max(idActividad)") + 1) + "");
            }

        } catch (Exception e) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int porcent() {

        /*
    @autor:Bases de datos
    @version:1.0
    @metodo:Consulta y suma los datos del campo porcentaje de la tabla actividad 
         */
        ResultSet rs = cone.consultDB("select sum(Porcentaje) from actividad");
        int temp = 0;
        try {
            if (rs.next()) {
                temp = rs.getInt("sum(Porcentaje)");
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        temp2 = 100 - temp;
        jLabel13.setText("" + temp2);

        return temp2;

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
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboGroup = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboSubjects = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboPeriod = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtAchievements = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        spiPercent = new javax.swing.JSpinner();
        lblId = new javax.swing.JLabel();
        calDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenuItem2.setText("Eliminar");
        jMenuItem2.setComponentPopupMenu(jPopupMenu1);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem1.setText("Editar");
        jMenuItem1.setComponentPopupMenu(jPopupMenu1);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("DATOS");

        cboGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGroupActionPerformed(evt);
            }
        });

        jLabel2.setText("GRUPOS");

        jLabel3.setText("MATERIA");

        cboSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectsActionPerformed(evt);
            }
        });

        jLabel4.setText("PERIODO");

        jLabel5.setText("LOGROS");

        txtAchievements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAchievementsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPeriod, 0, 131, Short.MAX_VALUE)
                            .addComponent(txtAchievements, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSubjects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAchievements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("ACTIVIDAD A INGRESAR");

        jLabel7.setText("ID");

        jLabel8.setText("NOMBRE");

        jLabel9.setText("DESCRIPCION");

        jLabel10.setText("FECHA ENTREGA");

        jLabel11.setText("PORCENTAJE");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jLabel12.setText("%");

        btnAdd.setText("AGREGAR");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        calDate.setDateFormatString("yyyy-MM-dd");

        jLabel13.setText("000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(289, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spiPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(58, 58, 58))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(btnAdd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(calDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(spiPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(5, 5, 5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(29, 29, 29))
        );

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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGroupActionPerformed

    }//GEN-LAST:event_cboGroupActionPerformed

    private void cboSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectsActionPerformed

    }//GEN-LAST:event_cboSubjectsActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

       
//        Ingresada ing = new Ingresada();
//        Principal1.jDesktopPane1.add(ing);
//        ing.toFront();
//        ing.setVisible(true); //Comentar
         
        int porce = (int) spiPercent.getValue();
        String grupo = (String) cboGroup.getSelectedItem();
        String logro = (String) txtAchievements.getSelectedItem();
        
        String id, nom, des;
        
        id = lblId.getText();
        nom = txtName.getText();
        des = txtDescription.getText();

        /*nom = TextNom.getText();
        desc = TextDesc.getText();
        porce = (double)SpinnerPor.getValue();*/
                        
        ResultSet rs = cone.consultDB("SELECT * FROM logro WHERE Nombre = '"+logro+"'");
        try {
             if (rs.next()) {
            idAch = rs.getInt("idLogro");
        }
        } catch (Exception e) {
        }
        ResultSet rs2 = cone.consultDB("SELECT * FROM grupo WHERE Nombre = '"+grupo+"'");
        try {
             if (rs2.next()) {
            idGroup = rs2.getInt("idGrupo");
        }
        } catch (Exception e) {
        }
       
        java.sql.Date date = new java.sql.Date(calDate.getDate().getTime());

        System.out.println(id + "," + nom + "," + des + "," + porce + "," + idGroup + "," + idAch + "," + date);
        
       try {
           
            cone.modifyDB("INSERT INTO actividad "
                    + "VALUES(" + id + ",'" + nom + "','" + des + "'," + 1 + ",'" + date + "'," + idGroup + ", " + idAch + " ," + porce + ")");

            JOptionPane.showMessageDialog(rootPane, "Dato ingresado");
        } catch (Exception e) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, e);
        }
        
        porcent();
        cargarId();
        consult();

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtAchievementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAchievementsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAchievementsActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int fila = jTable1.getSelectedRow();
        String value = jTable1.getValueAt(fila, 0).toString();

        if (fila >= 0) {
            cone.modifyDB("UPDATE actividad SET Estado = 0 WHERE idActividad= '" + value + "'");
            JOptionPane.showMessageDialog(rootPane, "Dato eliminado");
        }

        consult();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int id = jTable1.getSelectedRow();

        ResultSet rs = cone.consultDB("SELECT * FROM Actividad WHERE  idActividad = " + jTable1.getValueAt(id, 0));

        try {
            while (rs.next()) {
                txtName.setText(rs.getString("Nombre"));
                txtDescription.setText(rs.getString("Descripcion"));
                calDate.setDateFormatString(rs.getString("Fecha_Entrega"));
                spiPercent.setValue(rs.getString("Porcentaje"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdd;
    private com.toedter.calendar.JDateChooser calDate;
    private javax.swing.JComboBox cboGroup;
    private javax.swing.JComboBox cboPeriod;
    private javax.swing.JComboBox cboSubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblId;
    private javax.swing.JSpinner spiPercent;
    private javax.swing.JComboBox txtAchievements;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
