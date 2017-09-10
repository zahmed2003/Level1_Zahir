package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int prevX;
	int prevY;
	

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;

		prevX = x;
		prevY = y;

	}
	
	public void update()
	{
		y -= speed;
		if(y <= 0)
		{
			isAlive = false;
		}

		if(isColliding && collisionObject instanceof Alien)
		{
			isAlive = false;
		}
		
		colBox.setBounds(x, y, width, height);
		prevX = x;
		prevY = y;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
