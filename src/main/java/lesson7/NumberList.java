package lesson7;

import java.lang.reflect.Array;
import java.util.*;

public class NumberList<T extends Number> implements List<T> {
    private int size;
    transient private T[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    protected transient int modCount = 0;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public NumberList() {
        this.elementData = (T[]) Array.newInstance(Number.class, DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(T element) {
        modCount++;
        addToStart(element);
        return true;
    }

    private void addToStart(T element) {
        add(0, element);
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;
        T oldValue = (T) es[index];
        clear();
        return oldValue;
    }

    public boolean remove(Object o) {
        clear();
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return containsMoreTwo(o) >= 2;
    }

    public int containsMoreTwo(Object o) {
        int j = 0;
        for (T es : elementData) {
            if (o == null) {
                if (es == null) {
                    j++;
                }
            } else {
                if (o.equals(es)) {
                    j++;
                }
            }
        }
        return (j == 0) ? -1 : j;
    }

    public Double getDouble(int index) {
        rangeCheckForAdd(index);
        T el = elementData[index];
        if (el instanceof Double) {
            return (Double) el;
        }
        throw new NumberFormatException("Значение не Double");
    }

    public int sumIntegers() {
        int sum = 0;
        for (T es : elementData) {
            if (es instanceof Integer) {
                sum = sum + (int) es;
            }
        }
        return sum;
    }

//////////////////////////////////////////////////////

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        modCount++;
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    private void add(T element, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = element;
        size = s + 1;
    }

    @Override
    public void add(int index, T element) {
        rangeCheckForAdd(index);
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                newCapacity(minCapacity));
    }

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(Object[] es, int i) {
//        modCount++;
//        final int newSize;
//        if ((newSize = size - 1) > i)
//            System.arraycopy(es, i + 1, es, i, newSize - i);
//        es[size = newSize] = null;
        clear();
    }

    @Override
    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        return "NumberList{" +
                "size=" + size +
                ", elementData=" + Arrays.toString(elementData) +
                '}';
    }
}
