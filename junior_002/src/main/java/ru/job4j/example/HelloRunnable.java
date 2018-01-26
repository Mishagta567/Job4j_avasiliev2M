package ru.job4j.example;


import java.util.*;

/**
 * Oracle Example
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

public class HelloRunnable  implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from a thread!");
	}

	public static void main(String[] args) {
		new Thread(new HelloRunnable()).start();
	}

}