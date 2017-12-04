/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signo;

import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Grupo diseño
 * @version 1.0
 */
public class ActivityNotes extends javax.swing.JInternalFrame {

    /**
     * Crea una nueva ventana para el ingreso de notas por actividad, y 
     * notas por logro
     */
    Connection con;
    DefaultTableModel model;
    DefaultComboBoxModel model1, model2, model3;
    String idGroup [], idSubject[], idAchivement[], idActivity[];
    String title[] = {"Nuip", "Nombres y apellidos", "Nota"};
    TableColumnModel columnModel;
    /**
     * Método constructor de la clase ActivityNotes, instanciando la clase
     * de la conexión a la base de datos, cargando el jComboBox de grupo dependiendo del
     * docente que le dé clases. Cargando también el método disableCombo para
     * desactivar los demás jComboBox. También carga el método loadTeacher para
     * establecer el nombre del profesor que ingrese al sistema. Se instancia la clase
     * de modelo de la tabla y la clase del modelo de la columna de la tabla
     */
    public ActivityNotes() {
        initComponents();
        con = new Connection();
        disableCombo();
        loadUser(Main.id);
        columnModel = tbData.getColumnModel();
        model = new DefaultTableModel(null, title);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        cboGroup = new javax.swing.JComboBox();
        cboAchievements = new javax.swing.JComboBox();
        cboActivity = new javax.swing.JComboBox();
        btnRegister = new javax.swing.JButton();
        cboSubjects = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbTeachers = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Notas por actividad");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Docente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Grupo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 83, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Materia");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 136, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 243, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Logro");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 189, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Actividades");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 246, -1, -1));

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
        jScrollPane1.setViewportView(tbData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 293, 397, 110));

        cboGroup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGroupItemStateChanged(evt);
            }
        });
        cboGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGroupActionPerformed(evt);
            }
        });
        getContentPane().add(cboGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 172, -1));

        cboAchievements.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cboAchievements.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboAchievementsItemStateChanged(evt);
            }
        });
        getContentPane().add(cboAchievements, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 183, 172, -1));

        cboActivity.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cboActivity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboActivityItemStateChanged(evt);
            }
        });
        getContentPane().add(cboActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 172, -1));

        btnRegister.setText("REGISTRAR");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 436, -1, -1));

        cboSubjects.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSubjectsItemStateChanged(evt);
            }
        });
        getContentPane().add(cboSubjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 132, 172, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setText("PDF");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 436, -1, -1));
        getContentPane().add(lbTeachers, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 172, 16));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        int count = tbData.getRowCount();
        String rank = "";
        if(jLabel6.isVisible() && cboActivity.isVisible()){
            try {                
                for (int i = 0; i < count; i++) {
                String grade = (String) model.getValueAt(i, 2);                                      
                int pos = cboActivity.getSelectedIndex();          
                ResultSet rs = con.consultDB("SELECT * FROM nota_actividad "+
                        "WHERE estudiante_codigo = "+model.getValueAt(i, 0)+ 
                        " AND actividad_id = "+idActivity[pos]);
                if(grade.equals("")){   
                   
                  if(rs.next()){
                    con.modifyDB("UPDATE Nota_Actividad SET Calificacion = 0, Rango = 'B'"
                           + " WHERE Estudiante_Codigo = "+model.getValueAt(i, 0)+ " AND "
                           + "actividad_id = "+idActivity[pos]);
                    JOptionPane.showMessageDialog(rootPane, "LA CALIFICACION DE LA ACTIVIDAD "
                           + "FUE ACTUALIZADA CORRECTAMENTE");
                  }else{
                    con.modifyDB("INSERT INTO Nota_Actividad VALUES "
                          + "(null, 0, "+model.getValueAt(i, 0)+", "+idActivity[pos]+", 'B')");
                    JOptionPane.showMessageDialog(rootPane, "LA CALIFICACION DE LA ACTIVIDAD "
                           + "FUE INGRESADA CORRECTAMENTE");        
                  }
                }else {                
                    double num = Double.parseDouble(grade);
                    rank = assignRank(num);
                  if(rs.next()){
                    con.modifyDB("UPDATE Nota_Actividad SET Calificacion = "+ model.getValueAt(i, 2)
                    + ", Rango = '"+rank+"' WHERE Estudiante_Codigo = "+model.getValueAt(i, 0)
                    +" AND actividad_id = "+idActivity[pos]);
                    JOptionPane.showMessageDialog(rootPane, "LA CALIFICACION DE LA ACTIVIDAD "
                           + "FUE ACTUALIZADA CORRECTAMENTE");
                  }else{                                    
                    con.modifyDB("INSERT INTO Nota_Actividad VALUES "
                          + "(null, "+model.getValueAt(i, 2)+", "+model.getValueAt(i, 0)+", "+idActivity[pos]+", '"+rank+"')");  
                    JOptionPane.showMessageDialog(rootPane, "LA CALIFICACION DE LA ACTIVIDAD "
                           + "FUE INGRESADA CORRECTAMENTE");
                  }
                }  
                }
            } catch (Exception e) {
            }
        }else{
             try {
                for (int i = 0; i < count; i++) {                    
                  String grade = (String) model.getValueAt(i, 2);     
                  int pos = cboAchievements.getSelectedIndex();
                  ResultSet rs = con.consultDB("SELECT * FROM nota_logro "+
                        "WHERE estudiante_codigo = "+model.getValueAt(i, 0)+ 
                        " AND logro_id = "+idAchivement[pos]);
                if(grade.equals("")){
                    if(rs.next()){
                        con.modifyDB("UPDATE Nota_Logro SET Calificacion = 0, Rango = 'B'"
                           + " WHERE Estudiante_Codigo = "+model.getValueAt(i, 0)+ " AND "
                           + " Logro_id = "+idAchivement[pos]);
                    JOptionPane.showMessageDialog(rootPane, "EL LOGRO INSTITUCIONAL"
                           + " FUE ACTUALIZADO CORRECTAMENTE");
                    }else{
                        con.modifyDB("INSERT INTO Nota_Logro VALUES "
                          + "(null, 0, "+idAchivement[pos]+", "+model.getValueAt(i, 0)+", 'B')"); 
                        JOptionPane.showMessageDialog(rootPane, "EL LOGRO INSTITUCIONAL"
                           + " FUE INGRESADO CORRECTAMENTE");
                    }
                }else {
                  double num = Double.parseDouble(grade);
                  rank = assignRank(num);
                  if(rs.next()){
                    con.modifyDB("UPDATE Nota_Logro SET Calificacion = "+ model.getValueAt(i, 2)
                    + ", Rango = '"+rank+"' WHERE Estudiante_Codigo = "+model.getValueAt(i, 0)
                    +" AND logro_id = "+idAchivement[pos]);
                    JOptionPane.showMessageDialog(rootPane, "LA CALIFICACION DEL LOGRO INSTITUCIONAL"
                           + "FUE ACTUALIZADA CORRECTAMENTE");
                  }else{                                    
                    con.modifyDB("INSERT INTO Nota_Logro VALUES "
                          + "(null, "+model.getValueAt(i, 2)+", "+idAchivement[pos]+", "+model.getValueAt(i, 0)+", '"+rank+"')");  
                    JOptionPane.showMessageDialog(rootPane, "LA CALIFICACION DEL LOGRO INSTITUCIONAL"
                           + "FUE INGRESADO CORRECTAMENTE");
                  }
                }  
                }
            } catch (Exception e) {
            }
        }
                
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void cboGroupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGroupItemStateChanged
        if(cboGroup.getSelectedIndex() > 0){
            cboSubjects.setEnabled(true);
            jLabel6.setVisible(false);
            cboActivity.setVisible(false);
            int pos = cboGroup.getSelectedIndex();
            loadSubjects(idGroup[pos]);        
        }else if(cboGroup.getSelectedIndex() == 0){
            disableCombo();    
            cboSubjects.removeAllItems();
            cboAchievements.removeAllItems();
            cboActivity.removeAllItems();            
        }            
    }//GEN-LAST:event_cboGroupItemStateChanged

    private void cboGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGroupActionPerformed

    private void cboSubjectsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSubjectsItemStateChanged
        if(cboSubjects.getSelectedIndex() > 0){
            int pos = cboSubjects.getSelectedIndex();
            loadAchievements(idSubject[pos]);
            cboAchievements.setEnabled(true);
        }else if(cboSubjects.getSelectedIndex() == 0){
            cboAchievements.setEnabled(false);
            cboActivity.setEnabled(false);
            cboAchievements.removeAllItems();
            cboActivity.removeAllItems();            
        }
    }//GEN-LAST:event_cboSubjectsItemStateChanged

    private void cboAchievementsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAchievementsItemStateChanged
        if(cboAchievements.getSelectedIndex() > 0){
            int pos = cboAchievements.getSelectedIndex();
            try {
                ResultSet rs = con.consultDB("SELECT * FROM logro WHERE "
                        + "idLogro = "+idAchivement[pos]+" AND tipo = 'ins'");
                if(rs.next()){
                    loadTableAchievements(idAchivement[pos]);
                }else{
                    loadActivity(idAchivement[pos]);
                }
            } catch (Exception e) {
            }
            
        }else if(cboAchievements.getSelectedIndex() == 0){                                   
            cboActivity.removeAllItems();
            cboActivity.setEnabled(false);
            cboActivity.setVisible(false);
            jLabel6.setVisible(false);
            model.setRowCount(0);
        }       
    }//GEN-LAST:event_cboAchievementsItemStateChanged

    private void cboActivityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboActivityItemStateChanged
        if(cboActivity.getSelectedIndex() > 0){
            int pos = cboActivity.getSelectedIndex();
            loadTableActivity(idActivity[pos]);
        }else{
            model.setRowCount(0);
        }    
    }//GEN-LAST:event_cboActivityItemStateChanged
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método lo que hace es cargar el jComboBox de grados dependiendo del usuario
 * que ingrese al sistema, si es docente, cargará sus grupos, si es administrador cargará
 * todos los grados
 * @param code Recibe como parámetro en un int, el código de la persona que inicia sesión
 * 
 */
