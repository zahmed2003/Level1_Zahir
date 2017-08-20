package leagueInvaders;

public class Projectile extends GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;

	public Projectile(int x, int y, int width, int height) {

		int speed = 10;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;

	}
	
	public void update()
	{
		

	}
	
	public static void draw()
	{
		
	}
}
