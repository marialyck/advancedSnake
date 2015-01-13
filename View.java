package snakalicious;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame{

	@SuppressWarnings("unused")
	private Model model;

	public View(Model model) {
		super("Snake");
		this.model = model;
		
		
		//HighScore p = new HighScore();
		//add(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new GamePanel(model), BorderLayout.CENTER);
		//getContentPane().setBackground(Color.RED);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}

	
}
