package iti.domain.links;

public class Link {
    private String rel;
    private String url;

    public Link(String rel, String url){

          this.rel = rel;
          this.url = url;
    }
    public String getRel() {
          return rel;
    }
    public void setRel(String rel) {
          this.rel = rel;
    }
    public String getUrl() {
          return url;
    }
    public void setUrl(String url) {
          this.url = url;
    }
}
