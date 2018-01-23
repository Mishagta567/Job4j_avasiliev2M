package ru.job4j.threads;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountThreadTest {


	@Test
	public void getTextString() throws Exception {
		/**
		*  Что-то я здесь не смог получить вывода никаких данных. Не понятно как.
		*/
				CountThread ct = new CountThread();
			Thread tSpace = new Thread(new CountThread.SpaceCount());
			tSpace.start();
	}

	@Test
	public void threadMessage() throws Exception {
	}

}