package fr.thivard.mousemoverui;

import java.awt.*;
import java.security.SecureRandom;
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

    /**
     * Start button treatment
     */
    @FXML
    private void onStart() throws AWTException {

        if(!AppManager.app.isRunning() && !AppManager.app.threadAlive()){

            AppManager.app.changeStatus(true);
            changeStatus();

            java.awt.Robot robot = new Robot();
            SecureRandom random = new SecureRandom();

            AppManager.app.setThread(new Thread(() -> {

                while (AppManager.app.isRunning()){
                    robot.mouseMove(random.nextInt(400), random.nextInt(400));
                    refreshCount();
                    try {
                        int i = 60;
                        while (i > 0){
                            i--;
                            refreshTimer(i);
                            Thread.sleep(1000);
                        }
                        refreshTimer(60);
                    } catch (InterruptedException e) {
                        System.out.println(AppManager.app.getThreadName()+" STOPPED");
                    }
                }
            }));
            AppManager.app.start();
        }
    }

    /**
     * Stop button treatment
     */
    @FXML
    private void onStop(){

        if (AppManager.app.isRunning()){
            AppManager.app.changeStatus(false);
            AppManager.app.stop();
            changeStatus();
            refreshCount();
            refreshTimer(60);
        }
    }

    /**
     * Change the circle color
     */
    public void changeStatus(){
        if(AppManager.app.isRunning()){
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
        if(AppManager.app.isRunning()){
            this.txtCount.setText(String.valueOf(Integer.parseInt(this.txtCount.getText())+1));
        }
        else {
            this.txtCount.setText("0");
        }
    }

    public void refreshTimer(int time){
        this.txtTimer.setText(String.valueOf(time));
    }
}