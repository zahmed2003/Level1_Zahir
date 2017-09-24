package leagueInvaders;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 500;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}
   
	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies(){
		
		Random r = new Random();
		int enemy = r.nextInt(2);
		
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			
			if(enemy == 1)
			{
			addObject(new Alien(new Random().nextInt(LeagueInvaders.width - 50) + 50, 0, 50, 50, new Random().nextInt(5) + 5, new Random().nextInt(1) + 1));
			enemyTimer = System.currentTimeMillis();
			}
			if(enemy == 0)
			{
				addObject(new Alien2(0, new Random().nextInt(500) + 50, 50, 50, new Random().nextInt(5) + 5));
				enemyTimer = System.currentTimeMillis();
				
			}
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if(o1.colBox.intersects(o2.colBox)){
					o1.setColliding(true);
					o1.setCollisionObject(o2);
					
					o2.setColliding(true);
					o2.setCollisionObject(o1);
					
					if(o1 instanceof Projectile && o2 instanceof Alien || o2 instanceof Projectile && o1 instanceof Alien || o1 instanceof Projectile && o2 instanceof Alien2 || o2 instanceof Projectile && o1 instanceof Alien2) 
					{
						score++;
					}
				}
			}
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}

