import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static int WIDTH = 1080, HEIGHT = 680;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void tick() {
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        g.fillRect(0,0, 50,50);
        bs.show();
    }

    public static void main(String[] args) {
        var game = new Game();
        var jframe = new JFrame();

        jframe.add(game);
        jframe.setTitle("Mini Zelda");
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        new Thread(game).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                tick();
                render();
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}