void loadUser(int code){
    try {
        ResultSet rs = con.consultDB("SELECT CONCAT(usu.PrimerNombre, ' ', "
                + "usu.PrimerApellido) Name FROM usuario usu, administrador a " +
                  "WHERE usu.NUIP = a.Codigo AND a.Activo = 1 AND a.Codigo = "+ code);
        if(rs.next()){
            cboGroup.removeAllItems();
            jLabel1.setText("Admin");
            lbTeachers.setText(rs.getString("Name"));
            try {
                ResultSet res = con.consultDB("SELECT count(*) conteo FROM grupo WHERE Activo = 1");
            if(res.next()){
            int num = res.getInt("conteo");
            idGroup = new String[num+1];            
            }
            } catch (Exception e) {
            }
            Connection cone = new Connection();
            int i = 1;
            ResultSet resul = cone.consultDB("SELECT idGrupo, Nombre FROM grupo WHERE Activo = 1");
            model3 = new DefaultComboBoxModel();
            cboGroup.setModel(model3);
            model3.addElement("Seleccione un grado");
            while(resul.next()){                
                idGroup[i] = resul.getString("idGrupo");                
                model3.addElement(resul.getString("Nombre"));
                i++;        
            }
        }else{
            loadGroup(code);
            loadTeacher(code);
            jLabel1.setText("Docente");
        }
    } catch (Exception e) {
    }
}    
 /**
 * @author Grupo diseño
 * @version 1.0
 * Lo que hace este método es cargar el jComboBox de grupos dependiendo del docente 
 * que le da clase a esos grupos.
 * @param code El método loadGroup recibe como parámetro el código de docente en un int
 * que le da clases a unos determinados grupos, se llama en el método constructor.
 *  
 */
