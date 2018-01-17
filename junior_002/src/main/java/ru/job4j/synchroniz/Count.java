package ru.job4j.synchroniz;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Пример из видео Петра А.   // Академик           Скулачев   - зрение
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

@ThreadSafe
public class Count {
	@GuardedBy("this")
	private int value;

	public synchronized void increment() {
		this.value++;
	}

	public synchronized int get() {
		return this.value;
	}

}