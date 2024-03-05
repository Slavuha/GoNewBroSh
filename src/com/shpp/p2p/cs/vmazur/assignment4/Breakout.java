package com.shpp.p2p.cs.vmazur.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;


public class Breakout extends WindowProgram {
    /**
     * Width and height of an application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;

    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 10;

    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;

    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 4;

    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 8;

    /**
     * Capacity of weight pixels which we can use for calculate brick weight.
     */
    private static final int APP_WIDTH_CAPACITY = APPLICATION_WIDTH - (BRICK_SEP * (NBRICKS_PER_ROW + 2));

    /**
     * Weight of a brick
     */
    private static final int BRICK_WIDTH = APP_WIDTH_CAPACITY / (NBRICKS_PER_ROW);

    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 10;

    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;

    /**
     * Number of turns
     */
    private static final int NTURNS = 3;
    /**
     * Number of turns with I could change.
     */
    int countOfTurns = NTURNS;

    /**
     * Speed of the ball
     */
    private double vx = 1;
    private double vy = 3;
    /**
     * Count of left bricks on canvas
     */
    int countOfLeftBricks = NBRICKS_PER_ROW * NBRICK_ROWS;

    public void run() {

        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        createPaddle();
        addMouseListeners();
        createBall();
        random();
        createBricks();
        while (countOfTurns > 0) {
            moveBall();
            if (countOfLeftBricks == 0) {
                createWinLabel();
                break;
            }
        }
    }

    /**
     * Method create win label if user wins
     */
    private void createWinLabel() {

        GLabel label = new GLabel("You win!!!");
        label.setColor(Color.PINK);
        label.setFont(new Font("Veranda", Font.PLAIN, 44));
        label.setLocation(
                getWidth() / 2 - label.getWidth() / 2,
                getHeight() / 2);
        add(label);
    }

    /**
     * Method creates bricks on canvas.
     */
    private void createBricks() {
        int y = 0; //I added variable for controlee correct place of bricks.
        for (int i = 0; i < NBRICK_ROWS; i++) {
            createRowOfBricks(y);
            y = y + BRICK_HEIGHT + BRICK_SEP;
        }

    }

    /**
     * I added a variable to calculate count for bricks to controlee color of bricks.
     */
    int counterOfBricks = 0;

    /**
     * Method creates row of bricks
     *
     * @param y from pervier method to controlee y coordinate
     */
    private void createRowOfBricks(int y) {
        int x = 0;//I added variable for controlee correct place of bricks.

        for (int i = 0; i < NBRICKS_PER_ROW; i++) {
            createBrick(x, y);
            x = x + BRICK_WIDTH + BRICK_SEP;
            counterOfBricks++;//Here I added a counter to regulate color or bricks.
        }
    }

    /**
     * Method creates simple brick in correct place.
     *
     * @param x, y came from perviouse methods to control coordinate of bricks
     */
    private void createBrick(int x, int y) {
        GRect gRect = new GRect(
                x,
                BRICK_Y_OFFSET + y,
                BRICK_WIDTH,
                BRICK_HEIGHT
        );
        gRect.setFilled(true);
        color(gRect); //Here program changes colors of bricks in dependence of rows
        add(gRect);
    }

    /**
     * Method chose write color of brick in dependency of his row
     *
     * @param gRect our gRect, with we create in method createBrick
     */
    private void color(GRect gRect) {
        if (counterOfBricks < 2 * NBRICKS_PER_ROW) {
            gRect.setColor(Color.RED);
        } else if (counterOfBricks < 4 * NBRICKS_PER_ROW) {
            gRect.setColor(Color.ORANGE);
        } else if (counterOfBricks < 6 * NBRICKS_PER_ROW) {
            gRect.setColor(Color.YELLOW);

        } else if (counterOfBricks < 8 * NBRICKS_PER_ROW) {
            gRect.setColor(Color.GREEN);

        } else if (counterOfBricks < 10 * NBRICKS_PER_ROW) {
            gRect.setColor(Color.CYAN);
        }
    }

