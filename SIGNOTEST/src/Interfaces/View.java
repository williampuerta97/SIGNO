
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class View extends javax.swing.JInternalFrame {
    ConexionDB con;
    DefaultTableModel Modelo;
    
    
    public View() {
        initComponents();
        con=new ConexionDB();
        ingreso();

        //creacion de columnas         
    }
    public void ingreso (){
        String titulos[] = {"Id_actividad","Nombre","Descripcion","Estado","Fecha_de_entrega","Grupo_id","Logro_id","Porcentaje"};
        Modelo = new DefaultTableModel(null,titulos);
        String datos[]=new String [8];
       
        try {
            ResultSet rs = con.consultDB("SELECT idActividad, Nombre, Descripcion, Estado, Fecha_entrega, Grupo_id, Logro_id, Porcentaje FROM actividad");
            while(rs.next()){
                datos[0] = rs.getString("idActividad");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Descripcion");
                datos[3] = rs.getString("Estado");
                datos[4] = rs.getString("Fecha_Entrega");
                datos[5] = rs.getString("Grupo_Id");
                datos[6] = rs.getString("Logro_Id");
                datos[7] = rs.getString("Porcentaje");
                
                Modelo.addRow(datos);
                
            }
            jTable1.setModel(Modelo);
            
        } catch (Exception e) {
            System.out.println("error"+ e);
        }
       
        
}

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        jMenuItem1.setText("Eliminar");
        jMenuItem1.setComponentPopupMenu(jPopupMenu1);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator1);

        jMenuItem2.setText("Agregar");
        jMenuItem2.setComponentPopupMenu(jPopupMenu1);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                int fila = jTable1.getSelectedRow();
                String value = jTable1.getValueAt(fila, 0).toString();
                
                if (fila >= 0) {
            con.modifyDB("UPDATE actividad SET Estado = 0 WHERE idActividad= '" + value + "'");
            JOptionPane.showMessageDialog(rootPane, "Dato eliminado");
        }
                ingreso();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int fila = jTable1.getSelectedRow();
                String value = jTable1.getValueAt(fila, 0).toString();
                
                if (fila >= 0) {
            con.modifyDB("UPDATE actividad SET Estado = 1 WHERE idActividad= '" + value + "'");
            JOptionPane.showMessageDialog(rootPane, "Dato Agregado");
        }
                ingreso();
                               
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
