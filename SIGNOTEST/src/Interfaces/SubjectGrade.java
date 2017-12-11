/* CONECTAR CON LAS INTERCES DE LOGROS MATERIAS ASIGNATURAS NOTAS */
package Interfaces;
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
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jDesktopPaneFondo.setBackground(new java.awt.Color(0, 0, 255));

        jLabelTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("INGRESO DE ?");
        jDesktopPaneFondo.add(jLabelTitulo);
        jLabelTitulo.setBounds(0, 30, 730, 22);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/asignaturas.png"))); // NOI18N
        jButton1.setText("   ASIGNATURAS   ");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPaneFondo.add(jButton1);
        jButton1.setBounds(80, 130, 180, 170);

        getContentPane().add(jDesktopPaneFondo);
        jDesktopPaneFondo.setBounds(0, 0, 730, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // CONECTAR CON LA INTERFAZ ASIGNATURAS:
        EnterSubjects entSub = new EnterSubjects();
        entSub.setVisible(true);
        entSub.setLocation(300, 50);
        jDesktopPaneFondo.add(entSub);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPaneFondo;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
