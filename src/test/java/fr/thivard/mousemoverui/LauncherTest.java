package fr.thivard.mousemoverui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static fr.thivard.mousemoverui.Launcher.*;

class LauncherTest {

    @Test
    void main() {

        //Given
        String expected = """
                            
                            ---------------------------------------------
                                MouseMoverUI started on version 1.1.3
                            ---------------------------------------------
                            """;

        //When
        String actual = STARTLOG;

        //Then
        assertEquals(expected, actual);

    }
}