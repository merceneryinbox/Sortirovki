package my.datastruct;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 08.11.16
 * Time: 23:52
 * To change this template use File | Settings | File Templates.
 */
public class DynamicArray<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;

    public DynamicArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E element) {
        if (size == elements.length)
            ensureCapacity();
        elements[size++] = element;
    }

    private void ensureCapacity() {
        elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
    }

    public void remove() {
        if (size > 0)
            elements[--size] = null;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }
    public void set(E element, int index) {
        rangeCheck(index);
        elements[index] = element;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public static void main(String[] args) {
        DynamicArray<String> test = new DynamicArray<String>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        //test.set("44",10);
        //test.set("22",-1);
        System.out.println(test.get(3));
        test.remove();

    }
}
