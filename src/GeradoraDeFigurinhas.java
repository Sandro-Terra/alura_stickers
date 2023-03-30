import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

// Classe que tem por objetivo criar stickers para WhatsApp com as imagens da lista de filmes do IMBb
public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
        
        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("img/TopMovies_1.jpg"));
        
        BufferedImage imgOrig = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imgOrig.getWidth();
        int altura = imgOrig.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar a imagem original para imagem nova na memória
        Graphics2D graphics = (Graphics2D) novaImg.getGraphics();
        graphics.drawImage(imgOrig, 0, 0, null);

        // formatar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        // new Font(Font.SANS_SERIF, Font.BOLD, 200);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        String texto;
        graphics.drawString("TOPZERA", 100, novaAltura - 100);
        
       
        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImg, "png", new File(nomeArquivo));
    }
   

}
