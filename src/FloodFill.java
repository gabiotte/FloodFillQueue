import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFill {

    public static void floodFill(BufferedImage image, int startX, int startY, Color targetColor, Color replacementColor) {
        if (targetColor.equals(replacementColor)) {
            return;
        }

        int width = image.getWidth();
        int height = image.getHeight();
        StaticQueue queue = new StaticQueue(width * height);

        queue.add(new Coordenada(startX, startY));

        while (!queue.isEmpty()) {
            Coordenada coord = queue.remove();
            int x = coord.getX();
            int y = coord.getY();

            if (x < 0 || x >= width || y < 0 || y >= height) {
                continue;
            }

            Color currentColor = new Color(image.getRGB(x, y));

            if (!currentColor.equals(targetColor)) {
                continue;
            }

            image.setRGB(x, y, replacementColor.getRGB());

            queue.add(new Coordenada(x + 1, y));
            queue.add(new Coordenada(x - 1, y));
            queue.add(new Coordenada(x, y + 1));
            queue.add(new Coordenada(x, y - 1));
        }
    }
}
