import java.awt.*;

public class Blocks extends Rectangle {

    public Blocks(int x, int y) {
        super(x, y, 32, 32);
    }

    public void render(Graphics graphics){
        //graphics.drawImage(Spritesheet.tileWall, x, y, 32, 32, null); falta criar a posição da spritsheet dos muros
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(x, y, width, height);
        graphics.setColor(Color.black);
        graphics.drawRect(x, y, width, height);
    }
}
