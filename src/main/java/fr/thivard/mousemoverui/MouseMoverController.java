package fr.thivard.mousemoverui;

import fr.thivard.mousemoverui.core.Mover;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private void onStart() throws InterruptedException {
        if(!Mover.run){
            this.status.setFill(Paint.valueOf("#0ff000"));
            Mover.run = true;
            Mover.program();
        }
    }

    @FXML
    private void onStop(){
        if(Mover.run){
            this.status.setFill(Paint.valueOf("#ff0000"));
            Mover.run = false;
        }
    }
}