package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		int speed = 10;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;

	}
	
	public void update()
	{
		super.update();
		y -= speed;
		if(y < 0)
		{
			isAlive = false;
		}

	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}