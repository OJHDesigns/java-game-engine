package com.oliverhinde.gameloop.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Launcher {
	public Launcher(Manager manager) {
		JFrame window = new JFrame();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setTitle("Game Loop");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new Panel(manager));
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setLocation(screen.width / 2 - Panel.WIDTH * Panel.SCALE / 2, screen.height / 2 - Panel.HEIGHT * Panel.SCALE / 2 - 45);
	}
}