package fr.thivard.mousemoverui.manager;

import org.apache.logging.log4j.*;

public class App {

    private boolean runningStatus;
    private Thread thread;
    private final Logger logger;
    private Long time;

    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public App(){
        this.runningStatus = false;
        this.thread = new Thread();
        this.logger = LogManager.getLogger(App.class.getName());
        this.time = 60L;
    }

    public boolean isRunning(){
        return this.runningStatus;
    }

    public void changeStatus(boolean runningStatus){
        this.runningStatus = runningStatus;
    }

    public void start(){
        this.thread.start();
    }

    public void stop(){
        this.thread.interrupt();
    }

    public boolean threadAlive(){
        return this.thread.isAlive();
    }

    public void setThread(Thread thread){
        this.thread = thread;
    }

    public void error(String message){this.logger.error(message);}

    public void info(String message){
        this.logger.info(message);
    }

    public Thread getThread(){return this.thread;}

    public Long getTime(){return this.time;}

    public void next(){this.time--;}

    public void setTime(Long time){this.time = time;}
}
