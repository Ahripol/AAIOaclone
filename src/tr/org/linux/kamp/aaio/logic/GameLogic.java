package tr.org.linux.kamp.aaio.logic;

import java.awt.BorderLayout;
/**
 * @author ahripol
 * Game mechanics has been set in this class.
 */
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import tr.org.linux.kamp.aaio.models.Chip;
import tr.org.linux.kamp.aaio.models.Enemy;
import tr.org.linux.kamp.aaio.models.GameObject;
import tr.org.linux.kamp.aaio.models.Mine;
import tr.org.linux.kamp.aaio.models.Player;
import tr.org.linux.kamp.aaio.screen.GameFrame;
import tr.org.linux.kamp.aaio.screen.GamePanel;
import tr.org.linux.kamp.windowbuilder.Diffuculty;



public class GameLogic {
	private JLabel label;
	private Player player;
	private ArrayList<GameObject> gameObject;
	private GameFrame gameFrame;
	private GamePanel gamePanel;
	private Random random = new Random();
	private ArrayList<GameObject> chipsToDelete;
	private ArrayList<GameObject> minesToDelete;
	private ArrayList<GameObject> enemiesToDelete;

	private int xTarget, yTarget;
	private boolean isGameRunning;

	/**
	 * 
	 * @param a
	 *            Name of the player
	 * @param selectedColor
	 *            Color of the player
	 * @param diff
	 *            Diffuculty level for the game.
	 */

	public GameLogic(String a, Color selectedColor, Diffuculty diff) {

		player = new Player(15, 15, 15, selectedColor, 5);
		player.setNick(a);
		gameObject = new ArrayList<GameObject>();
		gameObject.add(player);
		chipsToDelete = new ArrayList<GameObject>();
		minesToDelete = new ArrayList<GameObject>();
		enemiesToDelete = new ArrayList<GameObject>();
		gameFrame = new GameFrame();
		gamePanel = new GamePanel(gameObject);
		switch (diff) {
		case EASYPEASY:
			fillChips(30);
			addMouseEvents();
			setMinesUp(3);
			addEnemies(2);
			break;
		case STANDART:
			fillChips(15);
			addMouseEvents();
			setMinesUp(6);
			addEnemies(4);
			break;
		case HARD:
			fillChips(7);
			addMouseEvents();
			setMinesUp(12);
			addEnemies(5);
			break;
		case NIGHTMARE:
			fillChips(6);
			addMouseEvents();
			setMinesUp(43);
			addEnemies(34);
			break;
		default:
			break;
		}

	}

	/**
	 * Sets diffuculty, spawns player and other components, sets up list to delete
	 * unnecessary objects. Sets up frame and panel. Calls spawning methods and
	 * calls MouseListeners.
	 * 
	 * @param diff
	 *            Diffuculty
	 */

	public GameLogic(Diffuculty diff) {
		diff = Diffuculty.EASYPEASY;
		player = new Player(15, 15, 15, Color.CYAN, 5);
		gameObject = new ArrayList<GameObject>();
		gameObject.add(player);
		chipsToDelete = new ArrayList<GameObject>();
		minesToDelete = new ArrayList<GameObject>();
		enemiesToDelete = new ArrayList<GameObject>();
		gameFrame = new GameFrame();
		gamePanel = new GamePanel(gameObject);

		fillChips(20);
		addMouseEvents();
		setMinesUp(7);
		addEnemies(5);
	}

	/**
	 * Moves player according to mouse's coordinates.
	 */

	private synchronized void movePlayer() {
		if (xTarget > player.getX())
			player.setX((player.getX() + player.getSpeed()));
		else if (xTarget < player.getX())
			player.setX((player.getX() - player.getSpeed()));
		if (yTarget > player.getY())
			player.setY((player.getY() + player.getSpeed()));
		else if (yTarget < player.getY())
			player.setY((player.getY() - player.getSpeed()));

	}

	/**
	 * Moves enemy on behalf of player's coordinates. Wrote a basic AI to make enemy
	 * calculate best place to go.
	 */
	private void moveEnemy() {
		for (GameObject gameObject : gameObject) {
			if (gameObject instanceof Enemy) {
				Enemy enemy = (Enemy) gameObject;

				if (enemy.getR() < player.getR()) {
					int distance = (int) Point.distance(player.getX(), player.getY(), enemy.getX(), enemy.getY());
					int newX = enemy.getX() + enemy.getSpeed();
					int newY = enemy.getY() + enemy.getSpeed();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}
					newX = enemy.getX() + enemy.getSpeed();
					newY = enemy.getY() - enemy.getSpeed();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}
					newX = enemy.getX() - enemy.getSpeed();
					newY = enemy.getY() + enemy.getSpeed();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}

					newX = enemy.getX() - enemy.getSpeed();
					newY = enemy.getY() - enemy.getSpeed();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}

