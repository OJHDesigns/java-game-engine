package com.oliverhinde.gameloop.main;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	
	public static final int WIDTH = 312;
	public static final int HEIGHT = 196;
	public static final int SCALE = 4;
	
	public static int fps = 0;
	
	private Thread thread;
	private BufferedImage image;
	private Graphics2D g;
	private boolean running;
	
	private Manager manager;
	
	private float fixedFrequency = 60f; // 60hz
	private float fixedDelta = (1000f / fixedFrequency) / 1000f;
	
	public Panel(Manager manager) {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();

		this.manager = manager;
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			addKeyListener(this);
			addMouseListener(this);
			addMouseMotionListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
	
	// initializes variables
	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		running = true;
	}
	

	// run starts the game loop.
	public void run() {
	    // Initialise graphics.
	    init();

	    long start = System.nanoTime();
	    float last = 0f;      // Last update.
	    float lastFixed = 0f; // Last fixed update.
	    int currentSecond = 0;
	    int frames = 0;

	    while (running) {
	        // Get the current time in seconds.
	        float current = (System.nanoTime() - start) / 1000000000f;

	        // Keep doing fixed updates until broken.
	        while (true) {
	            // If we shouldn't do a fixed update, break.
	            if (current - fixedDelta < lastFixed) {
	                break;
	            }
	        	            
	            // Run the fixed update.
	            fixedUpdate(fixedDelta);

	            // Add the fixed delta.
	            lastFixed += fixedDelta;
	        }

	        // Get the current second casted as an integer.
	        int second = (int)current;
	        
	        // If we're still counting up frames:
	        if (second == currentSecond) {
	        	// Increment the frames counter.
	        	frames++;
	        // Otherwise:
	        } else {
	        	// Set the FPS to the frames in the last second.
	        	fps = frames;
	        	// Reset the other variables.
	        	currentSecond = second;
	        	frames = 0;
	        }
	        
	        // Run the update.
	        update(current, last, lastFixed, fps);

	        // Set the last run frame to now.
	        last = current;
	    }
	}
	
	// fixedUpdate will handle updates every set interval to keep consistency with physics and game logic.
	public void fixedUpdate(float delta) {
	    // Handle game logic and physics.
		manager.update(delta);
	}

	// update will handle all non-physics and game logic.
	public void update(float current, float last, float lastFixed, int fps) {
	    float delta = current - last;           // Delta for effects.
	    float deltaFixed = current - lastFixed; // Delta for interpolation.

	    //System.out.println(fps);
	    
	    draw(delta, deltaFixed);
	    drawToScreen();
	}
	
	// draws the game onto an off-screen buffered image
	private void draw(float delta, float deltaFixed) {
		manager.draw(g, delta, deltaFixed);
	}
	
	// draws the off-screen buffered image to the screen
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}
	
	public void keyPressed(KeyEvent k) {
		manager.keyPressed(k);
	}
	
	public void keyReleased(KeyEvent k) {
		manager.keyReleased(k);
	}

	public void mouseMoved(MouseEvent m) {
		manager.mouseMoved(m);
	}

	public void mousePressed(MouseEvent m) {
		manager.mousePressed(m);
	}

	public void mouseReleased(MouseEvent m) {
		manager.mouseReleased(m);
	}
	
	public void keyTyped(KeyEvent k) {}
	public void mouseDragged(MouseEvent m) {}
	public void mouseEntered(MouseEvent m) {}
	public void mouseExited(MouseEvent m) {}
	public void mouseClicked(MouseEvent arg0) {}
	
}