void loadGroup(int code){
    try {
        ResultSet rs = con.consultDB("SELECT count(*) conteo FROM grupo"
                + " INNER JOIN docente_materia_grupo as dmg "
                + "ON grupo.idGrupo = dmg.Grupo_id WHERE dmg.Docente_id = "+code
                + " AND grupo.Activo = 1 GROUP BY dmg.Grupo_id");
        if(rs.next()){
            int num = rs.getInt("conteo");
            idGroup = new String[num+1];            
        }
    } catch (Exception e) {
    }
    cboGroup.removeAllItems();
    try {
        int i = 1;
         ResultSet resul = con.consultDB("SELECT idGrupo, Nombre FROM grupo " +
            "INNER JOIN Docente_Materia_Grupo as dmg " +
            "ON grupo.idGrupo = dmg.Grupo_id " +
            "WHERE dmg.Docente_id = "+code +" AND grupo.Activo = 1 GROUP BY dmg.Grupo_id");
         model1 = new DefaultComboBoxModel();
         cboGroup.setModel(model1);
         model1.addElement("Seleccione un grado");
        while(resul.next()){           
            model1.addElement(resul.getString("Nombre"));
            idGroup[i] = resul.getString("idGrupo");
            i++;            
        }
    } catch (Exception e) {
    }
}
/**
 * @author Grupo diseño
 * @version 1.0
 * El método loadSubjects nos carga el jComboBox de materias que ve un determinado 
 * grupo.
 * @param value Recibe en un String, la id del grupo para cargar sus materias en el jComboBox
 */
