import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;


public class Portero extends JFrame{


	public Portero() {
				
			miConexion =null;
			miRs = null;

			acceso = new JPanel();
			setTitle("dsds");
			setBounds(500,200,400,350);
			acceso.setLayout(null);
			
			JLabel lblUsuario = new JLabel("User:");
			lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));
			lblUsuario.setBounds(68, 66, 71, 28);
			acceso.add(lblUsuario);
			
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
			lblPassword.setBounds(68, 137, 116, 14);
			acceso.add(lblPassword);
			
			textField = new JTextField();
			textField.setBounds(198, 72, 124, 20);
			acceso.add(textField);
			textField.setColumns(10);
			
			password = new JPasswordField();
			password.setBounds(198,128,124,23);
			acceso.add(password);
			
	        add(acceso);
			
			btnEnter = new JButton("Enter");
			btnEnter.setFont(new Font("Arial", Font.BOLD, 12));
			btnEnter.setBounds(146, 220, 89, 23);
			acceso.add(btnEnter);
			
			btnEnter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC","root","");
						
						PreparedStatement miStatement = miConexion.prepareStatement("SELECT * FROM portero WHERE USER=? AND PASSWORD=?");
						
						miStatement.setString(1, textField.getText());
						String valorPass = new String(password.getPassword());
						miStatement.setString(2, valorPass);
						
						miRs = miStatement.executeQuery();
						
						
							if(miRs.absolute(1)) {
								System.out.println("entro");
							}else {
								
								JOptionPane.showMessageDialog(null,"NO se encuentra");
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
			
			JButton b = new JButton("eee");
			acceso = new JPanel();
			acceso.add(b);
			
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					Administrador mi = new Administrador();
				}
				
			});
			
			container.add(acceso);
			
			validate();
			repaint();
			setVisible(true);
		}
}
