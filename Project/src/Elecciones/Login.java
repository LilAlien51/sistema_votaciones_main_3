package Elecciones;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField campoNombre;
	private JTextField campoCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		Image img = null;
		try {
			img = ImageIO.read(getClass().getResource("/assetsSemestral/frameIcono.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        this.setIconImage(img);
        
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - getWidth()) / 2;
		final int y = (screenSize.height - getHeight()) / 2;
		final int w = 1133;
		final int h = 683;
		setBounds(x-w/2, y-h/2, w, h);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1117, 644);
		contentPane.add(layeredPane);
		
		JLabel FondoConImagenes = new JLabel("");
		FondoConImagenes.setIcon(new ImageIcon(Login.class.getResource("/assetsSemestral/Login.png")));
		layeredPane.setLayer(FondoConImagenes, 1);
		FondoConImagenes.setBounds(0, 0, 1117, 644);
		layeredPane.add(FondoConImagenes);
		
		JButton btnIngresar = new JButton("");
		btnIngresar.setBounds(446, 521, 227, 72);
		layeredPane.add(btnIngresar);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(446, 239, 227, 56);
		campoNombre.setBackground(new Color(174, 255, 240));
		campoNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		campoNombre.setColumns(10);
		layeredPane.setLayer(campoNombre, 2);
		layeredPane.add(campoNombre);
		
		campoCedula = new JTextField();
		campoCedula.setBounds(446, 399, 227, 56);
		campoCedula.setBackground(new Color(174, 255, 240));
		campoCedula.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		campoCedula.setColumns(10);
		layeredPane.setLayer(campoCedula, 2);
		layeredPane.add(campoCedula);
		
		
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombresValidos[] = {"Jose"};
				String cedulaValidas[] = {"2-753-15", "1"};
				
				String username = campoNombre.getText();
				String ced = campoCedula.getText();
				System.out.println(username + " " + ced);
				for (String nombre : nombresValidos) {
					if (username.equals(nombre)) {
						for (String cedula : cedulaValidas) {
							if (ced.equals(cedula)) {
								AlertaBien.main("Usuario válido");
								votacionBuilder.main(null);
								dispose();
								return;
							}
						}
					}
				}
				AlertaMal.main("<html>Datos inválidos<br>");
			}
		});
	}
}
