package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	
	int ctr = 0;

	public Alien(int x, int y, int width, int height) {

		super(x, y, width, height);



	}
	
	public void update()
	{
		
		y += 5;
		if(isColliding && collisionObject instanceof Projectile)
		{
			isAlive = false;
		}
		
		colBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
}
