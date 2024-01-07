import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World {

    public static List<Blocks> blocksList = new ArrayList<>();

    public World() {
        for (int xx = 0; xx < 31; xx++) {
            blocksList.add(new Blocks(xx * 32, 0));
        }
        for (int xx = 0; xx < 31; xx++) {
            blocksList.add(new Blocks(xx * 32, 480 - 32));
        }
        for (int yy = 0; yy < 31; yy++) {
            blocksList.add(new Blocks(0, yy * 32));
        }
        for (int yy = 0; yy < 31; yy++) {
            blocksList.add(new Blocks(982 - 32, yy * 32));
        }
    }

    public static boolean isFree(int x, int y) {
        for (int i = 0; i < blocksList.size(); i++) {
            Blocks blocoAtual = blocksList.get(i);
            if (blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
                return false;
            }
        }
        return true;
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < blocksList.size(); i++) {
            blocksList.get(i).render(graphics);
        }
    }
}
