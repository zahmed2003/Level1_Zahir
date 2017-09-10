package leagueInvaders;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Alien extends GameObject{
	
	int ctr = 0;
	int speed;

	public Alien(int x, int y, int width, int height, int speed) {

		super(x, y, width, height);
		this.speed = speed;



	}
	
	public void update()
	{
		
		y += speed;
		if(isColliding && collisionObject instanceof Projectile)
		{
			
			isAlive = false;
		
		}
		
		
		colBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
	
}
