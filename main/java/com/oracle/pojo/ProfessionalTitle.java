package com.oracle.pojo;

public class ProfessionalTitle {
    private Integer id;
    private String title_name;
    private String description;

    @Override
    public String toString() {
        return "ProfessionalTitle{" +
                "id=" + id +
                ", title_name='" + title_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProfessionalTitle() {
    }

    public ProfessionalTitle(Integer id, String title_name, String description) {
        this.id = id;
        this.title_name = title_name;
        this.description = description;
    }
}
