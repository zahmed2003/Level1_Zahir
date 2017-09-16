package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;


public class AlienProjectile extends GameObject {
	int prevX;
	int prevY;

	

	public AlienProjectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;

		prevX = x;
		prevY = y;

	}
	
	public void update()
	{
		y += speed;
		if(y > 800)
		{
			isAlive = false;
		}
		

		if(isColliding && collisionObject instanceof Rocketship)
		{
			isAlive = false;
		}
		
		colBox.setBounds(x, y, width, height);
		prevX = x;
		prevY = y;
		
		
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(GamePanel.AlienBulletImg, x, y, width, height, null);
	}
}
