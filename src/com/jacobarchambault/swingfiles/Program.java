package com.jacobarchambault.swingfiles;

import javax.swing.WindowConstants;

public class Program {
	public static void main(
			String[] args) {
		SwingFiles frame = new SwingFiles();
		frame.setSize(
				400,
				300);
		frame.setTitle(
				"Chapter 18 Lab1");
		frame.setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(
				null); // Center the frame
		frame.setVisible(
				true);
	}

}
