
// Copyright Wintriss Technical Schools 2013

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrumKit extends MouseAdapter {
	JFrame frame = new JFrame();

	JLabel drumLabelWithImage;
	String drum = null;
	JPanel panel = null;

	JLabel drumLabelWithImage1;
	String drum1 = null;

	JPanel drumPanel = new JPanel();

	public static void main(String[] args) throws Exception {
		new DrumKit().getGoing();

	}

	private void getGoing() throws MalformedURLException {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setTitle("DrumKit");

		frame.add(drumPanel);
		drumPanel.setVisible(true);

		addDrum(drum, "drum.jpg", drumLabelWithImage);
		addDrum(drum1, "drum2.png", drumLabelWithImage1);
	}

	public void mouseClicked(MouseEvent e) {

		System.out.println("mouse clicked");

		JLabel drumClicked = (JLabel) e.getSource();
		if (drumClicked.equals(drumLabelWithImage)) {
			playSound("drumSound.wav");
		}
		if (drumClicked.equals(drumLabelWithImage1)) {
			playSound("drumSound2.wav");
		}
	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	private void addDrum(String drumImageName, String imageURL, JLabel drumImageLabelName)
			throws MalformedURLException {

		drumImageName = imageURL;
		drumImageLabelName = createLabelImage(drumImageName);
		drumPanel.add(drumImageLabelName);
		drumPanel.setLayout(new GridLayout());
		frame.pack();
		drumImageLabelName.addMouseListener(this);
	}

}
