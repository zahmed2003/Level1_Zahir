package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int x;
	int y;
	int width;
	int height;
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		int speed = 5;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;

	}

	public void update() 
	{
		super.update();
		keyHandler();
	}
	
	
	private void keyHandler()
	{
		if (InputManager.left_key)
		{
			x -= speed;
		}
		if (InputManager.right_key)
		{
			x += speed;
		}
	}

	

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}
}
