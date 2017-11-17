import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicInterface {

	public JButton buttonMore;
	public JButton buttonLess;
	public JButton buttonValider;
	public JLabel PimpMyFridge;
	public static JLabel consigne;
	public JLabel temperature;
	public static int nombreConsigne = 0;
	public static int nombreTemperature = 20;

	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException {

		JPanel panel = new JPanel() {
			private BufferedImage buf = ImageIO.read(img);

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(buf, 0, 0, null);
			}
		};

		frame.setContentPane(panel);

		return panel;
	}

	void Gui() throws IOException {
		JFrame frame = new JFrame();

		JPanel panel = setBackgroundImage(frame, new File("C:\\Users\\Damien\\Desktop\\oui.png"));

		// Bouton pour augmenter la valeur consigne
		buttonMore = new JButton("+");
		buttonMore.setBounds(84, 170, 40, 40);
		buttonMore.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonMoreActionPerformed(evt);
			}
		});
		panel.add(buttonMore);
		panel.setLayout(null);

		// Bouton pour diminuer la valeur consigne
		buttonLess = new JButton("-");
		buttonLess.setBounds(172, 170, 40, 40);
		buttonLess.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonLessActionPerformed(evt);
			}
		});
		panel.add(buttonLess);

		// Bouton pour valider la valeur consigne
		buttonValider = new JButton("Valider");
		buttonValider.setBounds(280, 170, 100, 40);
		buttonValider.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonValiderActionPerformed(evt);
			}
		});
		panel.add(buttonValider);

		// Label : Consigne
		consigne = new JLabel("0");
		panel.add(consigne);
		consigne.setFont(new Font("Arial", Font.BOLD, 30));
		consigne.setBounds(140, 170, 40, 40);
		consigne.setForeground(Color.blue);

		// Label : Température
		// temperature = new JLabel(nombreTemperature + "°");
		// panel.add(temperature);
		// temperature.setFont(new Font("Calibri", Font.BOLD, 70));
		// temperature.setBounds(50, 30, 200, 200);
		// temperature.setForeground(Color.white);

		// Label : PimpMyFridge
		PimpMyFridge = new JLabel("Pimp My Fridge");
		PimpMyFridge.setFont(new Font("Arial", Font.BOLD, 35));
		PimpMyFridge.setBounds(80, 60, 280, 50);
		PimpMyFridge.setForeground(Color.blue);
		panel.add(PimpMyFridge);

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(960, 600);
		frame.setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private static void buttonMoreActionPerformed(java.awt.event.ActionEvent evt) {
		if (nombreConsigne + 1 != 16) {
			nombreConsigne++;
			consigne.setText(String.valueOf(nombreConsigne));
			CalibrageConsigne();
		}
	}

	private void buttonLessActionPerformed(java.awt.event.ActionEvent evt) {
		if (nombreConsigne - 1 != -6) {
			nombreConsigne--;
			consigne.setText(String.valueOf(nombreConsigne));
			CalibrageConsigne();
		}
	}

	// Lance le
	private void buttonValiderActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println(nombreConsigne);
		// Mettre code de l'arduino
	}

	private static void CalibrageConsigne() {

		if (nombreConsigne >= 10) {
			consigne.setBounds(130, 170, 40, 40);
		} else if (nombreConsigne >= 0 && nombreConsigne <= 10) {
			consigne.setBounds(140, 170, 40, 40);
		} else if (nombreConsigne < 0) {
			consigne.setBounds(135, 170, 40, 40);
		}
	}

}