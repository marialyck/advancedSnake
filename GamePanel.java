package snakalicious;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private Model model;
	private int cell;

	public GamePanel(Model model) {
		this.model = model;
		this.setBackground(new Color(0, 0, 0));
		this.setPreferredSize(new Dimension(500, 500));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int panelWidthPixels = this.getWidth();
		int panelHeightPixels = this.getHeight();
		int maxCellWidth = panelWidthPixels / model.getTrack().getN();
		int maxCellHeight = panelHeightPixels / model.getTrack().getM();

		cell = Math.min(maxCellHeight, maxCellWidth);

		// painting Track
		for (int j = 0; j <= model.getTrack().getM(); j++) {
			for(int i=0; i <=model.getTrack().getN(); i++){

			g.setColor(new Color(100, 200, 0));
			g.fillRect(0, 0, model.getTrack().getN()*cell,
					model.getTrack().getM()*cell);
				}
		}
		// painting apple
		g.setColor(Color.RED);
		g.fillRect(model.getApple().getColumnApple() * cell, model.getApple()
				.getRowApple() * cell, cell, cell);
		g.setColor(Color.BLACK);// fancy apple
		g.fillRect(model.getApple().getColumnApple() * cell + 5, model
				.getApple().getRowApple() * cell + 5, cell - 10, cell - 10);

		// painting snake
		for (int i = 0; i < model.getSnake().getSnakeList().size(); i++) {
			g.setColor(Color.BLACK);
			g.fillRect(model.getSnake().getSnakeList().get(i).getColumn()
					* cell, model.getSnake().getSnakeList().get(i).getRow()
					* cell, cell, cell);
			g.setColor(Color.YELLOW);
			g.fillRect(model.getSnake().getSnakeList().get(i).getColumn()
					* cell + 5, model.getSnake().getSnakeList().get(i).getRow()
					* cell + 5, cell - 10, cell - 10);

		}
		//painting secondSnake
		for (int i = 0; i < model.getSecondsnake().getSnakeList2().size(); i++) {
			g.setColor(Color.BLUE);
			g.fillRect(model.getSecondsnake().getSnakeList2().get(i).getColumn2()
					* cell, model.getSecondsnake().getSnakeList2().get(i).getRow2()
					* cell, cell, cell);
			g.setColor(Color.ORANGE);
			g.fillRect(model.getSecondsnake().getSnakeList2().get(i).getColumn2()
					* cell + 5, model.getSecondsnake().getSnakeList2().get(i).getRow2()
					* cell + 5, cell - 10, cell - 10);

		}

	}

}
