package leagueInvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class LeagueInvaders{

	JFrame frame = new JFrame();
	final static int width = 500;
	final static int height = 800;
	GamePanel gamepanel = new GamePanel();

	public static void main(String[] args) {
		LeagueInvaders lInvaders = new LeagueInvaders();

	}

	public LeagueInvaders() {
		GamePanel gamepanel = new GamePanel();
		JFrame frame = new JFrame();

		this.frame = frame;
		this.gamepanel = gamepanel;
		setup();
	}

	public void setup() {
		frame.add(gamepanel);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.addKeyListener(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamepanel.startGame();

	}

}
