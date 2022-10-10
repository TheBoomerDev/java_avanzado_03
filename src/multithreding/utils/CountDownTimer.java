package multithreding.utils;

import java.util.logging.Handler;

public class CountDownTimer{



    public interface Listener{
        void tickEvent();
    }

    private class Worker implements Runnable{

        @Override
        public void run() {

            try {
                Thread.sleep(tick);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentTicks--;
            if (currentTicks <= 0){
                return;
            }

            vuelta();
        }
    }

    private Listener listener;
    private final int total;
    private int currentTicks = 0;
    private final int tick;
    private final Worker worker = new Worker();

    public CountDownTimer(int total, int tick){
        this.total = total;
        this.tick = tick;
        this.currentTicks = this.total / this.tick;
    }

    private void vuelta(){
        this.listener.tickEvent();
    }

    public void start(Listener listener) {
        this.listener = listener;
    }
}
