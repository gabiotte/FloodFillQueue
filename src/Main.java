import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            File inputFile = new File("input/star.png");
            if (inputFile == null) {
                throw new IOException("Caminho não encontrado.");
            }

            BufferedImage image = ImageIO.read(inputFile);
            if (image == null) {
                throw new IOException("Imagem nula, problema na leitura");
            }
            int startX = 200;
            int startY = 200;

            Color targetColor = new Color(image.getRGB(startX, startY));
            Color replacementColor = Color.yellow;

            FloodFill.floodFill(image, startX, startY, targetColor, replacementColor);

            File outputFile = new File("output/star.png");
            ImageIO.write(image, "png", outputFile);

            System.out.println("Flood Fill aplicado e imagem salva!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