void loadSubjects(String value){
    try {
        ResultSet rs = con.consultDB("SELECT count(*) conteo "
                + "FROM materia mat, docente_materia_grupo dmg "
                + "WHERE mat.idMateria = dmg.Materia_id AND dmg.Grupo_id = "+value+
                " AND mat.Activo = 1");
        if(rs.next()){
            int num = rs.getInt("conteo");
            idSubject = new String[num+1];
        }
    } catch (Exception e) {
    }
    cboSubjects.removeAllItems();
    int i = 1;
    try {
         ResultSet rs = con.consultDB("SELECT mat.idMateria, mat.Nombre "
            + "FROM materia as mat "
            + "INNER JOIN Docente_Materia_Grupo as dmg "
            + "ON mat.idMateria = dmg.Materia_id "
            + "INNER JOIN grupo as gru "
            + "ON dmg.Grupo_id = gru.idGrupo "
            + "WHERE gru.idGrupo = "+value+" AND mat.Activo = 1");      
         model2 = new DefaultComboBoxModel();
         cboSubjects.setModel(model2);
         model2.addElement("Seleccione una materia");
        while(rs.next()){
            model2.addElement(rs.getString("Nombre"));
            idSubject[i] = rs.getString("mat.idMateria");
            i++;
        }
        
    } catch (Exception e) {
    }
}
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método carga en el jComboBox de logros, los logros que tiene una materia
 * determinada
 * @param value Este parámetro en String es para recibir la id de la materia y así cargar
 * todos los logros que hay en ella
 */
void loadAchievements(String value){
    cboAchievements.removeAllItems();
    try {
        ResultSet rs = con.consultDB("SELECT COUNT(*) conteo FROM logro as log "
                + "INNER JOIN materia as mat "
                + "ON log.Materia_id = mat.idMateria "
                + "WHERE mat.idMateria = "+value+" AND log.Activo = 1");
        if(rs.next()){
            int num = rs.getInt("conteo");
            idAchivement = new String[num+1];
        }
    } catch (Exception e) {
    }
    int i = 1;
    try {
        ResultSet rs = con.consultDB("SELECT logro.Nombre, logro.idLogro FROM logro, materia "
                + "WHERE logro.Materia_id = materia.idMateria AND " 
                + " materia.idMateria = "+value+" AND logro.Activo = 1");
        cboAchievements.addItem("Seleccione un logro");
        while(rs.next()){
            cboAchievements.addItem(rs.getString("logro.Nombre"));
            idAchivement[i] = rs.getString("logro.idLogro");
            i++;
        }
    } catch (Exception e) {
    }
}
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método carga en el jComboBox de actvidad, las actividades que tiene un logro
 * determinado, si este logro es institucional (ins), no mostrará el jComboBox
 * de actividad.
 * @param value Este parámetro recibe en un String, la id del logro y carga las actividades
 * que tenga ese logro
 */
