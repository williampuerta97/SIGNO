/* CONEXION DE INTERFACES CORRESPONDIENTES A LA NACIONALIDAD DEL USUARIO */
package Interfaces;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author 1354951 */
public class Nationality extends javax.swing.JInternalFrame {


    public Nationality() {
        initComponents();
        setSize(1248,663);
        setLocation(0,36);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneFondo = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        btnPais = new javax.swing.JButton();
        btnDepartament = new javax.swing.JButton();
        btnCiudad = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        jDesktopPaneFondo.setBackground(new java.awt.Color(0, 0, 255));

        jLabelTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CREACION DE NACIONALIDAD");

        btnPais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPais.setForeground(new java.awt.Color(255, 255, 255));
        btnPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Mapais.png"))); // NOI18N
        btnPais.setText("PAIS");
        btnPais.setBorder(null);
        btnPais.setBorderPainted(false);
        btnPais.setContentAreaFilled(false);
        btnPais.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPais.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaisActionPerformed(evt);
            }
        });

        btnDepartament.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDepartament.setForeground(new java.awt.Color(255, 255, 255));
        btnDepartament.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/departament.png"))); // NOI18N
        btnDepartament.setText("DEPARTAMENTO");
        btnDepartament.setBorder(null);
        btnDepartament.setBorderPainted(false);
        btnDepartament.setContentAreaFilled(false);
        btnDepartament.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDepartament.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDepartament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentActionPerformed(evt);
            }
        });

        btnCiudad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCiudad.setForeground(new java.awt.Color(255, 255, 255));
        btnCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ciudad.png"))); // NOI18N
        btnCiudad.setText("CIUDAD");
        btnCiudad.setBorder(null);
        btnCiudad.setBorderPainted(false);
        btnCiudad.setContentAreaFilled(false);
        btnCiudad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCiudad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
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

        jDesktopPaneFondo.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(btnPais, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(btnDepartament, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(btnCiudad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneFondo.setLayer(jButtonSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneFondoLayout = new javax.swing.GroupLayout(jDesktopPaneFondo);
        jDesktopPaneFondo.setLayout(jDesktopPaneFondoLayout);
        jDesktopPaneFondoLayout.setHorizontalGroup(
            jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(btnPais, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneFondoLayout.createSequentialGroup()
                .addContainerGap(497, Short.MAX_VALUE)
                .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(406, 406, 406)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPaneFondoLayout.setVerticalGroup(
            jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelTitulo)
                .addGap(134, 134, 134)
                .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPais, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPaneFondoLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneFondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneFondo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaisActionPerformed
        try {
            // CONEXION A LA INTERFAZ DE PAIS:
            Country country = new Country();
            country.setVisible(true);
            jDesktopPaneFondo.add(country);
            country.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Nationality.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPaisActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // SALIR AL PRINCIPAL:
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void btnDepartamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentActionPerformed
        try {
            // CONEXION A LA INTERFAZ DE DEPARTAMENTO:
            Departament depart = new Departament();
            depart.setVisible(true);
            jDesktopPaneFondo.add(depart);
            depart.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Nationality.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDepartamentActionPerformed

    private void btnCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadActionPerformed
        try {
            // CONEXION A LA INTERFAZ DE CIUDAD:
            City ciudad = new City();
            ciudad.setVisible(true);
            jDesktopPaneFondo.add(ciudad);
            ciudad.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Nationality.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCiudadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCiudad;
    private javax.swing.JButton btnDepartament;
    private javax.swing.JButton btnPais;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JDesktopPane jDesktopPaneFondo;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
