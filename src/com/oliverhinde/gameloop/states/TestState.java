package com.oliverhinde.gameloop.states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import com.oliverhinde.gameloop.main.Panel;
import com.oliverhinde.gameloop.main.Manager;
import com.oliverhinde.gameloop.utilities.State;
import com.oliverhinde.gameloop.utilities.Vector;

public class TestState extends State {

	Vector pos;
	Vector vel;
	final float speed = 50f;
	boolean moveLeft;
	boolean moveRight;
	boolean moveUp;
	boolean moveDown;
	
	public TestState(Manager sm) {
		this.sm = sm;
		
//		try {
//			load images
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		init();
	}
	
	public void init() {
		
	}
	
	public void update(float delta) {

	}

	public void draw(Graphics2D g, float delta, float deltaFixed) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
	}

	public void keyPressed(KeyEvent k) {
		
	}

	public void keyReleased(KeyEvent k) {
	
	}

	public void mousePressed(MouseEvent m) {
		
	}
	
	public void mouseReleased(MouseEvent m) {
		
	}
	
	public void mouseMoved(MouseEvent m) {
		
	}
}
