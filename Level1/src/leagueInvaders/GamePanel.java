package leagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer(1000 / 60, this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	
	ObjectManager manager = new ObjectManager();
	
	
	Font titleFont;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);

	public GamePanel() {
		Timer timer = new Timer(1000 / 60, this);
		Font titleFont = new Font("Arial", Font.PLAIN, 48); // type o/ font,
															// stylization, size

		this.timer = timer;
		manager.addObject(rocket);

	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		manager.update();
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		g.setFont(titleFont);
		g.drawString("text", 10, 10); // change the 10s into other values

	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		manager.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		g.setFont(titleFont);
		g.drawString("text", 10, 10); // change the 10s into other values
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	public void startGame() {

		timer.start();

	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("key typed");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("key Pressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { 
										
			if (currentState <= 2) {
				currentState += 1;
			}
			if (currentState >= 3) {
				currentState = MENU_STATE;
			}
		}
			
			
		if(key == KeyEvent.VK_LEFT)
			{
				InputManager.left_key = true;
			}
			if(key == KeyEvent.VK_RIGHT)
			{
				
				InputManager.right_key = true;
			}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("key released");
		int key = e.getKeyCode();
		
		
		if(key == KeyEvent.VK_LEFT)
		{
			
			InputManager.left_key = false;
		}
		if(key == KeyEvent.VK_RIGHT)
		{
			
			InputManager.right_key = false;
		}

	}

}
