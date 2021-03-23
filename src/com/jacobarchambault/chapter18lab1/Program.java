package com.jacobarchambault.chapter18lab1;

import javax.swing.WindowConstants;

public class Program {
	public static void main(
			String[] args) {
		Ch18Lab1 frame = new Ch18Lab1();
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
