package com.oliverhinde.gameloop.utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.oliverhinde.gameloop.main.Panel;

public class Debug {

	Font debugFont;
	
	public int mouseX;
	public int mouseY;

	private boolean mouseButton1;
	private boolean mouseButton2;
	
	public static boolean debug = false;
	
	public Debug() {
		debugFont = new Font("Arial", 10, 10);
	}
	
	public void update(int mouseX, int mouseY) {
		this.mouseX = mouseX;
		this.mouseY = mouseY;
	}
	
	public void draw(Graphics2D g, int currentState) {
		if(debug) {
			g.setFont(debugFont);
			g.setColor(Color.WHITE);
			g.drawString("FPS: " + Panel.fps, 4, 13);
			g.drawString("Current State: " + currentState, 4, 27);	
			g.drawString("Mouse X: " + mouseX + " " + "Mouse Y: " + mouseY, 4, 42);
			g.drawString("Mouse Button 1: " + mouseButton1 + "   " + "Mouse Button 2: " + mouseButton2, 4, 57);
		}	
	}
	
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode() == KeyEvent.VK_F3) {
			if(debug) {
				debug = false;
			} else {
				debug = true;
			}
		}
	}
	
	public void mousePressed(MouseEvent m) {
		if(m.getButton() == MouseEvent.BUTTON1) {
			mouseButton1 = true;
		}
		
		if(m.getButton() == MouseEvent.BUTTON3) {
			mouseButton2 = true;
		}
	}
	
	public void mouseReleased(MouseEvent m) {
		if(m.getButton() == MouseEvent.BUTTON1) {
			mouseButton1 = false;
		}
		
		if(m.getButton() == MouseEvent.BUTTON3) {
			mouseButton2 = false;
		}
	}
	
	public void mouseMoved(MouseEvent m) {
		mouseX = m.getX() / Panel.SCALE;
		mouseY = m.getY() / Panel.SCALE;
	}
}
