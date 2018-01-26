package ru.job4j.wait;

import java.util.concurrent.ConcurrentHashMap;

import static javafx.scene.input.KeyCode.*;

/**
 * 	Ошибка для Неблокированный кеш.
 *
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */



public class OplimisticException extends RuntimeException {
	/**
	 * @param message -- an exception's message
	 */
	public OplimisticException(String message) {
		super(message);
	}
}