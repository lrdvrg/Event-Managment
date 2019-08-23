import javax.swing.*;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

public class Administrador extends JFrame{
	
	
	public Administrador() {	
		
		miConexion =null;
		miRs = null;

		acceso = new JPanel();
		setTitle("Login");
		setBounds(500,200,400,350);
		acceso.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblUsuario.setBounds(113, 26, 141, 35);
		acceso.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPassword.setBounds(119, 129, 135, 46);
		acceso.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(113, 72, 141, 35);
		acceso.add(textField);
		textField.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(113,186,141,35);
		acceso.add(password);
		
        getContentPane().add(acceso);
		
		btnEnter = new JButton("Enter");
		btnEnter.setMnemonic(KeyEvent.VK_ENTER);
		btnEnter.setFont(new Font("Arial", Font.BOLD, 12));
		btnEnter.setBounds(135, 246, 104, 41);
		acceso.add(btnEnter);
		
		btnEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC","root","");
					
					PreparedStatement miStatement = miConexion.prepareStatement("SELECT * FROM administrador WHERE USER=? AND PASSWORD=?");
					
					miStatement.setString(1, textField.getText());
					String valorPass = new String(password.getPassword());
					miStatement.setString(2, valorPass);
					
					miRs = miStatement.executeQuery();
					
					
						if(miRs.absolute(1)) {
							MantenimientoUsuario MU = new MantenimientoUsuario();
							MU.setVisible(true);
							
							dispose();
							
						}else {
							
							JOptionPane.showMessageDialog(null,"El usuario/contraseña esta incorrectos.");
						}
					
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
			
			}
			
			
		});
	}
	
	private JPanel acceso; 
	private JTextField textField;
	private JPasswordField password;
	private JButton btnEnter;
	private Container container;
	private Connection miConexion;
	private ResultSet miRs;
	
	public void ejemplo() {
		
		
		
		
		container = getContentPane();
		container.removeAll();
		
		acceso = new JPanel();
	    acceso.add(new JButton("dddsd"));
		container.add(acceso);
		
		validate();
		repaint();
		setVisible(true);
	}

}