void loadActivity(String value){
    cboActivity.removeAllItems();
    jLabel6.setVisible(true);
    cboActivity.setVisible(true);
    cboActivity.setEnabled(true);
    try {
        ResultSet rs = con.consultDB("SELECT COUNT(*) conteo FROM actividad as act "
                + "INNER JOIN logro as log "
                + "ON act.Logro_id = log.idLogro "
                + "WHERE act.Logro_id = "+value+" AND act.Estado = 1");
        if(rs.next()){
            int num = rs.getInt("conteo");
            idActivity = new String[num+1];
        }
    } catch (Exception e) {
    }
    int i = 1;
    try {
        ResultSet rs = con.consultDB("SELECT actividad.idActividad, actividad.Nombre FROM actividad, logro "
                + "WHERE actividad.Logro_id = logro.idLogro AND "
                + "logro.idLogro = "+value+" AND actividad.Estado = 1");
        cboActivity.addItem("Seleccione una actividad");
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){                               
                    cboActivity.addItem(rs.getString("actividad.Nombre"));
                    idActivity[i] = rs.getString("actividad.idActividad");
                    i++;
                }
            }else{
                jLabel6.setVisible(false);
                cboActivity.setVisible(false);
            }
            
    } catch (Exception e) {
    }
}
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método carga la tabla con los estudiantes de un determinado grupo elegido
 * por el docente que le da clase, carga un campo para que éste docente digite 
 * la calificación de cualquier de sus alumnos, si el alumno tiene notas, entonces
 * el campo vacío que trae, vendrá con su nota de determinada actividad
 * @param id Recibe en un String, la id del logro para cargar los estudiantes y sus notas (si tienen, 
 * en caso de no tener trae el campo vacío para que el docente digite la nota)
 */
void loadTableActivity(String id){   
    String reg[] = new String[3];    
 model.setRowCount(0);
 int pos = cboGroup.getSelectedIndex();
    try {
        ResultSet rs = con.consultDB("SELECT usu.NUIP, CONCAT(usu.PrimerApellido, ' ', usu.PrimerNombre) Nombre\n" +
"FROM usuario usu\n" +
"INNER JOIN estudiante est\n" +
"ON usu.NUIP = est.Codigo\n" +
"INNER JOIN grupo gru\n" +
"on est.Grupo_Id = gru.idGrupo\n" +
"WHERE gru.idGrupo =  "+idGroup[pos]+" AND est.Activo = 1");
        
        while(rs.next()){
            reg[0] = rs.getString("usu.NUIP");
            reg[1] = rs.getString("Nombre");
            Connection cone = new Connection();
            ResultSet resul = cone.consultDB("SELECT * FROM nota_actividad "
                    + "WHERE estudiante_codigo = "+reg[0]+" AND Actividad_id = "+id);
            if(resul.next()){
               reg[2] = resul.getString("Calificacion");
            }else{
               reg[2] = ""; 
            }            
            
            model.addRow(reg);
        }
        tbData.setModel(model);
        columnModel.getColumn(2).setPreferredWidth(5);
        columnModel.getColumn(0).setPreferredWidth(20);
    } catch (Exception e) {
    }
 
}
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método carga la tabla de los estudiantes de un deeterminado grupo
 * escogido previamente por el docente. Trae las notas si los estudiantes tienen
 * sino tienen, trae el campo vacío para que el docente las digite. Esta tabla se
 * carga sólo para los logros institucionales (ins).
 * @param id Recibe en un String, la id del logro seleccionado con anterioridad para cargar si tiene
 * o no tiene notas el estudiante.
 */
