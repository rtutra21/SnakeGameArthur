package SnakeGameJava;

import com.javarush.engine.cell.*;
import com.javarush.engine.cell.Color;

import javax.swing.*;
import java.awt.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score;
    private JButton restartButton;


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onKeyPress(Key key) {

        if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        } else if (key == Key.SPACE && isGameStopped == true) {
            createGame();
        }
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (apple.isAlive == false) {
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if (snake.isAlive == false) {
            gameOver();
        }
        if (snake.getLength() > GOAL) {
            win();
        }
        drawScene();
    }


    private void createGame() {
        Snake snakeReal = new Snake(WIDTH / 2, HEIGHT / 2);
        snake = snakeReal;
        turnDelay = 300;
        setTurnTimer(turnDelay);
        createNewApple();
        isGameStopped = false;
        drawScene();
        score = 0;
        setScore(score);
    }


    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "YOU WIN", Color.AZURE, 60);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.FIREBRICK, "GAME OVER", Color.WHITESMOKE, 60);

    }


    private void drawScene() {

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.SNOW, " ");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        Apple appleGen;

        do {
            int new1 = getRandomNumber(WIDTH);
            int new2 = getRandomNumber(HEIGHT);
            appleGen = new Apple(new1, new2);

        } while (snake.checkCollision(appleGen));
        apple = appleGen;


    }
}
