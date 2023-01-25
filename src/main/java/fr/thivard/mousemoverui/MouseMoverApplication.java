package fr.thivard.mousemoverui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MouseMoverApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MouseMoverApplication.class.getResource("mouse-mover-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MouseMover");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}