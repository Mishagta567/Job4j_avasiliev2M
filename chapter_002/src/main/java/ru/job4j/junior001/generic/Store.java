package ru.job4j.junior001.generic;



/**
 * Реализовать Store
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public interface Store<T extends Base> {
    void add(T model);

    boolean update(String id, T model);

    boolean delete(String id);

    T get(String id);
}