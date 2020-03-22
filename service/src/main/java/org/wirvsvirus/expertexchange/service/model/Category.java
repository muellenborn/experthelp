package org.wirvsvirus.expertexchange.service.model;

import java.util.List;

/**
 * Category class either for know how categories and also for ressource categories.
 */

public class Category {

    private String id;
    private String name;
    private List<SubCategory> subCategories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
