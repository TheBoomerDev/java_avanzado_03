package patrones.observer;

public class WorkThread extends Thread {

    private final WorkListener listener;

    public WorkThread(WorkListener listener){
        this.listener = listener;
    }

    @Override public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.listener.heTerminado();

    }

}
