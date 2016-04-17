package io.projectandroid.restaurant.model;

import java.io.Serializable;

/**
 * Created by izabela on 16/04/16.
 */
public class OrderedMeal implements Serializable {
    private Meal mMeal;
    private float mTotalPrice;
    private Integer mQuantity;
    private String mComments;

    public OrderedMeal(Meal meal, float priceTotal, Integer quantity, String comments) {
        mMeal = meal;
        mTotalPrice = priceTotal;
        mQuantity = quantity;
        mComments = comments;
    }

    public OrderedMeal() {
    }

    public String getComments() {
        return mComments;
    }

    public void setComments(String comments) {
        mComments = comments;
    }

    public Meal getMeal() {
        return mMeal;
    }

    public void setMeal(Meal meal) {
        mMeal = meal;
    }

    public float getTotalPrice() {
        return mTotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        mTotalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Integer quantity) {
        mQuantity = quantity;
    }
}
