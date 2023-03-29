import java.net.URL;
import java.util.List;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws Exception {
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        
        var http = new clientHttp();
        String result = http.SearchData(url);

        var geradora = new GeraFigurinha();

        extractNasaAPI extract = new extractNasaAPI();
        List<content> conteudos = extract.getContent(result);

        for (int i = 0; i < 3; i++) {
            content conteudo = conteudos.get(i);

            InputStream input = new URL(conteudo.getImage()).openStream();
            String archieveName = "saida/" + conteudo.getTitle() + ".png";

            geradora.cria(input, archieveName);
            System.out.println(conteudo.getTitle());
            System.out.println();
        }
    }
}