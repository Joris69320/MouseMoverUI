module fr.thivard.mousemoverui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires log4j;

    opens fr.thivard.mousemoverui to javafx.fxml;
    exports fr.thivard.mousemoverui;
}