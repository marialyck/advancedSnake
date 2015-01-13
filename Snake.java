package snakalicious;
import java.util.LinkedList;

public class Snake {

	private LinkedList<Field> snakeList;

	private Direction d;

	private Track track;
	private int n;
	private int m;
	
	private int score;

	private Apple apple;

	public Snake(Track track, Apple apple) {
		this.apple = apple;
		this.track = track;
		this.m = track.getM();
		this.n = track.getN();
		snakeList = new LinkedList<Field>();
		snakeList.addFirst(new Field(m / 2, n / 2));
		snakeList.addLast(new Field(m / 2, n / 2 + 1));
		
		
	}

	public LinkedList<Field> getSnakeList() {
		return snakeList;
	}

	public void setSnakeList(LinkedList<Field> snakeList) {
		this.snakeList = snakeList;
	}
	
	

		public void changeDirection(Direction d) {
			this.d = d;
		}
	
		public void move() {
	
			if (d == Direction.LEFT) {
				Field oldHead = getHead();
				snakeList.addFirst(new Field(oldHead.getRow(),
						oldHead.getColumn() - 1));
				if (snakeList.getFirst().getColumn() < 0) { //torus effect
					snakeList.getFirst().setColumn(track.getN() - 1);
					
	
				}
				if (!appleEaten()) {
					snakeList.removeLast();
				}
				
			}
	
			if (d == Direction.RIGHT) {
				Field oldHead = getHead();
				snakeList.addFirst(new Field(oldHead.getRow(),
						oldHead.getColumn() + 1));
				if (snakeList.getFirst().getColumn() >= track.getN()) {
					snakeList.getFirst().setColumn(0);
	
				}
				if (!appleEaten()) {
					snakeList.removeLast();
				}
				
			}
	
			if (d == Direction.UP) {
				Field oldHead = getHead();
				snakeList.addFirst(new Field(oldHead.getRow() - 1, oldHead
						.getColumn()));
				if (snakeList.getFirst().getRow() < 0) {
					snakeList.getFirst().setRow(track.getM() - 1);
	
				}
				if (!appleEaten()) {
					snakeList.removeLast();
				}
				
			}
	
			if (d == Direction.DOWN) {
				Field oldHead = getHead();
				snakeList.addFirst(new Field(oldHead.getRow() + 1, oldHead
						.getColumn()));
				if (snakeList.getFirst().getRow() >= track.getM()) {
					snakeList.getFirst().setRow(0);
				}
				if (!appleEaten()) {
					snakeList.removeLast();
				}
				
			}
		}

	public Field getHead() {
		return snakeList.getFirst();
	}

	public boolean isAlive() {
		for (int i = 1; i < snakeList.size(); i++) { // end game!
			if (snakeList.getFirst().equals(snakeList.get(i))) { // if the head
																	// is
																	// colliding
																	// with its
																	// body
																	// the game
				return false; // stops
			}
		}
		return true;
	}

	public boolean appleEaten() {
		if (snakeList.getFirst().getColumn() == apple.getColumnApple()
				&& snakeList.getFirst().getRow() == apple.getRowApple()) {
			score();
			while(isSnakeHere()){ //will always place an apple where there is no snake
				apple.placeApple();
			}
			return true;
		}
		return false;
	}

	public boolean isSnakeHere() { // method for checking if apples can spawn
		for (int i = 0; i < snakeList.size(); i++) {
			if (apple.getColumnApple() == snakeList.get(i).getColumn()
					&& apple.getRowApple() == snakeList.get(i).getRow()) {
				return true;
			}
		}
		return false;
	}
	
	public int score(){
		if ((snakeList.getFirst().getColumn() == apple.getColumnApple()
				&& snakeList.getFirst().getRow() == apple.getRowApple())){
			score++;
		}
		return score;
	}
}
