package pl.konczak.learn.mongo.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class Domain {

    @Id
    private final UUID id;

    @Indexed(unique = true)
    private String domain;

    private boolean displayAds;

    public Domain(String domain, boolean displayAds) {
        this.id = UUID.randomUUID();
        this.domain = domain;
        this.displayAds = displayAds;
    }

    public UUID getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isDisplayAds() {
        return displayAds;
    }

    public void setDisplayAds(boolean displayAds) {
        this.displayAds = displayAds;
    }

}
