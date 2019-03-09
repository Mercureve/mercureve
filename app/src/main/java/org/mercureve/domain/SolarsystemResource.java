package org.mercureve.domain;

public class SolarsystemResource {

    private String id_str;
    private String href;
    private Long id;
    private String name;

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SolarsystemResource{" +
                "id_str='" + id_str + '\'' +
                ", href='" + href + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
