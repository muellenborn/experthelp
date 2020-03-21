package org.wirvscvirus.expertexchange.service.model;

import javax.persistence.*;
import java.util.List;

/**
 * Category class either for know how categories and also for ressource categories.
 */

@Entity
@Table(name = "knowhow_categories")
public class KnowhowCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int knowhow_cat_id;
    private String knowhow;
    private String knowhow_sub;
    private String knowhow_example;

    public int getKnowhow_cat_id() {
        return knowhow_cat_id;
    }

    public void setKnowhow_cat_id(int knowhow_cat_id) {
        this.knowhow_cat_id = knowhow_cat_id;
    }

    public String getKnowhow() {
        return knowhow;
    }

    public void setKnowhow(String knowhow) {
        this.knowhow = knowhow;
    }

    public String getKnowhow_sub() {
        return knowhow_sub;
    }

    public void setKnowhow_sub(String knowhow_sub) {
        this.knowhow_sub = knowhow_sub;
    }

    public String getKnowhow_example() {
        return knowhow_example;
    }

    public void setKnowhow_example(String knowhow_example) {
        this.knowhow_example = knowhow_example;
    }
}
