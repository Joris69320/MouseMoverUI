package fr.thivard.mousemoverui;

import fr.thivard.mousemoverui.manager.AppManager;
import org.junit.jupiter.api.Test;

class LauncherTest {

    @Test
    void main() {
        String startLog =   """
                            
                            ---------------------------------------------
                                MouseMoverUI started on version 1.1.3
                            ---------------------------------------------
                            """;
        AppManager.app.info(startLog);
    }
}