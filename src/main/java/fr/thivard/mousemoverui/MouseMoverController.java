package fr.thivard.mousemoverui;

import java.awt.*;
import java.util.Random;
import fr.thivard.mousemoverui.manager.AppManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

@SuppressWarnings("BusyWait")
public class MouseMoverController {

    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
    @FXML
    private Circle status;
    @FXML
    private Text txtCount;
    @FXML
    private VBox boxApp;
    @FXML
    private Text txtTimer;

    public MouseMoverController() {}

    /**
     * Start button treatment
     */
    @FXML
    private void onStart() throws AWTException {

        if(!AppManager.runningStatus && !AppManager.thread.isAlive()){

            AppManager.runningStatus = true;
            changeStatus();

            java.awt.Robot robot = new Robot();
            Random random = new Random();

            AppManager.thread = new Thread(() -> {

                while (AppManager.runningStatus){
                    robot.mouseMove(random.nextInt(400), random.nextInt(400));
                    refreshCount();
                    try {
                        int i = 60;
                        while (i > 0){
                            i--;
                            txtTimer.setText(String.valueOf(i));
                            Thread.sleep(1000);
                        }
                        txtTimer.setText("60");
                    } catch (InterruptedException e) {
                        System.out.println(AppManager.thread.getName()+" STOPPED");
                    }
                }
            });
            AppManager.thread.start();
        }
    }

    /**
     * Stop button treatment
     */
    @FXML
    private void onStop(){

        if (AppManager.runningStatus){
            AppManager.runningStatus = false;
            AppManager.thread.interrupt();
            changeStatus();
            refreshCount();
            txtTimer.setText("60");
        }
    }

    /**
     * Change the circle color
     */
    public void changeStatus(){
        if(AppManager.runningStatus){
            this.status.setFill(Paint.valueOf("#0ff000"));
        }
        else{
            this.status.setFill(Paint.valueOf("#ff0000"));
        }
    }

    /**
     * Stay the count up to date
     */
    public void refreshCount(){
        if(AppManager.runningStatus){
            this.txtCount.setText(String.valueOf(Integer.parseInt(this.txtCount.getText())+1));
        }
        else {
            this.txtCount.setText("0");
        }
    }
}