 /* LOGUE A SISTEMA DE CONTROL DE NOTAS  */
package Interfaces;

import com.mysql.jdbc.log.Log;
import Resources.DisenoPlac;
import Resources.MensajesLoguin;
import Resources.Connection;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*@author SIGNO */
public class Login extends javax.swing.JFrame {
    MensajesLoguin mensaje;
    DisenoPlac diseno;
 
    public Login() throws MalformedURLException {
        initComponents();
        this.setLocationRelativeTo(null);
        mensaje = new MensajesLoguin();
        diseno = new DisenoPlac();
        Iniciar();
    }
    
    public Image getIconImage(){
    Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/ico.png"));
        return retValue;    
    }
    
    public void Iniciar(){
        diseno.Mensaje(txtUser, mensaje.getUsuario(), 0);
        diseno.Mensaje1(jpassw, mensaje.getContrasena(), 0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jpassw = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtInicio = new javax.swing.JButton();
        BtSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\JH0N4T4N\\Desktop\\l_.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INICIO DE SESION");

        txtUser.setBackground(new java.awt.Color(0, 0, 51));
        txtUser.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setBorder(null);
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        jpassw.setBackground(new java.awt.Color(0, 0, 51));
        jpassw.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jpassw.setForeground(new java.awt.Color(255, 255, 255));
        jpassw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jpassw.setBorder(null);
        jpassw.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpasswFocusLost(evt);
            }
        });
        jpassw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpasswMouseClicked(evt);
            }
        });
        jpassw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpasswKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        BtInicio.setBackground(new java.awt.Color(0, 0, 0));
        BtInicio.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtInicio.setForeground(new java.awt.Color(255, 255, 255));
        BtInicio.setText("CONECTAR");
        BtInicio.setBorder(null);
        BtInicio.setBorderPainted(false);
        BtInicio.setContentAreaFilled(false);
        BtInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtInicioActionPerformed(evt);
            }
        });

        BtSalir.setBackground(new java.awt.Color(0, 0, 0));
        BtSalir.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BtSalir.setForeground(new java.awt.Color(255, 255, 255));
        BtSalir.setText("SALIR");
        BtSalir.setBorder(null);
        BtSalir.setBorderPainted(false);
        BtSalir.setContentAreaFilled(false);
        BtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpassw, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(BtInicio)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtSalir))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(104, 104, 104)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jpassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(63, 63, 63)
                .addComponent(BtInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(BtSalir))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        // PLACEH LOGUE:
        diseno.Mensaje(txtUser, mensaje.getUsuario(), txtUser.getText().length());
    }//GEN-LAST:event_txtUserFocusLost

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        diseno.Clic(txtUser, mensaje.getUsuario());
    }//GEN-LAST:event_txtUserMouseClicked

    private void jpasswFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpasswFocusLost
        // PLACEH LOGUE:
        diseno.Mensaje1(jpassw, mensaje.getContrasena(), jpassw.getText().length());
    }//GEN-LAST:event_jpasswFocusLost

    private void jpasswMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpasswMouseClicked
        diseno.Clic1(jpassw, mensaje.getContrasena());
    }//GEN-LAST:event_jpasswMouseClicked

    private void BtInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtInicioActionPerformed
        // CONECTAT CON BASE DE DATOS VALIDAR Y ACCEDER AL MODULO PRINCIPAL:
          Connection con = new Connection();
         try {
            String user=txtUser.getText();
            String password=jpassw.getText();
            
            ResultSet rs = con.consultDB("SELECT usu.*, rol.* FROM usuario as usu INNER JOIN rol as rol ON usu.Rol_id=rol.idRol "
                    + "WHERE usu.usuario='"+user+"' AND usu.contrasena='"+password+"'");
            if (rs.next()) {
                Main.id=rs.getInt("usu.nuip");
                Main.user = rs.getString("usu.usuario");
                Main.rol = rs.getInt("usu.Rol_id");
                
                Main mainWindow = new Main();
                mainWindow.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Error en los datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_BtInicioActionPerformed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        // CONECTAR AL DAR ENTER:
         char cTeclaPresionada=evt.getKeyChar();
            if (cTeclaPresionada==KeyEvent.VK_ENTER) {
            BtInicio.doClick();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void jpasswKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpasswKeyTyped
        // CONECTAR AL DAR ENTER:
        char cTeclaPresionada=evt.getKeyChar();
            if (cTeclaPresionada==KeyEvent.VK_ENTER) {
            BtInicio.doClick();
        }
    }//GEN-LAST:event_jpasswKeyTyped

    private void BtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalirActionPerformed
        // CERRAR INICIO:
        System.exit(0);
    }//GEN-LAST:event_BtSalirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtInicio;
    private javax.swing.JButton BtSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jpassw;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
