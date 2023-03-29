import java.io.File;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class GeraFigurinha {
  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
    BufferedImage Original = ImageIO.read(inputStream);
    int width = Original.getWidth();
    int height = Original.getHeight();
    int newHeight = height + 200;
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(Original, 0, 0, null);
    
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 100, newHeight - 100);

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File(nomeArquivo));
  }
}
