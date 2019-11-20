package com.data.structure.array;

/**
 * @author zhangjin
 * @since 2019-11-18 20:48
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * // 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * // 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * // 获取数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * // 返回数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * // 在index索引的位置插入一个新元素e
     *
     * @param index 下标
     * @param e     元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }
//        System.arraycopy(data, index, data, index + 1, size - index);

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * // 向所有元素后添加一个新元素
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * // 在所有元素前添加一个新元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * // 获取index索引位置的元素
     *
     * @param index 下标
     * @return E
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 返回最后一个
     *
     * @return E
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 返回第一个
     *
     * @return E
     */
    public E getFirst() {

        return get(0);
    }

    /**
     * // 修改index索引位置的元素为e
     *
     * @param index 下标
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * // 查找数组中是否有元素e
     *
     * @param e 下标
     * @return 是否包含
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e 元素
     * @return int
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * // 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index 下标
     * @return E
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects != memory leak
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * // 从数组中删除第一个元素, 返回删除的元素
     *
     * @return E
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * // 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return E
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * // 从数组中删除元素e
     *
     * @param e 删除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }

    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * // 将数组空间的容量变成newCapacity大小
     *
     * @param newCapacity 新数组的容量
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public static void main(String[] args) {
//        Array<Integer> array = new Array();


        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

//        array.addFirst(1);
//        array.addFirst(2);
//        array.removeFirst();
//        array.set(1, 2);
//        array.set(1, 3);
//        array.set(2, 3);
//        array.contains(1);
//        array.removeFirst();
//        array.removeFirst();
//        array.getFirst();
//        array.getLast();
//        boolean contains = array.contains(2);
//        System.out.println(contains);
//        array.removeElement(1);

    }
}
