package fr.thivard.mousemoverui.core;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.robot.Robot;

import java.util.Random;

public class Mover {

    public static final int DURATION = 60000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    public static boolean run = false;

    public static void program(){

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                Robot robot = new Robot();
                Random random = new Random();

                while (true){
                    robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
                    Thread.sleep(DURATION);
                }
            }
        };

        new Thread(task).start();
    }
}
