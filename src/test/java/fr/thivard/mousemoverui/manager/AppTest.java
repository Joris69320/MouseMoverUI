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

    @Test
    void threadAliveTrue() {

        //Given
        App app = new App();

        //When
        app.start();

        //Then
        assertTrue(app.threadAlive());

    }

    @Test
    void threadAliveFalse(){

        //Given
        App app = new App();

        //When

        //Then
        assertFalse(app.threadAlive());
    }

    @Test
    void setThread() {

        //Given
        App app = new App();

        //When
        app.setThread(null);

        //Then
        assertNull(app.getThread());
    }
}