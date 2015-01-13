package snakalicious;

public class Model {

	// private LinkedList<Point> snake;

	protected int x;
	protected int y;

	// private int xBody, yBody;

	// private Snake snakeCoor = new Snake(xBody,yBody);

	private Apple apple;
	private Snake snake;
	private Track track;
	private SecondSnake secondsnake;

	public Model() {
		track = new Track();
		apple = new Apple(track);
		snake = new Snake(track, apple);
		secondsnake = new SecondSnake(track,apple);

	}
	public Snake getSnake() {
		return snake;
	}
	
	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public SecondSnake getSecondsnake() {
		return secondsnake;
	}
	
	public void setSecondSnake(SecondSnake secondsnake) {
		this.secondsnake = secondsnake;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}
	public void setTrack(Track track){
		this.track=track;
	}

	public Track getTrack() {
		return track;
	}


	public void move(){
		snake.move();
		
	}
	public void move2(){
		secondsnake.move2();
	}

	public void requestNewDirection(Direction newD) {
		// TODO Auto-generated method stub
		snake.changeDirection(newD);
	}
	public void requestNewDirection2(Direction2 newD2) {
		// TODO Auto-generated method stub
		secondsnake.changeDirection2(newD2);
	}
}
