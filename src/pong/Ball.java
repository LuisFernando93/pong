package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	private static int X0 = 60;
	private static int Y0 = 60;
	private static int BALL_WIDTH = 3;
	private static int BALL_HEIGHT = 3;
	
	private double x,y;
	
	private double dx, dy;
	private double speed = 1.4;
	
	public Ball() {
		this.x = X0;
		this.y = Y0;
		
		int angle = new Random().nextInt(120 - 45) + 45 + 1;
		
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	
	public double getX() {
		return this.x;
	}
	
	public void update() {
		x+= dx*speed;
		y+= dy*speed;
		
		if(x + (dx*speed) + BALL_WIDTH >= Game.WIDTH) { 
			//bola saindo pela direita
			dx*= -1;
		} else if(x + (dx*speed) <= 0) { 
			//bola saindo pela esquerda
			dx*= -1;
		}
		
		if (this.y >= Game.HEIGHT) {
			//ponto do inimigo
			System.out.println("ponto do inimigo");
			new Game();
			return;
		} else if (this.y < 0) {
			//ponto do jogador
			System.out.println("ponto do jogador");
			new Game();
			return;
		}
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), BALL_WIDTH, BALL_HEIGHT);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.getX(), Game.player.getY(), Game.player.getWidth(), Game.player.getHeight());
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.getX(), (int)Game.enemy.getY(), Game.enemy.getWidth(), Game.enemy.getHeight());
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if (dy > 0) {
				dy*= -1;
			}
		} else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if (dy < 0) {
				dy*= -1;
			}
		}
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.YELLOW);
		graphics.fillRect((int)x, (int)y, BALL_WIDTH, BALL_HEIGHT);
	}
}
