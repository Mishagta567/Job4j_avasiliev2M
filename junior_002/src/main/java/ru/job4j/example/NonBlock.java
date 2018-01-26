package ru.job4j.example;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Пример Петра ProducerCustomer
 *
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

public class NonBlock {
	private volatile boolean blockCustomer = true; // volatile - истинно / честно доступна ВСЕМ Thread-ам. Пишется в оперативку.

	public void doSomething() {
		while (this.blockCustomer) {
			System.out.println(String.format("%s enable", Thread.currentThread().getId()));
		}
	}

	public void changeBlock(boolean enable) {
		System.out.println(String.format("%s enable", Thread.currentThread().getId()));
		this.blockCustomer = enable;
	}

	public static void main(String[] arg) {
		new Thread() {
			@Override
			public void run() {
				/**
				 * 1. read
				 * 2. increment		// Но volatile НЕ ГАРАНТИРУЕТ синхронизацию более одной операции
				 * 3. Write
				 */
				//count++;
			}
		}.start();
		// Листы для многопоточных программ. Работают конечно же медленнее.
		List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
		//ConcurrentHashMap.
	}
}