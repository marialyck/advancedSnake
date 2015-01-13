package snakalicious;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Controller {

	public static Model model;
	public static View view;

	public static void main(String[] args) {

		model = new Model();
		view = new View(model);
		view.addKeyListener(new Key(model, view));
		view.addKeyListener(new Key2(model,view));
		startGame();
	}

	public static void stop() {
		if (!model.getSnake().isAlive()&&!model.getSecondsnake().isAlive2()) {
			JOptionPane.showMessageDialog(view,
					"You Lost! #UninstallGame fgt L2P.\nFirst Player score: "
							+ model.getSnake().score() + "\n and second player score: " + model.getSecondsnake().score2() , "Ouch!",
					JOptionPane.WARNING_MESSAGE);
		} else if (model.getSnake().getSnakeList().size() + model.getSecondsnake().getSnakeList2().size() == model.getTrack()
				.getN() * model.getTrack().getM()) {
			JOptionPane.showMessageDialog(view, "Your score: "
					+ model.getSnake().score(), "You win!",
					JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	

	public static void startGame() {
		try {
			// Open an audio input stream.
			File soundFile = new File("Sandstorm01.wav");
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio
			// input stream.
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
//		while(model.getSnake().isAlive() || model.getSecondsnake().isAlive2()){
//			model.move();
//			model.move2();
//			Controller.stop();
//			view.repaint();
//			
//				
//			}
//		}
	}
}
