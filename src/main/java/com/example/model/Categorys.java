package com.example.model;

import javax.persistence.*;




@Entity
@Table(name = "categorys")
public class Categorys {

  


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long cid;

    @Column(name = "category_room")
    private String categoryName;

    public Categorys() {

    }

    public Categorys(String name) {
        this.categoryName = name;
    }

    public Categorys(long cid, String categoryName) {
        this.cid = cid;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return String.format("Category [cid = '%d', name = '%s']", cid, categoryName);
    }

    public long getId() {
        return cid;
    }

    public void setId(long cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }
}
