package ru.job4j.wait;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * 1. Неблокирующий кеш [#4741]
 *  в кеше должны быть методы  add, update delete
 *
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class NonBlockingCash {
	private Integer key;
	private ConcurrentHashMap<Integer, Model> map = new ConcurrentHashMap<Integer, Model>();

	public Model getModel(Integer key) {
		return map.get(key);
	}


	public boolean add(Integer key, Model model) {
		boolean result = false;
		// мы добавляем новую пару, только если отличен Key
		if (!this.map.containsKey(key)) {
			map.put(key, model);
			result = true;
		} // else {
		//	 throw new OplimisticException(String.format("Уже есть Модель с ID %s.", key));
		 //}
		return result;
	}

	public boolean delete(Integer key) {
		boolean result = false;
		// мы добавляем новую пару, только если отличен Key
		if (this.map.containsKey(key)) {
			map.remove(key);
			result = true;
		} //else {
		//	throw new OplimisticException(String.format("Нет у нас модели с ключем %s.", key));
		//}
		return result;
	}

	public void update(Integer mapKey, Model newModel) {
		// Не понятно зачем так мучиться, пытаясь использовать compute, если намного проще было просто сравнить версии.
		this.map.computeIfPresent(mapKey, new BiFunction<Integer, Model, Model>() {

			@Override
			//// В процессе тестов я вычислил что метод откуда-то берет СТАРОЕ значение модели.   Вопрос: ОТКУДА?
			public Model apply(Integer id, Model oldModel) {
				// Мы достаем из карты старое значение Model и убеждаемся что version совпадает с текующей. Могли обновить
				//if (map.containsKey(mapKey)) {
					//oldModel = map.get(mapKey);
					if (oldModel.getVersion() != newModel.getVersion()) {
						throw new OplimisticException(String.format("Весрии в карте и новые - отличны: %s и %s.", oldModel, newModel));
					} else {
						//  Не совсем понятно как это работает, но по логике мне наверное здесь нужно сделать обновление.
						// В первую очередь - изменим версию Модели. И уже более новую версию вставим в карту.
						newModel.updateVersion();
						//map.remove(mapKey);
						//map.put(mapKey, newModel);
						//map.replace(mapKey, oldModel, newModel);
						////   ПО НЕПОНЯТНОЙ ПРИЧИНЕ вместо newModel пишется старая model. Не пойму почему.

					}
				//} else {
				//	// если у нас нет объекта с этим key - выкидываем ошибку.
				//	throw new OplimisticException(String.format("Нет у нас модели с ключем %s.", mapKey));
				//}  //  */
				return newModel;
			}
		});
	}


}
