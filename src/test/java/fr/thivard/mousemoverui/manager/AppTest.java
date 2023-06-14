package fr.thivard.mousemoverui.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void isRunning() {

        //Given
        App app = new App();

        //When
        boolean actualFalse = app.isRunning();
        app.changeStatus(true);
        boolean actualTrue = app.isRunning();

        //Then
        assertFalse(actualFalse);
        assertTrue(actualTrue);
    }
}