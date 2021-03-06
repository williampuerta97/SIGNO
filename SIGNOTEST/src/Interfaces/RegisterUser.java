package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import Resources.Connection;
/**
 *
 * @author Grupo prueba y calidad
 */
public class RegisterUser extends javax.swing.JInternalFrame {

    Connection cone;
    String idRol[];
    String idCiudad[];
    String IdExpedicion[];
    String IdNacimiento[];
    String IdGroup[];

/**
 @author Grupo prueba y calidad
 version 1.0
 Constructor para inicializar la conexion con la base de datos
 y cada uno de los metodos donde se cargan los paises, departamentos ciudades y el rol de cada usuario.
 */
        
    public RegisterUser() {
        
        initComponents();
        setSize(1248,663);
        setLocation(0,36);
              
        cone = new Connection();
        cargarComboPais();
        cargarComboPais2();
        cargarComboExpedicion();
        cargarComboRol();
        cargarComboGroup ();
        
    }

    /**
    @author Grupo prueba y calidad
    version 1.1
    Metodo que genera los paises que se encuentran en la base de datos signo_db 
    para poder seleccionar el pais donde vive el usuario que se va a registrar. 
    */
    public void cargarComboPais() {
        jcCountry.removeAllItems();
        
        try {
            ResultSet rs=cone.consultDB("SELECT Nombre FROM pais");
            while (rs.next()) {
            jcCountry.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }
    
    /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera los paises que se encuentran en la base de datos signo_db 
    para poder seleccionar el pais donde nacio el usuario que se va a registrar. 
    */
    public void cargarComboPais2() {
        Connection cone2 = new Connection();
        jcCountry2.removeAllItems();
        try {
            
            ResultSet rs=cone2.consultDB("SELECT Nombre FROM pais");
            while (rs.next()) {
            jcCountry2.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }
    
    /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera los departamentos que se encuentran en la base de datos signo_db 
    para poder seleccionar el Departamento donde vive el usuario que se va a registrar 
    y al seleccionar un pais solo quedan los departamentos correspondientes a dicho Pais.
    */
     public void cargarComboDepartamento() {
         
        Connection cone3 = new Connection();
        jcDepartment.removeAllItems();
         try {
              
            ResultSet rs=cone3.consultDB("SELECT departamento.Nombre "
                    + "FROM departamento, pais WHERE departamento.Pais_Id=pais.idPais "
                    + "AND pais.Nombre='" + jcCountry.getSelectedItem()+"'");
             System.out.println(rs);
            while (rs.next()) {
            jcDepartment.addItem(rs.getString("departamento.Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }
     
    /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera los departamentos que se encuentran en la base de datos signo_db para poder seleccionar el departamento donde nacio el usuario que se va a registrar
    y al seleccionar un pais solo quedan los departamentos correspondientes a dicho Pais.
    */
     
    public void cargarComboDepartamento2() {
        Connection cone4 = new Connection();
        jcDepartment2.removeAllItems();
        try {
            ResultSet rs=cone4.consultDB("SELECT departamento.Nombre "
                    + "FROM departamento, pais WHERE departamento.Pais_Id=pais.idPais "
                    + "AND pais.Nombre='" + jcCountry2.getSelectedItem()+"'");
            while (rs.next()) {
            jcDepartment2.addItem(rs.getString("departamento.Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }
    
    /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera las ciudades que se encuentran en la base de datos signo_db
    para guardar en la tabla usuarios el ID de la ciudad donde vive el usuario que se va a registrar
    y al seleccionar un departamento solo quedan las ciudades correspondientes a dicho Departamento.
    */
    
    
    public void cargarComboCiudad() {
        Connection cone5 = new Connection();
        jcCity.removeAllItems();
        
      try {
            
            ResultSet resul = cone5.consultDB("SELECT COUNT(*) cuenta FROM Ciudad C "
                    + "INNER JOIN Departamento D ON C.Departamento_id = D.idDepartamento"
                    + " WHERE D.Nombre = '" +jcDepartment.getSelectedItem()+ "'");
            if(resul.next()){
                idCiudad = new String[resul.getInt("cuenta")];
            }
         } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        
        try {
             int i = 0;
            ResultSet rs=cone5.consultDB("SELECT idCiudad,ciudad.Nombre "
                    + "FROM ciudad, departamento WHERE ciudad.Departamento_id=departamento.idDepartamento"
                    + " AND departamento.Nombre='" + jcDepartment.getSelectedItem()+"'");
            while (rs.next()) {
            idCiudad[i] = rs.getString("idCiudad");
            System.out.println(idCiudad[i]);    
            jcCity.addItem(rs.getString("ciudad.Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }
    
     /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera las ciudades que se encuentran en la base de datos signo_db
    para guardar en la tabla nuip el ID de la ciudad donde nacio el usuario que se va a registrar
    y al seleccionar un departamento solo quedan las ciudades correspondientes a dicho Departamento.
    */
    
    public void cargarComboCiudad2() {
        Connection cone6 = new Connection();
        jcBirthPlace.removeAllItems();
        try {
            ResultSet resul = cone6.consultDB("SELECT COUNT(*) cuenta FROM Ciudad C "
                    + "INNER JOIN Departamento D ON C.Departamento_id = D.idDepartamento"
                    + " WHERE D.Nombre = '" +jcDepartment2.getSelectedItem()+ "'");
            if(resul.next()){
                IdNacimiento = new String[resul.getInt("cuenta")];
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        
        int i = 0;
        try {
            ResultSet rs=cone6.consultDB("SELECT ciudad.Nombre, ciudad.idCiudad "
                    + "FROM ciudad, departamento WHERE ciudad.Departamento_id=departamento.idDepartamento"
                    + " AND departamento.Nombre='" + jcDepartment2.getSelectedItem()+"'");
            while (rs.next()) {
            jcBirthPlace.addItem(rs.getString("ciudad.Nombre"));
            IdNacimiento[i] =rs.getString("ciudad.idCiudad");
                    i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }
     /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera las ciudades que se encuentran en la base de datos signo_db
    para guardar en la tabla nuip el ID de la ciudad donde fue expedida la identificacion del usuario
    y al seleccionar un departamento solo quedan las ciudades correspondientes a dicho Departamento.
    */
    
    public void cargarComboExpedicion() {
         
        Connection cone6 = new Connection();
        jcExpeditionPlace.removeAllItems();
        try {
            ResultSet resul = cone6.consultDB("SELECT COUNT(*) cuenta FROM Ciudad C "
                    + "INNER JOIN Departamento D ON C.Departamento_id = D.idDepartamento"
                    + " WHERE D.Nombre = '" +jcDepartment2.getSelectedItem()+ "'");
            if(resul.next()){
                IdExpedicion = new String[resul.getInt("cuenta")];
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        
        int i = 0;
        try {
            ResultSet rs=cone6.consultDB("SELECT ciudad.Nombre, ciudad.idCiudad "
                    + "FROM ciudad, departamento WHERE ciudad.Departamento_id=departamento.idDepartamento"
                    + " AND departamento.Nombre='" + jcDepartment2.getSelectedItem()+"'");
            while (rs.next()) {
            jcExpeditionPlace.addItem(rs.getString("ciudad.Nombre"));
            IdExpedicion[i] =rs.getString("ciudad.idCiudad");
                    i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    
    }
    
    
     /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera los roles registrados e la base de datos (administrador, estudiante, acudiente,docente)
    y devuelve el id del rol seleccionado para guardarlo en la tabla usuario y en la tabla que corresponde al 
    rol escogido.
    */
    
    public void cargarComboRol() {
        Connection cone8 = new Connection();
        try {
            ResultSet resul = cone8.consultDB("SELECT COUNT(*) cuenta FROM ROL");
            if(resul.next()){
                idRol = new String[resul.getInt("cuenta")];
            }
         } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }    
            try {
                int i = 0;
            ResultSet rs=cone8.consultDB("SELECT idRol, Nombre FROM rol");            
            while (rs.next()) {
            idRol[i] = rs.getString("idRol");
            System.out.println(idRol[i]);
            jcRol.addItem(rs.getString("Nombre"));
            i++;
            }
            
            } catch (Exception e) {
                System.out.println("Error"+e);
            }
            
    }
     /**
    @author Grupo prueba y calidad
    version 1.0
    Metodo que genera los grupos que han sido registrados en la base de datos y carga en el jcombobox los nombres
    y devuelve el id del grupo seleccionado para poder guardarlo en la tabla estudiantes.
    */
    
    public void cargarComboGroup () {
        Connection cone9 = new Connection();
        try {
            ResultSet rs = cone9.consultDB("SELECT COUNT(*) cuenta FROM Grupo");
            while (rs.next()) {
            IdGroup = new String[rs.getInt("cuenta")];
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        try {
            int i = 0;
            ResultSet resul=cone9.consultDB("SELECT idGrupo, Nombre FROM Grupo");
            while (resul.next()) {
                IdGroup[i] = resul.getString("idGrupo");
                System.out.println(IdGroup[i]);
                jcGroup.addItem(resul.getString("Nombre"));
                i++;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtSecondName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtSecondL = new javax.swing.JTextField();
        jsAge = new javax.swing.JSpinner();
        jrMas = new javax.swing.JRadioButton();
        jrFem = new javax.swing.JRadioButton();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNuip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jcCountry2 = new javax.swing.JComboBox<>();
        jcDepartment2 = new javax.swing.JComboBox<>();
        jcBirthPlace = new javax.swing.JComboBox<>();
        txtHeight = new javax.swing.JTextField();
        txtRH = new javax.swing.JTextField();
        txtExpeditionDate = new javax.swing.JTextField();
        jcExpeditionPlace = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jbRegister = new javax.swing.JButton();
        jcCountry = new javax.swing.JComboBox<>();
        jbConsult = new javax.swing.JButton();
        jcDepartment = new javax.swing.JComboBox<>();
        jbUpdate = new javax.swing.JButton();
        jcCity = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jcRol = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jpPassword = new javax.swing.JPasswordField();
        jLabel25 = new javax.swing.JLabel();
        jcGroup = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txtGuardian = new javax.swing.JTextField();
        lblImg = new javax.swing.JLabel();
        lblAcu = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setText("Ciudad");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(38, 441, 50, 16);
        getContentPane().add(txtFirstName);
        txtFirstName.setBounds(166, 24, 195, 20);
        getContentPane().add(txtSecondName);
        txtSecondName.setBounds(166, 62, 195, 20);
        getContentPane().add(txtSurname);
        txtSurname.setBounds(166, 100, 195, 20);
        getContentPane().add(txtSecondL);
        txtSecondL.setBounds(166, 138, 195, 20);
        getContentPane().add(jsAge);
        jsAge.setBounds(278, 176, 83, 20);

        jrMas.setText("Masculino");
        getContentPane().add(jrMas);
        jrMas.setBounds(290, 214, 71, 23);

        jrFem.setText("Femenino");
        getContentPane().add(jrFem);
        jrFem.setBounds(290, 237, 71, 23);
        getContentPane().add(txtPhone);
        txtPhone.setBounds(166, 276, 195, 20);
        getContentPane().add(txtAddress);
        txtAddress.setBounds(166, 314, 195, 20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel21.setText("Lugar de expedicion");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(410, 299, 114, 16);
        getContentPane().add(txtNuip);
        txtNuip.setBounds(545, 24, 189, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Primer Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(38, 28, 87, 16);
        getContentPane().add(txtDate);
        txtDate.setBounds(545, 55, 189, 20);

        jcCountry2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCountry2ItemStateChanged(evt);
            }
        });
        getContentPane().add(jcCountry2);
        jcCountry2.setBounds(545, 82, 189, 20);

        jcDepartment2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcDepartment2ItemStateChanged(evt);
            }
        });
        getContentPane().add(jcDepartment2);
        jcDepartment2.setBounds(545, 120, 189, 20);

        jcBirthPlace.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcBirthPlaceItemStateChanged(evt);
            }
        });
        getContentPane().add(jcBirthPlace);
        jcBirthPlace.setBounds(545, 158, 189, 20);
        getContentPane().add(txtHeight);
        txtHeight.setBounds(545, 196, 189, 20);
        getContentPane().add(txtRH);
        txtRH.setBounds(545, 222, 189, 20);
        getContentPane().add(txtExpeditionDate);
        txtExpeditionDate.setBounds(545, 260, 189, 20);

        jcExpeditionPlace.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcExpeditionPlaceItemStateChanged(evt);
            }
        });
        getContentPane().add(jcExpeditionPlace);
        jcExpeditionPlace.setBounds(545, 298, 189, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Segundo Nombre");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(38, 63, 99, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Primer Apellido");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(38, 101, 87, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Segundo Apellido");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(38, 139, 99, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Edad");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(38, 177, 28, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Genero");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(38, 216, 41, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Telefono");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(38, 277, 50, 16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Direccion ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(38, 315, 56, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("E-mail");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(38, 341, 36, 16);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Nuip");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(408, 25, 25, 16);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Pais");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(38, 372, 23, 16);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("Fecha de nacimiento");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(409, 56, 118, 16);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Departamento");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(38, 406, 81, 16);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(166, 340, 195, 20);

        jbRegister.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jbRegister.setText("Registrar");
        jbRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(jbRegister);
        jbRegister.setBounds(38, 483, 85, 25);

        jcCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCountryItemStateChanged(evt);
            }
        });
        getContentPane().add(jcCountry);
        jcCountry.setBounds(166, 371, 195, 20);

        jbConsult.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jbConsult.setText("Consultar");
        jbConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultActionPerformed(evt);
            }
        });
        getContentPane().add(jbConsult);
        jbConsult.setBounds(150, 483, 87, 25);

        jcDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcDepartmentItemStateChanged(evt);
            }
        });
        getContentPane().add(jcDepartment);
        jcDepartment.setBounds(166, 402, 195, 20);

        jbUpdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jbUpdate.setText("Actualizar");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jbUpdate);
        jbUpdate.setBounds(272, 483, 89, 25);

        jcCity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCityItemStateChanged(evt);
            }
        });
        getContentPane().add(jcCity);
        jcCity.setBounds(166, 440, 195, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setText("Pais");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(408, 83, 23, 16);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setText("Departamento");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(408, 121, 81, 16);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel17.setText("Lugar de nacimiento");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(411, 159, 116, 16);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setText("Estatura");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(411, 197, 47, 16);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel19.setText("RH");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(411, 223, 16, 16);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel20.setText("Fecha de expedicion");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(408, 261, 116, 16);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel22.setText("Rol");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(410, 340, 18, 16);

        jcRol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcRolItemStateChanged(evt);
            }
        });
        getContentPane().add(jcRol);
        jcRol.setBounds(547, 340, 189, 20);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel23.setText("Usuario");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(410, 372, 43, 16);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel24.setText("Contraseña");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(410, 402, 65, 16);
        getContentPane().add(txtUser);
        txtUser.setBounds(547, 371, 189, 20);
        getContentPane().add(jpPassword);
        jpPassword.setBounds(547, 402, 189, 20);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel25.setText("Grupo");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(410, 441, 34, 16);

        getContentPane().add(jcGroup);
        jcGroup.setBounds(547, 440, 189, 20);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel26.setText("Acudiente");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(410, 478, 56, 16);
        getContentPane().add(txtGuardian);
        txtGuardian.setBounds(547, 478, 130, 20);

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscador-de-lupa.png"))); // NOI18N
        lblImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImgMousePressed(evt);
            }
        });
        getContentPane().add(lblImg);
        lblImg.setBounds(695, 478, 24, 24);
        getContentPane().add(lblAcu);
        lblAcu.setBounds(540, 510, 140, 18);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel27.setText("Nombre");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(410, 510, 45, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegisterActionPerformed
        int pos = (int) jcRol.getSelectedIndex();
        String rol = (String) jcRol.getSelectedItem();
        System.out.println(pos);
        int posc = (int) jcCity.getSelectedIndex();
        System.out.println(posc);
        int poci = (int) jcGroup.getSelectedIndex();
        System.out.println(poci);
        
        
         try {
            int Edad = (int)jsAge.getValue();
            String Genero = "";
            if (jrMas.isSelected()) {
                Genero = "M";
            }
            if (jrFem.isSelected()) {
                Genero = "F";
            }
            int PosNaci = jcBirthPlace.getSelectedIndex();
            int PosExp = jcExpeditionPlace.getSelectedIndex();
            
        cone.modifyDB("INSERT INTO usuario VALUES ( "+txtNuip.getText()+" ,' "+txtSurname.getText()+" ',' "+txtSecondL.getText()+
                " ',' "+txtFirstName.getText()+" ',' "+txtSecondName.getText()+"', '"+txtPhone.getText()+"' ,' "+txtAddress.getText()+"',"
                +Edad+",' "+txtEmail.getText()+" ','"+Genero+"',' "+txtUser.getText()+" ',' "+jpPassword.getText()+" ',"+idCiudad[posc]+","+idRol[pos]+"); ");
        
         cone.modifyDB("INSERT INTO Nuip VALUES ("+txtNuip.getText()+",'"+txtDate.getText()+"',"+IdNacimiento[PosNaci]
             +",'"+txtHeight.getText()+"','"+txtRH.getText()+"','"+txtExpeditionDate.getText()+"',"+IdExpedicion[PosExp]+"); ");
         
         if(rol.equals("Administrador")){
            
            cone.modifyDB("INSERT INTO Administrador VALUES ("+txtNuip.getText()+","+idRol[pos]+",1)");
            
        }else if(rol.equals("acudiente")){
            
            cone.modifyDB("INSERT INTO acudiente VALUES ("+txtNuip.getText()+","+idRol[pos]+",1)");
            
        }else if(rol.equals("Docente")){
            
            cone.modifyDB("INSERT INTO Docente VALUES ("+txtNuip.getText()+","+idRol[pos]+",1)");
            
        }else if(rol.equals("Estudiante")){
            
            cone.modifyDB("INSERT INTO Estudiante VALUES ("+txtNuip.getText()+","+idRol[pos]+","+IdGroup[poci]+","+txtGuardian.getText()+",1)");
       }
        
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_jbRegisterActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        
        try {
            int Edad = jsAge.getComponentCount();
            String Genero = "";
            if (jrMas.isSelected()) {
                Genero = "Masculino";
            }
            if (jrFem.isSelected()) {
                Genero = "Femenino";
            }
            
            cone.modifyDB("UPDATE SET ");
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jcCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCountryItemStateChanged
        
      cargarComboDepartamento();
    }//GEN-LAST:event_jcCountryItemStateChanged

    private void jcDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcDepartmentItemStateChanged
        
              cargarComboCiudad();
    }//GEN-LAST:event_jcDepartmentItemStateChanged

    private void jcCountry2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCountry2ItemStateChanged
        
     cargarComboDepartamento2();
    }//GEN-LAST:event_jcCountry2ItemStateChanged

    private void jcDepartment2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcDepartment2ItemStateChanged
        cargarComboCiudad2();
        cargarComboExpedicion();
    }//GEN-LAST:event_jcDepartment2ItemStateChanged

    private void jcCityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCityItemStateChanged
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jcCityItemStateChanged

    private void jcBirthPlaceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcBirthPlaceItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcBirthPlaceItemStateChanged

    private void jcExpeditionPlaceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcExpeditionPlaceItemStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jcExpeditionPlaceItemStateChanged

    private void jcRolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcRolItemStateChanged
       String rolEs = (String) jcRol.getSelectedItem();
       int posEst = (int) jcRol.getSelectedIndex();
       
       if(rolEs.equals("Estudiante")){
           jcGroup.setVisible(true);
           txtGuardian.setVisible(true);
           jLabel25.setVisible(true);
           jLabel26.setVisible(true);
           lblImg.setVisible(true);
           lblAcu.setVisible(true);
           jLabel27.setVisible(true);
           
       }else if(rolEs.equals("Administrador")){
           jcGroup.setVisible(false);
           txtGuardian.setVisible(false);
           jLabel25.setVisible(false);
           jLabel26.setVisible(false);
           lblImg.setVisible(false);
           lblAcu.setVisible(false);
           jLabel27.setVisible(false);
           
       }else if(rolEs.equals("acudiente")){
           jcGroup.setVisible(false);
           txtGuardian.setVisible(false);
           jLabel25.setVisible(false);
           jLabel26.setVisible(false);
           lblImg.setVisible(false);
           lblAcu.setVisible(false);
           jLabel27.setVisible(false);
       }
       
       else if(rolEs.equals("Docente")){
           jcGroup.setVisible(false);
           txtGuardian.setVisible(false); 
           jLabel25.setVisible(false);
           jLabel26.setVisible(false);
           lblImg.setVisible(false);
           lblAcu.setVisible(false);
           jLabel27.setVisible(false);
       }
    }//GEN-LAST:event_jcRolItemStateChanged

    private void lblImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgMousePressed
        // TODO add your handling code here:
         String Acu = txtGuardian.getText();
            
             ResultSet rSearch = cone.consultDB("SELECT CONCAT (PrimerNombre, '' ,PrimerApellido) Nombre "
                 + "FROM usuario "
                 + "INNER JOIN Acudiente A "
                 + "ON usuario.NUIP = A.Codigo "
                 + "WHERE A.Codigo = "+Acu);
            try {
                while (rSearch.next()) {
                   
                    lblAcu.setText(rSearch.getString("Nombre"));
                }
        } catch (Exception e) {
                System.out.println("Error" + e);
        }
    }//GEN-LAST:event_lblImgMousePressed

    private void jbConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbConsultActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbConsult;
    private javax.swing.JButton jbRegister;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox<String> jcBirthPlace;
    private javax.swing.JComboBox<String> jcCity;
    private javax.swing.JComboBox<String> jcCountry;
    private javax.swing.JComboBox<String> jcCountry2;
    private javax.swing.JComboBox<String> jcDepartment;
    private javax.swing.JComboBox<String> jcDepartment2;
    private javax.swing.JComboBox<String> jcExpeditionPlace;
    private javax.swing.JComboBox<String> jcGroup;
    private javax.swing.JComboBox<String> jcRol;
    private javax.swing.JPasswordField jpPassword;
    private javax.swing.JRadioButton jrFem;
    private javax.swing.JRadioButton jrMas;
    private javax.swing.JSpinner jsAge;
    private javax.swing.JLabel lblAcu;
    private javax.swing.JLabel lblImg;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtExpeditionDate;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGuardian;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtNuip;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRH;
    private javax.swing.JTextField txtSecondL;
    private javax.swing.JTextField txtSecondName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
