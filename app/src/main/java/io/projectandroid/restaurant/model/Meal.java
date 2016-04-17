package io.projectandroid.restaurant.model;

import java.io.Serializable;

/**
 * Created by izabela on 16/04/16.
 */
public class Meal implements Serializable{
    private String name;
    private float price;
    private String img;
    private String alergics;

    public Meal(String name, float price, String img, String alergics) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.alergics = alergics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAlergics() {
        return alergics;
    }

    public void setAlergics(String alergics) {
        this.alergics = alergics;
    }
}
