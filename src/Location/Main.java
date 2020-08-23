package Location;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
	Scanner sc = new Scanner(System.in);

	private JPanel panel = new JPanel();
	private String location = sc.nextLine();
	private GoogleAPI googleAPI = new GoogleAPI();
	private JLabel googleMap = new JLabel();

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			g.setColor(Color.red);
			g.drawOval(20, 20, 80, 80);
		}	
	}

	public void setMap(String location) {
		pack();
	}

	public Main() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Google Maps");
		setVisible(true);

		googleAPI.downloadMap(location);
		googleMap.setIcon(googleAPI.getMap(location));
		googleAPI.FileDelete(location);

		add(BorderLayout.NORTH, panel);
		add(BorderLayout.SOUTH, googleMap);
		pack();
		
	}
}
