package SnakeGameJava;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7e";
    private static final String BODY_SIGN = "\u26AB";

    private Direction direction = Direction.LEFT;

    public boolean isAlive = true;

    public List<GameObject> snakeParts = new ArrayList<>();

    public void setDirection(Direction direction) {

        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x) {
            return;
        }
        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y) {
            return;
        }

        if (direction == Direction.LEFT && this.direction == Direction.RIGHT) {
            return;
        } else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) {
            return;
        } else if (direction == Direction.UP && this.direction == Direction.DOWN) {
            return;
        } else if (direction == Direction.DOWN && this.direction == Direction.UP) {
            return;
        }

        this.direction = direction;
    }

    public Snake(int x, int y) {
        GameObject gameObject0 = new GameObject(x, y);
        GameObject gameObject1 = new GameObject(x + 1, y);
        GameObject gameObject2 = new GameObject(x + 2, y);

        snakeParts.add(gameObject0);
        snakeParts.add(gameObject1);
        snakeParts.add(gameObject2);
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject partSnake = snakeParts.get(i);
            String sign = (i != 0) ? BODY_SIGN : HEAD_SIGN;
            String color = String.valueOf((isAlive == true) ? Color.BLACK : Color.RED);
            game.setCellValueEx(partSnake.x, partSnake.y, Color.NONE, sign, Color.valueOf(color), 75);
        }
    }

    public void removeTail() {
        snakeParts.removeLast();
    }

    private GameObject getGameObject() {
        GameObject newHeadPosition = createNewHead();
        return newHeadPosition;
    }

    public GameObject createNewHead() {

        GameObject newHead = snakeParts.getFirst();

        if (direction == Direction.LEFT) {
            return new GameObject(newHead.x - 1, newHead.y);
        } else if (direction == Direction.DOWN) {
            return new GameObject(newHead.x, newHead.y + 1);
        } else if (direction == Direction.UP) {
            return new GameObject(newHead.x, newHead.y - 1);
        } else if (direction == Direction.RIGHT) {
            return new GameObject(newHead.x + 1, newHead.y);
        } else {
            return null;
        }
    }

    public int getLength() {
        return snakeParts.size();
    }

    public void move(Apple apple) {
        GameObject newHead = getGameObject();
        if (newHead.x >= SnakeGame.WIDTH
                || newHead.x < 0
                || newHead.y >= SnakeGame.HEIGHT
                || newHead.y < 0) {
            isAlive = false;
            return;
        }

        if (newHead.x == apple.x && newHead.y == apple.y) {
            apple.isAlive = false;
            return;
        }
        if (checkCollision(newHead)) {
            isAlive = false;
            return;
        }
        snakeParts.addFirst(newHead);
        removeTail();
    }


    public boolean checkCollision(GameObject gameObject) {
        for (GameObject part : snakeParts) {
            if (part.x == gameObject.x && part.y == gameObject.y) {
                return true;
            }
        }
        return false;
    }

}



