package fr.thivard.mousemoverui;

import java.awt.*;
import java.util.Random;
import fr.thivard.mousemoverui.manager.AppManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class MouseMoverController {

    @FXML
    private Button btnStart;

    @FXML
    private Button btnStop;

    @FXML
    private Circle status;

    @FXML
    private Text txtCount;

    private Thread thread;

    @FXML
    private void onStart() throws AWTException {

        if(!AppManager.runningStatus){

            AppManager.runningStatus = true;
            changeStatus();

            java.awt.Robot robot = new Robot();
            Random random = new Random();

            this.thread = new Thread(() -> {

                while (AppManager.runningStatus){
                    robot.mouseMove(random.nextInt(720), random.nextInt(1280));
                    refreshCount();
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        System.out.println("THREAD STOPPED");
                    }
                }
            });
            this.thread.start();
        }
    }

    @FXML
    private void onStop(){

        if (AppManager.runningStatus){
            AppManager.runningStatus = false;
            changeStatus();
            refreshCount();
        }
    }

    public void changeStatus(){
        if(AppManager.runningStatus){
            this.status.setFill(Paint.valueOf("#0ff000"));
        }
        else{
            this.status.setFill(Paint.valueOf("#ff0000"));
        }
    }

    public void refreshCount(){
        if(AppManager.runningStatus){
            this.txtCount.setText(String.valueOf(Integer.parseInt(this.txtCount.getText())+1));
        }
        else {
            this.txtCount.setText("0");
        }
    }
}