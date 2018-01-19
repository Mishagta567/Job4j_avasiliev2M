package ru.job4j.junior001.generic;



/**
 * Реализовать Store
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}