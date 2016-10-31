package hayen.com.practices.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AhmetNM on 10/31/16.
 */

public class HeaderExampleEntity {


    private List<String> tags;
    private List<String> titles;

    public List<String> getTags() {
        tags = new ArrayList<>();
        tags.add("Bomba");
        tags.add("Zara");
        tags.add("Gucci");
        tags.add("Fabrika");
        return tags;
    }


    public List<String> getTitles() {
        titles = new ArrayList<>();
        titles.add("Bahar");
        titles.add("Yaz");
        titles.add("Sonbahar");
        titles.add("Kis baslik");
        titles.add("Hooppala Pasam!");
        return titles;
    }
}
