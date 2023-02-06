package fr.thivard.mousemoverui;

import fr.thivard.mousemoverui.manager.AppManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.Property;

import java.security.Provider;

public class Launcher {
    public static void main(String[] args){
        Configurator.initialize("Config", String.valueOf(Launcher.class.getResource("log4j.properties")));
        AppManager.app.info("\n---------------------------------------------\n\t" +
                            "MouseMoverUI started on version 1.1.3\n" +
                            "---------------------------------------------");
        MouseMoverApplication.main(args);
    }
}
