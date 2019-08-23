import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Main {

	public static void main(String[] args) {
		
		Bienvenida miBienvenida = new Bienvenida();
		miBienvenida.setVisible(true);
		miBienvenida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSeleccioneSuPerfil = new JLabel("Seleccione su perfil de usuario");
		lblSeleccioneSuPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneSuPerfil.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
		miBienvenida.getContentPane().add(lblSeleccioneSuPerfil, BorderLayout.NORTH);

			
	}

}


class Bienvenida extends JFrame{
	
	public Bienvenida() {
		
		setTitle("Gestion de eventos");
		setBounds(500,200,400,350);
		
		inicio = new JPanel();
		inicio.setLayout(null);
		
		btnAdmin = new JButton("Administrador");
		btnAdmin.setBounds(10, 28, 365, 120);
		btnAdmin.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Administrador miAdministrador = new Administrador();
				miAdministrador.setVisible(true);
				miAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
			
		});
		
		btnPort = new JButton("Portero");
		btnPort.setBounds(10, 158, 365, 120);
		btnPort.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnPort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Portero pt = new Portero();
				pt.setVisible(true);
				pt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
		});
		
		
		
		inicio.add(btnAdmin);
		inicio.add(btnPort);
		
		add(inicio);
	}
	
	private JPanel inicio;
	private JButton btnAdmin;
	private JButton btnPort;
	private JLabel label;
}

















