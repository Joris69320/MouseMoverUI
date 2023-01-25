package fr.thivard.mousemoverui.core;

import javafx.scene.robot.Robot;

import java.util.Random;

public class Program {

    private int DURATION;

    private int MAX_Y;

    private int MAX_X;

    private Robot robot;

    private Random random;

    public Program(int DURATION){
        this.DURATION = DURATION;
        this.MAX_Y = 720;
        this.MAX_X = 1280;
        this.robot = new Robot();
        this.random = new Random();
    }
}
