package fr.thivard.mousemoverui;

import fr.thivard.mousemoverui.manager.AppManager;
import org.apache.log4j.PropertyConfigurator;

public class Launcher {
    public static void main(String[] args){
        PropertyConfigurator.configure(Launcher.class.getResourceAsStream("log4j.properties"));
        AppManager.app.info("\n---------------------------------------------\n\t" +
                            "MouseMoverUI started on version 1.1.3\n" +
                            "---------------------------------------------");
        MouseMoverApplication.main(args);
    }
}
