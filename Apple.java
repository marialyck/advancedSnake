package snakalicious;
import java.util.Random;

public class Apple {

	private int rowApple, columnApple;
	private Track track;
	private Random r = new Random();

	public Apple(Track track) {
		this.track = track;
		placeApple();
	}
	
	public void placeApple() {
		rowApple = r.nextInt(track.getM());
		columnApple = r.nextInt(track.getN());
	}

	public int getRowApple() {
		return rowApple;
	}

	public void setRowApple(int rowApple) {
		this.rowApple = rowApple;
	}

	public int getColumnApple() {
		return columnApple;
	}

	public void setColumnApple(int columnApple) {
		this.columnApple = columnApple;
	}

}
