package org.wirvscvirus.expertexchange.service.model;

import java.util.List;

public class KnowHowCategory {

    private String id;
    private String name;
    private List<KnowHowSubCategory> subCategories;

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

    public List<KnowHowSubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<KnowHowSubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