void loadTableAchievements(String id){   
    String reg[] = new String[3];    
 model.setRowCount(0);
 jLabel6.setVisible(false);
 cboActivity.setVisible(false);
 int pos = cboGroup.getSelectedIndex();
    try {
        ResultSet rs = con.consultDB("SELECT usu.NUIP, CONCAT(usu.PrimerApellido, ' ', usu.PrimerNombre) Nombre\n" +
"FROM usuario usu\n" +
"INNER JOIN estudiante est\n" +
"ON usu.NUIP = est.Codigo\n" +
"INNER JOIN grupo gru\n" +
"on est.Grupo_Id = gru.idGrupo\n" +
"INNER JOIN docente_materia_grupo as dmg\n" +
"ON gru.idGrupo = dmg.Grupo_id\n" +
"INNER JOIN materia as mat\n" +
"ON dmg.Materia_id = mat.idMateria\n" +
"INNER JOIN logro as log\n" +
"ON mat.idMateria = log.idLogro\n" +
"LEFT JOIN actividad as act\n" +
"ON log.idLogro = act.idActividad "+
"WHERE gru.idGrupo =  "+idGroup[pos]+" AND act.idActividad IS NULL AND est.Activo = 1");
        
        while(rs.next()){
            reg[0] = rs.getString("usu.NUIP");
            reg[1] = rs.getString("Nombre");
            Connection cone = new Connection();
            ResultSet resul = cone.consultDB("SELECT * FROM nota_logro nl "
                    + "WHERE estudiante_codigo = "+reg[0]+" AND logro_id = "+id);
            if(resul.next()){
               reg[2] = resul.getString("Calificacion");
            }else{
               reg[2] = ""; 
            }
            
            model.addRow(reg);
        }
        tbData.setModel(model);
        columnModel.getColumn(2).setPreferredWidth(5);
        columnModel.getColumn(0).setPreferredWidth(20);
    } catch (Exception e) {
    }
 
}
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método desactiva todos los jComboBox menos el de grupo y también
 * oculta el jLabel de actividad y el jComboBox de la misma
 * 
 */
void disableCombo(){
    cboSubjects.setEnabled(false);
    cboAchievements.setEnabled(false);
    cboActivity.setVisible(false);
    jLabel6.setVisible(false);
}
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método lo que hace es establecer el nombre del docente que entre al sistema
 * @param id Este parámetro int, recibe el código del docente que se captura desde
 * que él ingresa al sistema
 */
void loadTeacher(int id){
    try {
        ResultSet rs = con.consultDB("SELECT CONCAT(u.PrimerNombre, ' '"
                + " , u.PrimerApellido ) Nombre "
                + "FROM Usuario u INNER JOIN Docente d "
                + "ON u.NUIP = d.Codigo "
                + "WHERE d.Codigo = "+id);
        if(rs.next()){
            lbTeachers.setText(rs.getString("Nombre"));
        }
    } catch (Exception e) {
    }
}
/**
 * @author Grupo diseño
 * @version 1.0
 * Este método asigna el rango de nota para una actividad o un logro institucional.
 * El rango se pasa en letra
 * @param grade Recibe como parámetro un double que es la nota del estudiante para
 * compararla y así sacar su rango de nota
 * @return Devuelve un String que es el rango de la nota del estudiante
 */
String assignRank(double grade){
    String rank = "";
    if((grade >= 0) && (grade <= 2.5)){
        rank = "B";
    }else if((grade >= 2.6) && (grade < 3.5)){
        rank = "M";
    }else {
        rank = "A";
    }   
    return rank;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox cboAchievements;
    private javax.swing.JComboBox cboActivity;
    private javax.swing.JComboBox cboGroup;
    private javax.swing.JComboBox<String> cboSubjects;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTeachers;
    private javax.swing.JTable tbData;
    // End of variables declaration//GEN-END:variables
}
