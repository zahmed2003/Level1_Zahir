package leagueInvaders;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;

public class Alien2 extends GameObject{
	
	int ctr = 0;
	int speed;
	int counter = 0;
	int x;

	public Alien2(int x, int y, int width, int height, int speed) {

		
		super(x, y, width, height);
		
		this.speed = speed;
		this.x = x;
		
	}
	
	public void update()
	{
			counter ++;
			x += speed;
			if(counter % 30 == 0 || x == 10)
			{
			GamePanel.manager.addObject(new AlienProjectile(x + (width/2), y, 6, 15));
			}
			
			
		
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
	

