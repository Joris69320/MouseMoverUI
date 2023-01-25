module fr.thivard.mousemoverui {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.thivard.mousemoverui to javafx.fxml;
    exports fr.thivard.mousemoverui;
}