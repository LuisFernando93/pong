package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	private static int ENEMY_WIDTH = 40;
	private static int ENEMY_HEIGHT = 5;
	private static int X0 = 60;
	private static int Y0 = 0;
	
	private double dificuldade = 0.1;
	
	private double x,y;
	
	public Enemy() {
		this.x = X0;
		this.y = Y0;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public int getWidth() {
		return ENEMY_WIDTH;
	}
	
	public int getHeight() {
		return ENEMY_HEIGHT;
	}
	
	private double enemyInsideBorder(double x) {
		if (x+ENEMY_WIDTH > Game.WIDTH) {
			return Game.WIDTH - ENEMY_WIDTH;
		} else if (x < 0) {
			return 0;
		} else {
			return x;
		}
	}
	
	public void update() {
		this.x += ((Game.ball.getX() - this.x - 6)*dificuldade);
		this.x = enemyInsideBorder(x);
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.RED);
		graphics.fillRect((int)x, (int)y, ENEMY_WIDTH, ENEMY_HEIGHT);
	}
}