    /**
     * Method gives a random direction for ball.
     */
    private void random() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5))
            vx = -vx;
    }

    /**
     * Method move ball. Per each move method involve methods checkCoordinate & checkCollidingObject
     */
    private void moveBall() {
        // Pause between move
        int pause = 1000 / 48;
        checkCoordinate();
        checkCollidingObject();
        ball.move(vx, vy);
        pause(pause);
    }

    /**
     * Method checks a colliding object with a ball.
     * If it paddles ball changes a direction by Y
     * If in another object remove it and changes direction.
     */
    private void checkCollidingObject() {
        GObject collider = getCollidingObject();
        if (collider == paddle) {
            vy = -vy;
        } else if (collider != null) {
            remove(collider);
            countOfLeftBricks--;//When brick was removed we decrease counter to understand when player will win.
            vy = -vy;
        }
    }

    /**
     * Method check colliding object with four caners of ball.
     *
     * @return colliding object to method to checkCollidingObject.
     */
    private GObject getCollidingObject() {
        int x = 0;
        int y = 0;

        GObject gObject = getElementAt(ball.getX(), ball.getY());

        if (gObject != null) {
            return gObject;
        } else if (gObject == null) {
            y = y + BALL_RADIUS;
            gObject = getElementAt(ball.getX(), (ball.getY() + y));
            y = 0;
        } else if (gObject == null) {
            x = x + BALL_RADIUS;
            gObject = getElementAt(ball.getX() + x, ball.getY());
            x = 0;
        } else if (gObject == null) {
            x = x + BALL_RADIUS;
            y = y + BALL_RADIUS;

            gObject = getElementAt(ball.getX() + x, ball.getY() + y);
            x = 0;
            y = 0;
        }
        return gObject;
    }

    /**
     * Check coordinate of ball to protect it from flying over the territory of canvas.
     */
    private void checkCoordinate() {
        if (ball.getY() < 0) {
            vy = -vy;
        } else if (ball.getY() > (getHeight() - BALL_RADIUS)) {
            countOfTurns--; //If it uses lost a ball method count decrease of lives.
            ball.setLocation(getWidth() / 2 - BALL_RADIUS / 2,
                    getHeight() / 2 - BALL_RADIUS / 2);
            waitForClick();
            random();
        } else if (ball.getX() < 0 || ball.getX() > (getWidth() - BALL_RADIUS)) {
            vx = -vx;
        }
    }

    /**
     * Object ball
     */
    GOval ball;

    /**
     * Method creates ball in start place.
     */
    private void createBall() {
        ball = new GOval(
                getWidth() / 2 - BALL_RADIUS / 2,
                getHeight() / 2 - BALL_RADIUS / 2,
                BALL_RADIUS, BALL_RADIUS);
        ball.setFilled(true);
        ball.setFillColor(Color.PINK);
        add(ball);
    }

    /**
     * Object paddle
     */
    GRect paddle;

    /**
     * Method creates paddle in place regards to task requirements.
     */
    private void createPaddle() {
        paddle = new GRect(
                getWidth() / 2 - PADDLE_WIDTH / 2,
                getHeight() - PADDLE_Y_OFFSET,
                PADDLE_WIDTH,
                PADDLE_HEIGHT
        );
        paddle.setFilled(true);
        paddle.setFillColor(Color.green);
        add(paddle);
    }

    /**
     * Method move paddle regards your mouse on canvas
     * @param mouseEvent the event to be processed
     */
    public void mouseMoved(MouseEvent mouseEvent) {
        //I added these variables to control paddle.
        double paddleX;
        double paddleY = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
        //Cases when paddle could move over canvas
        if ((mouseEvent.getX() - PADDLE_WIDTH / 2.0) < 0) {
            paddleX = 0;
        } else if ((getWidth() - mouseEvent.getX()) < PADDLE_WIDTH / 2.0) {
            paddleX = getWidth() - PADDLE_WIDTH;
        } else {
            paddleX = mouseEvent.getX() - PADDLE_WIDTH / 2.00;
        }

        paddle.setLocation(paddleX, paddleY);
        add(paddle);
    }
}

