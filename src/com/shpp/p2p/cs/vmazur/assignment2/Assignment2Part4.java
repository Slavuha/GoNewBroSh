package com.shpp.p2p.cs.vmazur.assignment2;

import acm.graphics.G3DRect;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

//Program creates Flag of settlement Visokey
public class Assignment2Part4 extends WindowProgram {
    private static final double GRECTWIGHT = 111;
    private static final double GRECTHIGHT = 333;

    public void run(){
        createFlag();
        createSentense();
    }
//Method creates Flag throw cycles.
    private void createFlag() {
    for (int i = 0; i<3; i++){
        createGrect(i);
    }
    }
//Method creates gRects. We correct all gRects coordinate and colors.
    private void createGrect(int i) {
    double gRectCounter = 0;
    Color col = Color.CYAN;

    if (i == 1){
        gRectCounter = GRECTWIGHT;
        col = Color.GREEN;
    }
        if (i == 2){
            gRectCounter = GRECTWIGHT*2;
            col = Color.ORANGE;
        }
        GRect gRect = new GRect(
                getWidth()/2-(GRECTWIGHT + GRECTWIGHT/2 ) +gRectCounter,
                getHeight()/2-GRECTHIGHT/2,
                GRECTWIGHT,
                GRECTHIGHT
        );
        gRect.setFilled(true);
        gRect.setColor(col);
        add(gRect);
    }

//Method creates sentence.
    private void createSentense() {

        GLabel label = new GLabel("FLAG OF GREEN GAY ");
        label.setColor(Color.GREEN);
        double labelsWidth = label.getWidth();
        label.setLocation(getWidth() -  labelsWidth, getHeight()
                - label.getDescent());
        add(label);
    }
}

