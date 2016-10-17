package hayen.com.practices.Entity;

/**
 * Created by AhmetNM on 10/10/16.
 */
public class Information {
    private String titleText;
    private String subtitleText;

    public Information(String titleText, String subtitleText)
    {
        this.titleText = titleText;
        this.subtitleText = subtitleText;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getSubtitleText() {
        return subtitleText;
    }

    public void setSubtitleText(String subtitleText) {
        this.subtitleText = subtitleText;
    }
}
