package fr.thivard.mousemoverui;

import java.awt.*;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;
import fr.thivard.mousemoverui.manager.AppManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

@SuppressWarnings("BusyWait")
public class MouseMoverController implements Initializable {

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
    @FXML
    private TextField txtTime;
    private Long time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        time = 60L;
        AppManager.app.setTime(time);

        txtTime.textProperty().addListener((observableValue, s, t1) -> {
            if(!txtTime.getText().isEmpty()){
                try{
                    if(txtTime.getText().length() <= 4){
                        if(Long.parseLong(observableValue.getValue()) >= 20 && Long.parseLong(observableValue.getValue()) <= 1800){
                            time = Long.parseLong(observableValue.getValue());
                        } else {
                            time = 60L;
                        }
                    }
                }
                catch (Exception e){
                    AppManager.app.error(e.getMessage());
                }
                refreshTimer(time);
            }
        });
    }

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
                        AppManager.app.setTime(time);
                        while (AppManager.app.getTime() > 0){
                            AppManager.app.next();
                            refreshTimer(AppManager.app.getTime());
                            Thread.sleep(1000);
                        }
                        refreshTimer(AppManager.app.getTime());
                    } catch (InterruptedException e) {
                        AppManager.app.info(e.getMessage());
                        AppManager.app.getThread().interrupt();
                    }
                }
            }));
            AppManager.app.start();
            txtTime.setDisable(true);
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
            AppManager.app.setTime(time);
            changeStatus();
            refreshCount();
            refreshTimer(AppManager.app.getTime());
            txtTime.setDisable(false);
        }
    }

    /**
     * Change the circle color
     */
    private void changeStatus(){
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
    private void refreshCount(){
        if(AppManager.app.isRunning()){
            this.txtCount.setText(String.valueOf(Integer.parseInt(this.txtCount.getText())+1));
        }
        else {
            this.txtCount.setText("0");
        }
    }

    /**
     * Display the time remaining
     * @param time
     */
    private void refreshTimer(Long time){
        this.txtTimer.setText(String.valueOf(time));
    }
}