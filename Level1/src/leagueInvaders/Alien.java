package leagueInvaders;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;

public class Alien extends GameObject{
	
	int ctr = 0;
	int speed;
	Random r = new Random();
	int health;
	int counter = 0;

	public Alien(int x, int y, int width, int height, int speed, int health) {

		
		super(x, y, width, height);
		
		this.health = health;
		this.health = health;
		this.speed = speed;



	}
	
	public void update()
	{
		counter++;
		if(counter % 1 == 0)
		{
		GamePanel.manager.addObject(new AlienProjectile(x + (width/2), y + (width/2), 6, 15));
		}
		y += speed;
		if(isColliding && collisionObject instanceof Projectile)
		{
			if(health > 0)
				{
					health = health - 1;
				}
			if(health == 0)
				{
				isAlive = false;
				}
		}
		
		
		colBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
	
}
