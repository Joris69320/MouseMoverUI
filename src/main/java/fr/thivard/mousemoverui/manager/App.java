package fr.thivard.mousemoverui.manager;

public class App {

    private boolean runningStatus;
    private Thread thread;

    public App(){
        this.runningStatus = false;
        this.thread = new Thread();
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

    public String getThreadName(){
        return this.thread.getName();
    }
}
