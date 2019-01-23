package watch;

import javax.swing.*;

public class Display extends JFrame {

    public static void main(String[] args) {
        new Display().execute();
    }

    private void execute() {
        this.setVisible(true);
    }

    private final Watch w;
    private final WatchDisplay display;

    public Display() {
        w = new Watch();
        display = new WatchDisplay(w);

        this.setTitle("Watch");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,420);
        this.setResizable(false);
        this.add(display);
    }
}
