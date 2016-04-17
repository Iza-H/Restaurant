package io.projectandroid.restaurant.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by izabela on 13/04/16.
 */
public class Table implements Serializable{
    private Integer mNumber;
    private float mTotalPrice = 0;
    private boolean mIsFree=true;
    List<OrderedMeal> mMeal;

    public Table(Integer number) {
        mNumber = number;
    }

    public float getTotalPrice() {
        return mTotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        mTotalPrice = totalPrice;
    }

    public boolean isFree() {
        return mIsFree;
    }

    public void setFree(boolean free) {
        mIsFree = free;
    }

    public Integer getNumber() {
        return mNumber;
    }

    public void setNumber(Integer number) {
        mNumber = number;
    }

    public List<OrderedMeal> getMeal() {
        return mMeal;
    }

    public void setMeal(List<OrderedMeal> meal) {
        mMeal = meal;
    }

    @Override
    public String toString() {
        return String.format("Table nr %d", getNumber());
    }

    public void clear(){
        mTotalPrice=0;
        mIsFree=true;
        mMeal=null;
    }
}
