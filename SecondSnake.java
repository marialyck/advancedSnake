package snakalicious;

import java.util.LinkedList;

public class SecondSnake {

	private LinkedList<Field2> snakeList2;

	private Direction2 d2;

	private Track track;
	private int score2;

	private Apple apple;

	public SecondSnake(Track track, Apple apple) {
		this.apple = apple;
		this.track = track;
		track.getM();
		track.getN();
		snakeList2 = new LinkedList<Field2>();
		snakeList2.addFirst(new Field2(0, 0));
		snakeList2.addFirst(new Field2(0, 0 + 1));
	}

	public LinkedList<Field2> getSnakeList2() {
		return snakeList2;
	}

	public void setSnakeList2(LinkedList<Field2> snakeList) {
		this.snakeList2 = snakeList;
	}

	public void changeDirection2(Direction2 newD2) {
		this.d2 = newD2;
	}

	public void move2() {

		if (d2 == Direction2.LEFT) {
			Field2 oldHead2 = getHead2();
			snakeList2.addFirst(new Field2(oldHead2.getRow2(), oldHead2
					.getColumn2() - 1));
			if (snakeList2.getFirst().getColumn2() < 0) { // torus effect
				snakeList2.getFirst().setColumn2(track.getN() - 1);

			}
			if (!appleEaten()) {
				snakeList2.removeLast();
			}

		}

		if (d2 == Direction2.RIGHT) {
			Field2 oldHead2 = getHead2();
			snakeList2.addFirst(new Field2(oldHead2.getRow2(), oldHead2
					.getColumn2() + 1));
			if (snakeList2.getFirst().getColumn2() >= track.getN()) {
				snakeList2.getFirst().setColumn2(0);

			}
			if (!appleEaten()) {
				snakeList2.removeLast();
			}

		}

		if (d2 == Direction2.UP) {
			Field2 oldHead2 = getHead2();
			snakeList2.addFirst(new Field2(oldHead2.getRow2() - 1, oldHead2
					.getColumn2()));
			if (snakeList2.getFirst().getRow2() < 0) {
				snakeList2.getFirst().setRow2(track.getM() - 1);

			}
			if (!appleEaten()) {
				snakeList2.removeLast();
			}

		}

		if (d2 == Direction2.DOWN) {
			Field2 oldHead2 = getHead2();
			snakeList2.addFirst(new Field2(oldHead2.getRow2() + 1, oldHead2
					.getColumn2()));
			if (snakeList2.getFirst().getRow2() >= track.getM()) {
				snakeList2.getFirst().setRow2(0);
			}
			if (!appleEaten()) {
				snakeList2.removeLast();
			}

		}
	}

	public Field2 getHead2() {
		return snakeList2.getFirst();
	}

	public boolean isAlive2() {
		for (int i = 1; i < snakeList2.size(); i++) { // end game!
			if (snakeList2.getFirst().equals(snakeList2.get(i))) { // if the
																	// head
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
		if (snakeList2.getFirst().getColumn2() == apple.getColumnApple()
				&& snakeList2.getFirst().getRow2() == apple.getRowApple()) {
			score2();
			while (isSnakeHere()) { // will always place an apple where there is
									// no snake
				apple.placeApple();
			}
			return true;
		}
		return false;
	}

	public boolean isSnakeHere() { // method for checking if apples can spawn
		for (int i = 0; i < snakeList2.size(); i++) {
			if (apple.getColumnApple() == snakeList2.get(i).getColumn2()
					&& apple.getRowApple() == snakeList2.get(i).getRow2()) {
				return true;
			}
		}
		return false;
	}

	public int score2() {
		if ((snakeList2.getFirst().getColumn2() == apple.getColumnApple() && snakeList2
				.getFirst().getRow2() == apple.getRowApple())) {
			score2++;
		}
		return score2;
	}
}
