package com.jacobarchambault.swingfiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/* Display file in a text area. File is chosen from a dialog box. The JFileChooser class will be demonstrated. */
public class SwingFiles extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem aboutMenu;
	private JMenu chooseColor;
	private JMenu colorMenu;
	private JMenu editMenu;
	private JMenuItem exitMenu;
	private JMenu fileMenu;
	// Create a Font object
	private Font font = new Font(
			"Helvetica",
			Font.BOLD,
			16);
	private JMenu helpMenu;
	private JButton jbtBrowse;
	// Create jFileChooser
	private JFileChooser jFileChooser;
	// ScrollPane
	private JScrollPane jsp;
	// Text area to display file
	private JTextArea jtaFileContent;
	// Text field to receive file name
	private JTextField jtfFile;
	// Create Menu
	private JMenuBar menuBar;
	private JMenuItem openMenu;
	// Create panel
	private JPanel p;
	private JMenuItem selectAllMenu;
	private JMenuItem setBackgroundMenu;

	private JMenuItem setForegroundMenu;

	public SwingFiles() {
		createMenu();
		createPanel();
		// Use BorderLayout for the frame
		setLayout(
				new BorderLayout());
		add(
				jsp,
				BorderLayout.CENTER);
		add(
				p,
				BorderLayout.SOUTH);
		jtaFileContent.setBackground(
				Color.white);
		jtaFileContent.setForeground(
				Color.black);
	}

	public void createMenu() {
		ImageIcon bulletIcon = new ImageIcon(
				"bullet.gif");
		menuBar = new JMenuBar();
		setJMenuBar(
				menuBar);
		fileMenu = new JMenu(
				"File");
		fileMenu.setFont(
				font);
		editMenu = new JMenu(
				"Edit");
		colorMenu = new JMenu(
				"Set Color");
		helpMenu = new JMenu(
				"Help");
		menuBar.add(
				fileMenu);
		menuBar.add(
				Box.createHorizontalGlue());
		menuBar.add(
				editMenu);
		menuBar.add(
				Box.createHorizontalGlue());
		menuBar.add(
				colorMenu);
		menuBar.add(
				Box.createHorizontalGlue());
		menuBar.add(
				helpMenu);
		ImageIcon icon = new ImageIcon(
				"file.png");

		openMenu = new JMenuItem(
				"Open File");
		openMenu.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						browse();
					}
				});
		openMenu.setIcon(
				bulletIcon);

		exitMenu = new JMenuItem(
				"Exit Program");
		exitMenu.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						System.exit(
								0);
					}
				});
		exitMenu.setIcon(
				bulletIcon);

		selectAllMenu = new JMenuItem(
				"Select All");
		selectAllMenu.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						jtaFileContent.selectAll();
					}
				});
		selectAllMenu.setIcon(
				bulletIcon);

		chooseColor = new JMenu(
				"Change Color");
		chooseColor.setIcon(
				bulletIcon);
		setBackgroundMenu = new JMenuItem(
				"Set Background Color");
		setBackgroundMenu.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						Color selectedColor = JColorChooser.showDialog(
								null,
								"Choose Background Color",
								jtaFileContent.getBackground());
						if (selectedColor != null)
							jtaFileContent.setBackground(
									selectedColor);
					}
				});
		setBackgroundMenu.setIcon(
				bulletIcon);

		setForegroundMenu = new JMenuItem(
				"Set Text Color");
		setForegroundMenu.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						Color selectedColor = JColorChooser.showDialog(
								null,
								"Choose Background Color",
								jtaFileContent.getForeground());
						if (selectedColor != null)
							jtaFileContent.setForeground(
									selectedColor);
					}
				});
		setForegroundMenu.setIcon(
				bulletIcon);

		aboutMenu = new JMenuItem(
				"About Program");
		aboutMenu.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						JOptionPane.showMessageDialog(
								null,
								"Click Browse and Choose a File to Display",
								"JFileChooser Demo",
								JOptionPane.INFORMATION_MESSAGE,
								icon);
					}
				});
		aboutMenu.setIcon(
				bulletIcon);
		fileMenu.add(
				openMenu);
		fileMenu.add(
				exitMenu);
		editMenu.add(
				selectAllMenu);
		colorMenu.add(
				chooseColor);
		chooseColor.add(
				setBackgroundMenu);
		chooseColor.add(
				setForegroundMenu);
		helpMenu.add(
				aboutMenu);

		fileMenu.setMnemonic(
				'F');
		helpMenu.setMnemonic(
				'H');
		editMenu.setMnemonic(
				'E');
		colorMenu.setMnemonic(
				'C');
		openMenu.setMnemonic(
				'O');
		exitMenu.setMnemonic(
				'X');
		selectAllMenu.setMnemonic(
				'S');
		setBackgroundMenu.setMnemonic(
				'B');
		setForegroundMenu.setMnemonic(
				'T');
		aboutMenu.setMnemonic(
				'A');
	}

	public void createPanel() {
		// Create a Panel to hold a label, a text field, and a button
		p = new JPanel();
		p.setLayout(
				new BorderLayout());
		p.add(
				new JLabel(
						"Filename"),
				BorderLayout.WEST);
		jtfFile = new JTextField();
		p.add(
				jtfFile,
				BorderLayout.CENTER);
		jtfFile.setBackground(
				Color.white);
		jtfFile.setForeground(
				Color.black);
		jtfFile.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						showFile(
								new File(
										jtfFile.getText()
												.trim()));
					}
				});

		jbtBrowse = new JButton(
				"Browse");
		jbtBrowse.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(
							ActionEvent e) {
						browse();
					}
				});
		p.add(
				jbtBrowse,
				BorderLayout.EAST);
		// Create a scrollable text area
		jtaFileContent = new JTextArea();
		jsp = new JScrollPane(
				jtaFileContent);
		// Set default directory to the current directory
		jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(
				new File(
						"."));
	}

	private void browse() {
		if (jFileChooser.showOpenDialog(
				this) == JFileChooser.APPROVE_OPTION) {
			showFile(
					jFileChooser.getSelectedFile());
		}
	}

	private void showFile(
			File file) {
		BufferedReader infile = null; // declare buffered stream
		// get file name from the text field
		String inLine;
		jtfFile.setText(
				file.getName());
		try {
			// create a buffered stream
			infile = new BufferedReader(
					new FileReader(
							file));
			// read a line
			inLine = infile.readLine();
			boolean firstLine = true;
			// append the line to the text area
			while (inLine != null) {
				if (firstLine) {
					firstLine = false;
					jtaFileContent.append(
							inLine);
				} else {
					jtaFileContent.append(
							"\n" + inLine);
				}
				inLine = infile.readLine();
			}
		} catch (FileNotFoundException ex) {
			System.out.println(
					"File not found: " + file.getName());
		} catch (IOException ex) {
			System.out.println(
					ex.getMessage());
		} finally {
			try {
				if (infile != null)
					infile.close();
			} catch (IOException ex) {
			}
		}
	}
}
