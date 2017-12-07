/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Resources.Connection;

/**
 *
 * @author Grupo diseño
 * @version 1.0
 */
public class Observations extends javax.swing.JInternalFrame {

    /**
     * Creates new form proyecto
     */
    Connection con;
    DefaultComboBoxModel model1, model2, model3;
    DefaultTableModel tbModel1, tbModel2;
    /**
     * Variables que guardaran el id del grupo, materia y periodo
     */
    String idGroup[];
    String idSubjects[];
    String idPeriod[];

    public Observations() {
        initComponents();
        con = new Connection();
        loadTables("", null, null);
        loadGroup(Main.id);
        disableCombo();
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
        lbTeachers = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbObservations = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        cboCourse = new javax.swing.JComboBox<>();
        cboSubjects = new javax.swing.JComboBox<>();
        cboPeriod = new javax.swing.JComboBox<>();
        btnPdf = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Definitiva estudiantes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Docente");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Grado");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Materia");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Periodo");

        lbTeachers.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        tbData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        tbObservations.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbObservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbObservations);

        btnSave.setText("GUARDAR");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cboCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCourseItemStateChanged(evt);
            }
        });

        cboSubjects.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSubjectsItemStateChanged(evt);
            }
        });

        cboPeriod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPeriodItemStateChanged(evt);
            }
        });

        btnPdf.setText("GENERAR PDF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTeachers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(cboSubjects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPeriod, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(btnPdf)
                .addGap(30, 30, 30)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lbTeachers, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3))
                    .addComponent(cboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(cboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPdf)
                    .addComponent(btnSave))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCourseItemStateChanged
        if (cboCourse.getSelectedIndex() > 0) {
            int group = cboCourse.getSelectedIndex();
            cboSubjects.setEnabled(true);
            loadSubjects(idGroup[group], Main.id);
        } else if (cboCourse.getSelectedIndex() == 0) {
            loadTables("", null, null);
            cboSubjects.removeAllItems();
            cboPeriod.removeAllItems();
            disableCombo();
        }
    }//GEN-LAST:event_cboCourseItemStateChanged

    private void cboSubjectsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSubjectsItemStateChanged
        String subject = (String) cboSubjects.getSelectedItem();
        loadPeriod();
        loadTables("", null, null);
        cboPeriod.setEnabled(true);
    }//GEN-LAST:event_cboSubjectsItemStateChanged

    private void cboPeriodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPeriodItemStateChanged
        if (cboPeriod.getSelectedIndex() > 0) {
            int subject = cboSubjects.getSelectedIndex();
            int period = cboPeriod.getSelectedIndex();
            int group = cboCourse.getSelectedIndex();
            tbObservations.setVisible(true);
            tbData.setVisible(true);
            tbData.setEnabled(false);
            loadTables(idPeriod[period], idSubjects[subject], idGroup[group]);
        } else if (cboPeriod.getSelectedIndex() == 0) {
            tbObservations.setVisible(false);
            tbData.setVisible(false);
        }
    }//GEN-LAST:event_cboPeriodItemStateChanged

    /**
     * Evento ActionPerformed del boton btnSave Guarda los datos de las dos
     * tablas del frame en la base de datos
     *
     * @param evt
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int idSubj = Integer.parseInt(idSubjects[cboSubjects.getSelectedIndex()]);
        int idPer = Integer.parseInt(idPeriod[cboPeriod.getSelectedIndex()]);
        String rank = "";
        String observation = "";

        int codeStudent = 0;
        double grade = 0.0;
        int column = tbData.getColumnCount() - 1;

        for (int i = 0; i < tbData.getRowCount(); i++) {
            codeStudent = Integer.parseInt((String) tbData.getValueAt(i, 0));
            grade = Double.parseDouble((String) tbData.getValueAt(i, column));
            rank = assingRank(grade);
            observation = (String) tbObservations.getValueAt(i, 0);

            con.modifyDB("INSERT INTO nota_materia_periodo VALUES "
                    + "( NULL ," + grade + ",'" + rank + "','" + observation + "',"
                    + codeStudent + "," + idPer + "," + idSubj + ")");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Método para cargar los grupos en los que está el docente
     *
     * @param code recibe el código del docente
     */
    boolean userAdmin(int code) {
        boolean user = false;
        int quant = 0;
        try {
            ResultSet query = con.consultDB("SELECT COUNT(*) as cantidad FROM usuario as usu "
                    + "INNER JOIN administrador as admin "
                    + "ON admin.Codigo = usu.NUIP "
                    + "WHERE admin.Codigo = " + code + " "
                    + "AND admin.Activo = 1 "
            );
            while (query.next()) {
                if (query.getInt("cantidad") != 0) {
                    user = true;
                }
            }
        } catch (Exception e) {
        }
        return user;
    }

    void loadGroup(int code) {
        boolean user = userAdmin(code);
        if (!user) {
            boolean doc = false;
            try {
                ResultSet query = con.consultDB("SELECT COUNT(*) as docente FROM docente "
                        + "WHERE Activo = 1");
                if (query.next()) {
                    if (query.getInt("docente") != 0) {
                        doc = true;
                    }
                }
            } catch (Exception e) {
            }
            if (doc) {

                /**
                 * Consulta que trae el nombre del docente logueado y la
                 * cantidad de grupos en los que enseña el docente
                 */
                try {
                    ResultSet rs = con.consultDB("SELECT COUNT(*) as grupos, "
                            + "CONCAT(usu.PrimerNombre,' ',usu.PrimerApellido) as nomDoc "
                            + "FROM grupo, usuario as usu WHERE Activo = 1 "
                            + "AND (SELECT Codigo FROM docente as doc WHERE doc.Codigo = " + code + ") "
                            + "AND usu.NUIP = " + code
                    );
                    model1 = new DefaultComboBoxModel();
                    cboCourse.setModel(model1);
                    model1.addElement("Seleccione un grado");
                    while (rs.next()) {
                        int groups = rs.getInt("grupos");
                        /**
                         * En la longitud del arreglo se le asigna la variable
                         * groups, que tiene la cantidad de grupos y se le suma
                         * 1, ya que en el comboBox de grupo el primer item no
                         * tiene valor
                         */
                        idGroup = new String[groups + 1];
                        jLabel1.setText("Docente");
                        lbTeachers.setText(rs.getString("nomDoc"));
                    }
                } catch (Exception e) {
                }

                /**
                 * Consulta que trae el id y el nombre del grupo, a su vez carga
                 * el cboCourse con los grupos que dicta el docente
                 */
                try {
                    /**
                     * Se crea la variable i tipo entero que es inicializada en
                     * 1
                     */
                    int i = 1;
                    ResultSet rst = con.consultDB("SELECT idGrupo, Nombre FROM grupo "
                            + "INNER JOIN docente_materia_grupo as dmg "
                            + "ON grupo.idGrupo = dmg.Grupo_id "
                            + "WHERE dmg.Docente_id = " + code + " "
                            + "AND grupo.Activo = 1 "
                            + "GROUP BY dmg.Grupo_id");
                    model1 = new DefaultComboBoxModel();
                    cboCourse.setModel(model1);
                    model1.addElement("Seleccione un grado");
                    while (rst.next()) {
                        model1.addElement(rst.getString("Nombre"));
                        /**
                         * El arreglo de idGrupo tomara valor desde la posición
                         * 1
                         */
                        idGroup[i] = rst.getString("idGrupo");
                        i++;
                    }
                } catch (Exception e) {
                }
            } else {
                model1 = new DefaultComboBoxModel();
                cboCourse.setModel(model1);
                model1.addElement("Seleccione un grado");
            }
        } else {
            try {
                ResultSet rs = con.consultDB("SELECT CONCAT(usu.PrimerNombre,' ',usu.PrimerApellido) as nomAdmin "
                        + "FROM usuario as usu WHERE usu.NUIP = " + code
                );

                model1 = new DefaultComboBoxModel();
                cboCourse.setModel(model1);
                model1.addElement("Seleccione un grado");
                while (rs.next()) {

                    jLabel1.setText("Administrador");
                    lbTeachers.setText(rs.getString("nomAdmin"));
                }
            } catch (Exception e) {
            }

            try {
                ResultSet rs2 = con.consultDB("SELECT COUNT(*) as grupos FROM grupo ");
                while (rs2.next()) {
                    int groups = rs2.getInt("grupos");
                    idGroup = new String[groups + 1];
                }
            } catch (Exception e) {
            }
            try {
                int i = 1;
                ResultSet rst = con.consultDB("SELECT idGrupo, Nombre FROM grupo ");
                model1 = new DefaultComboBoxModel();
                cboCourse.setModel(model1);
                model1.addElement("Seleccione un grado");
                while (rst.next()) {
                    model1.addElement(rst.getString("Nombre"));
                    idGroup[i] = rst.getString("idGrupo");
                    i++;
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * Método que carga el comboBox de materias que se dictan en el grupo
     *
     * @param value recibe el id del grupo
     * @param value2 recibe el id del docente
     */
    void loadSubjects(String value, int value2) {
        /**
         * Consulta que trae la cantidad de materias que se dictan en el grupo
         */
        boolean user = userAdmin(value2);
        if (!user) {
            try {
                ResultSet rs = con.consultDB("SELECT COUNT(*) cantidad "
                        + "FROM materia as mat "
                        + "INNER JOIN docente_materia_grupo as dmg "
                        + "ON mat.idMateria = dmg.Materia_id "
                        + "INNER JOIN grupo as gru "
                        + "ON dmg.Grupo_id = gru.idGrupo "
                        + "WHERE gru.idGrupo = " + value + " "
                        + "AND dmg.Docente_id = " + value2 + " "
                        + "AND mat.Activo = 1"
                );
                model2 = new DefaultComboBoxModel();
                while (rs.next()) {
                    int subjects = rs.getInt("cantidad");
                    /**
                     * En la longitud del arreglo se le asigna la variable
                     * subjects, que tiene la cantidad de materias
                     */
                    idSubjects = new String[subjects];
                }
            } catch (Exception e) {
            }
            cboSubjects.removeAllItems();
            try {
                /**
                 * Se crea la variable i tipo entero que es inicializada en 0
                 */
                int i = 0;
                ResultSet rst = con.consultDB("SELECT mat.idMateria, mat.Nombre "
                        + "FROM materia as mat "
                        + "INNER JOIN docente_materia_grupo as dmg "
                        + "ON mat.idMateria = dmg.Materia_id "
                        + "INNER JOIN grupo as gru "
                        + "ON dmg.Grupo_id = gru.idGrupo "
                        + "WHERE gru.idGrupo = " + value + " "
                        + "AND dmg.Docente_id = " + value2 + " "
                        + "AND mat.Activo = 1");
                model2 = new DefaultComboBoxModel();
                while (rst.next()) {
                    model2.addElement(rst.getString("mat.Nombre"));
                    /**
                     * El arreglo de idSubjects tomara valor desde la posición 0
                     */
                    idSubjects[i] = rst.getString("mat.idMateria");
                    i++;
                }
                cboSubjects.setModel(model2);

            } catch (Exception e) {
            }
        } else {
            try {
                ResultSet rs = con.consultDB("SELECT COUNT(*) cantidad "
                        + "FROM materia as mat "
                        + "INNER JOIN docente_materia_grupo as dmg "
                        + "ON mat.idMateria = dmg.Materia_id "
                        + "INNER JOIN grupo as gru "
                        + "ON dmg.Grupo_id = gru.idGrupo "
                        + "WHERE gru.idGrupo = " + value
                );
                model2 = new DefaultComboBoxModel();
                while (rs.next()) {
                    int subjects = rs.getInt("cantidad");
                    idSubjects = new String[subjects];
                }
            } catch (Exception e) {
            }
            cboSubjects.removeAllItems();
            try {
                int i = 0;
                ResultSet rst = con.consultDB("SELECT mat.idMateria, mat.Nombre "
                        + "FROM materia as mat "
                        + "INNER JOIN docente_materia_grupo as dmg "
                        + "ON mat.idMateria = dmg.Materia_id "
                        + "INNER JOIN grupo as gru "
                        + "ON dmg.Grupo_id = gru.idGrupo "
                        + "WHERE gru.idGrupo = " + value
                );
                model2 = new DefaultComboBoxModel();
                while (rst.next()) {
                    model2.addElement(rst.getString("mat.Nombre"));
                    idSubjects[i] = rst.getString("mat.idMateria");
                    i++;
                }
                cboSubjects.setModel(model2);

            } catch (Exception e) {
            }
        }
    }

    /**
     * Método que carga cboPeriod con los periodos existentes
     */
    void loadPeriod() {
        /**
         * Consulta que trae la cantidad de periodos
         */
        try {
            ResultSet rs = con.consultDB("SELECT COUNT(*) cantidad FROM periodo ");
            model3 = new DefaultComboBoxModel();
            model3.addElement("Seleccione el periodo");
            cboPeriod.setModel(model3);
            while (rs.next()) {
                int period = rs.getInt("cantidad");
                /**
                 * En la longitud del arreglo se le asigna la variable period,
                 * que tiene la cantidad de periodos y se le suma 1, ya que en
                 * el comboBox de periodo el primer item no tiene valor
                 */
                idPeriod = new String[period + 1];
            }
        } catch (Exception e) {
        }

        /**
         * Consulta que traera el id y el nombre del periodo
         */
        try {
            int i = 1;
            ResultSet rst = con.consultDB("SELECT idperiodo, Nombre FROM periodo ");
            cboPeriod.setModel(model3);
            while (rst.next()) {
                model3.addElement(rst.getString("Nombre"));
                /**
                 * El arreglo idPeriod tendrá valor en la posición 1
                 */
                idPeriod[i] = rst.getString("idPeriodo");
                i++;
            }
        } catch (Exception e) {
        }
    }

    /**
     * Método que determina el rango de la calificación
     *
     * @param grade recibe la calificación
     * @return el rango de la calificación
     */
    public String assingRank(double grade) {
        String rank = "";
        if ((grade >= 0) && (grade < 2.5)) {
            rank = "B";
        } else if ((grade >= 2.6) && (grade < 3.5)) {
            rank = "M";
        } else {
            rank = "A";
        }
        return rank;
    }

    /**
     * Método que carga las tablas tbData y tbObservations
     *
     * @param value recibe el id del periodo
     * @param value2 recibe el id de la materia
     * @param value3 recibe el id del grupo
     */
    void loadTables(String value, String value2, String value3) {
        /**
         * Condicionales que cargaran las tablas según el valor que reciba el
         * segundo parámetro
         */
        if (value2 == null) {
            String title[] = {"NUIP", "Nombre", "Logro 1", "Definitiva"};
            tbModel1 = new DefaultTableModel(null, title);
            tbData.setModel(tbModel1);

            String title2[] = {"Observaciones"};
            tbModel2 = new DefaultTableModel(null, title2);
            tbObservations.setModel(tbModel2);
        }
        if (value2 != null) {
            int i = 1;
            /**
             * Consulta que trae la cantidad de logros que tiene la materia en
             * un determinado periodo
             */
            try {
                ResultSet query = con.consultDB("SELECT COUNT(log.idLogro) as cantidad "
                        + "FROM logro as log "
                        + "INNER JOIN nota_logro as ntl "
                        + "ON log.idLogro = ntl.Logro_id "
                        + "INNER JOIN periodo as per "
                        + "ON per.idperiodo = log.periodo_id "
                        + "INNER JOIN materia as mat "
                        + "ON mat.idMateria = log.Materia_id "
                        + "WHERE per.idperiodo = " + value + " "
                        + "AND mat.idMateria = " + value2);
                while (query.next()) {
                    if (Integer.parseInt(query.getString("cantidad")) > 0) {
                        i = Integer.parseInt(query.getString("cantidad"));
                    }
                }
            } catch (SQLException ex) {
            }
            /**
             * Inicializar el arreglo que muestra los identificadores de tbData.
             * Se le suma la variable i para que tome en cuenta la cantidad de
             * logros que tiene la materia
             */
            String title[] = new String[3 + i];

            //Ciclo para recorrer el arreglo title
            for (int j = 0; j < title.length; j++) {
                /**
                 * Condicionales para darle valor al arreglo según su posición
                 */
                if (j == 0) {
                    title[j] = "NUIP";
                }

                if (j == 1) {
                    title[j] = "Nombre";
                }
                if ((j > 1) && (j < title.length - 1)) {
                    for (int k = 0; k < i; k++) {
                        title[j] = "Logro " + (k + 1);
                        j++;
                    }
                }
                if (j == title.length - 1) {
                    title[j] = "Definitiva";
                }
            }

            tbModel1 = new DefaultTableModel(null, title);
            tbData.setModel(tbModel1);

            String reg[] = new String[title.length];

            //Está consulta traerá el nombre del logro
            try {
                /**
                 * La variable j en inicializada en 2, porque las posiciones 0 y
                 * 1 tendrán otro tipo de valor
                 */
                int j = 2;
                ResultSet rst = con.consultDB("SELECT log.Nombre "
                        + "FROM logro as log "
                        + "INNER JOIN periodo as per "
                        + "ON per.idperiodo = log.periodo_id "
                        + "INNER JOIN nota_logro as ntl "
                        + "ON log.idLogro = ntl.Logro_id "
                        + "INNER JOIN materia as mat "
                        + "ON log.Materia_id = mat.idMateria "
                        + "INNER JOIN estudiante as est "
                        + "ON est.Codigo = ntl.Estudiante_Codigo "
                        + "INNER JOIN usuario as usu "
                        + "ON usu.NUIP = est.Codigo "
                        + "WHERE per.idperiodo = " + value + " "
                        + "AND mat.idMateria = " + value2 + " "
                        + "GROUP BY log.idLogro "
                );
                while (rst.next()) {
                    if ((j > 1) && (j < reg.length - 1)) {
                        /**
                         * Los nombres de los logros estaran desde la posición 2
                         * en adelante (según la cantidad de logros), excepto en
                         * la última posición
                         */
                        reg[j] = rst.getString("log.Nombre");
                        j++;
                    }
                }
                tbData.setModel(tbModel1);
            } catch (Exception e) {
            }
            try {
                ResultSet rs = con.consultDB("SELECT usu.NUIP as Nuip, "
                        + "CONCAT(usu.PrimerApellido,' ',usu.PrimerNombre) as Nombre, "
                        + "FORMAT(AVG(ntl.Calificacion),1) as Definitiva "
                        + "FROM logro as log "
                        + "INNER JOIN periodo as per "
                        + "ON per.idperiodo = log.periodo_id "
                        + "INNER JOIN nota_logro as ntl "
                        + "ON log.idLogro = ntl.Logro_id "
                        + "INNER JOIN materia as mat "
                        + "ON log.Materia_id = mat.idMateria "
                        + "INNER JOIN estudiante as est "
                        + "ON est.Codigo = ntl.Estudiante_Codigo "
                        + "INNER JOIN usuario as usu "
                        + "ON usu.NUIP = est.Codigo "
                        + "WHERE per.idperiodo = " + value + " "
                        + "AND mat.idMateria = " + value2 + " "
                        + "AND est.Grupo_Id = " + value3 + " "
                        + "GROUP BY usu.NUIP "
                );

                /**
                 * Los datos traidos de la consulta se guardan en las posiciones
                 * 0, 1 y la última del arreglo reg
                 */
                while (rs.next()) {
                    reg[0] = rs.getString("Nuip");
                    reg[1] = rs.getString("Nombre");
                    double grade = rs.getDouble("Definitiva");
                    reg[reg.length - 1] = "" + grade;
                    tbModel1.addRow(reg);
                }

            } catch (Exception e) {
            }

            /**
             * Cargar la tabla tbObservations
             */
            // La variable obs es inicializada en 0
            int obs = 0;
            String title2[] = {"Observaciones"};
            tbModel2 = new DefaultTableModel(null, title2);
            try {
                ResultSet query = con.consultDB("SELECT COUNT(Observacion) as cantidad FROM nota_materia_periodo "
                        + "WHERE Periodo_id = " + value + " "
                        + "AND Materia_id = " + value2);
                while (query.next()) {
                    //La variable obs cambiara de valor según 
                    //el resultado de la consulta
                    obs = Integer.parseInt(query.getString("cantidad"));
                }
            } catch (Exception e) {
            }
            String reg2[] = new String[1];
            /**
             * Condicionales que cargaran la tabla tbObservations según el valor
             * de la variable obs
             */
            if (obs == 0) {
                int countRow = tbData.getRowCount();
                tbModel2.setRowCount(countRow);
                tbObservations.setModel(tbModel2);
            } else if (obs > 0 && obs != 1) {
                int countRow = tbData.getRowCount();
                tbModel2.setRowCount(countRow);
                int j = 0;
                try {
                    ResultSet rs = con.consultDB("SELECT COUNT(est.Codigo), nmp.Observacion "
                            + "FROM estudiante as est "
                            + "LEFT JOIN nota_materia_periodo as nmp "
                            + "ON est.Codigo = nmp.Estudiante_Codigo "
                            + "WHERE nmp.Periodo_id = " + value + " "
                            + "And nmp.Materia_id = " + value2 + " "
                            + "or nmp.Materia_id is null "
                            + "group by  est.Codigo "
                            + "order by est.Codigo"
                    );
                    while (rs.next()) {
                        reg2[0] = rs.getString("nmp.Observacion");
                        tbModel2.setValueAt(reg2[0], j, 0);
                        j++;
                    }
                    tbObservations.setModel(tbModel2);
                } catch (Exception e) {
                }
            } else if (obs == 1) {
                int countRow = tbData.getRowCount();
                tbModel2.setRowCount(countRow);
                int j = 0;
                try {
                    ResultSet rs = con.consultDB("SELECT COUNT(est.Codigo), nmp.Observacion "
                            + "FROM estudiante as est "
                            + "RIGHT JOIN nota_materia_periodo as nmp "
                            + "ON est.Codigo = nmp.Estudiante_Codigo "
                            + "WHERE nmp.Periodo_id = " + value + " "
                            + "And nmp.Materia_id = " + value2 + " "
                            + "or nmp.Materia_id is null "
                            + "group by  nmp.Observacion "
                            + "order by est.Codigo");

                    while (rs.next()) {
                        reg2[0] = rs.getString("nmp.Observacion");
                        tbModel2.setValueAt(reg2[0], j, 0);
                        j++;
                    }
                    tbObservations.setModel(tbModel2);
                } catch (Exception e) {
                }
            }
        } //Fin del segundo condicional (value2 != null)
    }

    /**
     * Método que deshabilita los comboBox de materia y periodo
     */
    void disableCombo() {
        cboSubjects.setEnabled(false);
        cboPeriod.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboPeriod;
    private javax.swing.JComboBox<String> cboSubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTeachers;
    private javax.swing.JTable tbData;
    private javax.swing.JTable tbObservations;
    // End of variables declaration//GEN-END:variables
}
