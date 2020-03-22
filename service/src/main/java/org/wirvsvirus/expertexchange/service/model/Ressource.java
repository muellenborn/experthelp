package org.wirvsvirus.expertexchange.service.model;

public class Ressource {

    private String id;
    private String category;
    private String name;
    private String unitOfRessource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitOfRessource() {
        return unitOfRessource;
    }

    public void setUnitOfRessource(String unitOfRessource) {
        this.unitOfRessource = unitOfRessource;
    }
}
