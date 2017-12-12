/* CONECTAR CON LAS INTERCES DE LOGROS MATERIAS ASIGNATURAS NOTAS */
package Interfaces;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author1354951 */
public class SubjectGrade extends javax.swing.JInternalFrame {

    public SubjectGrade() {
        initComponents();
        setSize(1248,663);
        setLocation(0,36);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneFondo = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        btnSubject = new javax.swing.JButton();
        btnDegree = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jDesktopPaneFondo.setBackground(new java.awt.Color(0, 0, 255));

        jLabelTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("INGRESO DE ?");
        jDesktopPaneFondo.add(jLabelTitulo);
        jLabelTitulo.setBounds(0, 30, 730, 22);

        btnSubject.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSubject.setForeground(new java.awt.Color(255, 255, 255));
        btnSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/asignaturas.png"))); // NOI18N
        btnSubject.setText("   ASIGNATURAS   ");
        btnSubject.setBorder(null);
        btnSubject.setBorderPainted(false);
        btnSubject.setContentAreaFilled(false);
        btnSubject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSubject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubjectActionPerformed(evt);
            }
        });
        jDesktopPaneFondo.add(btnSubject);
        btnSubject.setBounds(80, 130, 180, 170);

        btnDegree.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDegree.setForeground(new java.awt.Color(255, 255, 255));
        btnDegree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/grados.png"))); // NOI18N
        btnDegree.setText("   GRADO   ");
        btnDegree.setBorder(null);
        btnDegree.setBorderPainted(false);
        btnDegree.setContentAreaFilled(false);
        btnDegree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDegree.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDegree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDegreeActionPerformed(evt);
            }
        });
        jDesktopPaneFondo.add(btnDegree);
        btnDegree.setBounds(410, 130, 170, 180);

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
        jDesktopPaneFondo.add(jButtonSalir);
        jButtonSalir.setBounds(1160, 590, 80, 31);

        jButton1.setText("jButton1");
        jDesktopPaneFondo.add(jButton1);
        jButton1.setBounds(280, 490, 73, 23);

        getContentPane().add(jDesktopPaneFondo);
        jDesktopPaneFondo.setBounds(0, 0, 1240, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubjectActionPerformed
        // CONECTAR CON LA INTERFAZ ASIGNATURAS:
        EnterSubjects entSub = new EnterSubjects();
        entSub.setVisible(true);
        entSub.setSize(610, 467);
        entSub.setLocation(300, 50);
        jDesktopPaneFondo.add(entSub);
        try {
            entSub.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SubjectGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubjectActionPerformed

    private void btnDegreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDegreeActionPerformed
        EnterDegrees enterDeg = new EnterDegrees();
        enterDeg.setVisible(true);
        enterDeg.setSize(610, 467);
        enterDeg.setLocation(300, 50);
        jDesktopPaneFondo.add(enterDeg);
        try {
            enterDeg.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SubjectGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDegreeActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // SALIR AL PRINCIPAL:
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDegree;
    private javax.swing.JButton btnSubject;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JDesktopPane jDesktopPaneFondo;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
