import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet {

    public static BufferedImage spritesheet;
    public static BufferedImage player_front;

    public static BufferedImage tileWall;

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("/res/spritesheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        player_front = Spritesheet.getSpritesheet(0, 11, 16, 16);
        tileWall = Spritesheet.getSpritesheet(280, 221, 16, 16);
    }

    public static BufferedImage getSpritesheet(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }

}
