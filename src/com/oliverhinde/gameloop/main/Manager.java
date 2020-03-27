package com.oliverhinde.gameloop.main;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.oliverhinde.gameloop.states.TestState;
import com.oliverhinde.gameloop.utilities.Debug;
import com.oliverhinde.gameloop.utilities.State;

public class Manager {
	
	public Debug debug = new Debug();

	private ArrayList<State> states;
	private int currentState;
	
	public Manager() {
		states = new ArrayList<State>();

		currentState = TestState.id;
	}

	public void addNewState(State state) {
	    states.add(state);
    }
	
	public void setCurrentState(int i) {
		currentState = i;
	}
	
	public int getCurrentState() {
		return currentState;
	}
	
	public void update(float delta) {
		states.get(currentState).update(delta);
		debug.update(debug.mouseX, debug.mouseY);
	}
	
	public void draw(Graphics2D g, float delta, float deltaFixed) {
		states.get(currentState).draw(g, delta, deltaFixed);
		debug.draw(g, currentState);
	}
	
	public void keyPressed(KeyEvent k) {
		states.get(currentState).keyPressed(k);
		debug.keyPressed(k);
	}
	
	public void keyReleased(KeyEvent k) {
		states.get(currentState).keyReleased(k);
	}
	
	public void mousePressed(MouseEvent m) {
		states.get(currentState).mousePressed(m);
		debug.mousePressed(m);
	}
	
	public void mouseReleased(MouseEvent m) {
		states.get(currentState).mouseReleased(m);
		debug.mouseReleased(m);
	}

	public void mouseMoved(MouseEvent m) {
		states.get(currentState).mouseMoved(m);
		debug.mouseMoved(m);
	}
}
