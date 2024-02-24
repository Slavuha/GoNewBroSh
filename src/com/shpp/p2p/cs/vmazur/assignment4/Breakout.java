package com.shpp.p2p.cs.vmazur.assignment4;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;


public class Breakout extends WindowProgram {
    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** It's a bad idea to calculate brick width from APPLICATION_WIDTH */
    // private static final int BRICK_WIDTH =
    //        (APPLICATION_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static final int NTURNS = 3;

    private static final int PAUSE = 1000/48;
    int countOfTurns = NTURNS;
     //   Speed of the ball

    private double vx = 1;
    private double vy = 3;

    public void run() {
        setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
        createPaddle();
        addMouseListeners();
        createBall();
        random();
        while (countOfTurns>0){
            moveBall();
        }

    }
    private void random(){
        RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5))
            vx = -vx;
    }

    private void moveBall() {
        checkCoordinate();
        gOval.move(vx, vy);
        pause(PAUSE);
    }

    private void checkCoordinate() {
        if  (gOval.getY()>(getHeight()-BALL_RADIUS) ||gOval.getY()<0){
            vy = - vy;
        }
        else if (gOval.getX()<0|| gOval.getX()>(getWidth()-BALL_RADIUS)) {
            vx = -vx;
        }}

    GOval gOval;
    private void createBall() {
        gOval = new GOval(
                getWidth()/2 - BALL_RADIUS/2,
                getHeight()/2 - BALL_RADIUS/2,
                BALL_RADIUS, BALL_RADIUS);
        gOval.setFilled(true);
        gOval.setFillColor(Color.PINK);
        add(gOval);
    }


    GRect gRect;

    /**
     * Method creates paddle in place regards to task requirements.
     */
    private void createPaddle() {
         gRect = new GRect(
                getWidth()/2 - PADDLE_WIDTH/2,
                getHeight()-PADDLE_Y_OFFSET,
                PADDLE_WIDTH,
                PADDLE_HEIGHT
        );
        gRect.setFilled(true);
        gRect.setFillColor(Color.green);
        add(gRect);
    }

    /**
     * Method move paddle regards your mouse on canvas
     * @param mouseEvent the event to be processed
     */
    public void mouseMoved(MouseEvent mouseEvent) {
        //I added these variable to control paddle.
        double paddleX;
        double paddleY = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
        //Cases when paddle could move over canvas
        if ( (mouseEvent.getX()-PADDLE_WIDTH/2.0) < 0 ) {
            paddleX = 0;}
        else if ((getWidth() - mouseEvent.getX()) < PADDLE_WIDTH/2.0 ) {
            paddleX = getWidth() - PADDLE_WIDTH;
        }
        else {paddleX = mouseEvent.getX()-PADDLE_WIDTH/2.00;}

        gRect.setLocation(paddleX,paddleY);
        add(gRect);
    }
}

