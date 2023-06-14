package fr.thivard.mousemoverui;

import fr.thivard.mousemoverui.manager.AppManager;
import org.apache.logging.log4j.core.config.Configurator;

public class Launcher {

    public static final String STARTLOG = """
                            
                            ---------------------------------------------
                                MouseMoverUI started on version 1.1.5
                            ---------------------------------------------
                            """;

    public static void main(String[] args){
        Configurator.initialize("Config", String.valueOf(Launcher.class.getResource("log4j.properties")));
        AppManager.app.info(STARTLOG);
        MouseMoverApplication.main(args);
    }
}
