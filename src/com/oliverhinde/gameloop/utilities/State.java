package com.oliverhinde.gameloop.utilities;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.oliverhinde.gameloop.main.Manager;

public abstract class State {

	protected Manager sm;

	public abstract void update(float delta);
	public abstract void draw(Graphics2D g, float delta, float fixedDelta);
	public abstract void keyPressed(KeyEvent k);
	public abstract void keyReleased(KeyEvent k);
	public abstract void mousePressed(MouseEvent m);
	public abstract void mouseReleased(MouseEvent m);
	public abstract void mouseMoved(MouseEvent m);
}
