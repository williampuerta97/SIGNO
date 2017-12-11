/* ACCESO AL PANEL PRINCIPAL DE SIGNO  */
package Interfaces;


import Resources.Main_Background;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
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
        jPanelAdmin.setLayout(null);
        jPanelAcademic.setLayout(null);
        //System.out.println(rol+"-"+id+"-"+user);
        this.setLocationRelativeTo(null);
        this.rSButtonRegistro.setSelected(true);
       /*ESTABLECER EL FONDO DE LA HOJA*/
        imagen1 = new File ("src/Img/fond.jpg");
         try{                
           
            BufferedImage image = ImageIO.read(imagen1);      
            
              jDesktopPaneFondo.setBorder(new Main_Background(image)); }
        catch (Exception e){   
            System.out.println("Noo imagen, sorry"+ e);   
        }
        /*FIN DEL PROCESO DE ESTABLECER FONDO */
        /*NOMBRE DEL USUARIO EN EL PANEL*/
        jLabelUser.setText(user);
        /*OCULTACION DE MENU LATERAL*/
            Animacion.Animacion.mover_izquierda(0, -188, 0, 188 , jPanelDespMenu);
        /* VALIDACION DE INGRESO DEL ROL*/
            if (rol==1) {
            
            }else if (rol==2) {
                
            }else if (rol==3) {
                
            }else if (rol==4) {
                
            }
        /*OCULTAMIENTO DE MENU VERTICAL ADMIN*/
            Animacion.Animacion.subir(35, -160, 1, 10 , jPanelAdmin);
            Animacion.Animacion.subir(160, 35, 1, 10 , jPanelGFAcademico);
            jPanelAdmin.setVisible(false);
        /*OCULTAMIENTO DE MENU VERTICAL ACADEMICO*/
            //Animacion.Animacion.subir(35, -160, 1, 10 , jPanelAcademic);
            jPanelAcademic.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jDesktopPaneFondo = new javax.swing.JDesktopPane();
        jPanelMenu = new javax.swing.JPanel();
        jLabelUser = new javax.swing.JLabel();
        rSButtonMenu = new Resources.RSButtonMetro();
        jPanelDespMenu = new javax.swing.JPanel();
        rSButtonMetroGAdmin = new Resources.RSButtonMetro();
        jPanelAdmin = new javax.swing.JPanel();
        rSButtonRegistro = new Resources.RSButtonMetro();
        rSButtonReportes = new Resources.RSButtonMetro();
        rSButtonInactivos = new Resources.RSButtonMetro();
        jPanelGFAcademico = new javax.swing.JPanel();
        rSButtonMetroGAcadem = new Resources.RSButtonMetro();
        jPanelAcademic = new javax.swing.JPanel();
        rSButtonNotas = new Resources.RSButtonMetro();
        rSButtonGrados = new Resources.RSButtonMetro();
        rSButtonLogros = new Resources.RSButtonMetro();
        rSButtonMaterias = new Resources.RSButtonMetro();
        rSButtonCalifica = new Resources.RSButtonMetro();
        rSButtonPeriodo = new Resources.RSButtonMetro();
        rSButtonEvento = new Resources.RSButtonMetro();
        jButtonSalir = new javax.swing.JButton();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jDesktopPaneFondo.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPaneFondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jPanelMenu.setBackground(new java.awt.Color(0, 0, 255));
        jPanelMenu.setLayout(null);

        jLabelUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMenu.add(jLabelUser);
        jLabelUser.setBounds(1000, 10, 250, 20);

        rSButtonMenu.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu.png"))); // NOI18N
        rSButtonMenu.setColorHover(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonMenu.setOpaque(false);
        rSButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMenuActionPerformed(evt);
            }
        });
        jPanelMenu.add(rSButtonMenu);
        rSButtonMenu.setBounds(0, 0, 80, 40);

        jDesktopPaneFondo.add(jPanelMenu);
        jPanelMenu.setBounds(-3, -1, 1260, 40);

        jPanelDespMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDespMenu.setOpaque(false);
        jPanelDespMenu.setLayout(null);

        rSButtonMetroGAdmin.setBackground(new java.awt.Color(0, 0, 255));
        rSButtonMetroGAdmin.setText("G. ADMINISTRATIVA");
        rSButtonMetroGAdmin.setColorHover(new java.awt.Color(0, 0, 255));
        rSButtonMetroGAdmin.setColorNormal(new java.awt.Color(0, 0, 255));
        rSButtonMetroGAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetroGAdminActionPerformed(evt);
            }
        });
        jPanelDespMenu.add(rSButtonMetroGAdmin);
        rSButtonMetroGAdmin.setBounds(0, 0, 180, 50);

        jPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAdmin.setLayout(null);

        rSButtonRegistro.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRegistro.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/roles.png"))); // NOI18N
        rSButtonRegistro.setText("   REGISTRO  ");
        rSButtonRegistro.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRegistro.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonRegistro.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonRegistro.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonRegistro.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonRegistro.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRegistroActionPerformed(evt);
            }
        });
        jPanelAdmin.add(rSButtonRegistro);
        rSButtonRegistro.setBounds(0, 0, 180, 40);

        rSButtonReportes.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reportes.png"))); // NOI18N
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
        jPanelAdmin.add(rSButtonReportes);
        rSButtonReportes.setBounds(0, 50, 180, 40);

        rSButtonInactivos.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonInactivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inactivo.png"))); // NOI18N
        rSButtonInactivos.setText("   INACTIVOS");
        rSButtonInactivos.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonInactivos.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonInactivos.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonInactivos.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonInactivos.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonInactivos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonInactivos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelAdmin.add(rSButtonInactivos);
        rSButtonInactivos.setBounds(0, 100, 180, 40);

        jPanelDespMenu.add(jPanelAdmin);
        jPanelAdmin.setBounds(0, 50, 180, 150);

        jPanelGFAcademico.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGFAcademico.setLayout(null);

        rSButtonMetroGAcadem.setBackground(new java.awt.Color(0, 0, 255));
        rSButtonMetroGAcadem.setText("G. ACADEMICA");
        rSButtonMetroGAcadem.setColorHover(new java.awt.Color(0, 0, 255));
        rSButtonMetroGAcadem.setColorNormal(new java.awt.Color(0, 0, 255));
        rSButtonMetroGAcadem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetroGAcademActionPerformed(evt);
            }
        });
        jPanelGFAcademico.add(rSButtonMetroGAcadem);
        rSButtonMetroGAcadem.setBounds(0, 0, 180, 50);

        jPanelAcademic.setOpaque(false);
        jPanelAcademic.setLayout(null);

        rSButtonNotas.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/asignaturas.png"))); // NOI18N
        rSButtonNotas.setText("   NOTAS  ");
        rSButtonNotas.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonNotas.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonNotas.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonNotas.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonNotas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonNotas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonNotas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonNotasActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonNotas);
        rSButtonNotas.setBounds(0, 10, 180, 50);

        rSButtonGrados.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonGrados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/grados.png"))); // NOI18N
        rSButtonGrados.setText("   GRADOS  ");
        rSButtonGrados.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonGrados.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonGrados.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonGrados.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonGrados.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonGrados.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonGrados.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonGrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonGradosActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonGrados);
        rSButtonGrados.setBounds(0, 70, 180, 50);

        rSButtonLogros.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonLogros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logros.png"))); // NOI18N
        rSButtonLogros.setText("   LOGROS  ");
        rSButtonLogros.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonLogros.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonLogros.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonLogros.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonLogros.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonLogros.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonLogros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonLogros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonLogrosActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonLogros);
        rSButtonLogros.setBounds(0, 130, 180, 40);

        rSButtonMaterias.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMaterias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/materias.png"))); // NOI18N
        rSButtonMaterias.setText("   MATERIAS  ");
        rSButtonMaterias.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonMaterias.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonMaterias.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonMaterias.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonMaterias.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonMaterias.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonMaterias.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMateriasActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonMaterias);
        rSButtonMaterias.setBounds(0, 180, 180, 40);

        rSButtonCalifica.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonCalifica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/notas.png"))); // NOI18N
        rSButtonCalifica.setText("   CALIFICACION  ");
        rSButtonCalifica.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonCalifica.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonCalifica.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonCalifica.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonCalifica.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonCalifica.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonCalifica.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonCalifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonCalificaActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonCalifica);
        rSButtonCalifica.setBounds(0, 230, 180, 40);

        rSButtonPeriodo.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Periodo.png"))); // NOI18N
        rSButtonPeriodo.setText("   PERIODO  ");
        rSButtonPeriodo.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonPeriodo.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonPeriodo.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonPeriodo.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonPeriodo.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonPeriodo.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonPeriodo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonPeriodoActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonPeriodo);
        rSButtonPeriodo.setBounds(0, 280, 180, 40);

        rSButtonEvento.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eventos.png"))); // NOI18N
        rSButtonEvento.setText("   EVENTOS   ");
        rSButtonEvento.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonEvento.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonEvento.setColorPressed(new java.awt.Color(255, 255, 255));
        rSButtonEvento.setColorTextNormal(new java.awt.Color(0, 0, 0));
        rSButtonEvento.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rSButtonEvento.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonEvento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonEventoActionPerformed(evt);
            }
        });
        jPanelAcademic.add(rSButtonEvento);
        rSButtonEvento.setBounds(0, 330, 180, 40);

        jPanelGFAcademico.add(jPanelAcademic);
        jPanelAcademic.setBounds(0, 50, 180, 380);

        jPanelDespMenu.add(jPanelGFAcademico);
        jPanelGFAcademico.setBounds(0, 200, 180, 460);

        jDesktopPaneFondo.add(jPanelDespMenu);
        jPanelDespMenu.setBounds(0, 40, 180, 660);

        jButtonSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salir.png"))); // NOI18N
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
        jButtonSalir.setBounds(1170, 650, 70, 44);

        getContentPane().add(jDesktopPaneFondo);
        jDesktopPaneFondo.setBounds(0, 0, 1250, 700);

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

    private void rSButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonReportesActionPerformed

        try {
            // CONEXION A LA INTERFAZ REPORTES:
            Reports rep = new Reports();
            this.setLocationRelativeTo(null);
            rep.setVisible(true);
            jDesktopPaneFondo.add(rep);
            rep.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rSButtonReportesActionPerformed

    private void rSButtonLogrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonLogrosActionPerformed
        // TODO add your handling code here:
        Achievements achie = new Achievements();
        achie.setVisible(true);
        achie.setLocation(300, 50);
        jDesktopPaneFondo.add(achie);
    }//GEN-LAST:event_rSButtonLogrosActionPerformed

    private void rSButtonNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonNotasActionPerformed
        EnterSubjects entSub = new EnterSubjects();
        entSub.setVisible(true);
        entSub.setLocation(300, 50);
        jDesktopPaneFondo.add(entSub);
    }//GEN-LAST:event_rSButtonNotasActionPerformed

    private void rSButtonGradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonGradosActionPerformed
        EnterDegrees entDeg = new EnterDegrees();
        entDeg.setVisible(true);
        entDeg.setSize(610, 467);
        entDeg.setLocation(300, 50);
        jDesktopPaneFondo.add(entDeg);
    }//GEN-LAST:event_rSButtonGradosActionPerformed

    private void rSButtonMetroGAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetroGAdminActionPerformed
       // DESPLIGUE OPCIONES DEL MENU ADMIN:
        int posicion = this.jPanelAdmin.getY();
            if (posicion > -1) {
            Animacion.Animacion.subir(35, -160, 1, 10 , jPanelAdmin);
            Animacion.Animacion.subir(160, 35, 1, 10 , jPanelGFAcademico);
            jPanelAdmin.setVisible(false);
            }
            else {
            Animacion.Animacion.bajar(-160, 50, 1, 10 , jPanelAdmin);
            Animacion.Animacion.bajar(50, 200, 1, 10 , jPanelGFAcademico);
           // Animacion.Animacion.bajar(60, 210, 1, 10, jPanelAcademic);
            jPanelAdmin.setVisible(true);
            }     
    }//GEN-LAST:event_rSButtonMetroGAdminActionPerformed

    private void rSButtonMetroGAcademActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetroGAcademActionPerformed
               // DESPLIGUE OPCIONES DEL MENU ADMIN:
        int posicion = this.jPanelAcademic.getY();
            if (posicion > -1) {
            Animacion.Animacion.subir(35, -200, 1, 10 , jPanelAcademic);
            jPanelAcademic.setVisible(false);
            }
            else {
            Animacion.Animacion.bajar(-200, 50, 1, 10 , jPanelAcademic);
            jPanelAcademic.setVisible(true);
            } 
    }//GEN-LAST:event_rSButtonMetroGAcademActionPerformed

    private void rSButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRegistroActionPerformed

        
            // CONEXION A LA INTERFAZ REPORTES:
            /*RegisterUser regsuser = new RegisterUser();
            this.setLocationRelativeTo(null);
            regsuser.setVisible(true);
            jDesktopPaneFondo.add(regsuser);
            regsuser.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            RegisterUser regsuser = new RegisterUser();
            regsuser.setVisible(true);
            regsuser.setLocation(300, 50);
            jDesktopPaneFondo.add(regsuser);
    }//GEN-LAST:event_rSButtonRegistroActionPerformed

    private void rSButtonMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMateriasActionPerformed
       
        Subjects subj = new Subjects();
        subj.setVisible(true);
        subj.setLocation(300, 50);
        jDesktopPaneFondo.add(subj);
    }//GEN-LAST:event_rSButtonMateriasActionPerformed

    private void rSButtonEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonEventoActionPerformed
        Events eve = new Events();
        eve.setVisible(true);
        eve.setLocation(300, 50);
        jDesktopPaneFondo.add(eve);
    }//GEN-LAST:event_rSButtonEventoActionPerformed

    private void rSButtonCalificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCalificaActionPerformed

        try {
            // CONEXION A LA INTERFAZ REPORTES:
            Grades grade = new Grades();
            this.setLocationRelativeTo(null);
            grade.setVisible(true);
            jDesktopPaneFondo.add(grade);
            grade.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_rSButtonCalificaActionPerformed

    private void rSButtonPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonPeriodoActionPerformed
        periodo per = new periodo();
        per.setVisible(true);
        per.setLocation(300, 50);
        jDesktopPaneFondo.add(per);
    }//GEN-LAST:event_rSButtonPeriodoActionPerformed

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
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanelAcademic;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelDespMenu;
    private javax.swing.JPanel jPanelGFAcademico;
    private javax.swing.JPanel jPanelMenu;
    private Resources.RSButtonMetro rSButtonCalifica;
    private Resources.RSButtonMetro rSButtonEvento;
    private Resources.RSButtonMetro rSButtonGrados;
    private Resources.RSButtonMetro rSButtonInactivos;
    private Resources.RSButtonMetro rSButtonLogros;
    private Resources.RSButtonMetro rSButtonMaterias;
    private Resources.RSButtonMetro rSButtonMenu;
    private Resources.RSButtonMetro rSButtonMetroGAcadem;
    private Resources.RSButtonMetro rSButtonMetroGAdmin;
    private Resources.RSButtonMetro rSButtonNotas;
    private Resources.RSButtonMetro rSButtonPeriodo;
    private Resources.RSButtonMetro rSButtonRegistro;
    private Resources.RSButtonMetro rSButtonReportes;
    // End of variables declaration//GEN-END:variables
}