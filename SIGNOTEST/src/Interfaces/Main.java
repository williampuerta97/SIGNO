/* ACCESO AL PANEL PRINCIPAL DE SIGNO  */
package Interfaces;


import Resources.FondoPrincipal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/* @author JH0N4T4N */
public class Main extends javax.swing.JFrame {
/*LLAMADO PARA EL FONDO DE LA HOJA*/
    public File imagen1;
    public static int rol;
    public static int id;
    public static String user;
    
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.rSButtonRoles.setSelected(true);
       /*ESTABLECER EL FONDO DE LA HOJA*/
        imagen1 = new File ("src/Img/fond.jpg");
         try{                
           
            BufferedImage image = ImageIO.read(imagen1);      
            
              jDesktopPaneFondo.setBorder(new FondoPrincipal(image)); }
        catch (Exception e){   
            System.out.println("Noo imagen, sorry"+ e);   
        }
        /*FIN DEL PROCESO DE ESTABLECER FONDO */
         
        /*OCULTACION DE MENU LATERAL*/
            Animacion.Animacion.mover_izquierda(0, -188, 0, 188 , jPanelDespMenu);
        
            if (rol==1) {
            
            }else if (rol==2) {
                jPanelDespMenu.setVisible(false);
            }
 
            
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jDesktopPaneFondo = new javax.swing.JDesktopPane();
        jPanelMenu = new javax.swing.JPanel();
        rSButtonMenu = new Resources.RSButtonMetro();
        jPanelDespMenu = new javax.swing.JPanel();
        jPanelIdentificador = new javax.swing.JPanel();
        jLabelNombrecategoria = new javax.swing.JLabel();
        jPanelAdmin = new javax.swing.JPanel();
        rSButtonRoles = new Resources.RSButtonMetro();
        rSButtonReportes = new Resources.RSButtonMetro();
        rSButtonInactivos = new Resources.RSButtonMetro();
        jPanelIdentificador2 = new javax.swing.JPanel();
        jLabelNombrecategoria2 = new javax.swing.JLabel();
        jPanelAcademic = new javax.swing.JPanel();
        rSButtonInactivosAsignatura = new Resources.RSButtonMetro();
        rSButtonInactivosGrados = new Resources.RSButtonMetro();
        rSButtonInactivosLogros = new Resources.RSButtonMetro();
        rSButtonInactivosMaterias = new Resources.RSButtonMetro();
        rSButtonInactivosNota = new Resources.RSButtonMetro();
        rSButtonInactivosPeriodo = new Resources.RSButtonMetro();
        rSButtonInactivosEvento = new Resources.RSButtonMetro();
        jButtonSalir = new javax.swing.JButton();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPaneFondo.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPaneFondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jPanelMenu.setBackground(new java.awt.Color(0, 0, 255));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonMenu.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        rSButtonMenu.setColorHover(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setOpaque(false);
        rSButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMenuActionPerformed(evt);
            }
        });
        jPanelMenu.add(rSButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jDesktopPaneFondo.add(jPanelMenu);
        jPanelMenu.setBounds(-3, -1, 1270, 40);

        jPanelDespMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDespMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelIdentificador.setBackground(new java.awt.Color(0, 0, 255));
        jPanelIdentificador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombrecategoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNombrecategoria.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombrecategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombrecategoria.setText("G. ADMINISTRATIVA");
        jLabelNombrecategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelIdentificador.add(jLabelNombrecategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, 30));

        jPanelDespMenu.add(jPanelIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        jPanelAdmin.setOpaque(false);
        jPanelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonRoles.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRoles.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/roles.png"))); // NOI18N
        rSButtonRoles.setText("   PERFILES  ");
        rSButtonRoles.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRoles.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonRoles.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonRoles.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonRoles.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonRoles.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonRoles.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRolesActionPerformed(evt);
            }
        });
        jPanelAdmin.add(rSButtonRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        rSButtonReportes.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        rSButtonReportes.setText("   REPORTES");
        rSButtonReportes.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonReportes.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonReportes.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonReportes.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonReportes.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonReportes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonReportesActionPerformed(evt);
            }
        });
        jPanelAdmin.add(rSButtonReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 40));

        rSButtonInactivos.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        rSButtonInactivos.setText("   INACTIVOS");
        rSButtonInactivos.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivos.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivos.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivos.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivos.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelAdmin.add(rSButtonInactivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 180, 40));

        jPanelDespMenu.add(jPanelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 160));

        jPanelIdentificador2.setBackground(new java.awt.Color(0, 0, 255));
        jPanelIdentificador2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombrecategoria2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNombrecategoria2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombrecategoria2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombrecategoria2.setText("  G. ACADEMICA");
        jPanelIdentificador2.add(jLabelNombrecategoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, 30));

        jPanelDespMenu.add(jPanelIdentificador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 212, 180, 50));

        jPanelAcademic.setOpaque(false);
        jPanelAcademic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonInactivosAsignatura.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivosAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asignaturas.png"))); // NOI18N
        rSButtonInactivosAsignatura.setText("   ASIGNATURAS  ");
        rSButtonInactivosAsignatura.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivosAsignatura.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivosAsignatura.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivosAsignatura.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivosAsignatura.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivosAsignatura.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivosAsignatura.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonInactivosAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonInactivosAsignaturaActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonInactivosAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        rSButtonInactivosGrados.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivosGrados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/grados.png"))); // NOI18N
        rSButtonInactivosGrados.setText("   GRADOS  ");
        rSButtonInactivosGrados.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivosGrados.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivosGrados.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivosGrados.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivosGrados.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivosGrados.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivosGrados.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonInactivosGrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonInactivosGradosActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonInactivosGrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 50));

        rSButtonInactivosLogros.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivosLogros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logros.png"))); // NOI18N
        rSButtonInactivosLogros.setText("   LOGROS  ");
        rSButtonInactivosLogros.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivosLogros.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivosLogros.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivosLogros.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivosLogros.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivosLogros.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivosLogros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonInactivosLogros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonInactivosLogrosActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonInactivosLogros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 180, 40));

        rSButtonInactivosMaterias.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivosMaterias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/materias.png"))); // NOI18N
        rSButtonInactivosMaterias.setText("   MATERIAS  ");
        rSButtonInactivosMaterias.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivosMaterias.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivosMaterias.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivosMaterias.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivosMaterias.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivosMaterias.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivosMaterias.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelAcademic.add(rSButtonInactivosMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 180, 40));

        rSButtonInactivosNota.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivosNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/notas.png"))); // NOI18N
        rSButtonInactivosNota.setText("   NOTAS  ");
        rSButtonInactivosNota.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivosNota.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivosNota.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivosNota.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivosNota.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivosNota.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivosNota.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelAcademic.add(rSButtonInactivosNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, 40));

        rSButtonInactivosPeriodo.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivosPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Periodo.png"))); // NOI18N
        rSButtonInactivosPeriodo.setText("   PERIODO  ");
        rSButtonInactivosPeriodo.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivosPeriodo.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivosPeriodo.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivosPeriodo.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivosPeriodo.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivosPeriodo.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivosPeriodo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelAcademic.add(rSButtonInactivosPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 40));

        rSButtonInactivosEvento.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivosEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        rSButtonInactivosEvento.setText("   EVENTOS");
        rSButtonInactivosEvento.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivosEvento.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivosEvento.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivosEvento.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivosEvento.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivosEvento.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivosEvento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelAcademic.add(rSButtonInactivosEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 180, 40));

        jPanelDespMenu.add(jPanelAcademic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 370));

        jDesktopPaneFondo.add(jPanelDespMenu);
        jPanelDespMenu.setBounds(0, 40, 180, 630);

        jButtonSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.setBorder(null);
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jDesktopPaneFondo.add(jButtonSalir);
        jButtonSalir.setBounds(1164, 643, 65, 44);

        getContentPane().add(jDesktopPaneFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // SALIR DEL PRINCIPAL:
        Login conecLog = null;
        try {
            conecLog = new Login();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecLog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void rSButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMenuActionPerformed
        // DESPLIGUE OPCIONES DEL MENU:
        int posicion = this.jPanelDespMenu.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -188, 2, 2 , jPanelDespMenu);
        }else {
            Animacion.Animacion.mover_derecha(-188, 0, 2, 2 , jPanelDespMenu);  
        }
    }//GEN-LAST:event_rSButtonMenuActionPerformed

    private void rSButtonRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRolesActionPerformed
    /*    try {
            // CONEXION A LA INTERFAZ PERFILES:
            Roles prf = new Roles();
            this.setLocationRelativeTo(null);
            prf.setVisible(true);
            jDesktopPaneFondo.add(prf);
            prf.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_rSButtonRolesActionPerformed

    private void rSButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonReportesActionPerformed

        // CONEXION A LA INTERFAZ REPORTES:
        Reportes rep = new Reportes();
        this.setLocationRelativeTo(null);
        rep.setVisible(true);
        jDesktopPaneFondo.add(rep);
        rep.setSelected(true);
    }//GEN-LAST:event_rSButtonReportesActionPerformed

    private void rSButtonInactivosLogrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonInactivosLogrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonInactivosLogrosActionPerformed

    private void rSButtonInactivosAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonInactivosAsignaturaActionPerformed
        EnterSubjects entSub = new EnterSubjects();
        entSub.setVisible(true);
        entSub.setSize(400, 550);
        entSub.setLocation(100, 300);
        jDesktopPaneFondo.add(entSub);
    }//GEN-LAST:event_rSButtonInactivosAsignaturaActionPerformed

    private void rSButtonInactivosGradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonInactivosGradosActionPerformed
        EnterDegrees entDeg = new EnterDegrees();
        entDeg.setVisible(true);
        entDeg.setSize(400, 550);
        entDeg.setLocation(100, 300);
        jDesktopPaneFondo.add(entDeg);
    }//GEN-LAST:event_rSButtonInactivosGradosActionPerformed

//   public static void main(String args[]) {
//      
//       /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//       /* try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        */
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Principal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JDesktopPane jDesktopPaneFondo;
    private javax.swing.JLabel jLabelNombrecategoria;
    private javax.swing.JLabel jLabelNombrecategoria2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanelAcademic;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelDespMenu;
    private javax.swing.JPanel jPanelIdentificador;
    private javax.swing.JPanel jPanelIdentificador2;
    private javax.swing.JPanel jPanelMenu;
    private Resources.RSButtonMetro rSButtonInactivos;
    private Resources.RSButtonMetro rSButtonInactivosAsignatura;
    private Resources.RSButtonMetro rSButtonInactivosEvento;
    private Resources.RSButtonMetro rSButtonInactivosGrados;
    private Resources.RSButtonMetro rSButtonInactivosLogros;
    private Resources.RSButtonMetro rSButtonInactivosMaterias;
    private Resources.RSButtonMetro rSButtonInactivosNota;
    private Resources.RSButtonMetro rSButtonInactivosPeriodo;
    private Resources.RSButtonMetro rSButtonMenu;
    private Resources.RSButtonMetro rSButtonReportes;
    private Resources.RSButtonMetro rSButtonRoles;
    // End of variables declaration//GEN-END:variables
}
