package structures;

import java.util.Arrays;

public class DynamicArray<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public DynamicArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    public void set(E element, int index) {
        rangeCheck(index);
        elements[index] = element;
    }

    public E get(int index) {
        rangeCheck(index);
        return getElement(index);
    }

    public void remove() {
        if (size > 0) {
            elements[--size] = null;
        }
    }

    @SuppressWarnings("unchecked")
    private E getElement(int index) {
        return (E) elements[index];
    }

    private void ensureCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}