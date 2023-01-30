package fr.thivard.mousemoverui;

import org.apache.log4j.PropertyConfigurator;

public class Launcher {
    public static void main(String[] args){
        PropertyConfigurator.configure(Launcher.class.getResourceAsStream("log4j.properties"));
        MouseMoverApplication.main(args);
    }
}
