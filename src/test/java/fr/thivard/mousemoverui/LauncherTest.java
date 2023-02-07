package fr.thivard.mousemoverui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static fr.thivard.mousemoverui.Launcher.*;

class LauncherTest {

    @Test
    void mainTest() {
        assertEquals("""
                            
                            ---------------------------------------------
                                MouseMoverUI started on version 1.1.3
                            ---------------------------------------------
                            """, startLog);

    }
}