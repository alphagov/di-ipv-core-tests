package gov.di_ipv_core.POJO;

public class Root{
    private String resourceId;

    @Override
    public String toString() {
        return "Root{" +
                "resourceId='" + resourceId + '\'' +
                ", attributes=" + attributes +
                ", gpg45Score=" + gpg45Score +
                '}';
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Gpg45Score getGpg45Score() {
        return gpg45Score;
    }

    public void setGpg45Score(Gpg45Score gpg45Score) {
        this.gpg45Score = gpg45Score;
    }

    public Root(String resourceId, Attributes attributes, Gpg45Score gpg45Score) {
        this.resourceId = resourceId;
        this.attributes = attributes;
        this.gpg45Score = gpg45Score;
    }

    private Attributes attributes;
    private Gpg45Score gpg45Score;
}