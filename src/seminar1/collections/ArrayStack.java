package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<Item> implements IStack<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(Item item) {
        if (size == elementData.length)
            grow();
        elementData[size++] = item;
    }

    @Override
    public Item pop() {
        /* TODO: implement it */
        Item lastItem = null;
        if (size > 0) {
            lastItem = elementData[--size];
            elementData[size] = null;
        }
        shrink();
        return lastItem;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        if(size == elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            changeCapacity(newCapacity);
        }
    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        int oldCapacity = elementData.length;
        if(size < oldCapacity >> 2)
            changeCapacity(oldCapacity >> 1);
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            return elementData[--currentPosition];
        }

    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);

    }

}
