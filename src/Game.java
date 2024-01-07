import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener {

    public static int WIDTH = 1080, HEIGHT = 680;
    public Player player;

    public Game() {
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        player = new Player(0, 0);
    }

    public void tick() {
        player.tick();
    }

    public void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        player.render(graphics);

        bufferStrategy.show();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = false;
        }
    }
}