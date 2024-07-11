package Elecciones;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaVotacion extends JFrame {

	int votante = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(int candidatos, int votantes, Votacion NuevaVotacion) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaVotacion frame = new PantallaVotacion(candidatos, votantes, NuevaVotacion);
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
	public PantallaVotacion(int candidatos, int votantes, Votacion NuevaVotacion) {
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
		final int w = 1122;
		final int h = 683;
		setBounds(x - w / 2, y - h / 2, w, h);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1117, 644);
		getContentPane().add(layeredPane);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(PantallaVotacion.class.getResource("/assetsSemestral/VotacionL.png")));
		layeredPane.setLayer(fondo, 1);
		fondo.setBounds(0, 0, 1107, 644);
		layeredPane.add(fondo);

		JButton btnSelect1 = new JButton("");
		btnSelect1.setBackground(new Color(234, 236, 198));
		layeredPane.setLayer(btnSelect1, 2);
		btnSelect1.setBounds(298, 180, 49, 42);
		layeredPane.add(btnSelect1);

		JButton btnSelect2 = new JButton("");
		layeredPane.setLayer(btnSelect2, 2);
		btnSelect2.setBackground(new Color(234, 236, 198));
		btnSelect2.setBounds(691, 180, 49, 42);
		layeredPane.add(btnSelect2);

		JButton btnSelect3 = new JButton("");
		btnSelect3.setEnabled(false);
		btnSelect3.setBackground(new Color(234, 236, 198));
		layeredPane.setLayer(btnSelect3, 2);
		btnSelect3.setBounds(1042, 180, 49, 42);
		layeredPane.add(btnSelect3);

		JLabel cobertor3 = new JLabel("");
		cobertor3.setIcon(new ImageIcon(PantallaVotacion.class.getResource("/assetsSemestral/cobertor2.png")));
		layeredPane.setLayer(cobertor3, 3);
		cobertor3.setBounds(779, 173, 328, 222);
		layeredPane.add(cobertor3);

		JButton btnSelect4 = new JButton("");
		btnSelect4.setEnabled(false);
		btnSelect4.setBackground(new Color(234, 236, 198));
		layeredPane.setLayer(btnSelect4, 2);
		btnSelect4.setBounds(298, 420, 49, 42);
		layeredPane.add(btnSelect4);

		JLabel cobertor4 = new JLabel("");
		layeredPane.setLayer(cobertor4, 3);
		cobertor4.setIcon(new ImageIcon(PantallaVotacion.class.getResource("/assetsSemestral/cobertor2.png")));
		cobertor4.setBounds(0, 411, 358, 222);
		layeredPane.add(cobertor4);

		JButton btnSelect5 = new JButton("");
		btnSelect5.setEnabled(false);
		layeredPane.setLayer(btnSelect5, 2);
		btnSelect5.setBackground(new Color(234, 236, 198));
		btnSelect5.setBounds(691, 420, 49, 42);
		layeredPane.add(btnSelect5);

		JLabel cobertor5 = new JLabel("");
		cobertor5.setIcon(new ImageIcon(PantallaVotacion.class.getResource("/assetsSemestral/cobertor2.png")));
		layeredPane.setLayer(cobertor5, 3);
		cobertor5.setBounds(376, 411, 375, 222);
		layeredPane.add(cobertor5);

		JButton btnVotar = new JButton("");
		btnVotar.setBounds(855, 561, 172, 68);
		layeredPane.add(btnVotar);

		JLabel votandoPor = new JLabel("<html>Votando por: \r\n<br>Ninguno");
		votandoPor.setHorizontalAlignment(SwingConstants.CENTER);
		votandoPor.setFont(new Font("Tahoma", Font.BOLD, 25));
		layeredPane.setLayer(votandoPor, 3);
		votandoPor.setBounds(770, 420, 337, 130);
		layeredPane.add(votandoPor);

		JLabel Conteo = new JLabel("<html>Conteo:\r\n<br>Candidato 1: 0\r\n<br>Candidato 2: 0");
		Conteo.setFont(new Font("Tahoma", Font.BOLD, 20));
		Conteo.setVerticalAlignment(SwingConstants.TOP);
		layeredPane.setLayer(Conteo, 3);
		Conteo.setBounds(779, 0, 312, 162);
		layeredPane.add(Conteo);

		JLabel numeroVotante = new JLabel("Votante #1");
		numeroVotante.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(numeroVotante, 3);
		numeroVotante.setVerticalAlignment(SwingConstants.TOP);
		numeroVotante.setFont(new Font("Tahoma", Font.BOLD, 30));
		numeroVotante.setBounds(365, 22, 404, 48);
		layeredPane.add(numeroVotante);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		if (candidatos >= 3) {
			cobertor3.setVisible(false);
			Conteo.setText("<html>Conteo:\r\n<br>Candidato 1: 0\r\n<br>Candidato 2: 0\r\n<br>Candidato 3: 0");
			btnSelect3.setEnabled(true);
		}
		if (candidatos >= 4) {
			cobertor4.setVisible(false);
			Conteo.setText(
					"<html>Conteo:\r\n<br>Candidato 1: 0\r\n<br>Candidato 2: 0\r\n<br>Candidato 3: 0\r\n<br>Candidato 4: 0");
			btnSelect4.setEnabled(true);
		}
		if (candidatos >= 5) {
			cobertor5.setVisible(false);
			Conteo.setText(
					"<html>Conteo:\r\n<br>Candidato 1: 0\r\n<br>Candidato 2: 0\r\n<br>Candidato 3: 0\r\n<br>Candidato 4: 0\r\n<br>Candidato 5: 0");
			btnSelect5.setEnabled(true);
		}

		// funciones de botones

		btnSelect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelect1.setEnabled(false);
				btnSelect2.setEnabled(true);
				if (candidatos >= 3) {
					btnSelect3.setEnabled(true);
				}
				if (candidatos >= 4) {
					btnSelect4.setEnabled(true);
				}
				if (candidatos >= 5) {
					btnSelect5.setEnabled(true);
				}
				votandoPor.setText("<html>Votando por: \r\n<br>Candidato 1");
			}
		});

		btnSelect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelect1.setEnabled(true);
				btnSelect2.setEnabled(false);
				if (candidatos >= 3) {
					btnSelect3.setEnabled(true);
				}
				if (candidatos >= 4) {
					btnSelect4.setEnabled(true);
				}
				if (candidatos >= 5) {
					btnSelect5.setEnabled(true);
				}
				votandoPor.setText("<html>Votando por: \r\n<br>Candidato 2");
			}
		});

		btnSelect3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelect1.setEnabled(true);
				btnSelect2.setEnabled(true);
				if (candidatos >= 3) {
					btnSelect3.setEnabled(false);
				}
				if (candidatos >= 4) {
					btnSelect4.setEnabled(true);
				}
				if (candidatos >= 5) {
					btnSelect5.setEnabled(true);
				}
				votandoPor.setText("<html>Votando por: \r\n<br>Candidato 3");
			}
		});

		btnSelect4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelect1.setEnabled(true);
				btnSelect2.setEnabled(true);
				if (candidatos >= 3) {
					btnSelect3.setEnabled(true);
				}
				if (candidatos >= 4) {
					btnSelect4.setEnabled(false);
				}
				if (candidatos >= 5) {
					btnSelect5.setEnabled(true);
				}
				votandoPor.setText("<html>Votando por: \r\n<br>Candidato 4");
			}
		});

		btnSelect5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelect1.setEnabled(true);
				btnSelect2.setEnabled(true);
				if (candidatos >= 3) {
					btnSelect3.setEnabled(true);
				}
				if (candidatos >= 4) {
					btnSelect4.setEnabled(true);
				}
				if (candidatos >= 5) {
					btnSelect5.setEnabled(false);
				}
				votandoPor.setText("<html>Votando por: \r\n<br>Candidato 5");
			}
		});

		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				votandoPor.setText("<html>Votando por: \r\n<br>Ninguno");
				if (btnSelect1.isEnabled() == true && btnSelect2.isEnabled() == true && candidatos == 2) {
					AlertaMal.main("<html>No ha seleccionado<br>un candidato");
					return;
				}
				if (btnSelect1.isEnabled() == true && btnSelect2.isEnabled() == true && btnSelect3.isEnabled() == true
						&& candidatos == 3) {
					AlertaMal.main("<html>No ha seleccionado<br>un candidato");
					return;
				}
				if (btnSelect1.isEnabled() == true && btnSelect2.isEnabled() == true && btnSelect3.isEnabled() == true
						&& btnSelect4.isEnabled() == true && candidatos == 4) {
					AlertaMal.main("<html>No ha seleccionado<br>un candidato");
					return;
				}
				if (btnSelect1.isEnabled() == true && btnSelect2.isEnabled() == true && btnSelect3.isEnabled() == true
						&& btnSelect4.isEnabled() == true && btnSelect5.isEnabled() == true && candidatos == 5) {
					AlertaMal.main("<html>No ha seleccionado<br>un candidato");
					return;
				}

				votante++;
				if (btnSelect1.isEnabled() == false) {
					NuevaVotacion.sumarVoto(0);
					btnSelect1.setEnabled(true);
				}
				if (btnSelect2.isEnabled() == false) {
					NuevaVotacion.sumarVoto(1);
					btnSelect2.setEnabled(true);
				}
				if (btnSelect3.isEnabled() == false && candidatos >= 3) {
					NuevaVotacion.sumarVoto(2);
					btnSelect3.setEnabled(true);
				}
				if (btnSelect4.isEnabled() == false && candidatos >= 4) {
					NuevaVotacion.sumarVoto(3);
					btnSelect4.setEnabled(true);
				}
				if (btnSelect5.isEnabled() == false && candidatos >= 5) {
					NuevaVotacion.sumarVoto(4);
					btnSelect5.setEnabled(true);
				}

				String conteo = "<html>Conteo:\r\n<br>Candidato 1: " + NuevaVotacion.votos[0] + "\r\n<br>Candidato 2: "
						+ NuevaVotacion.votos[1];

				if (candidatos >= 3) {
					conteo = conteo + "\r\n<br>Candidato 3: " + NuevaVotacion.votos[2];
				}
				if (candidatos >= 4) {
					conteo = conteo + "\r\n<br>Candidato 4: " + NuevaVotacion.votos[3];
				}
				if (candidatos >= 5) {
					conteo = conteo + "\r\n<br>Candidato 5: " + NuevaVotacion.votos[4];
				}
				Conteo.setText(conteo);
				numeroVotante.setText("Votante #" + (votante + 1));
				AlertaBien.main("<html>Voto registrado<br>correctamente");
				if (votante == votantes) {
					btnVotar.setEnabled(false);
					btnSelect1.setEnabled(false);
					btnSelect2.setEnabled(false);
					btnSelect3.setEnabled(false);
					btnSelect4.setEnabled(false);
					btnSelect5.setEnabled(false);
					votandoPor.setText("Votación finalizada");
					numeroVotante.setText("Votación finalizada");
				}
			}
		});

	}
}
