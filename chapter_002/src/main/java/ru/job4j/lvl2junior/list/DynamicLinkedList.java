package ru.job4j.lvl2junior.list;


import java.util.*;

/**
 * Динамический массив (+ итератор, который ходит в обе стороны)
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class DynamicLinkedList<T> implements Iterable<T> {
   private DynamicList<Integer> emptyCells = new DynamicList<Integer>();
   private Object[][] objects;     // Object[][0] - T реальные данные, Object[][1] - предыдущий, Object[][2] - текущий индекс, Object[][3] - следующий
   private int index = 0;
   private int realCurrentSize = 0;
   private int modCount = 0;
   private int itrStartCellInd = -1;
   private int itrEndSellIndx = -1;  // может быть совсем НЕ последняя ячейка массива. Пока делаем ошибку

    public int getItrStartCellInd() {
        return itrStartCellInd;
    }

    public int getItrEndSellIndx() {
        return itrEndSellIndx;
    }

    public int getRealCurrentSize() {
        return realCurrentSize;
    }

    public DynamicLinkedList() {
       this.objects = new Object[2][4];      // лучше конечно делать 100, но для тестов сделаем пока так
   }

   public void add(T value) {              // по аналогии можно создать уменьшение размера "листа".
       if (this.index >= objects.length - 1) {
           this.sizeIncrease();
           //System.out.println("Size increase work");
       }
       int lastEmtyCell = emptyCells.getIndex();
       if (lastEmtyCell == 0) {     // добавляем сверху, только если у нас нет пустых ячеек.
           this.objects[this.index][0] = value;
           this.objects[this.index][1] = itrEndSellIndx;
           this.objects[this.index][2] = this.index;
           this.objects[this.index][3] = -1;
           // нужно обратиться к предыдущей строке и записать туда индекс этой ячейки
           if (this.itrEndSellIndx != -1) {
               this.objects[this.itrEndSellIndx][3] = this.index;
           }
           if (itrStartCellInd == -1) {
               itrStartCellInd = this.index;
           }
           this.itrEndSellIndx = this.index;
           this.index++;
       } else {                                // в этом случае заполням удаленные
           this.objects[lastEmtyCell][0] = value;
           this.objects[lastEmtyCell][1] = itrEndSellIndx;
           if (this.itrEndSellIndx != -1) {
               this.objects[this.itrEndSellIndx][3] = lastEmtyCell;
           }
           this.itrEndSellIndx = lastEmtyCell;
           // и удаляем этот индекс из списка пустых ячеек:
           emptyCells.delete(emptyCells.getIndex());
           //this.index++;  Индекс в данном случае НЕ увеличиваем !!!
       }

       this.modCount++;
       this.realCurrentSize++;
   }

   public void add(T value, int imaginaryPosition) {  // теперь новую ячейку вставляем Якобы "между"
       if (objects.length - 1 <= this.index) {
           this.sizeIncrease();
       }
       int lastEmtyCell = emptyCells.getIndex();

       int stepsCount = 0;
       ArrayIterator it = new ArrayIterator();
       while (it.hasNext()) {
           stepsCount++;
           it.next();
           if (stepsCount == imaginaryPosition) {


               if (lastEmtyCell == 0) {     // добавляем сверху, только если у нас нет пустых ячеек.
                   this.objects[this.index][0] = value;
                   this.objects[this.index][1] = it.currCellPrevValue;
                   this.objects[this.index][2] = this.index;
                   this.objects[this.index][3] = it.currCellNextValue;
                   // нужно обратиться к предыдущей строке и записать туда индекс этой ячейки
                   if (it.currCellPrevValue != -1) {
                       this.objects[it.currCellPrevValue][3] = this.index;
                   }
                   if (it.currCellNextValue != -1) {
                       this.objects[it.currCellNextValue][1] = this.index;
                   }
                   this.itrEndSellIndx = this.index;
                   this.index++;
               } else {                                // в этом случае заполням удаленные
                   this.objects[lastEmtyCell][0] = value;
                   this.objects[lastEmtyCell][1] = it.currCellPrevValue;
                   //this.objects[this.index][2] = this.index;  эта строчка приведет к ошибке
                   this.objects[this.index][3] = it.currCellNextValue;

                   if (it.currCellPrevValue != -1) {
                       this.objects[it.currCellPrevValue][3] = lastEmtyCell;
                   }
                   if (it.currCellNextValue != -1) {
                       this.objects[it.currCellNextValue][1] = lastEmtyCell;
                   }

                   //this.itrEndSellIndx = lastEmtyCell;  Приведь к ошибке
                   // и удаляем этот индекс из списка пустых ячеек:
                   emptyCells.delete(emptyCells.getIndex());
                   //this.index++;  Индекс в данном случае НЕ увеличиваем !!!
               }

               this.modCount++;
               this.realCurrentSize++;
               break;
           }
       }
   }

   public void update(T value, int realIndex) {
       if (realIndex >= 0) {
           // пользуемся методом next до получения ячейки с этим номером по счету
           this.objects[realIndex][0] = value;  /** imaginaryPosition - конечно же пока НЕ ПРАВИЛЬНО */
           this.modCount++;
       }
   }

   public int getForwardRealIndex(int position) { // Backward: считаем с хвоста, 0: реальный index, forward: считаем с головы
        int realIndx = -1;
        if (position <= this.realCurrentSize && position >= 0) {
            // здесь нужно пользоваться методом next до получения ячейки с этим номером по счету
            int stepsCount = 0;
            ArrayIterator it = new ArrayIterator();
            while (it.hasNext()) {
                stepsCount++;
                it.next();
                if (stepsCount == position) {      // Ждем пока imaginaryPosition совпадет с кол-вом циклов
                    // Нашли нужную ячейку. Теперь нужно получить ее index.
                    realIndx = it.getCurrCellIndexValue();
                    break;
                }
            }
        }
        return realIndx;
    }

   public int getBackwardRealIndex(int indexOrPosition) { // Backward: считаем с хвоста, 0: реальный index, forward: считаем с головы
       int realIndx = -1;
       if (indexOrPosition <= this.realCurrentSize && indexOrPosition >= 0) {
           // Ищем с хвоста
           int stepsCount = 0;
           ArrayIterator it = new ArrayIterator();
           while (it.hasNextBack()) {
               stepsCount++;
               it.nextBack();
               if (stepsCount == indexOrPosition) {      // Ждем пока imaginaryPosition совпадет с кол-вом циклов
                   // Нашли нужную ячейку. Теперь нужно получить ее index.
                   realIndx = it.getCurrCellIndexValue();
                   break;
               }
           }
       }
       return realIndx;
   }

   public void delete(int realIndex) {
       if (realIndex != -1) {
           this.objects[realIndex][0] = null;  /** Интересно - можно ли так писать? */
           int curCellPrevValue = (int) this.objects[realIndex][1];
           int curCellNextValue = (int) this.objects[realIndex][3];
           // добавим удаленную ячейку в список_свободных_ячеек:
           emptyCells.add(realIndex);

           // изменим значения в яейках ДО
           if (curCellPrevValue != -1) {
               this.objects[curCellPrevValue][3] = curCellNextValue;
           } else {
               if (curCellNextValue != -1) {
                   this.objects[curCellNextValue][1] = -1;
                   this.itrStartCellInd = curCellNextValue;
               } else {
                   this.itrStartCellInd = -1;
               }
           }
           // изменим значения в яейках ПОСЛЕ
           if (curCellNextValue != -1) {
               this.objects[curCellNextValue][1] = curCellPrevValue;
           } else {
               if (curCellPrevValue != -1) {
                   this.objects[curCellPrevValue][3] = -1;
                   this.itrEndSellIndx = curCellPrevValue;
               } else {
                   this.itrEndSellIndx = -1;
               }
           }
           this.modCount++;
           this.realCurrentSize--;
       }
   }

   public T get(int realIndex) {
       // здесь нужно пользоваться методом next до получения ячейки с этим номером по счету
       return (T) this.objects[realIndex][0];
   }

   private void sizeIncrease() {
       Object[][] tempObject = new Object[objects.length * 2][4];
       for (int indx = 0; indx <= this.index; indx++) {
           tempObject[indx][0] = objects[indx][0];
           tempObject[indx][1] = objects[indx][1];
           tempObject[indx][2] = objects[indx][2];
           tempObject[indx][3] = objects[indx][3];
       }
       objects = tempObject;
   }

    public void setNextValueForNodeTestOnly(int realIndex, int value) {
        this.objects[realIndex][3] = value;
    }

    public boolean nodeForward() {        // проверяем на цикличность. С таким же успехом можно сделать проверку на обратную цикличность.
        int stepsCount = 0;
        int nextCell = (int) this.objects[this.itrStartCellInd][3];
        boolean result = false;

        while (nextCell != -1) {
            stepsCount++;
            nextCell = (int) this.objects[nextCell][3];
            if (stepsCount > this.realCurrentSize) {
                result = true;
                break;
            }
        }
        return result;
    }

   @Override
   public Iterator<T> iterator() {
       return new ArrayIterator();
   }

   public class ArrayIterator implements Iterator<T> {
       Object result = new Object();
       int current = 0;  // the current element we are looking at
       int currentBack = DynamicLinkedList.this.realCurrentSize;
       int expectedModCount = DynamicLinkedList.this.modCount;
       int currCellPrevValue = DynamicLinkedList.this.itrEndSellIndx;
       int currCellIndexValue = -1;
       int currCellNextValue = DynamicLinkedList.this.itrStartCellInd;

       public int getCurrCellIndexValue() {
           return currCellIndexValue;
       }

       // return whether or not there are more elements in the array that
       // have not been iterated over.
       @Override
       public boolean hasNext() {
           boolean result = false;
           if (this.current < DynamicLinkedList.this.realCurrentSize) {
               result = true;
           }
           return result;
       }
       public boolean hasNextBack() {
           boolean result = false;
           if (this.currentBack >= 0) {
              result = true;
           }
           return result;
       }

       // return the next element of the iteration and move the current
       // index to the element after that.
       @Override
       public T next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           if (this.expectedModCount != DynamicLinkedList.this.modCount) {
               throw new ConcurrentModificationException();
           }
           result = (T) DynamicLinkedList.this.objects[this.currCellNextValue][0];
           currCellPrevValue = (int) DynamicLinkedList.this.objects[this.currCellNextValue][1];
           currCellIndexValue = (int) DynamicLinkedList.this.objects[this.currCellNextValue][2];
           currCellNextValue = (int) DynamicLinkedList.this.objects[this.currCellNextValue][3];
           this.current++;
           return (T) result;
       }
       public T nextBack() {
           if (!hasNextBack()) {
               throw new NoSuchElementException();
           }
           if (this.expectedModCount != DynamicLinkedList.this.modCount) {
               throw new ConcurrentModificationException();
           }
           result = (T) DynamicLinkedList.this.objects[this.currCellPrevValue][0];
           currCellIndexValue = (int) DynamicLinkedList.this.objects[this.currCellPrevValue][2];
           currCellNextValue = (int) DynamicLinkedList.this.objects[this.currCellPrevValue][3];
           currCellPrevValue = (int) DynamicLinkedList.this.objects[this.currCellPrevValue][1];
           this.currentBack--;
           return (T) result;
       }
   }
}