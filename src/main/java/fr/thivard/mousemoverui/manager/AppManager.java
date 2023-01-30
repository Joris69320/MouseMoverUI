package fr.thivard.mousemoverui.manager;

@SuppressWarnings("ALL")
public class AppManager {

    private AppManager() { }

    public static boolean runningStatus = false;

    public static Thread thread = new Thread();
}
