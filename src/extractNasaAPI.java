import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extractNasaAPI implements extractAPI {
  public List<content> getContent (String json) {
    JsonParser parser = new JsonParser();
    List<Map<String, String>> AttributeList = parser.parse(json);

    List<content> conteudo = new ArrayList<>();

    for (Map<String, String> attributes : AttributeList) {
      String title = attributes.get("title");
      String urlImage = attributes.get("url");
      
      var newContent = new content(title, urlImage);
      conteudo.add(newContent);
    }

    return conteudo;
  } 
}
