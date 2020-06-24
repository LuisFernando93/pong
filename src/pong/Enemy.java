package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	private static int ENEMY_WIDTH = 40;
	private static int ENEMY_HEIGHT = 5;
	private static int X0 = 100;
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
	
	public void update() {
		this.x += ((Game.ball.getX() - this.x - 6)*dificuldade);
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.RED);
		graphics.fillRect((int)x, (int)y, ENEMY_WIDTH, ENEMY_HEIGHT);
	}
}
