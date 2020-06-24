package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	private static int PLAYER_WIDTH = 40;
	private static int PLAYER_HEIGHT = 5;
	private static int X0 = 100;
	private static int Y0 = Game.HEIGHT - PLAYER_HEIGHT;
	
	private int x, y;
	
	public boolean right, left;
	
	public Player() {
		this.x = X0;
		this.y = Y0;
	}
	
	public void update() {
		if(right) {
			x++;
		} else if(left) {
			x--;
		}
		x = playerInsideBorder(x);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return PLAYER_WIDTH;
	}
	
	public int getHeight() {
		return PLAYER_HEIGHT;
	}
	
	private int playerInsideBorder(int x) {
		if (x+PLAYER_WIDTH > Game.WIDTH) {
			return Game.WIDTH - PLAYER_WIDTH;
		} else if (x < 0) {
			return 0;
		} else {
			return x;
		}
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.fillRect(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
}
