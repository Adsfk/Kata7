package watch;

import java.util.*;

public class Watch {

    private static final double secs = 2 * Math.PI / 60;
    private static final double mins = secs / 60;
    private static final double hours = mins / 24;

    private final Timer timer;
    private final List<Observer> observers = new ArrayList<>();

    private double seconds=2*Math.PI,
            minutes=2*Math.PI,
            hour=2*Math.PI;

    public Watch() {
        timer = new Timer();
        timer.schedule(timerTask(),0,1000);
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                update();
            }
        };
    }

    private void step() {
        seconds = piModule(seconds + secs);
        minutes = piModule(minutes + mins);
        hour = piModule(hour + hours);
    }

    private void update() {
        observers.forEach(e -> e.update(null,null));
    }

    private double piModule(double d){
        return d % (2*Math.PI);
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public double getSecs() {
        return seconds;
    }

    public double getMins() {
        return minutes;
    }

    public double getHour() {
        return hour;
    }
}
