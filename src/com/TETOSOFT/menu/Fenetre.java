package com.TETOSOFT.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.TETOSOFT.tilegame.GameEngine;

public class Fenetre extends JFrame{
	
	private Panneau pan = new Panneau();
	private PanneauSouth panS = new PanneauSouth();
	private JPanel boutonPane = new JPanel();
	private JPanel container = new JPanel();
	private Bouton boutonPlay = new Bouton("Start new game");
	private Bouton boutonHtoPlay = new Bouton("How to play");
	private Bouton boutonAbout = new Bouton("About the game");
	private JOptionPane jopHtoPlay;
	private JOptionPane jopAbout;

	
	public Fenetre() {
		this.setTitle("Gamu");
		this.setSize(new Dimension(1080,720));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		Font police = new Font("Tahoma", Font.PLAIN, 20);
		
		boutonPlay.setFont(police);
		boutonHtoPlay.setFont(police);
		boutonAbout.setFont(police);
		
		boutonPlay.setPreferredSize(new Dimension(350,50));
		boutonHtoPlay.setPreferredSize(new Dimension(350,50));
		boutonAbout.setPreferredSize(new Dimension(350,50));
		
		boutonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						new GameEngine().run();      
					}
				
				   });
				t.start();
			}
		});

		boutonHtoPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				jopHtoPlay = new JOptionPane();
				String msgHowToPlay = "Left and right arrows for moving" + "\n" + "Space to jump";
				jopHtoPlay.showMessageDialog(null, msgHowToPlay , "How to play", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		boutonAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				jopAbout = new JOptionPane();
				String msgAbout = "Original game by: http://www.mohamedtalaat.net/ \n"
						+ "Improved by: \n"
						+ "\t\t\t - AMEKHROUB ZAKARIYAA \n"
						+ "\t\t\t - AMJOUN HAMZA \n"
						+ "\t\t\t - CHIEKH MOHAMMED NABIL \n"
						+ "\t\t\t - HOUMMANE ZINEB \n"
						+ "\t\t\t - KANIBOU NOURA \n"
						+ "\t\t\t - L'HICHOU ANAS";
				jopAbout.showMessageDialog(null, msgAbout , "About the game", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JPanel cell1 = new JPanel();
		cell1.setBackground(Color.BLACK);
		cell1.setPreferredSize(new Dimension(145,25));
		JPanel cell2 = new JPanel();
		cell2.setBackground(Color.BLACK);
		cell2.setPreferredSize(new Dimension(145,25));
		JPanel cell3 = new JPanel();
		cell3.setBackground(Color.BLACK);
		cell3.setPreferredSize(new Dimension(145,25));
		JPanel cell4 = new JPanel();
		cell4.setBackground(Color.BLACK);
		cell4.setPreferredSize(new Dimension(145,25));
		JPanel cell5 = new JPanel();
		cell5.setBackground(Color.BLACK);
		cell5.setPreferredSize(new Dimension(145,25));
		JPanel cell6 = new JPanel();
		cell6.setBackground(Color.BLACK);
		cell6.setPreferredSize(new Dimension(145,25));
		JPanel cell7 = new JPanel();
		cell7.setBackground(Color.BLACK);
		cell7.setPreferredSize(new Dimension(145,15));
		JPanel cell8 = new JPanel();
		cell8.setBackground(Color.BLACK);
		cell8.setPreferredSize(new Dimension(145,15));
		
		boutonPane.setBackground(Color.BLACK);
		boutonPane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		boutonPane.add(cell1,gbc);
		
		gbc.gridx = 1;
		boutonPane.add(boutonPlay,gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2;
		boutonPane.add(cell2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		boutonPane.add(cell7,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		boutonPane.add(cell3,gbc);
		
		gbc.gridx = 1;
		boutonPane.add(boutonHtoPlay,gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2;
		boutonPane.add(cell4,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		boutonPane.add(cell8,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		boutonPane.add(cell5,gbc);
		
		gbc.gridx = 1;
		boutonPane.add(boutonAbout,gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2;
		boutonPane.add(cell6,gbc);
		
		
		pan.setPreferredSize(new Dimension(681,340));
		panS.setPreferredSize(new Dimension(578,129));
		
		container.setBackground(Color.BLACK);
	    container.setLayout(new BorderLayout());
	    container.add(pan, BorderLayout.NORTH);
	    container.add(boutonPane, BorderLayout.CENTER);
	    container.add(panS,BorderLayout.SOUTH);
	    
	    this.setContentPane(container);
	    this.setVisible(true);
	}
}
