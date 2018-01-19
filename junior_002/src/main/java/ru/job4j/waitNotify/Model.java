package ru.job4j.waitNotify;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * 1. Неблокирующий кеш [#4741].  Model
 *  в кеше должны быть методы  add, update delete
 *
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class Model {
	private int version;
	// для упрощения считаем что нам нужно сохранять лишь имена. При желании можно добавить чего угодно.
	private String name;

	public Model(String name) {
		this.name = name;
		this.version = 0;
	}
	public void update(String newName) {
		// мы НЕ меняем версию во время обновления данных. Это отдельная процедура. Которая выполняется перед самым изменением.
		this.name = newName;
	}
	public void updateVersion() {
		this.version++;
	}
	public int getVersion() {
		return this.version;
	}
	public String getName() {
		return name;
	}
}