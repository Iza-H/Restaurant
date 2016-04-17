package io.projectandroid.restaurant.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by izabela on 13/04/16.
 */
public class Tables implements Serializable{
    private LinkedList<Table> mTables;

    public LinkedList<Table> getTables() {
        return mTables;
    }

    public Tables() {
        mTables = new LinkedList<>();
        mTables.add(new Table(1));
        mTables.add(new Table(2));
        mTables.add(new Table(3));
        mTables.add(new Table(4));
        mTables.add(new Table(5));
    }
}