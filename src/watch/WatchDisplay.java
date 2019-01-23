package watch;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class WatchDisplay extends JPanel implements Observer {

    private Watch watch;
    private int x,y;
    private BufferedImage back;

    public WatchDisplay(Watch watch){
        this.watch = watch;
        this.watch.addObserver(this);
        try {
            back = ImageIO.read(new FileInputStream("clock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.drawImage(back,0,0,this.getWidth(), this.getHeight(), this);
        g.setColor(Color.black);

        x=getWidth()/2;
        y=getHeight()/2;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x,y,x+dxs(),y-dys());
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(x,y,x+dxm(),y-dym());
        g2.setStroke(new BasicStroke(6));
        g2.drawLine(x,y,x+dxh(),y-dyh());
    }

    private int dxs(){
        return (int) (150*Math.sin(watch.getSecs()));
    }

    private int dys(){
        return (int) (150*Math.cos(watch.getSecs()));
    }

    private int dxm(){
        return (int) (120*Math.sin(watch.getMins()));
    }

    private int dym(){
        return (int) (120*Math.cos(watch.getMins()));
    }

    private int dxh(){
        return (int) (80*Math.sin(watch.getHour()));
    }

    private int dyh(){
        return (int) (80*Math.cos(watch.getHour()));
    }


}
