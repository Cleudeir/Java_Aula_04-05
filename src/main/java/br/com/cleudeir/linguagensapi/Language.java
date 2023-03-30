package br.com.cleudeir.linguagensapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Languages")
public class Language {
    @Id
    private String id;
    private String title;
    private String image;
    private String description;
    private int ranking;
    private String origin;

    public Language(String title, String image, String description, int ranking, String origin) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.ranking = ranking;
        this.origin = origin;
    }

    public Language() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getRanking() {
        return ranking;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Language [id=" + id + ", title=" + title + ", image=" + image + ", description=" + description
                + ", ranking=" + ranking + ", origin=" + origin + "]";
    }

}
