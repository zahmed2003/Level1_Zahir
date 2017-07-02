import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BodyPartQuiz {

	// Get 3 celebrity photos from the internet, save them to your computer, and
	// fill
	// in their paths here. To get the path, right click on the image, and copy
	// its Location.
	String firstImage = "/Users/league/Desktop/nicolasCage.jpg";
	String secondImage = "/Users/league/Desktop/jamieFoxx.jpg";
	String thirdImage = "/Users/league/Desktop/bradPitt.jpg";
	static int score = 0;
	static Frame window = new Frame();

	private void startQuiz() {
		BodyQuiz("Nicolas Cage");
		showNextImage();
		BodyQuiz("Jamie Foxx");
		showNextImage();
		BodyQuiz("Brad Pitt");
		window.dispose();
	}

	public void showNextImage() {
		window.removeAll();
		window.add(getNextImage());
		window.pack();
	}

	public static void main(String[] args) {
		BodyPartQuiz quiz = new BodyPartQuiz();
		quiz.initializeGui();
		quiz.startQuiz();
	}

	private void initializeGui() {
		initializeImageList();
		imageIterator = imageList.iterator();
		window.setVisible(true);
		showNextImage();
	}

	private JLabel loadImage(String fileName) {
		Icon icon = new ImageIcon(fileName);
		JLabel image = new JLabel(icon);
		return image;
	}

	ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	Iterator<JLabel> imageIterator;

	private void initializeImageList() {
		JLabel imageLabel = loadImage(firstImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(secondImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(thirdImage);
		imageList.add(imageLabel);
	}

	private JLabel getNextImage() {
		if (imageIterator.hasNext())
			return imageIterator.next();
		window.dispose();
		return new JLabel();
	}

	private static void BodyQuiz(String name) {
		window.setSize(100, 100);
		String answer1 = JOptionPane.showInputDialog("Who is this person?");
		if (answer1.equalsIgnoreCase(name)) {
			JOptionPane.showMessageDialog(null, "Correct!");
			score++;
		} else {
			JOptionPane.showMessageDialog(null, "Incorrect!");
		}
		System.out.println(score);
	}
}