					newX = enemy.getX();
					newY = enemy.getY() + enemy.getSpeed();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}

					newX = enemy.getX() + enemy.getSpeed();
					newY = enemy.getY();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}

					newX = enemy.getX();
					newY = enemy.getY() - enemy.getSpeed();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}

					newX = enemy.getX() - enemy.getSpeed();
					newY = enemy.getY();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}

					newX = enemy.getX();
					newY = enemy.getY();
					if (calc(newX, newY) > distance) {
						enemy.setX(newX);
						enemy.setY(newY);
						continue;
					}
				} else {
					if (player.getX() > enemy.getX())
						enemy.setX((enemy.getX() + (enemy).getSpeed()));
					else if (player.getX() < enemy.getX())
						enemy.setX((enemy.getX() - enemy.getSpeed()));
					if (player.getY() > enemy.getY())
						enemy.setY((enemy.getY() + enemy.getSpeed()));
					else if (player.getY() < enemy.getY())
						enemy.setY((enemy.getY() - enemy.getSpeed()));

				}
			}

		}

	}

	/**
	 * Makes distance calculation
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @return
	 */
	private int calc(int x, int y) {
		return (int) Point.distance(player.getX(), player.getY(), x, y);
	}

	/**
	 * Sets up mines.
	 * 
	 * @param a
	 */
	private void setMinesUp(int a) {
		for (int i = 0; i < a; i++) {
			Mine mine = new Mine(random.nextInt(1000) + 10, random.nextInt(700) + 10, 15, Color.red);

			while (player.getRect().intersects(mine.getRect())) {
				mine.setX(random.nextInt(1000));
				mine.setY(random.nextInt(700));

			}
			gameObject.add(mine);
		}

	}

	/**
	 * Sets up Mouse Listeners
	 */

	public void addMouseEvents() {
		gamePanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				xTarget = e.getX();
				yTarget = e.getY();

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	// public void mouseTouch() {
	// // going to add a method that spawns the player according to mouse's place
	// }
	/**
	 * Sets up score table with JLabel, sets up game frame and panel, starts game.
	 */

	public void startApplication() {
		gameFrame.setContentPane(gamePanel);
		gameFrame.setVisible(true);
		gamePanel.setBackground(Color.DARK_GRAY);
		gameFrame.setBackground(Color.DARK_GRAY);

		label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		gamePanel.add(label, BorderLayout.CENTER);
		label.setText("Score of " + player.getNick() + ": " + player.getScore());

		isGameRunning = true;
		startGame();
	}

	/**
	 * Adds chips as much as liked.
	 * 
	 * @param a
	 *            chip count
	 */

	private void fillChips(int a) {
		for (int i = 0; i < a; i++) {
			gameObject.add(new Chip(random.nextInt(1000), random.nextInt(700), 12, Color.GREEN));
		}

	}

	/**
	 * Adds enemy as much as liked. If enemy and player is in the same places,
	 * spawns randomly again.
	 * 
	 * @param a
	 *            enemy count
	 */

	private void addEnemies(int a) {
		for (int i = 0; i < a; i++) {
			Enemy enemy = new Enemy(random.nextInt(1000) + 10, random.nextInt(700) + 10, random.nextInt(16) + 7,
					Color.orange, 1);
			while (player.getRect().intersects(enemy.getRect())) {
				enemy.setX(random.nextInt(1000));
				enemy.setY(random.nextInt(700));

			}
			gameObject.add(enemy);
		}

	}
/**
 * Checks collisions by setting objects as rectangles. Makes this for enemy and player separately.
 * Then if collision has have happened, deletes the objects that should have needed.
 */
	private synchronized void checkCollision() {
		for (GameObject gameObject2 : gameObject) {
			if (player.getRect().intersects(gameObject2.getRect())) {
				if (gameObject2 instanceof Enemy) {
					if (gameObject2.getR() < player.getR()) {
						enemiesToDelete.add(gameObject2);
						((Enemy) gameObject2).setSpeed(0);
						player.setR(player.getR() + gameObject2.getR());

					} else if (gameObject2.getR() > player.getR()) {
						player.setSpeed(0);
						((Enemy) gameObject2).setSpeed(0);
						label.setText("You died, game OVER");
						player.setColor(Color.white);
						isGameRunning = false;
					}
				}
				if (gameObject2 instanceof Chip) {
					chipsToDelete.add(gameObject2);
					player.setR(player.getR() + gameObject2.getR() / 2);
					player.setSpeed(player.getSpeed() - (int) 0.50);
					player.setScore(player.getScore() + 1);
					label.setText("Score of " + player.getNick() + ": " + player.getScore());
				} else if (gameObject2 instanceof Mine) {
					player.setR(player.getR() / 2);
					minesToDelete.add(gameObject2);
					if (player.getR() <= 14) {
						player.setR(player.getR() * 2);
						player.setSpeed(0);
						label.setText("You died, game over");
						player.setColor(Color.white);
					}
				}
			}

			if (gameObject2 instanceof Enemy) {
				Enemy enemy = (Enemy) gameObject2;
				for (GameObject gameObject3 : gameObject) {
					if (enemy.getRect().intersects(gameObject3.getRect())) {
						if (gameObject3 instanceof Chip) {
							enemy.setR(enemy.getR() + gameObject3.getR());
							chipsToDelete.add(gameObject3);
						}
						if (gameObject3 instanceof Mine) {
							enemy.setR((int) enemy.getR() / 2);
							minesToDelete.add(gameObject3);
						}
					}
				}
			}
		}
		gameObject.removeAll(chipsToDelete);
		gameObject.removeAll(minesToDelete);
		gameObject.removeAll(enemiesToDelete);
	}
	// can do it without synchronization, too.
	/**
	 * Adds new objects.
	 */
	private synchronized void addNewObjects() {
		fillChips(chipsToDelete.size());
		setMinesUp(minesToDelete.size());
		addEnemies(enemiesToDelete.size());
		enemiesToDelete.clear();
		chipsToDelete.clear();
		minesToDelete.clear();

	}
	/**
	 * Starts game.
	 */
	private void startGame() {
		new Thread(new Runnable() {
			@Override
			public void run() {

				while (isGameRunning) {

					movePlayer();
					moveEnemy();
					checkCollision();
					addNewObjects();
					gamePanel.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

}
