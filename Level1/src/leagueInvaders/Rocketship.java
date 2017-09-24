package leagueInvaders;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JApplet;

public class Rocketship extends GameObject{
	boolean canFire;
	
	ObjectManager objManager;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;

		canFire = true;
		
		colBox = new Rectangle(x - (width/2), y - (height/2), width, height);

	}

	public void update() 
	{
		keyHandler();
		
		if(isColliding && collisionObject instanceof Alien || isColliding && collisionObject instanceof Alien2 || isColliding && collisionObject instanceof AlienProjectile)
		{
			isAlive = false;
		}
		
		colBox.setBounds(x, y, width, height);
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
		if (InputManager.up_key)
		{
			y -= speed;
		}
		if (InputManager.down_key)
		{
			y += speed;
		}
		
		if(InputManager.space_key && canFire)
		{
			objManager.addObject(new Projectile(x + (width/2), y, 6, 15));
			canFire = false;
			
		}
		if(!InputManager.space_key)
		{
			canFire = true;
		}
		
		if(x < 0)
		{
			x=0;
		}
		if(x > 500 - width)
		{
			x=500 - width;
		}
		
		
	}
	public void setObjectManager(ObjectManager o)
	{
		objManager = o;
	}

	

	public void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
	
}
