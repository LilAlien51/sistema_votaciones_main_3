package Elecciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class votacionBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField cantidadCantidatos;
	private JTextField cantidadVotantes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					votacionBuilder frame = new votacionBuilder();
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
	public votacionBuilder() {
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
		final int w = 587;
		final int h = 349;
		setBounds(x-w/2, y-h/2, w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(62, 192, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad de Candidatos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(174, 255, 240));
		lblNewLabel.setBounds(10, 91, 307, 45);
		contentPane.add(lblNewLabel);
		
		cantidadCantidatos = new JTextField();
		cantidadCantidatos.setBounds(327, 89, 234, 48);
		contentPane.add(cantidadCantidatos);
		cantidadCantidatos.setColumns(10);
		
		cantidadVotantes = new JTextField();
		cantidadVotantes.setColumns(10);
		cantidadVotantes.setBounds(327, 160, 234, 48);
		contentPane.add(cantidadVotantes);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de Votantes:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(174, 255, 240));
		lblNewLabel_1.setBounds(10, 162, 307, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Construir Votacion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 551, 69);
		contentPane.add(lblNewLabel_2);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(175, 236, 234, 48);
		contentPane.add(btnContinuar);
		
		
		
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int candidatos;
				int votantes;
				try {
					candidatos = Integer.parseInt(cantidadCantidatos.getText());
					votantes = Integer.parseInt(cantidadVotantes.getText());
				}
				catch (Exception a){
					AlertaMal.main("Ingrese datos válidos");
					return;
				}
				if (candidatos < 2 || candidatos > 5) {
					AlertaMal.main("<html>Debe seleccionar de 2 a 5<br>candidatos");
					return;
				}
				AlertaBien.main("<html>Votación creada<br>correctamente");
				Votacion NuevaVotacion = new Votacion(candidatos);
				PantallaVotacion.main(candidatos, votantes, NuevaVotacion);
				dispose();
			}
		});
	}

}
