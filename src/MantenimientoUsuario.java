import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.BorderLayout;

public class MantenimientoUsuario extends JFrame{
	private static final Object String = null;
	private JTextField Nombre;
	private JTextField Usuario;
	private JTextField Apellido;

	public MantenimientoUsuario() {
		
		setTitle("Gestor de mantenimientos");
		setBounds(500,200,400,350);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Mantenimiento de Usuarios", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNombre.setBounds(50, 11, 86, 20);
		panel_1.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblApellido.setBounds(210, 11, 85, 20);
		panel_1.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblUsuario.setBounds(50, 111, 86, 20);
		panel_1.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblContrasea.setBounds(210, 111, 95, 20);
		panel_1.add(lblContrasea);
		
		Nombre = new JTextField();
		Nombre.setBounds(50, 42, 119, 20);
		panel_1.add(Nombre);
		Nombre.setColumns(10);
		
		JPasswordField Contrasena = new JPasswordField();
		Contrasena.setBounds(210, 142, 118, 20);
		panel_1.add(Contrasena);
		
		Usuario = new JTextField();
		Usuario.setBounds(50, 142, 119, 20);
		panel_1.add(Usuario);
		Usuario.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setBounds(209, 42, 119, 20);
		panel_1.add(Apellido);
		Apellido.setColumns(10);
		
		JLabel lblPerfilDeSuario = new JLabel("Perfil de usuario:");
		lblPerfilDeSuario.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPerfilDeSuario.setBounds(50, 205, 119, 20);
		panel_1.add(lblPerfilDeSuario);
		
		JButton BotonCrear = new JButton("Crear");
		BotonCrear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		BotonCrear.setBounds(209, 205, 119, 51);
		panel_1.add(BotonCrear);
		
		JComboBox perfilUsuario = new JComboBox();
		perfilUsuario.setModel(new DefaultComboBoxModel(new String[] {"administrador", "portero"}));
		perfilUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		perfilUsuario.setBounds(50, 236, 119, 20);
		panel_1.add(perfilUsuario);
		
		String perfil = (String) perfilUsuario.getSelectedItem();
		
		BotonCrear.addActionListener(new ActionListener() {
			private Connection miConexion;
			private ResultSet miRs;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC","root","");
					PreparedStatement miStatement = miConexion.prepareStatement("INSERT into "+perfil+"(NAME,SURNAME,USER,PASSWORD) VALUES(?,?,?,?)");
					
					miStatement.setString(1, Nombre.getText());
					miStatement.setString(2, Apellido.getText());
					miStatement.setString(3, Usuario.getText());
					String valorPass = new String(Contrasena.getPassword());
					miStatement.setString(4, valorPass);
					miStatement.executeUpdate();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		JScrollPane panel_2 = new JScrollPane();
		tabbedPane.addTab("Mantenimiento de Eventos", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Mantenimiento de Invitados", null, panel_3, null);
		
	}
}
