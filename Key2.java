package snakalicious;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key2 implements KeyListener {

	private Model model;
	private View view;
	private boolean right = true, left = false, up = false, down = false; // starting
																			// to
																			// the
																			// right

	public Key2(Model model, View view) {
		this.model = model;
		this.view = view;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); // declares key codes as 'key' so no key
									// numbers are needed to be remembered

		if (model.getSecondsnake().isAlive2()) { // while snake is alive, you
													// can control it
			if (key == KeyEvent.VK_D && !left) { // making sure it can't
													// move into itself
				up = false;
				down = false;
				right = true;
				model.requestNewDirection2(Direction2.RIGHT); // calling
																// movement //
																// methods
				model.move2();
				Controller.stop();
				view.repaint();
			}

			if (key == KeyEvent.VK_A && !right) {
				up = false;
				down = false;
				left = true;
				model.requestNewDirection2(Direction2.LEFT);
				model.move2();
				Controller.stop();
				view.repaint();
			}

			if (key == KeyEvent.VK_W && !down) {
				up = true;
				right = false;
				left = false;
				model.requestNewDirection2(Direction2.UP);
				model.move2();
				Controller.stop();
				view.repaint();
			}

			if (key == KeyEvent.VK_S && !up) {
				down = true;
				right = false;
				left = false;
				model.requestNewDirection2(Direction2.DOWN);
				model.move2();
				Controller.stop();
				view.repaint();
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}