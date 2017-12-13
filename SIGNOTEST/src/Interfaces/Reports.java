/* MODULO INTERNO DE REPORTES */
package Interfaces;


import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map; 
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.JasperReport; 
import net.sf.jasperreports.view.JasperViewer; 
import net.sf.jasperreports.engine.JasperExportManager; 
import net.sf.jasperreports.engine.JasperCompileManager; 
 
/* @author JH0N4T4N */
public class Reports extends javax.swing.JInternalFrame {


    public Reports() {
        initComponents();
        setSize(1248,663);
        setLocation(0,36);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneFondo = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonRepIndividual = new javax.swing.JButton();
        jButtonRepGrado = new javax.swing.JButton();
        jButtonRepAsignaturas = new javax.swing.JButton();
        jButtonRepAreas = new javax.swing.JButton();
        jButtonDocente = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonNivelAcade = new javax.swing.JButton();
        jButtonCalificGrupal = new javax.swing.JButton();
        jButtonCalificIndividual = new javax.swing.JButton();
        jButtonIndicadores = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jDesktopPaneFondo.setBackground(new java.awt.Color(0, 0, 255));
        jDesktopPaneFondo.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPaneFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CREACION DE REPORTES");

        jButtonRepIndividual.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonRepIndividual.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRepIndividual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteIn.png"))); // NOI18N
        jButtonRepIndividual.setText("REP. INDIVIDUAL");
        jButtonRepIndividual.setToolTipText("Informe individual de cualquier estudiantes de la institución");
        jButtonRepIndividual.setBorder(null);
        jButtonRepIndividual.setBorderPainted(false);
        jButtonRepIndividual.setContentAreaFilled(false);
        jButtonRepIndividual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRepIndividual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonRepGrado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonRepGrado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRepGrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteGrad.png"))); // NOI18N
        jButtonRepGrado.setText("REP. GRADO");
        jButtonRepGrado.setToolTipText("Informe de los estudiantes pertenecientes a cada grado");
        jButtonRepGrado.setBorder(null);
        jButtonRepGrado.setBorderPainted(false);
        jButtonRepGrado.setContentAreaFilled(false);
        jButtonRepGrado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRepGrado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRepGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepGradoActionPerformed(evt);
            }
        });

        jButtonRepAsignaturas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonRepAsignaturas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRepAsignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteGrp.png"))); // NOI18N
        jButtonRepAsignaturas.setText("REP. ASIGNATURAS");
        jButtonRepAsignaturas.setToolTipText("Informe de las asignaturas que tiene asignado cada docente.");
        jButtonRepAsignaturas.setBorder(null);
        jButtonRepAsignaturas.setBorderPainted(false);
        jButtonRepAsignaturas.setContentAreaFilled(false);
        jButtonRepAsignaturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRepAsignaturas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonRepAreas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonRepAreas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRepAreas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteArea.png"))); // NOI18N
        jButtonRepAreas.setText("REP. AREA");
        jButtonRepAreas.setToolTipText("Informe de las distintas áreas que se enseñan en la institución.");
        jButtonRepAreas.setBorder(null);
        jButtonRepAreas.setBorderPainted(false);
        jButtonRepAreas.setContentAreaFilled(false);
        jButtonRepAreas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRepAreas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRepAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepAreasActionPerformed(evt);
            }
        });

        jButtonDocente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonDocente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteDocen.png"))); // NOI18N
        jButtonDocente.setText("REP. DOCENTES");
        jButtonDocente.setToolTipText("Informe de los docentes que trabajan en la institución");
        jButtonDocente.setBorder(null);
        jButtonDocente.setBorderPainted(false);
        jButtonDocente.setContentAreaFilled(false);
        jButtonDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDocente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocenteActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salir.png"))); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.setBorder(null);
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonNivelAcade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonNivelAcade.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNivelAcade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteNivelAcade.png"))); // NOI18N
        jButtonNivelAcade.setText("REP. NIVEL ACADEMICO");
        jButtonNivelAcade.setToolTipText("Informe de los grados (niveles académicos) que existen en la institución");
        jButtonNivelAcade.setBorder(null);
        jButtonNivelAcade.setBorderPainted(false);
        jButtonNivelAcade.setContentAreaFilled(false);
        jButtonNivelAcade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNivelAcade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonCalificGrupal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCalificGrupal.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCalificGrupal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteCalifGrupo.png"))); // NOI18N
        jButtonCalificGrupal.setText("REP. GRUPAL CALIF.");
        jButtonCalificGrupal.setToolTipText("Informe grupal de las calificaciones obtenidas por los estudiantes en cada asignatura");
        jButtonCalificGrupal.setBorder(null);
        jButtonCalificGrupal.setBorderPainted(false);
        jButtonCalificGrupal.setContentAreaFilled(false);
        jButtonCalificGrupal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCalificGrupal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonCalificIndividual.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCalificIndividual.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCalificIndividual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteCalifIndiv.png"))); // NOI18N
        jButtonCalificIndividual.setText("REP. INDIVIDUAL CALIF.");
        jButtonCalificIndividual.setToolTipText("Informe individual de calificaciones obtenidas por cada estudiante.");
        jButtonCalificIndividual.setBorder(null);
        jButtonCalificIndividual.setBorderPainted(false);
        jButtonCalificIndividual.setContentAreaFilled(false);
        jButtonCalificIndividual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCalificIndividual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonIndicadores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonIndicadores.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIndicadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteIndicadores.png"))); // NOI18N
        jButtonIndicadores.setText("REP. INDICADORES");
        jButtonIndicadores.setToolTipText("Informe de los indicadores de logro que tiene cada asignatura para cada periodo académico.");
        jButtonIndicadores.setBorder(null);
        jButtonIndicadores.setBorderPainted(false);
        jButtonIndicadores.setContentAreaFilled(false);
        jButtonIndicadores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIndicadores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonIndicadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIndicadoresActionPerformed(evt);
            }
        });

        jDesktopPaneFondo.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonRepIndividual, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonRepGrado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonRepAsignaturas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonRepAreas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonNivelAcade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonCalificGrupal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonCalificIndividual, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonIndicadores, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneFondoLayout = new javax.swing.GroupLayout(jDesktopPaneFondo);
        jDesktopPaneFondo.setLayout(jDesktopPaneFondoLayout);
        jDesktopPaneFondoLayout.setHorizontalGroup(
            jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                        .addComponent(jButtonRepGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(477, 477, 477))
                    .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRepIndividual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRepAreas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143)
                        .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCalificGrupal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDocente)
                            .addComponent(jButtonRepAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneFondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNivelAcade, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jButtonCalificIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jButtonIndicadores, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPaneFondoLayout.setVerticalGroup(
            jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButtonRepIndividual))
                            .addComponent(jButtonRepAsignaturas))
                        .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jButtonRepGrado))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneFondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCalificGrupal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                        .addComponent(jButtonCalificIndividual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNivelAcade, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneFondoLayout.createSequentialGroup()
                            .addComponent(jButtonRepAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51))
                        .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                            .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonIndicadores))
                            .addGap(53, 53, 53)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneFondoLayout.createSequentialGroup()
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );

        getContentPane().add(jDesktopPaneFondo);
        jDesktopPaneFondo.setBounds(0, 0, 1240, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // SALIR AL PRINCIPAL:     
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonRepAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepAreasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRepAreasActionPerformed

    private void jButtonIndicadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndicadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIndicadoresActionPerformed

    private void jButtonRepGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepGradoActionPerformed
        try {
            StudentsDegree st = new StudentsDegree();
            st.setVisible(true);
            jDesktopPaneFondo.add(st);
            st.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRepGradoActionPerformed

    private void jButtonDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocenteActionPerformed
        createReports2("src/Interfaces/TeachersReport.jrxml", "InformeDocentes");
    }//GEN-LAST:event_jButtonDocenteActionPerformed
public void createReports(String direc, String titulo, String param){
    Connection con = null;
         
        try {
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/signo_db","root","");
        } catch (Exception e) {
        } 
        try{
                Map parametro = new HashMap(); 
                parametro.put("id", param);

                JasperReport report = JasperCompileManager.compileReport (direc);
                JasperPrint print = JasperFillManager.fillReport(report, parametro, con ); 
                JasperExportManager.exportReportToPdfFile(print,titulo+".pdf"); 

                JasperViewer jviewer= new JasperViewer(print,false); 
                jviewer.setTitle(titulo); 
                jviewer.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
}
public void createReports2(String direc, String titulo){
    Connection con = null;
         
        try {
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/signo_db","root","");
        } catch (Exception e) {
        } 
       
                try { 
                JasperReport report = JasperCompileManager.compileReport (direc);
                JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), con ); 
                JasperExportManager.exportReportToPdfFile(print,titulo+".pdf"); 

                JasperViewer jviewer= new JasperViewer(print,false); 
                jviewer.setTitle(titulo); 
                jviewer.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
            
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalificGrupal;
    private javax.swing.JButton jButtonCalificIndividual;
    private javax.swing.JButton jButtonDocente;
    private javax.swing.JButton jButtonIndicadores;
    private javax.swing.JButton jButtonNivelAcade;
    private javax.swing.JButton jButtonRepAreas;
    private javax.swing.JButton jButtonRepAsignaturas;
    private javax.swing.JButton jButtonRepGrado;
    private javax.swing.JButton jButtonRepIndividual;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JDesktopPane jDesktopPaneFondo;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
