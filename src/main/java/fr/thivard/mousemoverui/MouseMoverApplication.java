package fr.thivard.mousemoverui;

import fr.thivard.mousemoverui.manager.AppManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MouseMoverApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MouseMoverApplication.class.getResource("mouse-mover-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(String.valueOf(MouseMoverApplication.class.getResource("styles.css")));
        stage.getIcons().add(new Image(Objects.requireNonNull(MouseMoverApplication.class.getResourceAsStream("mousemover.png"))));
        stage.setTitle("MouseMover");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {
            AppManager.runningStatus = false;
            AppManager.thread.interrupt();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}