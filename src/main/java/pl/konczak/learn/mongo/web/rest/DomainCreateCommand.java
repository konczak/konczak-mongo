package pl.konczak.learn.mongo.web.rest;

public class DomainCreateCommand {

    private String domain;

    private boolean displayAds;

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
