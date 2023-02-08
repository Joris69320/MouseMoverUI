package fr.thivard.mousemoverui;

import fr.thivard.mousemoverui.manager.AppManager;
import org.apache.logging.log4j.core.config.Configurator;

public class Launcher {

    public static final String startLog = """
                            
                            ---------------------------------------------
                                MouseMoverUI started on version 1.1.3
                            ---------------------------------------------
                            """;

    public static void main(String[] args){
        Configurator.initialize("Config", String.valueOf(Launcher.class.getResource("log4j.properties")));
        AppManager.app.info(startLog);
        MouseMoverApplication.main(args);
    }
}
