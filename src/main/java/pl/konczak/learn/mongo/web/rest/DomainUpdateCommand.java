package pl.konczak.learn.mongo.web.rest;

import java.util.UUID;

public class DomainUpdateCommand {

    private UUID id;

    private String domain;

    private boolean displayAds;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
